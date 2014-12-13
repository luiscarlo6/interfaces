package com.example.luiscarlo.fotolingo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class PrincipalReto3 extends Activity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {
    Button btAnterior;
    String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    RatingBar rtBar;
    ImageView foto;
    Button btSiguiente;
    Button btVerReto;
    TextView nombre;
    TextView id_reto;
    TextView calif;
    float rt1 = 0;
    boolean estaMiFoto=false;
    float rt2 = 0;
    float rt3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_reto_3);

        Typeface type = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        btAnterior = (Button) findViewById(R.id.botonAnterior);
        btAnterior.setTypeface(type);
        btSiguiente = (Button) findViewById(R.id.botonSiguiente);
        btSiguiente.setTypeface(type);
        btVerReto = (Button) findViewById(R.id.botonVerReto);
        btVerReto.setTypeface(type);

        foto = (ImageView) findViewById(R.id.foto);
        foto.setTag(R.drawable.humo_1);
        nombre = (TextView) findViewById(R.id.nombre);
        calif =  (TextView) findViewById(R.id.calif);
        id_reto = (TextView) findViewById(R.id.id_reto);
        rtBar = (RatingBar) findViewById(R.id.ratingBar);
        btVerReto.setOnClickListener(this);
        btSiguiente.setOnClickListener(this);
        btAnterior.setOnClickListener(this);
        rtBar.setOnRatingBarChangeListener(this);
        Bundle hola = getIntent().getExtras();
        if (hola != null)
            estaMiFoto = hola.getBoolean("EstaMiFoto");

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.botonVerReto:
                Intent Reto3 = new Intent("com.example.luiscarlo.fotolingo.Reto3");
                startActivity(Reto3);
                break;
            case R.id.botonSiguiente:
                if (foto.getTag().equals(R.drawable.humo_1)){
                    foto.setImageResource(R.drawable.humo_2);
                    foto.setTag(R.drawable.humo_2);
                    nombre.setText("Luiscarlo Rivera");
                    calif.setText("90%");
                    rtBar.setRating(rt2);
                }
                else if(foto.getTag().equals(R.drawable.humo_2) && estaMiFoto) {
                    //estaMiFoto && foto.getTag().equals(estaMiFoto
                    String file = ruta_fotos + "captura3" + ".jpg";
                    Bitmap bmp = BitmapFactory.decodeFile(file);
                    foto.setImageBitmap(bmp);
                    foto.setTag(estaMiFoto);
                    nombre.setText("Luiscarlo Rivera");
                    calif.setText("89%");
                    rtBar.setRating(rt3);
                }
                else{
                    foto.setImageResource(R.drawable.humo_1);
                    foto.setTag(R.drawable.humo_1);
                    nombre.setText("Daniel Leones");
                    calif.setText("95%");
                    rtBar.setRating(rt1);
                }
                break;
            case R.id.botonAnterior:
                if (foto.getTag().equals(R.drawable.humo_1) && estaMiFoto){
                    String file = ruta_fotos + "captura3" + ".jpg";
                    Bitmap bmp = BitmapFactory.decodeFile(file);
                    foto.setImageBitmap(bmp);
                    foto.setTag(estaMiFoto);
                    nombre.setText("Luiscarlo Rivera");
                    calif.setText("89%");
                    rtBar.setRating(rt3);
                }
                else if (foto.getTag().equals(R.drawable.humo_1)&& !estaMiFoto){
                    foto.setImageResource(R.drawable.humo_2);
                    foto.setTag(R.drawable.humo_2);
                    nombre.setText("Luiscarlo Rivera");
                    calif.setText("90%");
                    rtBar.setRating(rt2);
                }
                else if(foto.getTag().equals(estaMiFoto)) {
                    foto.setImageResource(R.drawable.humo_2);
                    foto.setTag(R.drawable.humo_2);
                    nombre.setText("Luiscarlo Rivera");
                    calif.setText("90%");
                    rtBar.setRating(rt2);
                }

                else{
                    foto.setImageResource(R.drawable.humo_1);
                    foto.setTag(R.drawable.humo_1);
                    nombre.setText("Daniel Leones");
                    calif.setText("95%");
                    rtBar.setRating(rt1);
                }
                break;
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        if (foto.getTag().equals(R.drawable.humo_2)) {
            rt2 = ratingBar.getRating();
        }
        else if(foto.getTag().equals(R.drawable.humo_1)) {
            rt1 = ratingBar.getRating();
        }
        else {
            rt3 = ratingBar.getRating();
        }
    }
}
