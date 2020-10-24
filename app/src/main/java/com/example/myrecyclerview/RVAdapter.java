package com.example.myrecyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonaViewHolder> {


    List<Persona> personas;
    Context context;

    public RVAdapter(List<Persona> personas, Context context) {
        this.personas = personas;
        this.context = context;
    }

    @NonNull
    @Override
    public RVAdapter.PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.persona,parent, false);

        PersonaViewHolder personaViewHolder = new PersonaViewHolder(view);

        return personaViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.PersonaViewHolder holder, int position) {

        holder.nombrePersonaa.setText(personas.get(position).nombre);
        holder.tipoPelicula.setText(personas.get(position).tipo);
        holder.descripcionPelicula.setText(personas.get(position).descripcion);


        Drawable original = context
                .getResources()
                .getDrawable(personas.get(position).foto,null);


        Bitmap originalBitmap =((BitmapDrawable)original).getBitmap();
        RoundedBitmapDrawable roundedBitmapDrawable=RoundedBitmapDrawableFactory.create(context.getResources(),originalBitmap);
        roundedBitmapDrawable.setCircular(true);

        holder.fotoPersona.setImageDrawable(roundedBitmapDrawable);
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public  static  class  PersonaViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView nombrePersonaa;
        TextView tipoPelicula;
        TextView descripcionPelicula;
        ImageView fotoPersona;
       public  PersonaViewHolder(@NonNull View itemView){
           super(itemView);

           cardView = (CardView)itemView.findViewById(R.id.cv);
           nombrePersonaa = (TextView) itemView.findViewById(R.id.nombreePersona);
           descripcionPelicula = (TextView) itemView.findViewById(R.id.tipo);
           tipoPelicula = (TextView) itemView.findViewById(R.id.descripcion);
           fotoPersona = (ImageView) itemView.findViewById(R.id.fotoPersona);
       }


    }
}
