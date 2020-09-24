package com.example.balls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {
    private static int WIDTH,HEIGHT;
    private BallsAnimation ballsAnimation;
    private BallsView ballsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AcSensor.Inst().onCreate(this);
        ballsView = new BallsView(this);
        /*for(int i=0;i<10;i++)*/ballsView.addBall(new Ball());
        setContentView(ballsView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //縦画面固定
        ballsAnimation = new BallsAnimation(ballsView);
    }

    @Override
    protected void onResume(){
        super.onResume();
        AcSensor.Inst().onResume();
        ballsAnimation.setRepeatCount(Animation.INFINITE);
        ballsView.startAnimation(ballsAnimation);
    }

    @Override
    protected void onPause(){
        super.onPause();
        AcSensor.Inst().onPause();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        setDisplaySize(ballsView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getX()<768&&event.getY()<1000) {
            ballsView.addBall(new Ball(event.getX(),event.getY()));
        }
        return true;
    }

    private void setDisplaySize(View view){
        WIDTH = view.getWidth();
        HEIGHT = view.getHeight();
        Log.d("tag","width=" + WIDTH);
        Log.d("tag","height=" + HEIGHT);
    }
    public static int getWidthSize(){
        return WIDTH;
    }
    public static int getHeightSize(){
        return HEIGHT;
    }
}
