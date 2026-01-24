package easy.done;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 1624: Largest Substring Between Two Equal Characters
 * Time Complexity: O(n)
 * Space Complexity: O(1) or O(k) where k is the number of unique characters
 * Topics: String, Hash Table, Array
 * <p>
 * Given a string s, return the length of the longest substring between two equal characters,
 * excluding the two characters. If there is no such substring, return -1.
 * <p>
 * Example:
 * Input: s = "abca"
 * Output: 2
 * Explanation: The substring between the two 'a's is "bc", which has a length of 2.
 * <p>
 * Hint:
 * 1. Use a HashMap to store the first occurrence index of each character.
 * 2. Iterate through the string and calculate the length of substrings between equal characters.
 * 3. Keep track of the maximum length found.
 * <p>
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 */
public class LargestSubstringBetweenTwoEqualCharacters {

	public static void main(String[] args) {
		String s = "abca";
		System.out.println("Max length (Map): " + maxLengthBetweenEqualCharactersMap(s)); // Output: 2
		System.out.println("Max length (Array): " + maxLengthBetweenEqualCharactersArray(s)); // Output: 2
	}

	private static int maxLengthBetweenEqualCharactersMap(String s) {
		int maxLen = -1;
		Map<Character, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (indexMap.containsKey(c)) {
				int indx = indexMap.get(c);
				int len = i - indx - 1;
				maxLen = Math.max(maxLen, len);
			} else
				indexMap.put(c, i);
		}

		return maxLen;
	}

	private static int maxLengthBetweenEqualCharactersArray(String s) {
		int maxLength = -1;
		int[] firstIndex = new int[26];
		for (int i = 0; i < 26; i++) {
			firstIndex[i] = -1;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			if (firstIndex[index] == -1) {
				firstIndex[index] = i;
			} else {
				int length = i - firstIndex[index] - 1;
				if (length > maxLength) {
					maxLength = length;
				}
			}
		}

		return maxLength;
	}
}