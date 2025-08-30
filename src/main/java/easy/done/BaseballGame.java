package easy.done;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem: 682. Baseball Game
 * Time Complexity: O(n), where n is the number of operations.
 * Space Complexity: O(n), in the worst case, for the stack used to store scores.
 * Topics: Stack, Array
 * <p>
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds,
 * where the scores of past rounds may affect future rounds' scores.
 * <p>
 * At the beginning of the game, you start with an empty record. You are given a list of strings ops,
 * where ops[i] is the ith operation you must apply to the record and is one of the following:
 * <p>
 * 1. An integer x - Record a new score of x.
 * 2. "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * 3. "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * 4. "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * <p>
 * Return the sum of all the scores on the record after applying all the operations.
 * The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer
 * <p>
 * Example:
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 * <p>
 * Constraints:
 * - 1 <= ops.length <= 1000
 * - ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 10^4, 3 * 10^4].
 * - For operation "+", there will always be at least two previous scores on the record.
 * - For operations "C" and "D", there will always be at least one previous score on the record.
 * Hint: Use a stack to keep track of the scores. For each operation, modify the stack accordingly.
 * https://leetcode.com/problems/baseball-game/
 */
public class BaseballGame {

	public static void main(String[] args) {
		String[] ops = { "5", "2", "C", "D", "+" };
		System.out.println(calPointsStack(ops)); // Output: 30
		System.out.println(calPointsArray(ops)); // Output: 30
	}

	private static int calPointsStack(String[] operations) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (String op : operations) {
			switch (op) {
				case "C":
					stack.pop();
					break;
				case "D":
					stack.push(stack.peek() * 2);
					break;
				case "+":
					int top = stack.pop();
					int next = top + stack.peek();
					stack.push(top);
					stack.push(next);
					break;
				default:
					stack.push(Integer.parseInt(op));
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}

	private static int calPointsArray(String[] ops) {
		int[] scores = new int[ops.length];
		int index = 0;

		for (String op : ops) {
			switch (op) {
				case "C":
					index--;
					break;
				case "D":
					scores[index] = 2 * scores[index - 1];
					index++;
					break;
				case "+":
					scores[index] = scores[index - 1] + scores[index - 2];
					index++;
					break;
				default:
					scores[index] = Integer.parseInt(op);
					index++;
					break;
			}
		}

		int totalScore = 0;
		for (int i = 0; i < index; i++) {
			totalScore += scores[i];
		}

		return totalScore;
	}
}