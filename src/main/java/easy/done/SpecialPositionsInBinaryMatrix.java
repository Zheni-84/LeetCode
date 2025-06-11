package easy.done;

/**
 * LeetCode 1582 - Special Positions in a Binary Matrix
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 * Topic: Array, Matrix
 * <p>
 * Given a binary matrix mat, return the number of special positions in it.
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0.
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 */
public class SpecialPositionsInBinaryMatrix {

	public static void main(String[] args) {
		int[][] mat = {
				{ 1, 0, 0 },
				{ 0, 0, 1 },
				{ 1, 0, 0 }
		};
		System.out.println("Special Positions Count: " + numSpecial(mat)); // Output: 1
	}

	private static int numSpecial(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int[] rowCount = new int[m];
		int[] colCount = new int[n];

		// First pass: count 1s in ech row and column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}
		//Second pass: count special positions
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
					count++;
				}
			}
		}

		return count;
	}
}