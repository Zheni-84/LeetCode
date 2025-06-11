package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 287. Find the Duplicate Number
 * Topic: Array, Two Pointers, Binary Search
 * <p>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicate {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 4, 3, 1 };
		System.out.println("Duplicate Number: " + findDuplicateBeastMode(nums)); // Output: 2
		// Example using HashSet
		int[] numbers = { 1, 3, 4, 2, 2 };
		System.out.println("Duplicate Number with Set: " + findDuplicateWithSet(numbers)); // Output: 2
		// Example using Needle
		int[] numbersWithNeedle = { 3, 1, 3, 4, 2 };
		System.out.println("Duplicate Number with Needle: " + findDuplicateWithNeedle(numbersWithNeedle)); // Output: 3
		// Example using Binary Search
		int[] numbersWithBinarySearch = { 1, 3, 4, 2, 2 };
		System.out.println("Duplicate Number with Binary Search: " + findRepeatBinarySearch(numbersWithBinarySearch)); // Output: 2
	}

	/**
	 * This method uses Floyd's Tortoise and Hare (Cycle Detection) algorithm to find the duplicate number in the array.
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * It treats the array as a linked list where each index points to the value at that index.
	 * The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
	 * When they meet, it indicates a cycle, and then it finds the entrance to the cycle which is the duplicate number.
	 *
	 * @param nums the input array of integers
	 * @return the first duplicate number found
	 */
	private static String findDuplicateBeastMode(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		// Phase 1: Finding the intersection point in the cycle
		// Use Floyd's Tortoise and Hare (Cycle Detection) algorithm
		do {
			slow = nums[slow]; // Move slow pointer by 1 step
			fast = nums[nums[fast]]; // Move fast pointer by 2 steps
		} while (slow != fast); // Loop until they meet

		// Phase 2: Finding the entrance to the cycle
		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow]; // Move slow pointer by 1 step
			fast = nums[fast]; // Move fast pointer by 1 step
		}
		// The point where they meet is the duplicate number
		return String.valueOf(slow);
	}

	/**
	 * This method uses a HashSet to find the duplicate number in the array.
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * It iterates through the array and checks if the number has already been seen.
	 * If it has, it returns that number as the duplicate.
	 * If no duplicate is found, it throws an IllegalArgumentException.
	 *
	 * @param numbers the input array of integers
	 * @return the first duplicate number found
	 */
	public static int findDuplicateWithSet(int[] numbers) {
		Set<Integer> numbersSeen = new HashSet<>();
		for (int number : numbers) {
			if (numbersSeen.contains(number)) {
				return number;
			} else {
				numbersSeen.add(number);
			}
		}

		// whoops--no duplicate
		throw new IllegalArgumentException("no duplicate!");
	}

	/**
	 * This method finds the duplicate number in the array by iterating through each possible number (1 to n-1).
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * It checks if the number has been seen before in the array.
	 * If it has, it returns that number as the duplicate.
	 * If no duplicate is found, it throws an IllegalArgumentException.
	 *
	 * @param numbers the input array of integers
	 * @return the first duplicate number found
	 */
	public static int findDuplicateWithNeedle(int[] numbers) {
		for (int needle = 1; needle < numbers.length; needle++) {
			boolean hasBeenSeen = false;
			for (int number : numbers) {
				if (number == needle) {
					if (hasBeenSeen) {
						return number;
					} else {
						hasBeenSeen = true;
					}
				}
			}
		}

		// whoops--no duplicate
		throw new IllegalArgumentException("no duplicate!");
	}

	/**
	 * This method uses a binary search approach to find the duplicate number in the array.
	 * Time Complexity: O(n log n)
	 * Space Complexity: O(1)
	 * It divides the range of possible numbers into two halves and counts how many numbers fall into each half.
	 * If the count in one half exceeds the number of distinct integers that can fit in that half, it narrows down the search to that half.
	 * When the floor and ceiling converge, it returns the found duplicate number.
	 *
	 * @param numbers the input array of integers
	 * @return the first duplicate number found
	 */
	public static int findRepeatBinarySearch(int[] numbers) {

		int floor = 1;
		int ceiling = numbers.length - 1;

		while (floor < ceiling) {

			// divide our range 1..n into an upper range and lower range
			// (such that they don't overlap)
			// lower range is floor..midpoint
			// upper range is midpoint+1..ceiling
			int midpoint = floor + ((ceiling - floor) / 2);
			int lowerRangeFloor   = floor;
			int lowerRangeCeiling = midpoint;
			int upperRangeFloor   = midpoint + 1;
			int upperRangeCeiling = ceiling;

			// count number of items in lower range
			int itemsInLowerRange = 0;
			for (int item : numbers) {

				// is it in the lower range?
				if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
					itemsInLowerRange += 1;
				}
			}

			int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

			if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {

				// there must be a duplicate in the lower range
				// so use the same approach iteratively on that range
				floor   = lowerRangeFloor;
				ceiling = lowerRangeCeiling;
			} else {

				// there must be a duplicate in the upper range
				// so use the same approach iteratively on that range
				floor   = upperRangeFloor;
				ceiling = upperRangeCeiling;
			}
		}

		// floor and ceiling have converged
		// we found a number that repeats!
		return floor;
	}
}