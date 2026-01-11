package easy.done;

import java.util.HashMap;

/**
 * LeetCode Problem 914: X of a Kind in a Deck of Cards
 * Time Complexity: O(n + k * log(max_count)), where n is the number of cards and k is the number of unique cards
 * Space Complexity: O(k), where k is the number of unique cards
 * Topics: Array, Hash Table, Math, Number Theory
 * <p>
 * Given an array deck where deck[i] represents a card with an integer written on it,
 * return true if you can partition the deck into one or more groups of cards, where:
 * - Each group has exactly X cards (X >= 2)
 * - All the cards in each group have the same integer
 * <p>
 * Examples:
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * <p>
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition
 * <p>
 * Constraints:
 * 1 <= deck.length <= 10^4
 * 0 <= deck[i] < 10^4
 * <p>
 * Hint:
 * 1. Count the frequency of each card value
 * 2. Find the GCD of all frequencies
 * 3. If GCD >= 2, we can partition the deck
 * <p>
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class XOfAKindInDeckOfCards {

	/**
	 * Solution with HashMap
	 * Uses HashMap to count card occurrences and finds GCD of all counts
	 */
	public boolean hasGroupsSizeXHashMap(int[] deck) {
		HashMap<Integer, Integer> count = new HashMap<>();

		// Count occurrences of each card
		for (int card : deck) {
			count.put(card, count.getOrDefault(card, 0) + 1);
		}

		// Find GCD of all counts
		int gcd = 0;
		for (int c : count.values()) {
			gcd = gcd(gcd, c);
		}

		return gcd >= 2;
	}

	/**
	 * Solution with array
	 * Uses array to count card occurrences and finds GCD of all counts
	 */
	public boolean hasGroupsSizeX(int[] deck) {
		int[] count = new int[10000];
		for (int card : deck) {
			count[card]++;
		}

		int gcd = 0;
		for (int c : count) {
			if (c > 0) {
				gcd = gcd(gcd, c);
			}
		}

		return gcd >= 2;
	}

	/**
	 * Calculates the Greatest Common Divisor (GCD) of two numbers using Euclidean algorithm
	 */
	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
		
}