package easy;

import java.util.*;

/**
 * LeetCode Problem 496 - Next Greater Element I
 * <p>
 * Description:
 * The next greater element of some element x in an array is the first greater
 * element that is to the right of x in the same array. You are given two distinct
 * 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
 * and determine the next greater element of nums2[j] in nums2. If there is no
 * next greater element, then the answer for this query is -1.
 * <p>
 * Link: https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement1 {

	//Could you find an O(nums1.length + nums2.length) solution?
	//You may assume that nums1 and nums2 have no duplicates.
	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		//Example usage
		//Output: [-1, 3, -1]
		//Explanation: For nums1[0]=4, there is no next greater element, so the answer is -1.
		//For nums1[1]=1, the next greater element is 3.
		//For nums1[2]=2, there is no next greater element, so the answer is -1.
		//Output: [-1, 3, -1]

		int[] result = nextGreaterElement(nums1, nums2);
		System.out.print(Arrays.toString(result));
	}

	static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//Create a map to hold the next greater values for numbers in num2
		Map<Integer, Integer> nextGreater = new HashMap<>();
		//Use a stack to keep track of all elements in decreasing order
		Deque<Integer> stack = new ArrayDeque<>();
		//Iterate over num2
		for (int num : nums2) {
			//Pop elements from the stack while the current number is greater
			while (!stack.isEmpty() && num > stack.peek()) {
				//The current number is the next greater element for the popped number
				int smaller = stack.pop();
				//Store the mapping in the map
				nextGreater.put(smaller, num);
			}
			//push current number to the stack
			stack.push(num);
		}
		//All remaining element in the stack does not have a greater element in num2
		while (!stack.isEmpty()) {
			nextGreater.put(stack.pop(), -1);
		}

		//Build the result for nums1 using the precomputed map
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			//Get the next greater element for each number in nums1
			result[i] = nextGreater.get(nums1[i]);
		}

		return result;
	}
}