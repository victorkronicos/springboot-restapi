package com.victor.springvscode.model;

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
@Table
public class ItemFatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItemFatura;

    @Column(name = "descricao_item_fatura", nullable = false, columnDefinition = "varchar(45)")
    private String descricaoItemFatura;

    @Column(name = "valor_item_fatura", nullable = false, columnDefinition = "decimal(10,2)")
    private Float valorItemFatura;

    @ManyToOne
    @JoinColumn(name = "fatura_id")
    private Fatura fatura;

    @ManyToOne
    @JoinColumn(name = "id_cartao_credito")
    private CartaoCredito cartaoCredito;
}
