package com.areap2.landtransaction.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.landtransaction.dto.ExcelUploadResponse;
import com.areap2.landtransaction.dto.LandTransactionRequest;
import com.areap2.landtransaction.dto.LandTransactionResponse;
import com.areap2.landtransaction.dto.PageResponse;
import com.areap2.landtransaction.entity.LandTransaction;

public interface LandTransactionService {

	LandTransactionResponse create(LandTransactionRequest request);

	LandTransactionResponse getById(Long id);

	PageResponse<LandTransactionResponse> search(String district, String circle, String mouza, String village,
			String dagNo, String nicCode, Boolean active, Pageable pageable);

	LandTransactionResponse update(Long id, LandTransactionRequest request);

	void delete(Long id);

	void restore(Long id);

	ExcelUploadResponse uploadExcel(MultipartFile file) throws IOException;

	List<LandTransaction> findData(String district, String circle);

	List<LandTransaction> findData(String district, String circle, String mouza);
}
