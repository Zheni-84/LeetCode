package medium;

import java.util.Arrays;

/**
 * LeetCode 452. Minimum Number of Arrows to Burst Balloons
 * Time Complexity: O(N log N) where N is the number of balloons
 * Space Complexity: O(1)
 * Topics: Greedy, Sorting
 *
 * You are given an array points where points[i] = [xstart, xend] denotes a balloon
 * whose horizontal diameter stretches between xstart and xend. You want to burst all the balloons
 * by shooting arrows vertically upwards from different points along the x-axis.
 * An arrow can burst a balloon if it is shot at a point x such that xstart <= x <= xend.
 * Find the minimum number of arrows that must be shot to burst all balloons.
 */

public class MinimumNumberArrowsToBurstBalloons {

	public static void main(String[] args) {
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		int result = findMinArrowShots(points);
		System.out.println("Minimum number of arrows to burst all balloons: " + result);
	}

	private static int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		// Sort the balloons based on their end coordinates
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

		int arrows = 1; // At least one arrow is needed
		int lastArrowPosition = points[0][1]; // Position of the first arrow

		for (int i = 1; i < points.length; i++) {
			// If the current balloon starts after the last arrow position,
			// we need a new arrow
			if (points[i][0] > lastArrowPosition) {
				arrows++;
				lastArrowPosition = points[i][1]; // Update the position of the new arrow
			}
		}

		return arrows;
	}
}