package br.com.sunshine.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalhesActivity extends AppCompatActivity {

    TextView text_detalhes;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //
        text_detalhes = (TextView) findViewById(R.id.text_detalhes);
        imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();//pegar o intent passado na outra tela

        //pegando a informação passada via intent
        String dados = intent.getStringExtra("dados");

        //exibindo na textview a informação
        text_detalhes.setText(dados);

        String link ="http://pescadordebits.com.br/wp-content/uploads/2014/09/Imagens-aleat%C3%B3rias-21.jpg";


        Picasso.with(this).load(link).into(imageView);


    }

}
