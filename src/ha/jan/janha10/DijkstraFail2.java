package ha.jan.janha10;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraFail2 {

    public static int[][] listeToMatrix(int[] liste) {
        int[][] matrix = new int[liste[0]][liste[0]];
        for (int i = 1; i < liste.length; i=i+3) {
            matrix[liste[i]-1][liste[i+1]-1] = liste[i+2];
        }
        return matrix;
    }

    public static void printDikstra(int[] kanten) {
        int[][] matrix = listeToMatrix(kanten);
        int knoten = 1;
        int gewicht = 0; // zusaetzliches Gewicht, welches addiert werden muss
        ArrayList<Integer> besuchteKnoten = new ArrayList<>();
        besuchteKnoten.add(knoten);

        int[][] dijkstra = new int[kanten[0]-1][kanten[0]];
        int[][] previous = new int[kanten[0]-1][kanten[0]];

        //
        int minimaleKosten = 0;
        int minimalerKnoten = 0;
        for (int i = 0; i < kanten[0]; i++) {
            int kosten = matrix[0][i];
            dijkstra[0][i] = kosten;
            if (minimaleKosten == 0 || kosten < minimaleKosten) {
                minimaleKosten = kosten;
                minimalerKnoten = i+1;
            }
        }
        knoten = minimalerKnoten;
        gewicht = minimaleKosten;
        System.out.println(Arrays.deepToString(dijkstra));
        System.out.println("Liste: " + besuchteKnoten);
        besuchteKnoten.add(knoten);

//		while(besuchteKnoten.size()-1 <= kanten[0]) {
//			for (int i = 0; i < kanten[0]; i++) {
//				if (matrix[knoten-1][i] != 0 && !besuchteKnoten.contains(i+1)) {
//					dijkstra[besuchteKnoten.size()-1][i] = matrix[knoten-1][i]+gewicht;
//				}
//			}
//		}
//
//		System.out.println(Arrays.deepToString(dijkstra));
    }





    public static void main(String[] args) {
        int[] liste = new int[] {4,1,2,2,1,4,5,2,4,1,2,3,4,3,1,1,4,3,1};

//		int[] liste2 = new int[] {10,1,2,30,1,3,10,2,5,15,2,8,55,3,4,5,3,
//				9,35,4,2,10,4,5,45,4,6,10,5,3,20,5,7,15,5,9,25,6,7,5,7,10,20,8,
//				10,15,9,8,10,9,10,30};
        System.out.println(Arrays.deepToString(listeToMatrix(liste)));
        printDikstra(liste);
    }



}
