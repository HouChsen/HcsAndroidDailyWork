package com.he.weekthree4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.textpassword);
        editText2 = (EditText) findViewById(R.id.textid);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String id = "201958501315";
                String password = "123456";
                if (id.equals(editText2.getText().toString()) == false) {
                    Toast.makeText(MainActivity.this, "学号错误", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(editText.getText().toString()) == false) {
                        Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();

                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("msg", editText2.getText().toString());
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);


                    }
                }

            }
        });
    }

    ;
}
