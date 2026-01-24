package easy.done;
/*
LeetCode #1427 – Perform String Shifts
Time Complexity: O(n)
Space Complexity: O(1)
Topics: String / Array / Prefix Sum
Hint:

You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [directioni, amounti]:
directioni can be 0 (for left shift) or 1 (for right shift).
amounti is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

Example 1:
Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:
Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 */

public class StringShift {

	public static void main(String[] args) {
		String s1 = "abcde";
		int[][] shifts1 = {{0, 1}, {1, 2}};
		System.out.println("Final String: " + stringShift(s1, shifts1)); // Output: "cdeab"

		String s2 = "abcdefg";
		int[][] shifts2 = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
		System.out.println("Final String: " + stringShift(s2, shifts2)); // Output: "efgabcd"
	}

	private static String stringShift(String s, int[][] shifts) {
		int netShift = 0;
		for (int[] shift : shifts) {
			if (shift[0] == 0) {
				netShift -= shift[1]; // Left shift
			} else {
				netShift += shift[1]; // Right shift
			}
		}

		// Normalize shift (invariant) procedural way
		netShift = netShift % s.length();
		if (netShift < 0) {
			netShift += s.length(); // Convert negative shift to positive
		}

		return s.substring(s.length() - netShift) + s.substring(0, s.length() - netShift);
	}

	public String stringShift2(String s, int[][] shift) {
		int n = s.length();
		int netShift = 0;

		// Step 1: Accumulate net shift
		for (int[] op : shift) {
			int direction = op[0];
			int amount = op[1];

			if (direction == 0) {
				netShift -= amount; // left shift
			} else {
				netShift += amount; // right shift
			}
		}

		// Step 2: Normalize shift (invariant) algebraic way
		netShift = ((netShift % n) + n) % n;

		// Step 3: Apply single rotation
		return s.substring(n - netShift) + s.substring(0, n - netShift);
	}
}