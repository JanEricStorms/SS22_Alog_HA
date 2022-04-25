package ha.jan.janha04;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    private ArrayList<Integer> feld;

    /**
     * Konstruktor der Klasse Heap <br>
     * Initialisiert die Datenstrucktur hinter dem Heap, <br>
     * und setzt einen Blocker fuer die 0-Position der ArrayList
     */
    public Heap(){
        feld = new ArrayList<>();
        feld.add(0,null);
    }

    /**
     * Diese Methode dient der Ueberpruefung ob der Heap leer ist oder nicht <br>
     * @return boolean > true, wenn Heap leer, anderenfalls false
     */
    public boolean isEmpty(){
        if(feld.size() == 1){
            return true;
        }
        return false;
    }

    /**
     * Diese Methode dient dem Hinzufuegen eines neuen Elementes zum Heap <br>
     * @param i > int der dem Heap hizugefuegt werden soll
     */
    public void add(int i){
        feld.add(i);
        upheap();
    }

    /**
     * Diese Methode entfernt das groeste Element des Heaps und gibt dieses zurueck <br>
     * @return int > Gibt das entfernte Element zurueck
     */
    public int getMax(){
        int max = feld.get(1);
        downheap();
        return max;
    }

    /**
     * Diese Methode gibt den Heap als String zurueck
     * @return String > Gibt den Heap ohne den Platzhalter zurueck
     */
    public String toString(){
        ArrayList<Integer> result = (ArrayList<Integer>) feld.clone();
        result.remove(0);
        return result.toString();
    }

    /**
     * Diese Methode ist fuer die ordnungsgemaesse Einsortierung des eingefuegten Wertes zustaendig <br>
     * Dazu performt sie einen Upheap. <br>
     * Dabei wird das zuletzt eingefuegte Element, solange mit seinen Eltern verglichen und vertauscht, <br>
     * bis sein Elternpunkt groesser ist und beide seiner Kinder kleiner sind.
     */
    private void upheap(){
        int lastindex = feld.size()-1;
        while(lastindex > 1 && (feld.get(lastindex) > feld.get(lastindex/2))){
            Collections.swap(feld,lastindex,lastindex/2);
            lastindex = lastindex/2;
        }
    }
    /**
     * Diese Methode ist fuer die ordnungsgemaesse umsortierung nach entfernen des groessten Elementes verantwortlich <br>
     * Dazu performt sie einen downheap. <br>
     * Dabei wird das letzte Element mit dem Wurzelelement vertauscht. <br>
     * Dann wird das Wurzelelement aus dem Heap gelöscht, und das neue Wurzelelement wird mit seinen Kindern verglichen und vertauscht. <br>
     * Dabei wird mit dem groesseren der beiden Kinder getauscht, solange bis das Element einen groesseren Elternknoten und kleinere Kinderknoten hat.
     */
    private void downheap(){
        int index = 1 ;
        Collections.swap(feld, index, feld.size()-1);
        feld.remove(feld.size()-1);
        while(index*2 <= feld.size()-1){
             if((index*2 +1 <= feld.size()-1) && (feld.get(index) < feld.get(index*2) || feld.get(index) < feld.get(index*2 +1))){
                 if(feld.get(index*2) > feld.get(index*2 +1)){
                     Collections.swap(feld,index,index*2);
                     index = index*2;
                 }else{
                     Collections.swap(feld,index,index*2 +1);
                     index = index*2 +1;
                 }
             }else{
                 if(index*2 == feld.size()-1 && feld.get(index) < feld.get(index*2)){
                     Collections.swap(feld, index, index*2);
                 }
                 index = index*2;
             }
        }
    }

}
