package easy.done;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode Problem 387: First Unique Character in a String
 * Solutions:
 * 1. Using HashMap to count occurrences
 * 2. Using frequency array
 * 3. Using frequency array and queue
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)/O(n) depending on the approach used
 * Topics: Index array, String, HashMap, Queue
 * <p>
 * Given a string, find the index of the first non-repeating character in it.
 * If it doesn't exist, return -1.
 * <p>
 * Example:
 * Input: "leetcode"
 * Output: 0 (the first unique character is 'l')
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		String s = "leetcode";
		int index = firstUniqChar(s);
		if (index != -1) {
			System.out.println("The first unique character is at index: " + index);
		} else {
			System.out.println("No unique character found.");
		}
	}

	// Using frequency array and queue
	// Time Complexity: O(n)
	// Space Complexity: O(1) since the frequency array size is fixed (26 for lowercase letters), for queue O(n) in worst case - all characters are unique
	public int firstUniqCharQueue(String s) {
		int[] freq = new int[26];
		Queue<Integer> queue = new LinkedList<>();

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			// Increment the frequency of the character
			freq[c - 'a']++;
			// Add the index of the character to the queue
			queue.offer(i);

			// Remove indices of characters that are no longer unique
			while(!queue.isEmpty() && freq[s.charAt(queue.peek()) - 'a'] > 1){
				queue.poll();
			}
		}

		// If the queue is empty, there are no unique characters
		// Otherwise, the front of the queue is the index of the first unique character
		return queue.isEmpty() ? -1 : queue.peek();
	}

	// Using frequency array
	// Time Complexity: O(n)
	// Space Complexity: O(1) since the frequency array size is fixed (26 for lowercase letters)
	private static int firstUniqChar(String s) {
		// Assuming the string contains only lowercase letters a-z
		int[] count = new int[26];

		// Count the occurrences of each character
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		// Iterate through the string again to find the first unique character
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// Check if the character count is 1
			if (count[c - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}

	// Using HashMap to count occurrences
	// Time Complexity: O(n)
	// Space Complexity: O(n) in the worst case if all characters are unique
	private static int firstUniqCharHashMap(String s) {
		// Using a HashMap to count occurrences
		Map<Character, Integer> charCount = new HashMap<>();

		// Count the occurrences of each character
		for (char c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		// Iterate through the string again to find the first unique character
		for (int i = 0; i < s.length(); i++) {
			if (charCount.get(s.charAt(i)) == 1) {
				return i;
			}
		}

		return -1;
	}
}