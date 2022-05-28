package com.he.week13;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.PhoneAccount;
import android.view.View;
import android.widget.Button;

public class ParentActivity extends AppCompatActivity {

    Button seekChildBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        setTitle("上一级页面");

        seekChildBtn=(Button)findViewById(R.id.seekChildBnt);
        seekChildBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ParentActivity.this,ChildActivity.class);
                startActivity(intent);
            }
        });
    }
}
