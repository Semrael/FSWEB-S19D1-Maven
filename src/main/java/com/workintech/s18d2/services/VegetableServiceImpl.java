package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements  VegetableService{
    @Autowired
    private VegetableRepository vegetableRepository;
    @Override
    public Vegetable saveVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable updateVegetable(Long id, Vegetable vegetable) {
        Optional<Vegetable> existingVegetable = vegetableRepository.findById(id);
        if (existingVegetable.isPresent()) {
            Vegetable updatedVegetable = existingVegetable.get();
            updatedVegetable.setName(vegetable.getName());
            updatedVegetable.setPrice(vegetable.getPrice());
            updatedVegetable.setIsGrownOnTree(vegetable.getIsGrownOnTree());
            return vegetableRepository.save(updatedVegetable);
        }
        return null;
    }

    @Override
    public void deleteVegetable(Long id) {
        vegetableRepository.deleteById(id);
    }

    @Override
    public List<Vegetable> getAllVegetables() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable getVegetableById(Long id) {
        Optional<Vegetable> existingVegetable = vegetableRepository.findById(id);
        return existingVegetable.get();
    }


    @Override
    public List<Vegetable> getAllVegetablesByPriceDesc() {
        return vegetableRepository.findAllByOrderPriceDesc();
    }

    @Override
    public List<Vegetable> getAllVegetablesByPriceAsc() {
        return vegetableRepository.findAllByOrderPriceAsc();
    }

    @Override
    public List<Vegetable> getVegetablesByNameContaining(String name) {
        return vegetableRepository.findByNameContaining(name);
    }
}
