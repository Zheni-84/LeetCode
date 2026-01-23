package medium;

import java.util.*;
/*
 * Leetcode problem - 93. Word Break
 * Time Complexity: O(n^2 * k) where n is the length of the input string and k is the number of words in the dictionary.
 * Space Complexity: O(n) Queue + visited array
 * Topics: Dynamic Programming, Breadth-First Search
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Leetcode link: https://leetcode.com/problems/word-break/
 */
public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		System.out.println("Word Break DP: " + wordBreakDP(s, wordDict)); // Output: true
		System.out.println("Word Break BFS: " + wordBreakBFS(s, wordDict)); // Output: true

		s = "applepenapple";
		wordDict = Arrays.asList("apple", "pen");
		System.out.println("Word Break DP: " + wordBreakDP(s, wordDict)); // Output: true
		System.out.println("Word Break BFS: " + wordBreakBFS(s, wordDict)); // Output: true

		s = "catsandog";
		wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println("Word Break DP: " + wordBreakDP(s, wordDict)); // Output: false
		System.out.println("Word Break BFS: " + wordBreakBFS(s, wordDict)); // Output: false
	}

	private static boolean wordBreakDP(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		//dp[i] = true if s[0..i-1] is a valid word
		dp[0] = true;
		for(int i = 0; i < s.length()+1; i++){
			for(int j = 0; j < i; j++){
				//Check if s[0..j-1] is a valid word and s[j..i-1] is in the dictionary
				if(dp[j] && dict.contains(s.substring(j, i))){
					//If so, s[0..i-1] is a valid word
					dp[i] = true;
					break;
				}
			}
		}

		//If the whole string is a valid word
		return dp[s.length()];
	}

	//BFS solution: This is DP over prefixes, implemented as BFS on indices
	// Time Complexity: O(n^2 * k) where n is the length of the input string and k is the number of words in the dictionary.
	// Space Complexity: O(n) Queue + visited array
	// Each index is visited once → O(n), for each index, scan up to n substrings
	// Substring check costs O(k) (max word length)
	private static boolean wordBreakBFS(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[s.length() + 1];

		// 0 is the start index, and it is valid; the empty prefix is always valid
		q.offer(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			//Let’s extend a prefix that we already know is valid
			int l = q.poll();

			//Try to extend the prefix [0, l) by checking all possible end indices r
			//try all possible next words starting at l
			for (int r = l + 1; r <= s.length(); r++) {
				//If the next chunk is a dictionary word, and we haven’t processed this index yet
				if (!visited[r] && dict.contains(s.substring(l, r))) {
					//Reaching s.length() means full segmentation exists
					if (r == s.length())
						return true;
					//enqueue and visit ONLY valid states
					q.offer(r);
					visited[r] = true;
				}
			}
		}

		return false;
	}
}