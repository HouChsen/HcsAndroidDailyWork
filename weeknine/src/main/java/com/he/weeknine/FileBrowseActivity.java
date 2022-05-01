package com.he.weeknine;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileBrowseActivity extends AppCompatActivity {
    private static final String TAG="FileBrowseActivity";
    private final int PERMISSION_REQUEST_CODE = 1;

    ListView listView;
    TextView textView;
    File currentParent=null;
    File[] currentFiles=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_browse);

        listView = (ListView) findViewById(R.id.fileList);
        textView = (TextView) findViewById(R.id.filePath);

        File root = Environment.getExternalStorageDirectory();
        Log.d(TAG,"执行了1");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED){
            Log.d(TAG,"无权限");
            ActivityCompat.requestPermissions(
                    FileBrowseActivity.this, new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);

        }
            if (root.exists()) {
            Log.d(TAG,"执行了if");
            currentParent = root;
            currentFiles = root.listFiles();
            if(currentFiles!=null)
                inflateListView(currentFiles);
            else
                Log.d(TAG,"执行了2");

        }
        else{
            Log.d(TAG,"执行了else");

        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG,"执行了3");

                if (currentFiles[position].isFile())
                    return;
                File[] tmp = currentFiles[position].listFiles();
                if (tmp == null || tmp.length == 0) {
                    Toast.makeText(FileBrowseActivity.this,
                            "当前路径不可访问或该路径下没有文件", Toast.LENGTH_LONG).show();
                } else {
                    currentParent = currentFiles[position];
                    currentFiles = tmp;
                    inflateListView(currentFiles);
                }
                Button parent = (Button) findViewById(R.id.fileParent);
                parent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (!currentParent.getCanonicalPath().equals("/storage/emulated/0")) {
                                currentParent = currentParent.getParentFile();
                                currentFiles = currentParent.listFiles();
                                inflateListView(currentFiles);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//若授权中选择允许（ALLOW）,则使相关按钮变得有效
                    Toast.makeText(this, "你同意授权", Toast.LENGTH_SHORT).show();

//增加
                } else {
//若选择了拒绝，给出提示信息
                    Toast.makeText(this, "你没有同意授权", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void inflateListView(File[] files) {
        Log.d(TAG,"执行了4");

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        Log.d(TAG,"执行了4.1");
        if(files!=null)
            Log.d(TAG,"执行了4.111");
        else{
            Log.d(TAG,"执行了4.222");
            return ;
        }


        for (int i = 0; i < files.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            Log.d(TAG,"执行了4.2");

            if (files[i].isDirectory()) {
                Log.d(TAG,"执行了4.3");

                listItem.put("icon", R.drawable.folder);
            } else {
                listItem.put("icon", R.drawable.file);
                Log.d(TAG,"执行了4.4");

            }
            listItem.put("fileName", files[i].getName());
            listItems.add(listItem);
            Log.d(TAG,files[i].getName());// Android

        }
        Log.d(TAG,"执行了4.5");

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.fileitem,
                new String[]{"icon", "fileName"},
                new int[]{R.id.fileIcon, R.id.file_name});
//        if(simpleAdapter==null)
//        {
//            Log.d(TAG,"执行了null");
//
//        }
//        else
//        {
//            Log.d(TAG,"执行了not null");
//            return ;
//        }
        listView.setAdapter(simpleAdapter);
        Log.d(TAG,"执行了5");

        try {
            textView.setText("当前路径为：" + currentParent.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG,"执行了6");

    }

}