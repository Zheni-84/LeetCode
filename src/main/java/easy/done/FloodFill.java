package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 733: Flood Fill
 * Time Complexity: O(m * n), where m and n are the dimensions of the image.
 * Space Complexity: O(m * n) in the worst case due to recursion stack or queue.
 * <p>
 * Given an image represented by a 2D integer array, this class provides methods to perform a flood fill operation.
 * Starting from a given pixel, it changes the color of the starting pixel and all adjacent pixels of the same color to a new color.
 * Both DFS and BFS approaches are implemented.
 * <p>
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

	public static void main(String[] args) {
		// Example usage
		int[][] image = {
				{ 1, 1, 1 },
				{ 1, 1, 0 },
				{ 1, 0, 1 }
		};
		int sr = 1;
		int sc = 1;
		int color = 2;

		int[][] result = floodFillDFS(image, sr, sc, color);
		//int[][] result = floodFillBFS(image, sr, sc, color);

		for (int[] row : result) {
			for (int pixel : row) {
				System.out.print(pixel + " ");
			}
			System.out.println();
		}
	}

	private static int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
		int originalColor = image[sr][sc];
		if (originalColor != color) {
			dfs(image, sr, sc, originalColor, color);
		}

		return image;
	}

	private static void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
		// Check if the current pixel is out of bounds
		// If the pixel is out of bounds, return
		if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
			return;
		}
		// If the pixel is not the original color, return
		if (image[r][c] != originalColor) {
			return;
		}

		// Change the color of the pixel
		image[r][c] = newColor;

		// Recursively call dfs for all four directions
		dfs(image, r + 1, c, originalColor, newColor);
		dfs(image, r - 1, c, originalColor, newColor);
		dfs(image, r, c + 1, originalColor, newColor);
		dfs(image, r, c - 1, originalColor, newColor);
	}

	public int[][] floodFillBFS1(int[][] image, int sr, int sc, int color) {
		int original = image[sr][sc];
		if(original == color) return image;

		int m = image.length;
		int n = image[0].length;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[]{sr, sc});
		while(!que.isEmpty()){
			int[] cell = que.poll();
			int r = cell[0];
			int c = cell[1];
			if(r < 0 || r >= m || c < 0 || c >= n || image[r][c] != original) continue;

			image[r][c] = color;

			que.offer(new int[]{r - 1, c});
			que.offer(new int[]{r + 1, c});
			que.offer(new int[]{r, c - 1});
			que.offer(new int[]{r, c + 1});
		}

		return image;
	}

	private static int[][] floodFillBFS2(int[][] image, int sr, int sc, int color) {
		int originalColor = image[sr][sc];
		if (originalColor == color) {
			return image;
		}

		int rows = image.length;
		int cols = image[0].length;

		LinkedList<int[]> queue = new LinkedList<>();
		// Start BFS from the initial pixel
		queue.offer(new int[] { sr, sc });

		// Mark as visited by coloring immediately
		image[sr][sc] = color;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!queue.isEmpty()) {
			// Get the next pixel from the queue
			// and mark it as visited
			int[] pixel = queue.poll();
			int r = pixel[0];
			int c = pixel[1];

			for (int[] dir : directions) {
				int newRow = r + dir[0];
				int newCol = c + dir[1];

				// Check if the new pixel is within bounds
				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
					// Check if the new pixel is the original color
						image[newRow][newCol] == originalColor) {
					// If it is, add it to the queue and change its color
					queue.offer(new int[] { newRow, newCol });
					image[newRow][newCol] = color; //mark as visited by coloring
				}
			}
		}

		return image;
	}
}