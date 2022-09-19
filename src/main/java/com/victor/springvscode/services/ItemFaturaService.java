package com.victor.springvscode.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.dto.ItemFaturaDTO;
import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.CartaoCreditoRepository;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class ItemFaturaService {

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    FaturaRepository faturaRepository;

    /**
     * @param id
     * @param itemFatura
     * @return Adiciona um Item à uma fatura
     */

    public ItemFaturaDTO addNew(ItemFatura itemFatura) {
        int idFatura = itemFatura.getFatura().getIdFatura();

        if (!checkVencimentoFatura(idFatura)) {
            return null;
        }

        // Float valorItemFatura = (float) itemFatura.getValorItemFatura();

        // cartaoCreditoRepository.findById(1);

        ItemFaturaDTO dto = new ItemFaturaDTO(itemFatura);
        return dto;
    }

    /**
     * 
     * @param itemFatura
     * @return Verifica o vencimento da fatura se é maior que a data atual
     */
    public Boolean checkVencimentoFatura(int idFatura) {
        LocalDate vencimentoFatura = faturaRepository
                .findById(idFatura)
                .get()
                .getDataVencimento();

        return vencimentoFatura.isAfter(LocalDate.now());
    }

}
