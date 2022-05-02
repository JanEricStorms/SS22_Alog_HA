package ha.jan.janha06;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Jedes Objekt dieser Klasse dient der Speicherung eines Graphen
 * mit Hilfe von Adjazenzlisten wie in der Vorlesung definiert.<br>
 * Loesung zu algo-h06 im SS 2022.
 */
public class MyGraph extends Graph {
  //TODO: Die noetigen Konstruktoren implementieren
  //TODO: Implementation der im Aufgabentext gewuenschten Operationen.
    public MyGraph(int v){
        super(v);
    }

    public MyGraph(int v, int x){
        super(v,x);
    }

    public MyGraph(int[] list){
        super(list);
    }

  /**
   * Erzeugt eine Kantenliste
   * @return ArrayList > Kantenliste des Grafen
   */
  public ArrayList<Integer> getEdgeList(){
      ArrayList<Integer> list = new ArrayList<>();
      list.add(super.getVertexCount());
      list.add(super.getEdgeCount());
      for(int i = 1;i <= list.get(0);i++){
        ArrayList<Integer> nachfolger = super.getAdjacent(i);
        for(int j = 0; j < nachfolger.size();j++){
          list.add(i);
          list.add(nachfolger.get(j));
        }
      }
      return list;
    }

  /**
   * Erzeugt eine Knotenliste
   * @return ArrayList > Knotenliste des Grafen
   */
    public ArrayList<Integer> getVertexList(){
      ArrayList<Integer> list = new ArrayList<>();
      list.add(super.getVertexCount());
      list.add(super.getEdgeCount());
      for(int i = 1; i <= list.get(0);i++){
        ArrayList<Integer> nachfolger = super.getAdjacent(i);
        int verbindungen = nachfolger.size();
        list.add(verbindungen);
        for( int j = 0; j < verbindungen; j++){
          list.add(nachfolger.get(j));
        }
      }
      return list;
    }

    /**
    * Erzeugt eine Adjacenzmatrix
    * @return ArrayList > Adjazenmatrix des Grafen
    */
    public int[][] getAdjacencyMatrix(){
      ArrayList<Integer>[] adjList = new ArrayList[super.getVertexCount()];
      for(int i = 1; i <= super.getVertexCount();i++){
        adjList[i-1] = super.getAdjacent(i);
      }
      int[][] matrix = new int[super.getVertexCount()][super.getVertexCount()];
      for(int i = 0;i < adjList.length;i++){
        for(int j = 0; j < adjList.length; j++){
          if(adjList[i].contains(j+1)){
            matrix[i][j] = 1;
          }else{
            matrix[i][j] = 0;
          }
        }
      }
      return matrix;
    }

  /**
   * Fuehrt die Breitensuche durch und gibt die erreichten Elemente zurueck
   * @param start > Position des Anfangs Knoten
   * @return ArrayList > Erreichte Knoten
   */
  public ArrayList<Integer> bfs(int start){
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> adjList;
      boolean[] check= new boolean[super.getVertexCount()];
      for(int i = 0; i < check.length; i++){
        check[i] = false;
      }
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      list.add(start);
      queue.addLast(start);
      check[start-1] = true;
      while(!queue.isEmpty()){
        adjList = super.getAdjacent(queue.getFirst());
        for(int i = 0; i < adjList.size(); i++){
          int value = adjList.get(i);
          if(!check[value-1]){
            check[value-1] = true;
            list.add(value);
            queue.addLast(value);
          }
        }
        queue.removeFirst();
      }
      return list;
    }

  /**
   * Fuehrt die Tiefensuche durch und gibt die erreichten Elemente zurueck
   * @param start > Position des Anfangs Knoten
   * @return ArrayList > Erreichte Knoten
   */
    public ArrayList<Integer> dfs(int start){
      Stack<Integer> stack = new Stack<>();
      ArrayList<Integer> list = new ArrayList<>();
      return helper2(start,list,stack);
    }

  /**
   * Eigentliche Funktionalitaet der Tierfensuche
   * @param position > Position des Anfangs Knoten
   * @param list > Liste der erreichten Elemente
   * @param stack > Stack mit dem vorherigen Element fuer die Tiefensuche
   * @return ArrayList > Erreichte Knoten
   */
    private ArrayList<Integer> helper2(int position,ArrayList<Integer> list, Stack stack ){
      stack.push(position);
      if(!list.contains(position)){
        list.add(position);
        for(int i = 0; i < super.getAdjacent(position).size(); i++){
          list = helper2(super.getAdjacent(position).get(i),list,stack);
        }
      }
      stack.pop();
      return list;
    }

  /**
   * Gibt alle nicht erreichbaren Knoten von start Knoten zurueck
   * @param start > Position des Anfangs knoten
   * @return ArrayList > Nicht erreichte Knoten
   */
    public ArrayList<Integer> getUnreachableVertices(int start) {
      ArrayList<Integer> remove = bfs(start);
      ArrayList<Integer> remove2 = dfs(start);
      for(int i = 0; i < remove2.size();i++){
        if(!remove.contains(remove2.get(i))){
          remove.add(remove2.get(i));
        }
      }
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 1; i <= super.getVertexCount(); i++){
        if(!remove.contains(i)){
          list.add(i);
        }
      }
      return list;
    }
}

