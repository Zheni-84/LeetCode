package easy;

/**
 * LeetCode Problem 125 - Valid Palindrome
 *
 * Determine if a string is a palindrome, considering only alphanumeric characters and ignoring cases.
 * A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward
 * (ignoring spaces, punctuation, and capitalization).
 *
 * Link: https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		// Example usage
		String word = "A man, a plan, a canal: Panama";
		boolean result = isPalindrome(word);
		// Output: true
		System.out.println("Is the word a palindrome? " + result);
	}

	/**
	 * Check if a given string is a palindrome.
	 *
	 * @param word The input string to check.
	 * @return true if the input string is a palindrome, false otherwise.
	 */
	public static boolean isPalindrome(String word) {
		// Convert the string to lowercase and remove all non-alphanumeric characters
		word = word.toLowerCase().replaceAll("[^a-z0-9]", "");
		int leftEnd = 0;
		int rightEnd = word.length() - 1;
		// Check if the characters at the left and right ends are equal
		while(leftEnd < rightEnd){
			// If they are not equal, it is not a palindrome
			if(word.charAt(leftEnd) != word.charAt(rightEnd)){
				return false;
			}
			// Move the pointers towards the center
			leftEnd++;
			rightEnd--;

		}
		// If all characters matched, it is a palindrome
		return true;
	}
}