package easy.done;

/**
 * LeetCode Problem 409 - Longest Palindrome
 * Topics: Hash Table, String
 * Time Complexity: O(n) - where n is the length of the string s, as we traverse the string once.
 * Space Complexity: O(1) - since we use a fixed-size array for character counts.
 * <p>
 * Description:
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindromic substring in s.
 * A palindrome is a string that reads the same backward as forward.
 * <p>
 * Link: https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		String s = "abccccdd";
		int result = longestPalindrome(s);
		System.out.println("Longest Palindrome Length: " + result); // Output: 7
	}

	private static int longestPalindrome(String s) {
		int[] counts = new int[128]; //ASCII size
		// Count occurrences of each character
		for (char c : s.toCharArray()) {

			counts[c]++;
		}

		int length = 0;
		boolean hasOdd = false;
		for (int count : counts) {
			// Add the largest even number less than or equal to count
			length += (count / 2) * 2;
			// Check if there is an odd count
			if (count % 2 == 1) {
				hasOdd = true;
			}
		}

		// If there is at least one odd count, we can add one more character to the palindrome
		return hasOdd ? length + 1 : length;
	}
}