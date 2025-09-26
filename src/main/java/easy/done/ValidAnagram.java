package easy.done;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 242: Valid Anagram
 * Time Complexity: O(n), where n is the length of the input strings.
 * Space Complexity: O(1), since we are using a fixed-size array for character counts.
 * Topics: String, Hash Table, Sorting (used in alternative solutions)
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters.
 * Hint: You can use a character count array or a HashMap to count the occurrences of each character in both strings and compare them.
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println("Is \"" + t + "\" an anagram of \"" + s + "\": " + isAnagramMap(s, t)); // Output: true

		s = "rat";
		t = "car";
		System.out.println("Is \"" + t + "\" an anagram of \"" + s + "\": " + isAnagram(s, t)); // Output: false
	}

	// Using HashMap to count character frequencies
	// Time Complexity: O(n)
	// Space Complexity: O(1) - since the character set is limited to lowercase English letters
	private static boolean isAnagramMap(String s, String t) {
		if (s.length() != t.length()) return false;

		Map<Character, Integer> freq = new HashMap<>();

		for (char c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		for (char c : t.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) - 1);
			if (freq.get(c) < 0) return false; // early exit
		}

		return true;
	}

	// Using a fixed-size array to count character frequencies
	// Time Complexity: O(n)
	// Space Complexity: O(1) - since the character set is limited to lowercase English letters
	private static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		// Create an array to count occurrences of each character
		int[] count = new int[26];
		// Count the occurrences of each character in both strings
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}

		// Check if all counts are zero
		for (int c : count) {
			if (c != 0) {
				return false;
			}
		}

		return true;
	}
}