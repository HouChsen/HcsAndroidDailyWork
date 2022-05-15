package com.he.week11;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RandomNumActivity extends AppCompatActivity {

    RandomNumService binderService;
    Button randomNumBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_num);
        randomNumBtn=(Button) findViewById(R.id.randomNumBtn);
        randomNumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                List number =binderService.getRandomNumber();
                String str="";
                for(int i=0;i<number.size();i++){
                    str+=(number.get(i).toString()+"");
                }
                TextView randomNumTxt=(TextView)findViewById(R.id.randomNumTxt);
                randomNumTxt.setText(str);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(this,RandomNumService.class);
        bindService(intent,conn,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);
    }

    private ServiceConnection conn =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binderService=((RandomNumService.MyBinder)service).getService();
        }


        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
