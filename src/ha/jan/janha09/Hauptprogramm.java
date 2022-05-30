package ha.jan.janha09;

import java.util.ArrayList;

public class Hauptprogramm {

    /**
     * Dieser int[] beinhaltet die Gewichte die zur Verfuegung stehen
     */
    private static final int[] gewichte = new int[]{1,3,8,20};

    /**
     * Diese Funktion ist der Rekursive anstoss, <br>
     * und gibt die moeglichen Ergebnisse zurueck. <br>
     * Dabei hat die Funktion in dem Korb nur eine der Symmetrischen Versionen, <br>
     * und laesst sich die andere durch die Hilfsfunktion printInverted ausgeben. <br>
     * @param gewicht > Gewicht des Artikels der Gewogen bzw ausgeglichen werden soll.
     */
    public static void getResult(int gewicht){
        ArrayList<String> korb = new ArrayList<>();
        getResultat(gewicht, new ArrayList<Integer>(), korb);
        for (int i = 0; i < korb.size();i++){
            System.out.println(korb.get(i));
            printInverted(korb.get(i));
        }
    }

    /**
     * Rekursive Funktion um alle Moeglichkeiten das Gewicht zu wiegen bzw Auszugleichen. <br>
     * Die Funktion ueberprueft zuerst, ob die aktuelle gewichtsauswahl hoeher ist als das Gewicht des Artikels. <br>
     * Danach ueberprueft sie die laenge der aktuellen auswahl, ist diese 4 wird im anschluss geprueft, <br>
     * ob das Gewicht mit dem das Artikel passt und ob der Korb diese auswahl schon enthaelt. <br>
     * Dann fuegt die Funktion das naechste Gewicht hinzu und ruft sich selber wieder auf. <br>
     * Dabei fuegt sie zuerst das positive gewicht, dann die 0 und zuletzt das negative gewicht hinzu. <br>
     * @param gewicht > Gewicht des Artikels
     * @param auswahl > ArrayList<Integer> enthaelt die aktuelle auswahl
     * @param korb > Speichert die gueltigen Ergebnisse ab
     */
    private static void getResultat(int gewicht,ArrayList<Integer> auswahl,ArrayList<String> korb){
        if( calcSum(auswahl) > gewicht){
            return;
        }
        if(auswahl.size() == 4){
            System.out.println(auswahl);
            System.out.println(!korb.contains(auswahl));
            if(!korb.contains(auswahl.toString()) && calcSum(auswahl) == gewicht){
                korb.add(auswahl.toString());
            }
            return;
        }
        auswahl.add(gewichte[auswahl.size()]);
        getResultat(gewicht,auswahl,korb);
        auswahl.remove(auswahl.size()-1);
        auswahl.add(0);
        getResultat(gewicht,auswahl,korb);
        auswahl.remove(auswahl.size()-1);
        auswahl.add(-1*gewichte[auswahl.size()]);
        getResultat(gewicht,auswahl,korb);
        auswahl.remove(auswahl.size()-1);
    }

    /**
     * Hilfsfunktion zur Berechnung der Summer der aktuellen auswahl <br>
     * Dient dem Vergleich mit dem Gewicht des Artikel
     * @param auswahl > ArrayList<Integer> mit aktueller auswahl
     * @return int > Gibt die summer der elemente der auswahl zurueck.
     */
    private static int calcSum(ArrayList<Integer> auswahl){
        int result = 0;
        for(int i = 0; i < auswahl.size(); i++){
            result = result + auswahl.get(i);
        }
        return result;
    }

    /**
     * Hilfsfunktion zur Ausgabe aller Moeglichkeiten. <br>
     * Gibt die Invertierten Elemente zurueck. Immer das Symmetrische gegenstueck zu dem bereits enthaltenem.
     * @param s
     */
    private static void printInverted(String s){
        s = s.substring(1,s.length()-1);
        String[] arr = s.split(",");
        arr[0] = " " + arr[0];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length;i++){
            result.add(-1*Integer.parseInt(arr[i].substring(1)));
        }
        System.out.println(result);
    }
}
