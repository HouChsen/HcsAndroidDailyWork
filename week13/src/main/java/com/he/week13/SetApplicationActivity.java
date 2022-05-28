package com.he.week13;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetApplicationActivity extends AppCompatActivity {

    private MyApplication app;
    private EditText userNameEdt,orgNameEdt;
    private Button updateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_application);

        app=(MyApplication)getApplication();

        userNameEdt=(EditText)findViewById(R.id.userNameEdt);
        orgNameEdt=(EditText)findViewById(R.id.orgNameEdt);
        updateBtn=(Button)findViewById(R.id.updateBnt);

        userNameEdt.setText(app.getUserName());
        orgNameEdt.setText(app.getOrgName());

        updateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                app.setUserName(userNameEdt.getText().toString());
                app.setOrgName(orgNameEdt.getText().toString());
                //finish();把下面3句删了，把这句注释取消即可
                Intent intent=new Intent();
                intent.setClass(SetApplicationActivity.this,SaveInstanceActivity.class);
                startActivity(intent);
            }
        });
    }
}
