package easy.done;

/**
 * LeetCode Problem: 883. Projection Area of 3D Shapes
 * Topic: Array, Matrix
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * <p>
 * Description:
 * You are given an n x n grid where grid[i][j] represents the number of cubes stacked at position (i, j).
 * Return the total projection area of the shape on the xy, yz, and zx planes.
 * Example:
 * Input: grid = [[1,2],[3,4]]
 * Output: 17
 * Constraints:
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 * <p>
 * Link: https://leetcode.com/problems/projection-area-of-3d-shapes/
 */
public class ProjectionArea3DShapes {

	public static void main(String[] args) {
		int[][] grid = {
			{1, 2},
			{3, 4}
		};

		System.out.println("Projection Area: " + projectionArea(grid)); // Output: 17
	}
	private static int projectionArea(int[][] grid) {
		int xy = 0;
		int yz = 0;
		int zx = 0;
		int rows = grid.length;

		for(int i=0; i<rows;i++){
			int maxRow = 0;
			int maxCol = 0;
			for(int j = 0; j<rows; j++){
				//fix the row, move through columns
				int val = grid[i][j];
				// Count the projection on the xy plane
				if(val > 0){
					xy++;
				}
				// Count the projection on the yz plane
				maxRow = Math.max(maxRow, val);
				// Count the projection on the zx plane
				// fix the column, move through rows
				maxCol = Math.max(maxCol,  grid[j][i]);
			}
			yz += maxRow;
			zx += maxCol;
		}

		return xy + yz + zx;
	}
}
