package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Autowired

    @Override
    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Object updateFruit(Long id, Fruit fruit) {
        Optional<Fruit>  existingFruit=fruitRepository.findById(id);
        if(existingFruit.isPresent()){
          Fruit updateFruit=  existingFruit.get();
          updateFruit.setName(fruit.getName());
          updateFruit.setPrice(fruit.getPrice());
          updateFruit.setFruitType(fruit.getFruitType());
          return fruitRepository.save(updateFruit);
        }
        return new InvalidDataException("Fruit not found with id"+ id, HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteFruit(Long id) {

        if (!fruitRepository.existsById(id)) {
            throw new InvalidDataException("Fruit not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        fruitRepository.deleteById(id);
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id).orElseThrow(()-> new InvalidDataException("Fruit not found with id: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Fruit> getAllFruitsByPriceDesc() {
        return fruitRepository.findAllByOrderPriceDesc();
    }

    @Override
    public List<Fruit> getAllFruitsByPriceAsc() {
        return fruitRepository.findAllByOrderPriceAsc();
    }

    @Override
    public List<Fruit> getFruitsByNameContaining(String name) {
        return fruitRepository.findByNameContaining(name);
    }
}
