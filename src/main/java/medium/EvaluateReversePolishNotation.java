package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem: 150. Evaluate Reverse Polish Notation
 * Time Complexity: O(n), where n is the number of tokens.
 * Space Complexity: O(n), in the worst case, for the stack used to store operands.
 * Topics: Stack, Array
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result,
 * and there will not be any division by zero operation.
 *
 * Example:
 *   Input: tokens = ["2","1","+","3","*"]
 *   Output: 9
 *   Explanation: ((2 + 1) * 3) = 9
 *
 *   Input: tokens = ["4","13","5","/","+"]
 *   Output: 6
 *   Explanation: (4 + (13 / 5)) = 6
 *
 *   Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 *   Output: 22
 *   Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *
 * Constraints:
 *   - 1 <= tokens.length <= 10^4
 *   - tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 *
 * Hint: Use a stack to keep track of operands. When you encounter an operator, pop the required number of operands from the stack,
 * apply the operator, and push the result back onto the stack.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		int result = evalRPN1(tokens);
		System.out.println(result); // Output: 9
	}

	private static int evalRPN1(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();

		for (String token : tokens) {
			switch (token) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a - b);
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					b = stack.pop();
					a = stack.pop();
					stack.push(a / b);
					break;
				default:
					stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

	private static int evalRPN2(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();

		for (String token : tokens) {
			if (isOperator(token)) {
				int b = stack.pop();
				int a = stack.pop();
				int res = applyOperator(a, b, token);
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

	private static boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

	private static int applyOperator(int a, int b, String operator) {
		switch (operator) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				return a / b; // Integer division
			default:
				throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}