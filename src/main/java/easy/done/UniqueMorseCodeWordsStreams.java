package easy.done;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 804 - Unique Morse Code Words with Streams
 * Topics: String, Hash Table, Math, Char manipulation, Streams
 * <p>
 * Description:
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 * as follows:
 * <p>
 * 'a' maps to ".-", 'b' maps to "-...", 'c' maps to "-.-.", and so on.
 * <p>
 * For example, the encoded representation of "cab" is "-.-..--".
 * <p>
 * Now, given a list of words, each word can be represented as a concatenation of the Morse code of each letter.
 * We need to find out how many different representations of Morse code exist in the given list.
 * <p>
 * Time complexity: O(n * m), where n is the number of words and m is the average length of the words.
 * Space complexity: O(n), where n is the number of unique Morse code representations.
 * <p>
 * Link: https://leetcode.com/problems/unique-morse-code-words/
 */
public class UniqueMorseCodeWordsStreams {

	private static final String[] MORSE_CODES = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
			".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
			"...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	public static void main(String[] args) {
		// Example usage
		String[] words = { "gin", "zen", "gig", "msg" };
		int result = new UniqueMorseCodeWordsStreams().uniqueMorseRepresentations(words);
		System.out.println("Number of unique Morse code representations: " + result); // result = 2
	}

	private int uniqueMorseRepresentations(String[] words) {
		return Arrays.stream(words)
				.map(word -> word.chars()
						// Convert each character to its Morse code representation
						.mapToObj(c -> MORSE_CODES[c - 'a'])
						.collect(Collectors.joining()))
				.collect(Collectors.toSet())
				.size();
	}
}