package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;
import java.util.Optional;

public interface VegetableService {
    Vegetable saveVegetable(Vegetable vegetable);
    Vegetable updateVegetable(Long id, Vegetable vegetable);
    void deleteVegetable(Long id);
    List<Vegetable> getAllVegetables();
   Vegetable getVegetableById(Long id);
    List<Vegetable> getAllVegetablesByPriceDesc();
    List<Vegetable> getAllVegetablesByPriceAsc();
    List<Vegetable> getVegetablesByNameContaining(String name);
}
