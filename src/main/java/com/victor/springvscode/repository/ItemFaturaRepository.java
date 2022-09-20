package com.victor.springvscode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victor.springvscode.model.ItemFatura;

@Repository
public interface ItemFaturaRepository extends JpaRepository<ItemFatura, Integer> {

    public ItemFatura findByFatura_idFatura(Integer id);

    public List<ItemFatura> findByCartaoCredito_idCartaoCredito(Integer id);
}
