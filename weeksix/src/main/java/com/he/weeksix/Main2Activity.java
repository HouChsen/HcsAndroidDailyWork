package com.he.weeksix;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView msgsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //定义和初始化组件并注册事件监听器
        Button toWriteBnt = (Button)findViewById(R.id.toWriteBnt);
        toWriteBnt.setOnClickListener(onClickListener);

        Button backMainBnt = (Button)findViewById(R.id.backMainBnt);
        backMainBnt.setOnClickListener(onClickListener);


        msgsText =(TextView) findViewById(R.id.msgsText);


    }
    //设置事件监听器对象
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.backMainBnt:   //返回
                    finish();
                    break;
                case R.id.toWriteBnt:    //填写信息
                    //创建Intent，指定新启动Activity的信息
                    Intent intent = new Intent(Main2Activity.this, WriteMsgActivity.class);
                    //创建Bundle对象，以便在intent中附加数据
                    Bundle bundle = new Bundle();
                    bundle.putInt("number_count", 12);  //学号长度
                    bundle.putString("teacher_name","贺老师");   //收集者
                    intent.putExtras(bundle);  //将bundle附加到intent对象

                    //启动新Activity，指定请求码为0x11（由设计者自定）
                    startActivityForResult(intent, 0x11);
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {   //结果码resultCode为 Activity.RESULT_OK)
            if (requestCode == 0x11) {    //针对请求码为0x11的请示
                //用Bundle对象取得返回的数据
                Bundle bundle = data.getExtras();
                //将从Bundle对象中取出的数据组合到信息框中
                msgsText.setText(msgsText.getText() + "\n学号：" +
                        bundle.getString("student_no") + "；姓名：" +
                        bundle.getString("student_name") + "\n链接：" +
                        bundle.getString("gitee_addr"));
            }
        }
    }
}
