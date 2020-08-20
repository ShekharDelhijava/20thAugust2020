package com.iiht.ecoronakit.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SuccessResponseDTO {

    private String message;

    public SuccessResponseDTO(String message) {
        this.message = message;
    }
}
