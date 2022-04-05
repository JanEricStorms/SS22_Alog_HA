package uebungen.jan.übung3jan;

public class Main {
    public static void main(String[] args) {
        MyDeque<Integer> md = new MyDeque<>();
        md.addFirst(5);
        md.addLast(10);
        md.addLast(15);
        md.addLast(20);
        md.addLast(25);
        md.addFirst(0);

        System.out.println(md.toArrayList().toString());
        System.out.println(md.removeFirst());
        System.out.println(md.removeLast());
        System.out.println(md.toReverseArrayList().toString());
    }

}
