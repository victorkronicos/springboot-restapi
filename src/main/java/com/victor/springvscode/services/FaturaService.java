package com.victor.springvscode.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.dto.FaturaDTO;
import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.CartaoCreditoRepository;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class FaturaService {

    @Autowired
    FaturaRepository faturaRepository;

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    public FaturaDTO addNew(Fatura fatura) {
        faturaRepository.save(fatura);
        FaturaDTO dto = new FaturaDTO(fatura);
        dto.setValorFatura(new BigDecimal(0));
        return dto;
    }

    public FaturaDTO findFaturaById(int idFatura) {
        Fatura fatura = faturaRepository.findByIdFatura(idFatura);
        List<ItemFatura> Items = itemFaturaRepository.findByFatura_idFatura(idFatura);
        List<BigDecimal> soma = new ArrayList<>();

        if (Items.isEmpty()) {
            return null;
        }

        FaturaDTO dto = new FaturaDTO(fatura);

        Items.stream().forEach(item -> {
            soma.add(item.getValorItemFatura());
        });

        BigDecimal result = soma.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        dto.setValorFatura(result);

        // Retornar mensagem fatura fechada
        if (dto.getDataVencimento().isBefore(LocalDate.now())) {
            return null;
        }

        return dto;
    }

}
