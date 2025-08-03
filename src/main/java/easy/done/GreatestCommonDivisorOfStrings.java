package easy.done;

/**
 * LeetCode Problem 1071 - Greatest Common Divisor of Strings
 * Time complexity: O(n + m) - where n and m are the lengths of the two strings.
 * Space complexity: O(1) - since we are using a constant amount of space.
 * Topics: String, Math
 * <p>
 * Description:
 * For two strings str1 and str2, we say "str2 divides str1" if and only if str1 = str2 + ... + str2 (str2 concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/
 **/
public class GreatestCommonDivisorOfStrings {

	public static void main(String[] args) {
		String str1 = "ABCABC";
		String str2 = "ABC";
		System.out.println(gcdOfStrings(str1, str2)); // Output: "ABC"

		str1 = "ABABAB";
		str2 = "ABAB";
		System.out.println(gcdOfStrings(str1, str2)); // Output: "AB"

		str1 = "LEET";
		str2 = "CODE";
		System.out.println(gcdOfStrings(str1, str2)); // Output: ""
	}

	private static String gcdOfStrings(String str1, String str2) {
		// If the concatenation of str1 and str2 in both orders is not equal,
		// then there is no common divisor string.
		// This is a necessary condition for the GCD of two strings.
		// Time complexity: O(n + m) - where n and m are the lengths of the two strings.
		// Space complexity: O(1) - since we are not using any additional space.
		// This check ensures that both strings can be formed by the same
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}

		// The GCD of the two strings is the substring of length gcd(str1.length(), str2.length())
		// starting from index 0 of str1 (or str2, since they are equivalent in this context).
		// We can use the Euclidean algorithm to find the GCD
		int gcdLength = gcd(str1.length(), str2.length());
		return str1.substring(0, gcdLength);
	}

	// Helper function to compute the greatest common divisor (GCD) of two integers
	// using the Euclidean algorithm.
	// Time complexity: O(log(min(a, b))) - where a and b are the lengths of the two strings.
	// Space complexity: O(1) - since we are using a constant amount of space.
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}