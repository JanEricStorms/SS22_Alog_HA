package übung2jan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UPN upn = new UPN();

        Scanner in = new Scanner(System.in);
        String z = "";
        while(true){
            z = in.nextLine();
            if(z.equals("quit")){
                break;
            }
            if(z.equals("clear")){
                upn.clearVariables();
                continue;
            }
            System.out.println("task '"+z+"' => " +upn.analyze(z));
        }
    }
}
