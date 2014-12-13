package com.example.luiscarlo.fotolingo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luiscarlo on 04-11-2014.
 */
public class Reto3 extends Activity implements View.OnTouchListener, View.OnClickListener {

    String arregloConsejo[]= {"Ilumina correctamente el humo para un mejor resultado","Prueba usando luz de diferentes colores",
            "Aprovecha el enfoque de la cámara cuando estes cerca"};
    int cont=0;
    TextView textConsejo;
    TextView TituloReto;
    Button btCapturar;
    Button btRetosAnteriores;
    Button btGaleria;
    String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    File file = new File(ruta_fotos);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        file.mkdirs();
        Typeface type = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reto_3);

        btCapturar = (Button) findViewById(R.id.botonCapturar);
        btCapturar.setTypeface(type);
        btCapturar.setOnClickListener(this);

        btRetosAnteriores = (Button) findViewById(R.id.botonRetosAnteriores);
        btRetosAnteriores.setTypeface(type);
        btRetosAnteriores.setOnClickListener(this);

        btGaleria = (Button) findViewById(R.id.botonGaleria);
        btGaleria.setTypeface(type);
        btGaleria.setOnClickListener(this);

        TituloReto = (TextView) findViewById(R.id.tituloReto1);
        TituloReto.setTypeface(type);

        textConsejo = (TextView) findViewById(R.id.textoConsejos);
        textConsejo.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent arg1) {
        if (arg1.getAction()==MotionEvent.ACTION_DOWN){
            textConsejo.setText(arregloConsejo[cont++]);
            if (cont==3){
                cont=0;
            }
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonRetosAnteriores:
                Intent Lista = new Intent("com.example.luiscarlo.fotolingo.AndroidListViewActivity");
                startActivity(Lista);
                break;
            case R.id.botonGaleria:
                Intent Vista = new Intent("com.example.luiscarlo.fotolingo.PrincipalReto3");
                Vista.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(Vista);
                break;
            case R.id.botonCapturar:
                String file = ruta_fotos + "captura3" + ".jpg";
                File mi_foto = new File( file );
                try {
                    mi_foto.createNewFile();
                } catch (IOException ex) {
                    Log.e("ERROR ", "Error:" + ex);
                }
                //
                Uri uri = Uri.fromFile( mi_foto );
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
        Intent Vista = new Intent("com.example.luiscarlo.fotolingo.SubirReto3");
        startActivity(Vista);
    }
}
