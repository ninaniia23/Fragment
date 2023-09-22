package com.example.fragapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Arrays;



public class MenuFrag extends Fragment {


    private String[] menus = {"Flowers", "Animals", "Foods"};
    private IFragmentClickListener itemfragment;
    private ListView list;

    public  MenuFrag(){

    }

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        try {
            itemfragment = (IFragmentClickListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        list = view.findViewById(R.id.list);
        ArrayAdapter<String> listadapter = new ArrayAdapter<>(view.getContext(), R.layout.menu_layout, new ArrayList<>(Arrays.asList(menus)));
        list.setAdapter(listadapter);
        list.setOnItemClickListener((parent, view1, position, id) -> {
            if (itemfragment != null) {
                itemfragment.onMenuItemClick(position);
            }
        });
        return view;
    }

    public interface IFragmentClickListener {
        void onMenuItemClick(int position);
    }
}