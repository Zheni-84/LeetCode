package easy.done;


/* LeetCode Problem 441: Arranging Coins
   Time Complexity: O(sqrt(n)) for the iterative approach, O(log n) for the binary search approach.
   Space Complexity: O(1)
   Topic: Math, Binary Search
   This class provides methods to determine the number of complete rows of coins that can be formed with a given number of coins.
   The main method demonstrates the usage of the arrangeCoins methods.

   Hint: Use the formula for the sum of the first k natural numbers to find the maximum k such that k(k+1)/2 <= n.
   https://leetcode.com/problems/arranging-coins/
*/
public class ArrangingCoins {

	public static void main(String[] args) {
		int n = 8;
		System.out.println("Number of complete rows that can be formed: " + arrangeCoins(n));
		System.out.println("Number of complete rows that can be formed (Binary Search): " + arrangeCoinsBinarySearch2(n));
		n = 3;
		System.out.println("Number of complete rows that can be formed: " + arrangeCoins(n));
		System.out.println("Number of complete rows that can be formed (Binary Search): " + arrangeCoinsBinarySearch(n));
		System.out.println("Number of complete rows that can be formed (Binary Search 2): " + arrangeCoinsBinarySearch2(n));
		n = 1;
		System.out.println("Number of complete rows that can be formed: " + arrangeCoins(n));
		System.out.println("Number of complete rows that can be formed (Binary Search): " + arrangeCoinsBinarySearch2(n));
		n = 100000;
		System.out.println("Number of complete rows that can be formed: " + arrangeCoins(n));
		System.out.println("Number of complete rows that can be formed (Binary Search): " + arrangeCoinsBinarySearch(n));
		System.out.println("Number of complete rows that can be formed (Binary Search 2): " + arrangeCoinsBinarySearch2(n));
	}

	//Binary Search approach
	//Time Complexity: O(log n)
	//Space Complexity: O(1)
	private static int arrangeCoinsBinarySearch(int n) {
		long left = 0, right = n;
		while (left <= right) {
			long mid = (left + right) / 2;
			long curr = mid * (mid + 1) / 2;
			if (curr == n) {
				return (int) mid;
			} else if (curr < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return (int) right;
	}

	private static int arrangeCoinsBinarySearch2(int n) {
		// Edge cases
		if (n < 3) {
			return 1;
		}
		long l = 0;
		// Maximum possible rows cannot be more than n/2
		long r = n / 2 + 1;
		while (l<=r) {
			long mid = (l + r) / 2;
			long sum = mid * (mid + 1) / 2;
			if (sum == n)
				return (int) mid;
			if (sum < n)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return (int) r;
	}

	//Math approach: n = k(k+1)/2 -> k^2 + k - 2n = 0
	//Using quadratic formula: k = (-1 + sqrt(1 + 8n)) / 2
	//Time Complexity: O(1)
	//Space Complexity: O(1)
	private static int arrangeCoins(int n) {
		int row = 0;
		while (n >= row + 1) {
			row++;
			n -= row;
		}
		return row;
	}
}
