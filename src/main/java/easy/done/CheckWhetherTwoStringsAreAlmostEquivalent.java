package easy.done;

/**
 * LeetCode Problem 2068: Check Whether Two Strings are Almost Equivalent
 * Time Complexity: O(n + m), where n and m are the lengths of word1 and word2 respectively.
 * Space Complexity: O(1) since the size of the frequency arrays is constant (26 for lowercase English letters).
 * Topic: String, Hash Table
 * <p>
 * This class provides a method to determine if two strings are almost equivalent,
 * meaning the absolute difference in the frequency of each character between the two strings
 * does not exceed 3. The main method demonstrates the usage of the checkAlmostEquivalent method.
 * <p>
 * Hint: Use frequency arrays to count character occurrences and compare them.
 * https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
 */
public class CheckWhetherTwoStringsAreAlmostEquivalent {

	public static void main(String[] args) {
		CheckWhetherTwoStringsAreAlmostEquivalent solution = new CheckWhetherTwoStringsAreAlmostEquivalent();

		String word1 = "aaaa";
		String word2 = "bccb";
		System.out.println("Are the two strings almost equivalent? " + solution.checkAlmostEquivalent(word1, word2)); // Output: false

		word1 = "abcdeef";
		word2 = "abaaacc";
		System.out.println("Are the two strings almost equivalent? " + solution.checkAlmostEquivalent(word1, word2)); // Output: true

		word1 = "cccddabba";
		word2 = "babababab";
		System.out.println("Are the two strings almost equivalent? " + solution.checkAlmostEquivalent(word1, word2)); // Output: true
	}

	public boolean checkAlmostEquivalent(String word1, String word2) {
		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for (char c : word1.toCharArray()) {
			count1[c - 'a']++;
		}
		Character charctr = word1.charAt(0);

		for (char c : word2.toCharArray()) {
			count2[c - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (Math.abs(count1[i] - count2[i]) > 3) {
				return false;
			}
		}

		return true;
	}
}