package easy;

import java.util.Arrays;

/**
 * LeetCode Problem 1295 - Find Numbers with Even Number of Digits
 * Topics: Array, Math, Streams
 * Description:
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * <p>
 * Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class NumbersWithEvenNumberOfDigits {

	public static void main(String[] args) {
		int[] nums = { 12, 345, 2, 6, 7896 };
		//Example usage
		//Output: 2
		//Explanation:
		//12 contains 2 digits (even number of digits).
		//345 contains 3 digits (odd number of digits).
		//2 contains 1 digit (odd number of digits).
		//6 contains 1 digit (odd number of digits).
		//7896 contains 4 digits (even number of digits).
		//However, only 12 and 7896 contain an even number of digits.

		System.out.println("Even count of digits numbers: " + findNumbers(nums));
	}
	private static int findNumbers(int[] nums) {

		return (int) Arrays.stream(nums)
				.filter(num -> String.valueOf(num).length() % 2 == 0)
				.count();
	}
}