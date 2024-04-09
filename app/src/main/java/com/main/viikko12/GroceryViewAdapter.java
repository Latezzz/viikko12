package com.main.viikko12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryViewAdapter extends RecyclerView.Adapter<GroceryViewHolder> {
    private ArrayList<Grocery> groceries = new ArrayList<>();
    private Context context;


    public GroceryViewAdapter(Context context, ArrayList<Grocery> groceries) {
        this.groceries = groceries;
        this.context = context;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroceryViewHolder(LayoutInflater.from(context).inflate(R.layout.grocery_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        holder.textGroceryName.setText(groceries.get(position).getName());
        holder.textGroceryNote.setText(groceries.get(position).getNote());

        holder.removeGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                ListGrocery.getInstance().removeGrocery(groceries.get(pos).getName());
                notifyItemRemoved(pos);
            }
        });

        holder.editGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if (holder.editNote.getVisibility() == View.VISIBLE) {
                    Grocery grocery = ListGrocery.getInstance().getGroceryByName(groceries.get(pos).getName());
                    grocery.setNote(holder.editNote.getText().toString());
                    holder.editNote.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    holder.editNote.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }
}
