package com.ugb.catalogo_productos;

import android.os.AsyncTask;

import java.net.HttpURLConnection;

import java.net.URL;

public class obtenerDatosServidor extends AsyncTask<Void, Void , String> {
    HttpURLConnection httpURLConnection;

    @Override
    protected String doInBackground(Void...voids) {
        StringBuilder result = new StringBuilder();
        try {
            //conexion con el servidor
            URL url = new URL("http://localhost:5984/bd_productos/_design/productos/_view/productos");


        } catch (Exception e) {
            //mensaje de error

        }
        return null;
    }
}
