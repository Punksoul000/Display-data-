package com.example.sachin1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge, editTextOccupation, editTextAddress;
    private Button buttonAddData, buttonListView, buttonGridView, buttonRecyclerView;

    public static ArrayList<String[]> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextOccupation = findViewById(R.id.editTextOccupation);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonAddData = findViewById(R.id.buttonAddData);
        buttonListView = findViewById(R.id.buttonListView);
        buttonGridView = findViewById(R.id.buttonGridView);
        buttonRecyclerView = findViewById(R.id.buttonRecyclerView);

        buttonAddData.setOnClickListener(v -> {
            String[] newData = {
                    editTextName.getText().toString(),
                    editTextAge.getText().toString(),
                    editTextOccupation.getText().toString(),
                    editTextAddress.getText().toString()
            };
            data.add(newData);
            clearFields();


            });
        buttonListView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        buttonGridView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
            startActivity(intent);
        });

        buttonRecyclerView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
        });
        }

    private void clearFields() {
        editTextName.setText("");
        editTextAge.setText("");
        editTextOccupation.setText("");
        editTextAddress.setText("");
    }
}