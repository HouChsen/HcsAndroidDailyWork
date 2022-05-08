package com.he.week10;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    private int[] imageIds = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
            R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,
            R.drawable.img_7, R.drawable.img_8, R.drawable.img_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView mGridView = (GridView) findViewById(R.id.gridview);
        ImageAdapter imageAdapter = new ImageAdapter(this, imageIds);
        mGridView.setAdapter(imageAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position) {
                    case 1:
                        intent.setClass(GridViewActivity.this, TextBookActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(GridViewActivity.this, TextBookCoontextMenuActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.setClass(GridViewActivity.this, TabHostActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent.setClass(GridViewActivity.this, NewsActivity.class);
                        startActivity(intent);
                        break;

                }
            }

        });
        }
    }



