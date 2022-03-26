package com.he.weekfour;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
    //定义显示结果的文本框
    private TextView textReslut;

    //定义单选按钮组
    private RadioGroup radioGroupId;

    //定义复选框按钮
    private CheckBox checkBoxKexing, checkBoxGuoyao, checkBoxKangxinuo;

    //定义开关组件
    private Switch switchMonitorCAll, switchRoomLeaderCall;

    //定义ToggleButton组件
    private ToggleButton toggleButtonWideScreen;

    //定义第1部分的布局对象
    private LinearLayout linearLayoutIDVacccine;

    //定义按钮对象
    private Button buttonShow, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化显示结果的文本框组件
        textReslut = (TextView)findViewById(R.id.textResult);

        //初始化按钮组对象并设置事件监听
        radioGroupId = (RadioGroup)findViewById(R.id.radioGroupId);
        radioGroupId.setOnCheckedChangeListener(radioGroupChangeListener);

        //初始化复选框按钮
        checkBoxKexing = (CheckBox)findViewById(R.id.kexing);
        checkBoxGuoyao = (CheckBox)findViewById(R.id.guoyao);
        checkBoxKangxinuo = (CheckBox)findViewById(R.id.kangxinuo);

        //设置复选框按钮的事件监听
        checkBoxKexing.setOnCheckedChangeListener(checkBoxChangeListener);
        checkBoxGuoyao.setOnCheckedChangeListener(checkBoxChangeListener);
        checkBoxKangxinuo.setOnCheckedChangeListener(checkBoxChangeListener);

        //初始化开关组件
        switchMonitorCAll = (Switch)findViewById(R.id.switchMonitorCall);
        switchRoomLeaderCall = (Switch)findViewById(R.id.switchRoomLeaderCall);

        //注册开关组件的事件监听
        switchMonitorCAll.setOnCheckedChangeListener(switchChangeListener);
        switchRoomLeaderCall.setOnCheckedChangeListener(switchChangeListener);

        //初始化toggleButton组件
        toggleButtonWideScreen =(ToggleButton) findViewById(R.id.toggleButtonWideScreen);

        //注册toggleButton组件的事件监听
        toggleButtonWideScreen.setOnCheckedChangeListener(switchChangeListener);

        //初始化要操作的第一部分的布局对象
        linearLayoutIDVacccine = (LinearLayout)findViewById(R.id.linearLayoutIDVaccine);

        //初始化按钮对象
        buttonShow =(Button) findViewById(R.id.buttonShow);
        buttonClear =(Button) findViewById(R.id.buttonClear);

        //注册按钮组件的事件监听
        buttonShow.setOnClickListener(buttonOnClickListener);
        buttonClear.setOnClickListener(buttonOnClickListener);
    }


    //定义单选按钮改变值的监听事件
    private RadioGroup.OnCheckedChangeListener radioGroupChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {

            //用getCheckedRadioButtonId()获得按钮组中改变的按钮
            int id = radioGroup.getCheckedRadioButtonId();
            //按下不同的按钮，在信息区显示不同的信息
            switch (id) {
                case R.id.radioTeacher:
                    textReslut.setText(R.string.youAreTeacher);
                    break;
                case R.id.radioStudent:
                    textReslut.setText(R.string.youAreStudent);
                    break;
                default:
                    textReslut.setText(R.string.youAreBothNot);
                    break;
            }
        }
    };
    //定义复选框的监听事件对象
    private CompoundButton.OnCheckedChangeListener checkBoxChangeListener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            //获得改变后的复选框
            int id = compoundButton.getId();
            switch (id) {
                case R.id.kexing:
                    if (b) {
                        textReslut.setText(R.string.getKexing);
                    } else {
                        textReslut.setText(R.string.notGetKexing);
                    }
                    break;
                case R.id.guoyao:
                    if (b) {
                        textReslut.setText(R.string.getGuoyao);
                    } else {
                        textReslut.setText(R.string.notGetGuoyao);
                    }
                    break;
                case R.id.kangxinuo:
                    if (b) {
                        textReslut.setText(R.string.getKangxinuo);
                    } else {
                        textReslut.setText(R.string.notGetKangxinuo);
                    }
                    break;
            }
        }
    };
    //定义开关组件的监听事件对象
    private CompoundButton.OnCheckedChangeListener switchChangeListener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            //获得改变后的开关组件
            int id = compoundButton.getId();
            switch (id) {
                case R.id.switchMonitorCall:
                    if (b) {
                        textReslut.setText(R.string.masterAsk);
                    } else {
                        textReslut.setText(R.string.masterNotAsk);
                    }
                    break;
                case R.id.switchRoomLeaderCall:
                    if (b) {
                        textReslut.setText(R.string.roomMasterAsk);
                    } else {
                        textReslut.setText(R.string.roomMasterNotAsk);
                    }
                    break;
                case R.id.toggleButtonWideScreen:
                    if (b) {
                        textReslut.setText(R.string.NarrowScreenSetting);
                        linearLayoutIDVacccine.setOrientation(LinearLayout.VERTICAL);
                        linearLayoutIDVacccine.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
                    } else {
                        textReslut.setText(R.string.WideScreenSetting);
                        linearLayoutIDVacccine.setOrientation(LinearLayout.HORIZONTAL);
                        linearLayoutIDVacccine.setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
                    }
                    break;
            }
        }
    };
    //响应按钮事件的代码
    private View.OnClickListener buttonOnClickListener
            = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.buttonShow:
                    String str = new String(R.string.yourChoice+"\n");

                    str += R.string.no_1+R.string.who;
                    switch (radioGroupId.getCheckedRadioButtonId()) {
                        case R.id.radioTeacher:
                            str += R.string.teacher+R.string.enter;
                            break;
                        case R.id.radioStudent:
                            str += R.string.student+R.string.enter;
                            break;
                        case R.id.radioOthers:
                            str += R.string.otherPeople+R.string.enter;
                            break;
                        default:
                            str += R.string.notChoice+R.string.enter;
                            break;
                    }

                    str += R.string.no_2+R.string.TheVaccineYouHad;
                    String strTemp = new String("");
                    if (checkBoxGuoyao.isChecked())
                        strTemp += R.string.guoyao;
                    if (checkBoxKexing.isChecked())
                        strTemp += R.string.kexing;
                    if (checkBoxKangxinuo.isChecked())
                        strTemp += R.string.kangxinuo;
                    if (strTemp.isEmpty())
                        strTemp += R.string.UnvaccinatedList;
                    str += (strTemp + R.string.enter);

                    str = str + R.string.no_3+R.string.whoAsk;
                    strTemp = new String("");
                    if (switchMonitorCAll.isChecked())
                        strTemp += R.string.master;
                    if (switchRoomLeaderCall.isChecked())
                        strTemp += R.string.roomMaster;
                    if (strTemp.isEmpty())
                        strTemp +=R.string.goodYouth;
                    str += (strTemp + R.string.enter);

                    str = str + R.string.TheCurrentDisplayModeIs;
                    if (toggleButtonWideScreen.isChecked())
                        str += R.string.NarrowScreen;
                    else
                        str += R.string.WideScreem;

                    textReslut.setText(str);

                    break;
                case R.id.buttonClear:
                    radioGroupId.check(-1);
                    checkBoxGuoyao.setChecked(false);
                    checkBoxKexing.setChecked(false);
                    checkBoxKangxinuo.setChecked(false);
                    switchMonitorCAll.setChecked(false);
                    switchRoomLeaderCall.setChecked(false);
                    toggleButtonWideScreen.setChecked(false);
                    textReslut.setText(R.string.notChoice);
                    break;
            }
        }
    };

}

