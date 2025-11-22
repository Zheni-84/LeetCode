package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 1385: Find the Distance Value Between Two Arrays
 * Time Complexity: O(n log m), where n is the length of arr1 and m is the length of arr2.
 * Space Complexity: O(1) if we ignore the input storage, otherwise O(m) for sorting arr2.
 * Topic: Array, Binary Search, Sorting
 *
 * This class provides a method to find the distance value between two arrays.
 * The main method demonstrates the usage of the findTheDistanceValue method.
 *
 * Hint: Sort arr2 and use binary search to efficiently check the distance condition for each element in arr1.
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 */
public class FindTheDistanceValueBetweenTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = { 4, 5, 8 };
		int[] arr2 = { 10, 9, 1, 8 };
		int d = 2;
		int result = findTheDistanceValue(arr1, arr2, d);
		System.out.println("Distance Value: " + result); // Output: 2

		arr1 = new int[] { 1, 4, 2, 3 };
		arr2 = new int[] { -4, -3, 6, 10, 20, 30 };
		d = 3;
		result = findTheDistanceValue(arr1, arr2, d);
		System.out.println("Distance Value: " + result); // Output: 2

		arr1 = new int[] { 2, 1, 100, 3 };
		arr2 = new int[] { -5, -2, 10, -3, 7 };
		d = 6;
		result = findTheDistanceValue(arr1, arr2, d);
		System.out.println("Distance Value: " + result); // Output: 1
	}

	private static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		Arrays.sort(arr2);
		for(int a : arr1){
			if(isFarEnough(a, arr2, d)){
				count++;
			}
		}

		return count;
	}

	private static  boolean isFarEnough(int a, int[] arr, int d){
		int idx = Arrays.binarySearch(arr, a);
		//exact match of the element in arr2
		if(idx >=0) return false;

		// 'a' does not exist in arr2, then check its potential neighbours left and right, if inserted
		int insertIdx = -idx - 1;

		//check the element at the index that 'a' should be inserted
		//this element should be after 'a', if 'a' is inserted
		if(insertIdx < arr.length && Math.abs(a - arr[insertIdx]) <= d) return false;
		// if 'a' has a left neighbour(insert pos > 0), then check it
		if(insertIdx > 0 && Math.abs(a - arr[insertIdx - 1]) <= d) return false;

		return true;
	}
}
