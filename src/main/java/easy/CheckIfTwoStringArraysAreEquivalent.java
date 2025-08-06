package easy;

//add leetcode documentation
/**
 * LeetCode Problem: 1662. Check If Two String Arrays are Equivalent
 * Time: O(n + m) where n is the total length of all strings in word1 and m is the total length of all strings in word2.
 * Space: O(1)
 * Topics: String, Two Pointers
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * A string is represented by an array if the array elements concatenated in order forms the string.
 * <p>
 * Example:
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Hint: Use two pointers to compare characters from both arrays.
 * http://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
public class CheckIfTwoStringArraysAreEquivalent {

	public static void main(String[] args) {
		String[] word1 = {"ab", "c"};
		String[] word2 = {"a", "bc"};
		System.out.println("Are the two string arrays equivalent? " + arrayStringsAreEqualBrute(word1, word2));

		String[] word3 = {"a", "cb"};
		String[] word4 = {"ab", "c"};
		System.out.println("Are the two string arrays equivalent? " + arrayStringsAreEqual(word3, word4));

		String[] word5 = {"abc", "d", "defg"};
		String[] word6 = {"abcddefg"};
		System.out.println("Are the two string arrays equivalent? " + arrayStringsAreEqual(word5, word6));
	}
	/*
	 * Brute Force:
	 * Time Complexity: O(n + m) where n is the total length of all strings in word1 and m is the total length of all strings in word2.
	 * Space Complexity: O(n + m) for the string concatenation in the brute force method.
	 */
	private static boolean arrayStringsAreEqualBrute(String[] word1, String[] word2) {
		// Convert both string arrays to single strings
		return String.join("", word1).equals(String.join("", word2));
	}

	/*
	 * Two Pointers:
	 * Time Complexity: O(n + m) where n is the total length of all strings in word1 and m is the total length of all strings in word2.
	 * Space Complexity: O(1) since we are not using any additional data structures that grow with input size.
	 */
	private static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		// Two pointers approach to compare the two string arrays
		// i for word1 and j for word2
		int i = 0;
		int j = 0;
		// Pointers to track the character position in each string in the respective arrays
		// p1 for word1 and p2 for word2
		int p1 = 0;
		int p2 = 0;

		while (i < word1.length && j < word2.length) {
			// If the characters at the current position do not match, return false
			if (word1[i].charAt(p1) != word2[j].charAt(p2)) {
				return false;
			}

			p1++;
			// If p1 reaches the end of the current string in word1, move to the next string and reset p1 to 0
			if (p1 == word1[i].length()) {
				i++;
				p1 = 0;
			}

			p2++;
			// If p2 reaches the end of the current string in word2, move to the next string and reset p2 to 0
			if (p2 == word2[j].length()) {
				j++;
				p2 = 0;
			}
		}

		// If both pointers have reached the end of their respective arrays, the arrays are equivalent
		return i == word1.length && j == word2.length;
	}
}