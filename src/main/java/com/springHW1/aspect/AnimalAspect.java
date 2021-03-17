package com.springHW1.aspect;

import com.springHW1.zoo.Animal;
import com.springHW1.zoo.food.Food;
import com.springHW1.zoo.food.FoodType;
import com.springHW1.zoo.impl.AnimalServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AnimalAspect {


    AnimalServiceImpl animalService;

    @Autowired
    public AnimalAspect(AnimalServiceImpl animalService) {

        this.animalService = animalService;

    }

    @Pointcut("execution(* com.springHW1.zoo.impl.*.voice())")
    public void voicePoint() {
    }

    @Pointcut("execution (* com.springHW1.zoo.Job.job())")
    public void anyAnimalMethod() {
    }

    @Pointcut("within (com.springHW1.zoo.*)")
    public void anyAnimalMethodWithWithIn() {
    }

    @Pointcut("@annotation(com.springHW1.aspect.annotationMarker.Marker)")
    public void annotationPointcut() {
    }

    @Pointcut("@within(com.springHW1.aspect.annotationMarker.Marker)")
    public void annotationWithInPointcut() {
    }

    @Pointcut("args(food)")
    public void withArg(Food food) {
    }

    @AfterReturning(value = "voicePoint()")
    public void beforeVoice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getThis().toString() + "  Feed!");

        animalService.feedAnimal(Food.builder()
                .expiredDate(LocalDateTime.now().plusMinutes(3))
                .foodType(FoodType.FISH)
                .value(2).build(), (Animal) joinPoint.getThis());
        animalService.feedAnimal(Food.builder()
                .expiredDate(LocalDateTime.now().plusMinutes(3))
                .foodType(FoodType.HAY)
                .value(2).build(), (Animal) joinPoint.getThis());
        animalService.feedAnimal(Food.builder()
                .expiredDate(LocalDateTime.now().plusMinutes(3))
                .foodType(FoodType.MEAT)
                .value(2).build(), (Animal) joinPoint.getThis());

    }

    @Before(value = "anyAnimalMethod() && withArg(food)", argNames = "food")
    public void beforeSetFood(Food food) {
        System.out.println(food.toString());
    }


}
