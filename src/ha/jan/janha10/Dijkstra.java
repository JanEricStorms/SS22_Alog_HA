package ha.jan.janha10;

import java.util.ArrayList;

public class Dijkstra {

    /**
     * Diese Funktion dient dem Aufruf des Dijkstra
     * Es werden zuerst alle daten aus dem Eingabe Array entnommen, und dann wird das Dijkstra zeilen weise bearbeitet.
     * @param kanten > Eingabe Array
     */
    public static void printDijkstra(int[] kanten){
        int knotenAnzahl = kanten[0];
        ArrayList<int[]> tripleListe = tripleExtractor(kanten);
        ArrayList<Integer> startKnoten = new ArrayList<>();
        int[][] dijkstra = new int[knotenAnzahl][knotenAnzahl-1];
        int[][] besuchteKnoten = new int[knotenAnzahl][knotenAnzahl-1];
        startKnoten.add(0,1);
        int ausgangsKnoten;
        int zielKnoten;
        int gewicht;
        for(int i = 0; i < knotenAnzahl; i++){
            ausgangsKnoten = startKnoten.get(i);
            for (int j = 0; j < tripleListe.size();j++){
                if(checkStartKnoten(ausgangsKnoten,tripleListe.get(j))){
                    zielKnoten = tripleListe.get(j)[1];
                    gewicht = tripleListe.get(j)[2];
                    if(i == 0){
                        dijkstra[i][zielKnoten-2] = gewicht;
                        besuchteKnoten[i][zielKnoten-2] = ausgangsKnoten;
                    }else{
                        if(zielKnoten != 1){
                            if(dijkstra[i-1][zielKnoten-2] != 0){
                                if(dijkstra[i-1][zielKnoten-2] > gewicht+dijkstra[i-1][ausgangsKnoten-2]){
                                    dijkstra[i][zielKnoten-2] = gewicht+dijkstra[i-1][ausgangsKnoten-2];
                                    besuchteKnoten[i][zielKnoten-2] = ausgangsKnoten;
                                }
                            }else{
                                dijkstra[i][zielKnoten-2] = gewicht+dijkstra[i-1][ausgangsKnoten-2];
                                besuchteKnoten[i][zielKnoten-2] = ausgangsKnoten;
                            }
                        }
                    }
                }
            }
            if(i > 0){
                for(int j = 0; j < dijkstra[0].length;j++){
                    if(dijkstra[i][j] == 0){
                        dijkstra[i][j] = dijkstra[i-1][j];
                    }
                }
                for(int j = 0; j < besuchteKnoten[0].length;j++){
                    if(besuchteKnoten[i][j] == 0){
                        besuchteKnoten[i][j] = besuchteKnoten[i-1][j];
                    }
                }
            }
            if(i < knotenAnzahl){
                int nextKnoten = nextStartKnoten(startKnoten,dijkstra);
                if(nextKnoten != -1){
                    startKnoten.add(i+1,nextKnoten);
                }

            }

        }
        ausgabe(startKnoten,dijkstra,besuchteKnoten,knotenAnzahl);
    }

    /**
     * Diese Funktion dient der Extraktion der Tripel aus dem eingabe Array
     * @param kanten > Eingabe Array
     * @return ArrayList<Integer> > Eine Liste die alle Tripel enthaelt
     */
    private static ArrayList<int[]> tripleExtractor(int[] kanten){
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 1; i < kanten.length; i=i+3){
            result.add(new int[]{kanten[i],kanten[i+1],kanten[i+2]});
        }
        return result;
    }

    /**
     * Diese Funktion dient der abfrage ob ein Tripel mit dem StartKnoten beginnt.
     * @param a > der StartKnoten
     * @param triple > Ein int[], dass das Tripel enthaelt
     * @return
     */
    private static boolean checkStartKnoten(int a,int[] triple){
        return a == triple[0];
    }

    /**
     * Diese Funktion sucht den naechsten Startknoten
     * 
     * @param startKnoten > ArrayListe mit den schon benutzten start knoten
     * @param dijkstra > int[][] mit der aktuellen dijkstra
     * @return int > naechster StartKnoten
     */
    private static int nextStartKnoten(ArrayList<Integer> startKnoten,int[][] dijkstra){
        int minGewicht = Integer.MAX_VALUE;
        int index = -1;
        int zeile = startKnoten.size()-1;
        for(int i = 0; i < dijkstra[0].length;i++){
            if(zeile != 2){
                if(dijkstra[startKnoten.get(zeile)-1][i] > 0 && dijkstra[startKnoten.get(zeile)-1][i] < minGewicht && !startKnoten.contains(i+2)){
                    minGewicht = dijkstra[startKnoten.get(zeile)-1][i];
                    index = i+2;
                }
            }else{
                if(dijkstra[startKnoten.get(zeile)-2][i] > 0 && dijkstra[startKnoten.get(zeile)-2][i] < minGewicht && !startKnoten.contains(i+2)){
                    minGewicht = dijkstra[startKnoten.get(zeile)-2][i];
                    index = i+2;
                }
            }

        }
        return index;
    }

    /**
     * Diese Funktion dient der Sauberen ausgabe
     * @param startKnoten
     * @param dijkstra
     * @param besuchteKnoten
     * @param knotenAnzahl
     */
    private static void ausgabe(ArrayList<Integer> startKnoten, int[][] dijkstra, int[][] besuchteKnoten, int knotenAnzahl){
        StringBuilder sb = new StringBuilder();
        sb.append("vi|");
        for (int i = 2; i <= knotenAnzahl;i++){
            sb.append(String.format("%3d", i));
        }
        sb.append("|");
        for (int i = 2; i <= knotenAnzahl;i++){
            sb.append(String.format("%3d", i));
        }
        sb.append("|");
        System.out.println(sb);
        sb = new StringBuilder();
        for(int i = 0; i < 3+knotenAnzahl*5;i++){
            sb.append("-");
        }
        System.out.println(sb);
        for(int i = 0; i < startKnoten.size();i++){
            sb = new StringBuilder();
            sb.append(String.format("%2d", startKnoten.get(i)) + "|");
            for (int j = 0; j < dijkstra[0].length;j++){
                sb.append(String.format("%3d", dijkstra[i][j]));
            }
            sb.append("|");
            for (int j = 0; j < besuchteKnoten[0].length;j++){
                sb.append(String.format("%3d", besuchteKnoten[i][j]));
            }
            sb.append("|");
            System.out.println(sb);
        }
    }
}
