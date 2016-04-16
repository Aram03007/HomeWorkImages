package com.example.narek.homworkimages;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by Narek on 4/14/16.
 */
public class DrawView extends View {


    private static final String TAG = "tag";

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    public  void animateImage(final ImageView imageView, final boolean t) {


        float x, y;
        x = (float) (getMeasuredWidth() * 0.5 - imageView.getWidth() * 0.5);
        y = (float) (getMeasuredHeight() * 0.5 - imageView.getHeight() * 0.5);


        Log.d(TAG, "animateImage() called with: " + "imageView = [" + imageView + "], t = [" + t + "]");



        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(imageView, "scaleX", imageView.getScaleX(), 2 * imageView.getScaleX());
        scaleXAnimator.setStartDelay(300);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imageView, "scaleY", imageView.getScaleY(), 2 * imageView.getScaleY());
        scaleYAnimator.setStartDelay(300);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .play(ObjectAnimator.ofFloat(imageView, "x", imageView.getX(), x))
                .with(ObjectAnimator.ofFloat(imageView, "y", imageView.getY(), y))
                .before(scaleXAnimator)
                .before(scaleYAnimator);
        animatorSet.start();



    }

    public void animateImageBack(final ImageView imageView ) {


        ObjectAnimator translateXAnimator = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getTranslationX(), 0);
        translateXAnimator.setStartDelay(300);
        ObjectAnimator translateYAnimator = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 0);
        translateYAnimator.setStartDelay(300);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .play(ObjectAnimator.ofFloat(imageView, "scaleX", imageView.getScaleX(), imageView.getScaleX() / 2))
                .with(ObjectAnimator.ofFloat(imageView, "scaleY", imageView.getScaleY(), imageView.getScaleY() / 2))
                .before(translateXAnimator)
                .before(translateYAnimator);

        animatorSet.start();






    }







}
