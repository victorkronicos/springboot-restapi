package com.victor.springvscode.model;

import java.math.BigDecimal;

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
    private Integer id_cartao_credito;
    private String nome_cartao_credito;
    private String bandeira_cartao_credito;
    private BigDecimal limite_cartao_credito;
    private BigDecimal saldo_cartao_credito;

}
