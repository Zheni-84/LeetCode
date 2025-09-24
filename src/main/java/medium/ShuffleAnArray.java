package medium;

import java.util.Random;

/**
 * LeetCode Problem: 384. Shuffle an Array
 * Time Complexity: O(n) for the shuffle operation, where n is the number of elements in the array.
 * Space Complexity: O(n) for storing the original array and the shuffled array.
 * Topics: Array, Math, Randomized
 *
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * All permutations of the array should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 *   - Solution(int[] nums) Initializes the object with the integer array nums.
 *   - int[] reset() Resets the array to its original configuration and returns it.
 *   - int[] shuffle() Returns a random shuffling of the array.
 *
 * Example:
 *   Input
 *   ["Solution", "shuffle", "reset", "shuffle"]
 *   [[[1, 2, 3]], [], [], []]
 *   Output
 *   [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 *   Explanation
 *   Solution solution = new Solution([1, 2, 3]);
 *   solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
 *   solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 *   solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 *
 * Constraints:
 *   - 1 <= nums.length <= 200
 *   - -10^6 <= nums[i] <= 10^6
 *   - All the elements of nums are unique.
 *   - At most 5 * 10^4 calls will be made to reset and shuffle.
 *
 * Hint: Use the Fisher-Yates shuffle algorithm to ensure that all permutations are equally likely.
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleAnArray {

	private static Random rand = new Random();

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		int[] clone1 = nums.clone();
		naiveShuffle(clone1);
		System.out.print("Naively Shuffled Array: ");
		for (int num : clone1) {
			System.out.print(num + " ");
		}
		int[] clone2 = nums.clone();
		shuffleOptimal(clone2);
		System.out.print("\nOptimally Shuffled Array: ");
		for (int num : clone2) {
			System.out.print(num + " ");
		}

		System.out.println();
		ShuffleAnArray shuffleAnArray = new ShuffleAnArray(nums);
		nums = shuffleAnArray.reset();
		int[] shuffled = shuffleAnArray.shuffle();
		System.out.print("Shuffled Array: ");
		for (int num : shuffled) {
			System.out.print(num + " ");
		}
		System.out.println();

		int[] resetArray = shuffleAnArray.reset();
		System.out.print("Reset Array: ");
		for (int num : resetArray) {
			System.out.print(num + " ");
		}
	}

	private static int getRandom(int floor, int ceiling) {
		// nextInt is normally exclusive of the top value, so add 1 to make it inclusive
		// Example: getRandom(1, 3) => possible values are 1, 2, or 3
		// Math: rand.nextInt((3 - 1) + 1) + 1 => rand.nextInt(3) + 1
		// rand.nextInt(3) generates 0, 1, or 2
		// Adding 1 shifts the range to 1, 2, or 3
		// This ensures uniform distribution across the range [floor, ceiling]
		int i = rand.nextInt((ceiling - floor) + 1);
		return i + floor;
	}

	private static void naiveShuffle(int[] array) {

		// for each index in the array
		for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

			// grab a random other index
			int secondIndex = getRandom(0, array.length - 1);

			// and swap the values
			if (secondIndex != firstIndex) {
				int temp = array[firstIndex];
				array[firstIndex] = array[secondIndex];
				array[secondIndex] = temp;
			}
		}
	}

	private static void shuffleOptimal(int[] array) {

		// if it's 1 or 0 items, just return
		if (array.length <= 1) {
			return;
		}

		// walk through from beginning to end
		for (int indexWeAreChoosingFor = 0; indexWeAreChoosingFor < array.length - 1; indexWeAreChoosingFor++) {

			// choose a random not-yet-placed item to place there
			// (could also be the item currently in that spot)
			// must be an item AFTER the current item, because the nums before has all already been placed
			int randomChoiceIndex = getRandom(indexWeAreChoosingFor, array.length - 1);

			// place our random choice in the spot by swapping
			if (randomChoiceIndex != indexWeAreChoosingFor) {
				int valueAtIndexWeChoseFor = array[indexWeAreChoosingFor];
				array[indexWeAreChoosingFor] = array[randomChoiceIndex];
				array[randomChoiceIndex] = valueAtIndexWeChoseFor;
			}
		}
	}

	private final int[] original;
	private int[] array;

	public ShuffleAnArray(int[] nums) {
		this.original = nums.clone();
		this.array = nums;
	}

	public int[] reset() {
		this.array = this.original.clone();
		return this.array;
	}

	public int[] shuffle() {
		for (int i = array.length - 1; i > 0; i--) {
			// Generate a random index j such that 0 <= j <= i
			//example: if i = 4, Math.random() * (4 + 1) = Math.random() * 5 = [0.0, 5.0) => (int) [0, 4]
			// So j can be 0, 1, 2, 3, or 4
			// This ensures that each element has an equal probability of being chosen for swapping
			// This is crucial for achieving a uniform shuffle
			// This is known as the Fisher-Yates shuffle algorithm
			double random = Math.random();
			int j = (int) (random * (i + 1));
			swap(array, i, j);
		}
		return array;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
