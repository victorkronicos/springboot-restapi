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

@RestController
@RequestMapping("/cartao")
public class CartaoCreditoController {

    @Autowired
    CartaoCreditoService cartaoCreditoService;

    /**
     * @return Retorna todos os Cartões de Crédito armazenados
     */
    @GetMapping("/")
    public ResponseEntity<List<CartaoCreditoDTO>> showAll() {
        List<CartaoCreditoDTO> response = cartaoCreditoService.showAll();
        if (response != null) {
            return new ResponseEntity<List<CartaoCreditoDTO>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<List<CartaoCreditoDTO>>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * @return Consulta Saldo e Limite de um Cartão de Crédito
     */
    @GetMapping("/{id}")
    public ResponseEntity<CartaoCreditoDTO> findById(@PathVariable int id) {
        CartaoCreditoDTO response = cartaoCreditoService.findById(id);
        if (response != null) {
            return new ResponseEntity<CartaoCreditoDTO>(response, HttpStatus.OK);
        }

        return new ResponseEntity<CartaoCreditoDTO>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * @return Insere um novo Cartão de Crédito
     */
    @PostMapping("/")
    public ResponseEntity<CartaoCreditoDTO> addNew(@RequestBody CartaoCredito cartaoCredito) {
        CartaoCreditoDTO response = cartaoCreditoService.addNew(cartaoCredito);
        if (response != null) {
            return new ResponseEntity<CartaoCreditoDTO>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<CartaoCreditoDTO>(response, HttpStatus.NOT_FOUND);
    }

}
