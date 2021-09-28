package com.example.tecsicomappdrivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etemail,etpassword;
    Button login,registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etemail=findViewById(R.id.editTextName);
        etpassword=findViewById(R.id.editTextTextPersonName2);
        login=findViewById(R.id.button);
        registro=findViewById(R.id.button2);

        //https://www.youtube.com/watch?v=xwhEHb_AZ6k
        //https://www.youtube.com/watch?v=IEc44_CxoyY
        registro.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registrer.class);
                startActivity(intent);
            }
        });
    }
        
    }
