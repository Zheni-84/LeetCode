package easy.done;

/**
 * LeetCode Problem: 1614. Maximum Nesting Depth of the Parentheses
 * Space: O(1)
 * Time: O(n)
 * Topics: String
 * Given a string s containing just the characters '(', ')', return the maximum nesting depth of the parentheses in s.
 * <p>
 * Example:
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Hint: Use a counter to track the current depth and update the maximum depth when encountering an opening parenthesis.
 * http://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class MaximumNestingDepthOfParentheses {

	public static void main(String[] args) {
		String input = "(1+(2*3)+((8)/4))+1";
		int result = maxDepth(input);
		System.out.println("Maximum nesting depth of parentheses: " + result); // Output: 3
	}

	private static int maxDepth(String s) {
		int maxDepth = 0;
		int currDepth = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				currDepth++;
				maxDepth = Math.max(maxDepth, currDepth);
			}
			if (c == ')') {
				currDepth--;
			}
		}

		return maxDepth;
	}
}