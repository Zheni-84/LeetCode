package medium;

/**
 * LeetCode 12. Integer to Roman
 * Time Complexity: O(1) since the number of digits is fixed (maximum 4 digits for 3999)
 * Space Complexity: O(1) since we use a fixed amount of space
 * Topics: Math, String
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as XII, which is simply X + II. The number twenty-seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral.
 *
 * Examples:
 * Input: num = 3
 * Output: "III"
 *
 * Input: num = 4
 * Output: "IV"
 *
 * Input: num = 9
 * Output: "IX"
 *
 * Input: num = 58
 * Output: "LVIII"
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 *
 * Constraints:
 * 1 <= num <= 3999
 *
 * Hint:
 * 1. Create arrays to map integer values to their corresponding Roman numeral symbols.
 * 2. Use a greedy approach to build the Roman numeral string by subtracting the largest possible values.
 *
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		int num = 1994;
		System.out.println("Integer: " + num);
		System.out.println("Roman Numeral (Mapping): " + intToRoman(num));

		IntegerToRoman converter = new IntegerToRoman();
		System.out.println("Roman Numeral (Greedy): " + converter.intToRomanGreedy(num));
	}

	//Greedy with ordered mapping
	public String intToRomanGreedy(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		StringBuilder roman = new StringBuilder();

		// Iterate through each symbol, stopping if num becomes 0
		for (int i = 0; i < values.length && num > 0; i++) {
			while (num >= values[i]) {
				// Append the symbol while subtracting its value from num
				num -= values[i];
				roman.append(symbols[i]);
			}
		}

		return roman.toString();
	}

	// Convert Integer to Roman Numerals
	// Time Complexity: O(1) since the number of digits is fixed (maximum 4 digits for 3999)
	// Space Complexity: O(1) since we use a fixed amount of space
	private static String intToRoman(int num) {
		String[] thousands = {"", "M", "MM", "MMM"};
		String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

		return thousands[num / 1000] +
			   hundreds[(num % 1000) / 100] +
			   tens[(num % 100) / 10] +
			   units[num % 10];
	}
}