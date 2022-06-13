package ha.jan.janha12;

public class Main {
    public static void main(String[] args) {
        System.out.println(TextSuche.textSearch("abcabcdababdc.", "ab")); //0, 3, 7, 9
        System.out.println(TextSuche.textSearch("abcabcdababdc.", "c.")); //2, 5, 12
        System.out.println(TextSuche.textSearch("abcabcdababdc.", "c\\.")); //12
        System.out.println(TextSuche.textSearch("abcabcdababdc.", "b[cd]")); //1,4,10
        System.out.println(TextSuche.textSearch("abcabcdababdc.", "a....c")); //0,7
        System.out.println(TextSuche.textSearch("a[aababa][ab]a", "a[ab]a")); //3,5
        System.out.println(TextSuche.textSearch("a[aababa][ab]a", "a.\\[a")); //7
    }
    }
