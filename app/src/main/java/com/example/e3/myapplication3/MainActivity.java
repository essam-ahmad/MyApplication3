package com.example.e3.myapplication3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstview = (ListView) findViewById(R.id.listview);
        // Inflate header view
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.headre, lstview, false);
        // Add header view to the ListView
        lstview.addHeaderView(headerView);
        // Get the string array defined in strings.xml file
        String[] items = getResources().getStringArray(R.array.list_items);
        // Create an adapter to bind data to the ListView
        lstAdapter adapter = new lstAdapter(this, R.layout.rowlayout, R.id.txtname, items);
        // Bind data to the ListView
        lstview.setAdapter(adapter);
    }
}
