package medium;

/**
 * Solution for LeetCode problem 72: Edit Distance
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 * Topics: Dynamic Programming
 *
 * Example:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 *
 * Explanation: intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (insert 'u')
 * exection -> execution (insert 'n')
 *
 * Hint: Use dynamic programming to build a 2D table where dp[i][j] represents the minimum edit distance between the first i characters of word1 and the first j characters of word2.
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
	public static void main(String[] args) {
		String word1 = "intention";
		String word2 = "execution";
		int distance = minDistance(word1, word2);
		System.out.println("Edit Distance: " + distance); // Output: 5
	}

	private static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j; // Insert all characters of word2
				} else if (j == 0) {
					dp[i][j] = i; // Remove all characters of word1
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1]; // Characters match
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
									Math.min(dp[i - 1][j], // Remove
											dp[i][j - 1])); // Insert
				}
			}
		}

		return dp[m][n];
	}

}