package ha.jan.janha10;
import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraFail3 {

    public static void printDijkstra(int[] kanten) {

        int knotenanzahl = kanten[0];
        int[][] dijkstra = new int[(knotenanzahl-1)*2][knotenanzahl];

        ArrayList<Integer> besuchteKnoten = new ArrayList<>();
        besuchteKnoten.add(1);

        while(true) {
            for(int i = 1; i < kanten.length; i=i+3) {
                int knoten = besuchteKnoten.get(besuchteKnoten.size()-1);

                int kosten = 0;
                int minKnoten = 0;
                int minKosten = 0;

                if(kanten[i] == knoten) {
                    if (dijkstra[knoten-1][kanten[i+1]-1] == 0) {
                        dijkstra[knoten-1][kanten[i+1]-1] = kanten[i+2];
                    } else if (dijkstra[knoten-1][kanten[i+1]-1] > kanten[i+2]) {
                        dijkstra[knoten-1][kanten[i+1]-1] = kanten[i+2];
                    }

                }

                int[] values = getMinimum(dijkstra, knoten);
                besuchteKnoten.add(values[1]);
                kosten = values[0];

            }
            System.out.println(Arrays.deepToString(dijkstra));
        }


    }

    private static int[] getMinimum(int[][] dijkstra, int knoten) {
        int kosten = 0;
        int neuerKnoten = 0;

        for (int i = 0; i < dijkstra[knoten].length; i++) {
            if (dijkstra[knoten][i] > 0 && (kosten == 0 || kosten > dijkstra[knoten][i])) {
                kosten = dijkstra[knoten][i];
                neuerKnoten = i+2;
            }
        }

        return new int[] {kosten, neuerKnoten};
    }

    public static void main(String[] args) {
        int[] liste = new int[] {4,1,2,2,1,4,5,2,4,1,2,3,4,3,1,1,4,3,1};

//		int[] liste2 = new int[] {10,1,2,30,1,3,10,2,5,15,2,8,55,3,4,5,3,
//				9,35,4,2,10,4,5,45,4,6,10,5,3,20,5,7,15,5,9,25,6,7,5,7,10,20,8,
//				10,15,9,8,10,9,10,30};
        // System.out.println(Arrays.deepToString(listeToMatrix(liste)));
        printDijkstra(liste);
    }




}
