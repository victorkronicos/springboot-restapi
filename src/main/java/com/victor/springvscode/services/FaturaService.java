package com.victor.springvscode.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.springvscode.dto.FaturaDTO;
import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@Service
public class FaturaService {

    @Autowired
    FaturaRepository faturaRepository;

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    public FaturaDTO addNew(Fatura fatura) {
        faturaRepository.save(fatura);
        FaturaDTO dto = new FaturaDTO(fatura);
        return dto;
    }

    /**
     * @param id
     * @return Consulta de valor parcial de uma fatura em aberto passando o
     *         ID_FATURA como
     *         parâmetro
     *         • Validar a data de vencimento para saber se a fatura está em aberto,
     *         se sim
     *         retornar o valor parcial da fatura
     */
    public FaturaDTO findById(int id) {
        return null;
    }
}
