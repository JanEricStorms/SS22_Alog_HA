package ha.svenja.ha03;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Svenja Zillekens, Justin Jansen, Jan-Eric Storms
 *
 */
public class LinkedList implements IList {

    // einfach verkettete Liste mit Daten:
    private Node head;
    private int elements;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    @Override
    public void insertAt(int index, int value) {
        validIndex(index);
        Node element = new Node(value);
        if (index == 0) {
            // Element an erste Stelle hinzufuegen
            element.next = this.head;
            this.head = element;
        }  else {
            element.next = getElement(index);
            getElement(index-1).next = element;
        }
        this.elements++;
    }

    /**
     * Methode gibt Node an einer bestimmten Position zurueck
     *
     * @param index		Position
     * @return			Knoten an bestimmter Position
     */
    public Node getElement(int index) {
        validIndex(index);
        int count = 0;
        Node element = head;
        while (count != index) {
            count ++;
            element = element.next;
        }
        return element;
    }

    public void removeAt(int index) {
        validIndex(index);
        if (index == 0) {
            // erste Stelle entfernen
            this.head = this.head.next;
        } else if (index == this.elements) {
            // letzte Stelle entfernen
            getElement(index-1).next = null;
        } else {
            getElement(index-1).next = getElement(index+1);
        }
        this.elements--;
    }

    @Override
    public int getAt(int index) {
        return getElement(index).data;
    }

    @Override
    public int search(int value) {
        int index = 0;
        Node element = this.head;
        for (int i = 0; i < this.elements; i++) {
            if (element.data == value) {
                return index;
            }
            element = element.next;
            index++;
        }
        throw new NoSuchElementException("Value not found");
    }

    @Override
    public void clear() {
        this.head = null;
        this.elements = 0;
    }

    @Override
    public int getCount() {
        return this.elements;
    }

    /**
     * Gibt eine Liste mit den Elementen der LinkedList zurueck
     *
     * @return 		ArrayList
     */
    public ArrayList<Integer> printElements() {
        ArrayList<Integer> result = new ArrayList<>();
        Node el = this.head;

        while (el != null) {
            result.add(el.data);
            el = el.next;
        }
        return result;
    }

    /**
     * Wirft Exception, wenn der Index negativ oder groesser als die Liste lang ist
     *
     * @param index
     * @throws ArrayIndexOutOfBoundsException
     */
    public void validIndex(int index) {
        if (index < 0 || index > (elements + 1)) {
            throw new ArrayIndexOutOfBoundsException("Index ist ungueltig");
        }
    }

}
