package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit saveFruit(Fruit fruit);
    Object updateFruit(Long id, Fruit fruit);
    void deleteFruit(Long id);
    List<Fruit> getAllFruits();
    Fruit  getFruitById(Long id);
    List<Fruit> getAllFruitsByPriceDesc();
    List<Fruit> getAllFruitsByPriceAsc();
    List<Fruit> getFruitsByNameContaining(String name);
}
