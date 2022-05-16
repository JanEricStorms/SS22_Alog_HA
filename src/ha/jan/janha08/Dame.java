package ha.jan.janha08;

import java.util.ArrayList;
import java.util.Arrays;

public class Dame {

    /**
     * Rekursiver anstoss
     * @param brettgroesse > Groesse des Schachfeldes
     */
    public static void damenProblem(int brettgroesse){
        ArrayList<Integer> position = new ArrayList<>();
        damenProblem(position,brettgroesse);
    }

    /**
     * Rekursive Methode fuer das Backtracking um alle moeglichkeiten auszugeben. <br>
     * @param pos > ArrayList, die die Positionen enthaelt.
     * @param brettgroesse > Groesse des Schachbrettes
     */
    private static void damenProblem(ArrayList<Integer> pos, int brettgroesse){
        if(pos.size() == brettgroesse){
            System.out.println(Arrays.toString(pos.toArray()));
        }else {
            for (int i = 1; i <= brettgroesse; i++) {
                pos.add(i);
                if (isValid(pos)) {
                    damenProblem(pos, brettgroesse);
                }
                pos.remove(pos.size() - 1);
            }
        }
    }


    /**
     * Diese Methode ueberprueft ob die Position der zuletzt hinzugefuegten Dame gueltig ist. <br>
     * Dazu wird aus der ArrayList das letzte Element entfernt und abgespeichert. <br>
     * Zuerst wird dann Ueberprueft, ob die Entfernte Zahl nochmal in der ArrayList enthalten ist. <br>
     * Falls schon, dann wird *false* returned. <br>
     * Ansonsten wird ueberprueft, ob es eine Diagonale verbindung zu einer anderen Dame gibt. <br>
     * Falls dies so ist, wird *false* returned.
     * Wenn keine der beiden Abfragen false returned dann is die Position gueltig und es wird true returned. <br>
     * @param pos > Die ArrayList mit den Positionen, wobei die letzte ueberprueft wird.
     * @return boolean > false wenn position nicht erlaubt ist, true wenn es keine probleme gibt.
     */
    private static boolean isValid(ArrayList<Integer> pos){
        int last = pos.remove(pos.size()-1);
        if(pos.contains(last)){
            pos.add(last);
            return false;
        }
        for(int i = 0; i < pos.size(); i++){
            if(Math.abs(pos.size()-i) == Math.abs((pos.get(i) - last))){
                pos.add(last);
                return false;
            }
        }
        pos.add(last);
        return true;
    }

    public static void main(String[] args) {
       damenProblem(6);

    }
}
