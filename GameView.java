package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.constraintlayout.solver.widgets.Rectangle;

import java.util.ArrayList;

class GameView extends SurfaceView implements Runnable {
    public static int maxX = 35; // размер по горизонтали
    public static int maxY = 18; // размер по вертикали
    public static float unitW = 0; // пикселей в юните по горизонтали
    public static float unitH = 0; // пикселей в юните по вертикали
    private boolean firstTime = true;
    private boolean gameRunning = true;
    private Ted ted;
    private Thread gameThread = null;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private ArrayList<Flower> flowers = new ArrayList<>();
    private ArrayList<Hill> hills = new ArrayList<>();
    ArrayList<Rectangle> rects;
    private final int FLOWER_INTERVAL = 50;
    private final int HILL_INTERVAL = 150;
    private int currentTime, scroll = 0;
    public static int score = 0;
//    public Bitmap bg = BitmapFactory.decodeFile("C:\\Prj\\app\\src\\main\\res\\drawable\\bg.png");

    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        // инициализируем поток
        gameThread = new Thread(this);
        gameThread.start();
    }
//  private void checkCollision(){
//        for (Flower flower : flowers) {
//            if((flower.x - ted.x <150)&&(flower.x - ted.x >0)&&((flower.y - ted.y<150)&&(flower.y - ted.y>0))){
//                // игрок проиграл
//                gameRunning = false; // останавливаем игру
//
//            }
//        }
//    }
private void checkIfNewHill(){
    if(currentTime >= HILL_INTERVAL){
        Hill hill = new Hill(getContext());
        hills.add(hill);
        currentTime = 0;
    }else{
        currentTime ++;
    }
}
    private void checkIfNewFlower(){
        if(scroll >= FLOWER_INTERVAL ) {
              Flower flower = new Flower(getContext());
              flowers.add(flower);
              scroll = 0;
        } else {
            scroll++;
        }
    }


    @Override
    public void run() {
        while (gameRunning) {

            update();
            draw();

           // checkCollision();
              checkIfNewHill();
            checkIfNewFlower();
//
            control();
            score++;
        }

    }

    private void update() {
        if(!firstTime) {
            ted.update();
            for (Flower flower : flowers) {
                flower.update();
            }
            for (Hill hill: hills) {
                hill.update();
            }
        }
    }



    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {  //проверяем валидный ли surface

            if(firstTime){ // инициализация при первом запуске
                firstTime = false;
                unitW = surfaceHolder.getSurfaceFrame().width()/maxX; // вычисляем число пикселей в юните
                unitH = surfaceHolder.getSurfaceFrame().height()/maxY;

                ted = new Ted(getContext()); // добавляем мишку
            }

            canvas = surfaceHolder.lockCanvas(); // закрываем canvas
         //   canvas.setBitmap(bg);
            canvas.drawColor(Color.WHITE);


            ted.draw(paint, canvas); // рисуем мишку
            for (Flower flower : flowers) {
                flower.draw(paint,canvas);
            }
            for (Hill hill: hills) {
                hill.draw(paint, canvas);
            }


            surfaceHolder.unlockCanvasAndPost(canvas); // открываем canvas
        }
    }

    private void control() { // пауза на 17 миллисекунд
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

