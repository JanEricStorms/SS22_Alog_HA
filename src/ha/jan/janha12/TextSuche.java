package ha.jan.janha12;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

public class TextSuche {

    /**
     * Diese Funktion dient der Erreichbarkeit. Sie startet die Textsuche.
     * @param text > Der Text indem Gesucht werden soll
     * @param pattern > Das Pattern nach dem Gesucht werden soll.
     * @return ArrayList <Integer> > Beinhaltet die Startpositionen ab der Text und Pattern Uebereinstimmen.
     */
    public static ArrayList<Integer> textSearch(String text, String pattern){
        patternCheck(pattern);
        return checkForPatternMatch(text,pattern);
    }

    /**
     * Checkt das Pattern auf Fehler.
     * @param pattern > Das Pattern das geprueft werden soll.
     * @throws PatternSyntaxException > Wird geworfen, wenn das Pattern fehler beinhaltet.
     */
    private static void patternCheck(String pattern){
        while(pattern.length() != 0){
            if(pattern.charAt(0) != '\\' && pattern.charAt(0) != '['){
                pattern = pattern.substring(1);
            }else{
                if(pattern.charAt(0) == '['){
                    boolean breaketClosed = false;
                    for(int i = 1; i < pattern.length();i++){
                        if(pattern.charAt(i) == ']'){
                            breaketClosed = true;
                            pattern = pattern.substring(i+1);
                            break;
                        }
                    }
                    if(!breaketClosed){
                        throw new PatternSyntaxException("The closing bracked is missing", pattern,0);
                    }
                }else{
                    pattern = pattern.substring(2);
                }
            }
        }
    }

    /**
     * Sucht im Text nach dem Pattern. Dafuer wird der Text zeichenweise durchgegangen und dann geprueft, </br>
     * ob der Text ab der Text stelle mit dem Pattern passt. Wenn ja dann wird der Textindex der ArrayList hinzugefuegt. </br>
     * @param text > Der Text nach dem Gesucht wird
     * @param pattern > Das Pattern nach dem Gesucht werden soll.
     * @return ArrayList <Integer> > Beinhaltet die Startpositionen ab der Text und Pattern Uebereinstimmen.
     */
    private static ArrayList<Integer> checkForPatternMatch(String text, String pattern){
        ArrayList<Integer> result = new ArrayList<>();
        boolean patternMatch;
        for(int i = 0; i < text.length();i++){
            patternMatch = true;
            int index = i-1;
            for (int j = 0; j < pattern.length();j++){
                if(index < text.length()-1){
                    index++;
                }else{
                    patternMatch = false;
                    break;
                }
                /**
                 * Pruefung ob ein bestimmter oder belibiger Buchstabe im Text steht und passt
                 */
                if(pattern.charAt(j) != '\\' && pattern.charAt(j) != '['){
                    if(pattern.charAt(j) != '.'){
                         if(text.charAt(index) != pattern.charAt(j)){
                             patternMatch = false;
                             break;
                         }
                    }
                    /**
                     * Pruefung fuer den Fall, dass das Pattern mit einem Backslash beginnt und mit dem Text uebereinstimmt
                     */
                }else if(pattern.charAt(j) == '\\'){
                    if(text.charAt(index) != pattern.charAt(j+1)){
                        patternMatch = false;
                        break;
                    }else{
                        j++;
                    }
                    /**
                     * Pruefung einer Zeichenklasse
                     */
                }else if(pattern.charAt(j) == '['){
                    ArrayList<Character> charList = new ArrayList<>();
                    for(int k = 1; k < pattern.length();k++){
                        if(pattern.charAt(j+k) != ']'){
                            charList.add(pattern.charAt(j+k));
                        }else{
                            j=j+k;
                            break;
                        }
                    }
                    if(!charList.contains(text.charAt(index))){
                        patternMatch = false;
                        break;
                    }
                }else{
                    patternMatch = false;
                }
            }
            if (patternMatch){
                result.add(i);
            }
        }
        return result;
    }
}
