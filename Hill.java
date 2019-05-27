package com.example.game;

import android.content.Context;

public class Hill extends Elements  {



    public Hill(Context context) {
        bitmapId = R.raw.hill;
        y =GameView.maxY - 40;
        size = 3;
        x=0;
        speed = 1;
        init(context);

    }
    @Override
    public void update() {
        x += speed;
    }
    public boolean isCollision(float tedX, float tedY, float tedSize) {
        return !(((x+size) < tedX)||(x > (tedX+tedSize))||((y+size) < tedY)||(y > (tedY+tedSize)));
    }
    public Hill(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public String toString() {
        return getClass().getName() + "[x=" + x + ",y=" + y + ",width=" + width + ",height=" + height + "]";
    }
}


