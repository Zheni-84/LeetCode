package easy.done;

/*
 * LeetCode Problem: 844. Backspace String Compare
 * Time Complexity: O(n + m), where n and m are the lengths of strings s and t respectively.
 * Space Complexity: O(n + m) for the StringBuilder used to build the final strings.
 * Topic: String, Two Pointers
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * Hint: Use two pointers to iterate from the end of both strings, skipping characters based on the number of backspaces.
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s = "ab#c";
		String t = "ad#c";
		// Output: true
		// Explanation: Both s and t become "ac".
		System.out.println("Backspace String Compare: " + backspaceCompare(s, t));

		s = "ab##";
		t = "c#d#";
		// Output: true
		// Explanation: Both s and t become "".
		System.out.println("Backspace String Compare: " + backspaceCompareOptimal(s, t));

		s = "a#c";
		t = "b";
		// Output: false
		// Explanation: s becomes "c" while t becomes "b".
		System.out.println("Backspace String Compare: " + backspaceCompareOptimal(s, t));
	}

	private static boolean backspaceCompare(String s, String t) {
		return build(s).equals(build(t));
	}

	// Optimal approach: two pointer technique
	// Iterate from the end of both strings and skip the characters based on the number of backspaces
	// Compare the characters from the end of both strings, if they are not equal, return false
	// If we reach the beginning of both strings and all characters are equal, return true
	// Time Complexity: O(n + m), where n and m are the lengths of strings s and t respectively.
	// Space Complexity: O(1)
	private static boolean backspaceCompareOptimal(String s, String t) {
		int i = s.length() - 1;
		int j = t.length() - 1;

		int skipS = 0;
		int skipT = 0;

		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (s.charAt(i) == '#') {
					skipS++;
					i--;
				} else if (skipS > 0) {
					skipS--;
					i--;
				} else {
					break;
				}
			}

			while (j >= 0) {
				if (t.charAt(j) == '#') {
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				} else {
					break;
				}
			}

			if (i >= 0 && j >= 0) {
				if (s.charAt(i) != t.charAt(j)) {
					return false;
				}
			} else {
				if (i >= 0 || j >= 0) {
					return false;
				}
			}

			i--;
			j--;
		}

		return true;
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