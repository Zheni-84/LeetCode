package easy.done;

/*
 * LeetCode Problem: 844. Backspace String Compare
 * Time Complexity: O(n + m), where n and m are the lengths of strings s and t respectively.
 * Space Complexity: O(n + m) for the StringBuilder used to build the final strings.
 * Topic: String Manipulation
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s = "ab#c";
		String t = "ad#c";
		System.out.println(backspaceCompare(s, t)); // Output: true

		s = "ab##";
		t = "c#d#";
		System.out.println(backspaceCompare(s, t)); // Output: true

		s = "a#c";
		t = "b";
		System.out.println(backspaceCompare(s, t)); // Output: false
	}

	private static boolean backspaceCompare(String s, String t) {
		return build(s).equals(build(t));
	}

	private static String build(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c == '#') {
				if (!sb.isEmpty()) {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}
}