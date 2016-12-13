package com.example.javigabbo.actividad3;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.libreria.QBAdmin;
import com.example.libreria.QBAdminListener;
import com.quickblox.core.model.QBBaseCustomObject;

import java.util.ArrayList;

/**
 * Created by Javigabbo on 28/11/16.
 */

public class Controlador implements View.OnClickListener, QBAdminListener{

    MainActivity vista;
    Intent intent = null;





    public Controlador(MainActivity vista){
        this.vista = vista;
        intent = new Intent(vista, Main2Activity.class);
    }





    @Override
    public void onClick(View v) {

        if (v.getId() == vista.botonRegistrar.getId()){
            vista.cambiaFragment(3);

        } else if(v.getId() == vista.botonIniciaSesionRegistro.getId()){
            vista.cambiaFragment(2);

        } else if (v.getId() == vista.botonLogin.getId()){
            if (!vista.EtUsuario.getText().toString().equals("") && !vista.EtPassw.getText().toString().equals("")) {
                vista.qbAdmin.iniciarSesion(vista.EtUsuario.getText().toString(), vista.EtPassw.getText().toString());
            }
        } else if (v.getId() == vista.botonRegistrarse.getId()){
            if (!vista.usuarioReg.getText().toString().equals("") && !vista.emailReg.getText().toString().equals("") && !vista.passwReg.getText().toString().equals("")){
                vista.qbAdmin.registrarse(vista.usuarioReg.getText().toString(), vista.emailReg.getText().toString(), vista.passwReg.getText().toString());
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
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos) {

    }

}
