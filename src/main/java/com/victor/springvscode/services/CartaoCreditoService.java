package com.victor.springvscode.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.dto.CartaoCreditoDTO;
import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.repository.CartaoCreditoRepository;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class CartaoCreditoService {

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    FaturaRepository faturaRepository;

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    /**
     * 
     * @param cartaoCredito
     * @return Adiciona um novo cartão de crédito ao banco de dados
     */
    public CartaoCreditoDTO addNew(CartaoCredito cartaoCredito) {
        if (cartaoCredito.getNomeCartaoCredito() == null) {
            return null;
        }

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

        if (cartoes.isEmpty()) {
            return null;
        }

        cartoes.stream().forEach(cartao -> {
            CartaoCreditoDTO dto = new CartaoCreditoDTO(cartao);
            dtos.add(dto);
        });

        return dtos;
    }

    public CartaoCreditoDTO findById(int id) {
        Optional<CartaoCredito> cartao = cartaoCreditoRepository.findById(id);

        if (cartao.isEmpty()) {
            return null;
        }

        CartaoCreditoDTO dto = new CartaoCreditoDTO(cartao.get());
        return dto;
    }

}
