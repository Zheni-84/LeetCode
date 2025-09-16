package easy.done;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 506 - Relative Ranks
 * Topics: Array, Sorting, Heap (Priority Queue)
 * Time Complexity: O(n log n) due to sorting the indices based on scores.
 * Space Complexity: O(n) for storing the indices and the result array.
 * <p>
 * Description:
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete.
 * All the scores are guaranteed to be unique. The athletes are placed based on their scores,
 * where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score,
 * and so on. The placement of each athlete determines their rank.
 * Hint: Use sorting to determine the ranks of the athletes based on their scores.
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

	// Alternative approach using sorting and binary search
	// This method sorts a copy of the scores and uses binary search to determine ranks
	// Time Complexity: O(n log n) due to sorting and binary search for each score
	// Space Complexity: O(n) for the sorted copy of scores and the result array
	private static String[] findRelativeRanks2(int[] score) {
		int n = score.length;
		String[] result = new String[n];
		int[] sortedScores = score.clone();
		Arrays.sort(sortedScores);
		for (int i = 0; i < n; i++) {
			int rank = n - Arrays.binarySearch(sortedScores, score[i]);
			switch (rank) {
				case 1:
					result[i] = "Gold Medal";
					break;
				case 2:
					result[i] = "Silver Medal";
					break;
				case 3:
					result[i] = "Bronze Medal";
					break;
				default:
					result[i] = String.valueOf(rank);
					break;
			}
		}
		return result;
	}

	// Another approach using a max-heap (priority queue) with custom comparator for { value, index }
	// This method uses a priority queue to determine ranks in O(n log n) time
	// Space Complexity: O(n) for the priority queue and the result array
	private static String[] findRelativeRanks3(int[] score) {
		int n = score.length;
		String[] result = new String[n];
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
		for (int i = 0; i < n; i++) {
			maxHeap.offer(new int[] { score[i], i });
		}
		for (int rank = 1; rank <= n; rank++) {
			int[] top = maxHeap.poll();
			int index = top[1];
			switch (rank) {
				case 1:
					result[index] = "Gold Medal";
					break;
				case 2:
					result[index] = "Silver Medal";
					break;
				case 3:
					result[index] = "Bronze Medal";
					break;
				default:
					result[index] = String.valueOf(rank);
					break;
			}
		}
		return result;
	}

	private static String[] findRelativeRanksBucketSort(int[] score) {
		int n = score.length;
		String[] result = new String[n];

		int maxScore = 0;
		for (int s : score) {
			maxScore = Math.max(maxScore, s);
		}

		int[] pos = new int[maxScore + 1];
		Arrays.fill(pos, -1);

		// pos[score] = index of athlete with that score
		// Since scores are unique, no need to handle duplicates
		// This allows us to directly access the athlete index by their score
		// This is a form of bucket sort where the score itself is the index
		// Time Complexity: O(n + m) where n is number of athletes and m is the range of scores
		// Space Complexity: O(m) for the pos array
		// This is efficient when the range of scores (m) is not significantly larger than n
		// If m is much larger than n, this approach may not be optimal in terms of space
		// However, it provides a straightforward way to assign ranks in a single pass
		// after populating the pos array
		// This method is particularly useful when scores are within a manageable range
		// and we want to avoid the overhead of sorting or using a priority queue
		// Example: If scores are in the range 0 to 1000 and we have 100 athletes,
		// this approach is efficient and easy to implement

		for (int i = 0; i < n; i++) {
			pos[score[i]] = i; // store athlete index
		}

		int rank = 1;
		for (int s = maxScore; s >= 0; s--) {
			if (pos[s] != -1) {
				// athlete with score s exists
				int idx = pos[s];
				if (rank == 1) result[idx] = "Gold Medal";
				else if (rank == 2) result[idx] = "Silver Medal";
				else if (rank == 3) result[idx] = "Bronze Medal";
				else result[idx] = String.valueOf(rank);
				rank++;
			}
		}

		return result;
	}
}