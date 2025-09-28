package easy.done;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode Problem 383: Ransom Note
 * Time Complexity: O(n + m), where n is the length of the ransom note and m is the length of the magazine.
 * Space Complexity: O(1), since we are using a fixed-size array for character counts.
 * Topics: String, Hash Table
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

	public static void main(String[] args) {
		String ransomNote = "a";
		String magazine = "b";
		boolean result = canConstructMap(ransomNote, magazine);
		System.out.println("Can construct ransom note: " + result); // Output: false

		ransomNote = "aa";
		magazine = "ab";
		result = canConstructBrute(ransomNote, magazine);
		System.out.println("Can construct ransom note: " + result); // Output: false

		ransomNote = "aa";
		magazine = "aab";
		result = canConstructArray(ransomNote, magazine);
		System.out.println("Can construct ransom note: " + result); // Output: true
	}

	private static boolean canConstructMap(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : magazine.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (char c : ransomNote.toCharArray()) {
			if (!map.containsKey(c) || map.get(c) == 0) return false;
			map.put(c, map.get(c) - 1);
		}

		return true;
	}

	private static boolean canConstructArray(String ransomNote, String magazine) {
		// Create an array to count occurrences of each character (a-z)
		int[] letters = new int[26];

		// Count the occurrences of each character in the magazine
		for(char c : magazine.toCharArray()){
			letters[c - 'a']++;
		}

		// Check if we can construct the ransom note using the characters from the magazine
		for(char c : ransomNote.toCharArray()){
			//This works even when c is not in the magazine, since letters[c - 'a'] will be 0, so we can safely decrement it
			letters[c - 'a']--;
			// If the count goes below zero, we cannot construct the ransom note
			if( letters[c - 'a'] < 0){
				return false;
			}
		}

		// If we successfully checked all characters, we can construct the ransom note
		return true;
	}

	private static boolean canConstructBrute(String ransomNote, String magazine) {
		StringBuilder sb = new StringBuilder(magazine);

		// Iterate through each character in the ransom note
		for (char c : ransomNote.toCharArray()) {
			// Find the index of the character in the magazine
			int index = sb.indexOf(String.valueOf(c));
			// If the character is not found, return false
			if (index == -1) {
				return false;
			}
			// Remove the character from the magazine
			sb.deleteCharAt(index);
		}

		return true;
	}
}
