package com.he.weeknine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListView3_Activity extends AppCompatActivity {
    private String[] learningSiteArray = {"逸夫图书馆", "承先图书馆", "综合楼", "四教", "五教", "六教"};

   // private ArrayList<String> learningSiteArray = new ArrayList<String>();
    ArrayList arrayList = new ArrayList();
    ListView listView = null;
    EditText addEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3_);
        for (int i = 0; i < learningSiteArray.length; i++) {
            arrayList.add(learningSiteArray[i]);
        }

        listView = (ListView) findViewById(R.id.listview3);
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ListView3_Activity.this,
                        "您选择了" + arrayList.get(position), Toast.LENGTH_LONG)
                        .show();
            }
        });
        addEdt = (EditText) findViewById(R.id.addListView3Edt);
        findViewById(R.id.addListView3Bnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(addEdt.getText().toString());
                adapter.notifyDataSetInvalidated();
                addEdt.setText("");

            }
        });
    }
}
