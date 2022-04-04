package ha.svenja.ha02;

import java.util.ArrayList;

public class MyHashSet<K> {

    private ArrayList<K>[] tabelle;

    public MyHashSet() {
        this.tabelle = new ArrayList[10];
    }

    public boolean add(K element) {
        if(contains(element)) {
            return true;
        }

        if (((getElements().size()+1) / this.tabelle.length) >= 2) {
            ArrayList<K>[] alteTabelle = this.tabelle.clone();
            this.tabelle = new ArrayList[2*this.tabelle.length];
            for (ArrayList<K> list: alteTabelle) {

                for (K value: list) {
                    this.add(value);
                }
            }
        }

        int mod = Math.abs(element.hashCode()) % this.tabelle.length;

        if (this.tabelle[mod] == null) {
            ArrayList<K> temp = new ArrayList<>();
            temp.add(element);
            this.tabelle[mod] = temp;
        } else {
            this.tabelle[mod].add(element);
        }
        return false;

    }

    public boolean delete(K element) {

        int mod = Math.abs(element.hashCode()) % this.tabelle.length;
        return this.tabelle[mod].remove(element);
    }

    public boolean contains(K element) {
        int mod = Math.abs(element.hashCode()) % this.tabelle.length;
        if (this.tabelle[mod] == null) {
            return false;
        }
        for (int i = 0; i < this.tabelle[mod].size(); i++) {
            if (this.tabelle[mod].get(i) == (Integer) element) {
                return true;
            }
        }
        return false;

    }

    public ArrayList<K> getElements() {
        ArrayList<K> res = new ArrayList<>();
        for (int i = 0; i < this.tabelle.length; i++) {
            if (this.tabelle[i] == null) {
                continue;
            }
            for (int j = 0; j < this.tabelle[i].size(); j++) {
                res.add(this.tabelle[i].get(j));
            }
        }
        return res;
    }
}
