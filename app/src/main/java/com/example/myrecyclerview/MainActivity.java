package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Persona> personas;
    private RatingBar rating;

    private  void initializarDatos(){
        personas = new ArrayList<>();

        personas.add(new Persona("SNIPER3","Shooter","Sniper Ghost Warrior 3 es un shooter táctico en primera persona desarrollado por CI Games",R.drawable.juego1));
        personas.add(new Persona("BATTELFIELD","Shooter","es una serie de videojuegos de guerra en primera persona aunque también puede ponerse en tercera persona",R.drawable.juego2));
        personas.add(new Persona("SPIDERMAN","Aventure"," es un videojuego de acción y aventura basado en el popular superhéroe hómonimo de la editorial Marvel Comics",R.drawable.juego3));
        personas.add(new Persona("MONKER ISLAND","Aventurw","es una saga de videojuegos de aventura gráfica producida y publicada por LucasArts,",R.drawable.juego4));
        personas.add(new Persona("DRAGON BALL Z","Fight","¡Patea, golpea, pelea, y libera poderes especiales del comic y la serie de TV",R.drawable.juego5));
        personas.add(new Persona("GALAXIA","Aventure","Classic genera la mejor sensación nostálgica de juego arcade de una época donde reinaban los reflejos",R.drawable.juego6));
        personas.add(new Persona("READ DEAD REDEMPTION","Aventure","Red Dead Redemption es un videojuego no lineal de acción-aventura western desarrollado por Rockstar San Diego",R.drawable.juego7));
        personas.add(new Persona("ABU SIMBEL","Aventure","Profanation es un videojuego desarrollado y distribuido por Dinamic Software ",R.drawable.juego8));
        personas.add(new Persona("MASS EFECT","Shooter","es una franquicia de medios de ciencia ficción militar creada por Preston Watamaniuk",R.drawable.juego9));
        personas.add(new Persona("WATCH DOGS","Arcade","es una serie de juegos de acción y aventuras desarrollados y publicados por Ubisoft",R.drawable.juego10));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(linearLayoutManager);

       /* rating =(RatingBar)findViewById(R.id.ratingBar3);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this,"Usted Califico la pelicula con "+rating,Toast.LENGTH_LONG);
            }
        });*/


        initializarDatos();
        RVAdapter rvAdapter = new RVAdapter(personas,getApplicationContext());
        recyclerView.setAdapter(rvAdapter);

    }



}