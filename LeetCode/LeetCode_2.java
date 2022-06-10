package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

// Premium TOO: https://leetcode.com/problems/shortest-way-to-form-string/
//https://leetcode.com/problems/minimize-max-distance-to-gas-station/
// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
// https://leetcode.com/problems/increasing-order-search-tree/
// https://leetcode.com/problems/brick-wall/
// https://leetcode.com/problems/di-string-match/
// https://leetcode.com/problems/shortest-path-with-alternating-colors/
// https://leetcode.com/problems/longest-string-chain/

public class LeetCode_2
{
    /*
        201. PROBLEM DESCRIPTION (https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/)
        Given an array of integers arr of even length n and an integer k.
        We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
        Return True If you can find a way to do that or False otherwise.

        Example 1:
            Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
            Output: true
            Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

        Example 2:
            Input: arr = [1,2,3,4,5,6], k = 7
            Output: true
            Explanation: Pairs are (1,6),(2,5) and(3,4).

        Example 3:
            Input: arr = [1,2,3,4,5,6], k = 10
            Output: false
            Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with
            sum divisible by 10.

        Example 4:
            Input: arr = [-10,10], k = 2
            Output: true

        Example 5:
            Input: arr = [-1,1,-2,2,-3,3,-4,4], k = 3
            Output: true

        Constraints:
            arr.length == n
            1 <= n <= 105
            n is even.
            -109 <= arr[i] <= 109
            1 <= k <= 105
    */
    public boolean canArrange(int[] arr, int k)
    {
        int mod_bucket[] = new int[k];
        for(int num_arr:arr)
        {
            int mod_val = num_arr%k;
            if(mod_val<0)
                mod_bucket[mod_val+k]++;
            else
                mod_bucket[mod_val]++;
        }
        if(mod_bucket[0]%2!=0)
            return false;
        for(int iterator_i=1;iterator_i<(k+1)/2;iterator_i++)
            if(mod_bucket[iterator_i] != mod_bucket[k-iterator_i])
                return false;
        if(k%2==0 && mod_bucket[k/2]%2!=0)
            return false;
        return true;
    }

    /*
        202. PROBLEM DESCRIPTION (https://leetcode.com/problems/edit-distance/)
        Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
        You have the following three operations permitted on a word:
            Insert a character
            Delete a character
            Replace a character

        Example 1:
            Input: word1 = "horse", word2 = "ros"
            Output: 3
            Explanation:
                horse -> rorse (replace 'h' with 'r')
                rorse -> rose (remove 'r')
                rose -> ros (remove 'e')

        Example 2:
            Input: word1 = "intention", word2 = "execution"
            Output: 5
            Explanation:
                intention -> inention (remove 't')
                inention -> enention (replace 'i' with 'e')
                enention -> exention (replace 'n' with 'x')
                exention -> exection (replace 'n' with 'c')
                exection -> execution (insert 'u')

        Constraints:
            0 <= word1.length, word2.length <= 500
            word1 and word2 consist of lowercase English letters.
    */
    public int minDistance_dp(String word1, String word2) // DP Approach
    {
        int dp_arr[][] = new int[word1.length()+1][word2.length()+1];

        // Compare substrings with empty string - Delete Operations
        for(int iterator_i=word1.length();iterator_i>=0;iterator_i--)
            dp_arr[iterator_i][word2.length()] = word1.length()-iterator_i;

        for(int iterator_i=word2.length();iterator_i>=0;iterator_i--)
            dp_arr[word1.length()][iterator_i] = word2.length()-iterator_i;

        // Calculate mindistance for all operations
        for(int iterator_row=word1.length()-1;iterator_row>=0;iterator_row--)
            for(int iterator_col=word2.length()-1;iterator_col>=0;iterator_col--)
                dp_arr[iterator_row][iterator_col] = Math.min(Math.min(dp_arr[iterator_row+1][iterator_col+1]+(word1.charAt(iterator_row) == word2.charAt(iterator_col)?0:1),dp_arr[iterator_row][iterator_col+1] + 1),dp_arr[iterator_row+1][iterator_col] + 1);

        return dp_arr[0][0];
    }


    /*
        203. PROBLEM DESCRIPTION (https://leetcode.com/problems/path-sum-ii/)
        Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum
        equals targetSum.
        A leaf is a node with no children.

        Example 1:
            Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
            Output: [[5,4,11,2],[5,8,4,5]]

        Example 2:
            Input: root = [1,2,3], targetSum = 5
            Output: []

        Example 3:
            Input: root = [1,2,3], targetSum = 5
            Output: []

        Constraints:
            The number of nodes in the tree is in the range [0, 5000].
            -1000 <= Node.val <= 1000
            -1000 <= targetSum <= 1000
    */
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum)
    {
        List<List<Integer>> result_list = new ArrayList<>();
        pathSum2Helper(root,targetSum,result_list,new ArrayList<Integer>(),0);
        return result_list;
    }

    public void pathSum2Helper(TreeNode root,int target,List<List<Integer>> result_list, List<Integer> current_list,int current_sum)
    {
        if(root==null)
            return;
        current_list.add(root.val);
        int new_sum = current_sum+root.val;
        if(root.left==null && root.right==null)
        {
            if(new_sum==target)
                result_list.add(new ArrayList<>(current_list));
            current_list.remove(current_list.size()-1);
            return;
        }

        pathSum2Helper(root.left,target,result_list,current_list,new_sum);
        pathSum2Helper(root.right,target,result_list,current_list,new_sum);
        current_list.remove(current_list.size()-1);
    }

    /*
        204. PROBLEM DESCRIPTION (https://leetcode.com/problems/partition-equal-subset-sum/)
        Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two
        subsets such that the sum of elements in both subsets is equal.

        Example 1:
            Input: nums = [1,5,11,5]
            Output: true
            Explanation: The array can be partitioned as [1, 5, 5] and [11].

        Example 2:
            Input: nums = [1,2,3,5]
            Output: false
            Explanation: The array cannot be partitioned into equal sum subsets.

        Constraints:
            1 <= nums.length <= 200
            1 <= nums[i] <= 100
    */
    boolean memoization_subset_visited[];
    public boolean canPartition_rcur(int[] nums) //DFS + Memo
    {
        int sum=0;
        for(int num:nums)
            sum += num;
        if(sum%2!=0)
            return false;
        sum /= 2;
        memoization_subset_visited = new boolean[sum+1];
        return canPartitionHelper(nums,nums.length-1,0,sum);
    }

    public boolean canPartitionHelper(int input_nums[],int iterator_index, int curr_leftsum, int max_sum)
    {
        if(curr_leftsum == max_sum)
            return true;
        if(curr_leftsum>max_sum || iterator_index<0)
            return false;
        if(memoization_subset_visited[curr_leftsum])
            return false;

        if(canPartitionHelper(input_nums,iterator_index-1,curr_leftsum+input_nums[iterator_index],max_sum))
            return true;
        if(canPartitionHelper(input_nums,iterator_index-1,curr_leftsum,max_sum))
            return true;
        memoization_subset_visited[curr_leftsum] = true;
        return false;
    }

    public boolean canPartition(int nums[])
    {
        int sums=0;
        for(int num:nums)
            sums += num;
        if(sums%2==1)
            return false;
        sums /= 2;
        boolean dp_visited[] = new boolean[sums+1];
        Arrays.sort(nums);
        dp_visited[0] = true;
        for(int iterator_num=nums.length-1;iterator_num>=0;iterator_num--)
        {
            for(int iterator_sum=sums;iterator_sum>0;iterator_sum--)
            {
                if(iterator_sum-nums[iterator_num]<0)
                    break;
                dp_visited[iterator_sum] = dp_visited[iterator_sum-nums[iterator_num]] || dp_visited[iterator_sum];
            }
            if(dp_visited[sums])
                return true;
        }
        return dp_visited[sums];
    }


    /*
        205. PROBLEM DESCRIPTION (https://leetcode.com/problems/path-sum-iii/)
        You are given a binary tree in which each node contains an integer value.
        Find the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf,
        but it must go downwards (traveling only from parent nodes to child nodes).
        The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

        Example:
            root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
                      10
                     /  \
                    5   -3
                   / \    \
                  3   2   11
                 / \   \
                3  -2   1
            Return 3. The paths that sum to 8 are:

            1.  5 -> 3
            2.  5 -> 2 -> 1
            3. -3 -> 11
    */
    public int pathSum_rcur(TreeNode root, int sum) // O(n^2)
    {
        if (root == null)
            return 0;
        return pathSumFrom(root, sum) + pathSum_rcur(root.left, sum) + pathSum_rcur(root.right, sum); // For each path with root and rcur all left and right
    }

    public int pathSumFrom(TreeNode node, int sum)
    {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

    public int pathSum(TreeNode root, int sum) // Prefix Map Solution
    {
        HashMap<Integer,Integer> prefix_hmap = new HashMap<>();
        prefix_hmap.put(0,1);
        return pathSum3Helper(root,prefix_hmap,0,sum);
    }

    public int pathSum3Helper(TreeNode root,HashMap<Integer,Integer> prefix_hmap,int current_sum, int target_sum)
    {
        if(root==null)
            return 0;
        int new_sum = current_sum+root.val;
        int numberOccurrences = prefix_hmap.getOrDefault(new_sum-target_sum,0); // Current root to any visited previous node

        //Add root to current sum in hmap
        prefix_hmap.put(new_sum,prefix_hmap.getOrDefault(new_sum,0)+1);

        numberOccurrences += pathSum3Helper(root.left,prefix_hmap,new_sum,target_sum) + pathSum3Helper(root.right,prefix_hmap,new_sum,target_sum);

        // Current Node visited - remove 1 count of occurrence since it will not be visited
        prefix_hmap.put(new_sum,prefix_hmap.get(new_sum)-1);
        return numberOccurrences;
    }

    /*
        206. PROBLEM DESCRIPTION (https://leetcode.com/problems/palindromic-substrings/)
        Given a string, your task is to count how many palindromic substrings in this string.
        The substrings with different start indexes or end indexes are counted as different substrings even they consist
        of same characters.

        Example 1:
            Input: "abc"
            Output: 3
            Explanation: Three palindromic strings: "a", "b", "c".

        Example 2:
            Input: "aaa"
            Output: 6
            Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

        Note:
            The input string length won't exceed 1000.

    */
    public int countSubstrings_dp(String s) // Dp Approach
    {
        boolean dp_palindrome[][] = new boolean[s.length()][s.length()];
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
            dp_palindrome[0][iterator_i] = true;
        int current_count = s.length();

        for(int iterator_size=1;iterator_size<s.length();iterator_size++) //Size = Iterator+1
        {
            for(int iterator_index=iterator_size;iterator_index<s.length();iterator_index++)
            {
                if(s.charAt(iterator_index)==s.charAt(iterator_index-iterator_size) && (iterator_size-2<0 || dp_palindrome[iterator_size-2][iterator_index-1]))
                {
                    current_count++;
                    dp_palindrome[iterator_size][iterator_index] = true;
                }
            }
        }
        return current_count;
    }

    public int countSubstrings(String s) // Expand Around Center
    {
        int count=0;
        for(int iterator_center=0;iterator_center<s.length();iterator_center++)
        {
            int front = iterator_center;
            int rear = iterator_center;
            while (front >= 0 && rear < s.length() && s.charAt(front) == s.charAt(rear)) // iterator_center is actual center
            {
                front--;
                rear++;
                count++;
            }

            front = iterator_center;
            rear = iterator_center + 1;
            while (front >= 0 && rear < s.length() && s.charAt(front) == s.charAt(rear))  //iterator_center is part of center
            {
                front--;
                rear++;
                count++;
            }
        }
        return count;
    }

    /*
        207. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-boxes/)
        You are given several boxes with different colors represented by different positive numbers.
        You may experience several rounds to remove boxes until there is no box left. Each time you can choose some
        continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.
        Return the maximum points you can get.

        Example 1:
            Input: boxes = [1,3,2,2,2,3,4,3,1]
            Output: 23
            Explanation:
                [1, 3, 2, 2, 2, 3, 4, 3, 1]
                ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
                ----> [1, 3, 3, 3, 1] (1*1=1 points)
                ----> [1, 1] (3*3=9 points)
                ----> [] (2*2=4 points)

        Example 2:
            Input: boxes = [1,1,1]
            Output: 9

        Example 3:
            Input: boxes = [1]
            Output: 1

        Constraints:
            1 <= boxes.length <= 100
            1 <= boxes[i] <= 100
    */
    public int removeBoxes_alt(int[] boxes) // Top Down DP
    {
        int dp_memo[][][] = new int[boxes.length][boxes.length][boxes.length];
        return removeBoxesHelper(boxes,dp_memo,0,boxes.length-1,0);

    }

    public int removeBoxesHelper(int boxes[],int dp_memo[][][],int start_pos,int end_pos,int left_occurrences)
    {
        if(start_pos>end_pos)
            return 0;

        if(dp_memo[start_pos][end_pos][left_occurrences] != 0)
            return dp_memo[start_pos][end_pos][left_occurrences];

        int iterator_shift =0, left_occurrences_original = left_occurrences;
        // Collapse left boundary til all similar boxes (local optimum)
        for(iterator_shift=start_pos;iterator_shift<end_pos && boxes[iterator_shift+1]==boxes[start_pos];iterator_shift++, left_occurrences++);

        // Remove i right now
        int remove_value = (left_occurrences+1)*(left_occurrences+1) + removeBoxesHelper(boxes,dp_memo,iterator_shift+1,end_pos,0);


        for(int iterator_i=iterator_shift+1;iterator_i<=end_pos;iterator_i++)
        {
            // Remove i later
            if(boxes[iterator_shift] == boxes[iterator_i])
                remove_value = Math.max(remove_value,removeBoxesHelper(boxes,dp_memo,iterator_shift+1,iterator_i-1,0) +
                        removeBoxesHelper(boxes,dp_memo,iterator_i,end_pos,left_occurrences+1));
            while(iterator_i<end_pos && boxes[iterator_i+1] == boxes[iterator_i]) // Skip common
                iterator_i++;
        }
        dp_memo[start_pos][end_pos][left_occurrences_original] = remove_value;
        return remove_value;
    }

    public int removeBoxes(int[] boxes)
    {
        int result = 0, dp_arr[][][] = new int[boxes.length][boxes.length][boxes.length];

        // Populate initial values
        for(int iterator_i=0;iterator_i<boxes.length;iterator_i++)
            for(int iterator_leftoccur = 0;iterator_leftoccur<=iterator_i;iterator_leftoccur++)
                dp_arr[iterator_i][iterator_i][iterator_leftoccur] = (iterator_leftoccur+1)*(iterator_leftoccur+1);

        for(int iterator_interval=1;iterator_interval<boxes.length;iterator_interval++)
        {
            for(int iterator_end=iterator_interval;iterator_end<boxes.length;iterator_end++)
            {
                int start_pos = iterator_end - iterator_interval;

                // All possible values of Left occurrences (from 0 to all same)
                for(int iterator_left=0;iterator_left<=start_pos;iterator_left++)
                {
                    // Remove Current Box
                    result = (iterator_left+1)*(iterator_left+1) + dp_arr[start_pos+1][iterator_end][0];

                    //Keep Current Box
                    for(int iterator_skip=start_pos+1;iterator_skip<=iterator_end;iterator_skip++)
                    {
                        if(boxes[iterator_skip]==boxes[start_pos])
                            result = Math.max(result,dp_arr[start_pos+1][iterator_skip-1][0] + dp_arr[iterator_skip][iterator_end][iterator_left+1]);
                    }
                    dp_arr[start_pos][iterator_end][iterator_left] = result;
                }
            }
        }
        return dp_arr[0][boxes.length-1][0];
    }


    /*
        208. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-palindrome/)
        Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
        that can be built with those letters.
        Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

        Example 1:
            Input: s = "abccccdd"
            Output: 7
            Explanation:
            One longest palindrome that can be built is "dccaccd", whose length is 7.

        Example 2:
            Input: s = "a"
            Output: 1

        Example 3:
            Input: s = "bb"
            Output: 2

        Constraints:
            1 <= s.length <= 2000
            s consists of lowercase and/or uppercase English letters only.
    */
    public int longestPalindrome1(String s)
    {
        int char_mapper[] = new int[256],max_odd=0, palindrome_length=0;

        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
            char_mapper[s.charAt(iterator_i)]++;

        for(char iterator_i='a';iterator_i<='z';iterator_i++)
        {
            int mapval = char_mapper[iterator_i];
            palindrome_length += mapval/2 *2;
        }
        for(char iterator_i='A';iterator_i<='Z';iterator_i++)
        {
            int mapval = char_mapper[iterator_i];
            palindrome_length += mapval/2 *2;
        }
        return palindrome_length<s.length()?palindrome_length+1:palindrome_length;
    }

    /*
        209. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-vowels-of-a-string/)
        Given a string s, reverse only all the vowels in the string and return it.
        The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

        Example 1:
            Input: s = "hello"
            Output: "holle"

        Example 2:
            Input: s = "leetcode"
            Output: "leotcede"

        Constraints:
            1 <= s.length <= 3 * 105
            s consist of printable ASCII characters.
    */
    public String reverseVowels(String s)
    {
        int iterator_left=0, iterator_right=s.length()-1;
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char original_str[] = s.toCharArray();
        while(iterator_left<iterator_right)
        {
            if(!vowels.contains(s.charAt(iterator_left)))
                iterator_left++;
            else if(!vowels.contains(s.charAt(iterator_right)))
                iterator_right--;
            else
            {
                char temp = original_str[iterator_left];
                original_str[iterator_left] = original_str[iterator_right];
                original_str[iterator_right] = temp;
                iterator_left++;
                iterator_right--;
            }
        }
        return new String(original_str);
    }

    /*
        210. PROBLEM DESCRIPTION (https://leetcode.com/problems/spiral-matrix-ii/)
        Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.

        Example 1:
            Input: n = 3
            Output: [[1,2,3],[8,9,4],[7,6,5]]

        Example 2:
            Input: n = 1
            Output: [[1]]

        Constraints:
            1 <= n <= 20
    */
    public int[][] generateMatrix(int n)
    {
        int current_row=0, current_col=0, current_number=1, current_depth=0, matrix[][] = new int[n][n];

        while(current_row+current_depth<n && current_col+current_depth<n)
        {
            while(current_col<n-current_depth)
                matrix[current_row][current_col++] = current_number++;

            current_col--;
            current_row++;
            while(current_row<n-current_depth)
                matrix[current_row++][current_col] = current_number++;

            current_row--;
            current_col--;
            while(current_col>=current_depth)
                matrix[current_row][current_col--] = current_number++;

            current_col++;
            current_row--;
            while(current_row>current_depth)
                matrix[current_row--][current_col] = current_number++;
            current_row++;
            current_col++;
            current_depth++;

        }

        return matrix;
    }

    /*
        211. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-binary-search-trees/)
        Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n
        nodes of unique values from 1 to n.

        Example 1:
            Input: n = 3
            Output: 5

        Example 2:
            Input: n = 1
            Output: 1

    */
    public int numTrees(int n)
    {
        int dp_arr[] = new int[n+1];
        dp_arr[1] = 1;
        dp_arr[0] = 1;
        for(int iterator_n=2;iterator_n<=n;iterator_n++)
        {
            int minNode=1,maxNode=iterator_n;
            for(int iterator_root=minNode;iterator_root<=maxNode;iterator_root++)
                dp_arr[iterator_n] += dp_arr[iterator_root-minNode]*dp_arr[maxNode-iterator_root];
        }

        return dp_arr[n];
    }

    /*
        212. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-harmonious-subsequence/)
        We define a harmonious array as an array where the difference between its maximum value and its minimum value is
        exactly 1. Given an integer array nums, return the length of its longest harmonious subsequence among all its
        possible subsequences.
        A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without
        changing the order of the remaining elements.

        Example 1:
            Input: nums = [1,3,2,2,5,2,3,7]
            Output: 5
            Explanation: The longest harmonious subsequence is [3,2,2,2,3].

        Example 2:
            Input: nums = [1,2,3,4]
            Output: 2

        Example 3:
            Input: nums = [1,1,1,1]
            Output: 0

        Constraints:
            1 <= nums.length <= 2 * 104
            -109 <= nums[i] <= 109

    */
    public int findLHS(int[] nums)
    {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int lhs =0;
        for(int numval: nums)
        {
            int current_val = hmap.getOrDefault(numval,0)+1;
            hmap.put(numval,current_val);
            if(hmap.containsKey(numval-1))
                lhs = Math.max(lhs,current_val + hmap.getOrDefault(numval-1,0));
            if(hmap.containsKey(numval+1))
                lhs = Math.max(lhs,current_val + hmap.getOrDefault(numval+1,0));
        }
        return lhs;
    }

    /*
        213. PROBLEM DESCRIPTION (https://leetcode.com/problems/subtree-of-another-tree/)
        Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
        a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s
        could also be considered as a subtree of itself.

        Example 1:
        Given tree s:
             3
            / \
           4   5
          / \
         1   2
        Given tree t:
           4
          / \
         1   2
        Return true, because t has the same structure and node values with a subtree of s.

        Example 2:
        Given tree s:
             3
            / \
           4   5
          / \
         1   2
            /
           0
        Given tree t:
           4
          / \
         1   2
        Return false.

    */
    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        return isSubtreeHelper(s,t,false);
    }

    public boolean isSubtreeHelper(TreeNode s, TreeNode t, boolean ancestor_check)
    {
        if(t==null && s==null)
            return true;
        if(s==null || t==null)
            return false;
        if(ancestor_check && s.val!=t.val)
            return false;
        if(s.val == t.val)
        {
            if(isSubtreeHelper(s.left,t.left,true) && isSubtreeHelper(s.right,t.right,true))
                return true;
            if(ancestor_check)
                return false;
        }
        return isSubtreeHelper(s.left,t,false) || isSubtreeHelper(s.right,t,false);
    }

    /*
        214. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/)
        Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from
        the multiplication table?

        Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return
        the k-th smallest number in this table.

        Example 1:
            Input: m = 3, n = 3, k = 5
            Output:
            Explanation:
                The Multiplication Table:
                1	2	3
                2	4	6
                3	6	9
            The 5-th smallest number is 3 (1, 2, 2, 3, 3).

        Example 2:
            Input: m = 2, n = 3, k = 6
            Output:
            Explanation:
                The Multiplication Table:
                1	2	3
                2	4	6
            The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).

        Note:
            The m and n will be in the range [1, 30000].
            The k will be in the range [1, m * n]
    */

    public int findKthNumber(int m, int n, int k)
    {
        int lo=1,hi=m*n,mid;
        while(lo<hi)
        {
            mid = lo + (hi-lo)/2;
            int count_elements = findKthNumberHelper(m,n,mid);
            if(count_elements<k)
                lo = mid+1;
            else
                hi = mid;
        }
        return lo;
    }

    public int findKthNumberHelper(int m,int n,int current_num)
    {
        int count_elements = 0;
        for(int iterator_i=1;iterator_i<=m;iterator_i++)
            count_elements += ((current_num/iterator_i>n)?n:current_num/iterator_i);
        return count_elements;
    }

    /*
        215. PROBLEM DESCRIPTION (https://leetcode.com/problems/frog-jump/)
        A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may
        not exist a stone. The frog can jump on a stone, but it must not jump into the water.
        Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river
        by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
        If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only
        jump in the forward direction.

        Example 1:
            Input: stones = [0,1,3,5,6,8,12,17]
            Output: true
            Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the
            3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5
            units to the 8th stone.

        Example 2:
            Input: stones = [0,1,2,3,4,8,9,11]
            Output: false
            Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.

        Constraints:
            2 <= stones.length <= 2000
            0 <= stones[i] <= 2^31 - 1
            stones[0] == 0
    */
    public boolean canCross(int[] stones)
    {
        boolean dp_arr[][] = new boolean[stones.length][stones.length];
        dp_arr[0][0] = true;
        for(int iterator_i=0;iterator_i<stones.length;iterator_i++) // Compute for all stone positions values for jump
        {
            for(int iterator_j=iterator_i-1;iterator_j>=0;iterator_j--) // All Previous stones
            {
                int current_jump_req = stones[iterator_i] - stones[iterator_j];
                if(current_jump_req>=stones.length)
                    break;
                if(dp_arr[iterator_j][current_jump_req] || dp_arr[iterator_j][current_jump_req-1] || (current_jump_req+1<stones.length && dp_arr[iterator_j][current_jump_req+1]))
                    dp_arr[iterator_i][current_jump_req] = true;
            }
        }
        for(boolean boolval:dp_arr[stones.length-1])
            if(boolval)
                return true;
        return false;
    }

    /*
        216. PROBLEM DESCRIPTION (https://leetcode.com/problems/set-mismatch/)
        You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some
        error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one
        number and loss of another number.
        You are given an integer array nums representing the data status of this set after the error.
        Find the number that occurs twice and the number that is missing and return them in the form of an array.

        Example 1:
            Input: nums = [1,2,2,4]
            Output: [2,3]

        Example 2:
            Input: nums = [1,1]
            Output: [1,2]

        Constraints:
            2 <= nums.length <= 104
            1 <= nums[i] <= 104
    */
    public int[] findErrorNums(int[] nums)
    {
        int duplicate=-1,missing=-1;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            int current_num = nums[iterator_i];
            if(nums[Math.abs(current_num)-1]<0)
                duplicate = Math.abs(current_num);
            else
                nums[Math.abs(current_num)-1] *= -1;
        }
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            if(nums[iterator_i]>0)
                return new int[]{duplicate,iterator_i+1};
        return new int[]{duplicate,missing};
    }

    /*
        217. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-product-of-word-lengths/)
        Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do
        not share common letters. If no such two words exist, return 0.

        Example 1:
            Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
            Output: 16
            Explanation: The two words can be "abcw", "xtfn".

        Example 2:
            Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
            Output: 4
            Explanation: The two words can be "ab", "cd".

        Example 3:
            Input: words = ["a","aa","aaa","aaaa"]
            Output: 0
            Explanation: No such pair of words.

        Constraints:
            2 <= words.length <= 1000
            1 <= words[i].length <= 1000
            words[i] consists only of lowercase English letters.
    */
    public int maxProduct(String[] words)
    {
        int max_product=0,bit_mapper[] = new int[words.length]; // used as HashSet int has 32 bits only 26 lowercase characters
        for(int iterator_i=0;iterator_i<words.length;iterator_i++)
        {
            bit_mapper[iterator_i] = 0;
            char word_index[] = words[iterator_i].toCharArray();
            for(char curr_char:word_index)
                bit_mapper[iterator_i] |= 1 << (curr_char - 'a');

        }

        for(int iterator_i=0;iterator_i<words.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<words.length;iterator_j++)
            {
                if((bit_mapper[iterator_i] & bit_mapper[iterator_j])== 0)
                    max_product = Math.max(max_product,words[iterator_i].length()*words[iterator_j].length());
            }
        }

        return max_product;
    }

    /*
        218. PROBLEM DESCRIPTION (https://leetcode.com/problems/shortest-distance-to-a-character/)
        Given a string s and a character c that occurs in s, return an array of integers answer where
        answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in
        s. The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

        Example 1:
            Input: s = "loveleetcode", c = "e"
            Output: [3,2,1,0,1,0,0,1,2,2,1,0]
            Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
                The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
                The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 3.
                For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
                The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.

        Example 2:
            Input: s = "aaab", c = "b"
            Output: [3,2,1,0]

        Constraints:
            1 <= s.length <= 104
            s[i] and c are lowercase English letters.
            It is guaranteed that c occurs at least once in s.
    */
    public int[] shortestToChar(String s, char c)
    {
        int distance_arr[] = new int[s.length()];
        int prev_occur = -1;

        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            if(c==s.charAt(iterator_i))
                prev_occur = iterator_i;
            distance_arr[iterator_i] = prev_occur==-1?Integer.MAX_VALUE:iterator_i-prev_occur;
        }
        prev_occur = s.length();
        for(int iterator_i=s.length()-1;iterator_i>=0;iterator_i--)
        {
            if(c==s.charAt(iterator_i))
                prev_occur = iterator_i;
            distance_arr[iterator_i] = Math.min(distance_arr[iterator_i],prev_occur==s.length()?Integer.MAX_VALUE:prev_occur-iterator_i);
        }

        return distance_arr;
    }


    /*
        219. PROBLEM DESCRIPTION (https://leetcode.com/problems/integer-break/)
        Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those
        integers. Return the maximum product you can get.

        Example 1:
            Input: n = 2
            Output: 1
            Explanation: 2 = 1 + 1, 1 × 1 = 1.

        Example 2:
            Input: n = 10
            Output: 36
            Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

        Constraints:
            2 <= n <= 58
    */
    public int integerBreak_dp(int n) // DP Approach
    {
        int dp_product[] = new int[n+1];
        dp_product[1] = 1;
        for(int iterator_i=2;iterator_i<=n;iterator_i++)
        {
            int current_max = 1;
            for(int iterator_j=2;iterator_j<iterator_i;iterator_j++)
                current_max = Math.max(current_max,iterator_j*Math.max(dp_product[iterator_i-iterator_j],iterator_i-iterator_j));

            dp_product[iterator_i] = current_max;
        }
        return dp_product[n];
    }

    public int integerBreak(int n) // Mathematical Approach(Split is in multiples of 3 since 3*3>2*2*2)
    {
        int split_threes_pdt = 1;
        if(n==1 || n==2)
            return 1;
        else if(n==3)
            return 2;
        else
        {
            while(n>4)
            {
                split_threes_pdt *= 3;
                n -= 3;
            }
            split_threes_pdt *= n ; // Remaining Value id Last set of multiples(2,3,2*2)
        }
        return split_threes_pdt;
    }

    /*
        220. PROBLEM DESCRIPTION (https://leetcode.com/problems/degree-of-an-array/)
        Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency
        of any one of its elements. Your task is to find the smallest possible length of a (contiguous) subarray of nums,
        that has the same degree as nums.

        Example 1:
            Input: nums = [1,2,2,3,1]
            Output: 2
            Explanation:
                The input array has a degree of 2 because both elements 1 and 2 appear twice.
                Of the subarrays that have the same degree:
                    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
                The shortest length is 2. So return 2.

        Example 2:
            Input: nums = [1,2,2,3,1,4,2]
            Output: 6
            Explanation:
                The degree is 3 because the element 2 is repeated 3 times.
                So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.

        Constraints:
            nums.length will be between 1 and 50,000.
            nums[i] will be an integer between 0 and 49,999.
    */
    public int findShortestSubArray_alt(int[] nums)
    {
        HashMap<Integer,Integer> hmap_left = new HashMap<>(), leftmost_position = new HashMap<>();
        HashSet right_position = new HashSet<>();
        int degree_arr = 0, result=nums.length;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            int num=nums[iterator_i],current_ele = hmap_left.getOrDefault(num, 0);
            hmap_left.put(num,current_ele+1);
            degree_arr = Math.max(degree_arr,current_ele+1);
            if(!leftmost_position.containsKey(num))
                leftmost_position.put(num,iterator_i);
        }
        int iterator_i=nums.length-1;
        while(iterator_i>=0)
        {
            int num = nums[iterator_i];
            if(hmap_left.get(num)==degree_arr && right_position.add(num))
                result = Math.min(result,iterator_i-leftmost_position.get(num)+1);
            iterator_i--;
        }
        return result;
    }

    public int findShortestSubArray(int[] nums)
    {
        HashMap<Integer,Integer> hmap_left = new HashMap<>(), leftmost_position = new HashMap<>(),right_position = new HashMap<>();
        int degree_arr = 0, result=nums.length;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            int num=nums[iterator_i],current_ele = hmap_left.getOrDefault(num, 0);
            hmap_left.put(num,current_ele+1);
            degree_arr = Math.max(degree_arr,current_ele+1);
            if(!leftmost_position.containsKey(num))
                leftmost_position.put(num,iterator_i);
            right_position.put(num,iterator_i);
        }
        for(int distinct_num:hmap_left.keySet())
        {
            if(hmap_left.get(distinct_num)==degree_arr)
                result = Math.min(result,right_position.get(distinct_num)-leftmost_position.get(distinct_num)+1);
        }
        return result;
    }

    /*
        221. PROBLEM DESCRIPTION (https://leetcode.com/problems/open-the-lock/)
        You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely
        and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
        The lock initially starts at '0000', a string representing the state of the 4 wheels.You are given a list of deadends dead ends, meaning if the lock displays
        any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
        Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it
        is impossible.

        Example 1:
            Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
            Output: 6
            Explanation:
                A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
                Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
                because the wheels of the lock become stuck after the display becomes the dead end "0102".

        Example 2:
            Input: deadends = ["8888"], target = "0009"
            Output: 1
            Explanation:
            We can turn the last wheel in reverse to move from "0000" -> "0009".

        Example 3:
            Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
            Output: -1
            Explanation:
            We can't reach the target without getting stuck.

        Example 4:
            Input: deadends = ["0000"], target = "8888"
            Output: -1

        Constraints:
            1 <= deadends.length <= 500
            deadends[i].length == 4
            target.length == 4
            target will not be in the list deadends.
            target and deadends[i] consist of digits only.
    */
    public int openLock_alt(String[] deadends, String target) // Basic BFS
    {
        HashSet<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        LinkedList<StringBuffer> current_level = new LinkedList<>();
        current_level.add(new StringBuffer("0000"));

        int turns_required=0;
        if(visited.contains("0000"))
            return -1;
        visited.add("0000");
        while(!current_level.isEmpty())
        {
            int current_level_size = current_level.size();
            for(int iterator_i=0;iterator_i<current_level_size;iterator_i++)
            {
                StringBuffer current_code = current_level.poll();
                if(target.equals(current_code.toString()))
                    return turns_required;
                // Get all possibilities for next code with only one turn
                for(int iterator_j=0;iterator_j<4;iterator_j++)
                {
                    char current_char = current_code.charAt(iterator_j);
                    // Forward turn
                    StringBuffer sbuffer_fr = new StringBuffer(current_code.substring(0,iterator_j)).append(current_char=='9'?'0':(char)(current_char+1)).append(current_code.substring(iterator_j+1));
                    // Backward Turn
                    StringBuffer sbuffer_bck = new StringBuffer(current_code.substring(0,iterator_j)).append(current_char=='0'?'9':(char)(current_char-1)).append(current_code.substring(iterator_j+1));

                    // Check if already visited or deadlock in which case dont add it
                    if(visited.add(sbuffer_fr.toString()))
                        current_level.offer(sbuffer_fr);
                    if(visited.add(sbuffer_bck.toString())) {
                        current_level.offer(sbuffer_bck);
                    }
                }
            }
            turns_required++;
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) // Biderectional BFS selecting smaller set
    {
        HashSet<String> visited_or_deadlocked = new HashSet();
        visited_or_deadlocked.addAll(Arrays.asList(deadends));

        HashSet<String> q_expand = new HashSet<>(), q_secondary = new HashSet<>();
        if(visited_or_deadlocked.contains("0000"))
            return -1;
        q_expand.add("0000");
        q_secondary.add(target);
        int turns = 0;
        while(!q_expand.isEmpty() && !q_secondary.isEmpty())
        {
            //Assign Queue to be expanded
            if(q_expand.size()>q_secondary.size())
            {
                HashSet temp2 = q_expand;
                q_expand = q_secondary;
                q_secondary = temp2;
            }
            HashSet<String> temp = new HashSet<>();
            for(String current_code:q_expand)
            {
                if(q_secondary.contains(current_code))
                    return turns;
                if(!visited_or_deadlocked.add(current_code))
                    continue;
                StringBuffer c_code = new StringBuffer(current_code);
                for(int iterator_j=0;iterator_j<4;iterator_j++)
                {
                    int current_char = c_code.charAt(iterator_j);
                    String sb_fr = (new StringBuffer(c_code.substring(0,iterator_j)).append(current_char=='9'?'0':(char)(1+current_char)).append(c_code.substring(iterator_j+1))).toString();
                    String sb_bck = (new StringBuffer(c_code.substring(0,iterator_j)).append(current_char=='0'?'9':(char)(current_char-1)).append(c_code.substring(iterator_j+1))).toString();

                    if(!visited_or_deadlocked.contains(sb_fr))
                        temp.add(sb_fr);
                    if(!visited_or_deadlocked.contains(sb_bck))
                        temp.add(sb_bck);
                }
            }
            turns++;
            q_expand = temp;
        }
        return -1;
    }


    /*
        222. PROBLEM DESCRIPTION (https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/)
        Given an array and a sorting algorithm, the sorting algorithm will do a selection swap. Find the number of swaps to sort the array.

        Example 1:
            Input: {4, 3, 2, 1}
            Output: 2
            Explanation: Swap index 0 with 3 and 1 with 2 to
              form the sorted array {1, 2, 3, 4}.

        Example 2:
            Input: {1, 5, 4, 3, 2}
            Output: 2
    */
    public int numberOfSwapsToSort_cyclic(int nums[]) // Cyclic swaps
    {
        boolean isFixed[] = new boolean[nums.length];
        int sorted_indexes[][] = new int[nums.length][2],swaps=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            sorted_indexes[iterator_i][0] = nums[iterator_i];
            sorted_indexes[iterator_i][1] = iterator_i;
        }
        Arrays.sort(sorted_indexes,(a,b)->(a[0]-b[0]));

        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            int iterator_j = iterator_i;
            while(!isFixed[iterator_j])
            {
                isFixed[iterator_j] = true;
                swaps += (sorted_indexes[iterator_j][1]!=iterator_j && !isFixed[sorted_indexes[iterator_j][1]])?1:0;
                iterator_j = sorted_indexes[iterator_j][1];
            }
        }
        return swaps;
    }

    public int numberOfSwapsToSort(int nums[]) // HashMap swaps
    {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int nums_cpy[] = Arrays.copyOf(nums,nums.length),swap=0;
        Arrays.sort(nums_cpy);

        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            hmap.put(nums[iterator_i],iterator_i);

        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(nums_cpy[iterator_i] != nums[iterator_i])
            {
                swap += 1;

                // Swap ith smallest element with number at current pos
                nums[hmap.get(nums_cpy[iterator_i])]=nums[iterator_i];
                hmap.put(nums[iterator_i],hmap.get(nums_cpy[iterator_i]));
            }
        }
        return swap;
    }

    /*
        223. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-provinces/)
        There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c,
        then city a is connected indirectly with city c.
        A province is a group of directly or indirectly connected cities and no other cities outside of the group.
        You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0
        otherwise. Return the total number of provinces.

        Example 1:
            Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
            Output: 2
        Example 2:
            Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
            Output: 3
    */
    public int findCircleNum(int[][] isConnected)
    {
        int n = isConnected.length,num_provinces = 0;
        boolean visited[] = new boolean[n];
        for (int iterator_i = 0; iterator_i < n; iterator_i++)
        {
            if (!visited[iterator_i])
            {
                findCircleNumHelper(isConnected, visited,iterator_i,n);
                num_provinces++;
            }
        }
        return num_provinces;
    }

    public void findCircleNumHelper(int[][] isConnected,boolean[] visited,int node,int n)
    {
        visited[node] = true;
        for(int iterator_i=0;iterator_i<n;iterator_i++) // Mark all nodes in province as visited
        {
            if(isConnected[node][iterator_i]==1 && !visited[iterator_i])
                findCircleNumHelper(isConnected,visited,iterator_i,n);
        }
        return;
    }

    /*
        224. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/)
        There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
        There are n + 1 taps located at points [0, 1, ..., n] in the garden. Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed)
        means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
        Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.

        Example 1:
            Input: n = 5, ranges = [3,4,1,1,0,0]
            Output: 1
            Explanation: The tap at point 0 can cover the interval [-3,3]
                The tap at point 1 can cover the interval [-3,5]
                The tap at point 2 can cover the interval [1,3]
                The tap at point 3 can cover the interval [2,4]
                The tap at point 4 can cover the interval [4,4]
                The tap at point 5 can cover the interval [5,5]
                Opening Only the second tap will water the whole garden [0,5]

        Example 2:
            Input: n = 3, ranges = [0,0,0,0]
            Output: -1
            Explanation: Even if you activate all the four taps you cannot water the whole garden.

        Example 3:
            Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
            Output: 3
    */
    public int minTaps_sort(int n, int[] ranges) // Sorting Method
    {
        if(n==0)
            return 0; // No taps needed
        int ranges_left[][] = new int[ranges.length][2],num_taps=0,start_pos=0;

        for(int iterator_i=0;iterator_i<ranges.length;iterator_i++)
        {
            ranges_left[iterator_i][0] = Math.max(iterator_i-ranges[iterator_i],0);
            ranges_left[iterator_i][1] = iterator_i;
        }
        Arrays.sort(ranges_left,(a,b)->{return Integer.compare(a[0],b[0]);});
        for(int iterator_i=0,end_pos=ranges[ranges_left[iterator_i][1]];iterator_i<ranges.length;iterator_i++)
        {
            int iterator_j=iterator_i;
            for(;iterator_j<ranges.length && ranges_left[iterator_j][0]<=start_pos;iterator_j++)
                end_pos = Math.max(end_pos,ranges_left[iterator_j][1]+ranges[ranges_left[iterator_j][1]]);
            if(start_pos==end_pos)
                return -1;
            num_taps++;
            if(end_pos>=n)
                return num_taps;
            iterator_i = iterator_j-1;
            start_pos = end_pos;

        }
        return -1;
    }

    public int minTaps_dp(int n, int[] ranges) // DP Method
    {
        int dp_arr[] = new int[n+1];
        Arrays.fill(dp_arr,n+2); // Not Possible
        dp_arr[0] = 0; // All point to 0 watered by 0 taps

        for(int iterator_i=0;iterator_i<=n;iterator_i++)
        {
            int previous_point = Math.max(iterator_i-ranges[iterator_i],0);
            //Update all dp[j] where j can be watered by i
            for(int iterator_j=previous_point;iterator_j<=Math.min(iterator_i+ranges[iterator_i],n);iterator_j++)
            {
                // Update if points before range are already watered. Otherwise not updated
                dp_arr[iterator_j] = Math.min(dp_arr[iterator_j],dp_arr[previous_point]+1);
            }
        }
        return dp_arr[n]==n+2?-1:dp_arr[n];
    }

    public int minTape(int n, int[] ranges) // Convert to FrogJump Subtype
    {
        int rightmost_arr[] = new int[n+1]; // maximum point reached by a tap which waters point i
        for(int iterator_i=0;iterator_i<=n;iterator_i++)
        {
            if(ranges[iterator_i]==0)
                continue;
            rightmost_arr[Math.max(iterator_i - ranges[iterator_i], 0)] = iterator_i + ranges[iterator_i];
        }

        int max_point_reached=0,num_taps=0,start_position;
        for(int iterator_i=0;iterator_i<=n;)
        {
            num_taps++;start_position = max_point_reached;
            while(iterator_i<=n && iterator_i<=start_position)
                max_point_reached = Math.max(max_point_reached,rightmost_arr[iterator_i++]);
            if(start_position==max_point_reached)
                return -1;
            if(max_point_reached>=n)
                return num_taps;
        }
        return -1;
    }

    /*
        225. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/)
        A string s is called good if there are no two different characters in s that have the same frequency. Given a string s, return the minimum number of characters
        you need to delete to make s good. The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab",
        the frequency of 'a' is 2, while the frequency of 'b' is 1.

        Example 1:
            Input: s = "aab"
            Output: 0
            Explanation: s is already good.

        Example 2:
            Input: s = "aaabbbcc"
            Output: 2
            Explanation: You can delete two 'b's resulting in the good string "aaabcc".
            Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

        Example 3:
            Input: s = "ceabaacb"
            Output: 2
            Explanation: You can delete both 'c's resulting in the good string "eabaab".
            Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).

        Constraints:
            1 <= s.length <= 105
            s contains only lowercase English letters.
    */
    public int minDeletions(String s)
    {
        int frequency_map[] = new int[26],num_deletions=0;
        for(char c:s.toCharArray())
            frequency_map[c-'a']++;
        Arrays.sort(frequency_map);

        for(int iterator_i=frequency_map.length-2;iterator_i>=0 && frequency_map[iterator_i]!=0;iterator_i--)
        {
            while(frequency_map[iterator_i]>=frequency_map[iterator_i+1] && frequency_map[iterator_i]!=0)
            {
                frequency_map[iterator_i]--;
                num_deletions++;
            }
        }
        return num_deletions;
    }

    /*
        226. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/)
        Given an integer n, return any array containing n unique integers such that they add up to 0.

        Example 1:
            Input: n = 5
            Output: [-7,-1,1,3,4]
            Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

        Example 2:
            Input: n = 3
            Output: [-1,0,1]

        Example 3:
            Input: n = 1
            Output: [0]

        Constraints:
            1 <= n <= 1000
    */
    public int[] sumZero(int n)
    {
        int result_arr[] = new int[n], left_ptr = n/2 -1,right_ptr=(n+1)/2,current_num=1;
        while(left_ptr>=0)
        {
            result_arr[left_ptr--] = current_num;
            result_arr[right_ptr++] = -current_num++;

        }
        return result_arr;
    }

    /*
        227. PROBLEM DESCRIPTION (https://leetcode.com/problems/partition-array-into-disjoint-intervals/)
        Given an array nums, partition it into two (contiguous) subarrays left and right so that:
            1. Every element in left is less than or equal to every element in right.
            2. left and right are non-empty.
            3. left has the smallest possible size.
        Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

        Example 1:
            Input: nums = [5,0,3,8,6]
            Output: 3
            Explanation: left = [5,0,3], right = [8,6]

        Example 2:
            Input: nums = [1,1,1,0,6,12]
            Output: 4
            Explanation: left = [1,1,1,0], right = [6,12]

        Note:
            2 <= nums.length <= 30000
            0 <= nums[i] <= 106
            It is guaranteed there is at least one way to partition nums as described.
    */
    public int partitionDisjoint_alt(int[] nums) // Time O(n) Space O(n)
    {
        int left_max[] = new int[nums.length], right_min[] = new int[nums.length];
        left_max[0] = nums[0];
        right_min[nums.length-1] = nums[nums.length-1];

        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            left_max[iterator_i] = Math.max(left_max[iterator_i - 1], nums[iterator_i]);
            right_min[nums.length-iterator_i-1] = Math.min(right_min[nums.length-iterator_i], nums[nums.length-iterator_i-1]);
        }
        for(int iterator_i=0;iterator_i<nums.length-1;iterator_i++)
        {
            if(left_max[iterator_i]<right_min[iterator_i+1])
                return iterator_i+1;
        }
        return nums.length;
    }

    public int partitionDisjoint(int[] nums) // Time O(n) Space O(1)
    {
        int partition_max=nums[0], global_max=nums[0], partition_index=0;
        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            if(partition_max>nums[iterator_i]) //New Partition till i needs to be formed
            {
                partition_max = global_max;
                partition_index = iterator_i;
            }
            else
                global_max = Math.max(global_max,nums[iterator_i]);
        }
        return partition_index+1;
    }

    /*
        228. PROBLEM DESCRIPTION (https://leetcode.com/problems/video-stitching/)
        You are given a series of video clips from a sporting event that lasted T seconds.  These video clips can be overlapping with each other and have varied lengths.
        Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].  We can cut these clips into segments freely: for example,
        a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
        Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).  If the task is impossible,
        return -1.

        Example 1:
            Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
            Output: 3
            Explanation:
                We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
                Then, we can reconstruct the sporting event as follows:
                We cut [1,9] into segments [1,2] + [2,8] + [8,9].
                Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].

        Example 2:
            Input: clips = [[0,1],[1,2]], T = 5
            Output: -1
            Explanation:
                We can't cover [0,5] with only [0,1] and [1,2].

        Example 3:
            Output: 3
            Explanation:
                We can take clips [0,4], [4,7], and [6,9].

        Example 4:
            Input: clips = [[0,4],[2,8]], T = 5
            Output: 2
            Explanation:
                Notice you can have extra video after the event ends.

        Constraints:
            1 <= clips.length <= 100
            0 <= clips[i][0] <= clips[i][1] <= 100
            0 <= T <= 100
    */
    public int videoStitching_sort(int[][] clips, int T) // Sort Technique
    {
        if(T==0)
            return 0;
        Arrays.sort(clips,(a,b)->(a[0]-b[0]));
        int start_position=0,end_position=0,num_clips=1;
        for(int iterator_i=0;iterator_i<clips.length;start_position=end_position,num_clips++)
        {
            while(iterator_i<clips.length && clips[iterator_i][0]<=start_position)
                end_position = Math.max(end_position,clips[iterator_i++][1]);
            if(end_position>=T)
                return num_clips;
            if(start_position==end_position)
                return -1;
        }
        return -1;
    }

    public int videoStitching(int[][] clips, int T) // DP Approach - Jump Game
    {
        int dp[] = new int[T+1]; // dp[i] : Number of clips to make clips[0,i]
        Arrays.fill(dp,clips.length+1);
        dp[0] = 0;
        for(int iterator_i=0;iterator_i<=T ;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<clips.length;iterator_j++)
            {
                if(iterator_i>=clips[iterator_j][0] && iterator_i<=clips[iterator_j][1])
                    dp[iterator_i] = Math.min(dp[iterator_i], dp[clips[iterator_j][0]] + 1);
            }
        }
        return dp[T]==clips.length+1?-1:dp[T];
    }

    /*
        229. PROBLEM DESCRIPTION (https://leetcode.com/problems/koko-eating-bananas/)
        Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less
        than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
        Return the minimum integer k such that she can eat all the bananas within h hours.

        Example 1:
            Input: piles = [3,6,7,11], h = 8
            Output: 4

        Example 2:
            Input: piles = [30,11,23,4,20], h = 5
            Output: 30

        Example 3:
            Input: piles = [30,11,23,4,20], h = 6
            Output: 23

        Constraints:
            1 <= piles.length <= 104
            piles.length <= h <= 109
            1 <= piles[i] <= 109
    */
    public int minEatingSpeed(int[] piles, int h)
    {
        int lb = 1, ub= 1000000000, mid=0, current_time; //UB constraint in Question
        while(lb<ub)
        {
            mid = lb + (ub-lb)/2;
            current_time =0;
            for(int iterator_pile=0;iterator_pile<piles.length && current_time<=h;iterator_pile++)
                current_time += (piles[iterator_pile] +mid -1) / mid; // MAth.ceil ca use / and mod
            if(current_time>h)
                lb = mid+1;
            else
                ub = mid;
        }
        return lb;
    }

    /*
        230. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-common-subsequence/)
        Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
        A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of
        the remaining characters.
        For example, "ace" is a subsequence of "abcde".A common subsequence of two strings is a subsequence that is common to both strings.

        Example 1:
            Input: text1 = "abcde", text2 = "ace"
            Output: 3
            Explanation: The longest common subsequence is "ace" and its length is 3.

        Example 2:
            Input: text1 = "abc", text2 = "abc"
            Output: 3
            Explanation: The longest common subsequence is "abc" and its length is 3.

        Example 3:
            Input: text1 = "abc", text2 = "def"
            Output: 0
            Explanation: There is no such common subsequence, so the result is 0.

        Constraints:
            1 <= text1.length, text2.length <= 1000
            text1 and text2 consist of only lowercase English characters.
    */
    public int longestCommonSubsequence(String text1, String text2)
    {
        int dp_prev[] = new int[text1.length()+1],dp_curr[];
        for(int iterator_i=0;iterator_i<text2.length();iterator_i++)
        {
            dp_curr = new int[text1.length()+1];
            for (int iterator_j = 1; iterator_j <= text1.length(); iterator_j++)
            {
                int current_max = Math.max(dp_curr[iterator_j - 1], dp_prev[iterator_j]);
                dp_curr[iterator_j] = (text1.charAt(iterator_j-1) == text2.charAt(iterator_i))?Math.max(current_max,dp_prev[iterator_j-1]+1):current_max;
            }
            dp_prev = dp_curr;
        }
        return dp_prev[text1.length()];
    }

    /*
        231. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-number-of-occurrences/)
        Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

        Example 1:
            Input: arr = [1,2,2,1,1,3]
            Output: true
            Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

        Example 2:
            Input: arr = [1,2]
            Output: false

        Example 3:
            Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
            Output: true

        Constraints:
            1 <= arr.length <= 1000
            -1000 <= arr[i] <= 1000
    */
    public boolean uniqueOccurrences(int[] arr)
    {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        HashSet<Integer> hset = new HashSet<>();
        for(int num:arr)
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        for(int val:hmap.keySet())
        {
            if(!hset.add(hmap.get(val)))
                return false;
        }
        return true;
    }

    /*
        232. PROBLEM DESCRIPTION (https://leetcode.com/problems/pancake-sorting/)
        Given an array of integers arr, sort the array by performing a series of pancake flips.
        In one pancake flip we do the following steps:
            1. Choose an integer k where 1 <= k <= arr.length.
            2. Reverse the sub-array arr[0...k-1] (0-indexed).
        For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip
        at k = 3.
        Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips
        will be judged as correct.

        Example 1:
            Input: arr = [3,2,4,1]
            Output: [4,2,4,3]
            Explanation:
                We perform 4 pancake flips, with k values 4, 2, 4, and 3.
                Starting state: arr = [3, 2, 4, 1]
                After 1st flip (k = 4): arr = [1, 4, 2, 3]
                After 2nd flip (k = 2): arr = [4, 1, 2, 3]
                After 3rd flip (k = 4): arr = [3, 2, 1, 4]
                After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.

            Example 2:
                Input: arr = [1,2,3]
                Output: []
                Explanation: The input is already sorted, so there is no need to flip anything.
        Note that other answers, such as [3, 3], would also be accepted.

        Constraints:
            1 <= arr.length <= 100
            1 <= arr[i] <= arr.length
            All integers in arr are unique (i.e. arr is a permutation of the integers from 1 to arr.length).
    */
    public List<Integer> pancakeSort(int[] arr) // Naive method
    {
        List<Integer> result_pancake = new ArrayList<>();
        for(int iterator_i=arr.length-1;iterator_i>0;iterator_i--)
        {
            // Find current max element to put in position
            int iterator_j=0;
            for(;arr[iterator_j]!=iterator_i+1;iterator_j++);
            if(iterator_j==iterator_i)
                continue;
            if(iterator_j!=0) {
                result_pancake.add(iterator_j + 1);
                pancakeSortHelper(arr, iterator_j);
            }
            result_pancake.add(iterator_i+1);
            pancakeSortHelper(arr,iterator_i);
        }
        return result_pancake;
    }

    public void pancakeSortHelper(int arr[],int last_index)
    {
        int temp;
        for(int iterator_i=0;iterator_i<=(last_index-1)/2;iterator_i++)
        {
            temp = arr[iterator_i];
            arr[iterator_i] = arr[last_index-iterator_i];
            arr[last_index-iterator_i] = temp;
        }
    }

    public List<Integer> pancakeSort_alt(int[] arr) //O(n)
    {
        LinkedList<Integer> result_list = new LinkedList<>();
        Stack<Integer> temp_stck = new Stack<>();
        int index_arr[] = new int[arr.length];
        for(int iterator_i=0;iterator_i<arr.length;iterator_i++)
            index_arr[arr[iterator_i]-1] = iterator_i;
        for(int iterator_i=0;iterator_i<arr.length;iterator_i++)
        {
            int sorted_pos = index_arr[iterator_i];
            pancakeSortPreserve(iterator_i,sorted_pos,temp_stck);
            arr[sorted_pos] = arr[iterator_i];
            index_arr[arr[iterator_i]-1] = sorted_pos;
        }
        while(!temp_stck.isEmpty())
            result_list.addFirst(temp_stck.pop());
        return result_list;
    }

    public void pancakeSortPreserve(int pos_i,int pos_j,Stack stck)
    {
        if(pos_i!=pos_j) // No need to move i to j
        {
            pancakeAdd(stck,pos_j+1);
            pancakeAdd(stck,pos_j-pos_i+1);
            pancakeAdd(stck,pos_j-pos_i);
            pancakeAdd(stck,pos_j-pos_i-1);
            pancakeAdd(stck,pos_j-pos_i);
            pancakeAdd(stck,pos_j+1);
        }
    }

    public void pancakeAdd(Stack stck,int val)
    {
        if(val>1) // 1 is not required since flipping itself
        {
            if(!stck.isEmpty() && (int)stck.peek()==val)
                stck.pop();
            else
                stck.push(val);
        }
    }

    /*
        233. PROBLEM DESCRIPTION (https://leetcode.com/problems/cheapest-flights-within-k-stops/)
        There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight
        from city fromi to city toi with cost pricei.
        You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

        Example 1:
            Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
            Output: 200
            Explanation: The graph is shown.
            The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

        Example 2:
            Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
            Output: 500
            Explanation: The graph is shown.
            The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.

        Constraints:
            1 <= n <= 100
            0 <= flights.length <= (n * (n - 1) / 2)
            flights[i].length == 3
            0 <= fromi, toi < n
            fromi != toi
            1 <= pricei <= 104
            There will not be any multiple flights between two cities.
            0 <= src, dst, k < n
            src != dst
    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) //
    {
        LinkedList<int []> bfs_q = new LinkedList<>();
        HashMap<Integer,Integer> seen = new HashMap();
        for(int iterator_i=0;iterator_i<n;iterator_i++)
            seen.put(iterator_i,Integer.MAX_VALUE);
        HashMap<Integer,LinkedList<int[]>> hmap_connections = new HashMap<>();
        for(int[] connection: flights)
            hmap_connections.computeIfAbsent(connection[0], a-> new LinkedList<>()).add(new int[]{connection[1],connection[2]});
        bfs_q.add(new int[]{src,0,0}); // airport,stops,cost
        int min_path_cast = Integer.MAX_VALUE;
        while(!bfs_q.isEmpty())
        {
            int size_breadth = bfs_q.size();
            for(int iterator_i=0;iterator_i<size_breadth;iterator_i++)
            {
                int[] popped_ele = bfs_q.poll();
                if(popped_ele[0] ==dst)
                    min_path_cast = Math.min(min_path_cast,popped_ele[2]);
                LinkedList<int[]> connection_ele = hmap_connections.getOrDefault(popped_ele[0],new LinkedList<>());
                for(int[] nxt_airport : connection_ele)
                {
                    if(popped_ele[1]>k || ( popped_ele[1] == k && nxt_airport[0]!=dst) || (seen.get(nxt_airport[0])<=popped_ele[2]+nxt_airport[1]))
                        continue;
                    seen.put(nxt_airport[0],popped_ele[2]+nxt_airport[1]);
                    bfs_q.addLast(new int[]{nxt_airport[0],popped_ele[1]+1,popped_ele[2]+nxt_airport[1]});
                }
            }
        }
        return min_path_cast==Integer.MAX_VALUE?-1:min_path_cast;
    }

    public int findCheapestPrice_alt(int n, int[][] flights, int src, int dst, int k) //Will run into TLE
    {
        Queue<int []> bfs_q = new PriorityQueue<>((a,b)->(Integer.compare(a[2],b[2])));
        HashMap<Integer,LinkedList<int[]>> hmap_connections = new HashMap<>();
        for(int[] connection: flights)
            hmap_connections.computeIfAbsent(connection[0], a-> new LinkedList<>()).add(new int[]{connection[1],connection[2]});
        bfs_q.add(new int[]{src,0,0}); // airport,stops,cost
        while(!bfs_q.isEmpty())
        {
            int[] popped_ele = bfs_q.poll();
            if(popped_ele[0] ==dst)
                return popped_ele[2];
            LinkedList<int[]> connection_ele = hmap_connections.getOrDefault(popped_ele[0],new LinkedList<>());
            if(popped_ele[1]>k)
                continue;
            for(int[] nxt_airport : connection_ele)
                bfs_q.add(new int[]{nxt_airport[0],popped_ele[1]+1,popped_ele[2]+nxt_airport[1]});

        }
        return -1;
    }

    /*
        234. PROBLEM DESCRIPTION (https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/)
        Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.

        Example 1:
            Input: nums = [1,0,0,0,1,0,0,1], k = 2
            Output: true
            Explanation: Each of the 1s are at least 2 places away from each other.

        Example 2:
            Input: nums = [1,0,0,1,0,1], k = 2
            Output: false
            Explanation: The second 1 and third 1 are only one apart from each other.

        Example 3:
            Input: nums = [1,1,1,1,1], k = 0
            Output: true

        Example 4:
            Input: nums = [0,1,0,1], k = 1
            Output: true

        Constraints:
            1 <= nums.length <= 105
            0 <= k <= nums.length
            nums[i] is 0 or 1
    */
    public boolean kLengthApart(int[] nums, int k)
    {
        int prev=-1;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(nums[iterator_i]==1)
            {
                if (prev!=-1 && iterator_i-prev<=k)
                    return false;
                prev = iterator_i;
            }
        }
        return true;
    }

    /*
        235. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
        There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
        In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards. Your score is the sum of the points of the
        cards you have taken.
        Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

        Example 1:
            Input: cardPoints = [1,2,3,4,5,6,1], k = 3
            Output: 12
            Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal
            strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

        Example 2:
            Input: cardPoints = [2,2,2], k = 2
            Output: 4
            Explanation: Regardless of which two cards you take, your score will always be 4.

        Example 3:
            Input: cardPoints = [9,7,7,9,7,7,9], k = 7
            Output: 55
            Explanation: You have to take all the cards. Your score is the sum of points of all cards.

        Example 4:
            Input: cardPoints = [1,1000,1], k = 1
            Output: 1
            Explanation: You cannot take the card in the middle. Your best score is 1.

        Example 5:
            Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
            Output: 202

        Constraints:
            1 <= cardPoints.length <= 105
            1 <= cardPoints[i] <= 104
            1 <= k <= cardPoints.length
    */
    public int maxScore(int[] cardPoints, int k) //Sliding Window
    {
        int current_window_sum =0,max_sum;
        for(int iterator_i=cardPoints.length-k;iterator_i<cardPoints.length;iterator_i++)
            current_window_sum += cardPoints[iterator_i];
        max_sum = current_window_sum;
        for(int iterator_i=-k+1;iterator_i<=0;iterator_i++)
        {
            current_window_sum += cardPoints[iterator_i+k-1]- cardPoints[cardPoints.length+iterator_i-1];
            max_sum = Math.max(max_sum,current_window_sum);
        }
        return max_sum;
    }

    /*
        236. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)
        Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, you have to divide it by 2, otherwise, you
        have to subtract 1 from it.

        Example 1:
            Input: num = 14
            Output: 6
            Explanation:
                Step 1) 14 is even; divide by 2 and obtain 7.
                Step 2) 7 is odd; subtract 1 and obtain 6.
                Step 3) 6 is even; divide by 2 and obtain 3.
                Step 4) 3 is odd; subtract 1 and obtain 2.
                Step 5) 2 is even; divide by 2 and obtain 1.
                Step 6) 1 is odd; subtract 1 and obtain 0.

        Example 2:
            Input: num = 8
            Output: 4

        Example 3:
            Input: num = 123
            Output: 12

        Constraints:
            0 <= num <= 10^6
    */
    public int numberOfSteps(int num)
    {
        if(num==0)
            return 0;
        int steps =0;
        while(num!=0)
        {
            if((num&1)!= 0) //Odd extra operation
                steps++;
            steps++;
            num >>=1;
        }
        return steps-1;
    }

    /*
        237. PROBLEM DESCRIPTION (https://leetcode.com/problems/making-a-large-island/)
        You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
        Return the size of the largest island in grid after applying this operation. An island is a 4-directionally connected group of 1s.

        Example 1:
            Input: grid = [[1,0],[0,1]]
            Output: 3
            Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

        Example 2:
            Input: grid = [[1,1],[1,0]]
            Output: 4
            Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.

        Example 3:
            Input: grid = [[1,1],[1,1]]
            Output: 4
            Explanation: Can't change any 0 to 1, only one island with area = 4.

        Constraints:
            n == grid.length
            n == grid[i].length
            1 <= n <= 500
            grid[i][j] is either 0 or 1.
    */
    int directions4[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid)
    {
        int n = grid.length,color=2;
        HashMap<Integer,Integer> size_hmap = new HashMap<>();
        //Give all island unique identifier
        for(int iterator_i=0;iterator_i<n;iterator_i++)
            for(int iterator_j=0;iterator_j<n;iterator_j++)
                if(grid[iterator_i][iterator_j]==1)
                    size_hmap.put(color,largestIslandColorDFS(iterator_i,iterator_j,grid,color++,n));

        // For all zeros check
        int max_island_size = 0;
        for(int iterator_i=0;iterator_i<n;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<n;iterator_j++)
            {
                if(grid[iterator_i][iterator_j]==0)
                {
                    HashSet<Integer> visited_set = new HashSet();
                    visited_set.add(1);
                    visited_set.add(0);
                    int current_island_size=1;
                    for(int direction[]:directions4)
                    {
                        int new_row = direction[0]+iterator_i;
                        int new_col = direction[1]+iterator_j;
                        if(new_row<0 || new_col<0 || new_row>=n || new_col>=n || !visited_set.add(grid[new_row][new_col]))
                            continue;
                        current_island_size += size_hmap.get(grid[new_row][new_col]);
                    }
                    max_island_size = Math.max(max_island_size,current_island_size);
                }
            }
        }
        return max_island_size==0?n*n:max_island_size;
    }

    public int largestIslandColorDFS(int row,int col,int grid[][],int color,int n)
    {
        int current_size =1;
        grid[row][col] = color;
        for(int[] direction:directions4)
        {
            int new_row = direction[0]+row;
            int new_col = direction[1]+col;
            if(new_row<0 || new_col<0 || new_row>=n || new_col>=n || grid[new_row][new_col]!=1)
                continue;
            current_size += largestIslandColorDFS(new_row,new_col,grid,color,n);
        }
        return current_size;
    }

    /*
        238. PROBLEM DESCRIPTION (https://leetcode.com/problems/range-sum-of-bst/)
        Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

        Example 1:
            Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
            Output: 32
            Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

        Example 2:
            Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
            Output: 23
            Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

        Constraints:
            The number of nodes in the tree is in the range [1, 2 * 104].
            1 <= Node.val <= 105
            1 <= low <= high <= 105
            All Node.val are unique.
    */
    public int rangeSumBST(TreeNode root, int low, int high)
    {
        if(root==null)
            return 0;
        int current_sum = 0,num_conditions=0;
        if(root.val>=low)
        {
            current_sum += rangeSumBST(root.left, low, high);
            num_conditions++;
        }
        if(root.val<=high)
        {
            current_sum += rangeSumBST(root.right, low, high);
            num_conditions++;
        }
        return current_sum + (num_conditions==2?root.val:0);
    }

    /*
        239. PROBLEM DESCRIPTION (https://leetcode.com/problems/prison-cells-after-n-days/)
        There are 8 prison cells in a row and each cell is either occupied or vacant. Each day, whether the cell is occupied or vacant changes according to the
        following rules:
            1. If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
            2. Otherwise, it becomes vacant.
        Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

        You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.
        Return the state of the prison after n days (i.e., n such changes described above).

        Example 1:
            Input: cells = [0,1,0,1,1,0,0,1], n = 7
            Output: [0,0,1,1,0,0,0,0]
            Explanation: The following table summarizes the state of the prison on each day:
                Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
                Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
                Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
                Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
                Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
                Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
                Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
                Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

        Example 2:
            Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
            Output: [0,0,1,1,1,1,1,0]

        Constraints:
            cells.length == 8
            cells[i] is either 0 or 1.
            1 <= n <= 109
    */
    public int[] prisonAfterNDays(int[] cells, int n)
    {
        HashMap<String,Integer> seen_map = new HashMap<>();
        for(int iterator_i=0;iterator_i<n;iterator_i++)
        {
            //Store current State and days occurred
            seen_map.put(Arrays.toString(cells),iterator_i);
            int next_cells[] = new int[8];
            for(int iterator_j=1;iterator_j<7;iterator_j++)
                next_cells[iterator_j] = (cells[iterator_j-1]==cells[iterator_j+1]?1:0);

            // Check if next state reached previously
            if(seen_map.containsKey(Arrays.toString(next_cells)))
            {
                if((n - iterator_i) % (iterator_i + 1 - seen_map.get(Arrays.toString(next_cells)))==0)
                    return cells;
                iterator_i += (n - iterator_i) / (iterator_i + 1 - seen_map.get(Arrays.toString(next_cells))) * (iterator_i + 1 - seen_map.get(Arrays.toString(next_cells)));
            }
            cells = next_cells;

        }
        return cells;
    }

    /*
        240. PROBLEM DESCRIPTION (https://leetcode.com/problems/baseball-game/)
        You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds'
        scores. At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to
        the record and is one of the following:
            1. An integer x - Record a new score of x.
            2. "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
            3. "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
            4. "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.

        Return the sum of all the scores on the record.

        Example 1:
            Input: ops = ["5","2","C","D","+"]
            Output: 30
            Explanation:
                "5" - Add 5 to the record, record is now [5].
                "2" - Add 2 to the record, record is now [5, 2].
                "C" - Invalidate and remove the previous score, record is now [5].
                "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
                "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
            The total sum is 5 + 10 + 15 = 30.

        Example 2:
            Input: ops = ["5","-2","4","C","D","9","+","+"]
            Output: 27
            Explanation:
                "5" - Add 5 to the record, record is now [5].
                "-2" - Add -2 to the record, record is now [5, -2].
                "4" - Add 4 to the record, record is now [5, -2, 4].
                "C" - Invalidate and remove the previous score, record is now [5, -2].
                "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
                "9" - Add 9 to the record, record is now [5, -2, -4, 9].
                "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
                "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
                The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.

        Example 3:
            Input: ops = ["1"]
            Output: 1

        Constraints:
            1 <= ops.length <= 1000
            ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
            For operation "+", there will always be at least two previous scores on the record.
            For operations "C" and "D", there will always be at least one previous score on the record.
    */
    public int calPoints(String[] ops)
    {
        Stack<Integer> score_stck = new Stack<>();
        for(int iterator_i=0;iterator_i<ops.length;iterator_i++)
        {
            if(ops[iterator_i].equals("C"))
                score_stck.pop();
            else if(ops[iterator_i].equals("+"))
            {
                int popval = score_stck.pop(),new_val = popval+score_stck.peek();
                score_stck.push(popval);
                score_stck.push(new_val);
            }
            else if(ops[iterator_i].equals("D"))
                score_stck.push(2*score_stck.peek());
            else
                score_stck.push(Integer.valueOf(ops[iterator_i]));
        }
        int points =0;
        while(!score_stck.isEmpty())
            points += score_stck.pop();
        return points;
    }

    /*
        241. PROBLEM DESCRIPTION (https://leetcode.com/problems/reorganize-string/)
        Given a string s, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
        If possible, output any possible result.  If not possible, return the empty string.

        Example 1:
            Input: s = "aab"
            Output: "aba"

        Example 2:
            Input: s = "aaab"
            Output: ""

        Note: s will consist of lowercase letters and have length in range [1, 500].
    */
    public String reorganizeString(String s)
    {
        int char_map[] = new int[26], max_val=0;
        char char_max = ' ';
        for(char c:s.toCharArray())
        {
            if(max_val < ++char_map[c-'a'])
            {
                max_val = char_map[c-'a'];
                char_max = c;
            }

        }
        if(max_val>(s.length()+1)/2)
            return "";
        char str_reorg[] = new char[s.length()];
        // Place the max value
        int index =0;
        while(index/2 < max_val)
        {
            str_reorg[index] = char_max;
            index += 2;
        }
        // Assign all other letters in between places
        for(int iterator_i=0;iterator_i<26;iterator_i++)
        {
            while(char_map[iterator_i]>0 && (iterator_i!=(char_max-'a')))
            {
                if(index>=s.length())
                    index=1;
                char_map[iterator_i]--;
                str_reorg[index] = (char)(iterator_i+'a');
                index += 2;
            }
        }
        return new String(str_reorg);
    }

    /*
        242. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)
        Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions )
        so that the resulting parentheses string is valid.

        Formally, a parentheses string is valid if and only if:
            1. It is the empty string, or
            2. It can be written as AB (A concatenated with B), where A and B are valid strings, or
            3. It can be written as (A), where A is a valid string.
        Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

        Example 1:
            Input: s = "())"
            Output: 1

        Example 2:
            Input: s = "((("
            Output: 3

        Example 3:
            Input: s = "()"
            Output: 0

        Example 4:
            Input: s = "()))(("
            Output: 4

        Note:
            s.length <= 1000
            s only consists of '(' and ')' characters.
    */
    public int minAddToMakeValid(String s)
    {
        int min_open=0,op=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                min_open++;
            else
            {
                if(min_open==0)
                    op++;
                else
                    min_open--;
            }
        }
        return op+min_open;
    }

    /*
        243. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-repeating-character-replacement/)
        You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase
        English character. You can perform this operation at most k times.
        Return the length of the longest substring containing the same letter you can get after performing the above operations.

        Example 1:
            Input: s = "ABAB", k = 2
            Output: 4
            Explanation: Replace the two 'A's with two 'B's or vice versa.

        Example 2:
            Input: s = "AABABBA", k = 1
            Output: 4
            Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
            The substring "BBBB" has the longest repeating letters, which is 4.

        Constraints:
            1 <= s.length <= 105
            s consists of only uppercase English letters.
            0 <= k <= s.length
    */
    public int characterReplacement(String s, int k)
    {
        int count[] = new int[26],start=0,max_seq_til_now=0;
        for(int end=0;end<s.length();end++)
        {
            max_seq_til_now = Math.max(max_seq_til_now,++count[s.charAt(end)-'A']);
            if(end-start+1>k+max_seq_til_now) // Not a valid window--- window should decrease
            {
                count[s.charAt(start++)-'A']--;
            }
        }
        return s.length()-start;
    }

    /*
        244. PROBLEM DESCRIPTION (https://leetcode.com/problems/set-matrix-zeroes/)
        Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

        Follow up:
            1.A straight forward solution using O(mn) space is probably a bad idea.
            2.A simple improvement uses O(m + n) space, but still not the best solution.
            3.Could you devise a constant space solution?

        Example 1:
            Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
            Output: [[1,0,1],[0,0,0],[1,0,1]]

        Example 2:
            Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
            Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

        Constraints:
            m == matrix.length
            n == matrix[0].length
            1 <= m, n <= 200
            -231 <= matrix[i][j] <= 231 - 1
    */
    public void setZeroes(int[][] matrix)
    {
        int m = matrix.length,n=matrix[0].length;
        boolean isFirstColSet=false,setRow=false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(j==0)
                        isFirstColSet = true;
                    else
                        matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // Transformation
        for(int i=1;i<m;i++) // RowWise except 1st row
            if(matrix[i][0]==0)
                Arrays.fill(matrix[i],0);
        if(matrix[0][0]==0)
            setRow = true;
        for(int i=0;i<n;i++)
        {
            if((i==0 && isFirstColSet) || (i!=0 && matrix[0][i]==0))
            {
                for(int j=0;j<m;j++)
                    matrix[j][i] = 0;
            }
        }
        if(setRow)
            Arrays.fill(matrix[0],0);
    }

    /*
        245. PROBLEM DESCRIPTION (https://leetcode.com/problems/non-overlapping-intervals/)
        Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need
        to remove to make the rest of the intervals non-overlapping.

        Example 1:
            Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
            Output: 1
            Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

        Example 2:
            Input: intervals = [[1,2],[1,2],[1,2]]
            Output: 2
            Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

        Example 3:
            Input: intervals = [[1,2],[2,3]]
            Output: 0
            Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

        Constraints:
            1 <= intervals.length <= 2 * 104
            intervals[i].length == 2
            -2 * 104 <= starti < endi <= 2 * 104
    */
    public int eraseOverlapIntervals(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)->{return Integer.compare(a[1],b[1]);});
        int x_pos = intervals[0][1],op=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>=x_pos)
                x_pos = intervals[i][1];
            else
                op++;
        }
        return op;
    }

    /*
        246. PROBLEM DESCRIPTION (https://leetcode.com/problems/rotate-image/)
        You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another
        2D matrix and do the rotation.

        Example 1:
            Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
            Output: [[7,4,1],[8,5,2],[9,6,3]]

        Example 2:
            Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
            Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

        Example 3:
            Input: matrix = [[1]]
            Output: [[1]]

        Example 4:
            Input: matrix = [[1,2],[3,4]]
            Output: [[3,1],[4,2]]

        Constraints:
            matrix.length == n
            matrix[i].length == n
            1 <= n <= 20
            -1000 <= matrix[i][j] <= 1000
    */
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++)
        {
            for (int j = 0; j < n / 2; j++)
            {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /*
        247. PROBLEM DESCRIPTION (https://leetcode.com/problems/pacific-atlantic-water-flow/)
        You are given an m x n integer matrix heights representing the height of each unit cell in a continent. The Pacific ocean
        touches the continent's left and top edges, and the Atlantic ocean touches the continent's right and bottom edges.
        Water can only flow in four directions: up, down, left, and right. Water flows from a cell to an adjacent one with an equal
        or lower height.
        Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.

        Example 1:
            Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
            Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

        Example 2:
            Input: heights = [[2,1],[1,2]]
            Output: [[0,0],[0,1],[1,0],[1,1]]

        Constraints:
            m == heights.length
            n == heights[i].length
            1 <= m, n <= 200
            1 <= heights[i][j] <= 105
    */
    int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        List<List<Integer>> result = new ArrayList<>();
        int m=heights.length,n=heights[0].length;
        boolean memo[][] = new boolean[m][n], memo2[][] = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            pacificAtlantichelper(heights,i,0,memo);
            pacificAtlantichelper(heights,i,n-1,memo2);
        }
        for(int j=0;j<n;j++)
        {
            pacificAtlantichelper(heights,0,j,memo);
            pacificAtlantichelper(heights,m-1,j,memo2);
        }
        // Extract results
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(memo[i][j] && memo2[i][j])
                    result.add(new ArrayList<>(Arrays.asList(new Integer[]{i,j})));
            }
        }
        return result;
    }
    public void pacificAtlantichelper(int[][] heights,int row, int col, boolean[][] memo)
    {
        memo[row][col] = true;
        int current_height = heights[row][col];
        for(int[] d:dir)
        {
            int next_row=row+d[0], next_col=col+d[1];
            if(next_row>=0 && next_row<heights.length && next_col>=0 && next_col<heights[0].length && heights[next_row][next_col]>=current_height && !memo[next_row][next_col])
                pacificAtlantichelper(heights,next_row,next_col,memo);
        }
    }

    /*
        248. PROBLEM DESCRIPTION (https://leetcode.com/problems/insert-interval/)
        Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
        You may assume that the intervals were initially sorted according to their start times.

        Example 1:
            Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
            Output: [[1,5],[6,9]]

        Example 2:
            Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
            Output: [[1,2],[3,10],[12,16]]
            Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

        Example 3:
            Input: intervals = [], newInterval = [5,7]
            Output: [[5,7]]

        Example 4:
            Input: intervals = [[1,5]], newInterval = [2,3]
            Output: [[1,5]]

        Example 5:
            Input: intervals = [[1,5]], newInterval = [2,7]
            Output: [[1,7]]

        Constraints:
            0 <= intervals.length <= 104
            intervals[i].length == 2
            0 <= intervals[i][0] <= intervals[i][1] <= 105
            intervals is sorted by intervals[i][0] in ascending order.
            newInterval.length == 2
            0 <= newInterval[0] <= newInterval[1] <= 105
    */
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        if(intervals.length ==0)
            return new int[][]{newInterval};
        int startIndex,i=0,newstart=newInterval[0],size_diff=intervals.length+1,newend=newInterval[1],size_diff2=0;
        while(i<intervals.length && newInterval[0]>intervals[i][0])
            i++;
        startIndex = i-1;
        if(startIndex>=0 && newInterval[0]<=intervals[startIndex][1])
        {
            newstart = Math.min(newstart,intervals[startIndex--][0]);
            size_diff--;
        }
        while(i<intervals.length && newInterval[1]>=intervals[i][0])
        {
            size_diff--;
            i++;
        }
        int endIndex = i-1;
        if(endIndex<intervals.length && endIndex!=-1 && newInterval[1]<=intervals[endIndex][1])
            newend = endIndex==-1?newend:Math.max(newend,intervals[endIndex][1]);
        int result[][] = new int[size_diff][2];
        for(int j=0;j<=startIndex;j++)
            result[j] = intervals[j];
        result[startIndex+1][0] = newstart;
        result[startIndex+1][1] = newend;

        for(int j=startIndex+2;j<result.length;j++)
            result[j] = intervals[++endIndex];

        return result;
    }

    /*
        249. PROBLEM DESCRIPTION (https://leetcode.com/problems/squares-of-a-sorted-array/)
        Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
        non-decreasing order.

        Example 1:
            Input: nums = [-4,-1,0,3,10]
            Output: [0,1,9,16,100]
            Explanation: After squaring, the array becomes [16,1,0,9,100].
                After sorting, it becomes [0,1,9,16,100].

        Example 2:
            Input: nums = [-7,-3,2,3,11]
            Output: [4,9,9,49,121]

        Constraints:
            1 <= nums.length <= 104
            -104 <= nums[i] <= 104
                nums is sorted in non-decreasing order.

        Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a
        different approach?
    */
    public int[] sortedSquares(int[] nums)
    {
        int result[] = new int[nums.length],index=0,result_ptr=0;
        while(index<nums.length && nums[index]<0)
            index++;
        if(index==nums.length)
            index--;
        int pos_ptr=index, neg_ptr=index-1;
        while(pos_ptr<nums.length || neg_ptr>=0)
        {
            int neg_max = (neg_ptr>=0?nums[neg_ptr]*nums[neg_ptr]:Integer.MAX_VALUE);
            int pos_max = (pos_ptr>=nums.length?Integer.MAX_VALUE:nums[pos_ptr]*nums[pos_ptr]);
            if(neg_max<=pos_max)
            {
                result[result_ptr++] = neg_max;
                neg_ptr--;
            }
            else
            {
                result[result_ptr++]= pos_max;
                pos_ptr++;
            }
        }
        return result;
    }

    /*
        250. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-word-in-dictionary/)
        Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one
        character at a time by other words in words.
        If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no
        answer, return the empty string.

        Example 1:
            Input: words = ["w","wo","wor","worl","world"]
            Output: "world"
            Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

        Example 2:
            Input: words = ["a","banana","app","appl","ap","apply","apple"]
            Output: "apple"
            Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is
            lexicographically smaller than "apply".

        Constraints:
            1 <= words.length <= 1000
            1 <= words[i].length <= 30
            words[i] consists of lowercase English letters.
    */
    public class TrieNode
    {
        char val;
        TrieNode child[];
        int num_child;
        public TrieNode(char val)
        {
            this.val = val;
            child = new TrieNode[257];
            num_child=0;
        }
    }

    public TrieNode checkCompatibility(TrieNode trie,String word)
    {
        for(int i=0;i<word.length()-1;i++)
        {
            for(int j=0;j<trie.num_child;j++)
            {
                //System.out.println(word.charAt(i)+" "+trie.child[j].val);
                if(trie.child[j].val == word.charAt(i))
                {
                    trie = trie.child[j];
                    break;
                }
            }
            if(trie.val!=word.charAt(i))
                return null;
        }
        return trie;
    }

    public void insertTrie(TrieNode trie,char c)
    {
        trie.child[trie.num_child++] = new TrieNode(c);
    }

    public String longestWord(String[] words)
    {
        Arrays.sort(words);
        String max_str = "";
        int index=0;
        TrieNode mytrie = new TrieNode('X');
        while(index<words.length)
        {
            TrieNode insertNode = checkCompatibility(mytrie,words[index]);
            //System.out.println("Out"+words[index]+" "+insertNode);
            if(insertNode!=null)
            {
                if(max_str.length()<words[index].length())
                    max_str = words[index];
                insertTrie(insertNode,words[index].charAt(words[index].length()-1));
            }
            index++;
        }

        return max_str;
    }
    /*
        251. PROBLEM DESCRIPTION (https://leetcode.com/problems/all-possible-full-binary-trees/)
        Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer
        must have Node.val == 0.
        Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
        A full binary tree is a binary tree where each node has exactly 0 or 2 children.

        Example 1:
            Input: n = 7
            Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],
            [0,0,0,0,0,null,null,0,0]]

        Example 2:
            Input: n = 3
            Output: [[0,0,0]]

        Constraints:
        1 <= n <= 20
    */
    HashMap<Integer,List<TreeNode>> fulltrees = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n)
    {
        if(fulltrees.containsKey(n))
            return fulltrees.get(n);
        List<TreeNode> result = new ArrayList<>();
        if(n==1 && !fulltrees.containsKey(1))
        {
            result.add(new TreeNode(0));
            fulltrees.put(1,result);
        }
        for(int i=1;i<n;i+=2)
        {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            for(TreeNode lchild :left)
            {
                for(TreeNode rchild: right)
                {
                    TreeNode currenttree = new TreeNode(0);
                    currenttree.left = lchild;
                    currenttree.right = rchild;
                    result.add(currenttree);
                }
            }

        }
        fulltrees.put(n,result);

        return fulltrees.get(n);
    }
    /*
        252. PROBLEM DESCRIPTION (https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/)
        Given a rectangle of size n x m, find the minimum number of integer-sided squares that tile the rectangle.

        Example 1:
            Input: n = 2, m = 3
            Output: 3
            Explanation: 3 squares are necessary to cover the rectangle.
                2 (squares of 1x1)
                1 (square of 2x2)

        Example 2:
            Input: n = 5, m = 8
            Output:

        Example 3:
        Input: n = 11, m = 13
        Output: 6

        Constraints:
            1 <= n <= 13
            1 <= m <= 13
    */
    public int tilingRectangle(int n, int m) {
        return -1;
    }

    /*
        253. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)
        Given an array of integers nums and an integer target. Return the number of non-empty subsequences of nums such that the sum
        of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

        Example 1:
            Input: nums = [3,5,6,7], target = 9
            Output: 4
            Explanation: There are 4 subsequences that satisfy the condition.
                [3] -> Min value + max value <= target (3 + 3 <= 9)
                [3,5] -> (3 + 5 <= 9)
                [3,5,6] -> (3 + 6 <= 9)
                [3,6] -> (3 + 6 <= 9)

        Example 2:
            Input: nums = [3,3,6,8], target = 10
            Output: 6
            Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
                [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]

        Example 3:
            Input: nums = [2,3,3,4,6,7], target = 12
            Output: 61
            Explanation: There are 63 non-empty subsequences, two of them don't satisfy the condition ([6,7], [7]).
            Number of valid subsequences (63 - 2 = 61).

        Example 4:
            Input: nums = [5,2,4,1,7,6,8], target = 16
            Output: 127
            Explanation: All non-empty subset satisfy the condition (2^7 - 1) = 127

        Constraints:
            1 <= nums.length <= 105
            1 <= nums[i] <= 106
            1 <= target <= 106
    */
    public int numSubseq(int[] nums, int target)
    {
        int max_allowed=nums.length-1;
        int count=0,modval = (int)(Math.pow(10,9)+7);
        Arrays.sort(nums);
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i=1;i<nums.length;i++)
            pows[i] = pows[i - 1]*2 % modval;
        for(int i=0;i<nums.length;i++)
        {
            while(max_allowed>i && nums[max_allowed]+nums[i]>target)
                max_allowed--;
            count = (int)((count+pows[max_allowed-i<0?0:max_allowed-i])%modval);
            count -= (2*nums[i]>target?1:0);
        }
        return (int)count;
    }

    /*
        254. PROBLEM DESCRIPTION (https://leetcode.com/problems/repeated-dna-sequences/)
        The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
        For example, "ACGAATTCCG" is a DNA sequence. When studying DNA, it is useful to identify repeated sequences within the DNA.
        Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than
        once in a DNA molecule. You may return the answer in any order.

        Example 1:
            Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
            Output: ["AAAAACCCCC","CCCCCAAAAA"]

        Example 2:
            Input: s = "AAAAAAAAAAAAA"
            Output: ["AAAAAAAAAA"]

        Constraints:
            1 <= s.length <= 105
            s[i] is either 'A', 'C', 'G', or 'T'.
    */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> hset = new HashSet<>(),visited = new HashSet<>();
        for(int i=10;i<=s.length();i++)
        {
            String seq = s.substring(i-10,i);
            if(!visited.contains(seq) && !hset.add(seq))
            {
                result.add(s.substring(i-10,i));
                visited.add(seq);
            }
        }
        return result;
    }

    /*
        255. PROBLEM DESCRIPTION (https://leetcode.com/problems/k-closest-points-to-origin/)
        Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k
        closest points to the origin (0, 0).
        The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
        You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

        Example 1:
            Input: points = [[1,3],[-2,2]], k = 1
            Output: [[-2,2]]
            Explanation:
                The distance between (1, 3) and the origin is sqrt(10).
                The distance between (-2, 2) and the origin is sqrt(8).
                Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
                We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

        Example 2:
            Input: points = [[3,3],[5,-1],[-2,4]], k = 2
            Output: [[3,3],[-2,4]]
            Explanation: The answer [[-2,4],[3,3]] would also be accepted.

        Constraints:
            1 <= k <= points.length <= 104
            -104 < xi, yi < 104
    */
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{return Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]);});
    public int[][] kClosest(int[][] points, int k)
    {
        for(int i=0;i<points.length;i++)
        {
            pq.add(points[i]);
            if(pq.size()>k)
                pq.poll();

        }
        int result[][] = new int[k][2],top=0;
        for(int i=0;i<k;i++)
            result[top++] =pq.poll();
        return result;
    }

    /*
        256. PROBLEM DESCRIPTION (https://leetcode.com/problems/sort-array-by-parity/)
        Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all
        the odd elements of nums.
        You may return any answer array that satisfies this condition.

        Example 1:
            Input: nums = [3,1,2,4]
            Output: [2,4,3,1]
            The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

        Note:
            1 <= nums.length <= 5000
            0 <= nums[i] <= 5000
    */
    public int[] sortArrayByParity(int[] nums) {
        int front=0,rear=nums.length-1;
        while(front<rear)
        {
            if(nums[front]%2==0)
                front++;
            else if(nums[rear]%2!=0)
                rear--;
            else
            {
                int temp = nums[front];
                nums[front++] = nums[rear];
                nums[rear--] = temp;
            }
        }
        return nums;
    }

    /*
        257. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/)
        You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
        You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
            1.Choose one integer x from either the start or the end of the array nums.
            2.Add multipliers[i] * x to your score.
            3.Remove x from the array nums.
        Return the maximum score after performing m operations.

        Example 1:
            Input: nums = [1,2,3], multipliers = [3,2,1]
            Output: 14
            Explanation: An optimal solution is as follows:
                - Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
                - Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
                - Choose from the end, [1], adding 1 * 1 = 1 to the score.
                The total score is 9 + 4 + 1 = 14.

        Example 2:
            Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
            Output: 102
            Explanation: An optimal solution is as follows:
                - Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
                - Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
                - Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
                - Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
                - Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
                The total score is 50 + 15 - 9 + 4 + 42 = 102.

        Constraints:
            n == nums.length
            m == multipliers.length
            1 <= m <= 103
            m <= n <= 105
            -1000 <= nums[i], multipliers[i] <= 1000
    */
    public int maximumScore(int[] nums, int[] multipliers)
    {
        int m=multipliers.length,dp[][] = new int[m+1][m+1],n=nums.length;
        return helper(dp,0,0,m,n,nums,multipliers);
    }
    public int helper(int dp[][], int left_count,int right_count,int m,int n,int []nums,int[] multiplier)
    {
        if(m==left_count+right_count)
            return 0;
        if(dp[left_count][right_count]!=0)
            return dp[left_count][right_count];
        int includeleft = helper(dp,left_count+1,right_count,m,n,nums,multiplier)+nums[left_count]*multiplier[left_count+right_count];
        int includeright = helper(dp,left_count,right_count+1,m,n,nums,multiplier)+nums[n-right_count-1]*multiplier[left_count+right_count];

        dp[left_count][right_count] = Math.max(includeleft,includeright);
        return dp[left_count][right_count];

    }
    /*
        258. PROBLEM DESCRIPTION (https://leetcode.com/problems/largest-perimeter-triangle/)
        Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these
        lengths. If it is impossible to form any triangle of a non-zero area, return 0.

        Example 1:
            Input: nums = [2,1,2]
            Output: 5

        Example 2:
            Input: nums = [1,2,1]
            Output: 0

        Example 3:
            Input: nums = [3,2,3,4]
            Output: 10

        Example 4:
            Input: nums = [3,6,2,3]
            Output: 8

        Constraints:
            3 <= nums.length <= 104
            1 <= nums[i] <= 106
    */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; --i)
            if (nums[i] + nums[i+1] > nums[i+2])
                return nums[i] + nums[i+1] + nums[i+2];
        return 0;
    }

    /*
        259. PROBLEM DESCRIPTION (https://leetcode.com/problems/duplicate-zeros/)
        Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
        Note that elements beyond the length of the original array are not written.
        Do the above modifications to the input array in place, do not return anything from your function.

        Example 1:
            Input: [1,0,2,3,0,4,5,0]
            Output: null
            Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

        Example 2:
            Input: [1,2,3]
            Output: null
            Explanation: After calling your function, the input array is modified to: [1,2,3]

        Note:
            1 <= arr.length <= 10000
            0 <= arr[i] <= 9
    */
    public void duplicateZeros(int[] arr) {
        int index=0,len=arr.length,pos_left=len,ptr=len-1;
        while(pos_left>0)
        {
            if(arr[index++]==0)
                pos_left-=2;
            else
                pos_left--;
        }
        index--;
        if(pos_left<0)
        {
            arr[ptr--] = 0;
            index--;
        }
        while(ptr>=0)
        {
            arr[ptr--] = arr[index];
            if(arr[index]==0)
                arr[ptr--] = arr[index];
            index--;
        }
    }

    /*
        260. PROBLEM DESCRIPTION (https://leetcode.com/problems/relative-sort-array/)
        Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
        Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't
        appear in arr2 should be placed at the end of arr1 in ascending order.

        Example 1:
            Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
            Output: [2,2,2,1,4,3,3,9,6,7,19]

        Constraints:
            1 <= arr1.length, arr2.length <= 1000
            0 <= arr1[i], arr2[i] <= 1000
            All the elements of arr2 are distinct.
            Each arr2[i] is in arr1.
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<arr1.length;i++)
            hmap.put(arr1[i],hmap.getOrDefault(arr1[i],0)+1);
        int index=0;
        for(int val:arr2)
        {
            if(hmap.containsKey(val))
            {
                int count = hmap.remove(val);
                for(int i=0;i<count;i++)
                    arr1[index++] = val;
            }
        }
        int start = index;
        for(int val:hmap.keySet())
        {
            for(int i=0;i<hmap.get(val);i++)
                arr1[index++] = val;
        }
        Arrays.sort(arr1,start,arr1.length);
        return arr1;
    }

    /*
        261. PROBLEM DESCRIPTION (https://leetcode.com/discuss/interview-question/1469039/Amazon-OA-CountMaximumTeams/1086834)

    */

    public int countMaximumTeams(int skill[],int size,int maxDiff)
    {
        Arrays.sort(skill);
        int count=0,end=0,i=0;
        while(i<skill.length)
        {
            while(end<skill.length && end-i<size && skill[i]+maxDiff>=skill[end])
                end++;
            System.out.println(i+" "+(end-i-1));
            if(end-i==size)
                count+= 1;
            i = end;
        }
        return count;
    }

    /*
        262. PROBLEM DESCRIPTION (https://leetcode.com/discuss/interview-question/1501685/AMAZON-or-OA-or-Find-Valid-Discount-Coupons)

    */

    public boolean isValidDiscountOA(String discount)
    {
        Stack<Character> stck = new Stack<>();
        for(char c: discount.toCharArray())
        {
            if(stck.isEmpty())
                stck.add(c);
            else
            {
                if(stck.peek()==c)
                    stck.pop();
                else
                    stck.push(c);
            }
        }
        return stck.isEmpty();
    }

    /*
        263. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
        You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between
        ai and bi in the graph.
        Return the number of connected components in the graph.
    */
    public int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        int count=0;
        HashMap<Integer,List<Integer>> conn = new HashMap<>();
        for(int e[]:edges)
        {
            if(!conn.containsKey(e[0]))
                conn.put(e[0],new ArrayList<Integer>());
            if(!conn.containsKey(e[1]))
                conn.put(e[1],new ArrayList<Integer>());
            conn.get(e[0]).add(e[1]);
            conn.get(e[1]).add(e[0]);
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i])
                continue;
            dfs_helper(conn,visited,i);
            count++;
        }

        return count;
    }

    public void dfs_helper(HashMap<Integer,List<Integer>> conn,boolean visited[],int cur_node)
    {
        visited[cur_node] = true;
        if(!conn.containsKey(cur_node))
            return;
        for(Integer adj:conn.get(cur_node))
        {
            if(!visited[adj])
                dfs_helper(conn,visited,adj);
        }
    }

    /*
        264. PROBLEM DESCRIPTION (https://leetcode.com/problems/powx-n/submissions/)
        Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

        Example 1:
            Input: x = 2.00000, n = 10
            Output: 1024.00000

        Example 2:
            Input: x = 2.10000, n = 3
        Output: 9.26100

        Example 3:
            Input: x = 2.00000, n = -2
            Output: 0.25000
            Explanation: 2-2 = 1/22 = 1/4 = 0.25

        Constraints:
            -100.0 < x < 100.0
            -231 <= n <= 231-1
            -104 <= xn <= 104
    */
    HashMap<Integer,HashMap<Double,Double>> hmap = new HashMap<>();
    public double myPow(double x, int n)
    {
        if(hmap.containsKey(n) && hmap.get(n).containsKey(x))
            return hmap.get(n).get(x);
        double val=1;
        if(n<0)
            val = myPow(x,n/2)* myPow(x,n/2)* (n%2!=0?1.0/x:1);
        else if(n>0)
            val = myPow(x,n/2) * myPow(x,n/2) * (n%2!=0?x:1);
        if(!hmap.containsKey(n))
            hmap.put(n,new HashMap<Double,Double>());
        HashMap nhmap = hmap.get(n);
        nhmap.put(x,val);
        return val;
    }

    /*
        265. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-nice-pairs-in-an-array/)
        You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For
        example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
            0 <= i < j < nums.length
            nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.

        Example 1:
            Input: nums = [42,11,1,97]
            Output: 2
            Explanation: The two pairs are:
                - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
                - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.

        Example 2:
            Input: nums = [13,10,35,24,76]
            Output: 4

        Constraints:
            1 <= nums.length <= 105
            0 <= nums[i] <= 109
    */
    public int countNicePairs(int[] nums)
    {
        long rev[] = new long[nums.length];
        int mod = (int)(Math.pow(10,9))+7,count=0;
        for(int i=0;i<nums.length;i++)
            rev[i] = reversehelper(nums[i]);
        //Change rev to difference
        HashMap<Long,Integer> hmap= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            rev[i] = rev[i]- nums[i];
            if(hmap.containsKey(rev[i]))
                count = (count + hmap.get(rev[i]))%mod;

            hmap.put(rev[i],hmap.getOrDefault(rev[i],0)+1);
        }
        return count;
    }
    public long reversehelper(int num)
    {
        long res=0;
        int count=0,temp=num;
        while(num>0)
        {
            count++;
            num/=10;
        }
        num=temp;
        while(num>0)
        {
            res =res + (int)(Math.pow(10,--count))*(num%10);
            num /= 10;
        }
        return res;
    }

    /*
        266. PROBLEM DESCRIPTION (https://leetcode.com/problems/rotating-the-box/)
        You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
            A stone '#'
            A stationary obstacle '*'
            Empty '.'
        The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an
        obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation
        does not affect the stones' horizontal positions.
        It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

        Return an n x m matrix representing the box after the rotation described above.
    */
    public char[][] rotateTheBox(char[][] box)
    {
        int n=box.length, m=box[0].length;
        char [][] res= new char[m][n];
        for(int i=0;i<n;i++)
        {
            int rock_avai=m-1;
            for(int j=m-1;j>=0;j--)
            {
                char c = box[i][j];
                if(c=='#')// stone
                    res[rock_avai--][n-i-1] = '#';
                else if(c=='*')
                {
                    res[j][n-i-1] = '*';
                    rock_avai = j-1;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                if(res[i][j]=='\u0000')
                    res[i][j] = '.';
        }
        return res;
    }

    /*
        266. PROBLEM DESCRIPTION (https://leetcode.com/problems/squirrel-simulation/)
        You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
            A stone '#'
            A stationary obstacle '*'
            Empty '.'
        The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an
        obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation
        does not affect the stones' horizontal positions.
        It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

        Return an n x m matrix representing the box after the rotation described above.
    */
    //int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    int pathcost=0;
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts)
    {
        int dist=Integer.MAX_VALUE,pos=-1,cost=0;
        for(int i=0;i<nuts.length;i++)
        {
            cost += 2* (Math.abs(nuts[i][0]-tree[0])+Math.abs(nuts[i][1]-tree[1]));
            int dp = getDistance(nuts[i],squirrel)-getDistance(nuts[i],tree);
            if(dp<dist)
            {
                dist = dp;
                pos=i;
            }

        }
        cost += dist;
        return cost;
    }
    public int getDistance(int x[],int y[])
    {
        return Math.abs(x[0]-y[0])+ Math.abs(x[1]-y[1]);
    }

    /*
        267. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximal-network-rank/)
    */
    public int maximalNetworkRank(int n, int[][] roads)
    {
        int connections[]=new int[n];
        Integer max=null;
        HashMap<Integer,HashSet<Integer>> hmap = new HashMap<>();
        for(int i=0;i<n;i++)
            hmap.put(i,new HashSet<Integer>());
        boolean conn_flag=false;
        for(int i=0;i<roads.length;i++)
        {
            connections[roads[i][0]]++;
            connections[roads[i][1]]++;
            hmap.get(roads[i][0]).add(roads[i][1]);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(max==null || max<(connections[i]+connections[j]+((hmap.get(i).contains(j)||hmap.get(j).contains(i))?-1:0)))
                    max = connections[i]+connections[j]+((hmap.get(i).contains(j)||hmap.get(j).contains(i))?-1:0);
            }
        }
        return max;
    }

    /*
        268. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-paths-iii/)
    */
    public int uniquePathsIII(int[][] grid)
    {
        int m=grid.length,n= grid[0].length,start_r=-1,start_c=-1;
        HashSet<Integer> empty = new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=-1)
                    empty.add(i*n+j);
                if(grid[i][j]==1)
                {
                    start_r = i;
                    start_c = j;
                }
            }
        }
        return uniquePaths3helper(grid,start_r,start_c,empty,m,n);
    }
    public int uniquePaths3helper(int[][] grid,int row,int col,HashSet<Integer> empty,int m,int n)
    {
        if(grid[row][col]==2)
        {
            if(empty.size()==1)
                return 1;
            return 0;
        }
        empty.remove(row*n+col);
        int current_paths=0;
        for(int d[]:dir)
        {
            int nr = row+d[0],nc= col+d[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && empty.contains(nr*n+nc) && grid[nr][nc]!=-1)
                current_paths += uniquePaths3helper(grid,nr,nc,empty,m,n);
        }
        empty.add(row*n+col);
        return current_paths;
    }

    /*
        269. PROBLEM DESCRIPTION (https://leetcode.com/problems/clone-graph/)
    */
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node)
    {
        if(node==null)
            return null;
        HashMap<Integer,Node> hmap = new HashMap<>();
        hmap.put(node.val,new Node(node.val));
        cloneNode(node,hmap);
        return hmap.get(node.val);
    }
    public void cloneNode(Node node,HashMap<Integer,Node> hmap)
    {
        for(Node nbr:node.neighbors)
        {
            if(!hmap.containsKey(nbr.val))
            {
                hmap.put(nbr.val,new Node(nbr.val));
                cloneNode(nbr,hmap);
            }
            hmap.get(node.val).neighbors.add(hmap.get(nbr.val));
        }
    }

    /*
        270. PROBLEM DESCRIPTION (https://leetcode.com/problems/integer-to-english-words/)
    */

    public String combine_digits(int x,int y,int z)
    {
        String result = "";
        result+= spell_digits(x,3);
        if(y==1 && z!=0)
        {
            switch(z)
            {
                case 1:
                    result += "Eleven ";
                    break;
                case 2:
                    result += "Twelve ";
                    break;
                case 3:
                    result += "Thirteen ";
                    break;
                case 4:
                    result += "Fourteen ";
                    break;
                case 5:
                    result += "Fifteen ";
                    break;
                case 6:
                    result += "Sixteen ";
                    break;
                case 7:
                    result += "Seventeen ";
                    break;
                case 8:
                    result += "Eighteen ";
                    break;
                case 9:
                    result += "Nineteen ";
                    break;
            }
            return result;
        }
        result+= spell_digits(y,2);
        result+= spell_digits(z,1);
        return result;
    }

    public String spell_digits(int digit,int pos)
    {
        String result="";
        if(pos==2)
        {
            switch(digit)
            {
                case 1:
                    result = "Ten ";
                    break;
                case 2:
                    result = "Twenty ";
                    break;
                case 3:
                    result = "Thirty ";
                    break;
                case 4:
                    result = "Forty ";
                    break;
                case 5:
                    result = "Fifty ";
                    break;
                case 6:
                    result = "Sixty ";
                    break;
                case 7:
                    result = "Seventy ";
                    break;
                case 8:
                    result = "Eighty ";
                    break;
                case 9:
                    result = "Ninety ";
                    break;
            }

        }
        else
        {
            switch(digit)
            {
                case 1:
                    result = "One ";
                    break;
                case 2:
                    result = "Two ";
                    break;
                case 3:
                    result = "Three ";
                    break;
                case 4:
                    result = "Four ";
                    break;
                case 5:
                    result = "Five ";
                    break;
                case 6:
                    result = "Six ";
                    break;
                case 7:
                    result = "Seven ";
                    break;
                case 8:
                    result = "Eight ";
                    break;
                case 9:
                    result = "Nine ";
                    break;
            }
        }
        if(pos==3 && digit!=0)
            result += "Hundred ";
        return result;

    }

    public String numberToWords(int num)
    {
        if(num==0)
            return "Zero";
        String result = "";
        int count=0;
        while(num!=0)
        {
            int d3=num%10;
            num/=10;
            int d2 = num%10;
            num/=10;
            int d1 = num%10;
            num /= 10;
            String sub = combine_digits(d1,d2,d3);
            if(sub.length()>0)
            {
                if(count==1)
                    sub += "Thousand ";
                else if(count==2)
                    sub += "Million ";
                else if(count==3)
                    sub += "Billion ";
            }
            count++;
            result = sub+result;
        }
        return result.trim();
    }

    /*
        271. PROBLEM DESCRIPTION (https://leetcode.com/problems/meeting-rooms-ii/)
    */
    public int minMeetingRooms(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)->{return Integer.compare(a[0],b[0]);});
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int max_rooms=0;
        for(int i=0;i<intervals.length;i++)
        {
            if(!pq.isEmpty() && pq.peek()<=intervals[i][0])
                pq.poll();
            pq.add(intervals[i][1]);
            max_rooms = Math.max(max_rooms,pq.size());
        }
        return max_rooms;
    }

    /*
        272. PROBLEM DESCRIPTION (https://leetcode.com/problems/the-maze-ii/)
    */
    public int shortestDistance(int[][] maze, int[] start, int[] destination)
    {
        int m=maze.length,n=maze[0].length;
        int mindist = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1],0});
        HashMap<Integer,Integer> visited = new HashMap<>();
        while(!q.isEmpty())
        {
            Queue<int[]> nq = new LinkedList<>();
            for(int[] pos:q)
            {
                if(pos[2]>mindist)
                    continue;
                //System.out.println(pos[0]+" "+pos[1]+" "+pos[2]);
                if(pos[0]==destination[0] && pos[1]==destination[1])
                    mindist = Math.min(mindist,pos[2]);
                visited.put(pos[0]*n+pos[1],pos[2]);
                // Direction 1
                int nr=pos[0],nc=pos[1],step=pos[2];
                while(nr<m-1 && maze[nr+1][nc]==0)
                {
                    step++;
                    nr++;
                }
                if(visited.getOrDefault(nr*n+nc,Integer.MAX_VALUE)>step)
                    nq.add(new int[]{nr,nc,step});
                nr=pos[0];
                nc = pos[1];
                step = pos[2];
                while(nr>0 && maze[nr-1][nc]==0)
                {
                    step++;
                    nr--;
                }
                if(visited.getOrDefault(nr*n+nc,Integer.MAX_VALUE)>step)
                    nq.add(new int[]{nr,nc,step});
                nr=pos[0];
                nc = pos[1];
                step = pos[2];
                while(nc>0 && maze[nr][nc-1]==0)
                {
                    step++;
                    nc--;
                }
                if(visited.getOrDefault(nr*n+nc,Integer.MAX_VALUE)>step)
                    nq.add(new int[]{nr,nc,step});
                nr=pos[0];
                nc = pos[1];
                step = pos[2];
                while(nc<n-1 && maze[nr][nc+1]==0)
                {
                    step++;
                    nc++;
                }
                if(visited.getOrDefault(nr*n+nc,Integer.MAX_VALUE)>step)
                    nq.add(new int[]{nr,nc,step});
            }
            q = nq;
        }
        return mindist==Integer.MAX_VALUE?-1:mindist;
    }

}
