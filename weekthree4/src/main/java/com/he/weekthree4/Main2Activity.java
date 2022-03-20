package com.he.weekthree4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=(TextView) findViewById(R.id.text);
        Intent intent=getIntent();
        String stringCombination = getString(R.string.hy) + intent.getStringExtra("msg")+getString(R.string.tx);
        textView.setText(stringCombination);

        //textView.setText(R.string.hy+intent.getStringExtra("msg")+R.string.tx);
    }
}
