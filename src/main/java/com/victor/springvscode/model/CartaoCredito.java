package com.victor.springvscode.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cartao_credito")
public class CartaoCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id_cartao_credito")
    @Column(name = "id_cartao_credito")
    private Integer idCartaoCredito;

    @JsonProperty("nome_cartao_credito")
    @Column(name = "nome_cartao_credito", nullable = false, columnDefinition = "varchar(45)")
    private String nomeCartaoCredito;

    @JsonProperty("bandeira_cartao_credito")
    @Column(name = "bandeira_cartao_credito", nullable = false, columnDefinition = "varchar(45)")
    private String bandeiraCartaoCredito;

    @JsonProperty("limite_cartao_credito")
    @Column(name = "limite_cartao_credito", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal limiteCartaoCredito;

    @JsonProperty("saldo_cartao_credito")
    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal saldoCartaoCredito;

}
