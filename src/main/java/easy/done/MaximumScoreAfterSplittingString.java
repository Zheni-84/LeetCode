package easy.done;

/**
 * LeetCode 1422: Maximum Score After Splitting a String
 * Topics: String, Prefix Sum
 * <p>
 * Time Complexity: O(n), where n is the length of the string s.
 * Space Complexity: O(1)
 * <p>
 * This class provides a method to calculate the maximum score after splitting a binary string
 * into two non-empty substrings, where the score is defined as the number of '0's in the left substring
 * plus the number of '1's in the right substring.
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class MaximumScoreAfterSplittingString {

	public static void main(String[] args) {
		//String s = "011101"; // Expected output: 5
		String s = "1111"; // Expected output: 3
		int result = maxScore(s);
		System.out.println("Maximum score after splitting the string: " + result);
	}

	private static int maxScore(String s) {
		int totalOnes = 0;
		// Count the total number of '1's in the string, excluding the first character
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				totalOnes++;
			}
		}
		int maxScore = 0;
		int zerosLeft = 0;
		int onesRight = totalOnes;
		// Iterate through the string, excluding the last character
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '0') {
				zerosLeft++;
			} else {
				// If we encounter a '1', we decrease the count of '1's on the right side
				onesRight--;
			}
			// The current score is the number of '0's on the left side plus the number of '1's on the right side
			int currentScore = zerosLeft + onesRight;
			// Update the maximum score found so far
			maxScore = Math.max(maxScore, currentScore);
		}

		return maxScore;
	}
}
