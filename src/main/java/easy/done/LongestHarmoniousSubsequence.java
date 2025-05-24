package easy.done;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * LeetCode Problem 594 - Longest Harmonious Subsequence
 * Topics: Array, Hash Table
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * A harmonious subsequence is defined as one where the difference between its maximum value and its minimum value is exactly 1.
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * Example:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3] with length 5.
 * LeetCode Link: https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class LongestHarmoniousSubsequence {
	private static final Logger logger = Logger.getLogger("LongestHarmoniousSubsequence");

	public static void main(String[] args) {
		int[] nums = {1,3,2,2,5,2,3,7};
		logger.info(String.valueOf(findLHS(nums))); // Output: 5
	}
	private static int findLHS(int[] nums) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		// Count frequency of each number
		for(int num : nums){
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		int maxLen = 0;
		// Check for each key if key + 1 exists
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
			int key = entry.getKey();
			int value = entry.getValue();
			// Check if key + 1 exists in the map
			if(freqMap.containsKey(key+1)){
				int currLen = value + freqMap.get(key+1);
				maxLen = Math.max(maxLen, currLen);
			}
		}

		return maxLen;
	}
}