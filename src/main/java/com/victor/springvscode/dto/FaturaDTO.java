package com.victor.springvscode.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.victor.springvscode.model.Fatura;

import lombok.Data;

public @Data class FaturaDTO {
    @JsonProperty("id")
    private Integer idFatura;

    @JsonProperty("vencimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @JsonProperty("valor")
    private BigDecimal valorFatura;

    public FaturaDTO(Fatura fatura) {
        idFatura = fatura.getIdFatura();
        dataVencimento = fatura.getDataVencimento();
        valorFatura = fatura.getValorFatura();
    }
}
