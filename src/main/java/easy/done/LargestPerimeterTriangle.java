package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 976 - Largest Perimeter Triangle
 * Topics: Array, Sorting
 * Time Complexity: O(n log n) - for sorting the array, where n is the length of the input array.
 * Space Complexity: O(1), as we are sorting the array in place.
 * <p>
 * Description:
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
 * formed from three of these lengths.
 * If it is impossible to form any triangle of a non-zero area, return 0.
 * <p>
 * Link: https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class LargestPerimeterTriangle {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 2 };
		// Example usage
		// Output: 5
		// Explanation: The perimeter is 2 + 1 + 2 = 5.
		System.out.println("Largest perimeter: " + largestPerimeter(nums));

		nums = new int[] { 1, 2, 1 };
		// Output: 0
		// Explanation: The perimeter cannot be formed.
		System.out.println("Largest perimeter: " + largestPerimeter(nums));
	}

	private static int largestPerimeter(int[] nums) {
		// Step 1: Sort the array in ascending order
		Arrays.sort(nums);

		// Step 2: Start from the largest numbers and check for valid triangle
		for (int i = nums.length - 1; i >= 2; i--) {
			int c = nums[i];
			int b = nums[i - 1];
			int a = nums[i - 2];
			// Step 3: Check triangle condition: sum of two smaller > largest
			if (a + b > c) {
				// Valid triangle found
				return a + b + c;
			}
		}

		return 0;
	}
}