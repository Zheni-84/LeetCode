package easy.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 2231 - Largest Number After Digit Swaps by Parity
 * Topics: Math, Sorting, Heap
 * Time Complexity: O(n log n) - where n is the number of digits in the input number.
 * Space Complexity: O(n) - for storing the digits and heaps.
 *
 * Description:
 * You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e., both even or both odd).
 * Return the largest possible value of num after any number of swaps.
 *
 * Hint: Separate the digits into odd and even lists, sort them in descending order, and then reconstruct the number by choosing from these lists based on the original digit's parity.
 * Link: https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
 */
public class LargestNumberAfterDigitSwapsByParity {
	public static void main(String[] args) {
		int num = 1234;
		// Output: 3412
		System.out.println("Largest Number After Digit Swaps By Parity: " + largestInteger(num));

		num = 65875;
		// Output: 87655
		System.out.println("Largest Number After Digit Swaps By Parity: " + largestInteger(num));
	}

	private static int largestIntegerHeap(int num) {
		char[] digits = String.valueOf(num).toCharArray();

		// Collect odd and even digits
		PriorityQueue<Integer> odds = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> evens = new PriorityQueue<>((a, b) -> b - a);
		for (char d : digits) {
			// Separate odd and even digits
			int digit = d - '0';
			if (digit % 2 == 0) {
				evens.offer(digit);
			} else {
				odds.offer(digit);
			}
		}

		StringBuilder result = new StringBuilder();

		// Reconstruct the number
		for (char d : digits) {
			int digit = d - '0';
			if (digit % 2 == 0) {
				result.append(evens.poll());
			} else {
				result.append(odds.poll());
			}
		}

		return Integer.parseInt(result.toString());
	}

	private static int largestInteger(int num) {
		char[] digits = String.valueOf(num).toCharArray();

		// Collect odd and even digits
		List<Integer> odds = new ArrayList<>();
		List<Integer> evens = new ArrayList<>();
		for (char d : digits) {
			int digit = d - '0';
			if (digit % 2 == 0) {
				evens.add(digit);
			} else {
				odds.add(digit);
			}
		}

		// Sort descending
		odds.sort((a, b) -> b - a);
		evens.sort((a, b) -> b - a);

		// Pointers to track next digit
		int oddIndex = 0, evenIndex = 0;
		StringBuilder result = new StringBuilder();

		for (char d : digits) {
			int digit = d - '0';
			if (digit % 2 == 0) {
				result.append(evens.get(evenIndex++));
			} else {
				result.append(odds.get(oddIndex++));
			}
		}

		return Integer.parseInt(result.toString());
	}

	public static int largestIntegerStreamHeap(int num) {
		int[] digits = String.valueOf(num).chars().toArray();

		// Separate odd and even digits using streams
		PriorityQueue<Integer> oddHeap = Arrays.stream(digits)
				.map(d -> d - '0')
				.filter(d -> d % 2 != 0)
				.boxed()
				.collect(Collectors.toCollection(() -> new PriorityQueue<>((a, b) -> b - a)));

		PriorityQueue<Integer> evenHeap = Arrays.stream(digits)
				.map(d -> d - '0')
				.filter(d -> d % 2 == 0)
				.boxed()
				.collect(Collectors.toCollection(() -> new PriorityQueue<>((a, b) -> b - a)));

		// Reconstruct the number by polling the appropriate heap
		return Integer.parseInt(
				Arrays.stream(digits)
						.mapToObj(d -> ((d - '0') % 2 == 0 ? evenHeap.poll() : oddHeap.poll()).toString())
						.collect(Collectors.joining())
		);
	}
}
