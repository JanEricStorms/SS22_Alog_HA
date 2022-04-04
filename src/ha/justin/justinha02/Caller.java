package ha.justin.justinha02;

public class Caller {

    public static void main(String[] args) {
        MyHashSet<Integer> table = new MyHashSet<>();

        for (int i = 0; i < 30; i++){
            table.add(i);
        }
        System.out.println(table.getElements());
        System.out.println(table.contains(13));

    }
}
