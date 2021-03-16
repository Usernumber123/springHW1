package com.springHW1.zoo.impl;

import com.springHW1.zoo.Animal;
import com.springHW1.zoo.food.Food;
import com.springHW1.zoo.food.FoodType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("catQualifier")
@Getter
@Setter
public class Cat implements Animal {
    private Food food;
    private Integer age = 3;

    @Override
    public void voice() {
        System.out.println("mi");
    }

    @Override
    public void feed(Food food) {
        if (food.getFoodType() != FoodType.HAY) {
            this.food = food;
        }
    }

    @Override
    public void throwException() {
        throw new RuntimeException("aaaaa");
    }

}