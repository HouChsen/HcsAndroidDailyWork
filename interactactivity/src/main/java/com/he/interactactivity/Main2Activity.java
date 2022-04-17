package com.he.interactactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView msg;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        msg=(TextView) findViewById(R.id.receiceMsg);
        btn=(Button) findViewById(R.id.feedbackBtn);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        msg.setText(bundle.getInt("num",0)+";"+bundle.getString("msg"));

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Main2Activity.this,MainActivity.class);
                intent.putExtra("msg","I'm fine, thank you!");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
