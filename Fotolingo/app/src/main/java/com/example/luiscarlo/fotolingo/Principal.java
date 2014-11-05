package com.example.luiscarlo.fotolingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Principal extends Activity implements View.OnClickListener{
    Button btAnterior;
    ImageView foto;
    Button btSiguiente;
    Button btVerReto;
    TextView nombre;
    TextView id_reto;
    TextView calif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btAnterior = (Button) findViewById(R.id.botonAnterior);
        btSiguiente = (Button) findViewById(R.id.botonSiguiente);
        btVerReto = (Button) findViewById(R.id.botonVerReto);
        foto = (ImageView) findViewById(R.id.foto);

        nombre = (TextView) findViewById(R.id.nombre);
        calif =  (TextView) findViewById(R.id.calif);
        id_reto = (TextView) findViewById(R.id.id_reto);
        btVerReto.setOnClickListener(this);
        btSiguiente.setOnClickListener(this);
        btAnterior.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.botonVerReto:
                Intent Reto1 = new Intent("com.example.luiscarlo.fotolingo.Reto1");
                startActivity(Reto1);
                break;
            case R.id.botonSiguiente:
                if (foto.getTag().equals(R.drawable.paisaje2)){
                    foto.setImageResource(R.drawable.paisaje1);
                    foto.setTag(R.drawable.paisaje1);
                    nombre.setText("Luiscarlo Rivera");
                    calif.setText("90%");
                }
                else{
                    foto.setImageResource(R.drawable.paisaje2);
                    foto.setTag(R.drawable.paisaje2);
                    nombre.setText("Daniel Leones");
                    calif.setText("95%");
                }
                break;
            case R.id.botonAnterior:
                if (foto.getTag().equals(R.drawable.paisaje2)){
                    foto.setImageResource(R.drawable.paisaje1);
                    foto.setTag(R.drawable.paisaje1);
                    nombre.setText("Luiscarlo Rivera");
                    calif.setText("90%");

                }
                else{
                    foto.setImageResource(R.drawable.paisaje2);
                    foto.setTag(R.drawable.paisaje2);
                    nombre.setText("Daniel Leones");
                    calif.setText("95%");
                }
                break;
        }
    }
}
