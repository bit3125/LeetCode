@author	lee

### Others

| No   | Title                                    | Difficulty | Completed | Comment                                  |
| ---- | ---------------------------------------- | ---------- | --------- | ---------------------------------------- |
| 34   | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array) |            | √         | BinarySearch                             |
| 771  | [Jewels and Stones](https://leetcode.com/problems/jewels-and-stones) | Easy       | √         | Hash                                     |
| 617  | [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees) | Easy       | √         | BinaryTree                               |
| 647  | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings) |            | √         | 二维DP                                     |
| 406  | [Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height) |            | √`        | Sort，分治法                                 |
| 98   | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) |            | √         | Tree                                     |
| 461  | [Hamming Distance](https://leetcode.com/problems/hamming-distance) |            | √         | Bit Manipulation                         |
| 560  | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k) |            | √, √`     | 自己想到了preSum On^2，看完hint后使用了TwoSum的HashMap进行优化 On |
| 494  | [Target Sum](https://leetcode.com/problems/target-sum) |            | √         | 2d-DP，与剑指offer掷骰子可比较。本题很典型，多看自己写的算法分析    |
|      |                                          |            |           |                                          |
|      |                                          |            |           |                                          |
|      |                                          |            |           |                                          |
|      |                                          |            |           |                                          |



### Summary

- 掷骰子DP

  以后看到两种特点可以考虑使用类骰子DP：

  1.求数组中各种取值的组合，复杂度达到O(2^n)的

  2.给出数组中每个数的取值上限，甚至给出数组长度上限的，90%是要用这个方法了

  =>使用dp[i][j]，表示前i个数的某种和取到j值的某种量

  ​


### Array

| No       | Title                                    | Difficulty | Completed | Comment                                  |
| -------- | ---------------------------------------- | ---------- | --------- | ---------------------------------------- |
| 55       | [Jump Game](https://leetcode.com/problems/jump-game) |            | √`        | 亦可回溯                                     |
| 11       | [Container With Most Water](https://leetcode.com/problems/container-with-most-water) |            | √`        |                                          |
| 42       | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water) | Hard       | √         | 写了OnOn，最优为OnO1                           |
| 128      | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence) | Hard       | √         | 用HashMap实现Tn=On，但是100ms。最优解用HashSet实现Tn=On，但是5ms+-。可能虽然复杂度一样但是HashMap有很多多余开销吧 |
| 287      | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number) |            | √         | 剑指offer原题                                |
| 4        | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays) | Hard       | √         |                                          |
| Interval |                                          |            |           |                                          |
| 56       | [Merge Intervals](https://leetcode.com/problems/merge-intervals) |            | √         |                                          |
| 253      | [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii) |            |           | 付费                                       |
| Counter  |                                          |            |           |                                          |
| 239      | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum) | Hard       | TODO      |                                          |
| 238      | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self) |            | √         |                                          |
| Sort     |                                          |            |           |                                          |
| 75       | [Sort Colors](https://leetcode.com/problems/sort-colors) |            | √         | HashSort/奇偶列首尾指针法                        |
| 283      | [Move Zeroes](https://leetcode.com/problems/move-zeroes) |            | √         | HashSort                                 |
|          |                                          |            |           |                                          |




### Binary Search

| No   | Title                                    | Difficulty | Completed | Comment                      |
| ---- | ---------------------------------------- | ---------- | --------- | ---------------------------- |
| 33   | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array) |            | √         | 可基于剑指offer No11              |
| 34   | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array) |            | √         |                              |
| 300  | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence) |            | √,  `TODO | 实现了O(n^2)复杂度，O(nlogn)复杂度尚未理解 |
|      |                                          |            |           |                              |



### LinkedList

| No   | Title                                    | Difficulty | Completed | Comment |
| ---- | ---------------------------------------- | ---------- | --------- | ------- |
| 206  | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) | Easy       | √         |         |
| 141  | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | Easy       | √         |         |
| 19   | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list) |            | √         |         |
| 2    | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers) | Easy       | √         |         |
| 160  | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists) | Easy       | √         |         |
| 21   | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) | Easy       | √         |         |
| 234  | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list) | Easy       | √         |         |
| 142  | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii) |            | √         |         |
| 148  | [Sort List](https://leetcode.com/problems/sort-list) |            | √`        |         |
| 23   | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists) | Hard       | √         |         |
|      |                                          |            |           |         |


### Stack & PriorityQueue

| NO   | Title                                    | Difficulty | Completed | Comment                          |
| ---- | ---------------------------------------- | ---------- | --------- | -------------------------------- |
| 155  | [Min Stack](https://leetcode.com/problems/min-stack) | Easy       | √         |                                  |
| 394  | [Decode String](https://leetcode.com/problems/decode-string) |            | √         | 这里我是之前用递归做的，并没有用栈                |
| 84   | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram) | Hard       | √`        | 看完答案写出了类动规的方法，stack的解法边界条件还是处理不好 |
| 215  | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array) |            | √         | top-k问题皆可考虑使用heap窗口              |
| 347  | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements) |            | √         |                                  |
|      |                                          |            |           |                                  |



### String

| No          | Title                                    | Difficulty | Completed | Comment                  |
| ----------- | ---------------------------------------- | ---------- | --------- | ------------------------ |
| 49          | [Group Anagrams](https://leetcode.com/problems/group-anagrams) |            | √         | Solution3使用Hash的思想值得好好借鉴 |
| Substring   |                                          |            |           |                          |
| 76          | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring) | Hard       |           |                          |
| 3           | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) |            | √         |                          |
| Palindrome  |                                          |            |           |                          |
| 5           | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring) |            | √`        |                          |
| Parentheses |                                          |            |           |                          |
| 20          | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses) | Easy       | √         |                          |
| 22          | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses) |            | √         |                          |
| 32          | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses) | Hard       | √ , √`    | DP解自己写出，栈解看后写            |
| 301         | [Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses) | Hard       | TODO      | 确实有点难度，先搁着               |



### Math


| No   | Title                                    | Difficulty | Completed | Comment          |
| ---- | ---------------------------------------- | ---------- | --------- | ---------------- |
| 1    | [Two Sum](https://leetcode.com/problems/two-sum) |            | √`        | 好好看，多解，高频        |
| 15   | [3Sum](https://leetcode.com/problems/3sum) |            | √         | 也看下，似乎看了hint才写出来 |
|      |                                          |            |           |                  |



### Tree

| No   | Title                                    | Difficulty | Completed | Comment                                |
| ---- | ---------------------------------------- | ---------- | --------- | -------------------------------------- |
| 94   | [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal) |            | √         |                                        |
| 102  | [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal) |            | √         |                                        |
| 101  | [Symmetric Tree](https://leetcode.com/problems/symmetric-tree) | Easy       | √         |                                        |
| 226  | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree) | Easy       | √         |                                        |
| 104  | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree) | Easy       | √         |                                        |
| 124  | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum) | Hard       | √         | 树形动规                                   |
| 337  | [House Robber III](https://leetcode.com/problems/house-robber-iii) |            | √         |                                        |
| 236  | [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree) |            | √         | 各种debug了超久。。结果还不是最简解。。好好看看             |
| 297  | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree) | Hard       | √         | offer原题                                |
| 114  | [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list) |            | √         | 上面说很少考？跟那题变二叉树为双向链表的几乎一毛一样（好像是offer上的） |
| 105  | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal) |            | √         | 上面说很少考？                                |
| 96   | [Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees) |            | √`        | 本质是DP                                  |
|      |                                          |            |           |                                        |



### Union Find

None



### DFS&BFS

| No   | Title                                    | Difficulty | Completed | Comment    |
| ---- | ---------------------------------------- | ---------- | --------- | ---------- |
| 200  | [Number of Islands](https://leetcode.com/problems/number-of-islands) |            | √         | DFS计算连通分量数 |
|      |                                          |            |           |            |


### Graph

None



### Backtracking (与其叫回溯不如叫排列。。。)

| No          | Title                                    | Difficulty | Completed | Comment                                  |
| ----------- | ---------------------------------------- | ---------- | --------- | ---------------------------------------- |
| 78          | [Subsets](https://leetcode.com/problems/subsets) |            | √         | 组合，使用boolean标记数组，无回溯。                    |
| 39          | [Combination Sum](https://leetcode.com/problems/combination-sum) |            | √         | 无回溯。但是应该可用                               |
| 46          | [Permutations](https://leetcode.com/problems/permutations) |            | √         |                                          |
| 31          | [Next Permutation](https://leetcode.com/problems/next-permutation) |            | √         | 无回溯。                                     |
| 79          | [Word Search](https://leetcode.com/problems/word-search) |            | √         | 本质是backtracking-DFS。几乎两年没写了20min一遍过，太强了（啪啪啪） |
| Enumeration |                                          |            |           |                                          |
| 17          | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number) |            | √         | 无回溯。                                     |
|             |                                          |            |           |                                          |
|             |                                          |            |           |                                          |

注：79题被大佬错分到Matrix，明明是Backtracking 才对



### Dynamic Programming

| No   | Title                                    | Difficulty | Completed | Comment                                  |
| ---- | ---------------------------------------- | ---------- | --------- | ---------------------------------------- |
| 一维   |                                          |            |           |                                          |
| 70   | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs) | Easy       | √         |                                          |
| 62   | [Unique Paths](https://leetcode.com/problems/unique-paths) |            | √         |                                          |
| 279  | [Perfect Squares](https://leetcode.com/problems/perfect-squares) |            | √         | On^2非最优                                  |
| 139  | [Word Break](https://leetcode.com/problems/word-break) |            | √`        | 穷举与DP复杂度一样结果前者TLE后者AC                    |
| 312  | [Burst Balloons](https://leetcode.com/problems/burst-balloons) | Hard       |           |                                          |
| 322  | [Coin Change](https://leetcode.com/problems/coin-change) |            | √         | 贪心递归（与Q39同法）是错误的，该用完全背包（目标钱数就是恰好容量，求最小价值） |
|      |                                          |            |           |                                          |
| 二维   |                                          |            |           |                                          |
| 64   | [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum) |            | √         |                                          |
| 72   | [Edit Distance](https://leetcode.com/problems/edit-distance) | Hard       | √`        | 比较典型的题型，DP方向从大到小会方便很多，边界条件是个难点           |
| 221  | [Maximal Square](https://leetcode.com/problems/maximal-square) |            | √`        |                                          |
| 85   | [Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle) | Hard       |           |                                          |
|      |                                          |            |           |                                          |
| 化简   |                                          |            |           |                                          |
| 198  | [House Robber](https://leetcode.com/problems/house-robber) | Easy       | √         |                                          |
| 10   | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching) | Hard       |           |                                          |
| 其他   |                                          |            |           |                                          |
| 121  | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) |            | √         |                                          |
| 309  | [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown) |            | ?         |                                          |
| 152  | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray) |            | √         |                                          |
|      |                                          |            |           |                                          |

注：53题被大佬错分到Array，明明是DP 才对- -。还有121,309,152也是



### Matrix

| No   | Title                                    | Difficulty | Completed | Comment |
| ---- | ---------------------------------------- | ---------- | --------- | ------- |
| 48   | [Rotate Image](https://leetcode.com/problems/rotate-image) |            | √         |         |
| 240  | [Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii) |            | √         | offer原题 |
|      |                                          |            |           |         |



### Bit Manipulation

| No   | Title                                    | Difficulty | Completed | Comment                           |
| ---- | ---------------------------------------- | ---------- | --------- | --------------------------------- |
| 136  | [Single Number](https://leetcode.com/problems/single-number) | Easy       | √         | offer原题                           |
| 338  | [Counting Bits](https://leetcode.com/problems/counting-bits) |            | √`        | 很少考？<br> 想到了O(n^2)的解，没想到使用DP的On的解 |
|      |                                          |            |           |                                   |


### Topological Sort

| No   | Title                                    | Difficulty | Completed | Comment |
| ---- | ---------------------------------------- | ---------- | --------- | ------- |
| 207  | [Course Schedule](https://leetcode.com/problems/course-schedule) |            |           |         |
|      |                                          |            |           |         |

### Random

None

### Design

| No   | Title                                    | Difficulty | Completed | Comment |
| ---- | ---------------------------------------- | ---------- | --------- | ------- |
| 146  | [LRU Cache](https://leetcode.com/problems/lru-cache) | Hard       |           |         |
|      |                                          |            |           |         |