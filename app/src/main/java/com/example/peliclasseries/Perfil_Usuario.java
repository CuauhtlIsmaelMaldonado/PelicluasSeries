package com.example.peliclasseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Perfil_Usuario extends AppCompatActivity {

    TextView nombrep;
    CardView cardConsulPeliculas,cardConsulSeries;

    RequestQueue requestQueue;

    /// para perfil ///
    String nombre = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        nombre = getIntent().getStringExtra("nombre");

        requestQueue = Volley.newRequestQueue(this);

        nombrep=findViewById(R.id.nombre);

        nombrep.setText(nombre);

        cardConsulPeliculas = findViewById(R.id.cardConsulPeliculas);
        cardConsulSeries= findViewById(R.id.cardConsulSeries);


        cardConsulPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                peliculas();
            }
        });

        cardConsulSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                series();

            }
        });

    }

    public void peliculas (){

        RequestQueue requestQueue = Volley.newRequestQueue(Perfil_Usuario.this);
        String url="";




        Intent intent = new Intent(this,Peliculas.class);

        startActivity(intent);

        overridePendingTransition(R.transition.in_left, R.transition.out_left);

    }

    public void series(){

        RequestQueue requestQueue = Volley.newRequestQueue(Perfil_Usuario.this);
        String url="";


        Intent intent = new Intent(this,Series.class);

        startActivity(intent);

        overridePendingTransition(R.transition.in_left, R.transition.out_left);

    }

}