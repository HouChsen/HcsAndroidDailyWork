package com.he.activitylifttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private Button btnGo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"执行了onCreate");/**/

        btnGo=(Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,1);
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
