package easy.done;

/**
 * LeetCode Problem 482 - License Key Formatting
 * Topics: String
 * Time Complexity: O(n) - where n is the length of the string s, as we traverse the string once to clean it and once to format it.
 * Space Complexity: O(n) - for the StringBuilder used to build the cleaned and formatted license key.
 *
 * Description:
 * You are given a license key represented as a string s that consists only alphanumeric characters and dashes.
 * The string is separated into n + 1 groups by dashes. You are also given an integer k.
 * We want to reformat the string s such that each group contains exactly k characters,
 * except for the first group, which could be shorter than k but still must contain at least one character.
 * The groups are separated by a dash '-'.
 *
 * Link: https://leetcode.com/problems/license-key-formatting/
 */
public class LicenseKeyFormatting {

	public static void main(String[] args) {
		String s = "5F3Z-2e-9-w";
		int k = 3;
		String formattedKey = licenseKeyFormatting(s, k);
		System.out.println("Formatted License Key: " + formattedKey);
	}
	private static String licenseKeyFormatting(String s, int k) {
		StringBuilder clean = new StringBuilder();
		for(char c : s.toCharArray()){
			if(c != '-'){
				clean.append(Character.toUpperCase(c));
			}
		}

		int count = 0;
		StringBuilder result = new StringBuilder();
		//Build the result in reverse
		for(int i = clean.length()-1; i>=0; i--){
			if(count==k){
				result.append('-');
				count = 0;
			}

			result.append(clean.charAt(i));
			count++;
		}

		return result.reverse().toString();
	}
}
