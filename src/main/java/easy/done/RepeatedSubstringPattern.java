package easy.done;

/**
 * LeetCode Problem 459 - Repeated Substring Pattern
 * Topics: String
 * Time Complexity: O(n) - where n is the length of the string s, as we perform operations that are linear in relation to the string length.
 * Space Complexity: O(n) - for the StringBuilder used in the brute force method.
 *
 * Description:
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 * Link: https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPatternBrute(String s) {
		int n = s.length();
		if (n < 2) {
			return false; // A single character or empty string cannot form a repeated pattern
		}

		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) { // Check if the length is divisible by i
				String substring = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				sb.append(substring.repeat(n / i));
				if (sb.toString().equals(s)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean repeatedSubstringPattern(String s) {
		if (s == null || s.length() < 2) {
			return false; // A single character or empty string cannot form a repeated pattern
		}

		String doubled = s + s;
		String trimmed = doubled.substring(1, doubled.length()-1);
		return trimmed.contains(s);
	}
}