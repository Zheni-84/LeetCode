package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 1634 - Buy Two Chocolates
 * Topics: Array, Sorting
 * Time Complexity: O(n log n) - for sorting the array, where n is the length of the input array.
 * Space Complexity: O(1) - in-place sorting.
 * <p>
 * Description:
 * You are given an integer array prices where prices[i] is the price of the ith chocolate.
 * You are also given an integer money, which represents the amount of money you have.
 * <p>
 * Return the amount of money left after buying two chocolates with the lowest prices.
 * If you cannot buy two chocolates, return money.
 * <p>
 * Link: https://leetcode.com/problems/buy-two-chocolates/
 */
public class BuyTwoChocolates {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 4, 5 };
		int money = 7;
		// Example usage
		// Output: 0
		// Explanation: The first two chocolates cost 1 and 2, which is a total of 3.
		// The remaining money is 7 - 3 = 4.
		System.out.println("Money left after buying two chocolates: " + buyChoco(prices, money));
	}

	private static int buyChoco(int[] prices, int money) {
		Arrays.sort(prices);
		int first = prices[0];
		int second = prices[1];
		int totalPrice = first + second;
		if (totalPrice <= money) {
			return money - totalPrice;
		}

		return money;
	}
}