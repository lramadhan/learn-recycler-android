package com.belajar.mydatapengajar.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.belajar.mydatapengajar.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailPengajarAdapter extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvItemName = findViewById(R.id.tv_item_name);
        TextView tvItemDescription = findViewById(R.id.tv_item_description);
        ImageView tvItemPhoto = findViewById(R.id.img_item_photo);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String photo = getIntent().getStringExtra("photo");

        Glide.with(this)
                .load(photo)
                .into(tvItemPhoto);

        tvItemName.setText(name);
        tvItemDescription.setText(description);
    }

    @Override
    public void onClick(View view) {

    }
}
