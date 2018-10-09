package com.example.shuangxi.cars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//        if (convertView == null) {
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(500, 500)); // origin 85
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
//        } else {
//            imageView = (ImageView) convertView;
//        }
//
//        imageView.setImageResource(mThumbIds[position]);
//        return imageView;

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_car, null);
        }

        // 3
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_car_name);


        // 4
        imageView.setImageResource(mThumbIds[position]);
        nameTextView.setText(carName[position]);


        return convertView;







    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.bmw_m5, R.drawable.ford_focus,
            R.drawable.honda_civic, R.drawable.rsz_mazda3,
            R.drawable.mercedes_benz_cla250, R.drawable.rsz_tesla_s,
            R.drawable.rsz_1rsz_volkswagen_gti,
            R.drawable.rsz_1audi_a3,
            R.drawable.rangerover, R.drawable.toyota_corolla
    };


    private String[] carName = {
           "BMW m5" , "Ford focus",
            "Honda civic", "Mazda 3",
            "Mercedes Benz cla250", "Tesla S",
            "Volkswagen GTI", "Audi A3",
            "RangeRover", "Toyota corolla"
    };
}