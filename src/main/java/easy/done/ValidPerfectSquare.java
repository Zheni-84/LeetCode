package easy.done;

/**
 * LeetCode Problem 367: Valid Perfect Square
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Topics: Math, Binary Search
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Example:
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * <p>
 * Hint: Use binary search to find the integer whose square is equal to num.
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

	public static void main(String[] args) {
		int num1 = 16;
		int num2 = 14;

		System.out.println("Is " + num1 + " a perfect square? " + isPerfectSquare(num1)); // Output: true
		System.out.println("Is " + num2 + " a perfect square? " + isPerfectSquare(num2)); // Output: false
	}

	private static boolean isPerfectSquare(int num) {
		if (num < 2)
			return true;

		int left = 1;
		int right = num;
		while (right - left > 1) {
			int mid = (left + right) / 2;
			if (mid * mid == num)
				return true;
			else if (mid * mid < num)
				left = mid;
			else
				right = mid;
		}

		return false;
	}
}