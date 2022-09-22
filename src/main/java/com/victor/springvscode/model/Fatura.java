package com.victor.springvscode.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fatura")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id_fatura")
    @Column(name = "id_fatura")
    private Integer idFatura;

    @JsonProperty("data_vencimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_vencimento", nullable = false, columnDefinition = "date")
    private LocalDate dataVencimento;

    @OneToMany
    @JsonProperty("id_item_fatura")
    @JoinColumn(name = "id_fatura")
    private List<ItemFatura> itemFatura;

    @JsonProperty("valor_fatura")
    private BigDecimal valorFatura;

}
