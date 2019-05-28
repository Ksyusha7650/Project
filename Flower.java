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

         speed = 1;
         height = 1;
         width = 1;
         size = 2;
        init(context);
    }

    @Override
    public void update() {
        y += speed;
    }
    public boolean isCollision(float tedX, float tedY, float tedHeight, float tedWidth) {
        if (((x+size) < tedX)||(x > (tedX+tedWidth))||((y+size) < tedY)||(y > (tedY+tedHeight))){
            return true;
        }
        else return false;
    }
}
