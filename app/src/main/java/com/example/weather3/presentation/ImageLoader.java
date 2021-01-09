package com.example.weather3.presentation;

import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class ImageLoader {
    public static void load(ImageView ownerView, String imageUrl) {
        Glide.with(ownerView.getContext())
                .load(imageUrl)
                .into(ownerView);
    }
}
