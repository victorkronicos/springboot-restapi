package com.victor.springvscode.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.victor.springvscode.model.ItemFatura;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    private Integer idCartao;

    public ItemFaturaDTO(ItemFatura itemFatura) {
        idItemFatura = itemFatura.getIdItemFatura();
        descricaoItemFatura = itemFatura.getDescricaoItemFatura();
        valorItemFatura = itemFatura.getValorItemFatura();
        fatura = itemFatura.getFatura().getIdFatura();
        idCartao = itemFatura.getCartaoCredito().getIdCartaoCredito();
    }
}
