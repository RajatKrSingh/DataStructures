package LeetCode;

import com.sun.org.apache.xerces.internal.xs.StringList;
import LeetCode.Revision;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static LeetCode.LeetCode.create_binary_tree;
import static LeetCode.LeetCode.create_linked_list;

public class Runner {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        LeetCode obj = new LeetCode();
        LeetCode_2 obj_2 = new LeetCode_2();
        Revision rev_obj = new Revision();

        /** Driver Code for Q1. twoSum
         **
         */

//        System.out.println("Enter length\n");
//        int length = sc.nextInt();
//
//        System.out.println("Enter numbers\n");
//        int nums[] = new int[length];
//        for(int i=0;i<length;i++)
//            nums[i] = sc.nextInt();
//
//        System.out.println("Enter target\n");
//        int target = sc.nextInt();
//
//        int result[] = new int[2];
//        result = obj.twoSum(nums,target);
//        result = rev_obj.twoSum(nums,target);
//
//        System.out.println(result[0]+" "+result[1]);

        /** Driver Code for Q2. addTwoNumbers
         **
         */
//        int len1,len2;
//        System.out.println("Enter lengths");
//        len1 = sc.nextInt();
//        len2 = sc.nextInt();
//        System.out.println("Enter first list");
//        ListNode temp = null;
//        ListNode firstList=null,secondList=null;
//        for(int i=0;i<len1;i++)
//        {
//            ListNode l1 = new ListNode(sc.nextInt());
//            if (temp == null) {
//                temp = l1;
//                firstList = temp;
//            } else {
//                temp.next = l1;
//                temp = l1;
//            }
//        }
//        temp = null;
//        System.out.println("Enter second list");
//        for(int i=0;i<len2;i++)
//        {
//            ListNode l1 = new ListNode(sc.nextInt());
//            if (temp == null) {
//                temp = l1;
//                secondList = temp;
//            } else {
//                temp.next = l1;
//                temp = l1;
//            }
//        }
//        ;
//        obj.DisplayList(obj.addTwoNumbers(firstList, secondList));


        /** Driver Code for Q3. lengthOfLongestSubstring
         **
         */
//        System.out.println("Enter string\n");
//        String str = sc.next();
//        System.out.println(obj.lengthOfLongestSubstring(str));


        /** Driver Code for Q4. reverse
         **
         */

//        System.out.println("Enter number");
//        int num = sc.nextInt();
//        System.out.println(obj.reverse(num));

        /** Driver Code for Q5. myAtoi
         **
         */

//        System.out.println("Enter number");
//        String str = sc.next();
//        System.out.println(obj.myAtoi(str));

        /** Driver Code for Q6. isPalindrome
         **
         */

//        System.out.println("Enter number");
//        int num = sc.nextInt();
//        System.out.println(obj.isPalindrome(num));

        /** Driver Code for Q7. intToRoman
         **
         */
//        System.out.println("Enter number");
//        int num = sc.nextInt();
//        System.out.println(obj.intToRoman(num));

        /** Driver Code for Q8. longestCommonPrefix
         **
         */
//        System.out.println("Enter number of string");
//        int len = sc.nextInt();
//        String str[] = new String[len];
//        for(int i=0;i<len;i++)
//            str[i] = sc.next();
//        System.out.println(obj.longestCommonPrefix(str));

        /** Driver Code for Q9. isValid
         **
         */
//        System.out.println("Enter string");
//        String str = sc.next();
//        System.out.println(obj.isValid(str));

        /** Driver Code for Q10. mergeTwoLists
         **
         */
//        int len1,len2;
//        System.out.println("Enter lengths\n");
//        len1 = sc.nextInt();
//        len2 = sc.nextInt();
//        System.out.println("Enter first list");
//        ListNode temp = null;
//        ListNode firstList=null,secondList=null;
//        for(int i=0;i<len1;i++)
//        {
//            ListNode l1 = new ListNode(sc.nextInt());
//            if (temp == null) {
//                temp = l1;
//                firstList = temp;
//            } else {
//                temp.next = l1;
//                temp = l1;
//            }
//        }
//        temp = null;
//        System.out.println("Enter second list\n");
//        for(int i=0;i<len2;i++)
//        {
//            ListNode l1 = new ListNode(sc.nextInt());
//            if (temp == null) {
//                temp = l1;
//                secondList = temp;
//            } else {
//                temp.next = l1;
//                temp = l1;
//            }
//        }
//        ;
//        obj.DisplayList(obj.mergeTwoLists(firstList, secondList));


        /** Driver Code for Q11. removeDuplicates
         **
         */
//        System.out.println("Enter length");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//        obj.removeDuplicates(arr);

        /** Driver Code for Q12. removeElement
         **
         */
//        System.out.println("Enter length");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//        System.out.println("Enter value");
//        int val=sc.nextInt();
//        obj.removeElement(arr,val);

        /** Driver Code for Q13. countAndSay
         **
         */
//        System.out.println("Enter n");
//        int n = sc.nextInt();
//        obj.countAndSay(n);

        /** Driver Code for Q14. searchInsert
         **
         */
//        System.out.println("Enter length of array");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i]= sc.nextInt();
//        System.out.println("Enter target");
//        int target = sc.nextInt();
//        System.out.println(obj.searchInsert(arr,target));


        /** Driver Code for Q15. plusOne
         **
         */
//        System.out.println("Enter length");
//        int len = sc.nextInt();
//        int digits[] = new int[len];
//        for(int i=0;i<len;i++)
//            digits[i] = sc.nextInt();
//        obj.plusOne(digits);

        /** Driver Code for Q16. mySqrt
         **
         */
//        System.out.println("Enter number");
//        int square = sc.nextInt();
//        System.out.println(obj.mySqrt(square));

        /** Driver Code for Q17. lengthOfLastWord
         **
         */
//        System.out.println("Enter String");
//        String str = sc.nextLine();
//        str ="";
//        System.out.println(obj.lengthOfLastWord(str));


        /** Driver Code for Q18. addBinary
         **
         */
//        System.out.println("Enter binary strings");
//        String bin1 = sc.next();
//        String bin2 = sc.next();
//        System.out.println(obj.addBinary(bin1,bin2));

        /** Driver Code for Q19. climbStairs
         **
         */
//        System.out.println("Enter n");
//        int n = sc.nextInt();
//        System.out.println(obj.climbStairs(n));


        /** Driver Code for Q20. merge
         **
         */
//        System.out.println("Enter array lengths");
//        int len1 = sc.nextInt();
//        int len2 = sc.nextInt();
//        int arr1[] = new int[len1+len2];
//        int arr2[] = new int[len2];
//        System.out.println("Enter numbers");
//        for(int i=0;i<len1;i++)
//            arr1[i] = sc.nextInt();
//        for(int i=0;i<len2;i++)
//            arr2[i] = sc.nextInt();
//
//        obj.merge(arr1,len1,arr2,len2);
//
//        for(int i=0;i<len1+len2;i++)
//            System.out.print( arr1[i] + " ");

        /** Driver Code for Q21. singleNumber
         **
         */
//        System.out.println("Enter length");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        System.out.println("Enter elements");
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//
//        System.out.println(obj.singleNumber(arr));

        /** Driver Code for Q22. maxProfit
         **
         */
//        System.out.println("Enter length ");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//
//        System.out.println(obj.maxProfit(arr));

        /** Driver Code for Q23. maxProfit1
         **
         */
//        System.out.println("Enter length ");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//
//        System.out.println(obj.maxProfit1(arr));

        /** Driver Code for Q24. isPalindrome
         **
         */
//        System.out.println("Enter string");
//        String str = sc.nextLine();
//        System.out.println(obj.isPalindrome(str));


        /** Driver Code for Q25. strStr()
         **
         */
//            System.out.println("Enter haystack and needle");
//            String haystack = sc.nextLine();
//            String needle = sc.nextLine();
//            System.out.println("Found at: "+obj.strStr1(haystack,needle));

        /** Driver Code for Q26. permute()
         *
         */
//            System.out.println("Enter array");
//            int input_arr[] = obj.create_array_int(sc);
//            obj.permute(input_arr);

        /** Driver Code for Q27. permuteUnique()
         *
         */
//            System.out.println("Enter array");
//            int input_arr[] = obj.create_array_int(sc);
//            obj.permuteUnique(input_arr);

        /** Driver Code for Q28. multiply()
         *
         */
//            System.out.println("Enter numbers");
//            System.out.println(obj.multiply(sc.next(),sc.next()));

        /** Driver Code for Q29. generateParenthesis()
         *
         */
//        System.out.println("Enter n");
//        obj.generateParenthesis(sc.nextInt());

        /** Driver Code for Q30.combinationSum
         *
         */
//        int candidates[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        obj.combinationSum(candidates,sc.nextInt());

        /** Driver Code for Q31.combinationSum2
         *
         */
//        int candidates[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        rev_obj.combinationSum2(candidates,sc.nextInt());

        /** Driver Code for Q32.isValidSudoku
         *
         */
//        System.out.println("Enter board");
//        char board[][] = new char[9][9];
//        for(int iterator_i=0;iterator_i<9;iterator_i++)
//            for(int iterator_j=0;iterator_j<9;iterator_j++)
//                board[iterator_i][iterator_j] = sc.next().charAt(0);
//        obj.isValidSudoku(board);

        /** Driver Code for Q33.solveSudoku
         *
         */
//        System.out.println("Enter board");
//        char board[][] ={{'5','3','.','.','7','.','.','.','.'},
//                        {'6','.','.','1','9','5','.','.','.'},
//                        {'.','9','8','.','.','.','.','6','.'},
//                        {'8','.','.','.','6','.','.','.','3'},
//                        {'4','.','.','8','.','3','.','.','1'},
//                        {'7','.','.','.','2','.','.','.','6'},
//                        {'.','6','.','.','.','.','2','8','.'},
//                        {'.','.','.','4','1','9','.','.','5'},
//                        {'.','.','.','.','8','.','.','7','9'}
//                        };
//        rev_obj.solveSudoku(board);

        /** Driver Code for Q34.threeSum
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.threeSum(input_arr);

        /** Driver Code for Q34.threeSumClosest
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        System.out.println("Closest Sum is: " +obj.threeSumClosest(input_arr,sc.nextInt()));

        /** Driver Code for Q35.letterCombinations
         *
         */
//        System.out.println("Enter numbers");
//        obj.letterCombinations(sc.next());

        /** Driver Code for Q36.longestValidParentheses
         *
         */
//        System.out.println("Enter string");
//        System.out.println(obj.longestValidParentheses(sc.next()));

        /** Driver Code for Q37. numDecodings
         *
         */
//        System.out.println("Enter string");
//        System.out.println(obj.numDecodings(sc.next()));

        /** Driver Code for Q38.findBestValue
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        System.out.println(rev_obj.findBestValue(input_arr, sc.nextInt()));


        /** Driver Code for Q39.isHappy
         *
         */
//        obj.isHappy(23);

        /** Driver Code for Q40.inorderTraversal
         *
         */
//        TreeNode tree1 = create_binary_tree(null,sc);
//        obj.inorderTraversal(tree1);

        /** Driver Code for Q41.delNodes
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        System.out.println("Enter deletion_array");
//        int del_arr[] = obj.create_array_int(sc);
//        obj.delNodes(input_tree,del_arr);

        /** Driver Code for Q42.lowestCommonAncestor
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        obj.lowestCommonAncestor(input_tree,input_tree.left,input_tree.left.right.right);

        /** Driver Code for Q43.subarraySum
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        System.out.println(obj.subarraySum(input_arr,sc.nextInt()));

        /** Driver Code for Q44.maxSubArray
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.maxSubArray(input_arr);

        /** Driver Code for Q45.longestPalindrome
         *
         */
//        System.out.println("Enter String");
//        System.out.println(obj.longestPalindrome(sc.nextLine()));

        /** Driver Code for Q46.removeNthFromEnd
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        System.out.println("Enter n");
//        obj.removeNthFromEnd(input_list,sc.nextInt());

        /** Driver Code for Q47.maxArea
         *
         */
//        int height[] = obj.create_array_int(sc);
//        System.out.println(obj.maxArea(height));

        /** Driver Code for Q48.sortColors
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.sortColors(input_arr);

        /** Driver Code for Q49.searchRange
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        int return_arr[] = obj.searchRange(input_arr,sc.nextInt());
//        System.out.println(return_arr[0]+","+return_arr[1]);

        /**  No Driver Code for Q50.copyRandomList
         *
         */

        /**  Driver Code for Q51.dailyTemperatures
         *
         */
//        int temperatures[] = obj.create_array_int(sc);
//        int return_days[] = obj.dailyTemperatures(temperatures);
//        for(int iterator_i=0;iterator_i<return_days.length;iterator_i++)
//            System.out.print(return_days[iterator_i]+" ");

        /**  No Driver Code for Q52.hasCycle
         *
         */

        /**  No Driver Code for Q53.detectCycle
         *
         */

        /**  No Driver Code for Q54.isPalindrome
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        System.out.println(obj.isPalindrome(input_list));

        /**  Driver Code for Q55.majorityElement
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.majorityElement(input_arr));


        /**  Driver Code for Q56.findKthLargest
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter k");
//        System.out.println(obj.findKthLargest(input_arr,sc.nextInt()));


        /**  Driver Code for Q57.mergeTrees
         *
         */
//        TreeNode t1 = create_binary_tree(null,sc);
//        TreeNode t2 = create_binary_tree(null,sc);
//        obj.mergeTrees(t1,t2);

        /**  Driver Code for Q58.gameOfLife
         *
         */
//        System.out.println("Enter n and m");
//        int board[][] = new int[sc.nextInt()][sc.nextInt()];
//        System.out.println("Enter board");
//        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
//            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
//                board[iterator_i][iterator_j] = sc.nextInt();
//        obj.gameOfLife(board);

        /**  Driver Code for Q59.diameterOfBinaryTree
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        obj.diameterOfBinaryTree(input_tree);

        /** No Driver Code for Q60.getIntersectionNode
         *
         */

        /** Driver Code for Q61.reverseList
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        input_list = obj.reverseList(input_list);
//        while(input_list!=null)
//        {
//            System.out.print(input_list.val+" ");
//            input_list = input_list.next;
//        }

        /** Driver Code for Q62.rob
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.rob(input_arr));

        /** Driver Code for Q63.LRUCache
         *
         */
//        LRUCache cache = new LRUCache( 2 );
//
//        cache.put(2, 1);
//        cache.put(1, 1);
//        cache.put(2, 3);
//        cache.put(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        /** Driver Code for Q64.findDisappearedNumbers
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.findDisappearedNumbers(input_arr);

        /** Driver Code for Q65.findTargetSumWays
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter sum");
//        System.out.println(obj.findTargetSumWays(input_arr,sc.nextInt()));

        /** Driver Code for Q66.maxDepth
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        System.out.println(obj.maxDepth(input_tree));

        /** Driver Code for Q67.flatten
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        obj.flatten(input_tree);

        /** Driver Code for Q68.subsets
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.subsets(input_arr);

        /** Driver Code for Q69.isSymmetric
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        obj.isSymmetric(input_tree);

        /** Driver Code for Q70.subsetsWithDup
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.subsetsWithDup(input_arr);

        /** Driver Code for Q71.canJump
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.canJump(input_arr));

        /** Driver Code for Q72.groupAnagrams
         *
         */
//        System.out.println("Enter number of strings");
//        int n = sc.nextInt();
//        String input_strs[] = new String[n];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            input_strs[iterator_i] = sc.next();
//        List<List<String>> final_list = rev_obj.groupAnagrams(input_strs);
//        for(List<String> lists:final_list) {
//            for (String s : lists)
//                System.out.print(s + " ");
//            System.out.println();
//        }

        /** Driver Code for Q73.uniquePaths
         *
         */
//        System.out.println("Enter m and n");
//        System.out.println(obj.uniquePaths(sc.nextInt(),sc.nextInt()));

        /** Driver Code for Q74.minPathSum
         *
         */
//        System.out.println("Enter m and n");
//        int m = sc.nextInt(),n=sc.nextInt();
//        int board[][] = new int[m][n];
//        System.out.println("Enter board");
//        for(int iterator_i=0;iterator_i<m;iterator_i++)
//            for(int iterator_j=0;iterator_j<n;iterator_j++)
//                board[iterator_i][iterator_j] = sc.nextInt();
//
//        System.out.println(obj.minPathSum(board));

        /** Driver Code for Q75.levelOrder
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        obj.levelOrder(input_tree);

        /** Driver Code for Q76.isValidBST
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        System.out.println(obj.isValidBST(input_tree));

        /** Driver Code for Q77.exist
         *
         */
//        System.out.println("Enter m and n");
//        int m = sc.nextInt(),n = sc.nextInt();
//        char board[][] = new char[m][n];
//        System.out.println("Enter board");
//        for(int iterator_i=0;iterator_i<m;iterator_i++)
//            for(int iterator_j=0;iterator_j<n;iterator_j++)
//                board[iterator_i][iterator_j] = sc.next().charAt(0);
//        System.out.println("Enter word to search");
//        obj.exist(board,sc.next());

        /** Driver Code for Q78.containsDuplicate
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.containsDuplicate(input_arr));

        /** Driver Code for Q79.countPrimes
         *
         */
//        System.out.println("Enter n ");
//        System.out.println(rev_obj.countPrimes(sc.nextInt()));

        /** Driver Code for Q80.numIslands
         *
         */
//        System.out.println("Enter grid row size");
//        int n = sc.nextInt();
//        char grid[][] = new char[n][n];
//        System.out.println("Enter grid");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<n;iterator_j++)
//                grid[iterator_i][iterator_j] = sc.next().charAt(0);
//        System.out.println(obj.numIslands(grid));

        /** Driver Code for Q81.findPeakElement
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.findPeakElement(input_arr));

        /** Driver Code for Q82.fizzBuzz
         *
         */
//          System.out.println("Enter n");
//          List<String> list = obj.fizzBuzz(sc.nextInt());
//          for(String lval:list)
//              System.out.println(lval);

        /** Driver Code for Q83.kthSmallest
         *
         */
//        System.out.println("Enter n");
//        int n = sc.nextInt(), input_arr[][] = new int[n][n];
//        System.out.println("Enter matrix");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<n;iterator_j++)
//                input_arr[iterator_i][iterator_j] = sc.nextInt();
//        System.out.println("Enter k");
//        System.out.println(obj.kthSmallest(input_arr,sc.nextInt()));

        /** Driver Code for Q84.oddEvenList
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        input_list = obj.oddEvenList(input_list);
//        while(input_list!=null)
//        {
//            System.out.print(output_list.val+" ");
//            output_list = output_list.next;
//        }

        /** Driver Code for Q85.findDuplicate
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.findDuplicate(input_arr));

        /** Driver Code for Q86.isAnagram
         *
         */
//        System.out.println("Enter 2 strings");
//        System.out.println(obj.isAnagram(sc.next(),sc.next()));

        /** Driver Code for Q87.productExceptSelf
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        input_arr = obj.productExceptSelf(input_arr);
//        for(int val:input_arr)
//            System.out.print(val+" ");
//        System.out.println();

        /** Driver Code for Q88.trailingZeroes
         *
         */
//        System.out.println("Enter n");
//        System.out.println(obj.trailingZeroes(sc.nextInt()));

        /** Driver Code for Q89.calculate
         *
         */
//        System.out.println("Enter expression");
//        System.out.println(obj.calculate(sc.nextLine()));

        /** Driver Code for Q90.searchMatrix
         *
         */
//        System.out.println("Enter n amd m");
//        int n = sc.nextInt(),m=sc.nextInt();
//        int input_matrix[][] = new int[n][m];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<m;iterator_j++)
//                input_matrix[iterator_i][iterator_j] = sc.nextInt();
//
//        System.out.println("Enter target");
//        obj.searchMatrix(input_matrix,sc.nextInt());

        /** No Driver Code for Q91.deleteNode
         *
         */

        /** Driver Code for Q92.canFinish
         *
         */
//        System.out.println("Enter number of pairs");
//        int n = sc.nextInt();
//        int prerequisites[][] = new int[n][2];
//        System.out.println("Enter prerequisites");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//        {
//            prerequisites[iterator_i][0] = sc.nextInt();
//            prerequisites[iterator_i][1] = sc.nextInt();
//        }
//        System.out.println("Enter number of courses");
//        System.out.println(obj.canFinish(sc.nextInt(),prerequisites));

        /** Driver Code for Q93.canFinish
         *
         */
//        System.out.println("Enter n and m");
//        int n = sc.nextInt(), m =sc.nextInt();
//        char board[][] = new char[n][m];
//        System.out.println("Enter board");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<m;iterator_j++)
//                board[iterator_i][iterator_j] = sc.next().charAt(0);
//        obj.solve(board);
//
//        System.out.println("Solved Board:");
//        for(int iterator_i=0;iterator_i<board.length;iterator_i++) {
//            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++)
//                System.out.print(board[iterator_i][iterator_j]);
//            System.out.println();
//        }

        /** Driver Code for Q94.hammingWeight
         *
         */
//        System.out.println("Enter n");
//        System.out.println(obj.hammingWeight(sc.nextInt()));

        /** Driver Code for Q95.titleToNumber
         *
         */
//        System.out.println("Enter column title");
//        System.out.println(obj.titleToNumber(sc.next()));

        /** Driver Code for Q96.maxProduct
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.maxProduct(input_arr));

        /** Driver Code for Q97.sortedArrayToBST
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        TreeNode bst = obj.sortedArrayToBST(input_arr);

        /** Driver Code for Q98.middleNode
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        obj.middleNode(input_list);

        /** Driver Code for Q99.moveZeroes
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.moveZeroes(input_arr);

        /** Driver Code for Q100.findMaxLength
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.findMaxLength(input_arr));

        /** Driver Code for Q101.solveNQueens
         *
         */
//        System.out.println("Enter n");
//        obj.solveNQueens_dp(sc.nextInt());

        /** Driver Code for Q102.backspaceCompare
         *
         */
//        System.out.println("Enter 2 strings");
//        obj.backspaceCompare(sc.next(),sc.next());

        /** Driver Code for Q103.lastStoneWeight
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.lastStoneWeight(input_arr));

        /** Driver Code for Q104.MinStack
         *
         */
//        MinStack minStack = new MinStack(); // Can also be done using ListNode with min val stored at each node
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin()); // return -3
//        minStack.pop();
//        System.out.println(minStack.top());    // return 0
//        System.out.println(minStack.getMin()); // return -2

        /** Driver Code for Q105.convertBST
         *
         */
//        TreeNode input_bst = create_binary_tree(null,sc);
//        obj.convertBST(input_bst);

        /** Driver Code for Q106.minDepth
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        System.out.println(obj.minDepth(input_tree));

        /** Driver Code for Q107.reorderList
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        rev_obj.reorderList(input_list);
//        System.out.println("1");

        /** Driver Code for Q108.bstFromPreorder
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.bstFromPreorder(input_arr);

        /** Driver Code for Q109.isSubsequence
         *
         */
//        System.out.println("Enter strings s and t");
//        obj.isSubsequence(sc.nextLine(),sc.nextLine());

        /** Driver Code for Q110.detectCapitalUse
         *
         */
//        System.out.println("Enter string");
//        System.out.println(obj.detectCapitalUse(sc.next()));

        /** Driver Code for Q111.sortList
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        input_list = obj.sortList(input_list);

        /** Driver Code for Q112.generate
         *
         */
//        System.out.println("Enter n");
//        obj.generate(sc.nextInt());

        /** Driver Code for Q113.rob2
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.rob2(input_arr));

        /** Driver Code for Q114.flipAndInvertImage
         *
         */
//        System.out.println("Enter size of 2d matrix");
//        int n = sc.nextInt(),img[][] = new int[n][n];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<n;iterator_j++)
//                img[iterator_i][iterator_j] = sc.nextInt();
//        obj.flipAndInvertImage(img);

        /** Driver Code for Q115.lexicalOrder
         *
         */
//        System.out.println("Enter n");
//        obj.lexicalOrder(sc.nextInt());

        /** Driver Code for Q116.maximalSquare
         *
         */
//        System.out.println("Enter size of 2d matrix");
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        char matrix[][] = new char[n][m];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<m;iterator_j++)
//                matrix[iterator_i][iterator_j] = sc.next().charAt(0);
//        System.out.println(obj.maximalSquare(matrix));

        /** Driver Code for Q117.numJewelsInStones
         *
         */
//        System.out.println("Enter jewel and rocks");
//        System.out.println(obj.numJewelsInStones(sc.next(),sc.next()));

        /** Driver Code for Q118.findMinArrowShots
         *
         */
//        System.out.println("Enter number of balloons");
//        int balloons[][] = new int[sc.nextInt()][2];
//        System.out.println("Enter balloons");
//        for(int iterator_i=0;iterator_i<balloons.length;iterator_i++)
//        {
//            balloons[iterator_i][0] = sc.nextInt();
//            balloons[iterator_i][1] = sc.nextInt();
//        }
//        System.out.println(obj.findMinArrowShots(balloons));

        /** Driver Code for Q119.find132pattern
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.find132pattern(input_arr));

        /** Driver Code for Q120.lemonadeChange
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.lemonadeChange(input_arr));

        /** Driver Code for Q121.checkValidString
         *
         */
//        System.out.println("Enter parenthesized string");
//        System.out.println(obj.checkValidString(sc.next()));

        /** Driver Code for Q122.arrangeCoins
         *
         */
//        System.out.println("Enter n");
//        System.out.println(obj.arrangeCoins(sc.nextInt()));

        /** Driver Code for Q123.updateBoard
         *
         */
//        System.out.println("Enter board length n and m");
//        int n = sc.nextInt(),m = sc.nextInt(),click[] = new int[2];
//        char board[][] = new char[n][m];
//        System.out.println("Enter board");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<m;iterator_j++)
//                board[iterator_i][iterator_j] = sc.next().charAt(0);
//        System.out.println("Enter click position");
//        click[0] = sc.nextInt();
//        click[1] = sc.nextInt();
//        obj.updateBoard(board,click);
//        System.out.println(board[0][0]);

        /** Driver Code for Q124.isPerfectSquare
         *
         */
//        System.out.println("Enter number");
//        System.out.println(obj.isPerfectSquare(sc.nextInt()));

        /** Driver Code for Q125.totalNQueens
         *
         */
//        System.out.println("Enter n");
//        System.out.println(obj.totalNQueens(sc.nextInt()));

        /** Driver Code for Q126.deleteDuplicates
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        obj.deleteDuplicates(input_list);

        /** Driver Code for Q127.deleteDuplicates
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        obj.deleteDuplicates2(input_list);

        /** Driver Code for Q128.deleteDuplicates
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        System.out.println("Enter partition value");
//        obj.partition(input_list,sc.nextInt());

        /** Driver Code for Q129.maximalRectangle
         *
         */
//        System.out.println("Enter m and n");
//        char input_matrix[][] = new char[sc.nextInt()][sc.nextInt()];
//        System.out.println("Enter matrix");
//        for(int iterator_i=0;iterator_i<input_matrix.length;iterator_i++)
//            for(int iterator_j=0;iterator_j<input_matrix[0].length;iterator_j++)
//                input_matrix[iterator_i][iterator_j] = sc.next().charAt(0);
//        System.out.println(rev_obj.maximalRectangle(input_matrix));

        /** Driver Code for Q130.reverseBetween
         *
         */
//        ListNode input_list = create_linked_list(sc);
//        System.out.println("Enter m and n");
//        obj.reverseBetween(input_list,sc.nextInt(),sc.nextInt());
//        System.out.println();

        /** Driver Code for Q131.arrayPairSum
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.arrayPairSum(input_arr);

        /** Driver Code for Q132.nthSuperUglyNumber
         *
         */
//        int input_primes[] = obj.create_array_int(sc);
//        System.out.println("Enter n");
//        System.out.println(obj.nthSuperUglyNumber(sc.nextInt(),input_primes));

        /** Driver Code for Q133.imageSmoother
         *
         */
//        System.out.println("Enter matrix size");
//        int n=sc.nextInt(),input_matrix[][] = new int[n][n];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<n;iterator_j++)
//                input_matrix[iterator_i][iterator_j] = sc.nextInt();
//
//        obj.imageSmoother(input_matrix);

        /** Driver Code for Q134.findTilt
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        System.out.println(obj.findTilt(input_tree));

        /** Driver Code for Q135.distributeCandies
         *
         */
//        int input_candies[] = obj.create_array_int(sc);
//        System.out.println(obj.distributeCandies(input_candies));

        /** Driver Code for Q136.trap
         *
         */
//        int input_height[] = obj.create_array_int(sc);
//        System.out.println(obj.trap(input_height));

        /** Driver Code for Q137.firstUniqChar
         *
         */
//        System.out.println("Enter String");
//        System.out.println(obj.firstUniqChar(sc.next()));

        /** Driver Code for Q138.numSquares
         *
         */
//        System.out.println("Enter n");
//        System.out.println(obj.numSquares(sc.nextInt()));

        /** Driver Code for Q139.hasPathSum
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        System.out.println("Enter sum");
//        System.out.println(obj.hasPathSum(input_tree,sc.nextInt()));

        /** Driver Code for Q140.mergeKLists
         *
         */
//        System.out.println("Enter number of lists");
//        int k = sc.nextInt();
//        ListNode input_lists[] = new ListNode[k];
//        for(int iterator_i=0;iterator_i<k;iterator_i++)
//        {
//            System.out.println("Enter List "+(iterator_i+1));
//            input_lists[iterator_i] = create_linked_list(sc);
//        }
//        ListNode result_node = obj.mergeKLists(input_lists);

        /** Driver Code for Q143.longestIncreasingPath
         *
         */
//        System.out.println("Enter matrix size");
//        int n = sc.nextInt(),input_matrix[][] = new int[n][n];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<n;iterator_j++)
//                input_matrix[iterator_i][iterator_j] = sc.nextInt();
//        System.out.println(obj.longestIncreasingPath(input_matrix));

        /** Driver Code for Q142.intersect
         *
         */
//        int input_arr1[] = obj.create_array_int(sc);
//        int input_arr2[] = obj.create_array_int(sc);
//        input_arr1 = obj.intersect(input_arr1,input_arr2);

        /** Driver Code for Q143.reverseString
         *
         */
//        System.out.println("Enter string");
//        obj.reverseString(sc.next().toCharArray());

        /** Driver Code for Q144.merge
         *
         */
//        System.out.println("Enter number of intervals");
//        int n = sc.nextInt(),input_intervals[][] = new int[n][2];
//        System.out.println("Enter intervals");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//        {
//            input_intervals[iterator_i][0] = sc.nextInt();
//            input_intervals[iterator_i][1] = sc.nextInt();
//        }
//        input_intervals = obj.merge(input_intervals);

        /** Driver Code for Q145.findMedianSortedArrays
         *
         */
//        int input_arr1[] = obj.create_array_int(sc);
//        int input_arr2[] = obj.create_array_int(sc);
//        System.out.println(obj.findMedianSortedArrays(input_arr1,input_arr2));

        /** Driver Code for Q146.convertToTitle
         *
         */
//        System.out.println("Enter n");
//        System.out.println(obj.convertToTitle(sc.nextInt()));

        /** Driver Code for Q147.twoSum
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        obj.twoSum2(input_arr,sc.nextInt());

        /** Driver Code for Q148.convert
         *
         */
//        System.out.println("Enter String and number of rows");
//        System.out.println(obj.convert(sc.next(),sc.nextInt()));

        /** Driver Code for Q149.sumNumbers
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        obj.sumNumbers(input_tree);

        /** Driver Code for Q150.maxCoins
         *
         */
//        int balloons[] = obj.create_array_int(sc);
//        System.out.println(obj.maxCoins(balloons));

        /** Driver Code for Q151.isIsomorphic
         *
         */
//        System.out.println("Enter 2 strings");
//        System.out.println(obj.isIsomorphic(sc.next(),sc.next()));

        /** Driver Code for Q152.isUgly
         *
         */
//        System.out.println("Enter n");
//        System.out.println(obj.isUgly(sc.nextInt()));

        /** Driver Code for Q153.restoreIpAddresses
         *
         */
//        System.out.println("Enter string");
//        obj.restoreIpAddresses(sc.next());

        /** Driver Code for Q154.minimumTotal
         *
         */
//        List<List<Integer>> input_list = new ArrayList<>();
//        System.out.println("Enter size of triangle");
//        int n = sc.nextInt();
//        System.out.println("Enter triangle");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//        {
//            input_list.add(new ArrayList<>());
//            for(int iterator_j = 0;iterator_j<=iterator_i;iterator_j++)
//                input_list.get(iterator_i).add(sc.nextInt());
//        }
//        System.out.println(obj.minimumTotal(input_list));

        /** Driver Code for Q155.binaryTreePaths
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        List<String> paths = obj.binaryTreePaths(input_tree);

        /** Driver Code for Q156.countSmaller
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.countSmaller(input_arr);

        /** Driver Code for Q157.intersection
         *
         */
//        int input_arr1[] = obj.create_array_int(sc);
//        int input_arr2[] = obj.create_array_int(sc);
//        input_arr1 = obj.intersection(input_arr1,input_arr2);

        /** Driver Code for Q158.getSkyline
         *
         */
//        System.out.println("Enter number of buildings");
//        int n = sc.nextInt(),input_buildings[][] = new int[n][3];
//        System.out.println("Enter triplets");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//        {
//            input_buildings[iterator_i][0] = sc.nextInt();
//            input_buildings[iterator_i][1] = sc.nextInt();
//            input_buildings[iterator_i][2] = sc.nextInt();
//        }
//        List<List<Integer>> outline_list = obj.getSkyline(input_buildings);

        /** No Driver Code for Q159.lowestCommonAncestor
         *
         */

        /** Driver Code for Q160.hIndex
         *
         */
//        int input_citations[] = obj.create_array_int(sc);
//        System.out.println(obj.hIndex(input_citations));

        /** Driver Code for Q161.sumOfLeftLeaves
         *
         */
//        TreeNode input_tree = create_binary_tree(null,sc);
//        System.out.println(obj.sumOfLeftLeaves(input_tree));

        /** Driver Code for Q162.canConstruct
         *
         */
//        System.out.println("Enter ransom and magazine");
//        System.out.println(obj.canConstruct(sc.next(),sc.next()));

        /** Driver Code for Q163.findItinerary
         *
         */
//        List<List<String>> input_tickets = new ArrayList<>();
//        System.out.println("Enter number of tickets");
//        int n = sc.nextInt();
//        System.out.println("Enter tickets");
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//        {
//            List<String> ticket = new ArrayList<>();
//            ticket.add(sc.next());
//            ticket.add(sc.next());
//            input_tickets.add(ticket);
//        }
//        List<String> ret_itinerary = obj.findItinerary_bfs(input_tickets);

        /** Driver Code for Q164.findMinFibonacciNumbers
         *
         */

        //int arr[] = obj.create_array_int(sc);
        //System.out.println("Enter S");
        //int S = sc.nextInt();
        //System.out.println("Answer:"+obj.pivotIndex(arr));

//        TreeNode inputtree=null;
//        inputtree = create_binary_tree(inputtree,sc);
//        System.out.println(obj.sumRootToLeaf(inputtree));

        /** Driver Code for Q165.minRefuelStops
         *
         */
//        System.out.println("Enter target and startFuel");
//        int target = sc.nextInt(),startFuel = sc.nextInt();
//        System.out.println("Enter number of stations");
//        int num_stations = sc.nextInt(),station[][] = new int[num_stations][2];
//        for(int iterator_i=0;iterator_i<num_stations;iterator_i++)
//        {
//            station[iterator_i][0] = sc.nextInt();
//            station[iterator_i][1] = sc.nextInt();
//        }
//        System.out.println(obj.minRefuelStops(target,startFuel,station));

        /** Driver Code for Q166.largestRectangleArea
         *
         */
//        int input_height[] = obj.create_array_int(sc);
//        System.out.println(obj.largestRectangleArea(input_height));

        /** Driver Code for Q167.largestRectangleArea
         *
         */
//        TreeNode input_tree = null;
//        input_tree = create_binary_tree(input_tree,sc);
//        System.out.println(obj.countNodes(input_tree));

        /** Driver Code for Q168.maxSlidingWindow
         *
         */
//        System.out.println("Enter k");
//        int k = sc.nextInt(), input_arr[]=obj.create_array_int(sc);
//        obj.maxSlidingWindow(input_arr,k);

        /** Driver Code for Q169.summaryRanges
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        obj.summaryRanges(input_arr);

        /** Driver Code for Q170.summaryRanges
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.firstMissingPositive(input_arr));

        /** Driver Code for Q171.decodeString
         *
         */
//        System.out.println("Enter string");
//        System.out.println(obj.decodeString(sc.next()));

        /** Driver Code for Q172.missingNumber
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.missingNumber(input_arr));

        /** Driver Code for Q173.kthSmallestHelper
         *
         */
//        TreeNode input_tree = null;
//        input_tree = create_binary_tree(input_tree,sc);
//        System.out.println("Enter value for k");
//        int k = sc.nextInt();
//        System.out.println(obj.kthSmallest(input_tree,k));

        /** Driver Code for Q174.lengthOfLIS
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.lengthOfLIS(input_arr));

        /** Driver Code for Q175.coinChange
         *
         */
//        int input_coins[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        System.out.println(obj.coinChange(input_coins,sc.nextInt()));

        /** Driver Code for Q176.minDiffInBST
         *
         */
//        TreeNode input_tree = null;
//        input_tree = create_binary_tree(input_tree,sc);
//        System.out.println(obj.minDiffInBST(input_tree));

        /** Driver Code for Q177.spiralOrder
         *
         */
//        System.out.println("Enter n, m and array");
//        int n= sc.nextInt(),m=sc.nextInt(), input_arr[][] = new int[n][m];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<m;iterator_j++)
//                input_arr[iterator_i][iterator_j] = sc.nextInt();
//
//        obj.spiralOrder(input_arr);

        /** Driver Code for Q178.ladderLength
         *
         */
//        System.out.println("Enter beginWord and endWord");
//        String beginWord = sc.next(), endWord = sc.next();
//        List<String> wordList = new ArrayList();
//        System.out.println("Enter length of wordList and wordList");
//        int n= sc.nextInt();
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            wordList.add(sc.next());
//        System.out.println(obj.ladderLength(beginWord,endWord,wordList));

        /** Driver Code for Q179.containsNearbyDuplicate
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter k");
//        System.out.println(obj.containsNearbyDuplicate(input_arr,sc.nextInt()));

        /** Driver Code for Q180.longestConsecutive
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.longestConsecutive(input_arr));

        /** Driver Code for Q181.isMatch
         *
         */
//        System.out.println("Enter string s and t");
//        System.out.println(obj.isMatch(sc.next(),sc.next()));

        /** Driver Code for Q182.numUniqueEmails
         *
         */
//        System.out.println("Enter number of emails");
//        int n = sc.nextInt();
//        String input_mails[] = new String[n];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            input_mails[iterator_i] = sc.next();
//        System.out.println(obj.numUniqueEmails(input_mails));

        /** Driver Code for Q183.minWindow
         *
         */
//        System.out.println("Enter string s and t");
//        System.out.println(obj.minWindow(sc.next(),sc.next()));

        /** Driver Code for Q184.isPowerOfThree
         *
         */
//        System.out.println("Enter value of n");
//        System.out.println(obj.isPowerOfThree(sc.nextInt()));

        /** Driver Code for Q185.topKFrequent
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter value of k");
//        obj.topKFrequent(input_arr,sc.nextInt());

        /** Driver Code for Q186.nextPermutation
         *
         */
//        int input_num[] = obj.create_array_int(sc);
//        obj.nextPermutation(input_num);

        /** Driver Code for Q187.search
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        System.out.println(obj.search(input_arr,sc.nextInt()));

        /** Driver Code for Q188.uniquePathsWithObstacles
         *
         */
//        System.out.println("Enter n,m and grid");
//        int n=sc.nextInt(), m=sc.nextInt(),input_grid[][] = new int[n][m];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<m;iterator_j++)
//                input_grid[iterator_i][iterator_j] = sc.nextInt();
//        System.out.println(obj.uniquePathsWithObstacles(input_grid));

        /** Driver Code for Q189.zigzagLevelOrder
         *
         */
//        TreeNode input_tree = null;
//        input_tree = create_binary_tree(input_tree,sc);
//        obj.zigzagLevelOrder(input_tree);

        /** Driver Code for Q190.islandPerimeter
         *
         */
//        System.out.println("Enter n and m");
//        int n=sc.nextInt(),m = sc.nextInt(),input_grid[][] = new int[n][m];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            for(int iterator_j=0;iterator_j<m;iterator_j++)
//                input_grid[iterator_i][iterator_j] = sc.nextInt();
//
//
//        System.out.println(obj.islandPerimeter(input_grid));

        /** Driver Code for Q191.wordBreak
         *
         */
//        System.out.println("Enter string");
//        String str = sc.next();
//        System.out.println("Enter items in dictionary");
//        int n = sc.nextInt();
//        List<String> input_dict = new ArrayList();
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            input_dict.add(sc.next());
//        obj.wordBreak(str,input_dict);

        /** Driver Code for Q192.findMin
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.findMin(input_arr));

        /** Driver Code for Q193.minSubArrayLen
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        obj.minSubArrayLen(sc.nextInt(),input_arr);

        /** Driver Code for Q194.kSmallestPairs
         *
         */
//        int input_arr[] = obj.create_array_int(sc),input_arr2[] = obj.create_array_int(sc);
//        System.out.println("Enter k");
//        obj.kSmallestPairs(input_arr,input_arr2,sc.nextInt());

        /** Driver Code for Q195.maxAreaOfIsland
         *
         */
//        System.out.println("Enter n,m and grid");
//        int grid[][] = new int[sc.nextInt()][sc.nextInt()];
//        for(int iterator_i=0;iterator_i<grid.length;iterator_i++)
//            for(int iterator_j=0;iterator_j<grid[0].length;iterator_j++)
//                grid[iterator_i][iterator_j] = sc.nextInt();
//        System.out.println(obj.maxAreaOfIsland(grid));

        /** Driver Code for Q197.kthGrammar
         *
         */
//        System.out.println("Enter N and K");
//        System.out.println(obj.kthGrammar(sc.nextInt(),sc.nextInt()));

        /** Driver Code for Q198.shipWithinDays
         *
         */
//        int input_weights[] = obj.create_array_int(sc);
//        System.out.println("Enter days");
//        System.out.println(obj.shipWithinDays(input_weights,sc.nextInt()));

        /** Driver Code for Q199.maxLevelSum
         *
         */
//        TreeNode input_tree = null;
//        input_tree = create_binary_tree(input_tree,sc);
//        obj.maxLevelSum(input_tree);

        /** Driver Code for Q200.findUnsortedSubarray
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj.findUnsortedSubarray(input_arr));

        /** Driver Code for Q201.canArrange
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Enter k");
//        System.out.println(obj_2.canArrange(input_arr,sc.nextInt()));

        /** Driver Code for Q202.minDistance
         *
         */
//        System.out.println("Enter 2 words");
//        System.out.println(obj_2.minDistance(sc.next(),sc.next()));

        /** Driver Code for Q203.pathSum2
         *
         */
//        TreeNode input_tree = null;
//        input_tree = create_binary_tree(input_tree,sc);
//        System.out.println("Enter target sum");
//        obj_2.pathSum2(input_tree,sc.nextInt());

        /** Driver Code for Q204.canPartition
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println(obj_2.canPartition(input_arr));

        /** Driver Code for Q205.pathSum
         *
         */
//        TreeNode input_root = create_binary_tree(null,sc);
//        System.out.println("Enter target");
//        obj_2.pathSum(input_root,sc.nextInt());

        /** Driver Code for Q206.countSubstrings
         *
         */
//        System.out.println("Enter Substring");
//        System.out.println(obj_2.countSubstrings(sc.next()));

        /** Driver Code for Q207.removeBoxes
         *
         */
//        int input_boxes[] = obj.create_array_int(sc);
//        System.out.println(obj_2.removeBoxes(input_boxes));

        /** Driver Code for Q208.longestPalindrome
         *
         */
//        System.out.println("Enter string");
//        System.out.println("Longest Palindrome: "+obj_2.longestPalindrome1(sc.next()));

        /** Driver Code for Q209.reverseVowels
         *
         */
//        System.out.println("Enter string");
//        System.out.println("Vowel Reversed String: "+obj_2.reverseVowels(sc.next()));

        /** Driver Code for Q210.generateMatrix
         *
         */
//        System.out.println("Enter n");
//        obj_2.generateMatrix(sc.nextInt());

        /** Driver Code for Q211.numTrees
         *
         */
//        System.out.println("Enter n");
//        System.out.println("Unique BST :"+obj_2.numTrees(sc.nextInt()));

        /** Driver Code for Q212.findLHS
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Longest Harmonious Subsequence: "+obj_2.findLHS(input_arr));

        /** Driver Code for Q213.isSubtree
         *
         */
//        System.out.println("Enter trees");
//        TreeNode t1 = create_binary_tree(null,sc), t2 = create_binary_tree(null,sc);
//        System.out.println("isSubtree: "+obj_2.isSubtree(t1,t2));

        /** Driver Code for Q214.findKthNumber
         *
         */
//        System.out.println("Enter m,n and k");
//        System.out.println("kth Smallest Number : "+obj_2.findKthNumber(sc.nextInt(),sc.nextInt(),sc.nextInt()));

        /** Driver Code for Q215.canCross
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        System.out.println("Can cross: "+obj_2.canCross(input_arr));

        /** Driver Code for Q216.findErrorNums
         *
         */
//        int input_arr[] = obj.create_array_int(sc);
//        int result_arr[] = obj_2.findErrorNums(input_arr);
//        System.out.println("Set Mismatch: "+result_arr[0]+","+result_arr[1]);

        /** Driver Code for Q217.maxProduct
         *
         */
//        System.out.println("Enter number of words, then words");
//        int n = sc.nextInt();
//        String input_str[] = new String[n];
//        for(int iterator_i=0;iterator_i<n;iterator_i++)
//            input_str[iterator_i] = sc.next();
//        System.out.println("maxProduct is : "+obj_2.maxProduct(input_str));

        /** Driver Code for Q218.shortestToChar
         *
         */
//        System.out.println("Enter String and char");
//        obj_2.shortestToChar(sc.next(),sc.next().charAt(0));

        /** Driver Code for Q219.integerBreak
         *
         */
//        System.out.println("Enter n");
//        System.out.println("IntegerBreak: "+obj_2.integerBreak(sc.nextInt()));

        /** Driver Code for Q220.findShortestSubArray
         *
         */
        int input_arr[] = obj.create_array_int(sc);
        System.out.println(obj_2.findShortestSubArray(input_arr));
    }
}
