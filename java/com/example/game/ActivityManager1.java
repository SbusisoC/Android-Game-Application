package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import java.util.Random;

public class ActivityManager1 {
    private static final Class[] activities = {
            StageOne.class,
            StageOne2.class,
            StageOne3.class,
            StageOne4.class,
            StageOne5.class,
            StageOne6.class,
            // Add more activity classes as needed
    };

    public static Class getRandomActivity() {
        Random random = new Random();
        int randomNumber = random.nextInt(activities.length);
        return activities[randomNumber];
    }
}