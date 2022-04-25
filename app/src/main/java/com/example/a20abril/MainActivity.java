package com.example.a20abril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

//contains

//si es activity es una pantalla
//para que se comporte como pantalla tiene que tener el extends....
public class MainActivity extends AppCompatActivity {
    //atributos
    private EditText etPalabra;
    private Button btnProcesar, btnContar;
    private CheckBox cbMinusculas;

    private String palabra;
    private Boolean esMinuscula;
    private int contador = 0;
    private String Cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //cuando esta pantalla este activandos le va a mostrar al usuario esta referrencia visual
        setContentView(R.layout.activity_main);
        inicializarVistas();
        //version tradicional
        /*btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });*/

        //Lambda functions or arrow functions
        //version reducida, ortima
        btnProcesar.setOnClickListener(view -> obtenerInformacion());
        btnContar.setOnClickListener(view -> verificarVocales());
    }

    private void verificarVocales() {
        /*
        FORMA MAS LARGA
        palabra =etPalabra.getText().toString();
        palabra = palabra.toLowerCase();
        contador = 0;
        for (int i = this.palabra.length()-1; i >=0 ; i--) {
            if ((palabra.charAt(i)=='a') || (palabra.charAt(i)=='e')|| (palabra.charAt(i)=='i') || (palabra.charAt(i)=='o') || (palabra.charAt(i)=='u'))
            {
                contador++;
            }
        }
        Cont = Integer.toString(contador);

        Toast.makeText(this,"La palabra "+this.palabra+" tiene " +Cont+ " Vocales", Toast.LENGTH_SHORT).show();
         */
        ArrayList<Character> vocales = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        int cantidadVocales = 0;
        for(int i=0; i<palabra.length();i++) {
            if(vocales.contains(palabra.charAt(i))) {
                cantidadVocales++;
            }
        }
        Toast.makeText(this, "Tiene: " + cantidadVocales, Toast.LENGTH_SHORT).show();

    }

    private void inicializarVistas() {
        etPalabra = findViewById(R.id.etPalabra);
        btnProcesar = findViewById(R.id.btnProcesar);
        btnContar = findViewById(R.id.btnContar);
        cbMinusculas = findViewById(R.id.cbMinusculas);
    }
    private  void obtenerInformacion() {
        palabra = etPalabra.getText().toString();
        //getChecked --- isChecked sigue siendo un getter
        esMinuscula = cbMinusculas.isChecked();
        convertirAMinuscula();
    }

    private void convertirAMinuscula(){
        if (esMinuscula){
            palabra = palabra.toLowerCase();
        }
    }


//SE PUEDE BUSCAR QUE ES HASHMAPS
}