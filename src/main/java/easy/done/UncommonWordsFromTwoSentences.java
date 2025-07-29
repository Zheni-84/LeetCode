package easy.done;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *  LeetCode Problem 884. Uncommon Words from Two Sentences
 *  Time Complexity: O(n)
 *  Space Complexity: O(n)
 *  Topic: HashMap, String Manipulation
 *
 *  You are given two sentences s1 and s2 that consist of some words separated by a single space with no leading or trailing spaces.
 *  Each sentence consists of only lowercase English letters and spaces.
 *  There may be multiple words with the same word.
 *
 *  A word is uncommon if it appears exactly once in one of the sentences and does not appear in the other sentence.
 *
 *  Return a list of all uncommon words. You may return the answer in any order.
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 */
public class UncommonWordsFromTwoSentences {

	public static void main(String[] args) {
		String s1 = "this apple is sweet";
		String s2 = "this apple is sour";
		String[] result = uncommonFromSentences(s1, s2);
		System.out.println(String.join(", ", result)); // Output: sweet, sour

		s1 = "apple apple";
		s2 = "banana";
		result = uncommonFromSentencesStreams(s1, s2);
		System.out.println(String.join(", ", result)); // Output: banana
	}

	private static String[] uncommonFromSentencesStreams(String s1, String s2) {
		Map<String, Long> wordsCount = Stream.concat(Stream.of(s1.split(" ")), Stream.of(s2.split(" ")))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		// Alternative way to count words using forEach
		//.forEach(word -> wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1));

		return wordsCount.entrySet().stream()
				.filter(entry -> entry.getValue() == 1)
				.map(Map.Entry::getKey)
				.toArray(String[]::new);
	}

	private static String[] uncommonFromSentences(String s1, String s2) {
		String[] words1 = s1.split(" ");
		String[] words2 = s2.split(" ");

		Map<String, Integer> wordCount = new HashMap<>();

		for (String word : words1) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		for (String word : words2) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		return wordCount.entrySet().stream()
				.filter(entry -> entry.getValue() == 1)
				.map(Map.Entry::getKey)
				.toArray(String[]::new);
	}
}