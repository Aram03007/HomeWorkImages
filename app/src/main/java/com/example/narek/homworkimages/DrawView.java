package com.example.narek.homworkimages;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by Narek on 4/14/16.
 */
public class DrawView extends View {




    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public  void animateImage(final ImageView imageView, final boolean t) {
        final ValueAnimator animator = ValueAnimator.ofInt(0, 300);


        animator.setDuration(1000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (t) {
                    float x = (float) (getMeasuredWidth() * 0.5 - imageView.getWidth() * 0.7);
                    float y = (float) -(getMeasuredHeight() * 0.5 - imageView.getHeight() * 0.5);
                    imageView.animate().translationXBy(x).translationYBy(y);

                } else {
                    float x = (float) (-getMeasuredWidth() * 0.5 + imageView.getWidth() * 0.7);
                    float y = (float) -(getMeasuredHeight() * 0.5 - imageView.getHeight() * 0.5);
                    imageView.animate().translationXBy((x)).translationYBy(y);
                }


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                imageView.animate().scaleXBy(2);
                imageView.animate().scaleYBy(2);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();



    }

    public void animateImageBack(final ImageView imageView ) {

        ValueAnimator animator = ValueAnimator.ofInt(0, 300);
        animator.setDuration(1000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                imageView.animate().scaleX(1);
                imageView.animate().scaleY(1);


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                imageView.animate().translationX(0).translationY(0);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();




    }







}
