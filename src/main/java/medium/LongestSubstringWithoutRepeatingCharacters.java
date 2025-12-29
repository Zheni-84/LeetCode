package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode Problem 3: Longest Substring Without Repeating Characters
 * Time Complexity: O(n) - where n is the length of the input string.
 * Space Complexity: O(min(m, n)) - where m is the size of the character set and n is the length of the input string.
 * Topics: Hash Table, String, Sliding Window
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * Hint: Use a sliding window approach with two pointers to track the current substring and a hash set to check for repeating characters.
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "abcabcbb";
		// Output: 3
		// Explanation: The answer is "abc", with the length of 3.
		System.out.println("Longest Substring Without Repeating Characters: " + lengthOfLongestSubstring(s));

		s = "bbbbb";
		// Output: 1
		// Explanation: The answer is "b", with the length of 1.
		System.out.println("Longest Substring Without Repeating Characters: " + lengthOfLongestSubstringBrute(s));

		s = "pwwkew";
		// Output: 3
		// Explanation: The answer is "wke", with the length of 3.
		// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		System.out.println("Longest Substring Without Repeating Characters: " + lengthOfLongestSubstringOptimal(s));
	}

	// Optimal approach using sliding window and character index mapping
	// Time Complexity: O(n) - where n is the length of the input string.
	// Space Complexity: O(min(m, n)) - where m is the size of the character set and n is the length of the input string.
	// This approach uses an array to store the last index of each character, allowing for O(1) access time.
	// The left pointer is updated to the maximum of its current position and the last index of the current character + 1.
	// This ensures that the substring between left and right pointers always contains unique characters.
	private static int lengthOfLongestSubstringOptimal(String s) {
		int n = s.length();
		int maxLength = 0;
		int left = 0;
		int right = 0;
		int[] index = new int[128]; // Assuming ASCII character set

		while (right < n) {
			char currentChar = s.charAt(right);
			left = Math.max(index[currentChar], left);
			maxLength = Math.max(maxLength, right - left + 1);
			index[currentChar] = right + 1; // Update the index of the current character
			right++;
		}

		return maxLength;
	}

	// Brute force approach using a hash set to track characters in the current substring
	// Time Complexity: O(n^2) - where n is the length of the input string.
	// Space Complexity: O(min(m, n)) - where m is the size of the character set and n is the length of the input string.
	// This approach checks all possible substrings starting from each character in the string.
	// For each starting character, it expands the substring until a duplicate character is found.
	// The maximum length of all such substrings is tracked and returned.
	private static int lengthOfLongestSubstringBrute(String s) {
		int n = s.length();
		int maxLength = 0;

		for (int i = 0; i < n; i++) {
			Set<Character> charSet = new HashSet<>();
			for (int j = i; j < n; j++) {
				char currentChar = s.charAt(j);
				if (charSet.contains(currentChar)) {
					break;
				} else {
					charSet.add(currentChar);
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}

		return maxLength;
	}

	// Sliding window approach using a hash set to track characters in the current substring
	// Time Complexity: O(n) - where n is the length of the input string.
	// Space Complexity: O(min(m, n)) - where m is the size of the character set and n is the length of the input string.
	// This approach uses two pointers (left and right) to represent the current substring.
	// The right pointer expands the window by adding characters to the set until a duplicate is found.
	// When a duplicate is found, the left pointer is moved to the right, removing characters from the set until the duplicate is removed.
	// This process continues until the right pointer reaches the end of the string.
	private static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int maxLength = 0;
		int left = 0;
		int right = 0;
		Set<Character> charSet = new HashSet<>();

		while (right < n) {
			char currentChar = s.charAt(right);
			if (!charSet.contains(currentChar)) {
				charSet.add(currentChar);
				right++;
				maxLength = Math.max(maxLength, right - left);
			} else {
				charSet.remove(s.charAt(left));
				left++;
			}
		}

		return maxLength;
	}
}