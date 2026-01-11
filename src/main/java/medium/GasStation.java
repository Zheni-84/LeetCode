package medium;

/**
 * LeetCode 134. Gas Station
 * Time Complexity: O(N) where N is the number of gas stations
 * Space Complexity: O(1)
 * Topics: Greedy, Array, Prefix Sum
 * <p>
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique.
 * <p>
 * Examples:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * <p>
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * <p>
 * Constraints:
 * n == gas.length == cost.length
 * 1 <= n <= 10^5
 * 0 <= gas[i], cost[i] <= 10^4
 * <p>
 * Solutions:
 * 1. Greedy Algorithm (O(N) time, O(1) space)
 * 2. Greedy Algorithm with Total and Current Gas Tracking (O(N) time, O(1) space)
 * <p>
 * Hint:
 * 1. If the total amount of gas is less than the total cost, completing the circuit is impossible.
 * 2. Use a greedy approach to find the starting station by tracking current gas and resetting when it goes negative.
 * <p>
 * Hint:
 * 1. Start from the first gas station and keep track of the total gas and total cost.
 * 2. Maintain a current gas variable to track the gas in the tank as you move from station to station.
 * 3. If at any point the current gas becomes negative, reset the starting station to the next station and reset current gas to zero.
 * 4. If the total gas is greater than or equal to the total cost, return the starting station index; otherwise return -1.
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {

	public static void main(String[] args) {
		int[] gas1 = {1, 2, 3, 4, 5};
		int[] cost1 = {3, 4, 5, 1, 2};
		System.out.println(canCompleteCircuit1(gas1, cost1)); // Output: 3

		int[] gas2 = {2, 3, 4};
		int[] cost2 = {3, 4, 3};
		System.out.println(canCompleteCircuit1(gas2, cost2)); // Output: -1

		System.out.println(canCompleteCircuit2(gas1, cost1)); // Output: 3
		System.out.println(canCompleteCircuit2(gas2, cost2)); // Output: -1

		System.out.println(canCompleteCircuitPrefixSum(gas1, cost1)); // Output: 3
		System.out.println(canCompleteCircuitPrefixSum(gas2, cost2)); // Output: -1
	}

	// Greedy Approach with Total and Current Gas Tracking
	private static int canCompleteCircuit1(int[] gas, int[] cost) {
		int totalGas = 0;
		int totalCost = 0;
		int currentGas = 0;
		int startingStation = 0;

		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			currentGas += gas[i] - cost[i];

			if (currentGas < 0) {
				startingStation = i + 1;
				currentGas = 0;
			}
		}

		return totalGas < totalCost ? -1 : startingStation;
	}

	// Greedy Approach
	private static int canCompleteCircuit2(int[] gas, int[] cost) {
		// If the total gas is less than the total cost, completing the circuit is
		// impossible.
		int totalGas = 0;
		int totalCost = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
		}
		if (totalGas < totalCost) {
			return -1;
		}
		int start = 0;
		int tank = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			// If our tank has negative gas, we cannot continue through the circuit from
			// the current start point, nor from any station before or including the
			// current station 'i'.
			if (tank < 0) {
				// Set the next station as the new start point and reset the tank.
				start = i + 1;
				tank = 0;
			}
		}

		return start;
	}

	// Prefix Sum Approach
	private static int canCompleteCircuitPrefixSum(int[] gas, int[] cost) {
		int totalGas = 0;
		int totalCost = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
		}
		if (totalGas < totalCost) {
			return -1;
		}

		int start = 0;
		int currentSum = 0;
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i < gas.length; i++) {
			currentSum += gas[i] - cost[i];
			if (currentSum < minSum) {
				minSum = currentSum;
				start = i + 1;
			}
		}

		return start % gas.length;
	}
}