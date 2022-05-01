package com.he.weeknine;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListView2_Activity extends ListActivity {
    private String[] learningSiteArray = {"逸夫图书馆", "承先图书馆", "综合楼", "四教", "五教", "六教"};
    ArrayList arrayList = new ArrayList();
    ListView listView = null;
    EditText addEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2_);
        for (int i = 0; i < learningSiteArray.length; i++) {
            arrayList.add(learningSiteArray[i]);
        }
        listView = getListView();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        setListAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ListView2_Activity.this,
                        "您选择了" + learningSiteArray[position], Toast.LENGTH_LONG)
                        .show();
            }
        });
        addEdt = (EditText) findViewById(R.id.addListView2Edt);
        findViewById(R.id.addListView2Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(addEdt.getText().toString());
                adapter.notifyDataSetInvalidated();
            }
        });
    }
}
