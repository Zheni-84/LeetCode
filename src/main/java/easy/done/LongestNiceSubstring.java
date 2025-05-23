package easy.done;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 1763 - Longest Nice Substring
 * Topics: String, Brute Force
 * Time Complexity: O(n^3), where n is the length of the string, due to checking all substrings and their characters.
 * Space Complexity: O(n) for storing character sets.
 * <p>
 * Description:
 * Finds the longest "nice" substring in a given string.
 * A substring is "nice" if for every letter in the substring,
 * both its uppercase and lowercase forms also appear in the substring.
 * Example: For input "YazaAay", the output is "aAa".
 */
public class LongestNiceSubstring {

	public static void main(String[] args) {
		String s = "Bb";
		System.out.println(longestNiceSubstring(s));
	}

	private static String longestNiceSubstring(String s) {
		int maxLen = 0;
		String result = "";

		// Check all substrings
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String sub = s.substring(i, j);
				if (isNice(sub) && sub.length() > maxLen) {
					result = sub;
					maxLen = sub.length();
				}
			}
		}

		return result;
	}

	private static boolean isNice(String s) {
		Set<Character> set = s.chars()
				// Convert to IntStream
				.mapToObj(c -> (char) c)
				.collect(Collectors.toSet());
		// Check if all characters have their corresponding opposite case
		for (char c : set) {
			if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) {
				return false;
			}
			if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c))) {
				return false;
			}
		}

		return true;
	}
}