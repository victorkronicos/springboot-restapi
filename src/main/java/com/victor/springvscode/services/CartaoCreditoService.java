package com.victor.springvscode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.dto.CartaoCreditoDTO;
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
    public CartaoCreditoDTO addNew(CartaoCredito cartaoCredito) {
        cartaoCreditoRepository.save(cartaoCredito);
        CartaoCreditoDTO dto = new CartaoCreditoDTO(cartaoCredito);
        return dto;
    }

    /**
     * 
     * @return Mostra todos os cartões de crédito cadastrados no banco de dados
     */
    public List<CartaoCreditoDTO> showAll() {
        List<CartaoCreditoDTO> dtos = new ArrayList<>();

        List<CartaoCredito> cartoes = cartaoCreditoRepository.findAll();

        cartoes.stream().forEach(cartao -> {
            CartaoCreditoDTO dto = new CartaoCreditoDTO(cartao);
            dtos.add(dto);
        });

        return dtos;
    }

    public CartaoCreditoDTO findById(int id) {
        CartaoCredito cartao = cartaoCreditoRepository.findById(id).get();
        CartaoCreditoDTO dto = new CartaoCreditoDTO(cartao);
        return dto;
    }

}
