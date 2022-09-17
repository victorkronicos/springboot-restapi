package com.victor.springvscode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.FaturaRepository;
import com.victor.springvscode.repository.ItemFaturaRepository;

@RestController
@RequestMapping("/item-fatura")
public class ItemFaturaController {

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    @Autowired
    FaturaRepository faturaRepository;

    @PostMapping("/inserir/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemFatura store(@PathVariable int id, @RequestBody ItemFatura itemFatura) {

        // Fatura codigo = this.faturaRepository.findById(id);
        // Optional<Fatura> faturaFindById = this.faturaRepository.findById(id);
        // Atribuir um item_fatura à uma fatura.
        // itemFatura.setFatura(faturaFindById);

        // Verificar se o cartão tem o saldo necessário
        // Se sim, atribui o valor do item_fatura para saldo
        // E subtrai o valor de item_fatura de limite

        // Somente adiciona item_fatura à fatura se este for menor que data_vencimento
        // Caso seja maior exibir erro ("Não é possível inserir items à uma fatura
        // fechada")
        return this.itemFaturaRepository.save(itemFatura);
    }
}
