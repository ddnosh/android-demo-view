package com.androidwind.demo.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class AddViewActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout root;
    private Button btn1, btn2, btn3, btn4;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addview);

        root = findViewById(R.id.ll_root);
        btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                TextView tv1 = new TextView(this);
                tv1.setBackgroundColor(Color.RED);
                tv1.setText("this is added by addView(View child)");
                //if (params == null), use the default LayoutParams
                // protected LayoutParams generateDefaultLayoutParams() {
                //    if (mOrientation == HORIZONTAL) {
                //        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                //    } else if (mOrientation == VERTICAL) {
                //        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                //    }
                //    return null;
                //}
                root.addView(tv1);
                break;
            case R.id.btn_2:
                tv2 = new TextView(this);
                tv2.setBackgroundColor(Color.BLUE);
                tv2.setTextColor(Color.WHITE);
                tv2.setText("this is added by addView(View child, LayoutParams params) with LinearLayout");
                tv2.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 500);
                //the params is relative to the father layout, here is LinearLayout(id:ll_root)
                params1.setMargins(100, 50, 100, 50);
                root.addView(tv2, params1);
                break;
            case R.id.btn_3:
//                root.removeView(tv2);
                root.removeAllViews();
                break;
            case R.id.btn_4:
                RelativeLayout rl = new RelativeLayout(this);
                TextView temp1 = new TextView(this);
                temp1.setId(1);
                temp1.setText("Pictures");
                rl.addView(temp1);
                TextView temp2 = new TextView(this);
                temp2.setText("Characters");
                temp2.setId(2);
                RelativeLayout.LayoutParams param1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                param1.addRule(RelativeLayout.BELOW, 1);//此控件在id为1的控件的下边
                rl.addView(temp2, param1);
                root.addView(rl);
                break;
        }
    }
}
