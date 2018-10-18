package com.example.user.spinner;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    final String[] datos = new String[]{"Operaciones","Suma","Resta","Multiplicación","División"};
    EditText numero1,numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = (EditText) findViewById(R.id.txtNumero1);
        numero2 = (EditText) findViewById(R.id.txtNumero2);

        final Spinner cmbOpera= (Spinner) findViewById(R.id.spinnerdatos);

        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
        //adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this,R.array.opciones,android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmbOpera.setAdapter(adaptador);

        cmbOpera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int n1,n2;
                float rpta;
                String cad,valor,otra;
                
                if (position==0){return;}
                
                n1=Integer.parseInt(numero1.getText().toString());
                n2=Integer.parseInt(numero2.getText().toString());

                AlertDialog mensaje = new AlertDialog.Builder(MainActivity.this).create();
                mensaje.setTitle("Mensaje de Combo");
                cad = "Posición: "+position+"\n";
                valor=cmbOpera.getSelectedItem().toString();
                otra=parent.getItemAtPosition(position).toString();
                cad=cad+"Contenido: "+valor+"\n"+"Otra forma: "+otra+"\n";

                switch (position){

                    case 1:
                        rpta=n1+n2;
                        mensaje.setMessage(cad + "La suma es: " + rpta);
                        mensaje.show();
                        break;

                    case 2:
                        rpta=n1-n2;
                        mensaje.setMessage(cad+"La Resta es: "+rpta);
                        mensaje.show();
                        break;

                    case 3:
                        rpta=n1*n2;
                        mensaje.setMessage(cad+"La Multiplicación es: "+rpta);
                        mensaje.show();
                        break;

                    case 4:
                        rpta=(float)n1/n2;
                        mensaje.setMessage(cad+"La División es: "+rpta);
                        mensaje.show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
