package com.example.game;

import android.content.Context;

class Ted extends Elements {
    public Ted(Context context) {
        bitmapId = R.raw.ted; // определяем начальные параметры
        size = 5;
        x=7;
        y=GameView.maxY - size - 1;
        speed = (float) 0.2;

        init(context);
    }
    @Override
    public void update() { // перемещаем мишку в зависимости от нажатой кнопки
        if(MainActivity.isLeftPressed && x >= 0){
            x -= speed;
        }
        if(MainActivity.isRightPressed && x <= GameView.maxX - 5){
            x += speed;
        }
        if(MainActivity.isUpPressed && y >= 0){
            y -= speed;
        }
        if(MainActivity.isDownPressed && y <= GameView.maxY - 5){
            y += speed;
        }

    }
}
