package com.springHW1.zoo.food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@Scope(value = "prototype")
public class Food {
    private LocalDateTime expiredDate;
    private FoodType foodType;
    private int value;
}