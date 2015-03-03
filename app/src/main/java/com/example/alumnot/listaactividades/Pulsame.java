package com.example.alumnot.listaactividades;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Pulsame extends ActionBarActivity {

    private Button boton;
    private int numVeces=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsame);
        boton=(Button)findViewById(R.id.boton);
        if(savedInstanceState!=null)
        {
            numVeces=savedInstanceState.getInt("numVeces",0);
            boton.setText("Pulsado "+numVeces+" veces");
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numVeces++;
                boton.setText("Pulsado "+numVeces+" veces");
            }
        });

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("numVeces",numVeces);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pulsame, menu);
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