package easy.done;

/* * LeetCode Problem: 1446. Consecutive Characters
 * Space: O(1)
 * Time: O(n)
 * Topics: String
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Example:
 * Input: s = "aaabbcddddeee"
 * Output: 4 (the substring "dddd" has the maximum length)
 * Hint: You can iterate through the string and keep track of the current character and its count, updating the maximum count when you encounter a different character.
 * http://leetcode.com/problems/consecutive-characters/
 */
public class ConsecutiveCharacters {

	public static void main(String[] args) {
		String input = "aaabbcddddeeeee";
		int result = maxPower(input);
		System.out.println("Maximum power of consecutive characters: " + result);
	}

	private static int maxPower(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int maxPower = 1;
		int currentPower = 1;
		int len = s.length();
		for (int i = 1; i < len; i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				currentPower++;
				maxPower = Math.max(maxPower, currentPower);
			} else {
				currentPower = 1;
			}
		}

		return maxPower;
	}
}