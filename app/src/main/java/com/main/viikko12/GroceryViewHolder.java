package com.main.viikko12;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder {

    TextView textGroceryName, textGroceryNote, editNote;

    ImageView removeGrocery, editGrocery;
    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        textGroceryName = itemView.findViewById(R.id.textGroceryName);
        textGroceryNote = itemView.findViewById(R.id.textGroceryNote);
        removeGrocery = itemView.findViewById(R.id.imageDelete);
        editGrocery = itemView.findViewById(R.id.imageEdit);
        editNote = itemView.findViewById(R.id.editTextGroceryNote);

    }
}