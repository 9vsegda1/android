package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

////        int position = intent.getIntExtra("ARG_ITEM_NAME", DEFAULT_POSITION);
//        if (position == DEFAULT_POSITION) {
//            // EXTRA_POSITION not found in intent
//            closeOnError();
//            return;
//        }

        String sandwichStr = intent.getStringExtra("ARG_ITEM_NAME");
//        if (sandwichStr == "") {
//            // EXTRA_POSITION not found in intent
//            closeOnError();
//            return;
//        }
        Log.i("ASDF", sandwichStr);



//        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
//
//        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(sandwichStr);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        TextView also_known_tv = findViewById(R.id.also_known_tv);
        TextView ingredients_tv = findViewById(R.id.ingredients_tv);
        TextView origin_tv = findViewById(R.id.origin_tv);
        TextView description_tv = findViewById(R.id.description_tv);
                also_known_tv.setText(sandwich.getAlsoKnownAs().toString());
        ingredients_tv.setText(sandwich.getIngredients().toString());
        origin_tv.setText(sandwich.getPlaceOfOrigin());
        description_tv.setText(sandwich.getDescription());

        populateUI();
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());


    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI() {

    }
}
