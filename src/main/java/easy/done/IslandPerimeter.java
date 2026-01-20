package easy.done;

import java.util.LinkedList;
import java.util.Queue;

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
		int[][] grid1 = {
				{0, 1, 0, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{0, 0, 0, 0}
		};
		System.out.println("Island Perimeter (Iterative): " + islandPerimeter(grid1)); // Output: 16
		System.out.println("Island Perimeter (DFS): " + islandPerimeterDFS(grid1)); // Output: 16

		int[][] grid2 = {
				{1}
		};
		System.out.println("Island Perimeter (Iterative): " + islandPerimeter(grid2)); // Output: 4
		System.out.println("Island Perimeter (DFS): " + islandPerimeterDFS(grid2)); // Output: 4

		int[][] grid3 = {
				{1, 0}
		};
		System.out.println("Island Perimeter (Iterative): " + islandPerimeter(grid3)); // Output: 4
		System.out.println("Island Perimeter (DFS): " + islandPerimeterDFS(grid3)); // Output: 4
	}

	// Iterative approach BFS
	// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
	// Space Complexity: O(1), since we are using a constant amount of space for the perimeter variable.
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

	// Alternative BFS approach
	// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
	// Space Complexity: O(m * n) in the worst case due to the visited array and queue.
	public int islandPerimeterBFS2(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

		Queue<int[]> q = new LinkedList<>();

		// Step 1: find first land cell
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 1) {
					q.offer(new int[]{r, c});
					visited[r][c] = true;
					break;
				}
			}
			if (!q.isEmpty()) break;
		}

		int perimeter = 0;

		// Step 2: BFS traversal
		while (!q.isEmpty()) {
			int[] cell = q.poll();
			int r = cell[0], c = cell[1];

			for (int[] d : dirs) {
				int nr = r + d[0], nc = c + d[1];
				if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] == 0) {
					perimeter++; // edge touches water or border, then it contributes to perimeter
				} else if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[]{nr, nc});
				}
			}
		}

		return perimeter;
	}

	// DFS approach
	// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
	// Space Complexity: O(m * n) in the worst case due to the recursion stack and visited array.
	private static int islandPerimeterDFS(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		boolean[][] visited = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					// Start DFS from the first land cell
					return dfs(grid, visited, i, j);
				}
			}
		}
		return 0;
	}

	private static int dfs(int[][] grid, boolean[][] visited, int i, int j) {
		int rows = grid.length;
		int cols = grid[0].length;

		// Out of bounds → +1 perimeter
		if (i < 0 || j < 0 || i >= rows || j >= cols) return 1;
		// Water cell → +1 perimeter
		if (grid[i][j] == 0) return 1;
		// Already visited → no contribution
		if (visited[i][j]) return 0;

		visited[i][j] = true;

		int perimeter = 0;
		perimeter += dfs(grid, visited, i - 1, j); // up
		perimeter += dfs(grid, visited, i + 1, j); // down
		perimeter += dfs(grid, visited, i, j - 1); // left
		perimeter += dfs(grid, visited, i, j + 1); // right

		return perimeter;
	}

	public int islandPerimeterBFS(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int[] start = findLand(grid);
		return dfs(grid, start[0], start[1], visited);
	}

	private int[] findLand(int[][] grid){
		int rows = grid.length;
		int cols = grid[0].length;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if (grid[i][j] == 1) return new int[]{i, j};
			}
		}

		return null;
	}

	private int dfs(int[][] grid, int r, int c, boolean[][] visited){
		int rows = grid.length;
		int cols = grid[0].length;

		if(r < 0 || c < 0 || r >= rows || c >= cols) return 1;
		if(grid[r][c] == 0) return 1;
		if(visited[r][c]) return 0;

		visited[r][c] = true;

		return dfs(grid, r-1, c, visited) +
				dfs(grid, r+1, c, visited) +
				dfs(grid, r, c-1, visited) +
				dfs(grid, r, c+1, visited);
	}
}