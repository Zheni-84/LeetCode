package easy.done;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 819 - Most Common Word
 * Time complexity: O(n), where n is the length of the paragraph.
 * Space complexity: O(n), where n is the number of unique words in the paragraph.
 * Topics: Hash Table, String, Counting
 * <p>
 * Description:
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the banned list.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Link: https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		System.out.println(mostCommonWord(paragraph, banned)); // Output: "ball"
		System.out.println(mostCommonWordStreams(paragraph, banned)); // Output: "ball"
		System.out.println(mostCommonWordStreams2(paragraph, banned)); // Output: "ball"
	}

	private static String mostCommonWord(String paragraph, String[] banned) {
		// Step 1: Normalize the paragraph
		paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z ]", "");

		// Step 2: Split into words
		String[] words = paragraph.split("\\s+");

		// Step 3: Put banned words into a HashSet for O(1) lookup
		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

		// Step 4: Count frequencies
		Map<String, Integer> freq = new HashMap<>();
		for (String word : words) {
			if (!bannedSet.contains(word) && !word.isEmpty()) {
				freq.put(word, freq.getOrDefault(word, 0) + 1);
			}
		}
		// Step 5: Find the most frequent non-banned word
		String mostCommon = "";
		int maxCount = 0;
		for (Map.Entry<String, Integer> word : freq.entrySet()) {
			int count = word.getValue();
			if (count > maxCount) {
				maxCount = count;
				mostCommon = word.getKey();
			}
		}

		return mostCommon;
	}

	// Solution with streams
	private static String mostCommonWordStreams(String paragraph, String[] banned) {
		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

		// Normalize the paragraph and split into words
		// Convert to lowercase, split by non-word characters, and filter out banned words
		String[] words = paragraph.toLowerCase().split("\\W+");
		return Arrays.stream(words)
				.filter(word -> !bannedSet.contains(word) && !word.isEmpty())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.orElse("");
	}

	private static String mostCommonWordStreams2(String paragraph, String[] banned) {

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