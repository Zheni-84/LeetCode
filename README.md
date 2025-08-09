# LeetCode Problems

This repository contains my solutions to LeetCode problems in Java.

---
<!-- TOC -->
* [LeetCode Problems](#leetcode-problems)
  * [📝 Problem List](#-problem-list)
    * [Easy Problems](#easy-problems)
    * [Medium Problems](#medium-problems)
    * [Hard Problems](#hard-problems)
  * [🚀 How I solve problems](#-how-i-solve-problems)
  * [✏️ Notes](#-notes)
  * [🛠 Git Workflow Reminder](#-git-workflow-reminder)
  * [📈 Goals](#-goals)
  * [📚 Useful Resources](#-useful-resources)
  * [📧 Contact](#-contact)
<!-- TOC -->

## 📝 Problem List

### Easy Problems

|    # |                           Problem                            |                       Topics                       |                                        Solution                                        |
|-----:|:------------------------------------------------------------:|:--------------------------------------------------:|:--------------------------------------------------------------------------------------:|
|   13 |                       Roman to Integer                       |              String, Hash Table, Math              |                [Java Code](src/main/java/easy/done/RomanToInteger.java)                |
|   14 |                    Longest Common Prefix                     | String, Array, Divide and Conquer, String Matching |             [Java Code](src/main/java/easy/done/LongestCommonPrefix.java)              |
|   20 |                      Valid Parentheses                       |             Stack, String, Hash Table              |               [Java Code](src/main/java/easy/done/ValidParentheses.java)               |
|   28 |      Find the Index of the First Occurrence in a String      |       String, String Matching, Two Pointers        |      [Java Code](src/main/java/easy/done/FindIndexOfFirstOccurrenceInString.java)      |
|   58 |                     Length of Last Word                      |              String, String Matching               |               [Java Code](src/main/java/easy/done/LengthOfLastWord.java)               |
|   66 |                           Plus one                           |                    Array, Math                     |                   [Java Code](src/main/java/easy/done/PlusOne.java)                    |
|   67 |                      Add Binary Strings                      |           String, Math, Bit Manipulation           |               [Java Code](src/main/java/easy/done/AddBinaryStrings.java)               |
|  125 |                       Valid Palindrome                       |                Two Pointers, String                |               [Java Code](src/main/java/easy/done/ValidPalindrome.java)                |
|  133 |                Reverse Words in a String III                 |                  String, Streams                   |               [Java Code](src/main/java/easy/done/ReverseWordsIII.java)                |
|  136 |                        Single Number                         |              Arrays, Bit Manipulation              |                 [Java Code](src/main/java/easy/done/SingleNumber.java)                 |
|  168 |                   Excel Sheet Column Title                   |                    String, Math                    |            [Java Code](src/main/java/easy/done/ExcelSheetColumnTitle.java)             |
|  205 |                      Isomorphic Strings                      |                 String, Hash Table                 |              [Java Code](src/main/java/easy/done/IsomorphicStrings.java)               |
|  219 |                    Contains Duplicate II                     |                   Array, HashMap                   |              [Java Code](src/main/java/easy/done/ContainsDuplicate2.java)              |
|  242 |                        Valid Anagram                         |            String, Hash Table, Sorting             |                 [Java Code](src/main/java/easy/done/ValidAnagram.java)                 |
|  290 |                         Word Pattern                         |                 String, Hash Table                 |                 [Java Code](src/main/java/easy/done/WordPattern.java)                  |
|  382 |                    License Key Formatting                    |                       String                       |             [Java Code](src/main/java/easy/done/LicenseKeyFormatting.java)             |
|  383 |                         Ransom Note                          |                 String, Hash Table                 |                  [Java Code](src/main/java/easy/done/RansomNote.java)                  |
|  387 |              First Unique Character in a String              |           Index array, String, Counting            |         [Java Code](src/main/java/easy/done/FirstUniqueCharacterInString.java)         |
|  392 |                        Is Subsequence                        |                Two Pointers, String                |                [Java Code](src/main/java/easy/done/IsSubsequence.java)                 |
|  392 |                  Is Subsequence (Optimized)                  |               String, Binary Search                |            [Java Code](src/main/java/easy/done/IsSubsequenceOptimized.java)            |
|  409 |                      Longest Palindrome                      |                       String                       |              [Java Code](src/main/java/easy/done/LongestPalindrome.java)               |
|  414 |                     Third Maximum Number                     |                       String                       |              [Java Code](src/main/java/easy/done/ThirdMaximumNumber.java)              |
|  434 |                Number of Segments in a String                |              Arrays, Sorting, TreeSet              |           [Java Code](src/main/java/easy/done/NumberOfSegmentsInString.java)           |
|  455 |                        Assign Cookies                        |               Array, Sorting, Greedy               |                [Java Code](src/main/java/easy/done/AssignCookies.java)                 |
|  459 |                  Repeated Substring Pattern                  |                       String                       |           [Java Code](src/main/java/easy/done/RepeatedSubstringPattern.java)           |
|  463 |                        Assign Cookies                        |              Array, DFS, BFS, Matrix               |               [Java Code](src/main/java/easy/done/IslandPerimeter.java)                |
|  495 |                       Teemo Attacking                        |                   Array, Greedy                    |                [Java Code](src/main/java/easy/done/TeemoAttacking.java)                |
|  496 |                    Next Greater Element I                    |     Array, Hash Table, Stack, Monotonic Stack      |             [Java Code](src/main/java/easy/done/NextGreaterElement1.java)              |
|  506 |                        Relative Ranks                        |       Array, Sorting, Heap (Priority Queue)        |                [Java Code](src/main/java/easy/done/RelativeRanks.java)                 |
|  521 |                Longest Uncommon Subsequence I                |                       String                       |         [Java Code](src/main/java/easy/done/LongestUncommonSubsequenceI.java)          |
|  541 |                      Reverse String II                       |                       String                       |               [Java Code](src/main/java/easy/done/ReverseStringII.java)                |
|  557 |                Reverse Words in a String III                 |                String, Two Pointers                |           [Java Code](src/main/java/easy/done/ReverseWordsInAStringIII.java)           |
|  557 |         Reverse Words in a String III (**Streams**)          |           String, Stream, StringBuilder            |        [Java Code](src/main/java/easy/done/ReverseWordsInAStringIIIStream.java)        |
|  594 |                Longest Harmonious Subsequence                |                 Array, Hash Table                  |         [Java Code](src/main/java/easy/done/LongestHarmoniousSubsequence.java)         |
|  599 |                Minimum Index Sum of Two Lists                |             Array, Hash Table, String              |           [Java Code](src/main/java/easy/done/MinimumIndexSumTwoLists.java)            |
|  661 |                        Image Smoother                        |                   Array, Matrix                    |                [Java Code](src/main/java/easy/done/ImageSmoother.java)                 |
|  605 |                      Can Place Flowers                       |                   Array, Greedy                    |               [Java Code](src/main/java/easy/done/CanPlaceFlowers.java)                |
|  643 |                  Maximum Average Subarray I                  |               Array, Sliding Window                |           [Java Code](src/main/java/easy/done/MaximumAverageSubarrayI.java)            |
|  657 |                    Robot Return to Origin                    |                 String, Simulation                 |             [Java Code](src/main/java/easy/done/RobotReturnToOrigin.java)              |
|  674 |          Longest Continuous Increasing Subsequence           |                       Array                        |         [Java Code](src/main/java/easy/done/LongestContinuousSubsequence.java)         |
|  680 |                     Valid Palindrome II                      |            Two Pointers, String, Greedy            |               [Java Code](src/main/java/easy/done/ValidPalindrome2.java)               |
|  680 |              Valid Palindrome II (**Streams**)               |       Two Pointers, String, Greedy, Streams        |           [Java Code](src/main/java/easy/done/ValidPalindrome2Streams.java)            |
|  733 |                          Flood Fill                          |              Array, DFS, BFS, Matrix               |                  [Java Code](src/main/java/easy/done/FloodFill.java)                   |
|  766 |                       Toeplitz Matrix                        |                   Array, Matrix                    |                [Java Code](src/main/java/easy/done/ToeplitzMatrix.java)                |
|  796 |                        Rotate String                         |                       String                       |                 [Java Code](src/main/java/easy/done/RotateString.java)                 |
|  804 |                   Unique Morse Code Words                    |             Array, Hash Table, String              |             [Java Code](src/main/java/easy/done/UniqueMorseCodeWords.java)             |
|  804 |            Unique Morse Code Words (**Streams**)             |         Array, Hash Table, String, Streams         |         [Java Code](src/main/java/easy/done/UniqueMorseCodeWordsStreams.java)          |
|  819 |                       Most Common Word                       |            String, Hash Table, Counting            |                [Java Code](src/main/java/easy/done/MostCommonWord.java)                |
|  830 |                  Positions of Large Groups                   |                String, Two Pointers                |            [Java Code](src/main/java/easy/done/PositionsOfLargeGroups.java)            |
|  844 |                   Backspace String Compare                   |                String Manipulation                 |            [Java Code](src/main/java/easy/done/BackspaceStringCompare.java)            |
|  867 |                       Transpose Matrix                       |                   Array, Matrix                    |               [Java Code](src/main/java/easy/done/TransposeMatrix.java)                |
|  883 |                 Projection Area of 3D Shapes                 |                   Array, Matrix                    |            [Java Code](src/main/java/easy/done/ProjectionArea3DShapes.java)            |
|  884 |              Uncommon Words from Two Sentences               |            HashMap, String Manipulation            |        [Java Code](src/main/java/easy/done/UncommonWordsFromTwoSentences.java)         |
|  917 |                     Reverse Only Letters                     |                String, Two Pointers                |              [Java Code](src/main/java/easy/done/ReverseOnlyLetters.java)              |
|  941 |                     Valid Mountain Array                     |                Array, Two Pointers                 |              [Java Code](src/main/java/easy/done/ValidMountainArray.java)              |
|  942 |                       DI String Match                        |                   Array, Greedy                    |                [Java Code](src/main/java/easy/done/DIStringMatch.java)                 |
|  953 |                Verifying an Alien Dictionary                 |                Array, HashMap Table                |           [Java Code](src/main/java/easy/done/VerifyingAlienDictionary.java)           |
|  976 |                  Largest Perimeter Triangle                  |                   Array, Sorting                   |           [Java Code](src/main/java/easy/done/LargestPerimeterTriangle.java)           |
| 1002 |                    Find Common Characters                    |                Array, HashMap Table                |             [Java Code](src/main/java/easy/done/FindCommonCharacters.java)             |
| 1050 |                        Height Checker                        |                   Array, Sorting                   |                [Java Code](src/main/java/easy/done/HeightChecker.java)                 |
| 1071 |              Greatest Common Divisor of Strings              |                    String, Math                    |        [Java Code](src/main/java/easy/done/GreatestCommonDivisorOfStrings.java)        |
| 1154 |                       Day of the Year                        |                    String, Math                    |                 [Java Code](src/main/java/easy/done/DayOfTheYear.java)                 |
| 1160 |         Find Words That Can Be Formed by Characters          |                Array, HashMap Table                |     [Java Code](src/main/java/easy/done/FindWordsThatCanBeFormedByCharacters.java)     |
| 1295 |           Find Numbers with Even Number of Digits            |                  String, Pointers                  |        [Java Code](src/main/java/easy/done/NumbersWithEvenNumberOfDigits.java)         |
| 1380 |                  Lucky Numbers in a Matrix                   |                   Array, Matrix                    |             [Java Code](src/main/java/easy/done/LuckyNumbersInMatrix.java)             |
| 1413 |        Minimum Value to Get Positive Step by Step Sum        |                 Array, Prefix Sum                  |        [Java Code](src/main/java/easy/done/MinimumValueToPositiveStepSum.java)         |
| 1422 |            Maximum Score After Splitting a String            |                 String, Prefix Sum                 |       [Java Code](src/main/java/easy/done/MaximumScoreAfterSplittingString.java)       |
| 1436 |                       Destination City                       |                 Hash Table, String                 |               [Java Code](src/main/java/easy/done/DestinationCity.java)                |
| 1446 |                    Consecutive Characters                    |                       String                       |            [Java Code](src/main/java/easy/done/ConsecutiveCharacters.java)             |
| 1491 | Average Salary Excluding the Minimum <br/>and Maximum Salary |                   Array, Sorting                   |     [Java Code](src/main/java/easy/done/AverageSalaryExcludingMinimumMaximum.java)     |
| 1496 |                        Path Crossing                         |                 Hash Table, String                 |                 [Java Code](src/main/java/easy/done/PathCrossing.java)                 |
| 1524 |            Largest 3-Same-Digit Number in String             |                       String                       |       [Java Code](src/main/java/easy/done/Largest3SameDigitNumberInString.java)        |
| 1572 |                     Matrix Diagonal Sum                      |                Array, Matrix, Math                 |              [Java Code](src/main/java/easy/done/MatrixDiagonalSum.java)               |
| 1582 |             Special Positions in a Binary Matrix             |                   Array, Matrix                    |        [Java Code](src/main/java/easy/done/SpecialPositionsInBinaryMatrix.java)        |
| 1588 |               Sum of All Odd Length Subarrays                |                 Array, Prefix Sum                  |           [Java Code](src/main/java/easy/done/SumAllOddLengthSubarrays.java)           |
| 1614 |           Maximum Nesting Depth of the Parentheses           |                       String                       |       [Java Code](src/main/java/easy/done/MaximumNestingDepthOfParentheses.java)       |
| 1629 |                         Slowest Key                          |                   String, Array                    |                  [Java Code](src/main/java/easy/done/SlowestKey.java)                  |
| 1634 |                      Buy Two Chocolates                      |                   Array, Sorting                   |               [Java Code](src/main/java/easy/done/BuyTwoChocolates.java)               |
| 1652 |                       Defuse the Bomb                        |                       Array                        |                [Java Code](src/main/java/easy/done/DefuseTheBomb.java)                 |
| 1662 |          Check If Two String Arrays are Equivalent           |                String, Two Pointers                |        [Java Code](src/main/java/easy/CheckIfTwoStringArraysAreEquivalent.java)        |
| 1732 |                  Find the Highest Altitude                   |                 Array, Prefix Sum                  |             [Java Code](src/main/java/easy/done/FindHighestAltitude.java)              |
| 1758 |      Minimum Changes To Make Alternating Binary String       |                   String, Greedy                   | [Java Code](src/main/java/easy/done/MinimumChangesToMakeAlternatingBinaryString.java)  |
| 1763 |                    Longest Nice Substring                    |                String, Brute Force                 |             [Java Code](src/main/java/easy/done/LongestNiceSubstring.java)             |
| 1768 |                  Merge Strings Alternately                   |                   Array, Sorting                   |               [Java Code](src/main/java/easy/done/BuyTwoChocolates.java)               |
| 1773 |                 Count Items Matching a Rule                  |                   Array, String                    |            [Java Code](src/main/java/easy/done/CountItemsMatchingRule.java)            |
| 1876 |      Substrings of Size Three with Distinct Characters       |          String, Sliding Window, Hash Set          |    [Java Code](src/main/java/easy/done/SubstringsSizeThreeDistinctCharacters.java)     |
| 1903 |                 Largest Odd Number in String                 |                       String                       |           [Java Code](src/main/java/easy/done/LargestOddNumberInString.java)           |
| 1913 |         Maximum Product Difference Between Two Pairs         |                   Array, Sorting                   |   [Java Code](src/main/java/easy/done/MaximumProductDifferenceBetweenTwoPairs.java)    |
| 1984 |  Minimum Difference Between Highest and Lowest of K Scores   |           Array, Sorting, Sliding window           | [Java Code](src/main/java/easy/done/MinimumDifferenceBetweenHighestLowestKScores.java) |
| 2000 |                    Reverse Prefix of Word                    |                       Array                        |             [Java Code](src/main/java/easy/done/ReversePrefixOfWord.java)              |
| 2037 |           Minimum Number of Moves to Seat Everyone           |                   Array, Sorting                   |        [Java Code](src/main/java/easy/done/MinimumNumberMovesSeatEveryone.java)        |
| 2108 |          Find First Palindromic String in the Array          |                   Array, String                    |     [Java Code](src/main/java/easy/done/FindFirstPalindromicStringInTheArray.java)     |
| 2269 |                  Find K-Beauty of a Number                   |                    String, Math                    |             [Java Code](src/main/java/easy/done/FindKBeautyOfNumber.java)              |
| 2373 |               Largest Local Values in a Matrix               |                   Array, Matrix                    |          [Java Code](src/main/java/easy/done/LargestLocalValuesInMatrix.java)          |
| 2379 |      Minimum Recolors to Get K Consecutive Black Blocks      |               String, Sliding Window               |  [Java Code](src/main/java/easy/done/MinimumRecolorsForKConsecutiveBlackBlocks.java)   |
| 2760 |           Longest Even Odd Subarray with Threshold           |               Array, Sliding Window                |     [Java Code](src/main/java/easy/done/LongestEvenOddSubarrayWithThreshold.java)      |

---

### Medium Problems

|   # |      Problem Title       |               Topics               |                       Solution                       |
|----:|:------------------------:|:----------------------------------:|:----------------------------------------------------:|
|   2 |     Add Two Numbers      |                                    | [Java Code](src/main/java/medium/AddTwoNumbers.java) |
| 287 |Find the Duplicate Number | Array, Two Pointers, Binary Search | [Java Code](src/main/java/medium/FindDuplicate.java) |

---

### Hard Problems

|    # |      Problem Title       |                                  Topics                                   |                    Solution                     |
|-----:|:------------------------:|:-------------------------------------------------------------------------:|:-----------------------------------------------:|
|   41 |  First Missing Positive  |                                                                           | [Java Code](src/main/java/hard/FirstMissingPositive.java) |
| 1499 |  Max Value of Equation   | Array, Queue, Sliding Window, <br/>Heap (Priority Queue), Monotonic Queue | [Java Code](src/main/java/hard/MaxValueOfEquation.java) |

---

---

## 🚀 How I solve problems

- **Understand** the problem requirements
- **Break down** edge cases
- **Write** clean and efficient code
- **Refactor** if I find better approaches
- **Add** short explanations when needed

---

## ✏️ Notes

- Each solution has proper JavaDoc on top linking to the original problem.
- Clean, readable code using Java best practices (Streams, Optionals, Lambdas when appropriate).
- Commits follow a clean, descriptive template.

---

## 🛠 Git Workflow Reminder

Refer to [GIT_WORKFLOW.md](GIT_WORKFLOW.md) for a full guide on how to contribute and push new problems.

---

## 📈 Goals

- Solve 500+ LeetCode problems
- Focus on mastering Data Structures and Algorithms
- Improve Java coding standards for interviews and real-world applications

## 📚 Useful Resources

- [LeetCode](https://leetcode.com/)
- [Java 8+ Documentation](https://docs.oracle.com/javase/8/docs/api/)
- [Big-O Cheat Sheet](https://www.bigocheatsheet.com/)

---

## 📧 Contact

If you want to connect, discuss, or collaborate, feel free to reach out!