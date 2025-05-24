package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 455 - Assign Cookies
 * Topics: Array, Sorting
 * Time Complexity: O(n log n + m log m), where n is the length of g and m is the length of s, due to sorting.
 * Space Complexity: O(1) - in-place sorting.
 * <p>
 * Description:
 * Given two integer arrays g and s representing the greed factors of children and sizes of cookies respectively,
 * return the maximum number of children you can satisfy.
 * Each child can only be satisfied if their greed factor is less than or equal to the size of the cookie.
 * Each cookie can be assigned to only one child.
 * LeetCode Link: https://leetcode.com/problems/assign-cookies/
 */
public class AssignCookies {

	public static void main(String[] args) {
		int[] g = { 1, 2, 3 };
		int[] s = { 1, 1 };

		System.out.println("Number of content children: " + findContentChildren(g, s));
	}

	/**
	 * Function to find the maximum number of children that can be content with the given cookies.
	 *
	 * @param g An array of integers representing the greed factors of the children.
	 * @param s An array of integers representing the sizes of the cookies.
	 * @return The number of children that can be satisfied by the given cookies.
	 */
	private static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0; // index for children
		int j = 0; // index for cookies

		while (i < g.length && j < s.length) {
			if (g[i] <= s[j]) {
				i++; // assign cookie and move to next child
			}
			j++; // move to next cookie regardless
		}
		return i; // number of content children
	}
}