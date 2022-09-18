package com.victor.springvscode.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
     * @param newitemFatura
     * @return Adiciona um Item à uma fatura
     */
    public ItemFatura addItemFatura(ItemFatura newitemFatura) {
        Integer idCartaoCredito = newitemFatura.getCartaoCredito().getIdCartaoCredito();
        Integer idFatura = newitemFatura.getFatura().getIdFatura();

        Float valorItemFatura = newitemFatura.getValorItemFatura();
        Float limiteCartaoCredito = cartaoCreditoRepository.findById(idCartaoCredito).get().getLimiteCartaoCredito();

        LocalDate vencimentoFatura = faturaRepository.findById(idFatura).get().getDataVencimento();

        // Verifica se o cartão de credito tem o limite necessário
        // E se a data do vencimento da fatura está vencida
        if (limiteCartaoCredito > valorItemFatura &&
                vencimentoFatura.isAfter(LocalDate.now())) {

            // Subtrai do limite do cartão de crédito o valor da compra
            cartaoCreditoRepository.findById(idCartaoCredito).get()
                    .setLimiteCartaoCredito(--valorItemFatura);

            // Atribui valor da compra ao saldo do cartão de crédito
            cartaoCreditoRepository.findById(idCartaoCredito).get()
                    .setSaldoCartaoCredito(++valorItemFatura);

            return itemFaturaRepository.save(newitemFatura);
        }

        return null;
    }

}
