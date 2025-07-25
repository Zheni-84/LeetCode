package easy;

/* LeetCode Problem: Rotate String
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
 */

public class RotateString {

	public static void main(String[] args) {
		RotateString solution = new RotateString();
		String s = "abcde";
		String goal = "cdeab";
		System.out.println(solution.rotateString(s, goal)); // Output: true

		s = "abcde";
		goal = "abced";
		System.out.println(solution.rotateString(s, goal)); // Output: false
	}
	public boolean rotateString(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		String concatenated = s + s;
		return concatenated.contains(goal);
	}

}
