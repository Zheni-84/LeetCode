package easy.done;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 205: Isomorphic Strings
 * Time Complexity: O(n), where n is the length of the input strings.
 * Space Complexity: O(1), since we are using a fixed-size map for character mappings.
 * Topics: String, Hash Table
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of any valid ascii characters.
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		String s1 = "egg";
		String t1 = "add";
		System.out.println("Are \"" + s1 + "\" and \"" + t1 + "\" isomorphic? " + isIsomorphic1(s1, t1)); // true

		String s2 = "foo";
		String t2 = "bar";
		System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" isomorphic? " + isIsomorphic1(s2, t2)); // false

		String s3 = "paper";
		String t3 = "title";
		System.out.println("Are \"" + s3 + "\" and \"" + t3 + "\" isomorphic? " + isIsomorphic2(s3, t3)); // true
	}

	private static boolean isIsomorphic1(String s, String t) {
		Map<Character, Character> st = new HashMap<>();
		Map<Character, Character> ts = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i), c2 = t.charAt(i);

			st.putIfAbsent(c1, c2);
			ts.putIfAbsent(c2, c1);

			if (st.get(c1) != c2 || ts.get(c2) != c1) return false;
		}
		return true;
	}

	private static boolean isIsomorphic2(String s, String t) {

		if(s.length()!=t.length()){
			return false;
		}
		// Maps to store character mappings from s to t and t to s
		Map<Character, Character> stMap = new HashMap<>();
		Map<Character, Character> tsMap = new HashMap<>();

		for(int i = 0; i < s.length(); i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			// Check the mapping from s to t
			if(stMap.containsKey(c1)){
				if(stMap.get(c1) != c2){
					return false;
				}
			}else{
				// If c1 is not mapped yet, map it to c2
				stMap.put(c1, c2);
			}

			// Check the reverse mapping
			if(tsMap.containsKey(c2)){
				if(tsMap.get(c2) != c1){
					return false;
				}
			}else{
				// If c2 is not mapped yet, map it to c1
				tsMap.put(c2, c1);
			}
		}

		return true;
	}
}