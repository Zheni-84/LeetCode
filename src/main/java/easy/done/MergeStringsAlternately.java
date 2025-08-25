package easy.done;

/**
 * LeetCode Problem 1768 - Merge Strings Alternately
 * Topics: String
 * Time Complexity: O(n), where n is the length of the longer string.
 * Space Complexity: O(n), where n is the length of the merged string.
 * <p>
 * Description:
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 * LeetCode Link: https://leetcode.com/problems/merge-strings-alternately/
 */
public class MergeStringsAlternately {

	public static void main(String[] args) {
		String word1 = "abcde";
		String word2 = "pqr";
		String result = mergeAlternately2(word1, word2);
		// Output: "apbqcr"
		System.out.println("Merged string: " + result);
	}

	private static String mergeAlternately(String word1, String word2) {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		int len1 = word1.length();
		int len2 = word2.length();
		// Iterate through both strings until the end of the longer one
		while (i < len1 || i < len2) {
			// Append character from word1 if available
			if (i < len1) {
				builder.append(word1.charAt(i));
			}
			// Append character from word2 if available
			if (i < len2) {
				builder.append(word2.charAt(i));
			}
			i++;
		}

		return builder.toString();
	}

	public static String mergeAlternately2(String word1, String word2) {
		int i = 0;
		StringBuilder result = new StringBuilder();
		while(i < word1.length() && i < word2.length()){
			result.append(word1.charAt(i));
			result.append(word2.charAt(i));
			i++;
		}
		if(i < word1.length()-1){
			String leftWord = word1.substring(i, word1.length());
			result.append(leftWord);
		}
		if(i < word2.length()){
			String leftWord = word2.substring(i, word2.length());
			result.append(leftWord);
		}

		return result.toString();
	}
}