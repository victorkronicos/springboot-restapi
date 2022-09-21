package com.victor.springvscode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springvscode.dto.ItemFaturaDTO;
import com.victor.springvscode.model.ItemFatura;
import com.victor.springvscode.services.ItemFaturaService;

@RestController
@RequestMapping("/item-fatura")
public class ItemFaturaController {

    @Autowired
    private ItemFaturaService itemFaturaService;

    /**
     * Inserir um novo item à Fatura
     * 
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<ItemFaturaDTO> addNew(@RequestBody ItemFatura itemFatura) {
        ItemFaturaDTO response = itemFaturaService.addNew(itemFatura);
        if (response != null) {
            return new ResponseEntity<ItemFaturaDTO>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<ItemFaturaDTO>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cartao/{id}")
    public ResponseEntity<List<ItemFaturaDTO>> findFaturasById(@PathVariable int id) {
        List<ItemFaturaDTO> response = itemFaturaService.findFaturasById(id);
        if (response != null) {
            return new ResponseEntity<List<ItemFaturaDTO>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<List<ItemFaturaDTO>>(response, HttpStatus.NOT_FOUND);
    }
}
