package com.udacity.sandwichclub;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udacity.sandwichclub.model.Sandwich;

import java.io.Serializable;
import java.util.List;



public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.ViewHolder> {
    private final MainActivity mainActivity;
    private final List<Sandwich> sandwiches;

    RViewAdapter(MainActivity parent, List<Sandwich> items) {
        mainActivity = parent;
        sandwiches = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.idView.setText(sandwiches.get(position).getMainName());
        holder.contentView.setText(sandwiches.get(position).getMainName());
        holder.itemView.setTag(sandwiches.get(position));
        holder.itemView.setOnClickListener(onClickListener);
    }
    @Override
    public int getItemCount() { return sandwiches.size(); }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idView;
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            idView = view.findViewById(R.id.id_text);
            contentView = view.findViewById(R.id.content);
        }
    }

    final private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();



            Sandwich item = (Sandwich) view.getTag();
            Context context = view.getContext();
            Log.i("GSON", gson.toJson(item));
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("ARG_ITEM_NAME", gson.toJson(item));
            //intent.putExtra("ARG_ITEM_Description", item.getDescription());
            context.startActivity(intent);
        }
    };
}
