package easy.done;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 2068: Check Whether Two Strings are Almost Equivalent
 * Time Complexity: O(n + m), where n and m are the lengths of word1 and word2 respectively.
 * Space Complexity: O(1), since the frequency maps will have at most 26 entries (for each lowercase English letter).
 * Topics: String, Hash Table
 * <p>
 * Two strings word1 and word2 are almost equivalent if the differences between the frequencies
 * of each letter from 'a' to 'z' between word1 and word2 is at most 3.
 * Given two strings word1 and word2, return true if they are almost equivalent, or false otherwise.
 * <p>
 * Example:
 * Input: word1 = "aaaa", word2 = "bccb"
 * Output: false
 * Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb".
 * The difference is 4, which is more than the allowed 3.
 * <p>
 * Hint: Count the frequency of each character in both strings and compare the differences.
 * https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
 */
public class CheckWhetherTwoStringsAlmostEquivalent {

	public static void main(String[] args) {
		String word1 = "aaaa";
		String word2 = "bccb";

		boolean resultStream = checkAlmostEquivalentStream(word1, word2);
		System.out.println("Using Streams: Are the two words almost equivalent? " + resultStream); // false

		boolean resultArray = checkAlmostEquivalentArray(word1, word2);
		System.out.println("Using Arrays: Are the two words almost equivalent? " + resultArray); // false
	}


	// The Stream solution is more expressive but less memory-and CPU-efficient because every primitive value has to be boxed into an object.
	// That adds indirection and garbage collection overhead. The array version operates purely on primitives,
	// which are CPU-cache-friendly and require no object management.
	// In practice, for small strings this overhead is negligible, but as an architect I’d consider whether this code runs on the
	// critical path or in bulk. If it’s part of a tight loop or high-frequency API, I’d prefer the array version.
	// Otherwise, the Stream API might be acceptable for readability.

	// Time Complexity: O(n + m), where n and m are the lengths of word1 and word2 respectively.
	// Space Complexity: O(1), since the frequency maps will have at most 26 entries (for each lowercase English letter).
	private static boolean checkAlmostEquivalentStream(String word1, String word2) {
		Map<Character, Long> freq1 = word1.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		Map<Character, Long> freq2 = word2.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		return java.util.stream.IntStream.rangeClosed('a', 'z')
				.allMatch(c -> {
					long diff1 = freq1.getOrDefault((char) c, 0L);
					long diff2 = freq2.getOrDefault((char) c, 0L);

					long diff = Math.abs(diff1 - diff2);
					return diff <= 3;
				});
	}

	// Time Complexity: O(n + m), where n and m are the lengths of word1 and word2 respectively.
	// Space Complexity: O(1), since the frequency arrays will have a fixed size of 26.
	private static boolean checkAlmostEquivalentArray(String word1, String word2) {
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];

		for (char c : word1.toCharArray())
			freq1[c - 'a']++;

		for (char c : word2.toCharArray())
			freq2[c - 'a']++;

		for (int i = 0; i < 26; i++) {
			if (Math.abs(freq1[i] - freq2[i]) > 3)
				return false;
		}

		return true;
	}
}