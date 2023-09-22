package com.example.fragapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> imageUrls;

    public ImageAdapter(Context context, ArrayList<String> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return imageUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_layout, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_item_image);
        String imageUrl = imageUrls.get(position);

        // Sử dụng Picasso để tải và hiển thị hình ảnh
        Picasso.get().load(imageUrl).into(imageView);

        // Thêm sự kiện click vào ảnh
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo Intent để chuyển đến Activity mới (ImageViewActivity)
                Intent intent = new Intent(context, ImageViewActivity.class);

                // Truyền đường dẫn của ảnh đã chọn đến ImageViewActivity
                intent.putExtra("image_url", imageUrl);

                // Bắt đầu ImageViewActivity
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}