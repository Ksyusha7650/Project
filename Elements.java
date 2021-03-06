package com.example.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.constraintlayout.solver.widgets.Rectangle;

public class Elements extends Rectangle {
    protected float x; // координаты
    protected float y;
    protected float size; // размер
    protected float height, width;
    protected float speed; // скорость
    protected int bitmapId; // id картинки
    protected Bitmap bitmap; // картинка

    void init(Context context) { // сжимаем картинку до нужных размеров
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(
                cBitmap,(int) (width * GameView.unitW),   (int) (height * GameView.unitH),false);

        cBitmap.recycle();
    }

    void update() { // тут будут вычисляться новые координаты
    }

    void draw(Paint paint, Canvas canvas) { // рисуем картинку
         canvas.drawBitmap(bitmap, x* GameView.unitW, y* GameView.unitH , paint);

    }
}
