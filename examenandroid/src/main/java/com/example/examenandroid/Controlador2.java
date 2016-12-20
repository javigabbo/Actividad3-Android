package com.example.examenandroid;

import android.content.Intent;
import android.view.View;

import com.example.libreria.QBAdminListener;

import java.util.HashMap;

/**
 * Created by Javigabbo on 20/12/16.
 */

public class Controlador2 implements View.OnClickListener, QBAdminListener {

    Main2Activity vista;
    Intent intent = null;

    public Controlador2(Main2Activity vista){
        this.vista = vista;
        intent = new Intent(vista, MainActivity.class);
    }




    @Override
    public void onClick(View v) {

        if (v.getId() == vista.btnEspanol.getId()) {
            vista.cambiarFragments(1);
        } else if (v.getId() == vista.btnIngles.getId()) {
            vista.cambiarFragments(1);
        }

        if (v.getId() == vista.btnPolitica.getId()){
            vista.qbAdmin.selectTema(vista.btnPolitica.getText().toString());

        }else if(v.getId() == vista.btnDeportes.getId()){
            vista.qbAdmin.selectTema(vista.btnDeportes.getText().toString());

        }else if(v.getId() == vista.btnMusica.getId()){
            vista.qbAdmin.selectTema(vista.btnMusica.getText().toString());

        }else if(v.getId() == vista.btnPeliculas.getId()){
            vista.qbAdmin.selectTema(vista.btnPeliculas.getText().toString());

        }else if(v.getId() == vista.btnTecnologia.getId()){
            vista.qbAdmin.selectTema(vista.btnTecnologia.getText().toString());

        }else if(v.getId() == vista.btnVideojuegos.getId()){
            vista.qbAdmin.selectTema(vista.btnVideojuegos.getText().toString());

        }
    }


    @Override
    public void logeado(boolean blLogeado) {

    }

    @Override
    public void registrado(boolean blRegistrado) {

    }

    @Override
    public void datosDescargados(HashMap<Integer, String> datos) {

    }
}
