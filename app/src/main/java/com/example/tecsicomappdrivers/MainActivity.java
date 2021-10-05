package com.example.tecsicomappdrivers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.tecsicomappdrivers.SelectUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    EditText etemail,etpassword;
    Button login,registro;

    private String email="";
    private String password="";

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        etemail=findViewById(R.id.editTextName);
        etpassword=findViewById(R.id.editTextTextPersonName2);
        login=findViewById(R.id.button);
        registro=findViewById(R.id.button2);
        mDatabaseReference= FirebaseDatabase.getInstance().getReference();


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
// para validar el inicio de Seccion del Conductor
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

