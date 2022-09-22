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

import net.minidev.json.JSONObject;

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
    public ResponseEntity<?> addNew(@RequestBody Fatura fatura) {
        FaturaDTO response = faturaService.addNew(fatura);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Não foi possível realizar esta operação.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObject);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findFaturaById(@PathVariable int id) {
        FaturaDTO response = faturaService.findFaturaById(id);
        if (response != null) {
            return ResponseEntity.ok().body(response);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Fatura não encontrada.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObject);
    }
}
