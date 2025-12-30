package medium;

/**
 * LeetCode 79. Word Search
 * Time Complexity: O(N*M * 3^L) where N is the number of cells in the board and L is the length of the word
 * Space Complexity: O(L) for the recursion stack
 * Topics: Backtracking, Depth-First Search
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Examples:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 * Solutions:
 * 1. Backtracking with in-place modification (O(N*M * 3^L) time, O(L) space)
 * 2. Backtracking with visited matrix (O(N*M * 3^L) time, O(N*M) space)
 *
 * Hint:
 * 1. Use Depth-First Search (DFS) to explore all possible paths in the grid.
 * 2. Mark cells as visited to avoid revisiting them in the same path.
 * 3. Backtrack by unmarking cells after exploring all paths from that cell.
 *
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		String word1 = "ABCCED"; // true
		String word2 = "SEE";    // true
		String word3 = "ABCB";   // false

		System.out.println("Exist (Method 1) - Word: " + word1 + " -> " + exist(board, word1));
		System.out.println("Exist (Method 1) - Word: " + word2 + " -> " + exist(board, word2));
		System.out.println("Exist (Method 1) - Word: " + word3 + " -> " + exist(board, word3));

		System.out.println("Exist (Method 2) - Word: " + word1 + " -> " + exist2(board, word1));
		System.out.println("Exist (Method 2) - Word: " + word2 + " -> " + exist2(board, word2));
		System.out.println("Exist (Method 2) - Word: " + word3 + " -> " + exist2(board, word3));
	}

	// Time Complexity: O(N*M * 3^L) where N is the number of cells in the board and L is the length of the word
	// Space Complexity: O(L = word length) for the recursion stack
	private static boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (dfs(board, word, r, c, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(char[][] board, String word, int r, int c, int index) {
		if (index == word.length()) {
			return true;
		}
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
			return false;
		}

		char temp = board[r][c];
		board[r][c] = '#'; // Mark as visited

		boolean found = dfs(board, word, r + 1, c, index + 1) ||
						dfs(board, word, r - 1, c, index + 1) ||
						dfs(board, word, r, c + 1, index + 1) ||
						dfs(board, word, r, c - 1, index + 1);

		board[r][c] = temp; // Restore original value
		return found;
	}

	/// ///////////////////////////////////////////////////////////
	// Alternative implementation using a visited matrix
	// Time Complexity: O(N * 3^L) where N is the number of cells in the board and L is the length of the word
	// Space Complexity: O(N) for the visited[][]
	private static boolean exist2(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (dfs2(board, word, 0, r, c, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs2(char[][] board, String word, int idx, int r, int c, boolean[][] visited) {
		if (idx == word.length()) return true;
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
		if (visited[r][c] || board[r][c] != word.charAt(idx)) return false;

		visited[r][c] = true;

		// explore 4 directions
		boolean found =
						dfs2(board, word, idx + 1, r + 1, c, visited) ||
						dfs2(board, word, idx + 1, r - 1, c, visited) ||
						dfs2(board, word, idx + 1, r, c + 1, visited) ||
						dfs2(board, word, idx + 1, r, c - 1, visited);

		visited[r][c] = false; // backtrack
		return found;
	}
}