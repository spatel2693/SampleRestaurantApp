package com.example.SampleRestaurantApp.SampleRestaurantApp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Menu_list extends AppCompatActivity {
    String[] Dishes;
    ListView list;
    Button selected_item_but;
    String abc ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);


        Intent t = getIntent();
        String cuisine = t.getStringExtra("selected_cuisine");
        String res_name = t.getStringExtra("selected_res");
        Resources res = getResources();
        if (cuisine.equals("Indian"))
        {
            switch (res_name)
            {
                case "Indian Restaurant 1":
                    Dishes = res.getStringArray(R.array.Indian_Res1);
                    break;
                case "Indian Restaurant 2":
                    Dishes = res.getStringArray(R.array.Indian_Res2);
                    break;
                case "Indian Restaurant 3":
                    Dishes = res.getStringArray(R.array.Indian_Res3);
                    break;
                case "Indian Restaurant 4":
                    Dishes = res.getStringArray(R.array.Indian_Res4);
                    break;
                case "Indian Restaurant 5":
                    Dishes = res.getStringArray(R.array.Indian_Res5);
                    break;
            }
        }
        else if (cuisine.equals("Mexican"))
        {
            switch (res_name)
            {
                case "Mexican Restaurant 1":
                    Dishes = res.getStringArray(R.array.Mexican_Res1);
                    break;
                case "Mexican Restaurant 2":
                    Dishes = res.getStringArray(R.array.Mexican_Res2);
                    break;
                case "Mexican Restaurant 3":
                    Dishes = res.getStringArray(R.array.Mexican_Res3);
                    break;
                case "Mexican Restaurant 4":
                    Dishes = res.getStringArray(R.array.Mexican_Res4);
                    break;
                case "Mexican Restaurant 5":
                    Dishes = res.getStringArray(R.array.Mexican_Res5);
                    break;
            }
        }
        else
        {
            switch (res_name)
            {
                case "Italian Restaurant 1":
                    Dishes = res.getStringArray(R.array.Italian_Res1);
                    break;
                case "Italian Restaurant 2":
                    Dishes = res.getStringArray(R.array.Italian_Res2);
                    break;
                case "Italian Restaurant 3":
                    Dishes = res.getStringArray(R.array.Italian_Res3);
                    break;
                case "Italian Restaurant 4":
                    Dishes = res.getStringArray(R.array.Italian_Res4);
                    break;
                case "Italian Restaurant 5":
                    Dishes = res.getStringArray(R.array.Italian_Res5);
                    break;
            }
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, Dishes);
        list = (ListView) findViewById(R.id.item_list);
        list.setAdapter(adapter);

        selected_item_but = (Button)findViewById(R.id.selected_item_button);
        selected_item_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray selected = list.getCheckedItemPositions();


                for(int i= (selected.size()-1) ; i>=0 ;i--) {

                    if (selected.valueAt(i)) {
                        String temp = list.getItemAtPosition(i).toString();

                        abc = abc + "\n" + temp;
                        //.append("\n" + String.valueOf(list.getItemAtPosition(i)));
                    }
                }
                Intent t = new Intent(Menu_list.this,Payment.class);
                t.putExtra("items_selected",abc);
                startActivity(t);
            }
        });



    }
}
