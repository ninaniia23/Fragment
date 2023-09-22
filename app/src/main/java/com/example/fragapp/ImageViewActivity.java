package com.example.fragapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ImageView imageView = findViewById(R.id.image_view);

        // Lấy đường dẫn ảnh từ Intent
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("image_url");

        // Sử dụng Picasso để hiển thị ảnh từ đường dẫn
        Picasso.get().load(imageUrl).into(imageView);
    }
}