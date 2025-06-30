package easy.done;

/**
 * LeetCode Problem 67: Add Binary Strings
 * Topics: String, Math, Bit Manipulation
 * Time Complexity: O(n + m), where n is the length of string a and m is the length of string b.
 * Space Complexity: O(n + m), since we are using a StringBuilder to store the result.
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "1010", b = "1101"
 * Output: "10111"
 *
 * Example 2:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Constraints:
 * - 1 <= a.length, b.length <= 10^4
 * - a and b consist only of '0' or '1' characters.
 * http://leetcode.com/problems/add-binary/
 */
public class AddBinaryStrings {

	public static void main(String[] args) {
		String a = "1010";
		String b = "1101";
		String result = addBinary(a, b);
		System.out.println("Sum of binary strings: " + result); // Output: 10111
	}
	private static String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;

		while (i >= 0 || j >= 0 || carry != 0) {
			// Get the current bits from a and b, or 0 if we've exhausted one of the strings
			int bitA = i >= 0 ? a.charAt(i--) - '0' : 0;
			int bitB = j >= 0 ? b.charAt(j--) - '0' : 0;

			// Calculate the sum of the bits and the carry
			int sum = bitA + bitB + carry;
			// Append the result bit (sum % 2) and update the carry (sum / 2)
			result.append(sum % 2);
			carry = sum / 2;
		}

		// The result is built in reverse order, so we need to reverse it before returning
		return result.reverse().toString();
	}
}