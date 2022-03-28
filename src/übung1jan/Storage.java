package übung1jan;

import java.util.Arrays;

public class Storage {
    private int[] speicher = new int[10];

    public boolean isEmpty() {
        return speicher.length == 0;
    }

    public void add(int item) {
        if (!isEmpty()) {
            int[] tempArray = new int[speicher.length + 1];
            for (int i = 0; i < speicher.length; i++) {
                tempArray[i] = speicher[i];
            }
            tempArray[tempArray.length - 1] = item;
            speicher = tempArray;
        } else {
            speicher = new int[speicher.length + 1];
            speicher[0] = item;
        }
    }


    public static void main(String[] args) {
        Storage st = new Storage();
        for (int i=0; i<30; i++) {
            st.add(i*2);
            System.out.println(st);
        }
    }
}
