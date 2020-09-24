package com.example.balls;

import java.util.Random;

public class Ball {
    private Random random = new Random();

    private int r;
    private int colorR;
    private int colorG;
    private int colorB;

    private float x = 250;
    private float y = 250;

    private float vecX=5;
    private float vecY=5;

    Ball(){
        r=random.nextInt(15)+15;
        colorR = random.nextInt(256);
        colorG = random.nextInt(256);
        colorB = random.nextInt(256);
        vecX=random.nextInt(20)-10;
        vecY=random.nextInt(20)-10;
    }
    Ball(int radius,int r,int g,int b){
        this.r=radius;
        colorR=r;
        colorB=b;
        colorG=g;
    }
    Ball(float x,float y){
        this.x=x;
        this.y=y;
        r=random.nextInt(15)+15;
        colorR = random.nextInt(256);
        colorG = random.nextInt(256);
        colorB = random.nextInt(256);
        vecX=random.nextInt(20)-10;
        vecY=random.nextInt(20)-10;
    }

    public void ballBehavior(){
        x+=vecX;
        y+=vecY;
        if(x>MainActivity.getWidthSize()){
            vecX*=-1;
            x=MainActivity.getWidthSize()-1;
        }
        if(y>MainActivity.getHeightSize()){
            vecY*=-1;
            y=MainActivity.getHeightSize()-1;
        }
        if(x<0){
            vecX*=-1;
            x=1;
        }
        if(y<0){
            vecY*=-1;
            y=1;
        }
        if(x<MainActivity.getWidthSize()-1&&y<MainActivity.getHeightSize()-1&&x>1&&y>1)addAc();
    }

    public void addAc(){
        this.x -= AcSensor.Inst().getX();
        this.y += AcSensor.Inst().getY();
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public float getRadius(){
        return r;
    }

    public int getColorR(){
        return colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public int getColorB() {
        return colorB;
    }

    private float pointCorrectionY(float x, float y, float afterX, float afterY, int point){
        float a;
        float b;
        a=(afterY-y)/(afterX-x);
        b=y-a*x;
        return a*point+b;
    }
    private float pointCorrectionX(float x, float y, float afterX, float afterY, int point){
        float a;
        float b;
        a=(afterY-y)/(afterX-x);
        b=y-a*x;
        return (point-b)/a;
    }
}
