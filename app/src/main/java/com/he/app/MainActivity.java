package com.he.app;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button clickBtn;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText=(TextView) findViewById(R.id.showText);
        clickBtn =(Button) findViewById(R.id.clickBtn);

        showText.setOnClickListener(onClickListener);
        clickBtn.setOnClickListener(onClickListener);
//        clickBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"按钮被点了！！！",Toast.LENGTH_LONG).show();
//            }
//        });
//        showText.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Toast.makeText(MainActivity.this,"文本框被点了！！！",Toast.LENGTH_LONG).show();
//            }
//        });
    }
    private View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.showText:
                    Toast.makeText(MainActivity.this,"文本框被点了！！！",Toast.LENGTH_LONG).show();
                case R.id.clickBtn:
                    Toast.makeText(MainActivity.this,"按钮被点了！！！",Toast.LENGTH_LONG).show();
            }
        }
    };



}
