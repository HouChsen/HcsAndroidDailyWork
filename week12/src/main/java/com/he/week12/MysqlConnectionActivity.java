package com.he.week12;

import android.icu.text.SimpleDateFormat;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnectionActivity extends AppCompatActivity {

    private EditText readerNumEdt,readerNameEdt,readerPhoneEdt;
    private TextView resultTxt;
    private RadioGroup readerTypeRadioGroup;

    Reader reader=null;

    private Handler handle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 0x11:
                    String s=(String )msg.obj;
                    resultTxt.setText(s);
                    break;
                case 0x12:
                    String ss=(String )msg.obj;
                    resultTxt.setText(ss);
                    break;
            }
            //super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysql_connection);

        readerNumEdt=(EditText)findViewById(R.id.readerNumEdt);
        readerNameEdt=(EditText)findViewById(R.id.readerNameEdt);
        readerPhoneEdt=(EditText)findViewById(R.id.readerPhoneEdt);
        resultTxt=(TextView)findViewById(R.id.resulteTxt);
        readerTypeRadioGroup=(RadioGroup)findViewById(R.id.readerTypeRadioGroup);
        findViewById(R.id.queryReaderBnt).setOnClickListener(onClickListener);
    }
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Message message = handle.obtainMessage();
            message.what = 0x11;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd" + "HH:mm:ss");
            switch (v.getId()) {
                case R.id.queryReaderBnt:
                    new Thread((new Runnable() {
                        @Override
                        public void run() {
                            ResultSet res = DBUtils.queryReader(readerNumEdt.getText().toString());
                            String str = "";
                            int i = 1;
                            try {
                                while (res.next()) {
                                    Reader reader = new Reader();
                                    reader.setReader_number(res.getString("reader_number"));
                                    reader.setReader_name(res.getString("reader_name"));
                                    reader.setReader_type(res.getString("reader_type"));
                                    reader.setReader_phone(res.getString("reader_phone"));
                                    reader.setReader_password(res.getString("reader_password"));
                                    reader.setReader_createtime(String.valueOf(res.getDate("reader_number")));
                                    str = str + i + "." + reader.toString();
                                    i++;

                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            if (str != "") {
                                message.what = 0x12;
                                message.obj = "查询结果:\n" + str;
                            } else {
                                message.obj = "查询结果为空";
                            }
                            handle.sendMessage(message);
                        }
                    })).start();
                    break;
            }
        }
    };
}
