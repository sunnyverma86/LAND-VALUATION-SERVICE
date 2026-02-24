package com.areap2.repository.duty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.areap2.entity.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
