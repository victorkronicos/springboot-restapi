package com.victor.springvscode.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.victor.springvscode.repository.FaturaRepository;

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
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
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
    private Float valorItemFatura;

    @ManyToOne
    @JsonProperty("fatura_id")
    @JoinColumn(name = "id_fatura")
    private Fatura fatura;

    @ManyToOne
    @JsonProperty("cartao_credito_id")
    @JoinColumn(name = "cartao_credito_id")
    private CartaoCredito cartaoCredito;

}
