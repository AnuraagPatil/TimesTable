package com.example.anuraag.listview;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView listView;

    public void Generate(int timesTable)
    {
        listView = findViewById(R.id.listview);
        final ArrayList<String> listItems= new ArrayList<>();

        for(int i=1;i<=10;i++)
            listItems.add(String.valueOf(i*timesTable));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, listItems.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Times Table");

        SeekBar numberTableSeekBar = findViewById(R.id.seekBar);
        numberTableSeekBar.setMax(20);
        numberTableSeekBar.setProgress(10);

        numberTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                 if(progress < min){
                        timesTable = min;
                 }else{
                       timesTable = progress;
                 }
                 Generate(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Generate(10);
    }
}
