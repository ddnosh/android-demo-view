package com.androidwind.demo.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class InflaterActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout root;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);

        root = findViewById(R.id.ll_root);
        btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);

        //three ways to invoke inflater
        LayoutInflater getInflater = getLayoutInflater();  //调用Activity的getLayoutInflater()
        LayoutInflater localinflater =  (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        //about: public View inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)
        //about: public View inflate(XmlPullParser parser, @Nullable ViewGroup root)

    }

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = LayoutInflater.from(this);
        root.removeAllViews();
        switch (v.getId()) {
            case R.id.btn_1:
                View view1 = inflater.inflate(R.layout.test, root, true);
                TextView test1 = view1.findViewById(R.id.tv_test);
                test1.setText("bingo!");
                break;
            case R.id.btn_2:
                View view2 = inflater.inflate(R.layout.test, root, false);
                TextView test2 = view2.findViewById(R.id.tv_test);
                test2.setText("bingo!");
                root.addView(view2);
                break;
            case R.id.btn_3:
                View view3 = inflater.inflate(R.layout.test, null, true);
                TextView test3 = view3.findViewById(R.id.tv_test);
                test3.setText("bingo!");
                root.addView(view3);
                break;
            case R.id.btn_4:
                View view4 = inflater.inflate(R.layout.test, null, false);
                TextView test4 = view4.findViewById(R.id.tv_test);
                test4.setText("bingo!");
                root.addView(view4);
                break;
            case R.id.btn_5:
                View view5 = inflater.inflate(R.layout.test, null);
                TextView test5 = view5.findViewById(R.id.tv_test);
                test5.setText("bingo!");
                root.addView(view5);
                break;
            case R.id.btn_6:
                View view6 = inflater.inflate(R.layout.test, root);
                TextView test6 = view6.findViewById(R.id.tv_test);
                test6.setText("bingo!");
                break;
        }
    }
}
