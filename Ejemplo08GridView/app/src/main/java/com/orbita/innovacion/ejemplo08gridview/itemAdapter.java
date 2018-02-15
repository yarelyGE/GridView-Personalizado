package com.orbita.innovacion.ejemplo08gridview;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class itemAdapter extends ArrayAdapter {

    private Context context;
    private int LayoutR;
    private ArrayList items;

    public itemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<item> items) {
        super(context, resource, items);
        this.LayoutR = resource;
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        item user = (item)getItem(position);

        if (item == null){
            item = LayoutInflater.from(getContext()).inflate(this.LayoutR, parent, false);
        }
        TextView tvName = (TextView) item.findViewById(R.id.name);
        ImageView image = (ImageView) item.findViewById(R.id.image);

        tvName.setText(user.getName());
        image.setImageBitmap(user.getImage());

        //return super.getView(position, convertView, parent);
        return item;
    }

}
