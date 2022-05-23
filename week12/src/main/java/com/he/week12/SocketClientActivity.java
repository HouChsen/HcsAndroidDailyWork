package com.he.week12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientActivity extends AppCompatActivity {


    private TextView chatMassage=null;
    private EditText sendMessage=null;
    private static  final String HOST="192.168.1.106";
    private static final int PORT=29898;
    private Socket socket=null;
    private BufferedReader bufferedReader=null;
    private PrintWriter printWriter=null;
    private  String msg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_client);

        chatMassage=(TextView)findViewById(R.id.chatmessage);
        sendMessage=(EditText)findViewById(R.id.sendmessage);
        new Thread(){
            public void run(){
                try{
                    socket=new Socket(HOST,PORT);
                    bufferedReader=new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    printWriter=new PrintWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(socket.getOutputStream())),true);

                }catch (Exception e){
                    e.printStackTrace();
                }
                super.run();
            }
        }.start();
        ((EditText) findViewById(R.id.sendmessage)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String message=sendMessage.getText().toString();
                Log.d("TAG","将发送1："+message);
                if(socket!=null&&printWriter!=null){
                    printWriter.println(message);
                    printWriter.flush();
                    chatMassage.setText(chatMassage.getText().toString()+"\n"+"发送："+message);
                    sendMessage.setText("");
                }
            }
        });
        new Thread(){
            public void run(){
                while (true){
                    if(socket!=null&&bufferedReader!=null){
                        if(socket.isConnected()){
                            try{
                                if((msg=bufferedReader.readLine())!=null){
                                    Log.d("TAG",msg);
                                    chatMassage.setText(chatMassage.getText().toString()+"\n"+"接受："+msg);
                                }
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();
    }
}
