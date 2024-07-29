package com.example.sachin1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        int GridView = 0;
        View gridView = findViewById(GridView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getFormattedData());
        gridView.setOnCapturedPointerListener((View.OnCapturedPointerListener) adapter);
    }

    private String[] getFormattedData() {
        String[] formattedData = new String[MainActivity.data.size()];
        for (int i = 0; i < MainActivity.data.size(); i++) {
            String[] entry = MainActivity.data.get(i);
            formattedData[i] = "Name: " + entry[0] + "\nAge: " + entry[1] + "\nOccupation: " + entry[2] + "\nAddress: " + entry[3];
        }
        return formattedData;
    }

    private class GridView {
        public void setAdapter(ArrayAdapter<String> adapter) {

        }
    }
}