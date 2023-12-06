package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import java.util.Random;

public class ActivityManager2 {
    private static final Class[] activities = {
            StageTwo.class,
            StageTwo2.class,
            StageTwo3.class,
            StageTwo4.class,
            // Add more activity classes as needed
    };

    public static Class getRandomActivity2() {
        Random random = new Random();
        int randomNumber = random.nextInt(activities.length);
        return activities[randomNumber];
    }
}
