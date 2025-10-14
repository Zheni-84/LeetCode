package easy.done;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 1897: Redistribute Characters to Make All Strings Equal
 * Time Complexity: O(n * m), where n is the number of words and m is the average length of the words.
 * Space Complexity: O(1), since the frequency map will have at most 26 entries (for each lowercase English letter).
 * Topics: String, Hash Table, Math
 *
 * You are given an array of strings words (0-indexed).
 * In one operation, pick two distinct indices i and j, and move a character from words[i] to any position in words[j].
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 *
 * Example:
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * then all the strings are equal to "abc".
 *
 * Hint: Count the frequency of each character across all strings. Each character's total count must be divisible by the number of strings.
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 */
public class RedistributeCharactersToMakeAllStringsEqual {

	public static void main(String[] args) {
		String[] words1 = { "abc", "aabc", "bc" };
		String[] words2 = { "ab", "a" };

		System.out.println("Can words1 be made equal? " + makeEqual(words1)); // true
		System.out.println("Can words2 be made equal? " + makeEqual(words2)); // false
	}

	private static boolean makeEqual(String[] words) {
		int n = words.length;

		Map<Character, Long> freq = Arrays.stream(words)
				.flatMapToInt(String::chars)
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		return freq.values().stream()
				.allMatch(num -> num % n == 0);
	}
}