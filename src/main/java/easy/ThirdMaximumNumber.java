package easy;

import java.util.TreeSet;

/**
 * LeetCode Problem 414 - Third Maximum Number
 * Topics: Array, Sorting
 * <p>
 * Description:
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 * <p>
 * Link: https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximumNumber {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1 };
		//Example usage
		//Output: 1
		//Explanation: The first distinct maximum is 3, the second distinct maximum is 2, and the third distinct maximum is 1.
		System.out.println("Third maximum number: " + thirdMax(nums));

		nums = new int[] { 1, 2 };
		//Output: 2
		//Explanation: The first distinct maximum is 2, the second distinct maximum is 1.
		System.out.println("Third maximum number: " + thirdMax(nums));

		nums = new int[] { 2, 2, 3, 1 };
		//Output: 1
		//Explanation: Note that the third distinct maximum here means the third distinct number in sorted order,
		//so it must be 1.
		System.out.println("Third maximum number: " + thirdMax(nums));
	}

	private static int thirdMax(int[] nums) {
		TreeSet<Integer> topTree = new TreeSet<>();

		for (int num : nums) {
			topTree.add(num);
			if (topTree.size() > 3) {
				//Remove first
				topTree.pollFirst();
			}
		}
		//If we have 3 distinct values, return the smallest, or return the last(largest)
		return topTree.size() == 3
				? topTree.first()
				: topTree.last();
	}
}