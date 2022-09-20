package com.victor.springvscode.services;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.dto.ItemFaturaDTO;
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
        // int idCartao = itemFatura.getCartaoCredito().getIdCartaoCredito();

        if (!checkVencimentoFatura(idFatura)) {
            return null;
        }

        System.out.println(itemFatura.getValorItemFatura());

        // cartaoCreditoRepository.findById(idCartao);

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
