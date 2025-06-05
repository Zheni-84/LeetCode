package easy.done;

/**
 * LeetCode Problem: 867 - Transpose Matrix
 * Topic: Array, Matrix
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 * <p>
 * Description:
 * Given a 2D integer array matrix, return the transpose of matrix.
 * The transpose of a matrix is the matrix flipped over its main diagonal,
 * switching the matrix's row and column indices.
 * Example:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Constraints:
 * 1 <= matrix.length <= 1000
 * 1 <= matrix[i].length <= 1000
 * -1000 <= matrix[i][j] <= 1000
 * <p>
 * Link: https://leetcode.com/problems/transpose-matrix/
 */
public class TransposeMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};

		int[][] transposedMatrix = transpose(matrix);

		for (int[] ints : transposedMatrix) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
		}
	}

	private static int[][] transpose(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] transposed = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Assign the value from the original matrix to the transposed matrix
				transposed[j][i] = matrix[i][j];
			}
		}

		return transposed;
	}
}