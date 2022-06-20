package ha.jan.janha13;

import java.util.ArrayList;

public class NFA {

    /**
     * ADJAZENS LISTE
     */
    private ArrayList<ArrayList<String>> adj;
    private int zielKnoten;

    /**
     * Konstruktor der die AdjazenzListe initialisiert. </br>
     * Liest den String geordnet aus. Splittet zuerst am "," </br>
     * und liest die Werte dann aus und traegt sie in der liste ein. </br>
     * @param x > String der die Kantenliste enthaelt
     */
    public NFA(String x){
        adj = new ArrayList<>();
        String[] split = x.split(",");
        for( int i = 0; i <= Integer.parseInt(split[0]);i++){
            adj.add(new ArrayList<String>());
        }
        zielKnoten = Integer.parseInt(split[1]);
        ArrayList<String> temp;
        for(int i = 2; i < split.length;i=i+3){
            int index = Integer.parseInt(split[i]);
            temp = adj.remove(index);
            temp.add("" + split[i+2] + split[i+1]);
            adj.add(index, temp);
        }

        for (int i = 0; i < adj.size(); i++){
            System.out.println(i + " " +adj.get(i));
        }
    }

    /**
     * Rekursiver aufruf von Aussen </br>
     * @param s > String der geprueft werden soll </br>
     * @return boolean > True, wenn String zum Paettern passt, false, wenn nicht. </br>
     */
    public boolean testString(String s){
        return testString(s, 1);
    }

    /**
     * Rekursiver aufruf von innen </br>
     * Liest den ersten Character des Strings aus. </br>
     * Nimmt sich die passende Liste und schaut ob der Char. enthalten ist, </br>
     * wenn, dann ruft er sich wieder von vorne auf bis der String weg ist </br>
     * und man am Zielknoten ist. </br>
     * param s > String der geprueft werden soll </br>
     * @param current > int der die aktuelle position angibt </br>
     * @return boolean > True, wenn String zum Paettern passt, false, wenn nicht. </br>
     */
    private boolean testString(String s, int current){
        ArrayList<String> possible;
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            possible = adj.get(current);
            for(String x : possible){
                if(x.startsWith("" + c)){
                    if(testString(s.substring(1), Integer.parseInt(""+x.charAt(1))) == true){
                        return true;
                    }
                }
            }
        }
        if( current == zielKnoten && s.length() == 0){
            return true;
        }
        return false;
    }
}
