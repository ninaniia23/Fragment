package com.example.fragapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements MenuFrag.IFragmentClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.ContentFrag, new ContentFrag())
//                    .add(R.id.MenuFrag, new MenuFrag())
//                    .commit();
//        }
    }

    @Override
    public void onMenuItemClick(int position) {
        ContentFrag contentFrag = (ContentFrag) getSupportFragmentManager().findFragmentById(R.id.ContentFrag);
        if (contentFrag != null) {
            contentFrag.updateContent(position);
        }
    }
}
