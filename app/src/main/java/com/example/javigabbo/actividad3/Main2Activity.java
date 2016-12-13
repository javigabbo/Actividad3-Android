package com.example.javigabbo.actividad3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.libreria.QBAdmin;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    Controlador2 controlador;
    QBAdmin qbAdmin;

    Button btnEspanol;
    Button btnIngles;
    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        controlador = new Controlador2(this);

        btnEspanol = (Button) this.findViewById(R.id.buttonEspanol);
        btnIngles = (Button) this.findViewById(R.id.buttonIngles);
        text1 =(TextView) this.findViewById(R.id.txt1);
        text2 =(TextView) this.findViewById(R.id.txt2);

        btnEspanol.setOnClickListener(controlador);
        btnIngles.setOnClickListener(controlador);

        qbAdmin = new QBAdmin(controlador, this);


    }
}
