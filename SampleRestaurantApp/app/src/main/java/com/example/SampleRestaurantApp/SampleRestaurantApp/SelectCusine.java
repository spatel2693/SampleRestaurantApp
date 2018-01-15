package com.example.SampleRestaurantApp.SampleRestaurantApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelectCusine extends AppCompatActivity
{

    RadioGroup cuisine;
    RadioButton cuisine_selected;
    Button selected_cuisine_button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cusine);

        cuisine = (RadioGroup)findViewById(R.id.selected_cuisine_rg);
        selected_cuisine_button =(Button)findViewById(R.id.selected_cuisine_button) ;
        selected_cuisine_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int selected_id = cuisine.getCheckedRadioButtonId();
                // TextView tv = (TextView) findViewById(R.id.text1);


                cuisine_selected = (RadioButton) findViewById(selected_id);
                String radCheck = cuisine_selected.getText().toString();

                Intent t = new Intent(SelectCusine.this, Restaurant_list.class);
                t.putExtra("selected_cuisine", radCheck);
                startActivity(t);


            }
        });
    }
}