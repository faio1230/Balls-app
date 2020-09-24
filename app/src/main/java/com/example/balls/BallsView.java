package com.example.balls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.view.View;

import java.util.LinkedList;

public class BallsView extends View {

    private Paint myPaint = new Paint();
    private LinkedList<Ball> ballList = new LinkedList<Ball>();

    BallsView(Context context){
        super(context);
    }

    public void addBall(Ball ball){
        ballList.add(ball);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(Ball ball : ballList){
            myPaint.setARGB(255,ball.getColorR(),ball.getColorG(),ball.getColorB());
            canvas.drawCircle(ball.getX(),ball.getY(),ball.getRadius(),myPaint);
            ball.ballBehavior();
        }
        //canvas.drawCircle(250,250,20,myPaint);
    }
}
