package easy.done;

/*
 * LeetCode Problem: 58. Length of Last Word
 * Topics: String
 * Time Complexity: O(n), where n is the length of the string s.
 * Space Complexity: O(1), since we are using a constant amount of space for the result and index variables.
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * Example:
 *   Input: s = "Hello World"
 *   Output: 5
 *   Input: s = "   "
 *   Output: 0
 * Constraints:
 *   - 1 <= s.length <= 10^4
 *   - s consists of only upper/lower-case alphabets and empty space characters ' '.
 * This class provides a static method lengthOfLastWord to find the length of the last word in a given string.
 *
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		String s = "Hello World";
		int length = lengthOfLastWord(s);
		System.out.println("Length of last word: " + length); // Output: 5

		s = "   ";
		length = lengthOfLastWord(s);
		System.out.println("Length of last word: " + length); // Output: 0

		s = "a";
		length = lengthOfLastWord(s);
		System.out.println("Length of last word: " + length); // Output: 1
	}

	private static int lengthOfLastWord(String s) {
		int result = 0;
		int i = s.length()-1;

		// Skip trailing spaces
		while(i>=0 && s.charAt(i)==' '){
			i--;
		}

		// Count the length of the last word
		while(i>=0 && s.charAt(i)!=' '){
			result++;
			i--;
		}

		return result;
	}
}