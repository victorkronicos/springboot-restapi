package com.victor.springvscode.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.CartaoCreditoRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class ItemFaturaService {

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    public ItemFatura addItemFatura(int id, ItemFatura newitemFatura) {

        Optional<CartaoCredito> cartaoId = cartaoCreditoRepository.findById(id);

        if (!cartaoId.isPresent()) {
            return null;
        }

        if (cartaoId.get().getLimite_cartao_credito() < newitemFatura.getValor_item_fatura()) {
            return null;
        }

        // Checar lógica
        if (cartaoId.get().getSaldo_cartao_credito() > newitemFatura.getValor_item_fatura()) {
            return null;
        }

        // validar a data de vencimento da fatura, não adicionar itens a uma fatura
        // vencida
        return itemFaturaRepository.save(newitemFatura);
    }
}
