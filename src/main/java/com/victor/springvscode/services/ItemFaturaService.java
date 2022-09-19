package com.victor.springvscode.services;

import java.time.LocalDate;

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

        if (!checkVencimentoFatura(itemFatura.getFatura().getIdFatura())) {
            return null;
        }

        if (!checkLimiteCartao(
                itemFatura.getCartaoCredito().getIdCartaoCredito(),
                itemFatura.getValorItemFatura())) {
            return null;
        }

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

    /**
     * 
     * @param itemFatura
     * @return Verifica se o Cartão tem o limite necessário
     */
    public Boolean checkLimiteCartao(int idCartaoCredito, float valorItemFatura) {

        Float limiteCartao = cartaoCreditoRepository
                .findById(idCartaoCredito)
                .get()
                .getLimiteCartaoCredito();

        // Se o limite for maior que o valor do item
        if (limiteCartao > valorItemFatura) {
            // Subtrai do limite o valor do respectivo item
            cartaoCreditoRepository
                    .findById(idCartaoCredito)
                    .get()
                    .setLimiteCartaoCredito((float) limiteCartao - valorItemFatura);

            // Atribui valor da compra ao saldo do cartão de crédito
            cartaoCreditoRepository.findById(idCartaoCredito)
                    .get()
                    .setSaldoCartaoCredito(++valorItemFatura);

            return true;
        }

        return false;
    }
}
