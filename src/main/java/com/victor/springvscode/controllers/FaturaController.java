package com.victor.springvscode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springvscode.dto.FaturaDTO;
import com.victor.springvscode.model.Fatura;
import com.victor.springvscode.services.FaturaService;

@RestController
@RequestMapping(value = "/fatura")
public class FaturaController {

    @Autowired
    FaturaService faturaService;

    /**
     * 
     * @param fatura
     * @return Insere uma fatura no banco de dados
     */
    @PostMapping(value = "/")
    public ResponseEntity<FaturaDTO> addNew(@RequestBody Fatura fatura) {
        FaturaDTO response = faturaService.addNew(fatura);
        return new ResponseEntity<FaturaDTO>(response, HttpStatus.CREATED);
    }

    /**
     * @param id
     * @return Retorna o valor parcial da fatura, caso não esteja vencida
     */
    @GetMapping("/{id}")
    public ResponseEntity<FaturaDTO> findById(@PathVariable("id") Integer id) {
        FaturaDTO response = faturaService.findById(id);
        return new ResponseEntity<FaturaDTO>(response, HttpStatus.OK);
    }

}
