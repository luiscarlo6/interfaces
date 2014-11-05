package com.example.luiscarlo.fotolingo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Luiscarlo on 04-11-2014.
 */
public class Reto1 extends Activity implements View.OnTouchListener {

    String arregloConsejo[]= {"Usa el flash en ocasiones","Toma varias fotos y elige la mejor",
                                "Acercate, en lo posible, al objetivo "};
    int cont=0;
    TextView textConsejo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reto_1);

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
}
