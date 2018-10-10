package com.example.shuangxi.cars;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Map;

public class carDealer extends Activity {

    private static final Map<Integer, String[]> names;
    static
    {
        names = new HashMap<Integer, String[]>();
        names.put(0, new String[]{"Perillo BMW", "BMW Technology Corporation", "Elmhurst BMW"});
        names.put(1, new String[]{"Golf Mill Ford", "Al Piemonte Ford", "Roesch Ford"});
        names.put(2, new String[]{"Continental Honda","Honda On Grand", "North City Honda" });
        names.put(3, new String[]{"The Autobarn City Mazda", "The Autobarn Mazda of Evanston", "Wilkins Mazda"});
        names.put(4, new String[]{"Mercedes-Benz of Chicago", "Mercedes Benz", "Mercedes-Benz of Naperville"});
        names.put(5, new String[]{"Tesla Gallery", "Tesla","Tesla"});
        names.put(6, new String[]{"The Autobarn City Volkswagen", "Volkswagen of Downtown Chicago", "Larry Roesch Volkswagen"});
        names.put(7, new String[]{"Fletcher Jones Audi", "Saab and Audi Best Tech Inc", "Audi Westmont"});
        names.put(8, new String[]{"Land Rover Chicago", "Land Rover Northfield", "Land Rover of Naperville"});
        names.put(9, new String[]{"Grossinger Toyota North", "Midtown Toyota", "Toyota On Western"});
    }


    private static final Map<Integer, String[]> address;
    static
    {
        address = new HashMap<Integer, String[]>();
        address.put(0, new String[]{"1035 N Clark St, Chicago, IL 60610", "540 W Madison St Suite 2400, Chicago, IL 60661","466 W Lake St, Elmhurst, IL 60126"});
        address.put(1, new String[]{"9401 N Milwaukee Ave, Niles, IL 60714", "2500 W North Ave, Melrose Park, IL 60160", "333 W Grand Ave, Bensenville, IL 60106"});
        address.put(2, new String[]{"5901 South La Grange Road, Countryside, IL 60525", "300 W Grand Ave, Elmhurst, IL 60126","6600 N Western Ave, Chicago, IL 60645" });
        address.put(3, new String[]{"3255 N Cicero Ave, Chicago, IL 60641", "1015 Chicago Ave, Evanston, IL 60202", "740 N York St, Elmhurst, IL 60126"});
        address.put(4, new String[]{"1520 W North Ave, Chicago, IL 60642","401 N Michigan, Chicago, IL 60611", "1569 Ogden Ave, Naperville, IL 60540"});
        address.put(5, new String[]{"901 N Rush St, Chicago, IL 60611", "875 N Ellsworth Ave, Villa Park, IL 60181", "58 Oakbrook Center, Oak Brook, IL 60523"});
        address.put(6, new String[]{"5330 W Irving Park Rd, Chicago, IL 60641", "1111 N Clark St, Chicago, IL 60610", "313 W Grand Ave, Bensenville, IL 60106"});
        address.put(7, new String[]{"1523 W North Ave, Chicago, IL 60642", "1419 W Shakespeare Ave, Chicago, IL 60614", "276 E Ogden Ave, Westmont, IL 60559"});
        address.put(8, new String[]{"1924 N Paulina St, Chicago, IL 60622", "670 Frontage Rd, Northfield, IL 60093", "1559 Ogden Ave Suite A, Naperville, IL 60540"});
        address.put(9, new String[]{"7225 N Cicero Ave, Lincolnwood, IL 60712", "2700 N Cicero Ave, Chicago, IL 60639", "6941 S Western Ave, Chicago, IL 60636"});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dealerinfo);

        Intent intent = getIntent();
        final int position = intent.getIntExtra("imagePosition", 0);

        ArrayAdapter adapter_name = new ArrayAdapter<String>(this,
                R.layout.dealerinfo_listview, names.get(position));

        ListView listView_name = (ListView) findViewById(R.id.dealer_name);
        listView_name.setAdapter(adapter_name);

        ArrayAdapter adapter_address = new ArrayAdapter<String>(this,
                R.layout.dealerinfo_listview, address.get(position));

        ListView listView_address = (ListView) findViewById(R.id.dealer_address);
        listView_address.setAdapter(adapter_address);


    }

}
