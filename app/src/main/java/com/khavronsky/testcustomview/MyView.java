package com.khavronsky.testcustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {

    final int MIN_WIDTH = 400;
    final int MIN_HEIGHT = 100;
    final int DEFAULT_COLOR = Color.GRAY;
    final int FOCUSED_COLOR = Color.DKGRAY;
    final int DEFAULT_RADIUS = 20;
    final int STROKE_WIDTH = 5;

    private int myWidth;
    private int myHeight;
    private int radius;
    private int margin;

    private int defaultColor;
    private int focusedColor;
    private int focusedCircle;
    private int countCircles;

    private Paint paint;
    final String TAG = "MyView";

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setMinimumWidth(MIN_WIDTH);
        setMinimumHeight(MIN_HEIGHT);
        defaultColor = DEFAULT_COLOR;
        focusedColor = FOCUSED_COLOR;
        radius = DEFAULT_RADIUS;

        margin = 50;
        countCircles = 10;
        focusedCircle = 7;

        paint = new Paint();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        myWidth = getWidth();
        myHeight = getHeight();
    }

    public void setDefaultColor(int defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void setFocusedColor(int focusedColor) {
        this.focusedColor = focusedColor;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        Log.d(TAG, "setRadius: ");
    }

    public void setMargin(int margin) {
        this.margin = margin;
        Log.d(TAG, "setMargin: ");
    }

    public void setFocusedCircle(int focusedCircle) {
        this.focusedCircle = focusedCircle;
        Log.d(TAG, "setFocusedCircle: " + focusedCircle);
    }

    public void setCountOfCircle(int countCircles) {
        this.countCircles = countCircles;
        Log.d(TAG, "setCountOfCircle: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw: ");
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);
        paint.setStrokeWidth(STROKE_WIDTH);

        int firstCircleCoordinate = myWidth / 2 - ((countCircles - 1) / 2) * margin;

        for (int i = 0; i < countCircles; i++) {
            paint.setColor(DEFAULT_COLOR);
            if (i == focusedCircle) {
                paint.setColor(FOCUSED_COLOR);
            }
            canvas.drawCircle(firstCircleCoordinate + i * margin, myHeight / 2, radius, paint);
        }
    }
}