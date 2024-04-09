package com.main.viikko12;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListGroceryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListGroceryFragment extends Fragment {

    private RecyclerView recyclerView;

    private ListGrocery listGrocery;

    private RecyclerView.Adapter adapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_grocery, container, false);

        listGrocery = ListGrocery.getInstance();
        recyclerView = view.findViewById(R.id.rvGroceries);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new GroceryViewAdapter(getActivity().getApplicationContext(), listGrocery.getGroceries());
        recyclerView.setAdapter(adapter);
        return view;
    }
}