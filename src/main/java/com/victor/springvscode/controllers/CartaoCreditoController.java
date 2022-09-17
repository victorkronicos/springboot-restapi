package com.victor.springvscode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springvscode.model.CartaoCredito;
import com.victor.springvscode.services.CartaoCreditoService;

@RestController
@RequestMapping("/cartao-credito")
public class CartaoCreditoController {

    @Autowired
    CartaoCreditoService cartaoCreditoService;

    /**
     * @return Retorna todos os Cartões de Crédito armazenados no banco de dados
     */
    @GetMapping("/")
    public List<CartaoCredito> show() {
        return cartaoCreditoService.showAllCartaoCredito();
    }

    /**
     * @return Consulta Saldo e Limite de um CartaoCredito
     */
    @GetMapping("/{id}")
    public CartaoCredito filter(@PathVariable int id) {
        return cartaoCreditoService.showCartaoCreditoById(id);
    }

    /**
     * @return Armazena um novo CartaoCredito
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoCredito store(@RequestBody CartaoCredito cartaoCredito) {
        return cartaoCreditoService.addCartaoCredito(cartaoCredito);
    }

}
