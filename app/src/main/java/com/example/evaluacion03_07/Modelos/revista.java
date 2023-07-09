package com.example.evaluacion03_07.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class revista {
    private String name;
    private String portada;
    private String journal_id;
    public revista(JSONObject a) throws JSONException {
        name = a.getString("name").toString() ;
        portada = a.getString("portada").toString() ;
        journal_id = a.getString("journal_id").toString() ;

    }
    public static ArrayList<revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<revista> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new revista(datos.getJSONObject(i)));
        }
        return usuarios;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }
}