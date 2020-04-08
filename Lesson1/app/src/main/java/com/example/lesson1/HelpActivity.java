package com.example.lesson1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {
    private TextView textViewLiters;
    private TextView textViewGalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button buttonClose = (Button)findViewById(R.id.button__close);

        setContentView(R.layout.help_activity);
        textViewLiters = findViewById(R.id.help_text_liters);
        textViewGalon = findViewById(R.id.help_text_galon);
        textViewLiters.setText(getIntent().getExtras().getString("liters"));
        textViewGalon.setText(getIntent().getExtras().getString("gallons"));

//        buttonClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    textViewLiters.setText(getIntent().getExtras().getString("gallons"));
//                } catch (Exception e) {                }
//            }
//        });

    }
    public void onButtonCloseClick(View v) {
        this.finish();
    }
}


//                                                   Intent intent = new Intent(MainActivity.this, HelpActivity.class);
//                                                   intent.putExtra("liters", String.valueOf(liters));
//                                                   intent.putExtra("gallons", String.valueOf(gallons));
//                                                   startActivity(intent);finish();
