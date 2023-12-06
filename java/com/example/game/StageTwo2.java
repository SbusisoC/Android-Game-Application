package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.media.SoundPool;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.Display;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class StageTwo2 extends AppCompatActivity {

    List<ImageView> imageViews = new ArrayList<>();
    List<ImageView> targetViews = new ArrayList<>();
    float[] xDown;
    float[] yDown;
    float screenWidth;
    float screenHeight;
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private int clickCount = 0;
    private int clickCount2 = 0;
    private SoundPool soundPool;
    private int wrongSound;
    private int wonSound;
    private int touchSound;
    ImageView boxImageView1;
    ImageView boxImageView2;
    ImageView boxImageView3;
    ImageView boxImageView4;
    ImageView lifeImageView1;
    ImageView lifeImageView2;
    ImageView lifeImageView3;
    ImageView fireworkImageView;
    ImageView fireworkImageView2;
    ImageView fireworkImageView3;
    ImageView fireworkImageView4;
    ImageView nextStageImageView;
    ImageView replayImageView;
    ImageView gameBoard;
    ImageView gameBoard2;

    public void launchStageThree(View v) {
        /*Intent i = new Intent(this, StageThree.class);
        startActivity(i);*/
        Class randomActivity = ActivityManager3.getRandomActivity3();
        Intent intent = new Intent(this, randomActivity);
        startActivity(intent);
    }

    public void launchStageTwo(View v) {
        Class randomActivity2 = ActivityManager2.getRandomActivity2();
        Intent intent = new Intent(this, randomActivity2);
        startActivity(intent);

    }


    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_two2);

        soundPool = new SoundPool.Builder().setMaxStreams(1).build(); // You can adjust the maximum number of simultaneous streams
        wrongSound = soundPool.load(this, R.raw.wrong, 1);
        wonSound = soundPool.load(this, R.raw.gamewon, 1);
        touchSound = soundPool.load(this, R.raw.tap, 1);


        button = findViewById(R.id.help);
        button2 = findViewById(R.id.check);
        button3 = findViewById(R.id.nextstage);
        button4 = findViewById(R.id.replay);
        boxImageView1 = findViewById(R.id.box1);
        boxImageView2 = findViewById(R.id.box2);
        boxImageView3 = findViewById(R.id.box3);
        boxImageView4 = findViewById(R.id.box4);
        lifeImageView1 = findViewById(R.id.lifebarthree);
        lifeImageView2 = findViewById(R.id.lifebartwo);
        lifeImageView3 = findViewById(R.id.lifebarone);
        fireworkImageView = findViewById(R.id.firework);
        fireworkImageView2 = findViewById(R.id.firework2);
        fireworkImageView3 = findViewById(R.id.firework3);
        fireworkImageView4 = findViewById(R.id.firework4);
        nextStageImageView = findViewById(R.id.imageView3);
        replayImageView = findViewById(R.id.imageView4);
        gameBoard = findViewById(R.id.gameboard2won);
        gameBoard2 = findViewById(R.id.gameboard2lose);


        Glide.with(this)
                .asGif()
                .load(R.drawable.fireworks2)
                .diskCacheStrategy(DiskCacheStrategy.NONE) // Disable disk caching for GIFs
                .into(fireworkImageView);

        Glide.with(this)
                .asGif()
                .load(R.drawable.fireworks2)
                .diskCacheStrategy(DiskCacheStrategy.NONE) // Disable disk caching for GIFs
                .into(fireworkImageView2);

        Glide.with(this)
                .asGif()
                .load(R.drawable.fireworks)
                .diskCacheStrategy(DiskCacheStrategy.NONE) // Disable disk caching for GIFs
                .into(fireworkImageView3);

        Glide.with(this)
                .asGif()
                .load(R.drawable.fireworks3)
                .diskCacheStrategy(DiskCacheStrategy.NONE) // Disable disk caching for GIFs
                .into(fireworkImageView4);



        imageViews.add(findViewById(R.id.star1));
        imageViews.add(findViewById(R.id.coin1));
        imageViews.add(findViewById(R.id.peach1));
        imageViews.add(findViewById(R.id.moneystack1));

        targetViews.add(findViewById(R.id.frame5));
        targetViews.add(findViewById(R.id.frame6));
        targetViews.add(findViewById(R.id.frame7));
        targetViews.add(findViewById(R.id.frame8));

        xDown = new float[imageViews.size()];
        yDown = new float[imageViews.size()];


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;



        button.setOnClickListener(v -> {
            // Increment the click count
            clickCount++;

            if (clickCount == 1) {
                boxImageView1.setVisibility(View.GONE);
            }
        });

        button2.setOnClickListener(v -> {
            // Increment the click count
            clickCount2++;

            if (clickCount2 == 1 && allTargetsMatched()) {
                boxImageView1.setVisibility(View.INVISIBLE);
                boxImageView2.setVisibility(View.INVISIBLE);
                boxImageView3.setVisibility(View.INVISIBLE);
                boxImageView4.setVisibility(View.INVISIBLE);

                fireworkImageView.setVisibility(View.VISIBLE);
                fireworkImageView2.setVisibility(View.VISIBLE);
                fireworkImageView3.setVisibility(View.VISIBLE);
                fireworkImageView4.setVisibility(View.VISIBLE);

                nextStageImageView.setVisibility(View.VISIBLE);
                replayImageView.setVisibility(View.VISIBLE);

                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                gameBoard.setVisibility(View.VISIBLE);
                soundPool.play(wonSound, 3.0f, 3.0f, 1, 0, 1.0f);
            } else if (clickCount2 == 1) {
                lifeImageView1.setVisibility(View.GONE);
                soundPool.play(wrongSound, 1.0f, 1.0f, 1, 0, 1.0f);
            }
            if (clickCount2 == 2 && allTargetsMatched()) {
                boxImageView1.setVisibility(View.INVISIBLE);
                boxImageView2.setVisibility(View.INVISIBLE);
                boxImageView3.setVisibility(View.INVISIBLE);
                boxImageView4.setVisibility(View.INVISIBLE);

                fireworkImageView.setVisibility(View.VISIBLE);
                fireworkImageView2.setVisibility(View.VISIBLE);
                fireworkImageView3.setVisibility(View.VISIBLE);
                fireworkImageView4.setVisibility(View.VISIBLE);

                nextStageImageView.setVisibility(View.VISIBLE);
                replayImageView.setVisibility(View.VISIBLE);

                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                gameBoard.setVisibility(View.VISIBLE);
                soundPool.play(wonSound, 3.0f, 3.0f, 1, 0, 1.0f);
            } else if (clickCount2 == 2) {
                lifeImageView2.setVisibility(View.GONE);
                soundPool.play(wrongSound, 1.0f, 1.0f, 1, 0, 1.0f);
            }
            if (clickCount2 == 3 && allTargetsMatched()) {
                boxImageView1.setVisibility(View.INVISIBLE);
                boxImageView2.setVisibility(View.INVISIBLE);
                boxImageView3.setVisibility(View.INVISIBLE);
                boxImageView4.setVisibility(View.INVISIBLE);

                fireworkImageView.setVisibility(View.VISIBLE);
                fireworkImageView2.setVisibility(View.VISIBLE);
                fireworkImageView3.setVisibility(View.VISIBLE);
                fireworkImageView4.setVisibility(View.VISIBLE);

                nextStageImageView.setVisibility(View.VISIBLE);
                replayImageView.setVisibility(View.VISIBLE);

                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                gameBoard.setVisibility(View.VISIBLE);
                soundPool.play(wonSound, 3.0f, 3.0f, 1, 0, 1.0f);
            } else if (clickCount2 == 3) {
                lifeImageView3.setVisibility(View.GONE);
                gameBoard2.setVisibility(View.VISIBLE);
                soundPool.play(wrongSound, 1.0f, 1.0f, 1, 0, 1.0f);
                button4.setVisibility(View.VISIBLE);
                replayImageView.setVisibility(View.VISIBLE);
            }
        });

        for (int i = 0; i < imageViews.size(); i++) {
            final ImageView imageView = imageViews.get(i);
            final int finalI = i;

            imageView.setOnTouchListener((v, event) -> {
                switch (event.getAction()) {

                    //touch
                    case MotionEvent.ACTION_DOWN:
                        xDown[finalI] = event.getX();
                        yDown[finalI] = event.getY();
                        soundPool.play(touchSound, 1.0f, 1.0f, 1, 0, 1.0f);

                        break;

                    //move finger
                    case MotionEvent.ACTION_MOVE:
                        float movedX = event.getX();
                        float movedY = event.getY();

                        // Calculate the movement
                        float distanceX = movedX - xDown[finalI];
                        float distanceY = movedY - yDown[finalI];

                        // Calculate the new X position
                        float newX = imageView.getX() + distanceX;
                        float newY = imageView.getY() + distanceY;

                        // Limit the movement to stay within the screen bounds
                        if (newX >= 0 && (newX + imageView.getWidth()) <= screenWidth) {
                            imageView.setX(newX);
                        }
                        if (newY >= 0 && (newY + imageView.getHeight()) <= screenHeight) {
                            imageView.setY(newY);
                        }

                        // Check if the imageView is near a target
                        for (int j = 0; j < targetViews.size(); j++) {
                            ImageView target = targetViews.get(j);
                            if (isMatch(imageView, target)) {
                                break; // Exit the loop if a match is found
                            }
                        }
                        break;

                    // Release
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            });
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();

    }

    private boolean isMatch(ImageView imageView, ImageView target) {
        Rect imageViewRect = new Rect();
        imageView.getGlobalVisibleRect(imageViewRect);

        Rect targetRect = new Rect();
        target.getGlobalVisibleRect(targetRect);

        float imageViewCenterX = imageViewRect.centerX();
        float imageViewCenterY = imageViewRect.centerY();

        // Use tolerance for both x and y-coordinate matching
        float toleranceX = imageView.getWidth() *  0.6f; // Adjust this value as needed
        float toleranceY = imageView.getHeight() * 0.8f; // Adjust this value as needed

        // Check which image is being moved and validate its position based on the corresponding target frame
        if (imageView.getId() == R.id.star1 && target.getId() == R.id.frame5) {
            return targetRect.contains((int) (imageViewCenterX + toleranceX), (int) (imageViewCenterY + toleranceY));
        } else if (imageView.getId() == R.id.peach1 && target.getId() == R.id.frame8) {
            return targetRect.contains((int) (imageViewCenterX + toleranceX), (int) (imageViewCenterY + toleranceY));
        } else if (imageView.getId() == R.id.coin1 && target.getId() == R.id.frame6) {
            return targetRect.contains((int) (imageViewCenterX + toleranceX), (int) (imageViewCenterY + toleranceY));
        } else if (imageView.getId() == R.id.moneystack1 && target.getId() == R.id.frame7) {
            return targetRect.contains((int) (imageViewCenterX + toleranceX), (int) (imageViewCenterY + toleranceY));
        }

        return false;
    }

    private boolean allTargetsMatched() {
        for (ImageView target : targetViews) {
            boolean targetMatched = false;
            for (ImageView imageView : imageViews) {
                if (isMatch(imageView, target)) {
                    targetMatched = true;
                    break; // No need to check this target with other imageViews
                }
            }
            if (!targetMatched) {
                return false; // If any target is not matched, return false
            }
        }
        return true; // All targets are matched
    }
}




