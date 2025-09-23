package easy.done;

import java.util.Set;

/*
 * LeetCode Problem 202 - Happy Number
 * Topics: Hash Table, Math, Two Pointers
 * Time Complexity: O(log n) - where n is the input number. This is because the number of digits in n is log(n) and we are processing each digit.
 * Space Complexity: O(1) - as we are using only a constant amount of extra space.
 *
 * Description:
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle that does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Hint: Use the Floyd's Cycle-Finding Algorithm (Tortoise and Hare) to detect cycles in the sequence of sums of squares.
 * Link: https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
	public static void main(String[] args) {
		int n = 19;
		// Output: true
		// Explanation: 1^2 + 9^2 = 82
		//              8^2 + 2^2 = 68
		//              6^2 + 8^2 = 100
		//              1^2 + 0^2 + 0^2 = 1
		System.out.println("Is Happy Number: " + isHappyNumberTheory(n));

		n = 2;
		// Output: false
		// Explanation: The process results in an endless cycle of numbers that does not include 1.
		System.out.println("Is Happy Number: " + isHappy(n));
	}

	// Floyd's Cycle-Finding Algorithm
	// Time Complexity: O(log n)
	// Space Complexity: O(1)
	private static boolean isHappy(int n) {
		int slow = n;
		int fast = sumOfSquares(n);

		while (fast != 1 && slow != fast) {
			slow = sumOfSquares(slow);
			fast = sumOfSquares(sumOfSquares(fast));
		}

		return fast == 1;
	}

	// Set to track known unhappy numbers to prevent infinite loops
	// Time Complexity: O(log n)
	// Space Complexity: O(1)
	// This set contains numbers that are part of the cycle for unhappy numbers.
	// If we encounter any of these numbers, we can immediately conclude that n is not a happy number.
	private static final Set<Integer> unhappyCycle = Set.of(4, 16, 37, 58, 89, 145, 42, 20);
	private static boolean isHappyNumberTheory(int n) {
		while (n != 1 && !unhappyCycle.contains(n)) {
			n = sumOfSquares(n);
		}

		return n == 1;
	}

	// Helper function to calculate the next number in the sequence
	private static int sumOfSquares(int num) {
		int totalSum = 0;
		while (num > 0) {
			int d = num % 10;
			totalSum += d * d;
			num /= 10;
		}

		return totalSum;
	}

}
