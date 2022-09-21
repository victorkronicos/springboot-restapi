package com.victor.springvscode.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.victor.springvscode.model.CartaoCredito;

import lombok.Data;

public @Data class CartaoCreditoDTO {
    @JsonProperty("id")
    private Integer idCartaoCredito;

    @JsonProperty("titular")
    private String nomeCartaoCredito;

    @JsonProperty("bandeira")
    private String bandeiraCartaoCredito;

    @JsonProperty("limite")
    private BigDecimal limiteCartaoCredito;

    @JsonProperty("saldo")
    private BigDecimal saldoCartaoCredito;

    public CartaoCreditoDTO(CartaoCredito cartaoCredito) {
        idCartaoCredito = cartaoCredito.getIdCartaoCredito();
        nomeCartaoCredito = cartaoCredito.getNomeCartaoCredito();
        bandeiraCartaoCredito = cartaoCredito.getBandeiraCartaoCredito();
        limiteCartaoCredito = cartaoCredito.getLimiteCartaoCredito();
        saldoCartaoCredito = cartaoCredito.getSaldoCartaoCredito();
    }
}
