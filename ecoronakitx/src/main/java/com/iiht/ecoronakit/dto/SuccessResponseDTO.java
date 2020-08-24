package com.iiht.ecoronakit.dto;


import lombok.Data;

@Data
public class SuccessResponseDTO {

    private String message;

    public SuccessResponseDTO(String message) {
        this.message = message;
    }
}
