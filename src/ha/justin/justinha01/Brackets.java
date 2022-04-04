package ha.justin.justinha01;

import java.util.ArrayDeque;
import java.util.HashMap;
/**
 * class Brackets to check whenever a value is following an syntax
 * 
 * @author Justin Jansen <jjansen@databay.de>
 * @author Svenja Zillekens
 * @author Jan-Eric Storms
 * @version 0.4.3
 */
public class Brackets {
	
	/**
	 * add more brackets with closing char if allowed <br>
	 * key = opening bracket - value = closing bracket
	 */
	private static HashMap<String, String> allowedBrackets = new HashMap<String, String>(){{
		put("{", "}");
		put("[", "]");
		put("(", ")");	
	}}; ;
	
	
	/**
	 * Returns whenever the given parameter is following the brackets syntax 
	 * 
	 * @param s > String
	 * @return boolean > true if syntax is correct
	 */
	public static boolean isValid(String s) {
		
		ArrayDeque<String> list = new ArrayDeque<String>();
		
		for (int i = 0; i <s.length(); i++) {
			
			String text = String.valueOf(s.charAt(i));
			
			if (Brackets.allowedBrackets.containsKey(text)) {
				list.add(text);
			}
			if (Brackets.allowedBrackets.containsValue(text)) {
				if (!list.isEmpty() && Brackets.allowedBrackets.get(list.getLast()).equals(text)) {
					list.removeLast();
					continue;
				}
				return false;
			}
			
		}
		return list.isEmpty();
	}
}
