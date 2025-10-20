package easy.done;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem 268: Missing Number
 * Time Complexity: O(n) for HashSet approach, O(n log n) for Binary Search approach
 * Space Complexity: O(n) for HashSet approach, O(1) for Binary Search approach
 * Topics: Array, Hash Table, Sorting, Binary Search
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Example:
 * Input: nums = [3,0,1]
 * Output: 2
 *
 * Hint: Use a HashSet to track existing numbers or sort the array and use binary search to find the missing number.
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] nums1 = {3, 0, 1};
		int[] nums2 = {0, 1};
		int[] nums3 = {9,6,4,2,3,5,7,0,1};

		System.out.println("Missing Number (HashSet approach): " + missingNumber(nums1)); // Output: 2
		System.out.println("Missing Number (HashSet approach): " + missingNumber(nums2)); // Output: 2
		System.out.println("Missing Number (HashSet approach): " + missingNumber(nums3)); // Output: 8

		System.out.println("Missing Number (Binary Search approach): " + missingNumberBS(nums1)); // Output: 2
		System.out.println("Missing Number (Binary Search approach): " + missingNumberBS(nums2)); // Output: 2
		System.out.println("Missing Number (Binary Search approach): " + missingNumberBS(nums3)); // Output: 8
	}

	// HashSet approach
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static int missingNumber(int[] nums) {
		int n = nums.length;

		// Put all numbers into a HashSet
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		// The missing number must be in the range [0..n]
		for (int i = 0; i <= n; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		// theoretically unreachable
		return -1;
	}

	// Binary Search approach
	// Time Complexity: O(n log n) due to sorting
	// Space Complexity: O(1)
	private static int missingNumberBS(int[] nums) {
		Arrays.sort(nums);
		int l = -1;
		int r = nums.length;

		while(r - l > 1){
			int mid = (l+r)/2;
			if(nums[mid] == mid){
				l = mid;
			}else r = mid;
		}

		return r;
	}
}