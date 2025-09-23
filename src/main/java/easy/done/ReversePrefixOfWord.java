package easy.done;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem: 2000. Reverse Prefix of Word
 * Space: O(n)
 * Time: O(n)
 * Topics: String, Stack, Stream
 * You are given a 0-indexed string word and a character ch.
 * Reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
 * If the character ch does not exist in word, do nothing.
 * Return the resulting string.
 * <p>
 * Example:
 * Input: word = "abcdefd", ch = "d"
 * Output: "dcbaefd"
 * Hint: Find the index of the first occurrence of ch and reverse the substring up to that index.
 * http://leetcode.com/problems/reverse-prefix-of-word/
 */
public class ReversePrefixOfWord {

	public static void main(String[] args) {
		System.out.println(reversePrefix("abcdefd", 'd')); // Output: "dcbaefd"
		System.out.println(reversePrefixStack("xyxzxe", 'z')); // Output: "zxyxxe"
		System.out.println(reversePrefix("abcd", 'z')); // Output: "abcd"
		System.out.println(reversePrefixStream("abcdefd", 'd')); // Output: "dcbaefd"
	}

	private static String reversePrefixStack(String word, char ch) {
		int index = word.indexOf(ch);
		if(index == -1) return word;

		Deque<Character> stack = new ArrayDeque<>();
		for(int i = 0; i <= index; i++){
			stack.push(word.charAt(i));
		}

		StringBuilder result = new StringBuilder();

		while(!stack.isEmpty()){
			result.append(stack.pop());
		}

		result.append(word.substring(index+1));

		return result.toString();
	}

	private static String reversePrefix(String word, char ch) {
		int index = word.indexOf(ch);
		if (index == -1) {
			return word;
		}

		String result = word.substring(0, index + 1);
		result = new StringBuilder(result).reverse().toString();

		return String.join("", result, word.substring(index + 1));
	}

	private static String reversePrefixStream(String word, char ch) {
		int idx = word.indexOf(ch);
		return idx == -1
				? word
				: new StringBuilder(word.substring(0, idx + 1))
				.reverse()
				.append(word.substring(idx + 1))
				.toString();
	}
}