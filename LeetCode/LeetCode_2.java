package LeetCode;

import java.util.*;

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
}
