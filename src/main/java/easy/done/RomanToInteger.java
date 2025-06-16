package easy.done;

import java.util.Map;

/**
 * LeetCode 13. Roman to Integer
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Topic: String, Hash Table, Math
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

	public static void main(String[] args) {
		String romanNumeral = "MCMXCIV"; // Example input
		int result = romanToInt(romanNumeral);
		System.out.println("The integer value of " + romanNumeral + " is: " + result);
	}
	private static int romanToInt(String s) {
		Map<Character, Integer> romanMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
		int result = 0;
		int prevValue = 0;

		for(int i = s.length() - 1; i >= 0; i--){
			// Get the value of the current Roman numeral
			int value = romanMap.get(s.charAt(i));
			// If the current value is less than the previous value, subtract it from the result
			if (value < prevValue){
				result -= value;
			} else{
				// Otherwise, add it to the result
				result += value;
			}
			// Update the previous value for the next iteration
			prevValue = value;
		}

		return result;
	}
}