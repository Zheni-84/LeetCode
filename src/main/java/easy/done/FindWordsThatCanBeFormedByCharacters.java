package easy.done;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 1160 - Find Words That Can Be Formed by Characters
 * Time complexity: O(n * m) - where n is the number of words and m is the average length of the words.
 * Space complexity: O(1) - since we are using a fixed-size array for character counts.
 * Topics: Array, HashMap Table
 * <p>
 * Description:
 * Given an array of strings words and a string chars, return the sum of lengths of all good words in words.
 * A good word is a word that can be formed by characters from chars (each character can only be used once).
 * <p>
 * Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class FindWordsThatCanBeFormedByCharacters {

	public static void main(String[] args) {
		String[] words = { "hello", "world", "leetcode" };
		String chars = "welldonehoneyr";

		int result = countCharacters(words, chars);
		System.out.println("Total length of good words: " + result); // Output: 10
	}

	//use hashmap to count frequency of characters in chars
	//for each word, count frequency of characters and compare with chars frequency
	//if word frequency is less than or equal to chars frequency for all characters, add word length to total
	private static int countCharactersMap(String[] words, String chars) {
		Map<Character, Integer> charFreq = new HashMap<>();

		// Count frequency of each character in chars
		for (char c : chars.toCharArray()) {
			charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
		}

		int total = 0;
		for (String word : words) {
			Map<Character, Integer> wordFreq = new HashMap<>();

			// Count frequency of each character in the current word
			for (char c : word.toCharArray()) {
				wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
			}

			boolean isGood = true;
			// Check if the word can be formed by the characters in chars
			for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
				char c = entry.getKey();
				int freq = entry.getValue();
				if (freq > charFreq.getOrDefault(c, 0)) {
					isGood = false;
					break;
				}
			}
			// If the word can be formed, add its length to the total count.
			if (isGood) {
				total += word.length();
			}
		}

		return total;

	}

	private static int countCharacters(String[] words, String chars) {
		int[] charFreq = new int[26];

		// Count frequency of each character in chars
		for (char c : chars.toCharArray()) {
			charFreq[c - 'a']++;
		}

		int total = 0;
		for (String word : words) {
			int[] wordFreq = new int[26];

			// Count frequency of each character in the current word
			for (char c : word.toCharArray()) {
				wordFreq[c - 'a']++;
			}

			boolean isGood = true;
			// Check if the word can be formed by the characters in chars
			// by comparing the frequency of each character in the word with the frequency in chars.
			// If any character in the word has a frequency greater than that in chars, the word cannot be formed.
			for (int i = 0; i < 26; i++) {
				if (wordFreq[i] > charFreq[i]) {
					isGood = false;
					break;
				}
			}
			// If the word can be formed, add its length to the total count.
			if (isGood) {
				total += word.length();
			}
		}

		return total;
	}
}