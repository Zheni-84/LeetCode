package easy.done;

/**
 * LeetCode Problem 997: Find the Town Judge
 * Topics: Array, Graphs
 * Time complexity: O(t + n) - where t is the number of trust relationships and n is the number of people in the town.
 * Space complexity: O(n) - for the trust score array.
 *
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * Given an array trust where trust[i] = [a, b] represents that the person labeled a trusts the person labeled b,
 * return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Constraints:
 * - 1 <= n <= 1000
 * - 0 <= trust.length <= 104
 * - trust[i].length == 2
 * - All the pairs of trust are unique.
 * - ai != bi
 * - 1 <= ai, bi <= n
 *
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class FindTheTownJudge {	public static void main(String[] args) {
		int n = 3;
		int[][] trust = {{1, 3}, {2, 3}};
		System.out.println("Town Judge: " + findJudge(n, trust)); // Output: 3

		n = 3;
		trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
		System.out.println("Town Judge: " + findJudge(n, trust)); // Output: -1

		n = 4;
		trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
		System.out.println("Town Judge: " + findJudge(n, trust)); // Output: 3
	}

	private static int findJudge(int n, int[][] trust) {
		int[] trustScores = new int[n + 1];

		for (int[] t : trust) {
			trustScores[t[0]]--; // Person t[0] trusts someone
			trustScores[t[1]]++; // Person t[1] is trusted by someone
		}

		for (int i = 1; i <= n; i++) {
			if (trustScores[i] == n - 1) {
				return i; // Found the town judge
			}
		}

		return -1; // No town judge found
	}

}