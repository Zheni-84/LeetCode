package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 1920 - Minimum Number of Moves to Seat Everyone
 * Topics: Array, Sorting
 * Time Complexity: O(n log n) - for sorting the arrays, where n is the length of the input arrays.
 * Space Complexity: O(1) - in-place sorting.
 * <p>
 * Description:
 * You are given an array seats of length n, where seats[i] is the number of seats in the ith row.
 * You are also given an array students of length n, where students[i] is the number of students in the ith row.
 * <p>
 * Return the minimum number of moves required to seat all students in a row such that no two students are seated in the same row.
 * <p>
 * Link: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
 */
public class MinimumNumberMovesSeatEveryone {

	public static void main(String[] args) {
		int[] seats = { 3, 1, 5 };
		int[] students = { 2, 7, 4 };
		// Example usage
		// Output: 4
		// Explanation: The students can be seated in the following way:
		// - Student 1 sits on seat 1 (1 move)
		// - Student 2 sits on seat 3 (4 moves)
		// - Student 3 sits on seat 5 (0 moves)
		System.out.println("Minimum Number of Moves to Seat Everyone: " + minMovesToSeat(seats, students));
	}

	private static int minMovesToSeat(int[] seats, int[] students) {
		Arrays.sort(seats);
		Arrays.sort(students);

		int minMoves = 0;

		for(int i = 0; i < seats.length; i++){
			int currentSeat = students[i];
			int nextSeat = seats[i];
			minMoves += Math.abs(currentSeat - nextSeat);
		}

		return minMoves;
	}
}