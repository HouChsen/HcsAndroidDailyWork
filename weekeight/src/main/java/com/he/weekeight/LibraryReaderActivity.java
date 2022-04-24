package com.he.weekeight;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;

public class LibraryReaderActivity extends AppCompatActivity {
    private EditText readerNumEdt, readerNameEdt, readerPhoneEdt;
    private TextView resultTxt;
    private RadioGroup readerTypeRadioGroup;
    Reader reader = null;
    LibraryDBHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_reader);
        readerNumEdt = (EditText) findViewById(R.id.readerNumEdt);
        readerNameEdt = (EditText) findViewById(R.id.readerNameEdt);
        readerPhoneEdt = (EditText) findViewById(R.id.readerPhoneEdt);
        resultTxt = (TextView) findViewById(R.id.resulteTxt);
        readerTypeRadioGroup = (RadioGroup) findViewById(R.id.readerTypeRadioGroup);
        findViewById(R.id.addReaderBnt).setOnClickListener(OnClickListener);
        findViewById(R.id.deleteReaderBnt).setOnClickListener(OnClickListener);
        findViewById(R.id.updateReaderBnt).setOnClickListener(OnClickListener);
        findViewById(R.id.queryReaderBnt).setOnClickListener(OnClickListener);
    }

    //定义事件监听器
    private View.OnClickListener OnClickListener = new View.OnClickListener() {
        @SuppressLint("Range")
        @Override
        public void onClick(View view) {
            LibraryDBHelper dbHelper = new LibraryDBHelper(getApplicationContext());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd " + "HH:mm:ss");
            switch (view.getId()) {
                case R.id.addReaderBnt:
                    reader = new Reader(readerNumEdt.getText().toString(),
                            readerNameEdt.getText().toString(),
                            getReaderType(),
                            readerPhoneEdt.getText().toString(),
                            null,
                            sdf.format(new Date()).toString());
                    dbHelper.insert_reader(reader);
                    resultTxt.setText("已经插入读者信息");
                    break;
                case R.id.deleteReaderBnt:
                    int delCount = dbHelper.delete_reader(readerNumEdt.getText().toString());
                    resultTxt.setText("已经删除  " + delCount + "名读者数据。");
                    break;
                case R.id.updateReaderBnt:
                    reader = new Reader(readerNumEdt.getText().toString(),
                            readerNameEdt.getText().toString(),
                            getReaderType(),
                            readerPhoneEdt.getText().toString(),
                            null,
                            sdf.format(new Date()).toString());
                    int updateCount = dbHelper.update_reader(reader);
                    resultTxt.setText("已经修改  " + updateCount + "名读者数据。");
                    break;
                case R.id.queryReaderBnt:
                    Cursor cursor = dbHelper.query_reader(readerNumEdt.getText().toString());
                    int count = cursor.getCount();
                    if (count == 0) {
                        resultTxt.setText("查询结果:(空)\n");
                    } else {
                        String str = "";
                        int i = 1;
                        while (cursor.moveToNext()) {
                            Reader reader = new Reader();
                            reader.setReader_number(cursor.getString(cursor.getColumnIndex("reader_number")));
                            reader.setReader_name(cursor.getString(cursor.getColumnIndex("reader_name")));
                            reader.setReader_type(cursor.getString(cursor.getColumnIndex("reader_type")));
                            reader.setReader_phone(cursor.getString(cursor.getColumnIndex("reader_phone")));
                            reader.setReader_password(cursor.getString(cursor.getColumnIndex("reader_password")));
                            reader.setReader_createtime(cursor.getString(cursor.getColumnIndex("reader_createtime")));
                            str = str + i + "." + reader.toString();
                            i++;
                        }
                        resultTxt.setText("查询结果:\n" + str);
                    }
                    break;
            }
        }
    };

    String getReaderType() {
        String readerType = null;
        switch (readerTypeRadioGroup.getCheckedRadioButtonId()) {
            case R.id.underGraduate:
                readerType = "本科生";
                break;
            case R.id.graduate:
                readerType = "研究生";
                break;
            case R.id.teacher:
                readerType = "教职工";
                break;
        }
        return readerType;
    }
}
