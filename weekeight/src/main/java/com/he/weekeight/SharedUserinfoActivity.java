package com.he.weekeight;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.FloatRange;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class SharedUserinfoActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText nameEdt;
    private EditText ageEdt;
    private EditText weightEdt;
    private CheckBox marriedCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_userinfo);

        nameEdt=(EditText)findViewById(R.id.nameSpEdt);
        ageEdt=(EditText)findViewById(R.id.ageSpEdt);
        weightEdt=(EditText)findViewById(R.id.weightSpEdt);
        marriedCheck=(CheckBox) findViewById(R.id.marriedSpCheck);

        findViewById(R.id.saveSpBnt).setOnClickListener(OnClickListener);
        findViewById(R.id.browseSpBnt).setOnClickListener(OnClickListener);

        preferences=getSharedPreferences("user_information",MODE_PRIVATE);
        editor=preferences.edit();

    }
    private  final View.OnClickListener OnClickListener=
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(v.getId()){
                        case R.id.saveSpBnt:
                                editor.putString("name",nameEdt
                                .getText().toString());
                                editor.putInt("age",Integer.parseInt(ageEdt.getText().toString()));
                                editor.putFloat("weight",Float.parseFloat((weightEdt.getText().toString())));
                                editor.putBoolean("married",marriedCheck.isChecked());
                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日"+"HH:mm:ss");
                            editor.putString("update_time",sdf.format(new Date()));
                            editor.commit();
                            Toast.makeText(SharedUserinfoActivity.this,"数据已写入共享参数",Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.browseSpBnt:
                            String str="姓名："+preferences.getString("name",null)+"\n年龄："+preferences.getInt("age",0)+"\n体重："+preferences.getFloat("weight",0)+"\n婚否："
                                    +(preferences.getBoolean("married",false)?"是":"否");
                            AlertDialog.Builder alertDialog=new AlertDialog.Builder(SharedUserinfoActivity.this);
                            alertDialog.setTitle("用户信息").setMessage(str).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create().show();
                            nameEdt.setText(preferences.getString("name",""));
                            ageEdt.setText(Integer.toString(preferences.getInt("age",0)));
                            weightEdt.setText(Float.toString(preferences.getFloat("weight",0)));
                            marriedCheck.setChecked(preferences.getBoolean("married" ,false));
                            break;
                    }
                }
            };
}
