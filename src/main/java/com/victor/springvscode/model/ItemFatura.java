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
    private Integer id_item_fatura;

    @Column(nullable = false, columnDefinition = "varchar(45)")
    private String descricao_item_fatura;

    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    private Float valor_item_fatura;

    @ManyToOne
    @JoinColumn(name = "fatura_id", columnDefinition = "integer")
    private Fatura fatura_id;

    @ManyToOne
    @JoinColumn(name = "id_cartao_credito", columnDefinition = "integer")
    private CartaoCredito id_cartao_credito;
}
