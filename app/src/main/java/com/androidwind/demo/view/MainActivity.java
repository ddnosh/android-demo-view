package com.androidwind.demo.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mContainer = findViewById(R.id.container);
//        Button btnView = new Button(this);
//        btnView.setText("addView");
//        btnView.setAllCaps(false);
//        Button btnInflater = new Button(this);
//        btnInflater.setText("Inflater");
//        btnInflater.setAllCaps(false);
//
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        mContainer.addView(btnView, params);
//        mContainer.addView(btnInflater, params);
//
//        FrameLayout.LayoutParams params3 = new FrameLayout.LayoutParams
//                (FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
//        params3.gravity = Gravity.BOTTOM | Gravity.RIGHT;
//        Button bottom = new Button(this);
//        bottom.setGravity(Gravity.RIGHT);
//        bottom.setAllCaps(false);
//        bottom.setText("this is view which added by addContentView");
//        //添加控件
//        addContentView(bottom, params3);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.TOP | Gravity.CENTER;
        final Button bottom = new Button(this);
        bottom.setGravity(Gravity.CENTER);
        bottom.setAllCaps(false);
        bottom.setText("created by addContentView, click to create by setContentView");
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });
        //添加控件
        addContentView(bottom, params);
        //requestLayout -> measure, layout, draw -> onGlobalLayout
        System.out.println("bottom width = " + bottom.getWidth());
        ViewTreeObserver vto2 = bottom.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                System.out.println("after onGlobalLayout -> bottom width = " + bottom.getWidth());
                bottom.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void ReplaceByAddContentView(View view) {
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params1.gravity = Gravity.TOP | Gravity.CENTER;
        params1.setMargins(0, 300, 0, 0);
        TextView tvAddView = new TextView(this);
        tvAddView.setGravity(Gravity.CENTER);
        tvAddView.setText("click to addView");
        tvAddView.setTextColor(Color.parseColor("#0000ff"));
        tvAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddViewActivity.class));
            }
        });
        addContentView(tvAddView, params1);

        FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params2.gravity = Gravity.CENTER;
        TextView tvInflater = new TextView(this);
        tvInflater.setGravity(Gravity.CENTER);
        tvInflater.setText("click to Inflater");
        tvInflater.setTextColor(Color.parseColor("#ff00ff"));
        tvInflater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InflaterActivity.class));
            }
        });
        addContentView(tvInflater, params2);

        FrameLayout.LayoutParams params3 = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params3.gravity = Gravity.BOTTOM | Gravity.CENTER;
        Button btnBottom = new Button(this);
        btnBottom.setGravity(Gravity.CENTER);
        btnBottom.setAllCaps(false);
        btnBottom.setText("Click to replace by [setContentView]");
        btnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });
        addContentView(btnBottom, params3);
    }
}
