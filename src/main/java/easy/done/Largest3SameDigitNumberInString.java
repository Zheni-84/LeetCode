package easy.done;

/* * LeetCode Problem: 1524. Largest 3-Same-Digit Number in String
 * Space: O(1)
 * Time: O(n)
 * Topics: String
 * Given a string num representing a large integer, return the largest good integer (i.e., a substring of length 3 that consists of the same digit) in num.
 * If no such substring exists, return an empty string.
 *
 * Example:
 * Input: num = "6777133339"
 * Output: "777"
 * Hint: Iterate through the string and check for substrings of length 3 that are the same.
 * http://leetcode.com/problems/largest-3-same-digit-number-in-string/
 */
public class Largest3SameDigitNumberInString {

	public static void main(String[] args) {
		String num = "6777133339";
		System.out.println(largestGoodInteger(num)); // Output: "777"
		System.out.println(largestGoodIntegerBrute(num)); // Output: "777"
	}

	private static String largestGoodInteger(String num) {
		for (int d = 9; d >= 0; d--) {
			// Create a string of the digit repeated 3 times
			String pattern = String.valueOf(d).repeat(3);
			// Check if the pattern exists in the input string
			// If it does, return it immediately as it's the largest possible
			if (num.contains(pattern)) {
				return pattern;
			}
		}

		return "";
	}

	private static String largestGoodIntegerBrute(String num) {
		String maxGood = "";
		for (int i = 0; i <= num.length() - 3; i++) {
			char c = num.charAt(i);
			if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
				String candidate = num.substring(i, i + 3);
				if (candidate.compareTo(maxGood) > 0) {
					maxGood = candidate;
				}
			}
		}
		return maxGood;
	}
}