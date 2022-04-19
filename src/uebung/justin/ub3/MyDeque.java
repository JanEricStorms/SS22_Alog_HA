package uebung.justin.ub3;

import java.util.ArrayList;

public class MyDeque<T> {

    private Node<T> head;

    private Node<T> tail;

    public MyDeque(){

    }

    public void addFirst(T value){

        Node<T> newNode = this.createNode(value);
        
        if (this.head != null) {
            head.setPrev(newNode);
            newNode.setNext(head);
            this.tail = this.head;
            this.head = newNode;
            return;
        }
        if (this.tail != null) {
            newNode.setNext(this.tail);
            this.tail.setPrev(newNode);
        }
        this.head = newNode;

    }

    public void addLast(T value){

        Node<T> newNode = this.createNode(value);

        if (this.tail != null){
            tail.setNext(newNode);
            newNode.setPrev(tail);
            this.tail = newNode;
            return;
        }
        if (this.head != null) {
            System.out.println("head nicht leer");
            newNode.setPrev(this.head);
            this.head.setNext(newNode);
        }
        this.tail = newNode;
    }

    public void removeFirst(){
        if (this.head != null) {
            this.head.getNext().setPrev(null);
            this.head = null;
        }
    }

    public void removeLast(){
        if (this.tail != null) {
            this.tail.getPrev().setNext(null);
            this.tail = null;
        }
    }

    private Node<T> createNode(T value){
        return new Node<T>(value);
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> list = new ArrayList<>();

        return recursiveString(list, this.head);
    }

    private ArrayList<T> recursiveString(ArrayList<T> list, Node<T> nextNode){

        list.add(nextNode.getData());
        if (nextNode.getNext() != null){
            recursiveString(list, nextNode.getNext());
        }
        return list;
    }
}
