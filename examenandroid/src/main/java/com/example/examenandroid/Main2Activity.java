package com.example.examenandroid;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.libreria.QBAdmin;

public class Main2Activity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
    QBAdmin qbAdmin;
    Controlador2 controlador2;

    TextView textView4;

    Button btnEspanol, btnIngles;
    Button btnPolitica, btnDeportes, btnMusica, btnPeliculas, btnTecnologia, btnVideojuegos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        fm = getSupportFragmentManager();
        controlador2 = new Controlador2(this);

        fragment1 = (Fragment1) fm.findFragmentById(R.id.fragment3);
        fragment2 = (Fragment2) fm.findFragmentById(R.id.fragment4);
        fragment3 = (Fragment3) fm.findFragmentById(R.id.fragment5);

        textView4 = (TextView) findViewById(R.id.textView4);
        btnEspanol = (Button) findViewById(R.id.btnEspanol);
        btnIngles = (Button) findViewById(R.id.btnIngles);

        btnPolitica = (Button) fragment1.getView().findViewById(R.id.btnPolitica);
        btnDeportes = (Button) fragment1.getView().findViewById(R.id.btnDeportes);
        btnMusica = (Button) fragment1.getView().findViewById(R.id.btnMusica);
        btnPeliculas = (Button) fragment1.getView().findViewById(R.id.btnPeliculas);
        btnTecnologia = (Button) fragment1.getView().findViewById(R.id.btnTecnologia);
        btnVideojuegos = (Button) fragment1.getView().findViewById(R.id.btnVideojuegos);

        btnEspanol.setOnClickListener(controlador2);
        btnIngles.setOnClickListener(controlador2);
        btnPolitica.setOnClickListener(controlador2);
        btnDeportes.setOnClickListener(controlador2);
        btnMusica.setOnClickListener(controlador2);
        btnPeliculas.setOnClickListener(controlador2);
        btnTecnologia.setOnClickListener(controlador2);
        btnVideojuegos.setOnClickListener(controlador2);



        qbAdmin = new QBAdmin(controlador2, this);
        qbAdmin.crearSesion();

        cambiarFragments(0);
    }




    public void cambiarFragments(int fragment){

        fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.hide(fragment1);
        fragmentTransaction.hide(fragment2);
        fragmentTransaction.hide(fragment3);

        if (fragment == 0){
            fragmentTransaction.hide(fragment1);
            fragmentTransaction.hide(fragment2);
            fragmentTransaction.hide(fragment3);

        }else if (fragment == 1){
            fragmentTransaction.show(fragment1);
            btnEspanol.setVisibility(View.INVISIBLE);
            btnIngles.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);

        } else if (fragment == 2){
            fragmentTransaction.show(fragment2);
            btnEspanol.setVisibility(View.INVISIBLE);
            btnIngles.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);

        } else if(fragment == 3){
            fragmentTransaction.show(fragment3);
            btnEspanol.setVisibility(View.INVISIBLE);
            btnIngles.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);

        }

        fragmentTransaction.commitNow();

    }
}
