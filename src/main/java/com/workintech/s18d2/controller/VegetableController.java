package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {
    @Autowired
    private VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> getAllVegetables() {
        return vegetableService.getAllVegetablesByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@PathVariable Long id) {
        return vegetableService.getVegetableById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllVegetablesByPriceDesc() {
        return vegetableService.getAllVegetablesByPriceDesc();
    }

    @PostMapping
    public Vegetable saveOrUpdateVegetable(@RequestBody Vegetable vegetable) {
        return vegetableService.saveVegetable(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> getVegetablesByName(@PathVariable String name) {
        return vegetableService.getVegetablesByNameContaining(name);
    }

    @DeleteMapping("/{id}")
    public void deleteVegetable(@PathVariable Long id) {
        vegetableService.deleteVegetable(id);
    }
}
