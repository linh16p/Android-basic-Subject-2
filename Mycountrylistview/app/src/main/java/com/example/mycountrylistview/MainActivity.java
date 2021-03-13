package com.example.mycountrylistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Country> arraylist;
    CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        // khoi tao du lieu mau
        arraylist = new ArrayList<>();
        arraylist.add(new Country("Arbani","1000000",R.drawable.aruba));
        arraylist.add(new Country("Brazil","9000000",R.drawable.australia));
        arraylist.add(new Country("United State","20000000",R.drawable.canada));
        arraylist.add(new Country("Viet Nam","3000000",R.drawable.czechrepublic));
        arraylist.add(new Country("Japan","4000000",R.drawable.china));
        arraylist.add(new Country("Russia","400000",R.drawable.denmark));
        // khoi tao cuxtomArrayAdapter
        customArrayAdapter = new CustomArrayAdapter(MainActivity.this,R.layout.activity_main2,arraylist);
        listView.setAdapter(customArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,arraylist.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}