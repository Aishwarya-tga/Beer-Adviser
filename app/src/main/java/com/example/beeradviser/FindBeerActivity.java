package com.example.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;


public class FindBeerActivity extends Activity {
    private final BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

        //call when the button gets clicked
        public void onClickFindBeer(View view){
        //get a reference to the TextView
        TextView brands = findViewById(R.id.brands);
        //get a reference to the Spinner
        Spinner color = findViewById(R.id.color);
        //get a selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());
        //to get recommendations from BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandsList){
            brandsFormatted.append(brand).append('\n');
        }
        //Display the selected item
        brands.setText(brandsFormatted);
    }
}