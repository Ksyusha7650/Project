package com.example.game;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
public static boolean isLeftPressed = false; // нажата левая кнопка
public static boolean isRightPressed = false;
    public static boolean isDownPressed = false; // нажата левая кнопка
    public static boolean isUpPressed = false;// нажата правая кнопка {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        GameView gameView = new GameView(this); // создаём gameView

        LinearLayout gameLayout = (LinearLayout) findViewById(R.id.gameLayout); // находим gameLayout
        gameLayout.addView(gameView); // и добавляем в него gameView

        Button leftButton = (Button) findViewById(R.id.left); // находим кнопки
        Button rightButton = (Button) findViewById(R.id.right);
        Button upButton = (Button)findViewById(R.id.up);
        Button downButton = (Button)findViewById(R.id.down);
        TextView sc = (TextView)findViewById(R.id.score);
        sc.setText(GameView.score);



        leftButton.setOnTouchListener(this); // и добавляем этот класс как слушателя (при нажатии сработает onTouch)
        rightButton.setOnTouchListener(this);
        upButton.setOnTouchListener(this); // и добавляем этот класс как слушателя (при нажатии сработает onTouch)
        downButton.setOnTouchListener(this);

    }

    public boolean onTouch(View button, MotionEvent motion) {
        switch(button.getId()) { // определяем какая кнопка
            case R.id.left:
                switch (motion.getAction()) { // определяем нажата или отпущена
                    case MotionEvent.ACTION_DOWN:
                        isLeftPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isLeftPressed = false;
                        break;
                }
                break;
            case R.id.right:
                switch (motion.getAction()) { // определяем нажата или отпущена
                    case MotionEvent.ACTION_DOWN:
                        isRightPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isRightPressed = false;
                        break;
                }
                break;

            case R.id.up:
                switch (motion.getAction()) { // определяем нажата или отпущена
                    case MotionEvent.ACTION_DOWN:
                        isUpPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isUpPressed = false;
                        break;
                }
                break;


            case R.id.down:
                switch (motion.getAction()) { // определяем нажата или отпущена
                    case MotionEvent.ACTION_DOWN:
                        isDownPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isDownPressed = false;
                        break;
                }
                break;
        }
        return true;
    }
}
