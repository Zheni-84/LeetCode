package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 131. Palindrome Partitioning
 * Time Complexity: O(N * 2^N) where N is the length of the string
 * Space Complexity: O(N) for the recursion stack and path storage
 * Topics: Backtracking, Recursion
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Examples:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 * Solutions:
 * 1. Backtracking (O(N * 2^N) time, O(N) space)
 *
 * Hint:
 * 1. Use backtracking to explore all possible partitions of the string.
 * 2. Check if each substring is a palindrome before adding it to the current partition.
 * 3. When the end of the string is reached, add the current partition to the result list.
 *
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> partitions = partition(s);
		System.out.println("All possible palindrome partitions of \"" + s + "\":");
		for (List<String> partition : partitions) {
			System.out.println(partition);
		}
	}

	private static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		backtrack(0, s, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int start, String s, List<String> path, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<>(path));
			return;
		}

		for (int end = start; end < s.length(); end++) {
			if (isPalindrome(s, start, end)) {
				path.add(s.substring(start, end + 1));
				backtrack(end + 1, s, path, result);
				path.remove(path.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--)) return false;
		}
		return true;
	}
}