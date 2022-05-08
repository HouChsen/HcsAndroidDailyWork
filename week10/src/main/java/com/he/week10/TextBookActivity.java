package com.he.week10;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.he.week10.R.id.basic;
import static com.he.week10.R.id.fielPathEdt;

public class TextBookActivity extends AppCompatActivity {

    final String FILE_NAME = "memo.txt";
    boolean ischanged = false;

    EditText editFileEdt, filePathEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_book);

        editFileEdt=(EditText)findViewById(R.id.editFileEdt);
        filePathEdt=(EditText)findViewById(R.id.fielPathEdt);

        editFileEdt.addTextChangedListener(textChangedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        int group1=1;
//        int group2=2;
//
//        menu.add(group1,201,1,"打开文件");
//        menu.add(group1,202,2,"保存文件");
//        menu.add(group2,203,3,"退出应用");
//        menu.add(group2,204,4,"关于...");
        SubMenu subMenu=menu.addSubMenu(0,Menu.NONE,Menu.NONE,"文件操作");
        MenuItem openItem=subMenu.add(2,201,1,"打开文件");
        openItem.setIcon(R.drawable.open);
        MenuItem saveItem=subMenu.add(2,202,2,"保存文件");
        saveItem.setIcon(R.drawable.save);

        menu.add(2,203,3,"退出应用");
        menu.add(2,204,4,"关于...");

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 201:
                readFile();
                break;
            case 202:
                writeFile();
                ischanged = false;
                break;
            case 203:
                if(ischanged){
                    AlertDialog.Builder alterDialog =new AlertDialog.Builder(TextBookActivity.this);
                    alterDialog.setTitle("提示").setMessage("文件有改动，是否保存")
                            .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    writeFile();
                                    finish();
                                }
                            }).setNegativeButton("不保存", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).create().show();
                }else{
                    finish();
                    Toast.makeText(TextBookActivity.this,"安全退出",Toast.LENGTH_SHORT).show();

                }
                break;
            case 204:
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(TextBookActivity.this);
                alertDialog.setTitle("提示")
                        .setMessage("通过这个例子，学会各种菜单")
                        .setPositiveButton("确认",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface,int i){

                }

            }).create().show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void writeFile() {
        String str = editFileEdt.getText().toString();
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(str.getBytes());
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
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = fis.read(buff)) > 0) {
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
