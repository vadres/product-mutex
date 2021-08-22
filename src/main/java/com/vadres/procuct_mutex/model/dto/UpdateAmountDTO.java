package com.vadres.procuct_mutex.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class UpdateAmountDTO {
	@NotNull
	private Long id;
    @NotNull
	private Long amount;
}
