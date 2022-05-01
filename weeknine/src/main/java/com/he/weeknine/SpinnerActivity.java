package com.he.weeknine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {

    private String[] learningSiteArray = {"逸夫图书馆",
            "承先图书馆", "综合楼", "四教", "五教", "六教"};
    private String[] playSiteArray;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        resultText = (TextView) findViewById(com.he.weeknine.R.id.sp_result);
    }

    private void intiDropdownSpinner() {
        Spinner sp_dropdown = (Spinner) findViewById(R.id.sp_dropdown);
        sp_dropdown.setPrompt("请选择学习场所");
        ArrayAdapter<String> learningSiteAdapter = new ArrayAdapter<String>(this, R.layout.item_select, learningSiteArray);
        sp_dropdown.setAdapter(learningSiteAdapter);
        sp_dropdown.setSelection(0);
        sp_dropdown.setOnItemSelectedListener(onItemSelectedListener);

    }

    private void intiDialogSpinner() {
        Spinner sp_dialog = (Spinner) findViewById(R.id.sp_dialog);
        sp_dialog.setPrompt("请选择运动场所");
        ArrayAdapter<String> palySiteAdapter = new ArrayAdapter<String>(this, R.layout.item_select, playSiteArray);
        sp_dialog.setAdapter(palySiteAdapter);
        sp_dialog.setOnItemSelectedListener(onItemSelectedListener);
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    switch (adapterView.getId()) {
                        case R.id.sp_dropdown:
                            resultText.setText("学习在" + learningSiteArray[position]);
                            break;
                        case R.id.sp_dialog:
                            resultText.setText("运动在" + playSiteArray[position]);
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            };
}