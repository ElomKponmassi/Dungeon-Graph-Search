package edu.frostburg.cosc310.projects.Graphs;

import java.util.ArrayList;

public class Room {
    String name;

    boolean visited = false;

    ArrayList<String[]> adj = new ArrayList<String[]>();
    ArrayList<Room> adjacents = new ArrayList<Room>();
    public Room(String[]fs){
        name = fs[0];
        for(int i = 1; i<fs.length; i+=2){
            String[] f = {fs[i], fs[i + 1]};
            adj.add(f);

        }
    }

    public Room(String s){
        name = s;
    }





}
