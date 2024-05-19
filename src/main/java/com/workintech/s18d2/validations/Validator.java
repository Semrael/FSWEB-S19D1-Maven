package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.InvalidDataException;
import org.springframework.http.HttpStatus;

public class Validator {
    public static void validateId(Long id){
        if(id==null || id<1){
            throw new InvalidDataException("Id must be greater then 0", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateFruit(Fruit fruit){
        if (fruit.getName() == null || fruit.getName().isEmpty()) {
            throw new InvalidDataException("Fruit name cannot be empty",HttpStatus.BAD_REQUEST);
        }
        if (fruit.getPrice() < 0) {
            throw new InvalidDataException("Fruit price cannot be negative",HttpStatus.BAD_REQUEST);
        }
        if (fruit.getFruitType() == null) {
            throw new InvalidDataException("Fruit type must be specified",HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateVegetable(Vegetable vegetable){
        if(vegetable.getName()==null||vegetable.getName().isEmpty()){
            throw new InvalidDataException("Vegetable name cannot be empty",HttpStatus.BAD_REQUEST);
        }
        if (vegetable.getPrice() < 0) {
            throw new InvalidDataException("Vegetable price cannot be negative",HttpStatus.BAD_REQUEST);
        }
    }
}
