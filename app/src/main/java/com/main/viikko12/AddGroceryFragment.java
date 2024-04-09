package com.main.viikko12;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddGroceryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddGroceryFragment extends Fragment {
    private EditText name;

    private EditText note;

    private CheckBox isImportant;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_grocery, container, false);

        Button btnAddCrocery = view.findViewById(R.id.buttonAddGrocery);

        name = view.findViewById(R.id.editGroceryName);
        note = view.findViewById(R.id.editGroceryNote);
        isImportant = view.findViewById(R.id.checkImportant);
        btnAddCrocery.setOnClickListener(listener);
        return view;


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String groceryName = name.getText().toString();
            String groceryNote = note.getText().toString();
            boolean itemIsImportant;

            if (isImportant.isChecked()) {
                itemIsImportant = true;
            } else {
                itemIsImportant = false;
            }

            ListGrocery.getInstance().addGrocery(new Grocery(groceryName, groceryNote, itemIsImportant));

        }
    };
}