package easy;

import java.util.Arrays;

/**
 * LeetCode Problem 1491 - Average Salary Excluding the Minimum and Maximum Salary
 * Topics: Array, Sorting
 * Time Complexity: O(n log n) - for sorting the array, where n is the length of the input array.
 * Space Complexity: O(1) - in-place sorting.
 * <p>
 * Description:
 * Given an array of unique integers salary where salary[i] is the salary of the employee i,
 * return the average salary of employees excluding the minimum and maximum salary.
 * <p>
 * Link: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */
public class AverageSalaryExcludingMinimumMaximum {

	public static void main(String[] args) {
		int[] salary = { 4000, 3000, 1000, 2000 };
		// Example usage
		// Output: 2500.00000
		// Explanation: Minimum salary is 1000 and maximum salary is 4000.
		// Average salary excluding minimum and maximum is (2000 + 3000) / 2 = 2500.00000.
		System.out.println("Average Salary Excluding Minimum and Maximum: " + average(salary));
	}

	private static double average(int[] salary) {
		Arrays.sort(salary);
		int sum = 0;

		// Exclude the first and last elements (minimum and maximum) from the sorted array
		for (int i = 1; i < salary.length - 1; i++) {
			sum += salary[i];
		}

		return (double) sum / (salary.length - 2);
	}
}