import java.io.*;
import java.util.*;

public class Graphs {

    ArrayList<Room> roomlist = new ArrayList<Room>();
    ArrayList<Room> path = new ArrayList<Room>();
    int cost=0;
    boolean reachable;
    int health = 100;
    int pots =0;

    public static void main(String[] args){
        Graphs n = new Graphs();
        n.readMap();
        n.search(n.roomlist.get(0));

        if (!n.reachable){
            System.out.println("'Zelda' cannot get a heart container in this dungeon.");
        }
        else {
            System.out.println("The path to take is: ");
            Collections.reverse(n.path);
            for(Room d: n.path){
                System.out.print(d.name + " ");
            }
            System.out.println();
            System.out.println("And it takes "+ n.cost + " steps to get there.");
            System.out.println("He will need to use " + n.pots + " potions.");
        }

    }

    /**
     * Read map, create rooms, and set adjacency.
     * Change file name to run another graph.
     */
    public void readMap(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("map_0000-1.txt"));
            for (int i = 0; i<7; i++ ){
                br.readLine();
            }

            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(" ");

                if (Arrays.toString(values).contains("X")){
                    Room a = new Room("X");
                    roomlist.add(a);
                }

                Room n = new Room(values);
                roomlist.add(n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Room r: roomlist){
            for(Room t: roomlist){
                for(int i =0; i<t.adj.size(); i++ ){
                    if (Arrays.toString(t.adj.get(i)).contains(r.name)){
                        t.adjacents.add(r);
                    }
                }
            }
        }
    }

    /**
     * Search for the target room.
     * @param v Room to to start the search from.
     */
    public void search(Room v){
        String target = "X";
        v.visited = true;

        if (v.name.equals(target)){
            System.out.println("There is a heart container to be found! ");
            reachable = true;
            path.add(v);
            inPath(v);
            return;
        }

        for(Room w: v.adjacents){
            if (!w.visited){
                search(w);
            }
        }
    }

    /**
     * Backtrack back to the start and insert the rooms in the path list.
     * @param o The room to backtrack from.
     */
    public void inPath(Room o){

        for (Room r: roomlist){
            for (Room rm: path){
                if (rm.name.equals("A")) return;
            }

            if (r.adjacents.contains(o)){
                for (String[] sa: r.adj){
                    if (Arrays.toString(sa).contains(o.name)){
                        health -= Integer.parseInt(sa[1]);
                        cost += Integer.parseInt(sa[1]);

                        while(health <= 0){
                            health += 50;
                            pots += 1;
                        }
                    }
                }

                if (!path.contains(r)){
                    path.add(r);
                    inPath(r);
                }
                return;
            }
        }
    }

}