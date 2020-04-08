package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {





//    GsonBuilder builder = new GsonBuilder();
//    Gson gson = builder.create();
//
//    String jsonText = gson.toJson(murzik);
//        Log.i("GSON", jsonText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.qwer);
       // String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);

        String[] sandwichesString = getResources().getStringArray(R.array.sandwich_details);

        List<Sandwich> sandwiches = new ArrayList();




        for (int i = 0; i < sandwichesString.length; i++) {
            Log.i("QWE", sandwichesString[i]);
            Sandwich sandwich = JsonUtils.parseSandwichJson( sandwichesString[i] );
            sandwiches.add(sandwich);
        }



//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, sandwiches);

        // Simplification: Using a ListView instead of a RecyclerView

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RViewAdapter(this, sandwiches));


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                launchDetailActivity(position);
//            }
//        });
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }
}
