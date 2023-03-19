package com.ugb.catalogo_productos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ugb.catalogo_productos.db.DB;

public class MainActivity extends AppCompatActivity {
    DB db_agenda;
    String accion="nuevo";
    String id="";
    Button btn;
    TextView temp;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            btn = findViewById(R.id.btnGuardar);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    guardar_agenda();
                }
            });
            fab = findViewById(R.id.fabRegresarListaProductos);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    regresarListaProductos();
                }
            });
        }catch (Exception e){
            Toast.makeText(this, "Error al cargar: "+ e.getMessage(), Toast.LENGTH_LONG).show();
        }
        mostrar_datos_productos();
    }
    void mostrar_datos_productos(){
        try {
            Bundle parametros = getIntent().getExtras();
            accion = parametros.getString("accion");
            if (accion.equals("modificar")) {
                String productos[] = parametros.getStringArray("amigos");
                id = productos[0];

                temp = findViewById(R.id.txtcodigo);
                temp.setText(productos[1]);

                temp = findViewById(R.id.txtdescripcion);
                temp.setText(productos[2]);

                temp = findViewById(R.id.txtmarca);
                temp.setText(productos[3]);

                temp = findViewById(R.id.txtpresentacion);
                temp.setText(productos[4]);

                temp = findViewById(R.id.txtprecio);
                temp.setText(productos[5]);
            }
        }catch (Exception e){
            Toast.makeText(this, "Error al mostrar datos: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    void guardar_agenda(){
        try {
            temp = (TextView) findViewById(R.id.txtcodigo);
            String codigo = temp.getText().toString();

            temp = (TextView) findViewById(R.id.txtdescripcion);
            String descripcion = temp.getText().toString();

            temp = (TextView) findViewById(R.id.txtmarca);
            String marca = temp.getText().toString();

            temp = (TextView) findViewById(R.id.txtpresentacion);
            String presentacion = temp.getText().toString();

            temp = (TextView) findViewById(R.id.txtprecio);
            String precio = temp.getText().toString();

            db_agenda = new DB(MainActivity.this, "",null,1);
            String result = db_agenda.administrar_agenda(id, codigo, descripcion, marca, presentacion, precio, accion);
            String msg = result;
            if( result.equals("ok") ){
                msg = "Registro guardado con exito";
                regresarListaProductos();
            }
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, "Error en guardar agenda: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    void regresarListaProductos(){
        Intent iListaProductos = new Intent(MainActivity.this, lista_productos.class);
        startActivity(iListaProductos);
    }
}

