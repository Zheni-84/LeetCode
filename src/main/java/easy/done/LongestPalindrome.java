package easy.done;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem 409 - Longest Palindrome
 * Topics: Hash Table, String
 * Time Complexity: O(n) - where n is the length of the string s, as we traverse the string once.
 * Space Complexity: O(1) - since we use a fixed-size array for character counts.
 * <p>
 * Description:
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindromic substring in s.
 * A palindrome is a string that reads the same backward as forward.
 * <p>
 * Link: https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		String s1 = "abccccdd";
		System.out.println("Longest Palindrome length in \"" + s1 + "\": " + longestPalindrome(s1)); // Output: 7

		String s2 = "a";
		System.out.println("Longest Palindrome length in \"" + s2 + "\": " + longestPalindromeSet(s2)); // Output: 1

		String s3 = "bb";
		System.out.println("Longest Palindrome length in \"" + s3 + "\": " + longestPalindromeSet(s3)); // Output: 2
	}

	private static int longestPalindrome(String s) {
		int[] counts = new int[128]; //ASCII size
		// Count occurrences of each character
		for (char c : s.toCharArray()) {

			counts[c]++;
		}

		int length = 0;
		boolean hasOdd = false;
		for (int count : counts) {
			// Add the largest even number less than or equal to count
			length += (count / 2) * 2;
			// Check if there is an odd count
			if (count % 2 == 1) {
				hasOdd = true;
			}
		}

		// If there is at least one odd count, we can add one more character to the palindrome
		return hasOdd ? length + 1 : length;
	}

	// Using HashSet to track characters with odd counts
	// Time Complexity: O(n)
	// Space Complexity: O(n) in the worst case where all characters are unique
	private static int longestPalindromeSet(String s) {
		Set<Character> set = new HashSet<>();

		int pairs = 0;
		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				set.remove(ch);
				pairs++;
			} else
				set.add(ch);
		}
		int odd = set.isEmpty() ? 0 : 1;

		return pairs * 2 + odd;
	}
}