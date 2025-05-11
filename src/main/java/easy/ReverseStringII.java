package easy;

/**
 * LeetCode Problem 541 - Reverse String II
 * Topics: String
 * Time Complexity: O(n) - for iterating through the string.
 * Space Complexity: O(n) - for the result string.
 * <p>
 * Description:
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 **/
public class ReverseStringII {
/*Takeaway:
    - Use StringBuilder for larger k => meaning fewer reversals — cleaner and often faster.
    - Use char[] for small k => meaning frequent reversals — much more memory- and CPU-efficient.
 */
	public static void main(String[] args) {
		StringBuilder input = new StringBuilder();
		for (int i = 0; i < 1_000_000; i++) { // change this for bigger/smaller input
			input.append((char) ('a' + (i % 26)));
		}
		String s = input.toString();
		int k = 1000;// change this to see benchmarks with more/fewer reversals

		// Measure the performance of the StringBuilder-based implementation
		// Start the timer
		long start1 = System.nanoTime();
		reverseStrBuilder(s, k); // Execute the reverseStrBuilder method
		// End the timer
		long end1 = System.nanoTime();
		// Output the elapsed time in milliseconds
		System.out.println("StringBuilder: " + (end1 - start1) / 1_000_000.0 + " ms");

		// Measure the performance of the char[]-based implementation
		// Start the timer
		long start2 = System.nanoTime();
		reverseStrArray(s, k); // Execute the reverseStrArray method
		// End the timer
		long end2 = System.nanoTime();
		// Output the elapsed time in milliseconds
		System.out.println("char[]: " + (end2 - start2) / 1_000_000.0 + " ms");
	}

	//Auto-Choosing Utility method
	public static String reverseStr(String s, int k) {
		// Heuristic: prefer char[] if many small reversals
		if (k <= 20) {
			return reverseStrArray(s, k);
		} else {
			return reverseStrBuilder(s, k);
		}
	}

	private static String reverseStrBuilder(String s, int k) {
		StringBuilder result = new StringBuilder();
		int n = s.length();

		for (int i = 0; i < n; i += 2 * k) {
			int end = Math.min(i + k, n);
			//Reverse the first k chars
			result.append(new StringBuilder(s.substring(i, end)).reverse());

			//Append the next k characters (if any)
			if (end < n) {
				int nextEnd = Math.min(i + 2 * k, n);
				result.append(s, end, nextEnd);
			}
		}

		return result.toString();
	}

	private static String reverseStrArray(String s, int k) {
		char[] chars = s.toCharArray();
		int n = chars.length;

		for (int i = 0; i < n; i += 2 * k) {
			int left = i;
			int right = Math.min(i + k - 1, n - 1);
			while (left < right) {
				char tmp = chars[left];
				chars[left++] = chars[right];
				chars[right--] = tmp;
			}
		}

		return new String(chars);
	}
}