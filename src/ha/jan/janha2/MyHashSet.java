package ha.jan.janha2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class MyHashSet<K>{

    private Hashtable<Integer, ArrayList<K>> myHash;
    private int numberOfElements;
    private int size;

    @Override
    public int hashCode(){
//        System.out.println("HashCode" + super.hashCode());
//        System.out.println("size" + size);
//        System.out.println("Value " +(super.hashCode()%size));
        return Math.abs(super.hashCode() % size);
    }

    public MyHashSet(){
        myHash = new Hashtable<>();
        numberOfElements = 0;
        size = 10;
        initializeHashtable();
    }

    private void checkFillLvl(){
        if((numberOfElements+1)/size >= 2){
            rebaseMyHash();
        }
    }

    private void rebaseMyHash(){
        ArrayList<K> allValues = getElements();
        size = 2*myHash.size();
        myHash.clear();
        initializeHashtable();
        int hashCode;
        for(int i = 0; i < allValues.size();i++){
//            hashCode = allValues.get(i).hashCode();
            hashCode = allValues.get(i).hashCode()%size;
            ArrayList<K> existingValues = this.myHash.get(hashCode);
            existingValues.add(allValues.get(i));
            this.myHash.put(hashCode, existingValues);
        }


    }

    public boolean add(K element){
        checkFillLvl();
//        int hashCode = element.hashCode();
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

    public boolean delete(K element){
//        int hashCode = element.hashCode();
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

    public boolean contains(K element ){
//        int hashCode = element.hashCode();
        int hashCode = Math.abs(element.hashCode()%size);
        if(this.myHash.get(hashCode).contains(element)){
            return true;
        }else{
            return false;
        }
    }

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

    private void initializeHashtable(){
        for (int i = 0; i < size;i++){
            this.myHash.put(i, new ArrayList<K>());
        }
    }

}
