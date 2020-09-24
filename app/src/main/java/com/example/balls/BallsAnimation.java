package com.example.balls;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class BallsAnimation extends Animation {

    private BallsView ballsView;

    BallsAnimation(BallsView ballsView){
        this.ballsView = ballsView;
    }

    @Override
    protected void applyTransformation(
            float interpolatedTime, Transformation transformation){
        this.ballsView.requestLayout();
    }
}