package easy.done;

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
		System.out.println(isAlienSortedStream(words2, order2)); // Output: false
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

	private static boolean isAlienSortedStream(String[] words, String order) {
		Map<Character, Integer> rankMap = new HashMap<>();
		// 1. Create and fill the rank map
		java.util.stream.IntStream
				.range(0, order.length())
				.forEach(i -> rankMap.put(order.charAt(i), i));

		return java.util.stream.IntStream
				.range(0, words.length - 1)
				.allMatch(i -> isOrdered(words[i], words[i+1], rankMap));
	}

	private static boolean isOrdered(String word1, String word2, Map<Character, Integer> rank){
		int n = Math.min(word1.length(), word2.length());
		for(int i = 0; i < n; i++){
			char c1 = word1.charAt(i);
			char c2 = word2.charAt(i);
			if(c1 != c2){
				return rank.get(c1) < rank.get(c2);
			}
		}

		// this works because math logic of lexicographical order
		// e.g. "apple" is before "applepie" because "apple" is a prefix of "applepie"
		// and shorter word is always before the longer word
		// if all characters are the same up to n, then the shorter word should come first, and n is the min length
		return word1.length() == n;
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