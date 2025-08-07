package easy.done;

/**
 * LeetCode Problem: 1758. Minimum Changes To Make Alternating Binary String
 * Space: O(1)
 * Time: O(n)
 * Topics: String, Greedy
 * Given a binary string s, return the minimum number of characters you need to change to make s alternating.
 * The string is called alternating if no two adjacent characters are equal.
 * <p>
 * Example:
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', the string will be "0101", which is alternating.
 * <p>
 * Hint: Use two counters to track changes needed for both starting with '0' and '1'.
 * http://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 */
public class MinimumChangesToMakeAlternatingBinaryString {

	public static void main(String[] args) {
		String s = "0100";
		int result = minOperationsIntuitive(s);
		System.out.println("Minimum operations to make the string alternating: " + result);

		String s2 = "1111";
		int result2 = minOperationsMath(s2);
		System.out.println("Minimum operations to make the string alternating: " + result2);
	}

	private static int minOperationsIntuitive(String s) {
		int count1 = 0; // Starting with '0'
		int count2 = 0; // Starting with '1'

		for (int i = 0; i < s.length(); i++) {
			char expected1 = (i % 2 == 0) ? '0' : '1';
			char expected2 = (i % 2 == 0) ? '1' : '0';

			if (s.charAt(i) != expected1) count1++;
			if (s.charAt(i) != expected2) count2++;
		}

		return Math.min(count1, count2);
	}

	private static int minOperationsMath(String s) {
		int start0 = 0;
		int n = s.length();

		for(int i = 0; i < n; i++){
			// Expected character at position i
			// If i is even, expected character is '0'
			// If i is odd, expected character is '1'
			// This creates an alternating pattern starting with '0'
			char expected = (i % 2 == 0) ? '0' : '1';
			// If the character at position i does not match the expected character,
			// increment the count of changes needed
			// This counts how many characters need to be changed to make the string alternate starting with '0'
			if(s.charAt(i)!= expected){
				start0++;
			}
		}

		// The minimum number of changes needed to make the string alternate
		// is the minimum of the changes needed to start with '0' or '1'
		// Since the string can either start with '0' or '1', we can
		// calculate the changes needed for both cases and return the minimum
		// Here, we assume that if the string starts with '1', the expected character
		// at position i would be '1' for even indices and '0' for
		return Math.min(start0, n - start0);
	}
}