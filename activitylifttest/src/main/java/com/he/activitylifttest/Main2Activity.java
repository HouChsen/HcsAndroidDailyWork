package com.he.activitylifttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG="Main2Activity";
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG,"执行了onCreate");

        btnBack=(Button) findViewById(R.id.btnGo);
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"执行了onStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"执行了onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"执行了onDestriy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"执行了onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"执行了onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"执行了onRestart");

    }

}
