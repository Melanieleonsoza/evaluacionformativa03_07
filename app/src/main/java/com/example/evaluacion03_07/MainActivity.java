package com.example.evaluacion03_07;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evaluacion03_07.Adaptadores.AdaptadorRevista;
import com.example.evaluacion03_07.Modelos.revista;
import com.example.evaluacion03_07.WebService.Asynchtask;
import com.example.evaluacion03_07.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {
    private ListView lstOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url=" https://revistas.uteq.edu.ec/ws/journals.php";

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(url,datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

        //VISTA
        lstOp = (ListView) findViewById(R.id.lstListaUsuario);

        //Inicializacion del evento Onclick
        lstOp.setOnItemClickListener(this);

    }

    @Override
    public void processFinish(String result) throws JSONException {
        //JSONObject Jsonlista = new JSONObject(result);
        JSONArray JSONlistarevista = new JSONArray(result);
        ArrayList<revista> lstrevista = revista.JsonObjectsBuild(JSONlistarevista);
        AdaptadorRevista adaptadorRevista = new AdaptadorRevista(this,lstrevista);
        lstOp.setAdapter(adaptadorRevista);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        revista revista=(revista) adapterView.getItemAtPosition(i);

        String identificador=revista.getJournal_id().toString();

        Intent intent=new Intent(MainActivity.this, Revista.class);

        Bundle bundle=new Bundle();
        bundle.putString("id",identificador);

        intent.putExtras(bundle);
        startActivity(intent);
        Toast.makeText(this, "ID Seleccionado: " + identificador,Toast.LENGTH_SHORT).show();
    }
}