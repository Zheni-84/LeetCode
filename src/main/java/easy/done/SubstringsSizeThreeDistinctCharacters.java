package easy.done;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 1876 - Substrings of Size Three with Distinct Characters
 * Topics: String, Sliding Window, Hash Set
 * Time Complexity: O(n), where n is the length of the string.
 * Space Complexity: O(1) for the Set (the set is always of length 3, it does not grow with the input grow)!!!
 * <p>
 * Description:
 * Counts the number of substrings of size three that contain three distinct characters.
 * Example: For input "aababcabc", the output is 4.
 * LeetCode Link: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 */
public class SubstringsSizeThreeDistinctCharacters {

	public static void main(String[] args) {
		String s = "aababcabc";
		System.out.println("Number of good substrings: " + countGoodSubstrings(s)); // Output: 4
	}

	private static int countGoodSubstrings(String s) {
		int result = 0;
		int len = s.length();

		for (int i = 0; i <= len - 3; i++) {
			String sub = s.substring(i, i + 3);
			Set<Character> charSet = sub.chars()
					.mapToObj(c -> (char) c)
					.collect(Collectors.toSet());
			if (charSet.size() == 3) {
				result++;
			}
		}

		return result;
	}
}