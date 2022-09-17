package com.victor.springvscode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.repository.CartaoCreditoRepository;

@Service
public class CartaoCreditoService {

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    /**
     * 
     * @param cartaoCredito
     * @return Adiciona um novo cartão de crédito ao banco de dados
     */
    public CartaoCredito addCartaoCredito(CartaoCredito cartaoCredito) {
        return this.cartaoCreditoRepository.save(cartaoCredito);
    }

    /**
     * 
     * @return Mostra todos os cartões de crédito cadastrados no banco de dados
     */
    public List<CartaoCredito> showAllCartaoCredito() {
        return cartaoCreditoRepository.findAll();
    }

    public CartaoCredito showCartaoCreditoById(int id) {
        Optional<CartaoCredito> cartaoFindById = this.cartaoCreditoRepository.findById(id);

        if (cartaoFindById.isPresent()) {
            return cartaoFindById.get();
        }
        return null;
    }

    /**
     * 
     * @param id
     * @return Verifica se o ID informado existe
     */
    public Integer getCartaoCreditoById(int id) {
        Optional<CartaoCredito> cartaoFindById = this.cartaoCreditoRepository.findById(id);

        if (cartaoFindById.isPresent()) {
            return cartaoFindById.get().getId_cartao_credito();
        }
        return null;
    }

}
