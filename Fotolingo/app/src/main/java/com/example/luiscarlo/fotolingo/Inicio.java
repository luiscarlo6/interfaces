package com.example.luiscarlo.fotolingo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Inicio extends Activity implements View.OnClickListener {
    Button btComenzar;
    TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        header = (TextView) findViewById(R.id.titulo);
        Typeface type = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        header.setTypeface(type);

        btComenzar= (Button) findViewById(R.id.botonComenzar);
        btComenzar.setTypeface(type);
        btComenzar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.botonComenzar:
                Intent Principal = new Intent("com.example.luiscarlo.fotolingo.Principal");
                Bundle hola = new Bundle(1);
                hola.putBoolean("EstaMiFoto", false);
                Principal.putExtras(hola);
                startActivity(Principal);
        }
    }
}
