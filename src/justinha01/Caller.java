package justinha01;

public class Caller {

	public static void main(String[] args) {
		String[] tests = {"( ( [ [ ] ] ) )", "( [ ) ]", "( [ ] ] )", "( ( ) ) )", "( ( )", "( { [ ] ) }", "Keine Klammern"};
		for(String value : tests) {
			System.out.println(Brackets.isValid(value));
		}
	}

}
