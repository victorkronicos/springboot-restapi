package com.victor.springvscode.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
     * @return Retorna a soma de valores de uma fatura, através do ID_CARTAO_CREDITO
     */
    public Fatura getFaturaValue(int id) {

        Optional<ItemFatura> itemsFatura = itemFaturaRepository.findById(id);

        if (!itemsFatura.isPresent()) {
            // Retornar em json "Recurso não encontrado"
            return null;
        }

        // for (ItemFatura itemFatura : itemsFatura) {
        // if (itemFatura.getId_item_fatura().equals(id)) {
        // // faturaValue += faturaValue;
        // }
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
