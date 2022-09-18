package com.victor.springvscode.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class FaturaService {

    @Autowired
    FaturaRepository faturaRepository;

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    public Fatura addFatura(Fatura fatura) {

        // if (checkDataFatura(fatura.getDataVencimento())) {
        // // Retornar um erro no formato JSON
        // return null;
        // }
        return faturaRepository.save(fatura);
    }

    /**
     * @param id
     * @return Retorna a soma de valores de uma fatura, através do ID_CARTAO_CREDITO
     */
    public Fatura getFaturaValue(int id) {

        // List<ItemFatura> itens = itemFaturaRepository.findByFatura_faturaId(id);

        // if (itens.isEmpty()) {
        // return null;
        // }

        return null;
    }

    /**
     * 
     * @param dataVencimentoFatura
     * @return Verifica se a data de vencimento da fatura está vencida
     */
    public Boolean checkDataFatura(LocalDate dataVencimentoFatura) {
        return dataVencimentoFatura.isAfter(LocalDate.now());
    }
}
