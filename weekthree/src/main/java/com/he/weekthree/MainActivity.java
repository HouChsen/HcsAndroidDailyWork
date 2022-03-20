package com.he.weekthree;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;
    private EditText editText;
    private EditText editText2;
    private Button button;
    private LinearLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        editText= (EditText) findViewById(R.id.etext);
        editText2= (EditText) findViewById(R.id.etext2);
        button=(Button) findViewById(R.id.button);
        myLayout=(LinearLayout)findViewById(R.id.linearLayout);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent =new Intent(MainActivity.this,MainPoemActivity.class);
                startActivity(intent);
            }
        });
    }
}
