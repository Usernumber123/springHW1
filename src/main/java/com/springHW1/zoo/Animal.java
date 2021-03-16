package com.springHW1.zoo;

import com.springHW1.zoo.food.Food;

public interface Animal {
    Food getFood();
    void voice();

    void feed(Food food);

    Integer getAge();
    void throwException();

}