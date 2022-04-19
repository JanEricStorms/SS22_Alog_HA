package ha.justin.ha05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Heap {

    private ArrayList<Integer> data;

    public Heap(){
        this.data = new ArrayList<>(){{
            add(0);
        }};
        System.out.println(this.data.size());
    }

    public boolean isEmpty() {
        return (this.data.size() == 1);
    }

    public void add(int i){
        this.data.add(i);

        this.resort();

    }

    public void clear(){
        this.data.clear();
        this.data.add(null);
    }
    public int getMax() {
        Integer maxValue = this.data.get(1);

        this.data.remove(1);
        this.resort();
        return maxValue;
    }

    private void resort() {

        int pos = this.data.size()-1;

        while (pos > 1 && this.data.get(pos) > this.data.get(pos/2)) {
            Collections.swap(this.data, pos, pos/2);
            pos = pos/2;
        }
    }

    public String toString(){
        return this.data.toString();
    }

    public static void main(String[] args) {

        // 1, 6, 8, 18, 23, 5, 17, 20, 26, 21, 9
        int[] array = new int[]{1,6,8,18,23,5,17,20,26,21,9};

        Heap heap = new Heap();
        for ( int value : array) {
            heap.add(value);
            System.out.println(heap);
        }
        System.out.println("----------------------------------------");
        while (!heap.isEmpty()) {
            System.out.println(heap.getMax());
            System.out.println(heap);
        }
    }
}
