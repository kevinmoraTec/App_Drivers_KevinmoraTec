package com.example.tecsicomappdrivers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText etemail,etpassword;
    Button login,registro;

    private String email="";
    private String password="";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
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

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etemail.getText().toString();
                password = etpassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    loginUser();
                }else {
                    Toast .makeText(MainActivity.this,"Complete los Campos",Toast.LENGTH_SHORT).show();
                }
            }
        });
        }

        private void loginUser(){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull  Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(MainActivity.this,Inicio.class));
                        finish();
                    }else {
                        Toast.makeText(MainActivity.this,"No se Pudo Iniciar Seccio Comprueba tus datos",Toast.LENGTH_SHORT).show();

                    }


                }
            });
        }
    }

