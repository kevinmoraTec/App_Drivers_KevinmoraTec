package com.example.tecsicomappdrivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class Inicio extends AppCompatActivity {

    TextView direccionInicio,direccionFinal;
    Button modificarInicio,modificarDestino;


    private static int AUTOCOMPLETE_REQUEST_CODE = 1;
    private static int TO_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Places.initialize(getApplicationContext(), getString(R.string.places));
        modificarInicio=findViewById(R.id.butonModificar1);
        modificarDestino=findViewById(R.id.butonModificar2);

        modificarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAutocomplete(AUTOCOMPLETE_REQUEST_CODE);
            }
        });

        modificarDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAutocomplete(TO_REQUEST_CODE);
                //https://www.youtube.com/watch?v=cZWSpWwToas
                //9.51
            }
        });



        //Para mapas >>> https://www.youtube.com/watch?v=cZWSpWwToas





    }
    private void startAutocomplete(int requesCode){
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, requesCode);
    }


    private  void autocompleteFrom(){
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);

    }
}