package com.example.javigabbo.actividad3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.libreria.QBAdmin;
import com.example.libreria.QBAdminListener;
import com.quickblox.core.model.QBBaseCustomObject;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements QBAdminListener{

    TestFragment testFragment;
    RegistroFragment registroFragment;
    CreditoFragment creditoFragment;
    Controlador controlador;
    FragmentTransaction transaction;
    FragmentManager fm;


    Button botonRegistrar;
    Button botonLogin;
    Button botonIniciaSesionRegistro;
    Button botonRegistrarse;

    EditText EtUsuario;
    EditText EtPassw;

    EditText usuarioReg;
    EditText emailReg;
    EditText passwReg;

    QBAdmin qbAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();


        controlador = new Controlador(this);
        testFragment = (TestFragment) fm.findFragmentById(R.id.miFragmento);
        registroFragment = (RegistroFragment) fm.findFragmentById(R.id.fragmentRegistro);
        creditoFragment = (CreditoFragment) fm.findFragmentById(R.id.fragmentCredito);

        botonLogin = (Button) testFragment.getView().findViewById(R.id.btnLogin);
        botonRegistrar = (Button) testFragment.getView().findViewById(R.id.btnRegistro);
        botonIniciaSesionRegistro = (Button) registroFragment.getView().findViewById(R.id.btnIniciaSesionRegistro);
        botonRegistrarse = (Button) registroFragment.getView().findViewById(R.id.btnRegistrarse);
        botonLogin.setOnClickListener(controlador);
        botonRegistrar.setOnClickListener(controlador);
        botonIniciaSesionRegistro.setOnClickListener(controlador);
        botonRegistrarse.setOnClickListener(controlador);

        EtUsuario = (EditText) testFragment.getView().findViewById(R.id.editTextUsername);
        EtPassw = (EditText) testFragment.getView().findViewById(R.id.editTextPassword);
        usuarioReg = (EditText) registroFragment.getView().findViewById(R.id.editTextUsuarioR);
        emailReg = (EditText) registroFragment.getView().findViewById(R.id.editTextEmailR);
        passwReg = (EditText) registroFragment.getView().findViewById(R.id.editTextPasswR);



        qbAdmin = new QBAdmin(this, this);
        qbAdmin.crearSesion();

        cambiaFragment(1);

    }

    public void cambiaFragment(int fragment) {

        transaction = fm.beginTransaction();

        transaction.hide(creditoFragment);
        transaction.hide(testFragment);
        transaction.hide(registroFragment);

        if (fragment == 1){
            transaction.show(creditoFragment);

        } else if (fragment == 2){
            transaction.show(testFragment);

        } else if (fragment == 3){
            transaction.show(registroFragment);
        }

        transaction.commitNow();

    }



    @Override
    public void logeado(boolean blLogeado){

        if (blLogeado){
            System.out.println("LOGEADO CON EXITO");
        }else{
            System.out.println("FALLO AL LOGEAR");
        }

    }

    @Override
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos) {

    }

}