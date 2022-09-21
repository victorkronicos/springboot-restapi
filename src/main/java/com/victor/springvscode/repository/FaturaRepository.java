package com.victor.springvscode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victor.springvscode.model.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {

    public Fatura findByIdFatura(Integer idFatura);
}
