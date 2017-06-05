package com.billionman.com.assignment_8_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void sortList(View view) {
        boolean isAsc = false;
        switch (view.getId()) {
            case R.id.asc:
                isAsc = true;
                break;
            case R.id.desc:
                ListView lv = (ListView) findViewById(R.id.months);
                isAsc = false;
                break;
        }
        String data[] = getResources().getStringArray(R.array.months);
        List<String> monthsData = Arrays.asList(data);
        Collections.sort(monthsData);
        if(!isAsc) {
            Collections.reverse(monthsData);
        }
        ArrayAdapter<String> arrD = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,monthsData);
        ListView lv = (ListView) findViewById(R.id.months);
        lv.setAdapter(arrD);
        arrD.notifyDataSetChanged();
    }
}
