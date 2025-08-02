package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 953 - Verifying an Alien Dictionary
 * Time complexity: O(n * m) - where n is the number of words and m is the average length of the words.
 * Space complexity: O(1) - since the order string has a fixed length of 26 characters.
 * Topics: Array, HashMap Table
 * <p>
 * Description:
 * In an alien language, surprisingly they also use English lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographically in this alien language.
 * <p>
 * Link: https://leetcode.com/problems/verifying-an-alien-dictionary/
 **/
public class VerifyingAlienDictionary {

	public static void main(String[] args) {
		String[] words = {"hello", "leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words, order)); // Output: true

		String[] words2 = {"word", "world", "row"};
		String order2 = "worldabcefghijkmnpqstuvxyz";
		System.out.println(isAlienSorted(words2, order2)); // Output: false
	}
	private static boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> orderMap = new HashMap<>();
		for(int i = 0; i < order.length(); i++){
			orderMap.put(order.charAt(i), i);
		}

		for(int i = 0; i < words.length - 1; i++){
			if(!inCorrectOrder(words[i], words[i+1], orderMap)){
				return false;
			}
		}

		return true;
	}

	private static boolean inCorrectOrder(String word1, String word2, Map<Character, Integer> orderMap){
		int len = Math.min(word1.length(), word2.length());
		for(int i = 0; i < len; i++){
			char c1 = word1.charAt(i);
			char c2 = word2.charAt(i);
			if(c1!=c2){
				return orderMap.get(c1) < orderMap.get(c2);
			}
		}
		//If we reach here, all characters are the same up to len
		return word1.length() < word2.length();
	}
}