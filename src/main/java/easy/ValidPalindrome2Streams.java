package easy;

import java.util.stream.IntStream;

/**
 * LeetCode Problem 680 - Valid Palindrome II
 * Topics: String, Two Pointers, Greedy
 * <p>
 * Description:
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * Link: https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome2Streams {

	public static void main(String[] args) {
		// Example usage
		String word = "abca";
		boolean result = validPalindrome(word);
		System.out.println("Is the word a valid palindrome? " + result);
	}

	public static boolean validPalindrome(String s) {
		return IntStream.range(0, s.length() / 2)
				// Check if the characters at the left and right ends are equal
				// If they are not equal, check if we can skip one character
				.allMatch(i ->
						// If they are equal, continue checking the next characters
						s.charAt(i) == s.charAt(s.length() - 1 - i) ||
								trySkip(s, i, s.length() - 1 - i) ||
								trySkip(s, i + 1, s.length() - 1 - i - 1));
	}

	private static boolean trySkip(String s, int left, int right) {
		// Check if the characters at the left and right ends are equal
		return IntStream.range(left, (right + left + 1) / 2)
				// Check if the characters at the left and right ends are equal
				.allMatch(i -> s.charAt(i) == s.charAt(right - (i - left)));
	}
}