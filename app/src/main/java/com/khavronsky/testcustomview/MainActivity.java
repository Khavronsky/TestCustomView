package com.khavronsky.testcustomview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (MyView) findViewById(R.id.myCV1);

        myView.setDefaultColor(Color.BLUE);
        myView.setBackgroundColor(Color.BLACK);
        myView.invalidate();

    }
}
