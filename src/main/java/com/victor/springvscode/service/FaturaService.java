package com.victor.springvscode.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class FaturaService {

    @Autowired
    FaturaRepository faturaRepository;

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    public Fatura addFatura(Fatura fatura) {

        if (checkDataFatura(fatura.getData_vencimento())) {
            // Retornar um erro no formato JSON
            return null;
        }
        return faturaRepository.save(fatura);
    }

    /**
     * @param id
     * @return Retorna a soma de valores de uma fatura, através de seu ID
     */
    public Float getFaturaValue(int id) {

        List<ItemFatura> itemsFatura = itemFaturaRepository.findItemFaturaById(id);
        Float faturaValue = (float) 0;

        for (ItemFatura itemFatura : itemsFatura) {
            if (itemFatura.getId_item_fatura().equals(id)) {
                faturaValue += faturaValue;
            }
        }
        return faturaValue;
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
