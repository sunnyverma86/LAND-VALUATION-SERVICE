package com.areap2.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.areap2.dto.excel.SelectionRequest;
import com.areap2.dto.excel.SelectionResponse;
import com.areap2.entity.Instrument;
import com.areap2.entity.UserSelection;
import com.areap2.repository.duty.InstrumentRepository;
import com.areap2.repository.duty.UserSelectionRepository;

@Service
public class StampDutyService {

	private final InstrumentRepository instrumentRepo;
	private final UserSelectionRepository userSelectionRepo;

	public StampDutyService(InstrumentRepository instrumentRepo, UserSelectionRepository userSelectionRepo) {
		this.instrumentRepo = instrumentRepo;
		this.userSelectionRepo = userSelectionRepo;
	}

	public List<Instrument> listInstruments() {
		return instrumentRepo.findAll();
	}

	@Transactional
	public List<SelectionResponse> saveSelections(List<SelectionRequest> requests) {
		if (requests == null)
			throw new IllegalArgumentException("Request body is empty");
		if (requests.size() > 7)
			throw new IllegalArgumentException("Maximum 7 instruments allowed");

		// validate options and collect ids
		List<Long> ids = requests.stream().map(SelectionRequest::getInstrumentId).collect(Collectors.toList());

		List<Instrument> instruments = instrumentRepo.findAllById(ids);
		Map<Long, Instrument> map = instruments.stream().collect(Collectors.toMap(Instrument::getId, i -> i));

		List<UserSelection> toSave = new ArrayList<>();
		for (SelectionRequest req : requests) {
			Instrument inst = map.get(req.getInstrumentId());
			if (inst == null)
				throw new NoSuchElementException("Instrument id not found: " + req.getInstrumentId());

			String opt = req.getSelectedOption();
			if (!("Male".equalsIgnoreCase(opt) || "Female".equalsIgnoreCase(opt) || "Joint".equalsIgnoreCase(opt))) {
				throw new IllegalArgumentException("selectedOption must be Male, Female or Joint");
			}

			int duty;
			if ("Male".equalsIgnoreCase(opt))
				duty = inst.getMaleDuty() == null ? 0 : inst.getMaleDuty();
			else if ("Female".equalsIgnoreCase(opt))
				duty = inst.getFemaleDuty() == null ? 0 : inst.getFemaleDuty();
			else
				duty = inst.getJointDuty() == null ? 0 : inst.getJointDuty();

			UserSelection sel = new UserSelection();
			sel.setInstrument(inst);
			sel.setSelectedOption(capitalize(opt));
			sel.setDutyValue(duty);
			toSave.add(sel);
		}

		List<UserSelection> saved = userSelectionRepo.saveAll(toSave);

		return saved.stream().map(this::toResponse).collect(Collectors.toList());
	}

	private SelectionResponse toResponse(UserSelection s) {
		SelectionResponse r = new SelectionResponse();
		r.setId(s.getId());
		r.setInstrumentId(s.getInstrument().getId());
		r.setInstrumentName(s.getInstrument().getName());
		r.setSelectedOption(s.getSelectedOption());
		r.setDutyValue(s.getDutyValue());
		r.setCreatedAt(s.getCreatedAt());
		return r;
	}

	private String capitalize(String s) {
		if (s == null || s.isEmpty())
			return s;
		String lower = s.toLowerCase();
		return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
	}
}
