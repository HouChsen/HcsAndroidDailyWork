package com.he.weekthree2;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //声明内部成员
    private TextView textView;
    private EditText editText;
    private Button button;
    private LinearLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //将内部成员与布局文件中的组件绑定
        textView = (TextView)findViewById(R.id.text);
        editText = (EditText)findViewById(R.id.edit);
        button =(Button) findViewById(R.id.button);
        myLayout =(LinearLayout) findViewById(R.id.linearLayout);

        //设置事件监听，当点击按钮后改变属性
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Update");
                editText.setHint("wait");
                editText.setText("");
                button.setBackgroundColor(Color.CYAN);
                myLayout.setOrientation(LinearLayout.VERTICAL);
                myLayout.setGravity(Gravity.CENTER);
                myLayout.setPadding(20,20,20,20);
            }
        });
    }
}
