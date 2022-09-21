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
     * @return Insere uma nova Fatura
     */
    @PostMapping(value = "/")
    public ResponseEntity<FaturaDTO> addNew(@RequestBody Fatura fatura) {
        FaturaDTO response = faturaService.addNew(fatura);
        if (response != null) {
            return new ResponseEntity<FaturaDTO>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<FaturaDTO>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FaturaDTO> findById(@PathVariable int id) {
        FaturaDTO response = faturaService.findById(id);
        if (response != null) {
            return new ResponseEntity<FaturaDTO>(response, HttpStatus.OK);
        }
        return new ResponseEntity<FaturaDTO>(response, HttpStatus.NOT_FOUND);
    }
}
