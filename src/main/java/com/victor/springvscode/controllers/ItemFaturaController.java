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

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/item-fatura")
public class ItemFaturaController {

    @Autowired
    private ItemFaturaService itemFaturaService;

    /**
     * Insere um novo item à Fatura
     */
    @PostMapping("/")
    public ResponseEntity<?> addNew(@RequestBody ItemFatura itemFatura) {
        ItemFaturaDTO response = itemFaturaService.addNew(itemFatura);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message",
                "Não foi possível processar sua compra.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObject);
    }

    /**
     * Consulta itens da Fatura de um cartão através do ID do Cartão
     * 
     * @param id
     */
    @GetMapping("/cartao/{id}")
    public ResponseEntity<?> findFaturasById(@PathVariable int id) {
        List<ItemFaturaDTO> response = itemFaturaService.findFaturasById(id);
        if (response != null) {
            return ResponseEntity.ok().body(response);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Nenhuma fatura vinculada a este cartão.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObject);
    }
}
