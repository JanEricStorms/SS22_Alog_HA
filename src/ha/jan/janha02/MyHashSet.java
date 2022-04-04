package ha.jan.janha02;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author Svenja, Jan-Eric, Justin
 * @param <K> > Type of HashSet (z.B. Integer, String
 */
public class MyHashSet<K>{

    private Hashtable<Integer, ArrayList<K>> myHash;
    private int numberOfElements;
    private int size;

    /**
     * Konstruktor der Klasse {@link MyHashSet} </br>
     * Erzeugt die HashTabelle, setzt die numberOfElements auf 0, und die initzial groesse von Size auf 10 </br>
     */
    public MyHashSet(){
        myHash = new Hashtable<>();
        numberOfElements = 0;
        size = 10;
        initializeHashtable();
    }

    /**
     * Prueft den Fuellgrad der HashTabelle, </br>
     * falls dieser groeßer als 2 ist wird die HashTabelle rebased mit size*2
     */
    private void checkFillLvl(){
        if((numberOfElements+1)/size >= 2){
            rebaseMyHash();
        }
    }

    /**
     * Diese Methode kopiert sich alle Werte der Hashtabelle mit der getElements Methode, </br>
     * vergroessert den Wert size auf das doppelte der HashTabelle und cleared die HashTabelle. </br>
     * Danach wird die HashTabelle initialisiert und die Werte in die neue HashTabelle einsortiert.
     */
    private void rebaseMyHash(){
        ArrayList<K> allValues = getElements();
        size = 2*myHash.size();
        myHash.clear();
        initializeHashtable();
        int hashCode;
        for(int i = 0; i < allValues.size();i++){
            hashCode = allValues.get(i).hashCode()%size;
            ArrayList<K> existingValues = this.myHash.get(hashCode);
            existingValues.add(allValues.get(i));
            this.myHash.put(hashCode, existingValues);
        }


    }

    /**
     * Fuegt der HashTabelle ein Element hinzu, falls dieses nicht schon enthalten ist </br>
     * @param element > Element des Typ K </br>
     * @return boolean > True wenn das Element schon enthalten ist, false wenn das Element neu ist. </br>
     */
    public boolean add(K element){
        checkFillLvl();
        int hashCode = Math.abs(element.hashCode()%size);
        if(contains(element)){
            return true;
        }else{
            ArrayList<K> list = this.myHash.get(hashCode);
            list.add(element);
            this.myHash.put(hashCode,list);
            numberOfElements++;
            return false;
        }
    }

    /**
     * Entfernt aus der HashTabelle ein Element, falls dieses enthalten ist </br>
     * @param element > Element des Typ K </br>
     * @return boolean > True wenn das Element enthalten ist, false wenn das Element nicht enthalten ist. </br>
     */
    public boolean delete(K element){
        int hashCode = Math.abs(element.hashCode()%size);
        if(contains(element)){
            ArrayList<K> list = this.myHash.get(hashCode);
            list.remove(element);
            this.myHash.put(hashCode, list);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Entfernt aus der HashTabelle ein Element, falls dieses enthalten ist </br>
     * @param element > Element des Typ K </br>
     * @return boolean > True wenn das Element enthalten ist, false wenn das Element nicht enthalten ist. </br>
     */
    public boolean contains(K element ){
        int hashCode = Math.abs(element.hashCode()%size);
        if(this.myHash.get(hashCode).contains(element)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Gibt eine ArrayList< K > zurueck die alle Elemente der HashTabelle enthaelt
     * @return ArrayList > Enthaelt alle Elemente der HashTabelle
     */
    public ArrayList<K> getElements(){
        ArrayList<K> newList = new ArrayList<>();
        for (int i = 0; i < size;i++){
            ArrayList<K> list = this.myHash.get(i);
            for(int j = 0; j < list.size(); j++){
                newList.add(list.get(j));
            }
        }
        return newList;
    }

    /**
     * Initialisiert die HashTabelle
     */
    private void initializeHashtable(){
        for (int i = 0; i < size;i++){
            this.myHash.put(i, new ArrayList<K>());
        }
    }

}
