package com.victor.springvscode.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.repository.FaturaRepository;

@RestController
@RequestMapping(value = "/fatura")
public class FaturaController {

    @Autowired
    private FaturaRepository faturaRepository;

    @PostMapping(value = "/")
    public Fatura store(@RequestBody Fatura fatura) {
        return this.faturaRepository.save(fatura);
    }

    /**
     * @param id
     * @return Retorna o valor parcial da fatura, caso não esteja vencida
     */
    @GetMapping("/{id}")
    public Fatura show(@PathVariable("id") Fatura id) {

        return null;
    }

}
