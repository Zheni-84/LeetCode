package easy;

import java.util.Arrays;

/**
 * LeetCode Problem: 2108. Find First Palindromic String in the Array
 * Space: O(n)
 * Time: O(n)
 * Topics: Array, String
 * You are given an array of strings words. A string is palindromic if it reads the same forward and backward.
 * Return the first palindromic string in the array. If there is no such string, return an empty string "".
 * <p>
 * Example:
 * Input: words = ["abc","car","ada","racecar","cool"]
 * Output: "ada"
 * Hint: Use a two-pointer technique to check for palindromes.
 * http://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 */
public class FindFirstPalindromicStringInTheArray {

/*	| Approach                | Time Complexity | Space Complexity | Allocations | GC Impact | Style Readability         |
	| ----------------------- | --------------- | ---------------- | ----------- | --------- | ------------------------- |
	| **Two-pointer classic** | O(n × m)        | O(1)             | None        | None      | ✅ Very clear             |
	| **Streams + reverse()** | O(n × m)        | O(m) per check   | High        | Moderate  | ✅ Concise but alloc-heavy|
	| **Two-pointer XOR**     | O(n × m)        | O(1)             | None        | None      | ⚠️ Slightly cryptic       |
*/

	public static void main(String[] args) {
		String[] words = { "abc", "car", "ada", "racecar", "cool" };
		String result = firstPalindrome(words);
		System.out.println("First palindromic string: " + result); // Output: "ada"

		String[] words2 = { "notapalindrome", "racecar" };
		String result2 = firstPalindrome(words2);
		System.out.println("First palindromic string: " + result2); // Output: "racecar"

		String[] words3 = { "abc", "def", "ghi" };
		String result3 = firstPalindromeStream(words3);
		System.out.println("First palindromic string: " + result3); // Output
	}

	private static String firstPalindromeStream(String[] words) {
		return Arrays.stream(words)
				.filter(w -> new StringBuilder(w).reverse().toString().equals(w))
				.findFirst()
				.orElse("");
	}

	private static String firstPalindrome(String[] words) {
		for (String word : words) {
			if (isPalindromeFast(word)) {
				return word;
			}
		}
		return "";
	}

	private static boolean isPalindrome(String word) {
		int left = 0;
		int right = word.length() - 1;
		while (left < right) {
			if (word.charAt(left) != word.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	// Fastest method using XOR to compare characters
	// This method assumes that the characters are ASCII and uses the property that
	// if two characters are the same, their XOR will be 0.
	// This is a clever trick that avoids the need for explicit character comparison.
	// Note: This method is less readable and may not be suitable for all character sets.
	private static boolean isPalindromeFast(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			// XOR check: if chars differ, XOR will be non-zero
			if ((s.charAt(left) ^ s.charAt(right)) != 0) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}