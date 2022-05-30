package ha.jan.janha10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DijkstraFail {

    public static void printDijkstra(int[] kanten){
        int knoten = kanten[0];
        int[][] ausgabe = new int[2*(knoten-1) + 1][knoten];
        ArrayList<int[]> tripleList = tripleExtractor(kanten);
        for(int i = 0; i < tripleList.size();i++){
            System.out.println(Arrays.toString(tripleList.get(i)));
        }
        ausgabe[0][0] = 1;
        int startknoten;
        int zielknoten;
        int gewicht;
        for(int i = 0; i < knoten;i++){
            startknoten = ausgabe[0][i];
            for(int j = 0; j < tripleList.size();j++){
                if(checkStartKnoten(startknoten, tripleList.get(j))){
                    zielknoten = tripleList.get(j)[1];
                    gewicht = tripleList.get(j)[2];
                    if(i != 0){
                        if(ausgabe[zielknoten-1][i-1] > gewicht+ausgabe[startknoten-1][i-1]){
                            ausgabe[zielknoten-1][i] = gewicht+ausgabe[startknoten-1][i-1];
                            ausgabe[(zielknoten-1)+(knoten-1)][i] = startknoten;
                        }
                    }else{
                        ausgabe[zielknoten-1][i] = gewicht;
                        ausgabe[(zielknoten-1)+(knoten-1)][i] = startknoten;
                    }
                }
            }
            for(int j = 1; j < ausgabe.length;j++){
                if(ausgabe[j][i] == 0 && i > 0){
                    ausgabe[j][i] = ausgabe[j][i-1];
                }
            }
            if(i < 3){
                ausgabe[0][i+1] = getNextStartknoten(ausgabe,i, knoten);
            }

        }
        printAusgabe(ausgabe);
    }

    private static ArrayList<int[]> tripleExtractor(int[] kanten){
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 1; i < kanten.length; i=i+3){
            result.add(new int[]{kanten[i],kanten[i+1],kanten[i+2]});
        }
        return result;
    }

    private static boolean checkStartKnoten(int a,int[] triple){
        if(a == triple[0]){
            return true;
        }
        return false;
    }

    private static int getNextStartknoten(int[][] ausgabe, int i, int knoten){
        int[] zeile = new int[knoten-1];
        for (int j = 1; j < knoten;j++){
            zeile[j-1] = ausgabe[j][i];
        }
        System.out.println( "ALERT " +Arrays.toString(zeile));
        ArrayList<Integer> sort= new ArrayList<>();
        for (int j = 0; j < zeile.length; j++){
            sort.add(zeile[j]);
        }

        Collections.sort(sort);
        System.out.println(" So " + sort.toString());
        if(sort.get(0) == 0){
            sort.remove(0);
        }
        System.out.println(" So2 " + sort.toString());
        ArrayList<Integer> used= new ArrayList<>();
        for (int j = 0; j <= i; j++){
            used.add(ausgabe[j][0]);
        }
        int[] reihenfolge = new int[knoten-1];
        for (int j = 0; j < sort.size(); j++){
            for ( int k = 0; k < zeile.length; k++){
                if(sort.get(j) == zeile[k]){
                    if(!used.contains(sort.get(j))){
                        reihenfolge[0] = k;
                        System.out.println(k);
                    }
                }
            }
        }
        System.out.println("Test" + reihenfolge[0]);
        return reihenfolge[0];
    }

    private static void printAusgabe(int[][] ausgabe){
        for (int i = 0; i < ausgabe.length;i++){
            System.out.print(String.format("%02d", ausgabe[i][0]) + "|");
            for (int j = 1; j < ausgabe[i].length; j++){
                if((j*2)-1 == ausgabe[i].length-1){
                    System.out.print("|");
                }
                System.out.print(String.format("%02d", ausgabe[i][j]) + "");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
