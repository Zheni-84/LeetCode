package easy.done;

import java.util.stream.IntStream;

/**
 * LeetCode Problem: 3110. Score of a String
 * Space: O(1)
 * Time: O(n)
 * Topics: String
 * You are given a string s. The score of a string is defined as the sum of
 * the absolute differences between the ASCII values of adjacent characters.
 * Return the score of the string.
 * <p>
 *     Example:
 *     Input: s = "hello"
 *     Output: 4
 *     Explanation: The ASCII values of adjacent characters are:
 *     'h' (104) and 'e' (101) -> |104 - 101| = 3
 *     'e' (101) and 'l' (108) -> |101 - 108| = 7
 *     'l' (108) and 'l' (108) -> |108 - 108| = 0
 *     'l' (108) and 'o' (111) -> |108 - 111| = 3
 *     Total score = 3 + 7 + 0 + 3 = 13
 *     Hint: Iterate through the string and calculate the absolute differences between adjacent characters.
 *     http://leetcode.com/problems/score-of-a-string/
 */
public class ScoreOfAString {

	public static void main(String[] args) {
		String s = "hello";
		int score = scoreOfString(s);
		System.out.println("Score of the string '" + s + "' is: " + score);

		int scoreStream = scoreOfStringStream(s);
		System.out.println("Score of the string '" + s + "' using stream is: " + scoreStream);
	}

	private static int scoreOfStringStream(String s) {
		return IntStream.range(0, s.length()-1)
				.map(i -> Math.abs(s.charAt(i)- s.charAt(i+1)))
				.sum();
	}

	private static int scoreOfString(String s) {
		int result = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			result += Math.abs(s.charAt(i) - s.charAt(i + 1));
		}

		return result;
	}
}