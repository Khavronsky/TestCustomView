package com.khavronsky.testcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {

    private static final int DEFAULT_MARGIN = 0;
    private static final int MIN_WIDTH = 400;
    private static final int MIN_HEIGHT = 100;
    private static final int DEFAULT_COLOR = Color.GRAY;
    private static final int DEFAULT_FOCUSED_COLOR = Color.DKGRAY;
    private static final int DEFAULT_RADIUS = 20;
    private static final int DEFAULT_COUNT_OF_CIRCLE = 1;
    private static final int DEFAULT_FOCUSED_CIRCLE = 0;

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
        Log.d(TAG, "MyView: 1");
        init(null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyView: 2");

        init(attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.d(TAG, "MyView: 3");
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setMinimumWidth(MIN_WIDTH);
        setMinimumHeight(MIN_HEIGHT);
//        defaultColor = DEFAULT_COLOR;
//        focusedColor = DEFAULT_FOCUSED_COLOR;
//        radius = DEFAULT_RADIUS;
//
//        margin = 50;
//        countCircles = 10;
//        focusedCircle = 7;
        setupAttributes(attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }
    private void setupAttributes(AttributeSet attrs){

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyView);

        radius = (int) a.getDimension(R.styleable.MyView_radius, DEFAULT_RADIUS);
        margin = (int) a.getDimension(R.styleable.MyView_margin, DEFAULT_MARGIN);
        countCircles = a.getInt(R.styleable.MyView_countCircles, DEFAULT_COUNT_OF_CIRCLE);
        focusedCircle = a.getInt(R.styleable.MyView_focusedCircle, DEFAULT_FOCUSED_CIRCLE);
        defaultColor = a.getColor(R.styleable.MyView_defaultColor, DEFAULT_COLOR);
        focusedColor = a.getColor(R.styleable.MyView_focusedColor, DEFAULT_FOCUSED_COLOR);
        a.recycle();
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

        int firstCircleCoordinate;
        int oddOrEven = countCircles;
        if ((oddOrEven %= 2) != 0) {

            firstCircleCoordinate = myWidth / 2 - ((countCircles - 1) / 2) * margin;
        } else {
            firstCircleCoordinate = myWidth / 2 - ((countCircles) / 2) * margin + margin / 2;
        }

        for (int i = 0; i < countCircles; i++) {
            paint.setColor(defaultColor);
            if (i == focusedCircle) {
                paint.setColor(focusedColor);
            }
            canvas.drawCircle(firstCircleCoordinate + i * margin, myHeight / 2, radius, paint);
        }
    }
}