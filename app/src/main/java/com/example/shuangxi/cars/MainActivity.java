package com.example.shuangxi.cars;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent toy = new Intent(MainActivity.this, BigImage.class);
                toy.putExtra("imagePosition", position);
                startActivity(toy);
            }
        });

        registerForContextMenu(gridview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo() ;

        switch (item.getItemId()) {
            // if choose show bigger image, we direct to BigImage.activity
            case R.id.showBImage:
                Intent toy = new Intent(MainActivity.this, BigImage.class);
                toy.putExtra("imagePosition", info.position);
                startActivity(toy);
                return true;

            case R.id.GoUrl:
                Intent open_url = new Intent(Intent.ACTION_VIEW);
                open_url.setData(Uri.parse(carURL[info.position]));
                startActivity(open_url);
                return true;

            case R.id.showDealers:
                Intent show_dealer = new Intent(MainActivity.this, carDealer.class);
                show_dealer.putExtra("imagePosition", info.position);
                startActivity(show_dealer);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }


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
