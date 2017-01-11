package com.khavronsky.testcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private MyView myView;
    EditText setRadius,
            setMargin,
            setFocusedCircle,
            setCountOfCircle;
    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

//        myView.setDefaultColor(Color.BLUE);
//        myView.setBackgroundColor(Color.BLACK);
        myView.invalidate();

    }

    private void init() {
        myView = (MyView) findViewById(R.id.myCV1);
        setRadius = (EditText) findViewById(R.id.set_radius);
        setMargin = (EditText) findViewById(R.id.set_margin);
        setFocusedCircle = (EditText) findViewById(R.id.set_focused_circle);
        setCountOfCircle = (EditText) findViewById(R.id.set_count_of_circles);
        okButton = (Button) findViewById(R.id.ok_button);
    }

    public void setAllParameters(View view) {
        int id = view.getId();
        MyView myView = new MyView(this);
        if (id == R.id.ok_button) {
            Log.d("!!!", "setAllParameters: ");
            myView.setRadius(Integer.parseInt(setRadius.getText().toString()));
            myView.setMargin(Integer.parseInt(setMargin.getText().toString()));
            myView.setFocusedCircle(Integer.parseInt(setFocusedCircle.getText().toString()));
            myView.setCountOfCircle(Integer.parseInt(setCountOfCircle.getText().toString()));
            myView.invalidate();
        }
    }
}