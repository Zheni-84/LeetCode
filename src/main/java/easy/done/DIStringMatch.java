package easy.done;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem 942: DI String Match
 * !!!!!!! Variation with lexicographically the smallest permutation !!!!!!!
 * Topics: Array, Greedy
 * Time Complexity: O(n), where n is the length of the string s.
 * Space Complexity: O(n), for the result array.
 * Given a string s consisting of 'I' (increasing) and 'D' (decreasing) characters,
 * return an array of integers representing a permutation of the integers from 0 to n
 * such that for each character in s, the corresponding condition is satisfied:
 * - If s[i] == 'I', then result[i] < result[i + 1]
 * - If s[i] == 'D', then result[i] > result[i + 1]
 * Example 1:
 * Input: s = "IDID"
 * Output: [0, 2, 1, 4, 3]
 * Explanation: The result array [0, 4, 1, 3, 2] satisfies the conditions:
 * - result[0] < result[1] (0 < 2)
 * - result[1] > result[2] (2 > 1)
 * - result[2] < result[3] (1 < 4)
 * - result[3] > result[4] (4 > 3)
 * http://leetcode.com/problems/di-string-match/
 */

public class DIStringMatch {

	public int[] diStringMatch(String s) {
		int n = s.length();
		int[] result = new int[n+1];

		Deque<Integer> stack = new ArrayDeque<>();
		int idx = 0;
		for(int i = 0; i<=n; i++){
			// Always push the current index
			stack.push(i);
			if(i < n && s.charAt(i) == 'D') {
				continue; // Continue to the next iteration if 'D' is found
			}
			// If we reach the end of the string or the next character is 'I',
			// we pop all elements from the stack to fill the result array
			if(i == n || s.charAt(i) == 'I'){
				// Pop elements from the stack and fill the result array
				while(!stack.isEmpty()){
					result[idx++] = stack.pop();
				}
			}
		}

		return result;
	}
}