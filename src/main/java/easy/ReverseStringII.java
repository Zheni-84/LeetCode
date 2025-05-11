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
		int[] ks = { 1, 20, 100, 1000, 5000 };
		int[] lengths = { 10_000, 100_000, 1_000_000 };

		for (int len : lengths) {
			String input = generateInput(len);
			for (int k : ks) {
				long start = System.nanoTime();
				reverseStr(input, k);
				long end = System.nanoTime();
				double duration = (end - start) / 1_000_000.0;
				System.out.printf("k = %-5d | Length = %-8d | Time = %.4f ms%n", k, len, duration);
			}
			System.out.println("-".repeat(50));
		}
	}

	private static String generateInput(int len) {
		return "abcdefghijklmnopqrstuvwxyz".repeat((len / 26) + 1).substring(0, len);
	}

	//Auto-Choosing Utility method
	public static String reverseStr(String s, int k) {
		boolean useCharArray = shouldUseCharArray(s.length(), k);
		logStrategy(useCharArray);
		return useCharArray ? reverseStrArray(s, k) : reverseStrBuilder(s, k);
	}

	private static boolean shouldUseCharArray(int length, int k) {
		// Heuristic: prefer char[] if many small reversals
		return k <= 20;
	}

	private static void logStrategy(boolean usedCharArray) {
		String strategy = usedCharArray ? "char[]" : "StringBuilder";
		System.out.printf("Using strategy: %-13s | ", strategy);
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