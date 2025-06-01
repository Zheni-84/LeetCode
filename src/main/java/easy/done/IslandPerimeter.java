package easy.done;

/**
 * LeetCode 463 - Island Perimeter
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
 * Space Complexity: O(1), since we are using a constant amount of space for the perimeter variable.
 * <p>
 * Given a 2D grid map of '1's (land) and '0's (water), return the perimeter of the island.
 * The grid has exactly one island (one or more connected lands) with no lakes (water inside that isn't connected to the water around the island).
 * <p>
 * https://leetcode.com/problems/island-perimeter/
 * <p>
 * Example:
 * Input:
 * 0 1 0 0
 * 1 1 1 0
 * 0 1 0 0
 * 0 0 0 0
 * Output: 16
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		// Output: Perimeter: 16
		int[][] grid = {
			{0, 1, 0, 0},
			{1, 1, 1, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		};

		System.out.println("Perimeter: " + islandPerimeter(grid));
	}
	private static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				// If the cell is land (1), add 4 to perimeter
				if (grid[r][c] == 1) {
					perimeter += 4;
					//Check up
					if (r > 0 && grid[r - 1][c] == 1)
						// If the cell above is also land, subtract 2 from perimeter
						// because the two cells share a side
						perimeter -= 2;
					// Check left
					// If the cell to the left is also land, subtract 2 from perimeter
					// because the two cells share a side
					if (c > 0 && grid[r][c - 1] == 1)
						perimeter -= 2;
				}
			}
		}
		return perimeter;
	}
}