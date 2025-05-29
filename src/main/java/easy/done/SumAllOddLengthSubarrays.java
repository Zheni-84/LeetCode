package easy.done;

/**
 * LeetCode 1588: Sum of All Odd Length Subarrays
 * Topics: Array, Prefix Sum
 * <p>
 * Time Complexity: O(n^2), where n is the length of the array.
 * Space Complexity: O(1)
 * <p>
 * This class provides two methods to calculate the sum of all odd-length subarrays.
 * The first method uses a brute force approach, while the second method uses an optimal approach.
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumAllOddLengthSubarrays {

	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 5, 3};

		int resultBrute = sumOddLengthSubarraysBrute(arr);
		System.out.println("Brute Force Result: " + resultBrute); // Expected output: 58

		int resultOptimal = sumOddLengthSubarraysOptimal(arr);
		System.out.println("Optimal Result: " + resultOptimal); // Expected output: 58
	}

	private static int sumOddLengthSubarraysBrute(int[] arr) {
		int totalSum = 0;
		int n = arr.length;

		for (int length = 1; length <= n; length += 2) { // Iterate over odd lengths
			for (int start = 0; start <= n - length; start++) { // Start index of the subarray
				for (int i = start; i < start + length; i++) { // Sum the elements in the subarray
					totalSum += arr[i];
				}
			}
		}

		return totalSum;
	}

	private static int sumOddLengthSubarraysOptimal(int[] arr) {
		int total = 0;
		int len = arr.length;

		for(int i = 0; i<len; i++){
			// Calculate the number of subarrays that include arr[i]
			// The number of subarrays that can be formed with arr[i] as the center
			// is determined by the number of elements to the left and right of it.
			// For arr[i], the number of subarrays that can be formed is:
			// (i + 1) * (len - i)
			// where (i + 1) is the number of elements to the left (including itself)
			// and (len - i) is the number of elements to the right (including itself).
			// Each subarray can be of odd length, and we need to count how many such subarrays
			// The total number of subarrays that include arr[i] is (i + 1) * (len - i).
			int left = i+1;
			int right = len-i;
			int totalSubArrays = left*right;
			// Since we are only interested in odd-length subarrays,
			// we can calculate how many of these subarrays are odd-length.
			// The number of odd-length subarrays is half of the total subarrays,
			int oddCount = (totalSubArrays+1)/2;
			// Now we can multiply the value of arr[i] by the number of odd-length subarrays
			// that include it to get the contribution of arr[i] to the total sum.
			// This is because each odd-length subarray that includes arr[i] contributes arr[i] to the total sum.
			// So we add arr[i] * oddCount to the total sum.
			total += arr[i] * oddCount;
		}

		return total;
	}
}