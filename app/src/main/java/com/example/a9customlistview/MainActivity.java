package com.example.a9customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Superhero> superheroList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superheroList = new ArrayList<>();
        listView = findViewById(R.id.listview);

        superheroList.add(new Superhero(R.drawable.batman, "Batman", "Light"));
        superheroList.add(new Superhero(R.drawable.captainamerica, "Captain America", "Dark"));
        superheroList.add(new Superhero(R.drawable.doctorstrange, "Doctor Strange", "Light"));
        superheroList.add(new Superhero(R.drawable.ironman, "Iron Man", "Dark"));
        superheroList.add(new Superhero(R.drawable.joker, "Joker", "Light"));
        superheroList.add(new Superhero(R.drawable.spiderman, "Spiderman", "Dark "));

        MyListAdapter adapter = new MyListAdapter(this, R.layout.my_custom_list, superheroList);
        listView.setAdapter(adapter);

    }
}