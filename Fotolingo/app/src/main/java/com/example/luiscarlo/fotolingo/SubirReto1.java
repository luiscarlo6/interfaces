package com.example.luiscarlo.fotolingo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luiscarlo on 24-11-2014.
 */
public class SubirReto1 extends Activity implements View.OnClickListener {

    ImageView miFoto;
    Button btEnviar;
    Button btReintentar;
    String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subir_foto_1);

        Typeface type = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        btEnviar = (Button) findViewById(R.id.botonEnviar);
        btReintentar = (Button) findViewById(R.id.botonReintentar);
        String file = ruta_fotos + "captura1" + ".jpg";
        Bitmap bmp = BitmapFactory.decodeFile(file);
        miFoto = (ImageView) findViewById(R.id.mi_foto);
        miFoto.setImageBitmap(bmp);

        btEnviar.setOnClickListener(this);
        btEnviar.setTypeface(type);
        btReintentar.setOnClickListener(this);
        btReintentar.setTypeface(type);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.botonEnviar:
                Intent Princi = new Intent("com.example.luiscarlo.fotolingo.Principal");
                //Princi.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                Bundle hola = new Bundle(1);
                hola.putBoolean("EstaMiFoto", true);
                Princi.putExtras(hola);
                startActivity(Princi);
                break;
            case R.id.botonReintentar:
                String file = ruta_fotos + "captura1" + ".jpg";
                File mi_foto = new File( file );
                try {
                    mi_foto.createNewFile();
                } catch (IOException ex) {
                    Log.e("ERROR ", "Error:" + ex);
                }
                //
                Uri uri = Uri.fromFile(mi_foto);
                //Abre la camara para tomar la foto
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //Guarda imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                //Retorna a la actividad
                startActivityForResult(cameraIntent, 0);
                break;

        }
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String file = ruta_fotos + "captura1" + ".jpg";
        Bitmap bmp = BitmapFactory.decodeFile(file);
        miFoto = (ImageView) findViewById(R.id.mi_foto);
        miFoto.setImageBitmap(bmp);
    }
    }

