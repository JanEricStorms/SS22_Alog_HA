package ha.jan.janha13;

public class Main {
    public static void main(String[] args) {
        NFA nfa_test = new NFA("3,3,1,2,a,1,3,a,2,2,a,2,2,b,2,3,a");
        System.out.println(nfa_test.testString("abba")); //true
        System.out.println(nfa_test.testString("a")); //true
        System.out.println(nfa_test.testString("ab")); //false

    }
}
