package uebungen.jan.übung8jan;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Permutationen {

    public static void printPermutationen(int n){
        String ret ="";
        boolean []check = new boolean[n];
        for (boolean i:check) {
            i=false;
        }
        printPermutationen(ret,n,check);
    }

    private static void printPermutationen(String ret,int n, boolean[]check){
        if(n==0){
            System.out.println(ret);
            ret="";
            return;
        }
        for(int i=1;i<=n;i++){
            if(!check[(i-1)]){
                String t = i + ret;
                check[(i-1)]=true;
                printPermutationen(t,n-1,check);
                check[(i-1)]=false;
            }
        }
    }

}
