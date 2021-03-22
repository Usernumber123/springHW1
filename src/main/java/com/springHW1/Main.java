package com.springHW1;

import com.springHW1.configuration.AnnotationConfiguration;
import com.springHW1.zoo.Animal;
import com.springHW1.zoo.AnimalService;
import com.springHW1.zoo.Zoo;
import com.springHW1.zoo.food.Food;
import com.springHW1.zoo.food.FoodType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext("annotationConfiguration");
        Zoo setterZoo = context.getBean("zoo", Zoo.class);

        AnimalService animalService = context.getBean("animalServiceImpl", AnimalService.class);
        Animal cat = context.getBean("cat", Animal.class);
        Animal dog = context.getBean("dog", Animal.class);
        Animal cow = context.getBean("cow", Animal.class);
        animalService.feedAnimal(
                Food.builder()
                        .expiredDate(LocalDateTime.now().plusMinutes(0))
                        .foodType(FoodType.FISH)
                        .value(100).build(),
                cat
        );
        animalService.feedAnimal(
                Food.builder()
                        .expiredDate(LocalDateTime.now().plusMinutes(0))
                        .foodType(FoodType.MEAT)
                        .value(100).build(),
                dog
        );
        animalService.feedAnimal(
                Food.builder()
                        .expiredDate(LocalDateTime.now().plusMinutes(0))
                        .foodType(FoodType.HAY)
                        .value(100).build(),
                cow
        );
        setterZoo.getAnimal1().voice();
    }

    private static ApplicationContext getAnnotationContext(String profile) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles(profile);
        annotationConfigApplicationContext.register(AnnotationConfiguration.class);
        annotationConfigApplicationContext.refresh();
        return annotationConfigApplicationContext;
    }



}