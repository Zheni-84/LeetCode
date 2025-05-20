package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 1051 - Height Checker
 * Topics: Array, Sorting
 * Time Complexity: O(n log n) - for sorting the array, where n is the length of the input array.
 * Space Complexity: O(n) - for creating a copy of the array.
 * <p>
 * Description:
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
 * <p>
 * Link: https://leetcode.com/problems/height-checker/
 */
public class HeightChecker {

	public static void main(String[] args) {
		int[] heights = { 1, 1, 4, 2, 1, 3 };
		// Example usage
		// Output: 3
		// Explanation: The heights are [1, 1, 4, 2, 1, 3].
		// After sorting, they are [1, 1, 1, 2, 3, 4].
		// So we have three students with heights not in the right place.
		System.out.println("Number of students not in the right place: " + heightChecker(heights));
	}

	private static int heightChecker(int[] heights) {
		int[] sorted = Arrays.copyOf(heights, heights.length);
		Arrays.sort(sorted);
		int count = 0;

		for(int i = 0; i < heights.length; i++){
			if(heights[i] != sorted[i]){
				count++;
			}
		}

		return count;
	}
}