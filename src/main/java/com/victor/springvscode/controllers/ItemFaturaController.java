package com.victor.springvscode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    @PostMapping("/inserir")
    public ResponseEntity<ItemFaturaDTO> addNew(@RequestBody ItemFatura itemFatura) {
        ItemFaturaDTO response = itemFaturaService.addNew(itemFatura);
        if (response != null) {
            return new ResponseEntity<ItemFaturaDTO>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<ItemFaturaDTO>(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/fatura")
    public ResponseEntity<List<ItemFaturaDTO>> findAll() {
        List<ItemFaturaDTO> response = itemFaturaService.findAll();
        return new ResponseEntity<List<ItemFaturaDTO>>(response, HttpStatus.OK);
    }
}
