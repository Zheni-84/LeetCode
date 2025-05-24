package easy.done;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem 804 - Unique Morse Code Words
 * Topics: String, Hash Table, Math, Char manipulation
 * <p>
 * Description:
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 * e.g., 'a' maps to ".-", 'b' maps to "-...", etc. For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",
 * ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
 * "...","-","..-","...-",".--","-..-","-.--","--.."]
 * <p>
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cab" can be written as "-.-..--", which is the concatenation of "-.-.", ".-", and "-...".
 * We will call such a concatenation the transformation of a word.
 * <p>
 * Time complexity: O(n * m), where n is the number of words and m is the average length of the words.
 * Space complexity: O(n), where n is the number of unique Morse code representations.
 * <p>
 * Return the number of different transformations among all words we have.
 * LeetCode Link: https://leetcode.com/problems/unique-morse-code-words/
 */
public class UniqueMorseCodeWords {

	public static void main(String[] args) {
		// Example usage
		String[] words = {"gin", "zen", "gig", "msg"};
		int result = uniqueMorseRepresentations(words);
		System.out.println("Number of unique Morse code representations: " + result);
	}

	private static int uniqueMorseRepresentations(String[] words) {
		String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
				".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
				"...","-","..-","...-",".--","-..-","-.--","--.."};

		// Using a HashSet to store unique Morse code transformations
		Set<String> transformations = new HashSet<>();
		for (String word : words) {
			StringBuilder transformation = new StringBuilder();
			for(char c : word.toCharArray()) {
				// Convert each character to its corresponding Morse code
				// 'a' is 97 in ASCII, so we subtract 97 to get the index
				// of the Morse code for the character
				// For example: 'a' = 97, 'b' = 98, 'c' = 99, ..., 'z' = 122
				// So, 'a' - 'a' = 0, 'b' - 'a' = 1, 'c' - 'a' = 2, ..., 'z' - 'a' = 25
				transformation.append(morseCodes[c - 'a']);
			}
			transformations.add(transformation.toString());
		}

		return transformations.size();
	}
}