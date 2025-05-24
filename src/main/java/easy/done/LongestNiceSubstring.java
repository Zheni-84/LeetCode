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
		System.out.println("Brute force O(n^3): " + longestNiceSubstringBruteForce(s));
		System.out.println("Divide&Conquer: " + longestNiceSubstringDC(s));
	}

	/**
	 * Function to find the longest nice substring using Devide and Conquer.
	 *
	 * @param s The input string.
	 * @return The longest nice substring.
	 */
	private static String longestNiceSubstringDC(String s) {
		return divideAndConquer(s, 0, s.length());
	}

	private static String divideAndConquer(String s, int start, int end) {
		if(end - start < 2) {
			return "";
		}

		Set<Character> set = s.substring(start, end)
				// Convert to IntStream and then to Set<Character>
				// This will ensure we have both cases of each character
				.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toSet());

		for (int i = start; i < end; i++) {
			char c = s.charAt(i);
			if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
				continue; // still nice so far
			}

			// Found a bad char — split around it
			String left = divideAndConquer(s, start, i);
			String right = divideAndConquer(s, i + 1, end);
			return left.length() >= right.length() ? left : right;
		}

		// If we never split, the whole substring is nice
		return s.substring(start, end);
	}

	/**
	 * Function to find the longest nice substring using Brute Force.
	 *
	 * @param s The input string.
	 * @return The longest nice substring.
	 */
	private static String longestNiceSubstringBruteForce(String s) {
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