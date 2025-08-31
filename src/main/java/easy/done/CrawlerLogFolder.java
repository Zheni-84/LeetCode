package easy.done;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * LeetCode 1598. Crawler Log Folder
 * Time Complexity: O(n), where n is the number of logs.
 * Space Complexity: O(h), where h is the height of the directory structure (in the worst case, all logs are "x/").
 * Topic: Stack, Simulation
 *
 * Each log is a string representing a change in the current directory, where:
 * "../" moves up one directory (to the parent directory of the current directory).
 * "x/" moves into the child directory named x (this is guaranteed to be a valid directory name).
 * "./" stays in the same directory.
 * You are given an array of strings logs where logs[i] is the ith operation performed by the user.
 * The file system starts in the main folder, then the operations in logs are performed.
 * Return the minimum number of operations needed to go back to the main folder after the change represented in logs.
 *
 * Example 1:
 * Input: logs = ["d1/","d2/","../","d21/","./"]
 * Output: 2
 * Explanation: Use this change to go back to the main folder:
 * Go up one level to go to the parent folder of d21 (which is the main folder).
 * Go up one more level to reach the main folder.
 * We need a total of 2 operations to reach the main folder.
 *
 * Example 2:
 * Input: logs = ["d1/","d2/","./","d3/","../","d31/"]
 * Output: 3
 * Explanation: Use this change to go back to the main folder:
 * Go up two levels to reach d1 (the parent folder of d31).
 * Go up one more level to reach the main folder.
 * We need a total of 3 operations to reach the main folder.
 *
 * Example 3:
 * Input: logs = ["d1/","../","../","../"]
 * Output: 0
 * Explanation: You are already in the main folder, so you cannot go up any further.
 *
 * Constraints:
 * 1 <= logs.length <= 10^3
 * 2 <= logs[i].length <= 10
 * logs[i] contains lowercase English letters, digits, '.', and '/'.
 * logs[i] follows the format described in the statement.
 * Directory names consist of lowercase English letters and digits.
 *
 * Hint: Use a stack to simulate the directory changes.
 * https://leetcode.com/problems/crawler-log-folder/
 */
public class CrawlerLogFolder {

	public static void main(String[] args) {
		String[] logs = {"d1/","d2/","../","d21/","./"};
		int result = minOperations(logs);
		System.out.println("Minimum operations to reach the main folder: " + result); // Output: 2
	}

	private static int minOperations(String[] logs) {
		Deque<String> stack = new ArrayDeque<>();
		for(String log : logs){
			if("../".equals(log)){
				// go up a level
				if(!stack.isEmpty()) stack.pop();
			} else if("./".equals(log)){
				//do nothing
			} else
				// go down a level
				stack.push(log);
		}

		// stack size indicates the level on which we are in
		return stack.size();
	}
}