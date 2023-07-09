package com.example.evaluacion03_07.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModeloRevista {
    private String volume;
    private String title;
    private String cover;
    private String year ;
    public ModeloRevista(JSONObject a) throws JSONException {
        volume = a.getString("volume") ;
        title = a.getString("title") ;
        year = a.getString("year") ;
        cover = a.getString("cover");

    }
    public static ArrayList<ModeloRevista> JsonObjectsBuild(JSONArray data) throws JSONException {
        ArrayList<ModeloRevista> libros = new ArrayList<>();
        for (int i = 0; i < data.length() && i<20; i++) {
            libros.add(new ModeloRevista(data.getJSONObject(i)));
        }
        return libros;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
