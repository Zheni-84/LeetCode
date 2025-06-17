package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * LeetCode Problem: 20. Valid Parentheses
 * Time Complexity: O(n), where n is the length of the string s.
 * Space Complexity: O(n), in the worst case, for the stack used to store opening brackets.
 * Topics: Stack, String, Hash Table, String Matching
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *   1. Open brackets must be closed by the same type of brackets.
 *   2. Open brackets must be closed in the correct order.
 *
 * Example:
 *   Input: s = "([{}])"
 *   Output: true
 *
 *   Input: s = "([)]"
 *   Output: false
 *
 * Constraints:
 *   - 1 <= s.length <= 10^4
 *   - s consists of parentheses only '()[]{}'
 *
 * This class provides a static method isValid to check the validity of the parentheses string.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		String s1 = "([{}])"; // true
		String s2 = "([)]";   // false
		String s3 = "{[()]}"; // true
		String s4 = "{[(])}"; // false
		String s5 = "()"; // true

		System.out.println("Is valid: " + vp.isValid(s1)); // true
		System.out.println("Is valid: " + vp.isValid(s2)); // false
		System.out.println("Is valid: " + vp.isValid(s3)); // true
		System.out.println("Is valid: " + vp.isValid(s4)); // false
		System.out.println("Is valid: " + vp.isValid(s5)); // true
	}

	private static boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		Map<Character, Character> matching = Map.of(')', '(', ']', '[', '}', '{');

		for (char ch : s.toCharArray()) {
			if (matching.containsValue(ch)) {
				// push opening bracket
				stack.push(ch);
			} else if (matching.containsKey(ch)) {
				if (stack.isEmpty() || stack.pop() != matching.get(ch)) {
					return false; // unmatched or out of order
				}
			}
		}
		// valid if all opened brackets are closed
		return stack.isEmpty();
	}
}