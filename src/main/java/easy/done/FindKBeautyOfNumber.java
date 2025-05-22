package easy.done;

/**
 * LeetCode Problem 2395 - Find K-Beauty of a Number
 * Topics: String, Math
 * Time Complexity: O(n), where n is the length of the number.
 * Space Complexity: O(1), since we are using a constant amount of space.
 * <p>
 * Given an integer num and an integer k, return the k-beauty of num.
 * The k-beauty of num is the number of k-digit substrings that are divisors of num.
 * A k-digit substring is a substring that consists of k consecutive digits in num.
 * A divisor of num is a number that divides num evenly (i.e., without leaving a remainder).
 * Note: Leading zeros are allowed.
 * <p>
 * Example:
 * Input: num = 240, k = 2
 * Output: 2
 */
public class FindKBeautyOfNumber {

	public static void main(String[] args) {
		int num = 240;
		int k = 2;
		System.out.println(divisorSubstrings(num, k)); // Output: 2
	}

	private static int divisorSubstrings(int num, int k) {
		String str = String.valueOf(num);
		int count = 0;
		// Iterate through all k-length substrings
		for (int i = 0; i <= str.length() - k; i++) {
			// Extract the k-length substring
			int val = Integer.parseInt(str.substring(i, i + k));
			// Check if the substring is a divisor of num
			if (val > 0 && num % val == 0) {
				count++;
			}
		}

		return count;
	}
}