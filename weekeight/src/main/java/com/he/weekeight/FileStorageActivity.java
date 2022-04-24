package com.he.weekeight;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStorageActivity extends AppCompatActivity {
    final String FILE_NAME = "memo.txt";
    boolean ischanged = false;
    ImageView openFileBnt, saveFileBnt, exitFileBnt;
    EditText editFileEdt, filePathEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);
        openFileBnt = (ImageView) findViewById(R.id.openFileBnt);
        saveFileBnt = (ImageView) findViewById(R.id.saveFileBnt);
        exitFileBnt = (ImageView) findViewById(R.id.exitFileBnt);
        editFileEdt = (EditText) findViewById(R.id.editFileEdt);
        filePathEdt = (EditText) findViewById(R.id.filePathEdt);
        openFileBnt.setOnClickListener(onClickListener);
        saveFileBnt.setOnClickListener(onClickListener);
        exitFileBnt.setOnClickListener(onClickListener);
        editFileEdt.addTextChangedListener(textChangedListener);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.openFileBnt:
                    readFile();
                    break;
                case R.id.saveFileBnt:
                    writeFile();
                    ischanged = false;
                    break;
                case R.id.exitFileBnt:
                    if (ischanged) {
                        AlertDialog.Builder alterDialog = new AlertDialog.Builder(FileStorageActivity.this);
                        alterDialog.setTitle("提示")
                                .setMessage("文件有改动，是否保存")
                                .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        writeFile();
                                        finish();
                                    }
                                })
                                .setNegativeButton("不保存", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                                .create()
                                .show();
                    } else {
                        finish();
                        Toast.makeText(FileStorageActivity.this, "安全退出",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        }
    };
    private void writeFile() {
        String str = editFileEdt.getText().toString();
        try {//   final String FILE_NAME = "memo.txt";
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(str.getBytes());//String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组。
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readFile() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];//byte在java中是一种是数据类型，代表一个字节，一个字节包含8个位，所以，byte类型的取值范围为-128到127
                                            //byte在文件操作时是必不可少的。不管是对文件写入还是读取都要用到。
            int hasRead = 0;               //对文件进行操作时，一般有两个异常：文件未找到异常和IO异常
            StringBuilder sb = new StringBuilder();
            while ((hasRead = fis.read(buff)) > 0) {//开始读文件，并记录文件中的内容
                sb.append(new String(buff, 0, hasRead));
            }
            fis.close();
            editFileEdt.setText(sb);
            filePathEdt.setText(getFilesDir().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private TextWatcher textChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        @Override
        public void afterTextChanged(Editable editable) {
            ischanged = true;
        }
    };

}
