package com.victor.springvscode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.victor.springvscode.model.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {

    List<Fatura> findAll();

    Optional<Fatura> findById(@Param("id") Integer id);

}
