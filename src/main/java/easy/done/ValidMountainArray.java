package easy.done;

/**
 * LeetCode Problem 941 - Valid Mountain Array
 * Topics: Array, Two Pointers
 * <p>
 * Description:
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * - arr.length >= 3
 * - There exists some i with 0 < i < arr.length - 1 such that:
 * - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * * <p>
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 *   Example 4:
 * Input: arr = [0,2,3,4,5,6,7,8,9]
 * Output: false
 *   Example 5:
 * Input: arr = [1,2,3,4,5,6,7,8,9]
 * Output: false
 *   Example 6:
 * Input: arr = [1,2,3,4,5,6,7,8,9,8]
 * 
 * Link: https://leetcode.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2 };
		boolean result = validMountainArray(nums);
		System.out.println("Is the array a valid mountain array? " + result);
	}

	private static boolean validMountainArray(int[] arr) {
		// Check if the array length is less than or equal to 3
		if (arr.length < 3) {
			return false;
		}

		int i = 0;
		// Check if the array is strictly increasing
		while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
			i++;
		}
		// If the peak is at the start or end of the array, return false
		if (i == 0 || i == arr.length - 1) {
			return false;
		}
		// Check if the array is strictly decreasing after the peak
		while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
			i++;
		}

		// If we have reached the end of the array, return true
		return i == arr.length - 1;
	}
}