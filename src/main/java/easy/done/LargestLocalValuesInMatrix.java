package easy.done;

/**
 * LeetCode 2373 - Largest Local Values in a Matrix
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * Topic: Array, Matrix
 * <p>
 * Given a 5x5 grid, this program finds the largest local values in each 3x3 sub-grid.
 * https://leetcode.com/problems/largest-local-values-in-a-matrix/
 */
public class LargestLocalValuesInMatrix {

	public static void main(String[] args) {
		int[][] grid = {
				{ 1, 2, 3, 4, 5 },
				{ 5, 6, 7, 8, 9 },
				{ 9, 10, 11, 12, 13 },
				{ 13, 14, 15, 16, 17 },
				{ 17, 18, 19, 20, 21 }
		};

		int[][] result = largestLocalBrute(grid);
		for (int[] row : result) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	/**
	 * This method finds the largest local values in a 5x5 grid.
	 * It iterates through each 3x3 sub-grid and finds the maximum value.
	 * Time Complexity: O(n^2) where n is the size of the grid.
	 * Space Complexity: O(n^2) for the result grid.
	 *
	 * @param grid the input 5x5 grid
	 * @return a 3x3 grid containing the largest local values
	 */
	private static int[][] largestLocalBrute(int[][] grid) {
		int n = grid.length;
		int[][] result = new int[n - 2][n - 2];
		// Iterate through each 3x3 sub-grid
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				int max = Integer.MIN_VALUE;
				// Find the maximum value in the current 3x3 sub-grid
				for (int r = i; r <= i + 2; r++) {
					for (int c = j; c <= j + 2; c++) {
						max = Math.max(max, grid[r][c]);
					}
				}
				// Store the maximum value in the result grid
				result[i][j] = max;
			}
		}

		return result;
	}
}