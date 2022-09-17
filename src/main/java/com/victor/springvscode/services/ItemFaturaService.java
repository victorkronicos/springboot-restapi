package com.victor.springvscode.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.CartaoCreditoRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class ItemFaturaService {

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    /**
     * @param id
     * @param newitemFatura
     * @return Adiciona um Item à uma fatura
     */
    public ItemFatura addItemFatura(Fatura FaturaId, ItemFatura newitemFatura) {

        // Optional<CartaoCredito> cartaoId = cartaoCreditoRepository.findById(id);

        // if (!cartaoId.isPresent()) {
        // return null;
        // }

        // if (checkLimiteCartao(cartaoId, newitemFatura.getValor_item_fatura())) {
        // return null;
        // }

        newitemFatura.setFatura_id(FaturaId);
        return itemFaturaRepository.save(newitemFatura);
    }

    /**
     * @param cartaoId
     * @param newitemFatura
     * @return Verifica se o Item inserido, é menor que o limite do Cartão
     */
    public Boolean checkLimiteCartao(Optional<CartaoCredito> cartaoId, Float itemFatura) {

        if (cartaoId.get().getLimite_cartao_credito() < itemFatura) {
            return false;
        }
        return true;
    }
}
