package easy.done;

/**
 * LeetCode Problem 521 - Longest Uncommon Subsequence I
 * Topics: String
 * Time Complexity: O(1) - because we have a constraint that the lengths of the strings are at most 100, which is constant.
 * Space Complexity: O(1) - no additional space used.
 * <p>
 * Description:
 * Given two strings a and b, return the length of the longest uncommon subsequence between them.
 * If the longest uncommon subsequence does not exist, return -1.
 * <p>
 * Link: https://leetcode.com/problems/longest-uncommon-subsequence-i/
 */
public class LongestUncommonSubsequenceI {

	public static void main(String[] args) {
		String a = "abc";
		String b = "abcdeef";
		int result = findLUSlength(a, b);
		System.out.println("Length of the longest uncommon subsequence: " + result);
	}

	private static int findLUSlength(String a, String b) {
		// If both strings are equal, there is no uncommon subsequence.
		if (a.equals(b)) {
			return -1;
		}
		// If the strings are not equal, the longest uncommon subsequence is the longer of the two strings.
		return Math.max(a.length(), b.length());
	}
}