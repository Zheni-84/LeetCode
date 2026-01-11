package easy.done;

/**
 * Problem: Plus One
 * Time Complexity: O(N) where N is the number of digits
 * Space Complexity: O(1) or O(N) in case of carry over
 * Topics: Array, Math
 *
 * Given a non-empty array of decimal digits representing a non-negative integer,
 * increment one to the integer. The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contains a single digit. You may assume the integer does not contain any leading zero,
 * except the number 0 itself.
 *
 * Examples:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 *
 * Input: digits = [9]
 * Output: [1,0]
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * Solutions:
 * 1. Simple Iteration from the end (O(N) time, O(1) space)
 *
 * Hint:
 * 1. Start from the last digit and move towards the first digit.
 * 2. If the digit is less than 9, increment it and return.
 * 3. If the digit is 9, set it to 0 and continue to the next digit.
 * 4. If all digits are 9, create a new array with an extra digit at the start.
 *
 * Hint:
 * 1. Iterate through the array from the last digit to the first.
 * 2. If the current digit is less than 9, increment it and return the array.
 * 3. If the current digit is 9, set it to 0 and continue to the next digit.
 * 4. If all digits are 9, create a new array with an additional leading 1.	The rest of the digits will be 0 by default.
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 9, 9, 9 };
		int[] result = plusOne(digits);
		for (int digit : result) {
			System.out.print(digit + " ");
		}
	}

	private static int[] plusOne(int[] digits) {
		// Start from the last digit and move towards the first digit
		for (int i = digits.length - 1; i >= 0; i--) {
			// Increment the last digit
			if (digits[i] < 9) {
				// If the digit is less than 9, just increment it and return
				digits[i]++;
				return digits;
			}
			// If the digit is 9, set it to 0 and continue to the next digit
			digits[i] = 0;
		}
		// If all digits are 9, we need to create a new array with an extra digit
		int[] result = new int[digits.length + 1];
		result[0] = 1;

		return result;
	}
}