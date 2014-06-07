package com.semoncat.fragmenttransanim;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/**
 * Created by SemonCat on 2014/6/7.
 */
public class AnimFrameLayout extends FrameLayout {

    private static final String TAG = AnimFrameLayout.class.getName();

    private float yFraction = 0;
    private float xFraction = 0;

    public AnimFrameLayout(Context context) {
        super(context);
    }

    public AnimFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    private ViewTreeObserver.OnPreDrawListener preDrawListener = null;

    public void setYFraction(float fraction) {
        this.yFraction = fraction;
        if (getHeight() == 0) {
            if (preDrawListener == null) {
                preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        getViewTreeObserver().removeOnPreDrawListener(preDrawListener);
                        setYFraction(yFraction);
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(preDrawListener);
            }
            return;
        }
        float translationY = getHeight() * fraction;
        setTranslationY(translationY);
    }


    public void setXFraction(float fraction) {
        this.xFraction = fraction;
        if (getWidth() == 0) {
            if (preDrawListener == null) {
                preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        getViewTreeObserver().removeOnPreDrawListener(preDrawListener);
                        setXFraction(xFraction);
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(preDrawListener);
            }
            return;
        }
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
    }


    public void setGlide(float fraction) {
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
        setRotationY(90 * fraction);
        setPivotX(0);
    }

    public void setGlideBack(float fraction) {
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
        setRotationY(90 * fraction);
        setPivotX(0);
        setPivotY(getHeight() / 2);
    }

    public void setCube(float fraction) {
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
        setRotationY(90 * fraction);
        setPivotX(0);
        setPivotY(getHeight() / 2);
    }

    public void setCubeBack(float fraction) {
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
        setRotationY(90 * fraction);
        setPivotY(getHeight() / 2);
        setPivotX(getWidth());
    }

    public void setRotateDown(float fraction) {
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
        setRotation(20 * fraction);
        setPivotY(getHeight());
        setPivotX(getWidth() / 2);
    }

    public void setRotateUp(float fraction) {
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
        setRotation(-20 * fraction);
        setPivotY(0);
        setPivotX(getWidth() / 2);
    }

    public void setAccordionPivotZero(float fraction) {
        setScaleX(fraction);
        setPivotX(0);
    }

    public void setAccordionPivotWidth(float fraction) {
        setScaleX(fraction);
        setPivotX(getWidth());
    }

    public void setTableHorizontalPivotZero(float fraction) {
        setRotationY(90 * fraction);
        setPivotX(0);
        setPivotY(getHeight() / 2);
    }

    public void setTableHorizontalPivotWidth(float fraction) {
        setRotationY(-90 * fraction);
        setPivotX(getWidth());
        setPivotY(getHeight() / 2);
    }

    public void setTableVerticalPivotZero(float fraction) {
        setRotationX(-90 * fraction);
        setPivotX(getWidth() / 2);
        setPivotY(0);
    }

    public void setTableVerticalPivotWidth(float fraction) {
        setRotationX(90 * fraction);
        setPivotX(getWidth() / 2);
        setPivotY(getHeight());
    }

}
