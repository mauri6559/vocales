package com.example.a20abril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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
        int contador = 0;
        String mensa = "";
        for (int i = 0; i < palabra.length(); i++) {
            if ((palabra.charAt(i) == 'a') || (palabra.charAt(i) == 'b') || (palabra.charAt(i) == 'c') || (palabra.charAt(i) == 'd') || (palabra.charAt(i) == 'e')) {
                contador++;
                mensa = "tiene: " + contador;
            }
        }

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
    }

    private void mostrar(){

        Toast.makeText(this, verificarVocales(), Toast.LENGTH_SHORT).show();
    }

}