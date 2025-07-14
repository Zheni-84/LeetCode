package easy;

/**
 * LeetCode Problem 168: Excel Sheet Column Title
 * Time Complexity: O(log n), where n is the column number.
 * Space Complexity: O(1), since we are using a StringBuilder to build the result.
 * Topics: String, Math
 *
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * For example:
 * 1 -> "A"
 * 2 -> "B"
 * ...
 * 26 -> "Z"
 * 27 -> "AA"
 * 28 -> "AB"
 *
 * Constraints:
 * - 1 <= columnNumber <= 2^31 - 1
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		int columnNumber = 28; // Example input
		String columnTitle = convertToTitle(columnNumber);
		System.out.println("Column Title for " + columnNumber + ": " + columnTitle); // Output: AB
	}

	static private String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();

		while (columnNumber > 0) {
			// Adjust columnNumber to be 0-indexed
			columnNumber--;
			// Get the character for the current position
			int remainder = columnNumber % 26;
			char currentChar = (char) ('A' + remainder);
			// Append the character to the result
			sb.append(currentChar);
			// Move to the next position
			columnNumber /= 26;
		}

		return sb.reverse().toString();
	}
}