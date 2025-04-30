package easy;

/**
 * LeetCode Problem 66 - Plus One
 * Topics: Array, Math
 * <p>
 * Increment a number represented as an array of digits by one.
 * <p>
 * Link: https://leetcode.com/problems/plus-one/
 *
 */
// Given a non-empty array of digits representing a non-negative integer,
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 9, 9, 9 };
		int[] result = plusOne(digits);
		for (int digit : result) {
			System.out.print(digit + " ");
		}
	}

	/**
	 * Increment a number represented as an array of digits by one.
	 *
	 * @param digits The input array of digits.
	 * @return The resulting array after incrementing the number by one.
	 */
	private static int[] plusOne(int[] digits) {
		// Start from the last digit and move towards the first digit
		for (int i = digits.length - 1; i >= 0; i--) {
			// Increment the last digit
			if (digits[i] < 9) {
				// If the digit is less than 9, just increment it and return
				digits[i] += 1;
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