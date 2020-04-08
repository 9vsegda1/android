package com.example.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_result);
        textView.setText("Всё, что нам нужно – это "+Phaser.PhaserGen());


    }
    public void onButtonGenClick(View v) {
        textView.setText("Всё, что нам нужно – это "+Phaser.PhaserGen());
    }
    public void onButtonReverseClick(View v) {
        textView.setText(Phaser.PhaserReverse(
                                                (String) textView.getText())
                                                                                    );
    }
}
