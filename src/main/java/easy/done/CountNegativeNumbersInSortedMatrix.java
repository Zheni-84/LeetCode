package easy.done;

/* LeetCode Problem 1351: Count Negative Numbers in a Sorted Matrix
   Time Complexity: O(m log n), where m is the number of rows and n is the number of columns.
   Space Complexity: O(1)
   Topic: Array, Binary Search
   This class provides a method to count the number of negative numbers in a sorted matrix.
   The main method demonstrates the usage of the countNegatives method.

   Hint: Use binary search on each row to find the first negative number.
   https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
*/
public class CountNegativeNumbersInSortedMatrix {

	public static void main(String[] args) {
		int[][] grid1 = {
				{ 4, 3, 2, -1 },
				{ 3, 2, 1, -1 },
				{ 1, 1, -1, -2 },
				{ -1, -1, -2, -3 }
		};
		System.out.println("Number of negative numbers: " + countNegativesBS(grid1)); // Output: 8

		int[][] grid2 = {
				{ 3, 2 },
				{ 1, 0 }
		};
		System.out.println("Number of negative numbers: " + countNegativesBS(grid2)); // Output: 0

		int[][] grid3 = {
				{ 5, 1, 0 },
				{ -5, -5, -5 }
		};
		System.out.println("Number of negative numbers: " + countNegativesBS(grid3)); // Output: 3
	}

	// Staircase Search approach
	// Time Complexity: O(m + n), where m is the number of rows and n is the number of columns.
	// Space Complexity: O(1)
	private static int countNegatives(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int row = 0, col = n - 1;
		int count = 0;

		while (row < m && col >= 0) {
			if (grid[row][col] < 0) {
				// All elements below in this column are negative
				count += (m - row);
				col--; // Move left
			} else {
				row++; // Move down
			}
		}

		return count;
	}

	// Binary Search approach
	// Time Complexity: O(m log n), where m is the number of rows and n is the number of columns.
	// Space Complexity: O(1)
	private static int countNegativesBS(int[][] grid) {
		int count = 0;
		for (int[] ints : grid) {
			int rowCount = binarySearch(ints);
			count += rowCount;
		}

		return count;
	}

	private static int binarySearch(int[] row) {
		int l = 0;
		int r = row.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (row[mid] < 0)
				r = mid - 1;
			else
				l = mid + 1;
		}

		return row.length - l;
	}
}