package com.example.lesson4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailActivity extends AppCompatActivity {

    TextView td_id;
    TextView td_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        String id = intent.getStringExtra("ARG_ITEM_ID");
        String details = intent.getStringExtra("ARG_ITEM_details");
        td_id = findViewById(R.id.td_id);

        td_id = findViewById(R.id.td_id);
        td_desc = findViewById(R.id.td_desc);

        td_id.setText(id);
        td_desc.setText(details);
    }
}
