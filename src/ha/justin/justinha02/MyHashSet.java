package ha.justin.justinha02;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Klasse zur Implementierung einer Hashtabelle mit Teillisten
 *
 * @author Justin Jansen <jjansen@databay.de>
 * @author Jan Eric
 * @author Svenja Zillekens
 * @param <K> > Hashtabellen Typ von K
 */
public class MyHashSet<K> {

    private Hashtable<Integer, ArrayList<K>> table;

    private Integer size = 10;
    private Integer elements = 0;
    private Integer maxLoadFactor = 2;

    public MyHashSet() {
        this.table = new Hashtable<>();
        reHash(true);
    }

    /**
     * Berechnet den Hashcode mit angebenen Parameter
     *
     * @param element > des Types K
     * @return int > Hashcode
     */
    public int hashCode(K element) {
        return Math.abs(element.hashCode() % this.table.size());
    }

    /**
     * Fuegt das angegebene Element der Hashtabelle mit seinem Hashcode hinzu
     *
     * @param element > des Types K
     * @return boolean > false, wenn element hinzugefuegt wurden ist
     */
    public boolean add(K element){

        ArrayList<K> list = getListOfHashcode(this.hashCode(element));
        if (list != null && !list.contains(element)) {
            sizeCheck();
            list.add(element);
            this.elements++;
            return false;
        }
        return true;
    }

    /**
     * Entfernt das angegebene Element aus der Hashtabelle, falls vorhanden
     *
     * @param element > des Types K
     * @return boolean > true, wenn entfernt
     */
    public boolean delete(K element){

        ArrayList<K> list = getListOfHashcode(this.hashCode(element));
        if (list != null && list.contains(element)) {
            list.remove(element);
            this.elements--;
            return true;
        }
        return false;
    }

    /**
     * Ueberprueft ob das angegebene element in der Hashtabelle ist
     *
     * @param element > des Types k
     * @return boolean > true
     */
    public boolean contains(K element){

        ArrayList<K> list = getListOfHashcode(this.hashCode(element));

        if (list != null) {
            return list.contains(element);
        }

        return false;
    }

    /**
     * Gibt die Teilliste von dem angegebenen Hashcode zurueck, falls vorhanden
     *
     * @param Hashcode > Integer
     * @return ArrayList<K>|null
     */
    private ArrayList<K> getListOfHashcode(Integer Hashcode){

        return this.table.get(Hashcode);
    }

    /**
     * Gibt alle Elemente in der Hashtabelle zurueck
     *
     * @return ArrayList<K> > Liste
     */
    public ArrayList<K> getElements(){
        ArrayList<K> totalList = new ArrayList<>();

        for (ArrayList<K> list : this.table.values()){
            totalList.addAll((ArrayList<K>) list.clone());
        }
        return totalList;
    }

    /**
     * Ueberprueft ob der Fuellstand von der Hashtabelle maxLoadFactor ueberschreitet, dann reHash
     *
     * @return boolean > true, Fuellstand ueberschritten
     */
    public boolean sizeCheck(){

        if ((this.elements / this.size) >= this.maxLoadFactor) {
            reHash(false);
            return true;
        }
        return false;
    }

    /**
     * reHashed die Hashtabelle mit allen Teillisten, platziert die vorhandenen Werte neu <br>
     * Falls initialize, dann wird die Hashtabelle mit size Teillisten initialisiert.
     *
     * @param initialize > true, Initialisiere die Hashtabelle
     */
    private void reHash(boolean initialize){

        if (initialize) {
            for (int i = 0; i < this.size; i++){
                this.table.put(i, new ArrayList<K>());
            }
            return;
        }

        Hashtable<Integer, ArrayList<K>> backUpTable = (Hashtable<Integer, ArrayList<K>>) this.table.clone();
        this.table.clear();

        this.size *= 2;
        reHash(true); // initialises the hashtable with more arrayList, then goes on and reHashes all existing values
        for (ArrayList<K> list : backUpTable.values()){
            for (K value : list){
                add(value);
            }
        }
    }
}
