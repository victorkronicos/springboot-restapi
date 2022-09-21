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
     * @return Retorna todos os Cartões de Crédito armazenados no banco de dados
     */
    @GetMapping("/")
    public ResponseEntity<List<CartaoCreditoDTO>> showAll() {
        List<CartaoCreditoDTO> response = cartaoCreditoService.showAll();
        return new ResponseEntity<List<CartaoCreditoDTO>>(response, HttpStatus.OK);
    }

    /**
     * @return Consulta Saldo e Limite de um CartaoCredito
     */
    @GetMapping("/{id}")
    public ResponseEntity<CartaoCreditoDTO> findById(@PathVariable int id) {
        CartaoCreditoDTO response = cartaoCreditoService.findById(id);
        return new ResponseEntity<CartaoCreditoDTO>(response, HttpStatus.OK);
    }

    /**
     * @return Armazena um novo CartaoCredito
     */
    @PostMapping("/")
    public ResponseEntity<CartaoCreditoDTO> addNew(@RequestBody CartaoCredito cartaoCredito) {
        CartaoCreditoDTO response = cartaoCreditoService.addNew(cartaoCredito);
        return new ResponseEntity<CartaoCreditoDTO>(response, HttpStatus.CREATED);
    }

}
