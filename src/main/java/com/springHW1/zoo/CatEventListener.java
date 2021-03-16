package com.springHW1.zoo;


import com.springHW1.zoo.event.AnimalIsHungryEvent;
import com.springHW1.zoo.impl.Cat;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CatEventListener implements ApplicationListener<AnimalIsHungryEvent<Cat>> {
    @Override
    public void onApplicationEvent(AnimalIsHungryEvent<Cat> event) {
        System.out.println("cat event caught");
    }
}