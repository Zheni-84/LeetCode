package medium;

/*
* Leetcode Problem 576: Out of Boundary Paths
* Topics: DP, Recursion, Memoization
* Time Complexity: O(mn)
* Space Complexity: O(mn)
* Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
* An interleaving of two strings s and t is a configuration where they are divided into
* non-empty substrings such that:
* s = s1 + s2 + ... + sn
* t = t1 + t2 + ... + tm
* |n - m| <= 1
* The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
* Note: a + b is the concatenation of strings a and b.
* Example:
* Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
* Output: true
* Explanation: One way to interleave s1 and s2 to get s3 is:
* s1: a   a   b   c   c
* s2:     d   b   b   c   a
* s3: a   a   d   b   b   c   b   c   a
* Constraints:
* 0 <= s1.length, s2.length <= 100
* 0 <= s3.length <= 200
* s1, s2, and s3 consist of lowercase English letters.
*
* Link: https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {

	// Time Complexity: O(mn)
	// Space Complexity: O(mn)
	// DP 2D
	private static boolean isInterleave2D(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();

		if (m + n != s3.length()) {
			return false;
		}

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		// First column: only s1
		for (int i = 1; i <= m; i++) {
			dp[i][0] = dp[i - 1][0]
					&& s1.charAt(i - 1) == s3.charAt(i - 1);
		}

		// First row: only s2
		for (int j = 1; j <= n; j++) {
			dp[0][j] = dp[0][j - 1]
					&& s2.charAt(j - 1) == s3.charAt(j - 1);
		}

		// Main DP
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char c = s3.charAt(i + j - 1);
				dp[i][j] =
						(dp[i - 1][j] && s1.charAt(i - 1) == c)
								|| (dp[i][j - 1] && s2.charAt(j - 1) == c);
			}
		}

		return dp[m][n];
	}

	private static boolean isInterleave_1D_DP(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		int m = s1.length();
		int n = s2.length();

		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		// First row (only s2)
		for (int j = 1; j <= n; j++) {
			dp[j] = dp[j - 1]
					&& s2.charAt(j - 1) == s3.charAt(j - 1);
		}

		for (int i = 1; i <= m; i++) {
			// First column update (only s1)
			dp[0] = dp[0]
					&& s1.charAt(i - 1) == s3.charAt(i - 1);

			for (int j = 1; j <= n; j++) {
				char c = s3.charAt(i + j - 1);
				dp[j] =
						(dp[j] && s1.charAt(i - 1) == c)
								|| (dp[j - 1] && s2.charAt(j - 1) == c);
			}
		}

		return dp[n];
	}

	private static boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();

		if (m + n != s3.length()) {
			return false;
		}

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i > 0) {
					dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
				}
				if (j > 0) {
					dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
				}
			}
		}

		return dp[m][n];
	}
}