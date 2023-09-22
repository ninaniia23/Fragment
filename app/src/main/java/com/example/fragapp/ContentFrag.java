package com.example.fragapp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;


public class ContentFrag extends Fragment  {

    private GridView gridview;
    private ImageAdapter imageAdapter;
    private ArrayList<String> imageUrls;

    public ContentFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        gridview = view.findViewById(R.id.gridview);
        return view;
    }

    public void updateContent(int position) {
        // Tạo danh sách các URL hình ảnh dựa vào vị trí
        imageUrls = new ArrayList<>();

        if (position == 0) {
            imageUrls.add("https://images.pexels.com/photos/1366630/pexels-photo-1366630.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/4207475/pexels-photo-4207475.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/136301/pexels-photo-136301.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/1366630/pexels-photo-1366630.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/136301/pexels-photo-136301.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            // Thêm các URL ảnh khác ở đây tương ứng với mục 0
        } else if (position == 1) {
            imageUrls.add("https://images.pexels.com/photos/1216482/pexels-photo-1216482.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/3656870/pexels-photo-3656870.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/2832077/pexels-photo-2832077.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/3656870/pexels-photo-3656870.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/1216482/pexels-photo-1216482.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            // Thêm các URL ảnh khác ở đây tương ứng với mục 1
        } else if (position == 2) {
            imageUrls.add("https://images.pexels.com/photos/323682/pexels-photo-323682.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/718742/pexels-photo-718742.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/699953/pexels-photo-699953.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/410648/pexels-photo-410648.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            imageUrls.add("https://images.pexels.com/photos/410648/pexels-photo-410648.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            // Thêm các URL ảnh khác ở đây tương ứng với mục 2
        }

        imageAdapter = new ImageAdapter(requireContext(), imageUrls);
        gridview.setAdapter(imageAdapter);


    }
}