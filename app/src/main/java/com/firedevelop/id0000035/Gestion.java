package com.firedevelop.id0000035;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class Gestion extends Activity{
    private Partida partida;
    private int dificultad;
    private int FPS=30; // frames por segundo
    private Handler temporizador;

    protected void onCreate (Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         Bundle extras=getIntent().getExtras();
         dificultad=extras.getInt("DIFICULTAD");
         partida=new Partida(getApplicationContext(), dificultad);
         setContentView(partida); // carga la partida, la vista en si.
        temporizador=new Handler();
        temporizador.postDelayed(elhilo,2000);
    }
    private Runnable elhilo=new Runnable() {
        @Override
        public void run() {
            if(partida.movimientoBola()) fin();
            else{
                partida.invalidate(); //
            }
        }
    };

}
