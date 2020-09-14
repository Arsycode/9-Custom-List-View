package com.example.a9customlistview;

public class Superhero {
    int image;
    String name, team;

    public Superhero(int image, String name, String team){
        this.image = image;
        this.name = name;
        this.team = team;
    }

    public int getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public String getTeam(){
        return team;
    }
}
