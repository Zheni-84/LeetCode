package easy.done;

import java.util.List;

/**
 * LeetCode 1773 - Count Items Matching a Rule
 * Space: O(n)
 * Time: O(1)
 * Topics: Array, String, Hash Table, Counting
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
 * The ith item is said to match the rule if one of the following is true:
 * - ruleKey == "type" and ruleValue == typei.
 * - ruleKey == "color" and ruleValue == colori.
 * - ruleKey == "name" and ruleValue == namei.
 * 	Return the number of items that match the given rule.
 * 	http://leetcode.com/problems/count-items-matching-a-rule/
 */
public class CountItemsMatchingRule {

	public static void main(String[] args) {
		String[][] items = {
				{ "phone", "blue", "pixel" },
				{ "computer", "silver", "lenovo" },
				{ "phone", "gold", "iphone" }
		};

		System.out.println(countMatchesArray(items, "type", "phone")); // Output: 2
		System.out.println(countMatchesArray(items, "color", "silver")); // Output: 1
		System.out.println(countMatchesArray(items, "name", "pixel")); // Output: 1

		List<List<String>> itemsList = List.of(
				List.of("phone", "blue", "pixel"),
				List.of("computer", "silver", "lenovo"),
				List.of("phone", "gold", "iphone")
		);

		System.out.println(countMatchesStreams(itemsList, "type", "phone")); // Output: 2
		System.out.println(countMatchesStreams(itemsList, "color", "silver")); // Output: 1
		System.out.println(countMatchesStreams(itemsList, "name", "pixel")); // Output: 1
	}

	private static int countMatchesStreams(List<List<String>> items, String ruleKey, String ruleValue) {
		int keyIndex = "type".equals(ruleKey) ? 0 : "color".equals(ruleKey) ? 1 : 2;

		return (int) items.stream()
				.filter(item -> item.get(keyIndex).equals(ruleValue))
				.count();
	}

	private static int countMatchesList(List<List<String>> items, String ruleKey, String ruleValue) {
		int keyIndex = 0;
		if (ruleKey.equals("color"))
			keyIndex = 1;
		else if (ruleKey.equals("name"))
			keyIndex = 2;

		int count = 0;
		for (List<String> item : items) {
			if (item.get(keyIndex).equals(ruleValue)) {
				count++;
			}
		}
		return count;
	}

	private static int countMatchesArray(String[][] items, String ruleKey, String ruleValue) {
		int count = 0;
		int ruleIndex;

		switch (ruleKey) {
			case "type":
				ruleIndex = 0;
				break;
			case "color":
				ruleIndex = 1;
				break;
			case "name":
				ruleIndex = 2;
				break;
			default:
				return 0; // Invalid ruleKey
		}

		for (String[] item : items) {
			if (item[ruleIndex].equals(ruleValue)) {
				count++;
			}
		}

		return count;
	}
}