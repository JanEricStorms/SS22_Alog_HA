package ha.jan.janha09;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Eine moegliche Form der Systemeingabe ueber den Benutzer [Benutzt einen Scanner, Wirft Exception wenn Buchstaben oder Symbole eingegeben werden]
//        System.out.println("Bitte geben Sie ein Gewicht ein: ");
//        Scanner sc = new Scanner(System.in);
//        Hauptprogramm.getResult(Integer.parseInt(sc.nextLine()));

        //Eine moegliche Form der Systemeingabe ueber den Benutzer [Benutzt einen JOptionPane, Wirft Exception wenn Buchstaben oder Symbole eingegeben werden]
//        String s = JOptionPane.showInputDialog("Bitte geben Sie ein Gewicht ein: ");
//        Hauptprogramm.getResult(Integer.parseInt(s));

        //Fester Wert im Funktionsaufruf
        Hauptprogramm.getResult(16);
    }
}
