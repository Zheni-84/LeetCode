package easy.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//add docs
/**
 * LeetCode Problem 1380 - Lucky Numbers in a Matrix
 * Topics: Array, Matrix
 * A lucky number in a matrix is an element of the matrix such that it is the minimum element in its row and the maximum element in its column.
 * Given an n x m matrix of distinct numbers, return all the lucky numbers in the matrix.
 * Time complexity: O(n*m)
 * Space complexity: O(n)
 * <p>
 * Example:
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and maximum in its column.
 * LeetCode Link: https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 */
public class

LuckyNumbersInMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 3, 7, 8 },
				{ 9, 11, 13 },
				{ 15, 16, 17 }
		};

		List<Integer> luckyNumbers = luckyNumbers(matrix);
		System.out.println(luckyNumbers); // Output: [15]
	}

	private static List<Integer> luckyNumbers(int[][] matrix) {
		int n = matrix[0].length;

		// Step 1: Find row minimum and store them (value, colIndex)
		List<int[]> rowMins = new ArrayList<>();
		for (int[] ints : matrix) {
			int minVal = ints[0];
			int minCol = 0;
			for (int j = 1; j < n; j++) {
				if (ints[j] < minVal) {
					minVal = ints[j];
					minCol = j;
				}
			}
			rowMins.add(new int[] { minVal, minCol });
		}

		//Step 2 : Find column maximums
		int[] colMaxes = new int[n];
		Arrays.fill(colMaxes, Integer.MIN_VALUE);
		for (int j = 0; j < n; j++) {
			for (int[] ints : matrix) {
				colMaxes[j] = Math.max(colMaxes[j], ints[j]);
			}
		}

		// Step 3 : Check forLucky Numbers
		List<Integer> result = new ArrayList<>();
		for (int[] rowMin : rowMins) {
			int value = rowMin[0];
			int col = rowMin[1];
			if (value == colMaxes[col]) {
				result.add(value);
			}
		}

		return result;
	}
}