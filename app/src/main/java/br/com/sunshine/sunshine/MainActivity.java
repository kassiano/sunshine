package br.com.sunshine.sunshine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //instanciando o objeto, buscando do XML
        listView = (ListView)findViewById(R.id.list_view);


        //lista com dados fake
        List<String> lstPrevisoes = new ArrayList<>();
        lstPrevisoes.add("Segunda - max 30º mín 18º");
        lstPrevisoes.add("Terça - max 28º mín 19º");
        lstPrevisoes.add("Quarta - max 26º mín 22º");
        lstPrevisoes.add("Quinta - max 30º mín 13º");
        lstPrevisoes.add("Sexta - max 32º mín 0º");


        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(
                this, //contexto, this significa esta mesma classe
                R.layout.list_view_item,//arquivo do list item
                lstPrevisoes //lista cm dados
                );

        //conectando o adapter na listView
        listView.setAdapter(adapter);

        //listenner para tratar o click da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemSelecionado = adapter.getItem(position);

                Toast.makeText(context, itemSelecionado, Toast.LENGTH_SHORT).show();

                //Abrir a tela de detalhes
                Intent intent = new Intent(context, DetalhesActivity.class);

                //passar informações p/ proxima tela
                intent.putExtra("dados", itemSelecionado);

                startActivity(intent);

            }
        });

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
