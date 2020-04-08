package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.text);
        View view = findViewById(R.id.view);


        Cat murzik = new Cat();
        murzik.name = "Мурзик";
        murzik.age = 9;
        murzik.color = Color.CYAN;


        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String jsonText = gson.toJson(murzik);
        Log.i("GSON", jsonText);

        jsonText = "{\"name\":\"Мурзик\",\"color\":-16711681,\"age\":10}";
        murzik = gson.fromJson(jsonText, Cat.class);
        Log.i("GSON", "Имя: " + murzik.name + "\nВозраст: " + murzik.age);

        tv.setText("Имя: " + murzik.name + " Возраст: " + murzik.age);
        view.setBackgroundColor(murzik.color);


    }



}
