package easy.done;

import java.util.Arrays;


/**
 * LeetCode Problem 506 - Relative Ranks
 * Topics: Array, Sorting, Heap (Priority Queue)
 * <p>
 * Description:
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete.
 * All the scores are guaranteed to be unique. The athletes are placed based on their scores,
 * where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score,
 * and so on. The placement of each athlete determines their rank.
 * <p>
 * Link: https://leetcode.com/problems/relative-ranks/
 */
public class RelativeRanks {

	public static void main(String[] args) {
		// Example input: [5, 4, 3, 2, 1]
		// Expected output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
		// Explanation: The athlete with the highest score (5) gets "Gold Medal",
		// the second highest (4) gets "Silver Medal", the third highest (3) gets "Bronze Medal",
		// and the rest get their respective ranks as strings.
		// The ranks are assigned in descending order of scores.
		// The athlete with the highest score (5) gets "Gold Medal",
		// the second highest (4) gets "Silver Medal", the third highest (3) gets "Bronze Medal",
		// and the rest get their respective ranks as strings.
		// The ranks are assigned in descending order of scores.

		int[] score = { 5, 4, 3, 2, 1 };
		String[] result = findRelativeRanks(score);
		// Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
		System.out.println(Arrays.toString(result));
	}

	/**
	 * This method takes an array of scores and returns an array of strings representing the ranks.
	 * The top three scores are assigned "Gold Medal", "Silver Medal", and "Bronze Medal" respectively,
	 * while the rest are assigned their respective ranks as strings.
	 *
	 * @param score an array of integers representing scores
	 * @return an array of strings representing ranks
	 */
	private static String[] findRelativeRanks(int[] score) {
		int scoreLen = score.length;

		// Create array of indices [0, 1, 2, ..., scoreLen - 1]
		Integer[] indicesArray = new Integer[scoreLen];
		for (int i = 0; i < scoreLen; i++) {
			indicesArray[i] = i;
		}

		// Sort indices by corresponding score values in descending order
		Arrays.sort(indicesArray, (i, j) -> Integer.compare(score[j], score[i]));

		// Prepare result array
		String[] result = new String[scoreLen];

		// Assign ranks based on sorted indices
		for (int rank = 0; rank < scoreLen; rank++) {
			// Get the original index of the athlete
			int i = indicesArray[rank];
			// Assign rank based on the position in the sorted array
			switch (rank) {
				case 0:
					result[i] = "Gold Medal";
					break;
				case 1:
					result[i] = "Silver Medal";
					break;
				case 2:
					result[i] = "Bronze Medal";
					break;
				default:
					result[i] = String.valueOf(rank + 1);
					break;
			}
		}

		return result;
	}
}
