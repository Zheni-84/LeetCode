package easy.done;

/**
 * LeetCode Problem 69: Sqrt(x)
 * Time Complexity: O(log x)
 * Space Complexity: O(1)
 * Topics: Math, Binary Search
 *
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 *
 * Example:
 * Input: x = 10
 * Output: 3
 * Explanation: The square root of 10 is approximately 3.1622776602,
 * and since the decimal part is truncated, 3 is returned.
 *
 * Hint: Use binary search to find the integer square root efficiently.
 * https://leetcode.com/problems/sqrtx/
 */
public class SqrtX {

	public static void main(String[] args) {
		int x = 10;
		int result = mySqrt(x);
		System.out.println("The integer square root of " + x + " is: " + result); // Output: 2
	}
	private static int mySqrt(int x) {
		if (x < 2)
			return x; // 0 or 1

		int l = 1, r = x / 2;
		while (r - l >= 0) {
			int m = (l + r) / 2;
			long sq = (long) m * m; // avoid overflow
			if (sq == x)
				return m;
			if (sq < x) {
				l = m + 1; // move right
			} else {
				r = m - 1; // move left
			}
		}
		return r; // transition point
	}
}