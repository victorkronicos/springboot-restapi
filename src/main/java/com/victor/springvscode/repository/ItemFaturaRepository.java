package com.victor.springvscode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victor.springvscode.model.ItemFatura;

@Repository
public interface ItemFaturaRepository extends JpaRepository<ItemFatura, Integer> {

    // public default List<ItemFatura> findItemFaturaById(int id) {

    // return null;
    // }
}
