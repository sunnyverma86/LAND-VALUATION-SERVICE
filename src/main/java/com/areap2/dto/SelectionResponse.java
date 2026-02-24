package com.areap2.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionResponse {
	
	
	private Long id;
	private Long instrumentId;
	private String instrumentName;
	private String selectedOption;
	private Integer dutyValue;
	private LocalDateTime createdAt;

	// getters/setters

}
