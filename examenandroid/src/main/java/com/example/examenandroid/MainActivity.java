package com.example.examenandroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.libreria.QBAdmin;

public class MainActivity extends AppCompatActivity {


    login_fragment loginFragment;
    registro_fragment registroFragment;
    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    QBAdmin qbAdmin;
    Controlador controlador;


    Button btnLogin, btnRegistro, btnRegistrarse, btnIniciarSesion;
    EditText editTextUsuarioLogin, editTextPasswLogin, editTextUsuarioRegistro, editTextPasswRegistro, editTextEmailRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm = getSupportFragmentManager();
        controlador = new Controlador(this);
        loginFragment = (login_fragment) fm.findFragmentById(R.id.fragment);
        registroFragment = (registro_fragment) fm.findFragmentById(R.id.fragment2);


        btnLogin = (Button) loginFragment.getView().findViewById(R.id.buttonLogin);
        btnRegistro = (Button) loginFragment.getView().findViewById(R.id.buttonRegistro);
        btnIniciarSesion = (Button) registroFragment.getView().findViewById(R.id.buttonIniciarSesion);
        btnRegistrarse = (Button) registroFragment.getView().findViewById(R.id.buttonRegistrarse);


        btnLogin.setOnClickListener(controlador);
        btnRegistro.setOnClickListener(controlador);
        btnIniciarSesion.setOnClickListener(controlador);
        btnRegistrarse.setOnClickListener(controlador);

        editTextUsuarioLogin = (EditText) loginFragment.getView().findViewById(R.id.editTextUsuarioLogin);
        editTextPasswLogin = (EditText) loginFragment.getView().findViewById(R.id.editTextPasswLogin);
        editTextEmailRegistro = (EditText) registroFragment.getView().findViewById(R.id.editTextEmailRegistro);
        editTextUsuarioRegistro = (EditText) registroFragment.getView().findViewById(R.id.editTextUsuarioRegistro);
        editTextPasswRegistro = (EditText) registroFragment.getView().findViewById(R.id.editTextPasswRegistro);


        qbAdmin = new QBAdmin(controlador, this);
        qbAdmin.crearSesion();


        cambiarFragment(1);
    }


    public void cambiarFragment(int fragment){

        fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.hide(loginFragment);
        fragmentTransaction.hide(registroFragment);

        if (fragment == 1){
            fragmentTransaction.show(loginFragment);

        } else if (fragment == 2){
            fragmentTransaction.show(registroFragment);

        }

        fragmentTransaction.commitNow();

    }
}
