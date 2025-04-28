package easy;
/**
 * 661. Image Smoother
 *
 * Problem Link: https://leetcode.com/problems/image-smoother/
 *
 * Problem:
 * Given a 2D integer matrix 'img' representing a grayscale image,
 * apply a smoothing filter over each cell.
 *
 * The smoothing filter works as follows:
 * - For each cell, consider itself and its 8 surrounding neighbors.
 * - Calculate the average of all valid neighboring cells (including itself).
 * - If a neighbor is out of bounds (edge/corner cases), ignore it.
 * - Set the new value of the cell as the floor of the average (integer division in Java automatically floors).
 *
 *
 * Approach:
 * - Iterate over each cell (i, j) of the matrix.
 * - For each cell, check all possible neighbors by moving in directions {-1, 0, 1} for both rows and columns.
 * - For each valid neighbor (inside the matrix boundaries), sum their values and count them.
 * - After collecting all valid neighbors, compute (sum / count) and assign it to the result matrix.
 *
 *
 * Complexity Analysis:
 * - Time Complexity: O(m * n), where m = number of rows, n = number of columns.
 *   For each cell, we check at most 9 neighbors (constant).
 * - Space Complexity: O(m * n), for storing the output matrix.
 */
public class ImageSmoother {

	public static void main(String[] args) {
		// Example usage
		int[][] img = {
				{ 100, 200, 100 },
				{ 200, 50, 200 },
				{ 100, 200, 100 }
		};

		int[][] smoothedImg = imageSmoother(img);

		for (int[] row : smoothedImg) {
			for (int pixel : row) {
				System.out.print(pixel + " ");
			}
			System.out.println();
		}
	}
	private static int[][] imageSmoother(int[][] img) {
		int rows = img.length;
		int cols = img[0].length;
		int[][] result = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = calculateAverage(img, i, j);
			}
		}

		return result;
	}

	private static int calculateAverage(int[][] img, int row, int col) {
		int sum = 0;
		int count = 0;

		// Check all 8 neighbors and itself
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				// Check if the neighbor is within bounds
				if (i >= 0 && i < img.length && j >= 0 && j < img[0].length) {
					// Add the value of the neighbor to the sum
					sum += img[i][j];
					// Increment the count of valid neighbors
					count++;
				}
			}
		}

		return sum / count;
	}
}