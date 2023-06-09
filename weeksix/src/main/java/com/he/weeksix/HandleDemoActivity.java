package com.he.weeksix;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HandleDemoActivity extends AppCompatActivity {

    final int TIME = 60;    //定义时间长度
    final int MSG_CODE = 0x001;    //定义消息代码
    private ProgressBar progressBar;    //声明水平进度条
    private int mProgressStatus = 0;    //定义完成进度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_demo);
        progressBar = (ProgressBar)findViewById(R.id.timer);      //获取进度条组件
        handler.sendEmptyMessage(MSG_CODE);    //发送消息，启动进度条
    }

    //创建Handle控制进度条
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //当前进度大于0
            if (TIME - mProgressStatus > 0) {
                mProgressStatus++;         //进度+1
                progressBar.setProgress(mProgressStatus);            //更新进度条的显示进度
                handler.sendEmptyMessageDelayed(MSG_CODE, 1000);    //延迟一秒发送消息
            } else {
                //提示时间已到
                Toast.makeText(HandleDemoActivity.this, "凝视时间到！", Toast.LENGTH_SHORT).show();
            }
        }
    };
}