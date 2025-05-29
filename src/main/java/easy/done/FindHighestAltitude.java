package easy.done;

/**
 * LeetCode 1732: Find the Highest Altitude
 * Topics: Array, Prefix Sum
 * <p>
 * Time Complexity: O(n), where n is the length of the gain array.
 * Space Complexity: O(1)
 * <p>
 * This class provides a method to find the highest altitude after performing a series of gains and losses.
 * The altitude starts at 0, and each element in the gain array represents the change in altitude at each step.
 * https://leetcode.com/problems/find-the-highest-altitude/
 */

public class FindHighestAltitude {

	public static void main(String[] args) {

		int[] gain = {-5, 1, 5, 0, -7};
		int result = largestAltitude(gain);
		System.out.println("The highest altitude is: " + result); // Expected output: 1
	}
	private static int largestAltitude(int[] gain) {
		int maxAlt = 0;
		int currAlt = 0;

		for (int j : gain) {
			currAlt += j;
			maxAlt = Math.max(maxAlt, currAlt);
		}

		return maxAlt;
	}
}