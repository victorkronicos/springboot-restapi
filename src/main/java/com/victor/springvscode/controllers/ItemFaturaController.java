package com.victor.springvscode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.services.ItemFaturaService;

@RestController
@RequestMapping("/item-fatura")
public class ItemFaturaController {

    @Autowired
    private ItemFaturaService itemFaturaService;

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemFatura store(@RequestBody ItemFatura newItemFatura) {
        return itemFaturaService.addItemFatura(newItemFatura);
    }
}
