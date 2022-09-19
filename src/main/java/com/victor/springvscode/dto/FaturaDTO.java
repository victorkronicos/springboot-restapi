package com.victor.springvscode.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.victor.springvscode.model.Fatura;

import lombok.Data;

public @Data class FaturaDTO {
    @JsonProperty("id")
    private Integer idFatura;

    @JsonProperty("vencimento")
    private LocalDate dataVencimento;

    public FaturaDTO(Fatura fatura) {
        idFatura = fatura.getIdFatura();
        dataVencimento = fatura.getDataVencimento();
    }

}
