package com.example.ejemplogrid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView grid_view;
    List<String> datos;
    GridAdapter adapter;
    Button btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid_view=findViewById(R.id.grid_view);
        datos=new ArrayList<>();
        btn_agregar=findViewById(R.id.btn_agregar);
        datos.add("holi");
        datos.add("codigo");
        adapter=new GridAdapter(this,R.layout.grid_item,datos);
        grid_view.setAdapter(adapter);
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MostrarDialogoAgregar();
            }
        });
    }
    void MostrarDialogoAgregar(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("CREAR NUEVO");
        builder.setMessage("ingrese un nuevo dato");

        View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_formulario,null);
        builder.setView(v);
        final EditText et =v.findViewById(R.id.editText);

        builder.setPositiveButton("AGREGAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CrearNuevoItem(et.getText().toString());
            }
        });
        builder.show();
    }
    void CrearNuevoItem(String s){
        datos.add(s);
        adapter.notifyDataSetChanged();
    }
}
