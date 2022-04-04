package uebungen.jan.übung2jan;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Scanner;

import static java.lang.Double.NaN;

public class UPN {

    private ArrayDeque<Double> stack= new ArrayDeque<>(); //Alternativ noch durch Stack<Double> ersetzen bei Multithreading
    private Hashtable<String, Double> mapVars = new Hashtable<>();
    private boolean firstOperation = true;

    private double eval(String exprUPN){
        firstOperation = true;
        String[] split = exprUPN.split(" ");
        for(int i = 0; i < split.length; i++){
            Scanner sc = new Scanner(split[i]);
            if((sc.hasNextDouble() || sc.hasNextInt()) && firstOperation){
                stack.add(Double.parseDouble(split[i]));
            }else{
                if(mapVars.containsKey(split[i])){
                    stack.add(mapVars.get(split[i]));
                }else{
                    double erg = isOperator(split[i]);
                    firstOperation = false;
                    if(!Double.isNaN(erg)){
                        stack.add(erg);
                    }else{
                        return NaN;
                    }
                }

            }
        }
        return stack.getLast();
    }

    public String analyze(String expr){
        if(expr.contains("=")){
            String exprUPN = "";
            String[] split = expr.split(" ");
            for(int i = 2; i< split.length;i++){
                exprUPN = exprUPN + split[i] + " ";
            }
            mapVars.put(split[0],eval(exprUPN));
            return "result: " + split[0] + "=" +eval(exprUPN);
        }else{
            return "result: "+eval(expr);
        }
    }

    public void clearVariables(){
        mapVars.clear();
    }

    private Double isOperator(String x){
        double a = stack.getLast();
        stack.removeLast();
        double b = stack.getLast();
        stack.removeLast();
        switch(x){
            case "+":
                return a+b;
            case "-":
                return b-a;
            case "*":
                return a*b;
            case "/":
                return b/a;
            case "^":
                return Math.pow(b,a);
            default:
                return NaN;
        }
    }
}
