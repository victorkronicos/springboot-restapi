package com.victor.springvscode.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_fatura;

    @Column(nullable = false, columnDefinition = "date")
    private LocalDate data_vencimento;

    @OneToMany
    @JoinColumn(name = "fatura_id")
    private List<ItemFatura> item_fatura;

}
