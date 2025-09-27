package easy.done;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * LeetCode Problem 290: Word Pattern
 * Time Complexity: O(n), where n is the length of the pattern or the number of words in the string.
 * Space Complexity: O(1), since we are using a fixed-size array for character mapping and a hash map for word mapping.
 * Topics: String, Hash Table
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * <p>
 * Constraints:
 * - 1 <= pattern.length <= 300
 * - pattern contains only lowercase English letters.
 * - 1 <= s.length <= 3000
 * - s contains only lowercase English letters and spaces.
 * - s does not contain any leading or trailing spaces.
 * - All the words in s are separated by a single space.
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

	public static void main(String[] args) {
		String pattern1 = "abba";
		String s1 = "dog cat cat dog";

		boolean result = wordPatternArray(pattern1, s1);
		System.out.println("pattern1 to s1 " + result);

		String pattern2 = "abba";
		String s2 = "dog cat cat fish";
		boolean result2 = wordPatternArray(pattern2, s2);
		System.out.println("pattern2 to s2 " + result2);

		String pattern3 = "aaaa";
		String s3 = "dog cat cat dog";
		boolean result3 = wordPatternMaps(pattern3, s3);
		System.out.println("pattern3 to s3 " + result3);
	}

	private static boolean wordPatternArray(String pattern, String s) {
		String[] words = s.split(" ");
		// If the length of the pattern does not match the number of words, return false
		if (pattern.length() != words.length) {
			return false;
		}

		// Create a mapping from characters to indices and from words to indices
		// We use indices starting from 1 to avoid confusion with uninitialized values
		int[] charToIndex = new int[26];
		Map<String, Integer> wordToIndex = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			// Get the character and the corresponding word
			char c = pattern.charAt(i);
			String word = words[i];
			// Convert character to index (0 for 'a', 1 for 'b', ..., 25 for 'z')
			int patternIndex = charToIndex[c - 'a'];
			// Get the index of the word from the map, defaulting to 0 if not found
			int wordIndex = wordToIndex.getOrDefault(word, 0);

			// If the character has been seen before, it should match the current word index
			if (patternIndex != wordIndex) {
				return false;
			}

			// Update the indices for the character and the word
			// We use i+1 to ensure that index 0 is not used, as 0 would mean uninitialized
			// we use i+1 to distinguish between multiple mappings for the same character or word
			charToIndex[c - 'a'] = i + 1;
			wordToIndex.put(word, i + 1);
		}

		return true;
	}

	private static boolean wordPatternMaps(String pattern, String s) {
		String[] words = s.split(" ");
		if (pattern.length() != words.length)
			return false;

		Map<Character, String> charToWord = new HashMap<>();
		Map<String, Character> wordToChar = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String word = words[i];

			// Check if the character is already mapped to a word
			if (charToWord.containsKey(c)) {
				// If the character is already mapped, check if it maps to the same word
				if (!charToWord.get(c).equals(word))
					return false;
			} else {
				// If the word is already mapped to a different character, return false
				if (wordToChar.containsKey(word))
					return false;

				// Otherwise, create the mapping
				charToWord.put(c, word);
				wordToChar.put(word, c);
			}
		}

		return true;
	}

	private static boolean wordPattern2(String pattern, String s) {
		String[] words = s.split(" ");
		if (pattern.length() != words.length) {
			return false;
		}

		Map<Character, String> charToWord = new HashMap<>();
		Map<String, Character> wordToChar = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String w = words[i];

			// Compare existing mapping directly
			String mappedWord = charToWord.getOrDefault(c, w);
			Character mappedChar = wordToChar.getOrDefault(w, c);

			if (!mappedWord.equals(w) || mappedChar != c) {
				return false;
			}

			// Create new mapping if absent
			charToWord.put(c, w);
			wordToChar.put(w, c);
		}
		return true;
	}

	public boolean wordPattern(String pattern, String s) {
		String[] words = s.split(" ");
		if(pattern.length() != words.length) return false;

		Map<Character, String> charToWord = new HashMap<>();
		Map<String, Character> wordToChar = new HashMap<>();
		for(int i = 0; i < pattern.length(); i++){
			char ch = pattern.charAt(i);
			String word = words[i];

			charToWord.putIfAbsent(ch, word);
			wordToChar.putIfAbsent(word, ch);

			if( !charToWord.get(ch).equals(word) || wordToChar.get(word) != ch){
				return false;
			}
		}

		return true;
	}

	private static boolean wordPattern3(String pattern, String s) {
		String[] words = s.split(" ");
		if (pattern.length() != words.length) {
			return false;
		}

		Map<Object, Integer> seen = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String w = words[i];

			// If the previous index of char and word differ, mapping is broken
			// We use Object as the key type to allow both Character and String keys
			// The put method returns the previous value associated with the key, or null if there was no mapping
			// By comparing the results of the two put calls, we can determine if the mappings are consistent
			// If they are not equal, it means one was seen before the other, breaking the bijection
			// We use i (the current index) as the value to store the last seen index
			// This way, both the character and the word will have the same last seen index if they are correctly mapped
			// If they are not correctly mapped, their last seen indices will differ
			// This approach ensures that each character maps to one unique word and vice versa
			// It effectively checks the bijection property
			// Example: pattern = "abba", s = "dog cat cat dog"
			// Iteration 0: c = 'a', w = "dog" -> seen.put('a', 0) = null, seen.put("dog", 0) = null -> equal
			// Iteration 1: c = 'b', w = "cat" -> seen.put('b', 1) = null, seen.put("cat", 1) = null -> equal
			// Iteration 2: c = 'b', w = "cat" -> seen.put('b', 2) = 1, seen.put("cat", 2) = 1 -> equal
			// Iteration 3: c = 'a', w = "dog" -> seen.put('a', 3) = 0, seen.put("dog", 3) = 0 -> equal
			if (!Objects.equals(seen.put(c, i), seen.put(w, i))) {
				return false;
			}
		}
		return true;
	}
}