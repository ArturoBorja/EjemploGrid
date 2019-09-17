package com.example.ejemplogrid;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

public class GridAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<String> datos;
    public GridAdapter(Context context, int layout, List<String> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;    }
    @Override
    public int getCount() {        return datos.size();    }
    @Override
    public Object getItem(int i) {        return datos.get(i);    }
    @Override
    public long getItemId(int i) {        return i;    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View v = inflater.inflate(layout,null);
        TextView tv =v.findViewById(R.id.textView);
        tv.setText(datos.get(i));
        Button btn_grid=v.findViewById(R.id.btn_grid);
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, datos.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
