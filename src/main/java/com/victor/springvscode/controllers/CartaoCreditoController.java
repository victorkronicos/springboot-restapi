package com.victor.springvscode.controllers;

import java.util.List;
import java.util.Optional;

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
import com.victor.springvscode.repository.CartaoCreditoRepository;

@RestController
@RequestMapping("/cartao-credito")
public class CartaoCreditoController {

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    /**
     * @return Returns Saldo from Cartão_Credito
     *         Refatorar pra trazer só o saldo e o limite
     */
    @GetMapping("/{id}")
    public CartaoCredito filter(@PathVariable int id) {
        Optional<CartaoCredito> cartaoFindById = this.cartaoCreditoRepository.findById(id);
        return cartaoFindById.get();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoCredito store(@RequestBody CartaoCredito cartaoCredito) {
        return this.cartaoCreditoRepository.save(cartaoCredito);
    }

    @GetMapping("/")
    public List<CartaoCredito> showAll() {
        return this.cartaoCreditoRepository.findAll();
    }
}
