package easy;

/**
 * LeetCode Problem 392 - Is Subsequence
 * Topics: Two Pointers, String
 * Time Complexity: O(n + m) - where n and m are the lengths of strings s and t respectively, as we traverse each string once.
 * Space Complexity: O(1) - no additional space used.
 * <p>
 * Description:
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * Link: https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		boolean subsequence = isSubsequence(s, t);
		System.out.println("Is subsequence: " + subsequence);
	}

	/**
	 * Function to check if the string s is a subsequence of string t.
	 *
	 * @param s the string to check for subsequence
	 * @param t the string in which to check the subsequence
	 * @return true if s is a subsequence of t, false otherwise
	 */
	private static boolean isSubsequence(String s, String t) {
		int sIndex = 0;
		int tIndex = 0;
		while (sIndex < s.length() && tIndex < t.length()) {
			if (t.charAt(tIndex) == s.charAt(sIndex)) {
				sIndex++;
			}

			tIndex++;
		}

		return sIndex == s.length();
	}
}