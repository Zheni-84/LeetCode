package easy.done;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem: 1614. Maximum Nesting Depth of the Parentheses
 * Time: O(n) - both methods
 * Space: O(1) - counters only; O(n) - stack in the worst case
 * Topics: String
 * Given a string s containing just the characters '(', ')', return the maximum nesting depth of the parentheses in s.
 * <p>
 * Example:
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Hint: Use a counter to track the current depth and update the maximum depth when encountering an opening parenthesis.
 * Or use a stack to track the depth of nested parentheses.
 * <p>
 * http://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class MaximumNestingDepthOfParentheses {

	public static void main(String[] args) {
		String s = "(1+(2*3)+((8)/4))+1";
		System.out.println(maxDepthStack(s)); // Output: 3
		System.out.println(maxDepthCounters(s)); // Output: 3
	}

	private static int maxDepthStack(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		return s.chars()
				.mapToObj(c -> (char)c) // convert int -> char
				.map(c -> {
					if(c == '(') stack.push(c);
					if(c == ')') stack.pop();

					return stack.size();
				})
				.max(Integer::compareTo)
				.orElse(0);
	}

	private static int maxDepthCounters(String s) {
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