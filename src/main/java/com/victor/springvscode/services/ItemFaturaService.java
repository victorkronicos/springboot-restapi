package com.victor.springvscode.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.dto.ItemFaturaDTO;
import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.model.Fatura;
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
        int idCartao = itemFatura.getCartaoCredito().getIdCartaoCredito();
        BigDecimal saldoCartao = getSaldoCartao(idCartao);
        BigDecimal valorItemFatura = itemFatura.getValorItemFatura();

        // Não permite adicionar itens à uma fatura vencida
        if (!checkVencimentoFatura(idFatura)) {
            return null;
        }

        // Não permite adicionar itens com valor maior que o saldo
        if (saldoCartao.compareTo(valorItemFatura) == -1) {
            return null;
        }

        updateFatura(idCartao, valorItemFatura);

        itemFaturaRepository.save(itemFatura);

        ItemFaturaDTO dto = new ItemFaturaDTO(itemFatura);
        return dto;
    }

    /**
     * @return Verifica o vencimento da fatura se é maior que a data atual
     */
    public Boolean checkVencimentoFatura(int id) {
        Optional<Fatura> fatura = faturaRepository.findById(id);
        if (!fatura.isPresent()) {
            return null;
        }
        return fatura.get().getDataVencimento().isAfter(LocalDate.now());
    }

    /**
     * @return Consulta o Saldo do cartão através do seu ID
     */
    public BigDecimal getSaldoCartao(int idCartao) {
        Optional<CartaoCredito> cartao = cartaoCreditoRepository.findById(idCartao);
        if (!cartao.isPresent()) {
            return null;
        }
        return cartao.get().getSaldoCartaoCredito();
    }

    /**
     * 
     * @param idCartao
     * @param valorItemFatura
     */
    public void updateFatura(int idCartao, BigDecimal valorItemFatura) {
        BigDecimal saldoAnterior = cartaoCreditoRepository.findById(idCartao).get().getSaldoCartaoCredito();

        BigDecimal novoSaldo = saldoAnterior.subtract(valorItemFatura);

        cartaoCreditoRepository.findById(idCartao).get().setSaldoCartaoCredito(novoSaldo);
    }

    /**
     * @param idFatura
     * @return Retorna items da fatura do cartão, recebendo como argumento o ID do
     *         Cartão de Crédito
     */
    public List<ItemFaturaDTO> findFaturasById(int idCartao) {
        List<ItemFaturaDTO> dtos = new ArrayList<>();
        List<ItemFatura> Items = itemFaturaRepository.findByCartaoCredito_idCartaoCredito(idCartao);

        if (Items.isEmpty()) {
            return null;
        }

        Items.stream().forEach(item -> {
            ItemFaturaDTO dto = new ItemFaturaDTO(item);
            dtos.add(dto);
        });

        return dtos;
    }

}
