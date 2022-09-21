package com.victor.springvscode.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_fatura")
public class ItemFatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id_item_fatura")
    @Column(name = "id_item_fatura")
    private Integer idItemFatura;

    @JsonProperty("descricao_item_fatura")
    @Column(name = "descricao_item_fatura", nullable = false, columnDefinition = "varchar(45)")
    private String descricaoItemFatura;

    @JsonProperty("valor_item_fatura")
    @Column(name = "valor_item_fatura", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal valorItemFatura;

    @ManyToOne
    @JsonProperty("fatura")
    @JoinColumn(name = "id_fatura")
    private Fatura fatura;

    @ManyToOne
    @JsonProperty("cartao_credito")
    @JoinColumn(name = "id_cartao_credito")
    private CartaoCredito cartaoCredito;

}
