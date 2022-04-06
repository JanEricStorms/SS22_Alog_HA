package ha03;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Klasse implementiert {@link IList} um eine einfach Verkettete Liste zuerstellen.
 *
 * @param <T>
 */
public class LinkedList<T> implements IList<T>
{

    private Node head;

    private class Node
    {
        T data;
        Node next;

        Node(T a)
        {
            data = a;
        }
    }

    @Override
    public boolean insertAt(T x, int p)
    {
        if(head == null)
        {
            if(p != 0)
            {
//                return false;
                throw new ArrayIndexOutOfBoundsException("Das erste Element muss an der Stelle p = 0 eingefuegt werden.");
            }else{
                head = new Node(x);
                return true;
            }
        }
        if(p <= getCount() && p >= 0)
        {
            Node new_Node = new Node(x);
            if(p == 0)
            {
                new_Node.next = head;
                head = new_Node;
                return true;
            }
            if(p == getCount())
            {
                getNodeAt(p-1).next = new_Node;
                return true;
            }
            new_Node.next = getNodeAt(p+1);
            getNodeAt(p-1).next = new_Node;
            return true;

        }
//        System.out.println("Das Element kann der Liste nicht hinzugefuegt werden, \n" +
//                "da sich die angegebene Position nicht im gueltigen Werte-Bereich befindet. \n" +
//                "Gueltiger Beeich: 0 bis " + getCount() + ". Angegebener Wert: " + p);
//        return false;
        throw new ArrayIndexOutOfBoundsException("Das Element kann der Liste nicht hinzugefuegt werden, \n" +
                "da sich die angegebene Position nicht im gueltigen Werte-Bereich befindet. \n" +
                "Gueltiger Beeich: 0 bis " + getCount() + ". Angegebener Wert: " + p);
    }

    @Override
    public boolean removeAt(int p)
    {
        if(p == 0)
        {
            head = head.next;
            return true;
        }
        if(p == getCount()-1)
        {
            getNodeAt(p-1).next = null;
            return true;
        }
        if(p > 0 && p < getCount()-1)
        {
            getNodeAt(p-1).next = getNodeAt(p+1);
            return true;
        }
//        return false;
        throw new ArrayIndexOutOfBoundsException("Es existiert keine Element an p = " + p);
    }

    @Override
    public T getAt(int p)
    {
        if(getNodeAt(p) == null)
        {
//            System.out.println("An der Stelle " + p + " existiert kein Element.");
//            return null;
            throw new ArrayIndexOutOfBoundsException("An der Stelle " + p + " existiert kein Element.");
        }
        return getNodeAt(p).data;
    }

    @Override
    public int search(T x)
    {
        Node pointer = head;
        for(int i = 0; i <getCount();i++)
        {
            if( pointer.data.equals(x))
            {
                return i;
            }
            pointer = pointer.next;
        }
        return -1;
//        throw new NoSuchElementException("Das Element ist nicht in der Liste enthalten"):
    }

    @Override
    public boolean clear()
    {
        head = null;
        return true;
    }

    @Override
    public int getCount()
    {
        if(head == null)
        {
            return 0;
        }
        int ret = 1;
        Node pointer = head;
        while(pointer.next != null)
        {
            ret++;
            pointer = pointer.next;
        }
        return ret;
    }

    /**
     * Die Methode gibt eine Node zurueck. </br>
     * @param p > Stelle der Node. </br>
     * @return Node > Gibt eine Node zurueck. </br>
     */
    private Node getNodeAt(int p)
    {
        if(p < 0 || p >= getCount())
        {
            return null;
        }
        Node pointer = head;
        for(int i  = 0; i < p;i++)
        {
            pointer = pointer.next;
        }
        return pointer;
    }

    private String asString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < getCount(); i++)
        {
            sb.append(getAt(i) + ",");
        }
        if(sb.length() > 1){
            sb.replace(sb.length()-1,sb.length()-1, "");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Diese Methode testet alle Funktionen der Liste.
     */
    public void testList()
    {
        System.out.println("Starte test der Liste.");
        System.out.println("Befuelle Liste mit 10 zufaelligen int Werten");
        Random rd = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i<10 ; i++)
        {
            System.out.println(list.insertAt(rd.nextInt(),i));
        }
        System.out.println("Ausgabe der Liste : " + list.asString());
        System.out.println("Entferne Element an p = 3");
        System.out.println(list.removeAt(3));
        System.out.println(list.asString());
        System.out.println("Element an p = 8 auslesen");
        System.out.println(list.getAt(8));
        System.out.println("Element an p = 0 entfernen");
        System.out.println(list.removeAt(0));
        System.out.println(list.asString());
        System.out.println("Element x = -1 an p = 3 einfuegen");
        System.out.println(list.insertAt(-1,3));
        System.out.println(list.asString());
        System.out.println("Element -1 suchen");
        System.out.println(list.search(-1));
        System.out.println("Element anzahl : " + list.getCount());
        System.out.println("Clear der Liste");
        System.out.println(list.clear());
        System.out.println(list.asString());
        System.out.println("Test der Liste beendet");


    }

}
