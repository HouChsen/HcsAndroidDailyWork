package com.he.weeknine;

import android.app.ListActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView1_Activity extends ListActivity {
    private String[] learningSiteArray = {"逸夫图书馆", "承先图书馆", "综合楼", "四教", "五教", "六教"};
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = getListView();
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, learningSiteArray));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ListView1_Activity.this,
                        "您选择了" + learningSiteArray[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
