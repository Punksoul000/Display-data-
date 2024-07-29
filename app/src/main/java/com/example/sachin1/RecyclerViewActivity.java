package com.example.sachin1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        @SuppressLint("WrongViewCast") RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DataAdapter dataAdapter = new DataAdapter(MainActivity.data);
        recyclerView.setAdapter(dataAdapter);
    }

    private static class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

        private final ArrayList<String[]> data;
        private ViewGroup parent;
        private int viewType;

        DataAdapter(ArrayList<String[]> data) {
            this.data = data;
        }

        private ViewHolder onCreateViewHolder(int viewType, Object o) {
            return null;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            this.parent = parent;
            this.viewType = viewType;
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            this.parent = parent;
            this.viewType = viewType;
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String[] entry = data.get(position);
            holder.textView.setText("Name: " + entry[0] + "\nAge: " + entry[1] + "\nOccupation: " + entry[2] + "\nAddress: " + entry[3]);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;

            ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);
            }
        }
    }
}