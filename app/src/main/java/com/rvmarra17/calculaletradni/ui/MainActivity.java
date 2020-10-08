package com.rvmarra17.calculaletradni.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rvmarra17.calculaletradni.R;
import com.rvmarra17.calculaletradni.core.calcularLetraDNI;

public class MainActivity extends AppCompatActivity { //actividad principal, extiende de unas capas de compativilidad

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) { //se ejecuta cuando la actividad es creada
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//lanza el xml

        final EditText ED_DNI = this.findViewById(R.id.edDNI);
        ED_DNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcula();
            }
        });

        final Button salir = this.findViewById(R.id.botonSalir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });


    }


    private void calcula() {

        final EditText ED_DNI = this.findViewById(R.id.edDNI);
        final TextView LETRA = this.findViewById(R.id.edResultado);
        char letra = calcularLetraDNI.calcula(ED_DNI.getText().toString());
        LETRA.setText("Letra: " + Character.toString(letra));
    }

    private void salir() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Salir");
        dlg.setMessage("Estás seguro?");
        dlg.setNegativeButton("no", null);
        dlg.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });

     /*   dlg.setItems(new String[]{
                "continuar", "salir"
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 1) {
                    MainActivity.this.finish();
                }
            }
        });*/

      /* dlg.setSingleChoiceItems(
               new String[]{
                       "continuar", "salir"
               },0,
               new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       if (which==1){
                           MainActivity.this.finish();
                       }
                   }
               }
       );

       dlg.setPositiveButton("aceptar",null);*/

        dlg.create().show();
    }
}