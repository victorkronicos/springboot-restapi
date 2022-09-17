package com.victor.springvscode.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class FaturaService {

    @Autowired
    FaturaRepository faturaRepository;

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    public Fatura addFatura(Fatura fatura) {

        boolean isBefore = fatura.getData_vencimento().isAfter(LocalDate.now());

        if (isBefore) {
            return null;
        }

        return null;
    }

    public Float getFaturaValue(int id) {

        List<ItemFatura> itemsFatura = itemFaturaRepository.findAll();
        Float faturaValue = (float) 0;

        for (ItemFatura itemFatura : itemsFatura) {
            if (itemFatura.getId_item_fatura().equals(id)) {
                faturaValue += faturaValue;
            }
        }

        return faturaValue;
    }
}
