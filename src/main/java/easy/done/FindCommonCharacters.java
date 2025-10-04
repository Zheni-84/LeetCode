package easy.done;

import java.util.*;

/**
 * LeetCode Problem 1002 - Find Common Characters
 * Time complexity: O(n * m) - where n is the number of words and m is the average length of the words.
 * Space complexity: O(1) - since we are using a fixed-size array for character counts.
 * Topics: Array, HashMap Table
 *
 * Description:
 * Given an array of strings words, return an array of all characters that show up in all strings within the array (including duplicates).
 * You may return the answer in any order.
 *
 * Link: https://leetcode.com/problems/find-common-characters/
 */
public class FindCommonCharacters {

	public static void main(String[] args) {
		String[] words1 = {"bella", "label", "roller"};
		String[] words2 = {"cool", "lock", "cook"};

		//System.out.println(Arrays.toString(findCommonCharacters1(words1))); // Output: ["e", "l", "l"]
		System.out.println(findCommonCharacters3(words1)); // Output: ["e", "l", "l"]
		System.out.println(findCommonCharacters3(words2)); // Output: ["c", "o"]
	}
	private static String[] findCommonCharacters1(String[] words) {
		if (words == null || words.length == 0) {
			return new String[0];
		}

		// Initialize an array to count occurrences of each character in the first word
		// and then find the minimum occurrences across all words.
		int[] charCount = new int[26];
		for (char c : words[0].toCharArray()) {
			charCount[c - 'a']++;
		}

		for (int i = 1; i < words.length; i++) {
			int[] currentCount = new int[26];
			// Count occurrences of each character in the current word
			for (char c : words[i].toCharArray()) {
				currentCount[c - 'a']++;
			}

			for (int j = 0; j < 26; j++) {
				charCount[j] = Math.min(charCount[j], currentCount[j]);
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			while (charCount[i] > 0) {
				result.append((char) ('a' + i));
				charCount[i]--;
			}
		}

		return result.toString().split("");
	}

	private static List<String> findCommonCharacters2(String[] words) {
		int[] minFreq = new int[26];
		Arrays.fill(minFreq, Integer.MAX_VALUE);

		for(String word : words){
			int[] freq = new int[26];
			// Count frequency of each character in the current word
			for(char c : word.toCharArray()){
				freq[c-'a']++;
			}

			// Update the minimum frequency for each character
			// by comparing with the current word's frequency.
			// If a character does not appear in the current word,
			// it will remain at Integer.MAX_VALUE, which means it won't be included in the result.
			// If it appears, we take the minimum frequency across all words.
			// This ensures that we only keep characters that appear in all words.
			for(int i = 0; i < 26; i++){
				minFreq[i] = Math.min(minFreq[i], freq[i]);
			}
		}

		List<String> result = new ArrayList<>();
		for(int i = 0; i < 26; i++){
			for(int j = 0; j < minFreq[i]; j++){
				// For each character that has a minimum frequency greater than 0,
				// we add it to the result list as a string.
				// We convert the index back to a character by adding 'a' to it.
				result.add(String.valueOf((char)(i + 'a')));
			}
		}

		return result;
	}

	private static List<String> findCommonCharacters3(String[] words) {
		Map<Character, Integer> common = new HashMap<>();
		// Initialize freq map with first word
		for(char c : words[0].toCharArray()){
			common.put(c, common.getOrDefault(c, 0) + 1);
		}

		// Intersect with remainig words
		for(int i = 1; i < words.length; i++){
			Map<Character, Integer> count = new HashMap<>();
			for(char c : words[i].toCharArray()){
				count.put(c, count.getOrDefault(c, 0) + 1);
			}

			//Update common map - keep only chars that repeat
			Set<Character> commonSet = new HashSet<>(common.keySet());
			for(char c : commonSet){
				if(count.containsKey(c)){
					common.put(c, Math.min(common.get(c), count.get(c)));
				} else
					//remove if not in current word
					common.remove(c);
			}
		}

		// Build result
		List<String> result = new ArrayList<>();
		for(Map.Entry<Character, Integer> entry : common.entrySet()){
			for(int i = 0; i < entry.getValue(); i++){
				result.add(String.valueOf(entry.getKey()));
			}
		}

		return result;
	}
}