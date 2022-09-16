package com.victor.springvscode.model;

import java.math.BigDecimal;

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
@Table
public class ItemFatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_item_fatura;
    private String descricao_item_fatura;
    private BigDecimal valor_item_fatura;

    @ManyToOne
    @JoinColumn(name = "fatura_id")
    private Fatura fatura;

}
