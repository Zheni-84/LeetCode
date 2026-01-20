package medium;

/**
 * LeetCode 274. H-Index Citations II
 * Time Complexity: O(N) where N is the number of citations
 * Space Complexity: O(N) for the buckets array
 * Topics: Array, Counting Sort
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
 * return compute the researcher's h-index.
 *
 * The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each
 * been cited at least h times.
 *
 * Examples:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 *
 * Input: citations = [1,3,1]
 * Output: 1
 *
 * Constraints:
 * n == citations.length
 * 1 <= n <= 10^5
 * 0 <= citations[i] <= 1000
 *
 * Solutions:
 * 1. Counting Sort (O(N) time, O(N) space)
 *
 * Hint:
 * 1. Use a bucket array to count the number of papers with a certain number of citations.
 * 2. Iterate from the highest possible h-index down to find the maximum h-index.
 *
 * https://leetcode.com/problems/h-index-ii/
 */
public class HIndexCitations {


	public int hIndex(int[] citations) {
		int n = citations.length;
		int[] buckets = new int[n + 1];

		for (int citation : citations) {
			if (citation >= n) {
				buckets[n]++;
			} else {
				buckets[citation]++;
			}
		}

		int count = 0;
		for (int i = n; i >= 0; i--) {
			count += buckets[i];
			if (count >= i) {
				return i;
			}
		}

		return 0;
	}

}
