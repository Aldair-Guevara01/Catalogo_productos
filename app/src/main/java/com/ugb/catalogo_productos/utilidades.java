package com.ugb.catalogo_productos;

public class utilidades {
    static String url_consulta= "http://192.168.85.176:5984/db_amigos/_design/amigos/_view/amigos";
    static  String url_mto = "http://192.168.85.176:5984/db_amigos/";

    public String generarIdUnico(){
        return java.util.UUID.randomUUID().toString();
    }

}

