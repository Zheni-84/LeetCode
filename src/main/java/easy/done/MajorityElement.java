package easy.done;

/*
 * LeetCode Problem 169 - Majority Element
 * Topics: Array, Hash Table, Divide and Conquer, Sorting
 * Time Complexity: O(n) - where n is the length of the input array.
 * Space Complexity: O(1) - as we are using only a constant amount of extra space.
 *
 * Description:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * Hint: Use the Boyer-Moore Voting Algorithm to find the majority element in linear time and constant space.
 * Link: https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		// Output: 3
		System.out.println("Majority Element: " + majorityElement(nums));

		nums = new int[]{2, 2, 1, 1, 1, 2, 2};
		// Output: 2
		System.out.println("Majority Element: " + majorityElement(nums));
	}

	// Boyer-Moore Voting Algorithm
	private static int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}

	public int majorityElement2(int[] nums) {
		int candidate = 0;
		int count = 0;

		for(int num : nums){
			// When count drops to 0, we pick a new candidate
			if(count == 0) candidate = num;

			// Increment or decrement the count based on whether the current number matches the candidate
			if(candidate == num){
				count++;
			}else{
				count--;
			}
		}

		// The candidate is guaranteed to be the majority element
		return candidate;
	}
}