package easy;

/**
 * LeetCode Problem 14: Longest Common Prefix
 * Time Complexity: O(n * m), where n is the number of strings and m is the length of the shortest string.
 * Space Complexity: O(1), since we are using a constant amount of space for the prefix variable.
 * Topics: String, Array, Divide and Conquer, String Matching, Trie
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lowercase English letters.
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "flight"};
		//Output: "fl"
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));

		String[] strs2 = {"dog", "racecar", "car"};
		//Output: ""
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs2));
	}
	private static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}
		// Start with the first string as an initial prefix
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++){
			while(!strs[i].startsWith(prefix)){
				// Reduce the prefix by one character from the end
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty()){
					return "";
				}
			}
		}
		return prefix;
	}
}