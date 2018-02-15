package com.orbita.innovacion.ejemplo08gridview;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class App extends AppCompatActivity {

    private GridView gridView = null;
    private itemAdapter adapter = null;
    private ImageView img = null;
    private TextView nom = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView)findViewById(R.id.gridView);
        adapter = new itemAdapter(this,R.layout.row_grid,fillImages());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object fhater = (item) parent.getItemAtPosition(position);

                Bitmap imagen = ((item)fhater).getImage();
                String nombre = ((item)fhater).getName();

                ventana(imagen, nombre);

            }
        });

    }
    private ArrayList<item> fillImages(){
        int values =  Integer.parseInt(getResources().getString(R.string.howmanyimages));
        ArrayList<item>lista = new ArrayList<>();

        for(int i = 0; i <= values; i++ ) {
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), getResources().getIdentifier(
                    "sample_" + i, "drawable", "com.orbita.innovacion.ejemplo08gridview"));
            lista.add(new item(bitmap,"sample_" + i));
        }

        return lista;
    }

    private void ventana(Bitmap imagen, String nombre) {
        Dialog d = new Dialog(this);
        d.setContentView(R.layout.zoom);

        img = (ImageView) d.findViewById(R.id.imgZoom);
        nom = (TextView) d.findViewById(R.id.txtNombre);

        img.setImageBitmap(imagen);
        nom.setText(nombre);

        d.show();
    }

}
