package easy.done;

/**
 * LeetCode 766: Toeplitz Matrix
 * Topic: Array, Matrix
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
 * Space Complexity: O(1), since we are using a constant amount of space for variables.
 * Space Complexity for Disk Stored: O(n), where n is the number of columns in the matrix, as we only store one row at a time.
 * Space Complexity for Partial Row: O(1), as we are not storing any additional data structures.
 *
 * A Toeplitz matrix is a matrix in which every diagonal from top-left to bottom-right has the same element.
 * This class provides methods to check if a given matrix is a Toeplitz matrix using different approaches.
 *
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class ToeplitzMatrix {

	public static void main(String[] args) {
		// Example usage
		int[][] matrixTrue = {
			{1, 2, 3, 4},
			{5, 1, 2, 3},
			{9, 5, 1, 2}
		};

		int[][] matrixFalse = {
			{1, 2},
			{2, 2}
		};

		System.out.println("Matrix 1 is Toeplitz: " + isToeplitzMatrix(matrixTrue)); // true
		System.out.println("Matrix 2 is Toeplitz: " + isToeplitzMatrix(matrixFalse)); // false

		System.out.println("Matrix 1 is Toeplitz (Disk Stored): " + isToeplitzMatrixDiskStored(matrixTrue)); // true
		System.out.println("Matrix 2 is Toeplitz (Disk Stored): " + isToeplitzMatrixDiskStored(matrixFalse)); // false

		System.out.println("Matrix 1 is Toeplitz (Partial Row): " + isToeplitzMatrixPartialRow(matrixTrue)); // true
		System.out.println("Matrix 2 is Toeplitz (Partial Row): " + isToeplitzMatrixPartialRow(matrixFalse)); // false
	}
	private static boolean isToeplitzMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i<rows-1; i++){
			for(int j = 0; j<cols-1;j++){
				if(matrix[i][j]!=matrix[i+1][j+1]){
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isToeplitzMatrixDiskStored(int[][] matrix) {
		//Load only one row in memory;
		int[] prevRow = matrix[0];
		int rows = matrix.length;
		for(int i = 1; i<rows; i++){
			//Load the next row for comparison
			int[] currRow = matrix[i];
			for(int j = 1; j<currRow.length;j++){
				if(currRow[j] != prevRow[j-1]){
					return false;
				}
			}
			// Simulates loading next row from disk
			prevRow = currRow;
		}

		return true;
	}

	private static boolean isToeplitzMatrixPartialRow(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		// Check diagonals starting from first row
		for(int col=0; col<cols; col++){
			int value = matrix[0][col];
			int i = 1;
			int j = col+1;
			// Check diagonal elements starting from (0, col)
			while(i<rows && j<cols){
				if(matrix[i][j]!=value){
					return false;
				}
				i++;
				j++;
			}
		}

		// Check diagonals starting from first column (excluding matrix[0][0] diagonal again)
		for(int row=1; row<rows;row++){
			int value = matrix[row][0];
			int i = row+1;
			int j = 1;
			// Check diagonal elements starting from (row, 0)
			while(i<rows && j<cols){
				if(matrix[i][j]!=value){
					return false;
				}
				i++;
				j++;
			}
		}

		return true;
	}
}