package easy.done;


/**
 * LeetCode Problem 2379 - Minimum Recolors to Get K Consecutive Black Blocks
 * Topics: String, Sliding Window
 * Time Complexity: O(n), where n is the length of the input string blocks.
 * Space Complexity: O(1), since we are using a constant amount of extra space for variables.
 *
 * Description:
 * You are given a string blocks of length n, where blocks[i] is either 'B' or 'W', representing a black block or a white block respectively.
 * You are also given an integer k, which represents the number of consecutive blocks you want to recolor to black.
 * Return the minimum number of white blocks that need to be recolored to get k consecutive black blocks.
 *
 * Example:
 * Input: blocks = "WBBWWBB", k = 7
 * Output: 3
 *
 * Link: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */
public class MinimumRecolorsForKConsecutiveBlackBlocks {

	public static void main(String[] args) {
		String blocks = "WBBWWBB";
		//int k = 7; // Output: 3
		int k = 5; // Output: 2
		MinimumRecolorsForKConsecutiveBlackBlocks solution = new MinimumRecolorsForKConsecutiveBlackBlocks();
		int result = solution.minimumRecolors(blocks, k);
		System.out.println("Minimum recolors needed: " + result);
	}
	public int minimumRecolors(String blocks, int k) {
		int currWhite = 0;

		//Initialize the window
		for(int i = 0; i< k; i++){
			if(blocks.charAt(i)=='W'){
				currWhite++;
			}
		}
		int minWhite = currWhite;

		//Sliding the window
		for(int i = k; i < blocks.length(); i++){
			if(blocks.charAt(i)=='W') currWhite++;
			if(blocks.charAt(i-k)=='W') currWhite--;

			minWhite = Math.min(minWhite, currWhite);
		}

		return minWhite;
	}
}