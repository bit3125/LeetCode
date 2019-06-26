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



### Array

| No       | Title                                    | Difficulty | Completed | Comment                                  |
| -------- | ---------------------------------------- | ---------- | --------- | ---------------------------------------- |
| 55       | [Jump Game](https://leetcode.com/problems/jump-game) |            | √`        | 亦可回溯                                     |
| 11       | [Container With Most Water](https://leetcode.com/problems/container-with-most-water) |            | √`        |                                          |
| 42       | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water) | Hard       | √         | 写了OnOn，最优为OnO1                           |
| 128      | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence) | Hard       | √         | 用HashMap实现Tn=On，但是100ms。最优解用HashSet实现Tn=On，但是5ms+-。可能虽然复杂度一样但是HashMap有很多多余开销吧 |
| 287      | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number) |            | √         | 剑指offer原题                                |
| 4        | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays) | Hard       | √         |                                          |
| 289      | [Game of Life](https://leetcode.com/problems/game-of-life) |            | √`        | 与73.类似，利用int的不同bit实现inplace              |
| 334      | [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence) |            | √`        | 限制复杂度，巧解                                 |
| 217      | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate) | Easy       | √         |                                          |
| 268      | [Missing Number](https://leetcode.com/problems/missing-number) | Easy       | √`        | 三种方法：SUM, Bit Manu, Binary Sort（有序时）。可以多看两眼 |
|          |                                          |            |           |                                          |
| Interval |                                          |            |           |                                          |
| 56       | [Merge Intervals](https://leetcode.com/problems/merge-intervals) |            | √         |                                          |
| 253      | [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii) |            |           | 付费                                       |
| Counter  |                                          |            |           |                                          |
| 239      | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum) | Hard       | √         | 剑指offer原题。使用Deque实现                      |
| 238      | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self) |            | √         |                                          |
| 295      | [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream) | Hard       | √         | 剑指offer原题                                |
|          |                                          |            |           |                                          |
| Sort     |                                          |            |           |                                          |
| 75       | [Sort Colors](https://leetcode.com/problems/sort-colors) |            | √         | HashSort/奇偶列首尾指针法                        |
| 283      | [Move Zeroes](https://leetcode.com/problems/move-zeroes) |            | √         | HashSort                                 |
| 88       | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array) |            | √         | 剑指offer原题。注意题目给的条件必有其用                   |
| 324      | [Wiggle Sort II](https://leetcode.com/problems/wiggle-sort-ii) |            | √`        | 感觉比些Hard还难。写了3个Solutions，重要一个技巧点是：上下分层模型+填充方向，3个Solutions都基于此。最佳解法为QuickSelect+3Partition+VirtualIndex（公式只能死记）。 |
| 315      | [Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self) | Hard       | √         | 类似于Reverse Pairs，使用merge others.sort 的思想。这里自己使用了一个int[3]结构来重构数据，完成后要做一次快排。discussion里有使用idx mapping技术的，可以看一下 |




### Binary Search

| No   | Title                                    | Difficulty | Completed | Comment                           |
| ---- | ---------------------------------------- | ---------- | --------- | --------------------------------- |
| 33   | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array) |            | √         | 可基于剑指offer No11                   |
| 34   | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array) |            | √         |                                   |
| 300  | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence) |            | √,  `TODO | 实现了O(n^2)复杂度，O(nlogn)复杂度尚未理解      |
| 162  | [Find Peak Element](https://leetcode.com/problems/find-peak-element) |            | √,√`      | 没想到用Binary Search。此题的BS的变形思路要好好揣摩 |
|      |                                          |            |           |                                   |
|      |                                          |            |           |                                   |



### LinkedList

| No   | Title                                                        | Difficulty | Completed | Completed-R2 | Comment                                                      |
| ---- | ------------------------------------------------------------ | ---------- | --------- | ------------ | ------------------------------------------------------------ |
| 206  | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) | Easy       | √         | √            |                                                              |
| 141  | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | Easy       | √         | √            |                                                              |
| 19   | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list) |            | √         | √            |                                                              |
| 2    | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers) |            | √         | √            |                                                              |
| 160  | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists) | Easy       | √         | √            |                                                              |
| 21   | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) | Easy       | √         | √            |                                                              |
| 234  | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list) | Easy       | √         | √            |                                                              |
| 142  | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii) |            | √         | √            |                                                              |
| 148  | [Sort List](https://leetcode.com/problems/sort-list)         |            | √`        | √            |                                                              |
| 23   | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists) | Hard       | √         | √            |                                                              |
| 237  | [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list) | Easy       | √         | √            | 剑指offer原题，不使用prev删除链表节点                        |
| 328  | [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list) |            | √         | √            | 拆链                                                         |
| 138  | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer) |            | √         | √            | 剑指offer原题。本Epoch进步在将俩操作解耦出来模块化了（见代码）这样指针操作不容易出错，一个bug过 |
|      |                                                              |            |           |              |                                                              |


### Stack & PriorityQueue

| NO   | Title                                    | Difficulty | Completed | Comment                          |
| ---- | ---------------------------------------- | ---------- | --------- | -------------------------------- |
| 155  | [Min Stack](https://leetcode.com/problems/min-stack) | Easy       | √         |                                  |
| 394  | [Decode String](https://leetcode.com/problems/decode-string) |            | √         | 这里我是之前用递归做的，并没有用栈                |
| 84   | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram) | Hard       | √`        | 看完答案写出了类动规的方法，stack的解法边界条件还是处理不好 |
| 215  | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array) |            | √         | top-k问题皆可考虑使用heap窗口              |
| 347  | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements) |            | √         |                                  |
| 150  | [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation) |            | √         | 比较简单的四则运算问题（难的是按照human形式输入）      |
| 341  | [Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator) |            | √`        | Medium活生生给我做成了Hard。。不过确实有trick   |
|      |                                          |            |           |                                  |
|      |                                          |            |           |                                  |



### String

| No          | Title                                                        | Difficulty | Completed | Completed-R2 | Comment                             |
| ----------- | ------------------------------------------------------------ | ---------- | --------- | ------------ | ----------------------------------- |
| 49          | [Group Anagrams](https://leetcode.com/problems/group-anagrams) |            | √         | √            | Solution3使用Hash的思想值得好好借鉴 |
| 344         | [Reverse String](https://leetcode.com/problems/reverse-string) |            | √         | √            | 剑指offer原题                       |
| 387         | [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string) | Easy       | √         | √            | 剑指offer原题                       |
| 38          | [Count and Say](https://leetcode.com/problems/count-and-say) | Easy       | √         | 不做         |                                     |
| 179         | [Largest Number](https://leetcode.com/problems/largest-number) |            | √         | √            | 剑指offer原题                       |
| 28          | [Implement strStr()](https://leetcode.com/problems/implement-strstr) | Easy       | √         | 不做         | 单模式串匹配，KMP                   |
| 242         | [Valid Anagram](https://leetcode.com/problems/valid-anagram) | Easy       | √         | 不做         |                                     |
| 171         | [Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number) | Easy       | √         | 不做         |                                     |
| Substring   |                                                              |            |           |              |                                     |
| 76          | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring) | Hard       | //TODO    |              |                                     |
| 3           | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) |            | √         | √            |                                     |
| 395         | [Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters) |            | √, √`     |              | //TODO On的解还没看噢，在discussion |
|             |                                                              |            |           |              |                                     |
|             |                                                              |            |           |              |                                     |
| Palindrome  |                                                              |            |           |              |                                     |
| 5           | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring) |            | √`        | √            |                                     |
| Parentheses |                                                              |            |           |              |                                     |
| 20          | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses) | Easy       | √         |              |                                     |
| 22          | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses) |            | √         |              |                                     |
| 32          | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses) | Hard       | √ , √`    |              | DP解自己写出，栈解看后写            |
| 301         | [Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses) | Hard       | TODO      |              | 确实有点难度，先搁着                |

Q003 Longest Substring Without Repeating Characters 与 Q005 Longest Palindromic Substring 可以好好对着看一下，都是dp但是分别使用了一维与二维的状态定义，用dp分别达到的效果：On^3 -> On, On^3 -> On^2



### Math


| No   | Title                                    | Difficulty | Completed | Comment                   |
| ---- | ---------------------------------------- | ---------- | --------- | ------------------------- |
| 1    | [Two Sum](https://leetcode.com/problems/two-sum) |            | √`        | 好好看，多解，高频                 |
| 15   | [3Sum](https://leetcode.com/problems/3sum) |            | √         | 也看下，似乎看了hint才写出来          |
| 66   | [Plus One](https://leetcode.com/problems/plus-one) | Easy       | √         | 按位模拟加法                    |
| 454  | [4Sum II](https://leetcode.com/problems/4sum-ii) |            | √         | 2Sum 3Sum 4Sum 都可以好好看看    |
| 326  | [Power of Three](https://leetcode.com/problems/power-of-three) | Easy       | √         |                           |
| 202  | [Happy Number](https://leetcode.com/problems/happy-number) | Easy       | √         | discuss有一个Sn=O1的类链表找环解法很妙 |
| 166  | [Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal) |            | √`        | 使用HashMap存remainders      |
| 204  | [Count Primes](https://leetcode.com/problems/count-primes) | Easy       | √         | 素数筛法                      |
|      |                                          |            |           |                           |



### Tree

| No         | Title                                    | Difficulty | Completed | Completed-R2 | Comment                                  |
| ---------- | ---------------------------------------- | ---------- | --------- | ------------ | ---------------------------------------- |
| 94         | [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal) |            | √         | √            |                                          |
|            |                                          |            |           |              |                                          |
| 101        | [Symmetric Tree](https://leetcode.com/problems/symmetric-tree) | Easy       | √         | √            |                                          |
| 226        | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree) | Easy       | √         | √            |                                          |
| 104        | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree) | Easy       | √         | √            |                                          |
| 124        | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum) | Hard       | √         |              | 树形动规                                     |
| 337        | [House Robber III](https://leetcode.com/problems/house-robber-iii) |            | √         | √            |                                          |
| 236        | [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree) |            | √         | √            | 各种debug了超久。。结果还不是最简解。。好好看看               |
| 297        | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree) | Hard       | √         | √            | offer原题                                  |
| 114        | [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list) |            | √         | √            | 上面说很少考？跟那题变二叉树为双向链表的几乎一毛一样（好像是offer上的）   |
| 105        | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal) |            | √         |              | 上面说很少考？                                  |
| 96         | [Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees) |            | √`        | √            | 本质是DP                                    |
| BST        |                                          |            |           |              |                                          |
| 230        | [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst) |            | √         | √            | BST的中序遍历                                 |
| 108        | [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree) | Easy       | √         | √            | 二分搜索构建AVL                                |
| LevelOrder |                                          |            |           |              |                                          |
| 102        | [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal) |            | √         | √            |                                          |
| 103        | [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal) |            | √         | √            | 剑指offer原题。关键点：  1.两个栈交替；2.奇偶层区分左右树的push顺序 |
| 116        | [Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node) |            | √, √`     | √            | Sn=O1的层序遍历<br>round2之时直接写出了一种新的Sn=O1的算法  |
|            |                                          |            |           |              |                                          |



### Union Find

None



### Trie

| No   | Title                        | Difficulty | Completed | Comment                                  |
| ---- | ---------------------------- | ---------- | --------- | ---------------------------------------- |
| 208  | Implement Trie (Prefix Tree) |            | √         | Trie Tree 基础实现                           |
| 212  | Word Search II               | Hard       | √         | Trie+DFS backtracking<br> 似乎利用startWith操作能够继续剪枝 ，尚未研究//TODO |
|      |                              |            |           |                                          |



### DFS&BFS

| No   | Title                                    | Difficulty | Completed | Comment         |
| ---- | ---------------------------------------- | ---------- | --------- | --------------- |
| 200  | [Number of Islands](https://leetcode.com/problems/number-of-islands) |            | √         | DFS计算连通分量数      |
| 329  | [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix) | Hard       | √         | DFS+cache剪枝，多看看 |


### Graph

None



### Backtracking (与其叫回溯不如叫排列。。。)

| No          | Title                                                        | Difficulty | Completed | Completed-R2 | Comment                                                      | Comment-R2                                                   |
| ----------- | ------------------------------------------------------------ | ---------- | --------- | ------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 78          | [Subsets](https://leetcode.com/problems/subsets)             |            | √         | √            | 组合，使用boolean标记数组，无回溯。                          |                                                              |
| 39          | [Combination Sum](https://leetcode.com/problems/combination-sum) |            | √         | √            | 无回溯。但是应该可用。r1在递归调用的基础上使用for来辅助穷举，一定程度上对递归栈深度剪枝 | r2使用的是类似状态机的搜索算法，用了backtracking，没有使用r1中的for来辅助，但时间开销近似 |
| 46          | [Permutations](https://leetcode.com/problems/permutations)   |            | √         | √            |                                                              |                                                              |
| 31          | [Next Permutation](https://leetcode.com/problems/next-permutation) |            | √         |              | 无回溯。                                                     |                                                              |
| 79          | [Word Search](https://leetcode.com/problems/word-search)     |            | √         | √            | 本质是backtracking-DFS。几乎两年没写了20min一遍过，太强了（啪啪啪） |                                                              |
| 131         | [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning) |            | √         |              | 回文串2d-DP(Q005)+枚举搜索backtracking                       |                                                              |
|             |                                                              |            |           |              |                                                              |                                                              |
|             |                                                              |            |           |              |                                                              |                                                              |
|             |                                                              |            |           |              |                                                              |                                                              |
| Enumeration |                                                              |            |           |              |                                                              |                                                              |
| 17          | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number) |            | √         |              | 无回溯。                                                     |                                                              |
|             |                                                              |            |           |              |                                                              |                                                              |
|             |                                                              |            |           |              |                                                              |                                                              |

注：79题被大佬错分到Matrix，明明是Backtracking 才对

Q39 Combination Sum 的r1 r2 两种解法可以多琢磨琢磨





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
| 85   | [Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle) | Hard       | TODO      |                                          |
|      |                                          |            |           |                                          |
| 化简   |                                          |            |           |                                          |
| 198  | [House Robber](https://leetcode.com/problems/house-robber) | Easy       | √         |                                          |
| 10   | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching) | Hard       |           |                                          |
| 91   | [Decode Ways](https://leetcode.com/problems/decode-ways) |            | √         | 边界挺麻烦的                                   |
|      |                                          |            |           |                                          |
| 其他   |                                          |            |           |                                          |
| 121  | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) |            | √         |                                          |
| 309  | [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown) |            | ?         |                                          |
| 152  | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray) |            | √         |                                          |
|      |                                          |            |           |                                          |

注：53题被大佬错分到Array，明明是DP 才对- -。还有121,309,152也是



### Matrix

| No   | Title                                    | Difficulty | Completed | Comment                       |
| ---- | ---------------------------------------- | ---------- | --------- | ----------------------------- |
| 48   | [Rotate Image](https://leetcode.com/problems/rotate-image) |            | √         |                               |
| 240  | [Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii) |            | √         | offer原题                       |
| 36   | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku) |            | √         |                               |
| 54   | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix) |            | √         | offer原题                       |
| 73   | [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes) |            | √`        | 与289.类似的思想，利用给定的matrix做marker |
| 378  | [Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix) |            | √`, TODO  | Range Binary Search。heap解法还没看 |



### Bit Manipulation

| No   | Title                                    | Difficulty | Completed | Comment                           |
| ---- | ---------------------------------------- | ---------- | --------- | --------------------------------- |
| 136  | [Single Number](https://leetcode.com/problems/single-number) | Easy       | √         | offer原题                           |
| 338  | [Counting Bits](https://leetcode.com/problems/counting-bits) |            | √`        | 很少考？<br> 想到了O(n^2)的解，没想到使用DP的On的解 |
| 371  | [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers) | Easy       | √         | 剑指offer原题。很少考？                    |
| 191  | [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits) | Easy       | √         | 剑指offer原题。很少考？                    |
|      |                                          |            |           |                                   |
|      |                                          |            |           |                                   |


### Topological Sort

| No   | Title                                    | Difficulty | Completed | Comment |
| ---- | ---------------------------------------- | ---------- | --------- | ------- |
| 207  | [Course Schedule](https://leetcode.com/problems/course-schedule) |            |           |         |
|      |                                          |            |           |         |

### Random

| No   | Title                                    | Difficulty | Completed | Comment      |
| ---- | ---------------------------------------- | ---------- | --------- | ------------ |
| 384  | [Shuffle an Array](https://leetcode.com/problems/shuffle-an-array) |            | √         | Fisher Yates |
|      |                                          |            |           |              |
|      |                                          |            |           |              |
|      |                                          |            |           |              |



### Design

| No   | Title                                    | Difficulty | Completed | Comment |
| ---- | ---------------------------------------- | ---------- | --------- | ------- |
| 146  | [LRU Cache](https://leetcode.com/problems/lru-cache) | Hard       | √         |         |
|      |                                          |            |           |         |