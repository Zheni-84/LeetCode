package easy.done;

/**
 * LeetCode 1572. Matrix Diagonal Sum
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Topic: Array, Matrix, Math
 * <p>
 * Given a square matrix mat, return the sum of the matrix diagonals.
 * Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */

public class MatrixDiagonalSum {

	public static void main(String[] args) {
		int[][] mat = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		System.out.println("Diagonal Sum: " + diagonalSum(mat)); // Output: 25
	}
	private static int diagonalSum(int[][] mat) {
		int sum = 0;
		int n = mat.length;

		for(int i = 0; i<n; i++){
			// Primary diagonal: mat[i][i]
			sum += mat[i][i];
			// Secondary diagonal: mat[i][n - i - 1]
			sum += mat[i][n-i-1];

		}

		if(n%2!=0){
			sum -= mat[n/2][n/2];
		}

		return sum;
	}
}