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

import com.victor.springvscode.dto.CartaoCreditoDTO;
import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.services.CartaoCreditoService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/cartao")
public class CartaoCreditoController {

    @Autowired
    CartaoCreditoService cartaoCreditoService;

    /**
     * @return Retorna todos os Cartões de Crédito armazenados
     */
    @GetMapping("/")
    public ResponseEntity<?> showAll() {
        List<CartaoCreditoDTO> response = cartaoCreditoService.showAll();
        if (response != null) {
            return ResponseEntity.ok().body(response);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Nenhum Cartão de Crédito encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObject);
    }

    /**
     * @return Consulta Saldo e Limite de um Cartão de Crédito
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        CartaoCreditoDTO response = cartaoCreditoService.findById(id);
        if (response != null) {
            return ResponseEntity.ok().body(response);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Cartão de Crédito não encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObject);
    }

    /**
     * @return Insere um novo Cartão de Crédito
     */
    @PostMapping("/")
    public ResponseEntity<?> addNew(@RequestBody CartaoCredito cartaoCredito) {
        CartaoCreditoDTO response = cartaoCreditoService.addNew(cartaoCredito);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Não foi possível realizar esta operação.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObject);
    }

}
