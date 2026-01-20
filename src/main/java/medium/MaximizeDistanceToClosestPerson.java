package medium;

/**
 * LeetCode 849. Maximize Distance to Closest Person
 * Time Complexity: O(n) where n is the number of seats
 * Space Complexity: O(1)
 * Topics: Array, Two Pointers
 *
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat,
 * and seats[i] = 0 represents that the ith seat is empty (0-indexed).
 * There is at least one empty seat and at least one person sitting.
 * Alex wants to sit in a seat such that the distance between him and the closest person to him is maximized.
 * Return that maximum distance to the closest person.
 *
 * Examples:
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 *
 * Input: seats = [1,0,0,0]
 * Output: 3
 *
 * Input: seats = [0,1]
 * Output: 1
 *
 * Constraints:
 * 2 <= seats.length <= 2 * 10^4
 * seats[i] is 0 or 1.
 * At least one seat is empty.
 * At least one seat is occupied.
 *
 * Solutions:
 * 1. Single pass with last occupied seat tracking (O(n) time, O(1) space)
 * 2. Segmented approach (O(n) time, O(1) space)
 *
 * Hint:
 * 1. Consider leading zeros, middle segments of zeros, and trailing zeros separately.
 * 2. Use a single pass to track the last occupied seat and calculate distances on the fly.
 *
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class MaximizeDistanceToClosestPerson {

	public static void main(String[] args) {
		int[] seats1 = { 1, 0, 0, 0, 1, 0, 1 };
		int[] seats2 = { 1, 0, 0, 0 };
		int[] seats3 = { 0, 1 };
		System.out.println("Max distance to closest person (Method 1) - Seats1: " + maxDistToClosest(seats1)); // Output: 2
		System.out.println("Max distance to closest person (Method 1) - Seats2: " + maxDistToClosest(seats2)); // Output: 3
		System.out.println("Max distance to closest person (Method 1) - Seats3: " + maxDistToClosest(seats3)); // Output: 1

		System.out.println("Max distance to closest person (Method 2) - Seats1: " + maxDistToClosest2(seats1)); // Output: 2
		System.out.println("Max distance to closest person (Method 2) - Seats2: " + maxDistToClosest2(seats2)); // Output: 3
		System.out.println("Max distance to closest person (Method 2) - Seats3: " + maxDistToClosest2(seats3)); // Output: 1
	}

	// Single pass implementation with last occupied seat tracking
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	private static int maxDistToClosest(int[] seats) {
		int maxDistance = 0;
		int lastOccupied = -1;
		int n = seats.length;

		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				if (lastOccupied == -1) {
					maxDistance = i; // Distance from the start
				} else {
					maxDistance = Math.max(maxDistance, (i - lastOccupied) / 2);
				}
				lastOccupied = i;
			}
		}
		// Check distance from the last occupied seat to the end
		if (seats[n - 1] == 0) {
			maxDistance = Math.max(maxDistance, n - 1 - lastOccupied);
		}

		return maxDistance;
	}

	// Alternative implementation with clearer segmentation
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	private static int maxDistToClosest2(int[] seats) {
		int n = seats.length;
		int maxDist = 0;

		// 1. Leading zeros
		int i = 0;
		while (i < n && seats[i] == 0) {
			i++;
		}
		maxDist = i;  // distance if Alex sits at index 0

		// 2. Middle segments
		int prev = i; // prev is the index of the last seen 1
		for (; i < n; i++) {
			if (seats[i] == 1) {
				if (prev != i) {
					int zeros = i - prev - 1;
					maxDist = Math.max(maxDist, zeros / 2);
				}
				prev = i;
			}
		}

		// 3. Trailing zeros
		int trailingZeros = n - 1 - prev;
		maxDist = Math.max(maxDist, trailingZeros);

		return maxDist;
	}

	public int maxDistToClosestTwoPointer(int[] seats) {
		int n = seats.length;
		int maxDist = 0;

		// Step 1: find first and last person
		int first = 0;
		while (first < n && seats[first] == 0)
			first++;
		int last = n - 1;
		while (last >= 0 && seats[last] == 0)
			last--;

		// Leading zeros
		maxDist = first;

		// Two pointers: find consecutive 1's
		int i = first;
		int j = i + 1;

		while (j < n) {
			// move j to next person
			while (j < n && seats[j] == 0)
				j++;

			if (j < n) {
				int gap = j - i - 1;  // zeros between i and j
				maxDist = Math.max(maxDist, gap / 2);
				i = j; // move i to current person
				j++;
			}
		}

		// Trailing zeros
		maxDist = Math.max(maxDist, n - 1 - last);

		return maxDist;
	}
}