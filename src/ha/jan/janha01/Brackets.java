package ha.jan.janha01;

import java.util.ArrayDeque;

public class Brackets {

    public static boolean isValid(String s){
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) =='(' || s.charAt(i) =='[' || s.charAt(i) =='{'){
                stack.add(s.charAt(i)+"");
            }else{
                if(!stack.isEmpty()){
                    switch(s.charAt(i)){
                        case ')':
                            if(!stack.getLast().equals("(")){
                                return false;
                            }else{
                                stack.removeLast();
                            }
                            break;
                        case']':
                            if(!stack.getLast().equals("[")){
                                return false;
                            }else{
                                stack.removeLast();
                            }
                            break;
                        case '}':
                            if(stack.getLast().equals("{")){
                                return false;
                            }else{
                                stack.removeLast();
                            }
                            break;
                        default:
                            break;
                    }
                }else{
                    if (s.length()-1-i <=1 && (s.charAt(i) ==')' || s.charAt(i) ==']' || s.charAt(i) =='}')) {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(([[]]))"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("([]])"));
        System.out.println(isValid("(()))"));
        System.out.println(isValid("(()"));
        System.out.println(isValid("({[])}"));
        System.out.println(isValid(""));
    }
}
