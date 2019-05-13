package com.example.bertone.mytp02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements RecyclerInterface {

        RecyclerView meuRecyclerView;
        LinearLayoutManager meuLayoutManager;
        MeuAdapter adapter;
        private List<Pastas> listaContatos = new ArrayList<>();
        public EditText editNome;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            editNome = findViewById(R.id.editText);//R.id do nome informado pelo usuario
            //editEmail = findViewById(R.id.editEmail);
            //editFone = findViewById(R.id.editFone);

            meuRecyclerView = (RecyclerView) findViewById(R.id.meuRecyclerView);
            meuLayoutManager = new LinearLayoutManager(this);
            meuRecyclerView.setLayoutManager(meuLayoutManager);
            adapter = new MeuAdapter(this, listaContatos, this);
            meuRecyclerView.setAdapter(adapter);
        }

        public void onClick(View v) {
            Pastas pastas = new Pastas();
            pastas.setNome(editNome.getText().toString());
            listaContatos.add(pastas);
            adapter.notifyDataSetChanged();
        }


        @Override
        public void onItemClick(Object object) {
            Pastas pastas = (Pastas) object;
            String nome = pastas.getNome();
            editNome.setText(nome);

        }



}
