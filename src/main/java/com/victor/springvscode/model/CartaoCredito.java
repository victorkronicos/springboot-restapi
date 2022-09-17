package com.victor.springvscode.model;

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
    private Integer idCartaoCredito;

    @Column(name = "nome_cartao_credito", nullable = false, columnDefinition = "varchar(45)")
    private String nomeCartaoCredito;

    @Column(name = "bandeiraCartaoCredito", nullable = false, columnDefinition = "varchar(45)")
    private String bandeira_cartao_credito;

    @Column(name = "limite_cartao_credito", nullable = false, columnDefinition = "decimal(10,2)")
    private Float limiteCartaoCredito;

    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    private Float saldoCartaoCredito = (float) 0;
}
