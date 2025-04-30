package easy;

import java.util.*;

/**
 * LeetCode Problem 819 - Most Common Word
 * Topics: Array, String, Hash Table, Counting
 * <p>
 * Description:
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the banned list.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Time complexity: O(n), where n is the length of the paragraph.
 * Space complexity: O(n), where n is the number of unique words in the paragraph.
 * <p>
 * Link: https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {

	public static void main(String[] args) {
		// Example usage
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		String result = mostCommonWord(paragraph, banned);
		System.out.println("Most common word: " + result); // Output: "ball"
	}

	private static String mostCommonWord(String paragraph, String[] banned) {

		String[] words = paragraph
				// Step 1: Convert paragraph to lowercase
				.toLowerCase()
				// Step 2: Replace all punctuation with space
				.replaceAll("[!?',;.]", " ")
				// Step 3: Split paragraph into words
				.split("\\s+");

		// Step 4: Create a set from the banned array
		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

		// Step 5: Use a map to count frequencies of non-banned words
		Map<String, Integer> freq = new HashMap<>();
		for (String word : words) {
			if (!bannedSet.contains(word) && !word.isEmpty()) {
				freq.put(word, freq.getOrDefault(word, 0) + 1);
			}
		}
		// Step 6: Find and return the most frequent non-banned word
		return freq.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.orElse("");
	}
}