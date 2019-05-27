package com.example.game;

import android.content.Context;

import java.util.Random;

class Flower extends Elements {
    private int radius = 2; // радиус


    public Flower(Context context) {
        Random random = new Random();

        bitmapId = R.raw.flower;
        y=0;
        x = random.nextInt(GameView.maxX) - radius;
        //size = radius*2;
//        speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat();
         speed = 1;
         size = 2;
        init(context);
    }

    @Override
    public void update() {
        y += speed;
    }
    public boolean isCollision(float tedX, float tedY, float tedSize) {
        return !(((x+size) < tedX)||(x > (tedX+tedSize))||((y+size) < tedY)||(y > (tedY+tedSize)));
    }
}
