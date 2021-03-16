package com.springHW1.zoo.impl;

import com.springHW1.aspect.annotationMarker.Marker;
import com.springHW1.zoo.Animal;
import com.springHW1.zoo.AnimalService;
import com.springHW1.zoo.food.Food;
import org.springframework.stereotype.Service;

@Service
@Marker
public class AnimalServiceImpl implements AnimalService {

    @Override
    public void feedAnimal(Food food, Animal animal) {
        animal.feed(food);
    }
}