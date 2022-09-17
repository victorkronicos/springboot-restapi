package com.victor.springvscode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.victor.springvscode.model.ItemFatura;

@Repository
public interface ItemFaturaRepository extends JpaRepository<ItemFatura, Integer> {

    public default List<ItemFatura> findItemFaturaById(int id) {
        // Refatorar
        return null;
    }
}
