package easy.done;

/* LeetCode Problem 796: Rotate String
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Topic: String Manipulation
 *
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *
 * Example:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * http://leetcode.com/problems/rotate-string/
 */

public class RotateString {

	public static void main(String[] args) {
		String s = "jwroibqbhkebuaazjtcdbzebnxydftkkxvcojqlgagzfxhcewncynszwrklxzkmvmmkkriuzukzhsdaiqqbioliipehdvwwqlgk";
		String goal = "jwroibqbhkebuaazjtcdbzebnxydftkkxvcojqlgagzfxhcewncynszwrklxzkmvmmkkriuzukzhsdaiqqbioliipehdvwwqlgx";

		System.out.println(rotateString(s, goal)); // Output: false
		System.out.println(rotateStringAlternative(s, goal)); // Output: false
		System.out.println(rotateStringBruteForce(s, goal)); // Output: false

		s = "abcde";
		goal = "abced";
		System.out.println(rotateString(s, goal)); // Output: false
	}

	// Method to check if we can double the string s and find goal in it
	private static boolean rotateString(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		String concatenated = s + s;
		return concatenated.contains(goal);
	}

	// Alternative method to check if we can find s in doubled goal
	private static boolean rotateStringAlternative(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		String doubled = String.join("", goal, goal);
		return doubled.contains(s);
	}

	private static boolean rotateStringBruteForce(String s, String goal) {
		if (s.length() != goal.length()) return false;

		int n = s.length();
		for (int i = 0; i < n; i++) {
			// Rotate by i positions
			String rotated = s.substring(i) + s.substring(0, i);
			if (rotated.equals(goal)) {
				return true;
			}
		}
		return false;
	}
}