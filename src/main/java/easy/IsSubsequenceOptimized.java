package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode Problem 392 (Optimized Implementation) - Is Subsequence
 * Topics: String, Binary Search
 * Time Complexity: O(m + n log k) - where n is the length of string t, m is the length of string s,
 * and k is the average size of the index list for a character in t.
 * Space Complexity: O(n) - for the map that stores the indices.
 * <p>
 * Description:
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * This optimized implementation preprocesses the string t to allow multiple queries for different strings s.
 * <p>
 * Link: https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequenceOptimized {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		boolean result = SubsequenceCheckerOptimized.isSubsequence(s);
		System.out.println("Is the subsequence " + s + " in " + t + "? " + result);
	}

	class SubsequenceCheckerOptimized {

		static Map<Character, List<Integer>> indexMap = new HashMap<>();

		/**
		 * Constructor that preprocesses string t by mapping each character
		 * to a list of its indices in t, allowing for efficient subsequence checking.
		 *
		 * @param t the string to preprocess
		 */
		public SubsequenceCheckerOptimized(String t) {
			// Preprocess `t` into a character → list of indices map
			for (int i = 0; i < t.length(); i++) {
				char c = t.charAt(i);
				// Add the current index to the list of indices for the character `c`.
				indexMap.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
			}
		}

		/**
		 * Checks if string s is a subsequence of the preprocessed string t.
		 *
		 * @param s the string to check for subsequence
		 * @return true if s is a subsequence of t, false otherwise
		 */
		private static boolean isSubsequence(String s) {
			int prevIndex = -1;

			for (char c : s.toCharArray()) {
				if (!indexMap.containsKey(c)) {
					return false;
				}

				List<Integer> positions = indexMap.get(c);
				int nextIndex = nextGreater(positions, prevIndex);
				if (nextIndex == -1) {
					return false;
				}

				prevIndex = nextIndex;
			}

			return true;
		}

		// Binary search to find the smallest element > prevIndex

		/**
		 * Finds the smallest index in the list that is greater than the given prevIndex.
		 *
		 * @param list      the list of indices for a character
		 * @param prevIndex the previous index to compare against
		 * @return the next greater index if found, or -1 if no such index exists
		 */
		private static int nextGreater(List<Integer> list, int prevIndex) {
			int left = 0;
			int right = list.size() - 1;
			int result = -1;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (list.get(mid) > prevIndex) {
					result = list.get(mid);
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			return result;
		}
	}
}