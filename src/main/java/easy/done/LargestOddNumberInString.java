package easy.done;

/* LeetCode Problem: 1903. Largest Odd Number in String
 * Time: O(n)
 * Space: O(1)
 * Topics: String
 * You are given a string num representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
 * A substring is a contiguous sequence of characters within a string.
 * * Example:
 * Input: num = "452"
 * Output: "45"
 * Input: num = "4206"
 * Output: ""
 * Hint: Traverse the string from the end to find the last odd digit, then return the substring up to that digit.
 * http://leetcode.com/problems/largest-odd-number-in-string/
 */
public class LargestOddNumberInString {

	public static void main(String[] args) {
		System.out.println(largestOddNumber("52")); // Output: "5"
		System.out.println(largestOddNumber("4206")); // Output: ""
		System.out.println(largestOddNumber("35427")); // Output: "35427"
		System.out.println(largestOddNumber("1234567890")); // Output: "123456789"
		System.out.println(largestOddNumber("")); // Output: ""
		System.out.println(largestOddNumber(null)); // Output: ""
	}
	private static String largestOddNumber(String num) {
		if(num == null || num.isEmpty()){
			return "";
		}

		for(int i = num.length()-1 ; i>=0; i--){
			char d = num.charAt(i);
			int digit = d - '0';
			if(digit % 2 == 1){
				return num.substring(0, i+1);
			}
		}

		return "";
	}
}