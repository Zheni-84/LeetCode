package easy.done;

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
 * Hint: Use a stack to keep track of opening brackets and ensure they are closed in the correct order.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String s1 = "([{}])"; // true
		String s2 = "([)]";   // false
		String s3 = "{[()]}"; // true
		String s4 = "{[(])}"; // false
		String s5 = "()"; // true

		System.out.println("Is valid: " + isValid3(s1)); // true
		System.out.println("Is valid: " + isValid3(s2)); // false
		System.out.println("Is valid: " + isValid1(s3)); // true
		System.out.println("Is valid: " + isValid2(s4)); // false
		System.out.println("Is valid: " + isValid2(s5)); // true
	}

	private static boolean isValid3(String s) {
		Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
		Deque<Character> stack = new ArrayDeque<>();

		for(char c : s.toCharArray()){
			if(map.containsKey(c)){
				stack.push(c);
			} else{
				if(stack.isEmpty()) return false;
				char opening = stack.pop();
				if(c != map.get(opening)) return false;
			}
		}

		return stack.isEmpty();
	}

	private static boolean isValid1(String s) {
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

	private static boolean isValid2(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') stack.push(')');
			else if (c == '[') stack.push(']');
			else if (c == '{') stack.push('}');
			else if (stack.isEmpty() || stack.pop() != c) return false;
		}

		return stack.isEmpty();
	}
}