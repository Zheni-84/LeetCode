package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode Problem 599 - Minimum Index Sum of Two Lists
 * Topics: Array, Hash Table, String
 * Time Complexity: O(n + m) - where n is the length of list1 and m is the length of list2.
 * Space Complexity: O(n + m) - for storing the indices in a HashMap.
 * <p>
 * Description:
 * Given two arrays of strings list1 and list2, find the common strings with the minimum index sum.
 * If there are multiple common strings with the same minimum index sum, return them in any order.
 * <p>
 * Link: https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSumTwoLists {

	class Solution {

		public static void main(String[] args) {
			String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
			String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

			String[] result = findRestaurant(list1, list2);
			for (String restaurant : result) {
				System.out.println(restaurant);
			}
		}

		private static String[] findRestaurant(String[] list1, String[] list2) {
			// Create a map to store the indices of the strings in list1
			Map<String, Integer> list1Map = new HashMap<>();
			for (int i = 0; i < list1.length; i++) {
				list1Map.put(list1[i], i);
			}

			//loop list2 and check with the index map, keep track of the min index sum
			//add in array the words
			List<String> result = new ArrayList<>();
			int minSum = Integer.MAX_VALUE;
			for (int i = 0; i < list2.length; i++) {
				String word = list2[i];
				if (list1Map.containsKey(word)) {
					//calculate the sum of indices
					int sum = i + list1Map.get(word);
					//check if the sum is less than the current minSum
					if (sum < minSum) {
						result.clear();
						result.add(word);
						minSum = sum;
					} else if (sum == minSum) {
						//if the sum is equal to the current minSum, add the word to the result
						result.add(word);
					}
				}
			}

			return result.toArray(new String[0]);
		}
	}
}