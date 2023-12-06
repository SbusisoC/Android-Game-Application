package com.example.game;

import java.util.Random;

public class ActivityManager3 {

    private static final Class[] activities = {
            StageThree.class,
            StageThree2.class,
            StageThree3.class,
            StageThree4.class,
            // Add more activity classes as needed
    };

    public static Class getRandomActivity3() {
        Random random = new Random();
        int randomNumber = random.nextInt(activities.length);
        return activities[randomNumber];
    }
}
