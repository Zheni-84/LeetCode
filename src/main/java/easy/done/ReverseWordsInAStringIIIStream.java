package easy.done;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 557 - Reverse Words in a String III
 * Topics: String
 * Time complexity: O(n) - where n is the length of the input string.
 * Space complexity: O(n) - where n is the length of the input string.
 * <p>
 * Description:
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 **/
public class ReverseWordsInAStringIIIStream {


	public static void main(String[] args) {
		// Example usage
		String s = "Let's take LeetCode contest";
		String result = reverseWords(s);
		System.out.println("Reverse words in a string III: " + result); // result = "s'teL ekat edoCteeL tsetnoc"
	}

	private static String reverseWords(String s) {
		String[] words = s.split("\\s+");

		return Arrays.stream(words)
				.map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.joining(" "));
	}
}