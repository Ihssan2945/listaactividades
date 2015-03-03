package com.example.alumnot.listaactividades;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ActividadesDePruebas extends ListActivity {

    String practicas[] = {"Intents_Act_01","Intents_Act_02","Intents_Act_03","CicloDeVida","Pulsame","ImplicitIntents"};


   final static String TAG= ActividadesDePruebas.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_de_pruebas);
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, practicas);

        setListAdapter(adaptador);}

    @Override
    protected void onListItemClick(ListView lista, View vista,int posicion, long id){
        super.onListItemClick(lista, vista, posicion, id);
        String nombrePractica = practicas[posicion];
        String uri = "com.example.alumnot.listaactividades."+nombrePractica;
        Log.d(TAG,uri);
        try{
            Class<?> clase= Class.forName(uri);
            Intent intent = new Intent(this,clase);
            startActivity(intent);

        }catch(ClassNotFoundException e){


            Log.d(TAG, e.getMessage());

     }catch(Exception e){


        Log.d(TAG, e.getMessage());
    }

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividades_de_pruebas, menu);
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
