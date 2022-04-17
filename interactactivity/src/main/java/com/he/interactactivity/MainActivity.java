package com.he.interactactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editHello;
    private Button bntSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editHello= (EditText) findViewById(R.id.editHello);
        bntSend= (Button) findViewById(R.id.btnSend);

        bntSend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putInt("num",1);
                bundle.putString("msg",editHello.getText().toString());

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtras(bundle);

                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            Bundle retBundle=data.getExtras();
            String retMsg=retBundle.getString("msg");

            editHello.setText("");
            editHello.setHint("收到回复："+retMsg);
        }
    }
}
