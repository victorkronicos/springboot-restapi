package com.victor.springvscode.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.model.CartaoCredito;

import jakarta.persistence.Id;
import lombok.Data;

public @Data class ItemFaturaDTO {
    @Id
    @JsonProperty("id")
    private Integer idItemFatura;

    @JsonProperty("descricao")
    private String descricaoItemFatura;

    @JsonProperty("valor")
    private BigDecimal valorItemFatura;

    @JsonProperty("fatura")
    private Integer fatura;

    @JsonProperty("cartao_credito")
    private Integer cartaoCredito;

    public ItemFaturaDTO(ItemFatura itemFatura) {
        idItemFatura = itemFatura.getIdItemFatura();
        descricaoItemFatura = itemFatura.getDescricaoItemFatura();
        valorItemFatura = itemFatura.getValorItemFatura();
        fatura = itemFatura.getFatura().getIdFatura();
        cartaoCredito = itemFatura.getCartaoCredito().getIdCartaoCredito();
    }
}
