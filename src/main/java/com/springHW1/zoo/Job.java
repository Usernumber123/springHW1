package com.springHW1.zoo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Job {
    private Animal cow;
    private Animal cat;
    private Animal dog;

    @Autowired
    public void setCat(Animal cat) {
        this.cat = cat;
    }

    @Autowired
    public void setDog(Animal dog) {
        this.dog = dog;
    }

    @Autowired
    public void setCow(Animal cow) {
        this.cow = cow;
    }


    @Scheduled(cron = "1 * * * * *")
    public void catEat() {
        if (cat.getFood().getValue() > 0) {
            if (cat.getFood().getExpiredDate().isAfter(LocalDateTime.now())) {
                cat.getFood().setValue(cat.getFood().getValue() - 1);
                System.out.println("Cat eat");
            } else {
                System.out.println("cat: rot food");
                cat.getFood().setValue(0);
                cat.voice();
            }
        } else {
            cat.voice();
        }
    }

    @Scheduled(cron = "4 * * * * *")
    public void dogEat() {
        if (dog.getFood().getValue() > 0) {
            if (dog.getFood().getExpiredDate().isAfter(LocalDateTime.now())) {
                dog.getFood().setValue(dog.getFood().getValue() - 1);
                System.out.println("Dog eat");
            } else {
                System.out.println("dog: rot food");
                dog.getFood().setValue(0);
                dog.voice();
            }
        } else {
            dog.voice();
        }
    }

    @Scheduled(cron = "2 * * * * *")
    public void cowEat() {
        if (cow.getFood().getValue() > 0) {
            if (cow.getFood().getExpiredDate().isAfter(LocalDateTime.now())) {
                cow.getFood().setValue(cow.getFood().getValue() - 1);
                System.out.println("Cow eat");
            } else {
                System.out.println("cow: rot food");
                cow.getFood().setValue(0);
                cow.voice();
            }
        } else {
            cow.voice();
        }
    }

}