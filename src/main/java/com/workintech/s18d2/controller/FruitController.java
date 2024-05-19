package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.validations.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/fruits")
public class FruitController {
    @Autowired
    private FruitService fruitService;
    @GetMapping
    public List<Fruit> getAllFruits(){


        return fruitService.getAllFruits();
    }
    @GetMapping("/{id}")
    public Fruit getFruitId(@PathVariable Long id){

        Validator.validateId(id);return fruitService.getFruitById(id);
    }
    @GetMapping("/desc")
    public List<Fruit> getAllFruitsByPriceDesc(){
        return fruitService.getAllFruitsByPriceDesc();
    }
    @PostMapping
    public Fruit saveFruit(@RequestBody Fruit fruit){
        Validator.validateFruit(fruit);
        return fruitService.saveFruit(fruit);
    }
    @PostMapping("/name")
    public List<Fruit> getFruitsByName(@PathVariable String name){
        return fruitService.getFruitsByNameContaining(name);
    }
    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Long id){
        Validator.validateId(id);
         fruitService.deleteFruit(id);
    }
}
