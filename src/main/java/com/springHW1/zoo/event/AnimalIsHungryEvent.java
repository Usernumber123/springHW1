package com.springHW1.zoo.event;

import com.springHW1.zoo.Animal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class AnimalIsHungryEvent<T extends Animal> extends ApplicationEvent {
    private T animal;

    public AnimalIsHungryEvent(T animal) {
        super(animal);
        this.animal = animal;
    }
}