package easy.done;

/**
 * LeetCode Problem 680 - Valid Palindrome II
 * Topics: String, Two Pointers, Greedy
 * <p>
 * Description:
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * Link: https://leetcode.com/problems/valid-palindrome-ii/
 * <p>
 * Constraints:
 * - 1 <= s.length <= 105
 * - s consists of lowercase English letters.
 * - s can be checked for palindrome by removing at most one character.
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * Example 1:
 * Input: s = "aba"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "abca"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "abc"
 * Output: false
 * <p>
 * Note:
 * - The solution uses a two-pointer approach to check if the string can be a palindrome by removing at most one character.
 * - The function checks if the characters at the left and right pointers are equal.
 * - If they are not equal, it checks if the substring formed by removing either the left or right character is a palindrome.
 * - The helper function isPalindrome checks if a substring is a palindrome by comparing characters from both ends.
 * - The main function validPalindrome returns true if the string can be a palindrome after removing at most one character.
 * <p>
 * Time Complexity:
 * - O(n), where n is the length of the string.
 * <p>
 * Space Complexity:
 * - O(1), as no additional space is used except for a few variables.
 */

public class ValidPalindrome2 {
	public static void main(String[] args) {

		System.out.println(validPalindrome("abca")); // true
		System.out.println(validPalindrome("abc")); // false
		System.out.println(validPalindrome("a")); // true
		System.out.println(validPalindrome("aa")); // true
		System.out.println(validPalindrome("aba")); // true
		System.out.println(validPalindrome("abccba")); // true
	}
	public static boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;

		while(left < right){
			// If the characters at the left and right pointers are equal
			// Move the pointers towards the center
			if(s.charAt(left) == s.charAt(right)){
				left++;
				right--;
			}else{
				// If they are not equal, check if the substring formed by removing either the left or right character is a palindrome
				// Check if the substring formed by removing the left OR right character is a palindrome
				// If either of them is a palindrome, return true
				// If not, return false
				return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
			}
		}
		// If all characters matched, it is a palindrome
		return true;
	}

	private static boolean isPalindrome(String s, int left, int right){
		while(left<right){
			// Check if the characters at the left and right pointers are equal
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			// Move the pointers towards the center
			left++;
			right--;
		}
		// If all characters matched, it is a palindrome
		return true;
	}
}