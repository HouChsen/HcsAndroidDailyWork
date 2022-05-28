package com.he.week13;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.widget.EditText;
import android.widget.TextView;

public class SaveInstanceActivity extends AppCompatActivity {

    private final String GAME_STATE_KEY="gameState";
    private final String GAME_CREDITS_KEY="gameCredits";
    private MyApplication app;
    private TextView global_variable_txt;
    private EditText game_credits_eidt;
    String gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState!=null){
            gameState=savedInstanceState.getString(GAME_CREDITS_KEY);
        }
        setContentView(R.layout.activity_save_instance);

        app=(MyApplication)getApplication();

        global_variable_txt=(TextView)findViewById(R.id.global_variable_txt);
        global_variable_txt.setText("用户姓名："+app.getUserName()+"\n机构名称:"+app.getOrgName());

        game_credits_eidt=(EditText)findViewById(R.id.game_credits_edt);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(GAME_STATE_KEY,gameState);
        outState.putString(GAME_CREDITS_KEY,game_credits_eidt.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        game_credits_eidt.setText(savedInstanceState.getString(GAME_CREDITS_KEY));
    }
}
