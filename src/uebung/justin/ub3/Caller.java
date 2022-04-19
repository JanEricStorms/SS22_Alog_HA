package uebung.justin.ub3;

public class Caller {

    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>();

        deque.addFirst(3);

        deque.addFirst(2);
        deque.addLast(213);
        deque.addLast(12);
        deque.removeFirst();

        System.out.println(deque.toArrayList());
    }
}
