package uebungen.jan.übung3jan;

import java.util.ArrayList;

public class MyDeque<T> {

    private Node head;
    private Node tail;


    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T a)
        {
            data = a;
        }
    }

    public void addFirst(T data)
    {
        Node new_Node = new Node(data);
        if(head == null && tail == null)
        {
            head = new_Node;
            tail = new_Node;
        }else
        {
            head.prev = new_Node;
            new_Node.next = head;
            head = new_Node;
        }
    }

    public void addLast(T data)
    {
        Node new_Node = new Node(data);
        if(head == null && tail == null)
        {
            head = new_Node;
            tail = new_Node;
        }else
        {
            tail.next = new_Node;
            new_Node.prev = tail;
            tail = new_Node;
        }
    }

    public T removeFirst()
    {
        if(head.next == null)
        {
            throw new LastElementException();
        }
        T removedObject = head.data;
        head.next.prev = null;
        head = head.next;
        return removedObject;
    }

    public T removeLast()
    {
        if(tail.prev == null)
        {
            throw new LastElementException();
        }
        T removedObject = tail.data;
        tail.prev.next = null;
        tail = tail.prev;
        return removedObject;
    }

    public ArrayList<T> toArrayList()
    {
        ArrayList<T> ret = new ArrayList<>();
        Node pointer = head;
        while(pointer.next != null)
        {
            ret.add(pointer.data);
            pointer = pointer.next;
        }
        ret.add(pointer.data);
        return ret;
    }

    public ArrayList<T> toReverseArrayList()
    {
        ArrayList<T> ret = new ArrayList<>();
        Node pointer = tail;
        while(pointer.prev != null)
        {
            ret.add(pointer.data);
            pointer = pointer.prev;
        }
        ret.add(pointer.data);
        return ret;
    }
}
