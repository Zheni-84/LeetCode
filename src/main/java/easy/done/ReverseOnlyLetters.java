package easy.done;

/**
 * LeetCode Problem 917: Reverse Only Letters
 * Topics: String, Two Pointers
 * Time Complexity: O(n), where n is the length of the string s.
 * Space Complexity: O(n), for the character array used to store the result.
 *
 * Given a string s, reverse the order of all characters in s that are letters,
 * while keeping all other characters in their original positions.
 *
 * Example 1:
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Constraints:
 * - 1 <= s.length <= 100
 * - s consists of characters and '-' or '_'.
 * http://leetcode.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {
	private static String reverseOnlyLetters1(String s) {
		char[] chars = s.toCharArray();
		int left = 0, right = chars.length - 1;

		while (left < right) {
			if (!Character.isLetter(chars[left])) {
				left++;
			} else if (!Character.isLetter(chars[right])) {
				right--;
			} else {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			}
		}

		return new String(chars);
	}

	public String reverseOnlyLetters2(String s) {
		char[] chars =s.toCharArray();
		int left = 0;
		int right = s.length()-1;

		while(left < right){
			// Move left pointer to the next letter
			while(left<right && !Character.isLetter(chars[left])){
				left++;
			}
			// Move right pointer to the previous letter
			while(left < right && !Character.isLetter(chars[right])){
				right--;
			}

			// Swap the letters at left and right pointers
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;

			// Move both pointers inward
			left++;
			right--;
		}

		return new String(chars);
	}
}