package com.victor.springvscode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.victor.springvscode.model.CartaoCredito;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Integer> {

    List<CartaoCredito> findAll();

    Optional<CartaoCredito> findById(@Param("id") Integer id);
}
