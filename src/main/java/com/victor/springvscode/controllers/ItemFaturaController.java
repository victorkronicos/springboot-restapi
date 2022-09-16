package com.victor.springvscode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.repository.ItemFaturaRepository;

@RestController
@RequestMapping("/item-fatura")
public class ItemFaturaController {

    @Autowired
    ItemFaturaRepository itemFaturaRepository;

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemFatura store(@RequestBody ItemFatura itemFatura) {
        return this.itemFaturaRepository.save(itemFatura);
    }
}
