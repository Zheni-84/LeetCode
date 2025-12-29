package easy.done;

/**
 * LeetCode 70. Climbing Stairs
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Topics: Dynamic Programming, Recursion
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Examples:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * 1 <= n <= 45
 *
 * Solutions:
 * 1. Dynamic Programming (O(n) time, O(n) space)
 * 2. Brute Force Recursion (Exponential time)
 * 3. Optimized Iterative (O(n) time, O(1) space)
 *
 * Hint:
 * 1. Think about the base cases for n = 1 and n = 2.
 * 2. For n > 2, the number of ways to reach the nth step is the sum of the ways to reach the (n-1)th and (n-2)th steps.
 * 3. Use an array to store the number of ways to reach each step up to n.
 * 4. Consider using two variables to keep track of the last two computed values to optimize space.
 *
 *  https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
	public static void main(String[] args) {
		int n = 5; // Example input
		System.out.println("Number of ways to climb " + n + " stairs (DP): " + climbStairsDP(n));
		System.out.println("Number of ways to climb " + n + " stairs (Brute Force): " + climbStairsBrute(n));
		System.out.println("Number of ways to climb " + n + " stairs (Optimal): " + climbStairsOptimal(n));
	}

	// Dynamic programming version with O(n) time and O(n) space complexity
	private static int climbStairsDP(int n) {
		if (n <= 2) return n;

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	// Brute force recursive version with exponential time complexity
	private static int climbStairsBrute(int n) {
		if (n == 0 || n == 1) return 1;
		return climbStairsBrute(n - 1) + climbStairsBrute(n - 2);
	}

	// Optimized version with O(n) time and O(1) space complexity
	private static int climbStairsOptimal(int n) {
		if (n <= 2) {
			return n;
		}
		int first = 1;
		int second = 2;
		for (int i = 3; i <= n; i++) {
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}
}