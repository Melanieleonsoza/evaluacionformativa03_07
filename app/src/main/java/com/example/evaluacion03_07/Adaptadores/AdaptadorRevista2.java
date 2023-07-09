package com.example.evaluacion03_07.Adaptadores;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluacion03_07.Modelos.ModeloRevista;
import com.example.evaluacion03_07.R;

import java.util.ArrayList;

public class AdaptadorRevista2 extends ArrayAdapter<ModeloRevista> {
    public AdaptadorRevista2(Context context, ArrayList<ModeloRevista> data) {
        super(context, R.layout.lyitemrevista2,data);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista2, null);

        TextView lbltitle = (TextView)item.findViewById(R.id.lbltitle2);
        lbltitle.setText(getItem(position).getTitle());

        TextView lblvolume = (TextView)item.findViewById(R.id.lblvolumen2);
        lblvolume.setText(getItem(position).getVolume());

        TextView lblyear = (TextView)item.findViewById(R.id.lblyear2);
        lblyear.setText(getItem(position).getYear());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr2);
        Glide.with(this.getContext()).load(getItem(position).getCover()).into(imageView);
        return(item);
    }
}
