package ha.svenja.ha03;

public class Test {

    /**
     * Testmethode, die alle Methoden der Klasse LinkedList testet.
     */
    public static void testList() {
        LinkedList liste = new LinkedList();

        liste.insertAt(0, 5);
        liste.insertAt(1, 14);
        liste.insertAt(1, 20);
        liste.insertAt(3, 39);
        liste.insertAt(2, 678);
        liste.insertAt(0, 592);

        System.out.println("Liste: " + liste.printElements());
        System.out.println("Search: " + liste.search(39));
        System.out.println("GetAt: " + liste.getAt(2));

        liste.removeAt(2);
        liste.removeAt(0);
        liste.removeAt(2);
        System.out.println("Liste: " + liste.printElements());

        liste.clear();
        System.out.println("Liste: " + liste.printElements());
    }

    /**
     * Main-Methode ruft die Testmethode auf.
     * @param args
     */
    public static void main(String[] args) {
        testList();
    }
}

