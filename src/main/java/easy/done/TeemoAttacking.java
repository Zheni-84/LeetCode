package easy.done;

/**
 * LeetCode Problem 495 - Teemo Attacking
 * Time Complexity: O(n), where n is the length of the timeSeries array.
 * Space Complexity: O(1), since we are using a constant amount of space.
 * Topics: Array, Greedy
 * <p>
 * Description:
 * 	Teemo is attacking an enemy with a poison duration.
 * 	Given an array of integers representing the time series of Teemo's attacks,
 * 	and an integer duration representing the poison duration,
 * 	return the total time that the enemy is poisoned.
 * 	Hint: If two attacks overlap, the poison duration is extended.
 * 	For example, if Teemo attacks at time t1 and then at t2,
 * 	if t2 is less than or equal to t1 + duration,
 * 	the poison duration is extended to t2 + duration.
 *
 * Hint:
 * 1. Iterate through the time series and calculate the poisoned duration for each attack.
 * 2. If the next attack occurs before the current poison duration ends, extend the poison duration.
 * 3. Sum up the total poisoned duration.
 * Link: https://leetcode.com/problems/teemo-attacking/
 */
public class TeemoAttacking {

	public static void main(String[] args) {
		// Example usage
		//Input: timeSeries = [1,4], duration = 2
		//Output: 4
		//Explanation: Teemo's attacks on Ashe go as follows:
		//- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
		//- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
		//Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
		int[] timeSeries = { 1, 4 };
		int duration = 2;
		int poisonedDuration = findPoisonedDuration(timeSeries, duration);
		// Output: 4
		System.out.println("Total poisoned duration: " + poisonedDuration);
	}

	// Function to find the total poisoned duration
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		int total = 0;
		int start = timeSeries[0];
		int end = timeSeries[0] + duration;
		// Iterate through the time series
		for (int i = 1; i < timeSeries.length; i++) {
			// Get the current attack time and calculate the end time
			int currStart = timeSeries[i];
			int currEnd = timeSeries[i] + duration;

			if (currStart <= end) {
				// If there is an overlap, extend the end time
				end = Math.max(end, currEnd);
			} else {
				//No overlap: add current interval length
				total += end - start;
				//Update the start and end times
				start = currStart;
				end = currEnd;
			}
		}
		//Add the last interval
		total += end - start;

		return total;
	}
}