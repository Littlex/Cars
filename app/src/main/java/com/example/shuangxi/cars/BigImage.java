package com.example.shuangxi.cars;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shuangxi.cars.MainActivity;
import com.example.shuangxi.cars.R;


public class BigImage extends AppCompatActivity {

    public ImageView highImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bimage);
        highImage = (ImageView) findViewById(R.id.bigimage);
        Intent intent = getIntent();
        final int position = intent.getIntExtra("imagePosition", 0);
        highImage.setImageResource(mThumbIds[position]);


        highImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_url = new Intent(Intent.ACTION_VIEW);
                open_url.setData(Uri.parse(carURL[position]));
                startActivity(open_url);
            }
        });



    }


    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.bmw_m5, R.drawable.ford_focus,
            R.drawable.honda_civic, R.drawable.mazda3,
            R.drawable.mercedes_benz_cla250, R.drawable.tesla_s,
            R.drawable.volkswagen_gti,
            R.drawable.audi_a3,
            R.drawable.rangerover, R.drawable.toyota_corolla
    };

    private String[] carURL = {
            "https://www.bmwusa.com/vehicles/m-models/m5.html",
            "https://www.ford.com/cars/focus/",
            "https://shop.honda.com/civic-hatchback.aspx?Group=civics",
            "https://www.mazdausa.com/vehicles/mazda3-sedan",
            "https://www.mbusa.com/en/vehicles/model/cla/coupe/cla250c",
            "https://www.tesla.com/models",
            "http://www.vw.com/builder/tab/trim/model/golf-gti/",
            "https://www.audiusa.com/models/audi-a3-sedan",
            "https://www.landroverusa.com/vehicles/range-rover/index.html",
            "https://www.toyota.com/corolla/"
    };


}

