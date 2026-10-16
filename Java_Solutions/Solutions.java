import java.util.*;
import java.util.Scanner;

# START OF CLASS DEFINITIONS

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


# END OF CLASS DEFITIONS

public class Solutions
{
/*
    1. PROBLEM DESCRIPTION (https://leetcode.com/problems/two-sum/)
*/
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    int cur_num = 0;
    for(int i=0; i<nums.length; i++)
    {
        cur_num = nums[i];
        if hmap.containsKey(target-nums[i])
            return new int[]{hmap.get(target-nums[i]), i};
    }
    return new int[]{-1,-1};
}

/*
    2. PROBLEM DESCRIPTION (https://leetcode.com/problems/add-two-numbers/)
*/
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0, cur_sum=0, countl1 = 0, count_l2 = 0;
    ListNode prevhead = l1, main_head = l1;
    while(l1!=null && l2!=null)
    {
        cur_sum = l1.val + l2.val + carry;
        carry = cur_sum/10;
        l1.val = cur_sum%10;
        prevhead = l1;
        l1 = l1.next;
        l2 = l2.next;
    }
    if(l2!=null)
        prevhead.next = l2;
    l1 = prevhead.next;
    while(carry!=0 && l1!=null)
    {
        if(l1.val == 9)
            l1.val = 0;
        else
        {
            l1.val++;
            carry = 0;
            break;
        }
        prevhead = l1;
        l1 = l1.next;
    }
    if(carry!=0)
        prevhead.next = new ListNode(carry);
    return main_head;
}

/*
    3. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-substring-without-repeating-characters/)
*/
public int lengthOfLongestSubstring(String s) {
    int[] hmap = new int[128];
    Arrays.fill(hmap, -1);
    int start_idx = 0, end_idx = 0, max_len = 0;
    char s_arr[] = s.toCharArray();
    while (end_idx<s.length())
    {
        char cur_c = s_arr[end_idx++];
        start_idx = Math.max(start_idx, hmap[cur_c]);
        hmap[cur_c] = end_idx;
        // System.out.println(cur_c+" "+start_idx+" "+end_idx);
        max_len = Math.max(max_len,end_idx - start_idx);
    }
    return max_len;
}

/*
    4. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-integer/)
*/
public int reverse(int x) {
    int result = 0, cur_dig=0;
    while(x!=0)
    {
        cur_dig = x%10;
        if (result>0 && ((Integer.MAX_VALUE/10 < result) || ((Integer.MAX_VALUE/10 == result) && (cur_dig>Integer.MAX_VALUE%10))))
            return 0;
        if (result < 0 &&((Integer.MIN_VALUE/10 > result) || ((Integer.MIN_VALUE/10 == result) && (cur_dig<Integer.MIN_VALUE%10))))
            return 0;
        result = result*10 + cur_dig;
        x /= 10;
    }
    return result;
}

/*
    5. PROBLEM DESCRIPTION (https://leetcode.com/problems/string-to-integer-atoi/)
*/
public int myAtoi(String s) {
    int idx = 0, result=0, sign = 1;
    char s_arr[] = s.toCharArray();
    if(s.length()==0)
        return 0;
    while(idx<s.length() && s_arr[idx]==' ')
        idx++;
    if(idx==s.length())
        return 0;
    if("+-".indexOf(s_arr[idx])>=0)
        if(s_arr[idx++]=='-')
            sign = -1;
    while(idx<s.length())
    {
        char cur_c = s_arr[idx++];
        if(!Character.isDigit(cur_c))
            return result * sign;
        int cur_int = cur_c - '0';
        if(sign>0 && ((Integer.MAX_VALUE/10 < result) || ((Integer.MAX_VALUE/10 == result) && (Integer.MAX_VALUE%10 < cur_int))))
            return Integer.MAX_VALUE;
        if(sign<0 && (Integer.MIN_VALUE/10 > sign*result || ((Integer.MIN_VALUE/10 == sign*result) && (Integer.MIN_VALUE%10 > sign*cur_int))))
            return Integer.MIN_VALUE;
        result = result*10 + cur_int;
    }
    return result * sign;
}

/*
    6. PROBLEM DESCRIPTION (https://leetcode.com/problems/palindrome-number/)
*/
public boolean isPalindrome(int x) {
    if(x<0)
        return false;
    int orig_x = x, palin = 0;
    while(x>0)
    {
        palin = palin *10 + x%10;
        x /= 10;
    }
    return palin ==orig_x;
}

/*
    7. PROBLEM DESCRIPTION (https://leetcode.com/problems/integer-to-roman/)
*/
public String intToRoman(int num) {
    int map_keys[] = new int[] {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String map_values[] = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int idx= map_keys.length-1;
    StringBuilder sb = new StringBuilder();
    while(num>0)
    {
        // System.out.println(num+" "+idx);
        if(num>=map_keys[idx])
        {
            sb.append(map_values[idx]);
            num -= map_keys[idx];
        }
        else
            idx--; 
    }
    return sb.toString();
}

/*
    8. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-common-prefix/)
*/
public String longestCommonPrefix(String[] strs) {
    for(int i=0;i<strs[0].length();i++)
    {
        char cur_c = strs[0].charAt(i);
        for(int j=0; j<strs.length;j++)
            if(i>=strs[j].length() || strs[j].charAt(i)!=cur_c)
                return strs[0].substring(0,i);
    }
    return strs[0];
}

/*
    9. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-parentheses/)
*/
public boolean isValid(String s) {
    Stack<Character> stck = new Stack<Character>();
    for(char c: s.toCharArray())
    {
        if(c == '}' || c == ')' || c==']')
        {
            if(stck.isEmpty())
                return false;
            if(c=='}' && stck.peek()!='{')
                return false;
            if(c==']' && stck.peek()!='[')
                return false;
            if(c==')' && stck.peek()!='(')
                return false;
            stck.pop();
        }
        else
            stck.push(c);
    }
    return stck.isEmpty();
}

/*
    10. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-two-sorted-lists/)
*/
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(), head = dummy;
    while(list1!=null && list2!=null)
    {
        if(list1.val <= list2.val)
        {
            dummy.next = list1;
            list1 = list1.next;
        }
        else
        {
            dummy.next = list2;
            list2 =list2.next;
        }
        dummy = dummy.next;
    }
    if(list1 != null)
        dummy.next = list1;
    else
        dummy.next = list2;
    return head.next;
}

/*
    11. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
*/
public int removeDuplicates(int[] nums) {
    int current_ptr = 1;
    for(int i=1;i<nums.length;i++)
    {
        if(nums[i] != nums[i-1])
            nums[current_ptr++] = nums[i];
    }
    return current_ptr;
}

/*
    12. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-element/)
*/
public int removeElement(int[] nums, int val) {
    int cur_ptr = 0;
    for (int i=0; i<nums.length; i++)
    {
        if(nums[i] != val)
            nums[cur_ptr++] = nums[i];
    }
    return cur_ptr;
}

/*
13. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-and-say/)
*/
public String countAndSay(int n) {
    StringBuilder sb = new StringBuilder(), next_sb;
    String prev_string = "1", next_string = "";
    if(n==1)
        return prev_string;
    for(int i=1; i<n;i++)
    {
        int cur_idx = 1, cur_num=1;
        char c = prev_string.charAt(0);
        next_sb = new StringBuilder();
        while(cur_idx<prev_string.length())
        {
            if(prev_string.charAt(cur_idx)==c)
                cur_num++;
            else
            {
                next_sb.append(cur_num);
                next_sb.append(c);
                cur_num = 1;
                c = prev_string.charAt(cur_idx);
            }
            cur_idx++;
        }
        next_sb.append(cur_num);
        next_sb.append(c);
        prev_string = next_sb.toString();
    }
    return prev_string;
}

/*
    14. PROBLEM DESCRIPTION (https://leetcode.com/problems/search-insert-position/)
*/
public int searchInsert(int[] nums, int target) {
    int lb = 0, ub = nums.length, mid;
    while(lb<ub)
    {
        mid = lb + (ub-lb)/2;
        if(nums[mid] < target)
            lb = mid+1;
        else if(nums[mid] > target)
            ub = mid;
        else
            return mid;
    }
    return lb;
}

/*
    15. PROBLEM DESCRIPTION (https://leetcode.com/problems/plus-one/)
*/
public int[] plusOne(int[] digits) {
    for(int i = digits.length-1; i>=0; i--)
    {
        if(digits[i]!=9)
        {
            digits[i]+=1;
            return digits;
        }
        else
            digits[i] = 0;
    }
    int new_arr[] = new int[digits.length+1];
    Arrays.fill(new_arr, 0);
    new_arr[0] = 1;
    return new_arr;
}

/*
    16. PROBLEM DESCRIPTION (https://leetcode.com/problems/sqrtx/)
*/
public int mySqrt(int x) {
    long lb = 0, ub = Math.max(1,x/2),mid;
    while(lb<ub)
    {
        mid = lb + (ub-lb)/2;
        if((mid*mid<=x) && (mid+1)*(mid+1)>x)
            return (int)mid;
        else if(mid*mid>x)
            ub = mid;
        else
            lb = mid+1;
    }
    return (int)lb;
}

/*
    17. PROBLEM DESCRIPTION (https://leetcode.com/problems/length-of-last-word/)
*/
public int lengthOfLastWord(String s) {
    String split[] = s.split(" ");
    return split[split.length-1].length();
}

/*
    18. PROBLEM DESCRIPTION (https://leetcode.com/problems/add-binary/)
*/
public String addBinary(String a, String b) {
    int a_index = a.length()-1, b_index = b.length()-1, carry=0;
    StringBuffer sb = new StringBuffer();
    while( a_index>=0 || b_index>=0 || carry>0)
    {
        int cur_a = 0, cur_b = 0;
        if(a_index >= 0)
            cur_a = (int)(a.charAt(a_index)-'0');
        if(b_index >= 0)
            cur_b = (int)(b.charAt(b_index)-'0');
        int total = cur_a + cur_b + carry;
        if(total%2 == 0)
            sb.append("0");
        else
            sb.append("1");
        carry = 0;
        if(total>1)
            carry = 1;
        a_index -=1;
        b_index -=1;
    }
    return sb.reverse().toString();
}

/*
    19. PROBLEM DESCRIPTION (https://leetcode.com/problems/climbing-stairs/)
*/
public int climbStairs(int n) {
    int dp[] = new int[n+1];
    dp[1] = dp[0] = 1;
    for(int i=2; i<=n; i++)
        dp[i] = dp[i-1]+ dp[i-2];
    return dp[n];
}

/*
    20. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-sorted-array/)
*/
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index1 = m-1, index2 = n-1;
    while(index2>=0)
    {
        if(index1<0 || nums2[index2]>=nums1[index1])
        {
            nums1[index1+index2+1] = nums2[index2];
            index2 -= 1; 
        }
        else
        {
            nums1[index1+index2+1] = nums1[index1];
            index1 -= 1;
        }
    }
}

/*
    21. PROBLEM DESCRIPTION (https://leetcode.com/problems/single-number/)
*/
public int singleNumber(int[] nums) {
    int xor_val = 0;
    for (int x: nums)
        xor_val ^= x;
    return xor_val;
}

/*
    22. PROBLEM DESCRIPTION (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
*/
public int maxProfit(int[] prices) {
    int cur_min = prices[0], profit = 0;
    for(int x:prices)
    {
        profit = Math.max(profit, x-cur_min);
        cur_min = Math.min(cur_min, x);
    }
    return profit;
}

/*
    23. PROBLEM DESCRIPTION (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
*/
public int maxProfit(int[] prices) {
    int profit = 0;
    for(int i=1;i<prices.length;i++)
        profit += Math.max(0, prices[i] - prices[i-1]);
    return profit;
}

/*
    24. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-palindrome/)
*/
public boolean isPalindrome(String s) {
    int start_idx = 0, end_idx = s.length()-1;
    while(start_idx<end_idx)
    {
        char cur_start_c = Character.toLowerCase(s.charAt(start_idx)), cur_end_c=Character.toLowerCase(s.charAt(end_idx));
        if(!Character.isLetterOrDigit(cur_start_c))
            start_idx++;
        else if(!Character.isLetterOrDigit(cur_end_c))
            end_idx--;
        else
        { 
            if(cur_start_c != cur_end_c)
                return false;
            start_idx++;
            end_idx--;
        }
    }
    return true;
}

/*
    25. PROBLEM DESCRIPTION (https://leetcode.com/problems/implement-strstr/)
*/
public int strStr(String haystack, String needle) {
    int len_needle = needle.length();
    for(int i=0;i<=haystack.length() - len_needle;i++)
    {
        String cur_substr = haystack.substring(i,len_needle+i);
        if(cur_substr.equals(needle))
            return i;
    }
    return -1;
}

/*
    26. PROBLEM DESCRIPTION (https://leetcode.com/problems/permutations/)
*/
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute_helper(0, nums, result);
    return result;
}
public void permute_helper(int pos_idx, int nums[], List<List<Integer>> result)
{
    if(pos_idx == nums.length-1)
    {
        ArrayList<Integer> new_lst = new ArrayList<>();
        for(int x:nums)
            new_lst.add(x);
        result.add(new_lst);
    }
    else
    {
        for(int idx=pos_idx; idx<nums.length; idx++)
        {
            swap(nums, pos_idx, idx);
            permute_helper(pos_idx+1, nums, result);
            swap(nums, pos_idx, idx);
        }
    }
}
public void swap(int nums[], int i, int j)
{
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

/*
    27. PROBLEM DESCRIPTION (https://leetcode.com/problems/permutations-ii/)
*/
public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    boolean isplaced[] = new boolean[nums.length];
    permute_helper(0, nums, isplaced, result, new ArrayList<Integer>());
    return result;
}
public void permute_helper(int pos_idx, int[] nums, boolean isplaced[], List<List<Integer>> result, List<Integer> cur_list)
{
    if(pos_idx ==nums.length)
    {
        result.add(new ArrayList(cur_list));
        return;
    }
    for(int i = 0; i<nums.length; i++)
    {
        if (i == 0 || (nums[i]==nums[i-1] && isplaced[i-1])|| nums[i]!=nums[i-1])
        {
            if(isplaced[i])
                continue;
            cur_list.add(nums[i]);
            isplaced[i] = true;
            permute_helper(pos_idx+1, nums, isplaced, result, cur_list);
            cur_list.remove(cur_list.size()-1);
            isplaced[i] = false;
        }
    }
}

/*
    28. PROBLEM DESCRIPTION (https://leetcode.com/problems/multiply-strings/)
*/
public String multiply(String num1, String num2) {
    int idx1 = num1.length()-1, result[] = new int[num1.length()+num2.length()], idx2;
    char[] char_arr1 = num1.toCharArray(), char_arr2 = num2.toCharArray();
    while(idx1>=0)
    {
        idx2 = num2.length()-1;
        while(idx2>=0)
        {
            int c1 = char_arr1[idx1]-'0', c2 = char_arr2[idx2]-'0';
            int product = c1*c2;
            result[idx1+idx2+1] += product;
            result[idx1+idx2] += result[idx1+idx2+1]/10;
            result[idx1+idx2+1] %= 10;
            idx2--;
        }
        idx1--;
    }
    int idx = 0;
    while(idx<result.length-1 && result[idx]==0)
        idx++;
    StringBuffer sb = new StringBuffer();
    for (int i= idx; i<result.length; i++)
    {
        sb.append(String.valueOf(result[i]));
    }
    return sb.toString();
}

/*
    29. PROBLEM DESCRIPTION (http://leetcode.com/problems/generate-parentheses/)
*/
public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    helper(0, 0, sb, result, 2*n);
    return result;
}
public void helper(int cur_pos, int num_open, StringBuffer sb, List<String> result, int n)
{
    if( cur_pos == n && num_open == 0)
    {
        result.add(sb.toString());
        return;
    }
    if(n-cur_pos > num_open)
    {
        sb.append("(");
        helper(cur_pos+1, num_open+1, sb, result, n);
        sb.deleteCharAt(sb.length()-1);
    }
    if(num_open>0)
    {
        sb.append(")");
        helper(cur_pos+1, num_open-1, sb, result, n);
        sb.deleteCharAt(sb.length()-1);
    }
}

/*
    30. PROBLEM DESCRIPTION (https://leetcode.com/problems/combination-sum/)
*/
public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur_list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(0, candidates, target, cur_list, result);
        return result;
    }
    public void helper(int cur_idx, int[] candidates, int sum_left, List<Integer> cur_list, List<List<Integer>> result)
    {
        if(sum_left == 0)
        {
            result.add(new ArrayList(cur_list));
            return;
        }
        for(int i=cur_idx; i<candidates.length; i++)
        {
            if(candidates[i]>sum_left)
                continue;
            cur_list.add(candidates[i]);
            helper(i, candidates, sum_left-candidates[i], cur_list, result);
            cur_list.remove(cur_list.size()-1);
        }
    }

/*
    31. PROBLEM DESCRIPTION (https://leetcode.com/problems/combination-sum-ii/)
*/
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur_list = new ArrayList<>();
    helper(0, target, candidates, cur_list, result);
    return result;
}
public void helper(int cur_idx, int sum_left, int[] candidates, List<Integer> cur_list, List<List<Integer>> result)
{
    if(sum_left == 0)
    {
        result.add(new ArrayList(cur_list));
        return;
    }
    for(int i=cur_idx; i<candidates.length; i++)
    {
        if(candidates[i]>sum_left)
            break;
        if( i>cur_idx && candidates[i]==candidates[i-1])
            continue;

        cur_list.add(candidates[i]);
        helper(i+1, sum_left-candidates[i], candidates, cur_list, result);
        cur_list.remove(cur_list.size()-1);
    }
}

/*
    32. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-sudoku/)
*/
public boolean isValidSudoku(char[][] board) {
    HashSet<Character>[] rowflag = new HashSet[9], colflag = new HashSet[9], subboardflag = new HashSet[9];
    for(int idx=0; idx<9; idx++)
    {
        rowflag[idx] = new HashSet();
        colflag[idx] = new HashSet();
        subboardflag[idx] = new HashSet();
    }
    for(int row_idx=0; row_idx<9; row_idx++)
    {
        for(int col_idx=0; col_idx<9; col_idx++)
        {
            char cur_c = board[row_idx][col_idx];
            if(cur_c == '.')
                continue;
            if(!rowflag[row_idx].add(cur_c))
                return false;
            if(!colflag[col_idx].add(cur_c))
                return false;
            if(!subboardflag[(row_idx/3)*3 + col_idx/3].add(cur_c))
                return false;
        }
    }
    return true;
}

/*
    33. PROBLEM DESCRIPTION (https://leetcode.com/problems/sudoku-solver/)
*/
public void solveSudoku(char[][] board) {
    HashSet<Character>[] rowflag = new HashSet[9], colflag = new HashSet[9], subboardflag = new HashSet[9];
    for(int idx=0; idx<9; idx++)
    {
        rowflag[idx] = new HashSet();
        colflag[idx] = new HashSet();
        subboardflag[idx] = new HashSet();
    }
    setboard(rowflag, colflag, subboardflag, board);
    fillboard(rowflag, colflag, subboardflag, board, 0);
}

public boolean fillboard(HashSet<Character> rowflag[], HashSet<Character> colflag[], HashSet<Character> subboardflag[], char[][] board, int cur_idx)
{
    if(cur_idx == 81)
        return true;
    int currow_idx = cur_idx/9, curcol_idx = cur_idx%9;
    char c = board[currow_idx][curcol_idx];
    if( c != '.')
        return fillboard(rowflag, colflag, subboardflag, board, cur_idx+1);
    for(char iter_c='1'; iter_c<='9'; iter_c++)
    {
        if(!rowflag[currow_idx].contains(iter_c) && !colflag[curcol_idx].contains(iter_c) && !subboardflag[(currow_idx/3)*3 + curcol_idx/3].contains(iter_c))
        {
            rowflag[currow_idx].add(iter_c);
            colflag[curcol_idx].add(iter_c);
            subboardflag[(currow_idx/3)*3 + curcol_idx/3].add(iter_c);
            board[currow_idx][curcol_idx] = iter_c;
            if(fillboard(rowflag, colflag, subboardflag, board, cur_idx+1))
                return true;
            rowflag[currow_idx].remove(iter_c);
            colflag[curcol_idx].remove(iter_c);
            subboardflag[(currow_idx/3)*3 + curcol_idx/3].remove(iter_c);
            board[currow_idx][curcol_idx] = '.';
        }
    }
    return false;
}

public void setboard(HashSet<Character>[] rowflag, HashSet<Character>[] colflag, HashSet<Character>[] subboardflag, char[][] board)
{
    for(int row_idx=0; row_idx<9; row_idx++)
    {
        for(int col_idx=0; col_idx<9; col_idx++)
        {
            char cur_c = board[row_idx][col_idx];
            if(cur_c == '.')
                continue;
            rowflag[row_idx].add(cur_c);
            colflag[col_idx].add(cur_c);
            subboardflag[(row_idx/3)*3+ col_idx/3].add(cur_c);
        }
    }
}

/*
    34. PROBLEM DESCRIPTION (https://leetcode.com/problems/3sum/)
*/
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0; i<nums.length-2; i++)
    {
        if(i>0 && nums[i]==nums[i-1])
            continue;
        int k = nums.length-1;
        for(int j=i+1; j<nums.length-1; j++)
        {
            if(j>=k)
                break;
            if (j>i+1 && nums[j]==nums[j-1])
                continue;
            while(k>j+1 && (nums[i] + nums[j] + nums[k]>0))
                k -= 1;
            if(nums[k]+nums[i]+nums[j] == 0)
                result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
        }
    }
    return result;
}

/*
    34_2. PROBLEM DESCRIPTION (https://leetcode.com/problems/3sum-closest/)
*/
public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closest = Integer.MAX_VALUE, min_difference = Integer.MAX_VALUE;
    for(int i=0; i<nums.length-2;i++)
    {
        if (i>0 && nums[i]==nums[i-1])
            continue;
        int k = nums.length-1;
        for(int j=i+1; j<nums.length-1; j++)
        {
            if(j>=k)
                break;
            if(j>i+1 && nums[j]==nums[j-1])
                continue;
            int cur_sum = nums[i]+nums[j];
            while(k>j+1 && cur_sum+nums[k]>target)
                k--;
            cur_sum = nums[i]+nums[j]+nums[k];
            int abs_diff = Math.abs(target-cur_sum);
            //Check currnt val and then next val if present
            if(k>j && min_difference>abs_diff)
            {
                closest = cur_sum;
                min_difference = abs_diff;
            }
            if(k+1<nums.length)
            {
                cur_sum = nums[i]+nums[j]+nums[k+1];
                abs_diff = Math.abs(target-cur_sum);
                if(min_difference>abs_diff)
                {
                    closest = cur_sum;
                    min_difference = abs_diff;
                }
            }
        }
    }
    return closest;
}

/*
    35. PROBLEM DESCRIPTION (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
*/
String map[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    helper(digits, new StringBuffer(), 0, result);
    return result;
}
public void helper(String digits, StringBuffer sb, int idx, List<String> result)
{
    if(digits.length()==idx)
    {
        result.add(sb.toString());
        return;
    }
    char cur_c = digits.charAt(idx); 
    for(char c: map[cur_c-'2'].toCharArray())
    {
        sb.append(c);
        helper(digits, sb, idx+1, result);
        sb.deleteCharAt(sb.length()-1);
    }
}

/*
    36. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-valid-parentheses/)
*/

public static void main(String args[])
{
    Scanner in = new Scanner(System.in);
    System.out.println("Entered Main");
}

}