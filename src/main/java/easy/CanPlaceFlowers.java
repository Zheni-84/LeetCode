package easy; /**
 * LeetCode Problem 605: Can Place Flowers
 * <p>
 * Description:
 * Given a flowerbed (represented as an array containing 0 and 1),
 * return if n new flowers can be planted without violating no-adjacent-flowers rule.
 */

/**
 * LeetCode Problem 605 - Can Place Flowers
 *
 * Description:
 * 	Determine if n new flowers can be planted in a flowerbed without violating the no-adjacent-flowers rule.
 * 	Given a flowerbed (represented as an array containing 0 and 1),
 *  return if n new flowers can be planted without violating no-adjacent-flowers rule.
 *
 * Link: https://leetcode.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

	public static void main(String[] args) {
		// Example usage
		int[] flowerbed = { 1, 0, 0, 0, 1 };
		int n = 1;
		boolean result = canPlaceFlowers(flowerbed, n);
		System.out.println(result); // Output: true
	}

	private static boolean canPlaceFlowers(int[] flowerBed, int n) {
		// Check if the flowerbed is empty or n is 0
		for (int i = 0; i < flowerBed.length; i++) {
			if (flowerBed[i] == 0) {
				// Is first bed or there is no flower on index i-1
				boolean isEmptyLeft = (i == 0) || (flowerBed[i - 1] == 0);
				// Is last bed or there is no flower on index i+1
				boolean isEmptyRight = (i == flowerBed.length - 1) || (flowerBed[i + 1] == 0);

				if (isEmptyLeft && isEmptyRight) {
					// We plant a flower!
					flowerBed[i] = 1;
					// decrease the total flowers unplanted
					n--;
					if (n <= 0) {
						return true;
					}
					// Skip the next index because it is adjasent to planted flower
					i++;
				}
			}
		}

		// Check if we planted all the flowers
		return n == 0;
	}
}