package com.victor.springvscode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.model.Fatura;

import lombok.Data;

public @Data class ItemFaturaDTO {
    @JsonProperty("id")
    private Integer idItemFatura;

    @JsonProperty("descricao")
    private String descricaoItemFatura;

    @JsonProperty("valor")
    private Float valorItemFatura;

    @JsonProperty("fatura")
    private Fatura fatura;

    @JsonProperty("cartao_credito")
    private CartaoCredito cartaoCredito;
}
