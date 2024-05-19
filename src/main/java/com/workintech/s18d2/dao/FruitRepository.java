package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Long> {

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
List<Fruit> findAllByOrderPriceDesc();
    @Query("SELECT f FROM Fruit f ORDER BY f.price")
List<Fruit> findAllByOrderPriceAsc();
    @Query("SELECT f FROM Fruit f WHERE f.name LIKE %:name%")
List<Fruit> findByNameContaining(String name);
}
