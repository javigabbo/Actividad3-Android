package com.example.examenandroid;

import android.content.Intent;
import android.view.View;

import com.example.libreria.QBAdminListener;

import java.util.HashMap;

/**
 * Created by Javigabbo on 20/12/16.
 */

public class Controlador implements View.OnClickListener, QBAdminListener {

    MainActivity vista;
    Intent intent = null;

    public Controlador(MainActivity vista){
        this.vista = vista;
        intent = new Intent(vista, Main2Activity.class);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == vista.btnLogin.getId()){
            if (!vista.editTextUsuarioLogin.getText().toString().equals("") && !vista.editTextPasswLogin.getText().toString().equals("")){
                vista.qbAdmin.iniciarSesion(vista.editTextUsuarioLogin.getText().toString(), vista.editTextPasswLogin.getText().toString());
            }

        }else if(v.getId() == vista.btnRegistro.getId()){
            vista.cambiarFragment(2);
            vista.editTextUsuarioLogin.setText("");
            vista.editTextPasswLogin.setText("");

        }else if(v.getId() == vista.btnIniciarSesion.getId()){
            vista.cambiarFragment(1);
            vista.editTextPasswRegistro.setText("");
            vista.editTextEmailRegistro.setText("");
            vista.editTextUsuarioRegistro.setText("");

        }else if(v.getId() == vista.btnRegistrarse.getId()){
            if (!vista.editTextUsuarioRegistro.getText().toString().equals("") && !vista.editTextEmailRegistro.getText().toString().equals("") && vista.editTextPasswRegistro.getText().toString().equals("")){
                vista.qbAdmin.registrarse(vista.editTextUsuarioRegistro.getText().toString(), vista.editTextPasswRegistro.getText().toString(), vista.editTextEmailRegistro.getText().toString());
            }

        }

    }

    @Override
    public void logeado(boolean blLogeado) {
        if (blLogeado) {
            vista.startActivity(intent);
            vista.finish();
        }
    }

    @Override
    public void registrado(boolean blRegistrado) {
        if (blRegistrado) {
            vista.startActivity(intent);
            vista.finish();
        }
    }

    @Override
    public void datosDescargados(HashMap<Integer, String> datos) {

    }

}
