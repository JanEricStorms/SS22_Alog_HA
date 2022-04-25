package ha.jan.janha04;

public class Main {
    public static void main(String[] args) {
        Heap h = new Heap();
        System.out.println(h);
        int[] add = {1,6,8,18,23,5,17,20,26,21,9};
        for(int i = 0; i < add.length; i++){
            h.add(add[i]);
            System.out.println(h);
        }
        System.out.println();
        while(h.isEmpty() != true){
            System.out.println(h.getMax());
            System.out.println(h);
        }
    }
}
