package com.example.evaluacion03_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.evaluacion03_07.Adaptadores.AdaptadorRevista;
import com.example.evaluacion03_07.Adaptadores.AdaptadorRevista2;
import com.example.evaluacion03_07.Modelos.ModeloRevista;
import com.example.evaluacion03_07.Modelos.revista;
import com.example.evaluacion03_07.WebService.Asynchtask;
import com.example.evaluacion03_07.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Revista extends AppCompatActivity implements Asynchtask {
    private ListView lstOp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revista);
        Bundle bundle=this.getIntent().getExtras();
        String url="https://revistas.uteq.edu.ec/ws/issues.php?j_id="+bundle.getString("id");
        Map<String, String> data = new HashMap<String, String>();
        WebService ws= new WebService(url,data,Revista.this, Revista.this);
        ws.execute("GET");

        //VISTA
        lstOp2 = (ListView) findViewById(R.id.lvrevistaac);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistarevistaac = new JSONArray(result);
        ArrayList<ModeloRevista> lstrevistaac = ModeloRevista.JsonObjectsBuild(JSONlistarevistaac);
        AdaptadorRevista2 adaptadorRevista2 = new AdaptadorRevista2(this,lstrevistaac);
        lstOp2.setAdapter(adaptadorRevista2);
    }
}