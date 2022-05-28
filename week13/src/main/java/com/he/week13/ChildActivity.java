package com.he.week13;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        if(NavUtils.getParentActivityName(ChildActivity.this)!=null){
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }
    }
}
