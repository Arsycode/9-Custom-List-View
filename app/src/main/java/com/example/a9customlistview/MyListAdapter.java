package com.example.a9customlistview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Superhero> {

    List<Superhero> superheroList;
    Context context;
    int resource;

    public MyListAdapter(Context context, int resource, List<Superhero> superheroList){
        super(context, resource, superheroList);
        this.context = context;
        this.resource = resource;
        this.superheroList = superheroList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textNameView);
        TextView textViewTeam = view.findViewById(R.id.textViewTeam);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        Superhero superhero = superheroList.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(superhero.getImage()));
        textViewName.setText(superhero.getName());
        textViewTeam.setText(superhero.getTeam());

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeHero(position);
            }
        });
        return view;
    }

    private void removeHero(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                superheroList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
