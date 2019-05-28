package com.example.game;

import android.content.Context;

public class Hill extends Elements  {
public int floorY = 3;


    public Hill(Context context) {
        bitmapId = R.raw.hill1;
        size = 5;
        y=15;
       // height = (int) ((Math.random()*GameView.maxY)/10 + (0.3)*GameView.maxY);
        height = 3;
        width = 3;
        x=0;
        speed = 0.5f;
        init(context);

    }
    @Override
    public void update() {
        x += speed;
    }
    public boolean isCollision(float tedX, float tedY, float tedSize) {
        return !(((x+width) < tedX)||(x > (tedX+tedSize))||((y+size) < tedY)||(y > (tedY+tedSize)));
    }

}


