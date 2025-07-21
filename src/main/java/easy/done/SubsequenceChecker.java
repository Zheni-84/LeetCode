package easy.done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode Problem 392 - Is Subsequence
 * Topics: String, Binary Search
 * Time Complexity: O(m + n log k) - where n is the length of string t, m is the length of string s,
 * and k is the average size of the index list for a character in t.
 * Space Complexity: O(n) - for the map that stores the indices.
 *
 * Description:
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * This implementation preprocesses the string t to allow multiple queries for different strings s.
 *
 * Link: https://leetcode.com/problems/is-subsequence/
 */
public class SubsequenceChecker {

	private Map<Character, List<Integer>> charToIndices;

	public static void main(String[] args) {
		SubsequenceChecker checker = new SubsequenceChecker("abdcade");
		System.out.println(checker.isSubsequence("ace")); // true
		System.out.println(checker.isSubsequence("aec")); // false
		System.out.println(checker.isSubsequence("abcde")); // true
		System.out.println(checker.isSubsequence("xyz")); // false
	}

	public SubsequenceChecker(String t) {
		charToIndices = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			charToIndices.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
		}
	}

	public boolean isSubsequence(String s) {
		int prevIndex = -1;
		for (char c : s.toCharArray()) {
			if (!charToIndices.containsKey(c))
				return false;

			List<Integer> indices = charToIndices.get(c);
			int nextPos = findNextIndex(indices, prevIndex);
			if (nextPos == -1)
				return false;
			prevIndex = nextPos;
		}
		return true;
	}

	// Binary search: find the first index > prevIndex
	private int findNextIndex(List<Integer> indices, int prevIndex) {
		int left = 0, right = indices.size();
		while (left < right) {
			int mid = (left + right) / 2;
			if (indices.get(mid) > prevIndex) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left < indices.size() ? indices.get(left) : -1;
	}
}
