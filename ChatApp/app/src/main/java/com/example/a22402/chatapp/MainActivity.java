package com.example.a22402.chatapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ArrayList<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.menu);
        int []images = {R.drawable.chat, R.drawable.address, R.drawable.share, R.drawable.home};
        list = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("menuItem", images[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.menu_item, new String[]{"menuItem"}, new int[]{R.id.menuItem});
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                ImageView imageView = view.findViewById(R.id.menuItem);
                imageView.setColorFilter(Color.GRAY);
            }
        });
    }
}
