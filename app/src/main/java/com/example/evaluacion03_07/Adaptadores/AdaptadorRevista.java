package com.example.evaluacion03_07.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.evaluacion03_07.Modelos.revista;
import com.example.evaluacion03_07.R;

import java.util.ArrayList;

public class AdaptadorRevista  extends ArrayAdapter<revista> {
    public AdaptadorRevista( Context context, ArrayList<revista> datos) {
        super(context, R.layout.lyitemrevista,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);

        TextView lblnombre = (TextView)item.findViewById(R.id.lblNombre);
        lblnombre.setText(getItem(position).getName());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext()).load(getItem(position).getPortada()).into(imageView);
        return(item);
    }
}
