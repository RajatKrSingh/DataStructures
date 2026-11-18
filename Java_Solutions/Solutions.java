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
public int longestValidParentheses(String s) {
    int len= s.length(), dp[] = new int[len+1], cur_max=0, global_max=0;
    char sArr[] = s.toCharArray();
    for(int i=2; i<=len; i++)
    {
        cur_max = 0;
        if(sArr[i-1]==')')
        {
            if(sArr[i-2]=='(')
                cur_max = 2+dp[i-2];
            if((i-2-dp[i-1]!=-1) && sArr[i-2-dp[i-1]]=='(')
                cur_max = Math.max(cur_max, 2+dp[i-2-dp[i-1]]+dp[i-1]);
        }
        dp[i] = cur_max;
        global_max = Math.max(global_max, cur_max);
    }
    return global_max;
}

public int longestValidParentheses(String s) {
    Deque<Integer> stck = new ArrayDeque<>();
    stck.push(-1);
    int len = s.length(), result=0;
    for(int i=0; i<len; i++)
    {
        if(s.charAt(i)=='(')
            stck.push(i);
        else
        {
            stck.pop();
            if(stck.size()==0)
                stck.push(i);
            else
                result = Math.max(result, i-stck.peek());
        }
    }
    return result;
}

/*
    37. PROBLEM DESCRIPTION (https://leetcode.com/problems/decode-ways/)
*/
public int numDecodings(String s) {
    int num_ways_til_prev=1, num_ways_til_now = 1, len = s.length(),temp;
    for(int i=0;i<len;i++)
    {
        temp = num_ways_til_prev;
        num_ways_til_prev = num_ways_til_now;
        if(s.charAt(i)=='0')
            num_ways_til_now = 0;
        if(i>0 && (s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<'7')))
            num_ways_til_now += temp;
    }
    return num_ways_til_now;
}

/*
    38. PROBLEM DESCRIPTION (https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/)
*/
public int findBestValue(int[] arr, int target) {
    Arrays.sort(arr);
    int cur_sum = 0, cur_total = 0, len = arr.length;
    for(int i=0; i<len; i++)
    {
        cur_total = cur_sum + (len-i)*arr[i];
        if(cur_total > target)
            return (int)(Math.ceil(1.0*target/(len-i) - 0.5));
        target -= arr[i];
    }
    return arr[len-1];
}

public int findBestValue(int[] arr, int target) {
    int lb=1, ub=0, mid;
    for(int x: arr)
        ub = Math.max(x, ub);
    while(lb<ub)
    {
        mid = (lb + ub)/2;
        if(sumhelper(arr, mid) > target)
            ub = mid;
        else
            lb = mid + 1;
    }
    int candidate_lower = target - sumhelper(arr, lb-1), candidate_higher = sumhelper(arr, lb) - target;
    return (candidate_lower<=candidate_higher?lb-1:lb);
}

public int sumhelper(int[] arr, int candidate)
{
    int total = 0;
    for(int x: arr)
        total += Math.min(x, candidate);
    return total;
}

/*
    39. PROBLEM DESCRIPTION (https://leetcode.com/problems/happy-number/)
*/
public boolean isHappy(int n) {
    HashSet<Integer> hset = new HashSet<>();
    int cur_total, modval;
    while(n!=1)
    {
        cur_total = 0;
        while(n>0)
        {
            modval = n%10;
            cur_total += modval*modval;
            n /= 10;
        }
        if(!hset.add(cur_total))
            return false;
        n = cur_total;
    }
    return true;
}

/*
    40. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-inorder-traversal/)
*/
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode cur_node = root;
    Stack<TreeNode> stck = new Stack<>();
    while(true)
    {
        if(cur_node!=null)
        {
            stck.push(cur_node);
            cur_node = cur_node.left;
        }
        else
        {
            if(stck.isEmpty())
                return result;
            cur_node = stck.pop();
            result.add(cur_node.val);
            cur_node = cur_node.right;
        }
    }
}

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    helper(result, root);
    return result;
}
public void helper(List<Integer> result, TreeNode root)
{
    if(root==null)
        return;
    helper(result, root.left);
    result.add(root.val);
    helper(result, root.right);
}

/*
    41. PROBLEM DESCRIPTION (https://leetcode.com/problems/delete-nodes-and-return-forest/)
*/
public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> result = new ArrayList<>();
    HashSet<Integer> hset = new HashSet<>();
    for(int x: to_delete)
        hset.add(x);
    if(!helper(root, hset, result))
        result.add(root);
    return result;
}
public boolean helper(TreeNode root, HashSet<Integer> hset, List<TreeNode> result)
{
    if(root == null)
        return false;
    boolean is_left_deleted = helper(root.left, hset, result);
    boolean is_right_deleted = helper(root.right, hset, result);
    boolean this_node_deleted = hset.contains(root.val);
    
    if(this_node_deleted)
    {
        if(!is_left_deleted && root.left!=null)
            result.add(root.left);
        if(!is_right_deleted && root.right!=null)
            result.add(root.right);
            
    }
    if(is_left_deleted)
        root.left = null;       
    if(is_right_deleted)
        root.right = null;
    return this_node_deleted;
}

/*
    42. PROBLEM DESCRIPTION (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
*/
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null || root == p || root == q)
        return root;
    TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q), rightAncestor = lowestCommonAncestor(root.right, p, q);
    if(leftAncestor!=null && rightAncestor!=null)
        return root;
    return leftAncestor!=null?leftAncestor:rightAncestor;
}

/*
    43. PROBLEM DESCRIPTION (https://leetcode.com/problems/subarray-sum-equals-k/)
*/
public int subarraySum(int[] nums, int k) {
    int cur_sum = 0, result = 0;
    HashMap<Integer, Integer> hmap = new HashMap<>();
    hmap.put(0,1);
    for(int x:nums)
    {
        cur_sum += x;
        result += hmap.getOrDefault(cur_sum-k,0); 
        hmap.put(cur_sum, hmap.getOrDefault(cur_sum,0)+1);
    }
    return result;
}

/*
    44. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-subarray/)
*/
public int maxSubArray(int[] nums) {
    int current_max = 0, result = nums[0];
    for(int x:nums)
    {
        current_max += x;
        result = Math.max(result, current_max);
        current_max = Math.max(0, current_max);
    }
    return result;
}

/*
    45. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-palindromic-substring)
*/
public String longestPalindrome(String s) {
    char[] sArr = s.toCharArray();
    String subresult="", temp;
    int len = s.length(), result = 0;
    for(int i=0; i<len;i++)
    {
        temp = expandFromCenter(sArr, i, i);
        if(temp.length() > subresult.length() )
            subresult = temp;

        temp = expandFromCenter(sArr, i, i+1);
        if(temp.length() > subresult.length() )
            subresult = temp;
    }
    return subresult;
}

public String expandFromCenter(char[] sArr, int left, int right)
{
    int result = 0;
    while(left>-1 && right<sArr.length && sArr[left]==sArr[right])
    {
        result = right-left+1;
        left--;
        right++;
    }
    return new String(sArr, left+1, result);
}

/*
    46. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
*/
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummyhead = new ListNode(0, head), slow = dummyhead, fast = dummyhead;
    for(int i=0;i<n;i++)
        fast = fast.next;
    while(fast.next!=null)
    {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummyhead.next;
}

/*
    47. PROBLEM DESCRIPTION (https://leetcode.com/problems/container-with-most-water/)
*/
public int maxArea(int[] height) {
    int result = 0, left = 0, right = height.length-1;
    while(left<right)
    {
        int current_volume = (right-left)*Math.min(height[right], height[left]);
        result = Math.max(result, current_volume);
        if(height[left]<height[right])
            left++;
        else
            right--;
    }
    return result;
}

/*
    48. PROBLEM DESCRIPTION (https://leetcode.com/problems/sort-colors/)
*/
public void sortColors(int[] nums) {
    int boundary1=0, boundary3=nums.length-1, cur_num, i=0, temp;
    while(i<=boundary3)
    {
        cur_num = nums[i];
        if(cur_num==0)
        {
            temp= nums[i];
            nums[i] = nums[boundary1];
            nums[boundary1++] = temp;
            i++;
        }
        else if(cur_num==1)
        {
            i++;
        }
        else
        {
            temp = nums[i];
            nums[i] = nums[boundary3];
            nums[boundary3--] = temp;
        }
    }
}

/*
    49. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
*/
public int[] searchRange(int[] nums, int target) {
    int left = 0, right = nums.length-1, mid;
    while(left<right)
    {
        mid = (left+right)/2;
        if(nums[mid]>=target)
            right = mid;
        else
            left = mid+1;
    }
    if( left==nums.length || nums[left]!=target)
        return new int[]{-1,-1};
    
    int start_pos = left;
    right=nums.length-1;
    while(left<right)
    {
        mid = (left+right+1)/2;
        if(nums[mid]==target)
            left = mid;
        else
            right = mid-1;
    }
    return new int[]{start_pos, left};
}

/*
    50. PROBLEM DESCRIPTION (https://leetcode.com/problems/copy-list-with-random-pointer/)
*/
public Node copyRandomList(Node head) {
    Node dummyhead = new Node(0);
    addNodes(head);
    set_random_ptr(head);
    reassign_next_ptr(head, dummyhead);
    return dummyhead.next;
}

public void addNodes(Node head)
{
    while(head!=null)
    {
        Node new_node = new Node(head.val);
        new_node.next = head.next;
        head.next = new_node;
        head = new_node.next;
    }
}

public void set_random_ptr(Node head)
{
    while(head!=null)
    {
        Node added_node = head.next;
        if(head.random!=null)
            added_node.random = head.random.next;
        head = added_node.next;
    }
}

public void reassign_next_ptr(Node head, Node dummy_head)
{
    while(head!=null)
    {
        dummy_head.next = head.next;
        head.next = head.next.next;
        head = head.next;
        dummy_head = dummy_head.next;
    }
}

/*
    51. PROBLEM DESCRIPTION (https://leetcode.com/problems/daily-temperatures/)
*/
public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stck = new Stack<>();
    int answer[] = new int[temperatures.length], cur_temp;
    for(int i=temperatures.length-1; i>=0; i--)
    {
        cur_temp = temperatures[i];
        while(!stck.isEmpty() && temperatures[stck.peek()]<=cur_temp)
            stck.pop();
        if(stck.isEmpty())
            answer[i] = 0;
        else
            answer[i] = stck.peek()-i;
        stck.push(i);
    }
    return answer;
}

/*
    52. PROBLEM DESCRIPTION (https://leetcode.com/problems/invert-binary-tree/)
*/
public TreeNode invertTree(TreeNode root) {
    if(root==null)
        return root;
    TreeNode right = invertTree(root.left);
    root.left = invertTree(root.right);
    root.right = right;
    return root;
}

/*
    53. PROBLEM DESCRIPTION (https://leetcode.com/problems/linked-list-cycle/)
*/
public boolean hasCycle(ListNode head) {
    ListNode slow=head, fast=head;
    while(fast!=null && fast.next!=null)
    {
        fast = fast.next.next;
        slow = slow.next;
        if(slow==fast)
            return true;
    }
    return false;
}
/*
    54. PROBLEM DESCRIPTION (https://leetcode.com/problems/linked-list-cycle-ii/)
*/
public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while(fast!=null && fast.next!=null)
    {
        fast = fast.next.next;
        slow = slow.next;
        if(fast==slow)
            break;
    }
    if(fast==null || fast.next==null)
        return null;
    slow = slow.next;
    int cycle_length = 1;
    while(slow!=fast)
    {
        slow = slow.next;
        cycle_length++;
    }
    fast = head;
    slow = head;
    for(int i=0; i<cycle_length;i++)
        fast = fast.next;
    while(slow!=fast)
    {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}

/*
    55. PROBLEM DESCRIPTION (https://leetcode.com/problems/palindrome-linked-list/)
*/
public boolean isPalindrome(ListNode head) {
    ListNode midpoint = head, fast = head, front=head, temp, prev=null;
    while(fast!=null && fast.next!=null)
    {
        fast = fast.next.next;
        midpoint = midpoint.next;
    }
    fast = midpoint;
    while(fast!=null)
    {
        temp = fast.next;
        fast.next = prev;
        prev = fast;
        fast = temp;
    }
    while(prev!=null)
    {
        if(prev.val != front.val)
            return false;
        prev = prev.next;
        front = front.next;
    }
    return true;
}

/*
    56. PROBLEM DESCRIPTION (https://leetcode.com/problems/majority-element/)
*/
public int majorityElement(int[] nums) {
    int cur_max=0, cur_count=0;
    for(int cur_num:nums)
    {
        if(cur_count==0)
        {
            cur_count = 1;
            cur_max = cur_num;
        }
        else if(cur_num==cur_max)
            cur_count++;
        else
            cur_count--;
    }
    return cur_max;
}

/*
    57. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-largest-element-in-an-array/)
*/
// Heap Technique
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue();
    for(int x : nums)
    {
        pq.add(x);
        if(pq.size()>k)
            pq.poll();
    }
    return pq.poll();
}

// Counting sort
public int findKthLargest(int[] nums, int k) {
    int max_ele = nums[0], min_ele = nums[0], left = k;
    for(int x: nums)
    {
        max_ele = Math.max(max_ele, x);
        min_ele = Math.min(min_ele, x);
    }
    int count[]= new int[max_ele-min_ele+1];
    for(int x: nums)
        count[x-min_ele]++;
    for(int i=max_ele; i>=min_ele; i--)
    {
        left -= count[i-min_ele];
        if(left<=0)
            return i;
    }
    return -1;
}

public int findKthLargest(int[] nums, int k) {
    return quickselect(nums, 0, nums.length-1, k-1);
}

public int quickselect(int nums[], int lb, int ub, int k)
{
    int partition[] = partition(nums, lb, ub);
    int lower = partition[0], same = partition[1];
    if(k<=lower+same && k>lower)
        return nums[lower+same];
    if(k<=lower)
        return quickselect(nums, lb, lower, k);
    if(k>lower+same)
        return quickselect(nums, lower+same+1, ub, k);
    return nums[lower+same];
}

public int[] partition(int nums[], int lb, int ub)
{
    int pivot = nums[ub], same=0, lower=0, temp, i=lb;
    while(i<ub)
    {
        if(nums[i]>pivot)
        {
            temp = nums[lb+lower];
            nums[lb+lower] = nums[i];
            nums[i] = temp;
            if(nums[i]==pivot)
            {
                i--;
                same--;
            }
            lower++;
        }
        else if (nums[i]==pivot)
        {
            temp = nums[lb+lower+same];
            nums[lb+lower+same] = nums[i];
            nums[i] = temp;
            same++;
        }
        i++;
    }
    temp = nums[lb+lower+same];
    nums[lb+lower+same] = nums[ub];
    nums[ub] = temp;
    same++;
    return new int[]{lb+lower-1, same};
}

/*
    58. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-two-binary-trees/)
*/
public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if(root1 == null)
        return root2;
    if(root2 != null)
    {
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
    }
    return root1;
}

/*
    59. PROBLEM DESCRIPTION (https://leetcode.com/problems/game-of-life/)
*/
int dir[][] = {{1,1},{1,0},{0,1}, {0,-1},{-1,0}, {-1,-1}, {1,-1}, {-1, 1}};
public void gameOfLife(int[][] board) {
    performTransitions(board);
    substituteNextState(board);
}

public void substituteNextState(int[][] board)
{
    int m=board.length, n=board[0].length, cur_status;
    for(int i=0;i<m;i++)
    {
        for(int j=0; j<n;j++)
        {
            cur_status = board[i][j];
            if(cur_status>=2)
                board[i][j] = 0;
            else if(cur_status==-1)
                board[i][j] = 1;
        }
    }
}

public void performTransitions(int[][] board)
{
    int m=board.length, n=board[0].length, count, cur_status;
    for(int i=0; i<m;i++)
    {
        for(int j=0; j<n; j++)
        {
            cur_status = board[i][j];
            count = getCountLiveNeighbors(board, i, j, m, n);
            if(cur_status==1)
            {
                if(count<2)
                    board[i][j] = 2;
                else if(count>3)
                    board[i][j] = 3;
            }
            else
            {
                if(count==3)
                    board[i][j] = -1;
            }
        }
    }
}
public int getCountLiveNeighbors(int[][] board, int row, int col, int m, int n)
{
    int new_row, new_col, result=0;
    for(int[] d: dir)
    {
        new_row = row+d[0];
        new_col = col+d[1];
        if(new_row>-1 && new_row<m && new_col>-1 && new_col<n && board[new_row][new_col]>0)
            result++;
    }
    return result;
}

/*
    60. PROBLEM DESCRIPTION (https://leetcode.com/problems/diameter-of-binary-tree/)
*/
public int diameterOfBinaryTree(TreeNode root) {
    return helper(root)[1];
}
public int[] helper(TreeNode root)
{
    if(root==null)
        return new int[]{0,0};
    int[] count_left = helper(root.left);
    int[] count_right = helper(root.right);
    int result[] = {1+Math.max(count_left[0],count_right[0]) , Math.max(count_left[1], count_right[1])};
    result[1] = Math.max(result[1], count_left[0]+count_right[0]);
    return result;
}

/*
    61. PROBLEM DESCRIPTION (https://leetcode.com/problems/intersection-of-two-linked-lists/)
*/
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode ptr1 = headA, ptr2 = headB;
    int reset_count = 0;
    while(reset_count<3)
    {
        if(ptr1 == null)
        {
            ptr1 = headB;
            reset_count++;
        }
        if(ptr2 == null)
        {
            ptr2 = headA;
            reset_count++;
        }
        if(ptr1==ptr2)
            return ptr1;
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
    }
    return null;
}

/*
    62. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-linked-list/)
*/
public ListNode reverseList(ListNode head) {
    ListNode prev = null, temp;
    while(head!=null)
    {
        temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;
    }
    return prev;
}

/*
    63. PROBLEM DESCRIPTION (https://leetcode.com/problems/house-robber/)
*/
public int rob(int[] nums) {
    int prev = 0, current = nums[0], next;
    for(int i=1; i<nums.length; i++)
    {
        next = Math.max(current, prev+nums[i]);
        prev = current;
        current = next;
    }
    return current;
}

/*
    64. PROBLEM DESCRIPTION (https://leetcode.com/problems/lru-cache/)
*/
class LRUCache {

    class DNode
    {
        int key, value;
        DNode next, prev;
        public DNode(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    DNode head = new DNode(0,0), tail = new DNode(0,0);
    Map<Integer, DNode> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void move_to_front(DNode mynode)
    {
        mynode.prev.next = mynode.next;
        mynode.next.prev = mynode.prev;
        mynode.next = null;
        mynode.prev = null;
        add_to_front(mynode);
    }

    public void add_to_front(DNode mynode)
    {
        mynode.next = this.head.next;
        mynode.prev = this.head;
        this.head.next.prev = mynode;
        this.head.next = mynode;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key))
        {
            DNode mynode = cache.get(key);
            move_to_front(mynode);
            return mynode.value;
        }
        return -1;
    }

    public void remove_node()
    {
        this.cache.remove(this.tail.prev.key);
        this.tail.prev.prev.next = this.tail;
        this.tail.prev = this.tail.prev.prev;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key))
        {
            DNode mynode = cache.get(key);
            mynode.value = value;
            move_to_front(mynode);
        }
        else
        {
            if(this.cache.size()==this.capacity)
                remove_node();
            DNode newnode = new DNode(key, value);
            this.cache.put(key, newnode);
            add_to_front(newnode);
        }
    }
}

/*
    65. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
*/
public List<Integer> findDisappearedNumbers(int[] nums) {
    int len = nums.length, index_value;
    for(int i=0;i<len;i++)
    {
        index_value = Math.abs(nums[i])-1;
        if(nums[index_value]>0)
            nums[index_value] = 0 - nums[index_value];
    }
    List<Integer> result = new ArrayList<>();
    for(int i=0; i<len; i++)
    {
        if(nums[i]<0)
            nums[i] = 0-nums[i];
        else
            result.add(i+1);
    }
    return result;
}

/*
    66. PROBLEM DESCRIPTION (https://leetcode.com/problems/target-sum/)
*/
public int findTargetSumWays(int[] nums, int target) {
    int dp_prev[] = new int[2001], len=nums.length, cur_num;
    dp_prev[1000]=1;
    for(int i=0; i<len; i++)
    {
        int dp_next[] = new int[2001];
        cur_num = nums[i];
        for(int j= cur_num; j<=2000;j++)
            dp_next[j] += dp_prev[j-cur_num];
        for(int j= 0; j<=2000-cur_num;j++)
            dp_next[j] += dp_prev[j+cur_num];
        dp_prev = dp_next;
    }
    return dp_prev[target+1000];
}

/*
    67. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-depth-of-binary-tree/)
*/
public int maxDepth(TreeNode root) {
    if(root == null)
        return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}

/*
    68. PROBLEM DESCRIPTION (https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
*/
public void flatten(TreeNode root) {
    if(root==null)
        return;
    flatten(root.left);
    flatten(root.right);
    TreeNode right = root.right;
    root.right = root.left;
    root.left = null;
    while(root.right!=null)
        root = root.right;
    root.right = right;
}

/*
    69. PROBLEM DESCRIPTION (https://leetcode.com/problems/subsets/)
*/
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(nums, 0, new ArrayList<Integer>(), result);
    return result;
}

public void helper(int[] nums, int index, List<Integer> cur_list, List<List<Integer>> result)
{
    if(index == nums.length)
    {
        result.add(new ArrayList(cur_list));
        return;
    }
    helper(nums, index+1, cur_list, result);
    cur_list.add(nums[index]);
    helper(nums, index+1, cur_list, result);
    cur_list.remove(cur_list.size()-1);
}


/*
    70. PROBLEM DESCRIPTION (https://leetcode.com/problems/symmetric-tree/)
*/
public boolean isSymmetric(TreeNode root) {
    return helper(root.left, root.right);
}
public boolean helper(TreeNode left, TreeNode right)
{
    if(left==null ^ right==null)
        return false;
    if(left==null)
        return true;
    if(left.val != right.val)
        return false;
    return helper(left.right, right.left) && helper(left.left, right.right);
}

/*
    71. PROBLEM DESCRIPTION (https://leetcode.com/problems/subsets-ii/)
*/
public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    boolean isplaced[] = new boolean[nums.length];
    helper(nums, 0, isplaced, new ArrayList<Integer>(), result);
    return result; 
}
public void helper(int[] nums, int index, boolean isplaced[], List<Integer> cur_list, List<List<Integer>> result)
{
    if(index == nums.length)
    {
        result.add(new ArrayList(cur_list));
        return;
    }
    helper(nums, index+1, isplaced, cur_list, result);
    if(index==0 || (nums[index]!=nums[index-1] || isplaced[index-1]))
    {
        isplaced[index] = true;
        cur_list.add(nums[index]);
        helper(nums, index+1, isplaced, cur_list, result);
        cur_list.remove(cur_list.size()-1);
        isplaced[index] = false;
    }
}

/*
    72. PROBLEM DESCRIPTION (https://leetcode.com/problems/jump-game/)
*/
public boolean canJump(int[] nums) {
    int len = nums.length-1, index = 0, max_reach=0;
    while(index<=max_reach)
    {
        max_reach = Math.max(max_reach, nums[index]+index);
        if(max_reach>=len)
            break;
        index++;
    }
    return max_reach>=len;
}

/*
    73. PROBLEM DESCRIPTION (https://leetcode.com/problems/group-anagrams/)
*/
public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> hmap = new HashMap<>();
    for(String s: strs)
    {
        char sArr[] = s.toCharArray();
        Arrays.sort(sArr);
        String hashcode = new String(sArr);
        if(!hmap.containsKey(hashcode))
            hmap.put(hashcode, new ArrayList<>());
        hmap.get(hashcode).add(s);
    }
    return new ArrayList<>(hmap.values());
}

/*
    74. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-paths/)
*/
public int uniquePaths(int m, int n) {
    int dp[] = new int[n];
    dp[0] = 1;
    for(int i=0; i<m; i++)
        for(int j=1; j<n; j++)
            dp[j] += dp[j-1];
    return dp[n-1];
}

/*
    75. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-path-sum/)
*/
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length, dp[] = grid[0];
    for(int i=1;i<n;i++)
        dp[i] += dp[i-1];
    for(int i=1; i<m; i++)
    {
        dp[0] += grid[i][0];
        for(int j=1; j<n; j++)
            dp[j] = Math.min(dp[j-1], dp[j])+grid[i][j];
    }
    return dp[n-1];
}

/*
    76. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-level-order-traversal/)
*/
public List<List<Integer>> levelOrder(TreeNode root) {
    record Pair<T>(T node, int level){}
    List<List<Integer>> result= new ArrayList<>();
    if(root==null)
        return result;
    Deque<Pair<TreeNode>> myqueue = new ArrayDeque();
    myqueue.add(new Pair(root, 0));
    while(!myqueue.isEmpty())
    {
        Pair<TreeNode> popped_pair = myqueue.pollFirst();
        TreeNode popped_node = popped_pair.node();
        int level = popped_pair.level();
        if(popped_node.left!=null)
            myqueue.offerLast(new Pair(popped_node.left, level+1));
        if(popped_node.right!=null)
            myqueue.offerLast(new Pair(popped_node.right, level+1));
        if(level==result.size())
            result.add(new ArrayList<>());
        result.get(level).add(popped_node.val);
    }
    return result;
}

/*
    77. PROBLEM DESCRIPTION (https://leetcode.com/problems/validate-binary-search-tree/)
*/
public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
}

public boolean helper(TreeNode root, Integer lb, Integer ub)
{
    if(root==null)
        return true;
    if((lb!=null && root.val<=lb) || (ub!=null && root.val>=ub))
        return false;
    return helper(root.left, lb, root.val) && helper(root.right, root.val, ub);
}

/*
    78. PROBLEM DESCRIPTION (https://leetcode.com/problems/word-search/)
*/
public boolean exist(char[][] board, String word) {
    int m=board.length, n=board[0].length;
    char[] wordArr = word.toCharArray();
    for(int i=0; i<m; i++)
        for(int j=0; j<n; j++)
            if(helper(board, wordArr, i, j, 0, m, n))
                return true;
    return false;
}
public boolean helper(char[][] board, char[] word, int row, int col, int word_idx, int m, int n)
{
    if(word_idx==word.length)
        return true;
    if(row<0 || row>=m || col<0 || col>=n || board[row][col]!=word[word_idx])
        return false;
    char temp = board[row][col];
    board[row][col] = '#';
    boolean isfound = helper(board, word, row-1, col, word_idx+1, m, n)
        || helper(board, word, row+1, col, word_idx+1, m, n)
        || helper(board, word, row, col-1, word_idx+1, m, n)
        || helper(board, word, row, col+1, word_idx+1, m, n);
    board[row][col] = temp;
    return isfound;
}

/*
    79. PROBLEM DESCRIPTION (https://leetcode.com/problems/contains-duplicate/)
*/
public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> hset = new HashSet<>();
    for(int x: nums)
    {
        if(!hset.add(x))
            return true;
    }
    return false;
}

/*
    80. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-primes/)
*/
public int countPrimes(int n) {
    if(n<3)
        return 0;
    boolean is_prime[] = new boolean[n];
    Arrays.fill(is_prime, true);
    is_prime[0] = is_prime[1] = false;
    int max_limit = (int)(Math.pow(n, 0.5))+1, result=0;
    for(int i=2; i<max_limit; i++)
    {
        if(is_prime[i])
        {
            for(int j=i*i; j<n; j+=i)
                is_prime[j] = false;
        }
    }
    for(boolean x:is_prime)
        result += (x?1:0);
    return result;
}

/*
    81. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-islands/)
*/
public int numIslands(char[][] grid) {
    int result = 0, m=grid.length, n=grid[0].length;
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]=='1')
            {
                helper(grid, i, j, m, n);
                result++;
            }
        }
    }
    return result;
}
public void helper(char[][] grid, int row, int col, int m, int n)
{
    if(row<0 || row>=m || col<0 || col>=n || grid[row][col]!='1')
        return;
    grid[row][col]='#';
    helper(grid, row+1, col, m, n);
    helper(grid, row-1, col, m, n);
    helper(grid, row, col+1, m, n);
    helper(grid, row, col-1, m, n);
}

/*
    82. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-peak-element/)
*/
public int findPeakElement(int[] nums) {
    int left=0, right=nums.length-1, mid;
    while(left<right)
    {
        mid = (left+right)/2;
        if(nums[mid]>nums[mid+1])
            right = mid;
        else
            left = mid+1;
    }
    return left;
}

/*
    83. PROBLEM DESCRIPTION (https://leetcode.com/problems/fizz-buzz/)
*/
public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>();
    for(int iter=1; iter<=n; iter++)
    {
        StringBuffer sb = new StringBuffer();
        if(iter%3==0)
            sb.append("Fizz");
        if(iter%5==0)
            sb.append("Buzz");
        if(sb.length()==0)
            result.add(String.valueOf(iter));
        else
            result.add(sb.toString());
    }
    return result;
}

/*
    84. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
*/
public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int lb=matrix[0][0], ub=matrix[n-1][n-1], mid, count_elements_less_equal;
    while(lb<=ub)
    {
        mid = (lb+ub)/2;
        count_elements_less_equal = get_rank(matrix, mid);
        if(k<=count_elements_less_equal)
            ub = mid-1;
        else
            lb = mid+1;
    }
    return lb;
}
public int get_rank(int[][] matrix, int cur_num)
{
    int result = 0 , n = matrix.length;
    int col_index = n-1;
    for(int i=0; i<n;i++)
    {
        while(col_index>-1 && matrix[i][col_index]>cur_num)
            col_index--;
        result += col_index+1;
    }
    return result;
}

/*
    85. PROBLEM DESCRIPTION (https://leetcode.com/problems/odd-even-linked-list/)
*/
public ListNode oddEvenList(ListNode head) {
    ListNode evenhead = new ListNode(), iter = head, oddhead = new ListNode();
    ListNode evenhead_cpy = evenhead;
    boolean iseven = false;
    while(iter!=null)
    {
        if(!iseven)
        {
            oddhead.next = iter;
            oddhead = oddhead.next;
        }
        else
        {
            evenhead.next = iter;
            evenhead = evenhead.next;
        }
        iseven = !iseven;
        iter = iter.next;
    }
    evenhead.next = null;
    oddhead.next = evenhead_cpy.next;
    return head;
}

/*
    86. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-the-duplicate-number/)
*/
public int findDuplicate(int[] nums) {
    int slow = nums[0], fast = nums[0];
    while(true)
    {
        slow = nums[slow];
        fast = nums[nums[fast]];
        if(slow == fast)
            break;
    }
    slow = nums[0];
    while(slow!=fast)
    {
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
}

/*
    87. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-anagram/)
*/
public boolean isAnagram(String s, String t) {
    char sArr[] = s.toCharArray(), tArr[] = t.toCharArray();
    Arrays.sort(sArr);
    Arrays.sort(tArr);
    return (new String(sArr)).equals(new String(tArr));
}

/*
    88. PROBLEM DESCRIPTION (https://leetcode.com/problems/product-of-array-except-self/)
*/
public int[] productExceptSelf(int[] nums) {
    int n = nums.length, cur_prod = 1;
    int result[] = new int[n];
    for(int i=0; i<n; i++)
    {
        result[i] = cur_prod;
        cur_prod *= nums[i];
    }
    cur_prod = 1;
    for(int i=n-1; i>=0; i--)
    {
        result[i] *= cur_prod;
        cur_prod *=nums[i];
    }
    return result;
}

/*
    89. PROBLEM DESCRIPTION (https://leetcode.com/problems/factorial-trailing-zeroes/)
*/
public int trailingZeroes(int n) {
    int result = 0;
    while(n>0)
    {
        n /= 5;
        result += n;
    }
    return result;
}

/*
    90. PROBLEM DESCRIPTION (https://leetcode.com/problems/basic-calculator-ii/)
*/
public int calculate(String s) {
    int cur_num = 0;
    char op = '+';
    Stack<Integer> operand_stck = new Stack<>();
    s += "+";
    for(char c: s.toCharArray())
    {
        if(c == ' ')
            continue;
        if(Character.isDigit(c))
        {
            cur_num = cur_num*10 + (c-'0');
            continue;
        }
        if(op == '+')
            operand_stck.add(cur_num);
        else if (op == '-')
            operand_stck.add(0-cur_num);
        else if (op == '*')
            operand_stck.add(operand_stck.pop() * cur_num);
        else
            operand_stck.add(operand_stck.pop() / cur_num);
        op = c;
        cur_num = 0;
    }
    int result = 0;
    while(!operand_stck.isEmpty())
        result += operand_stck.pop();
    return result+cur_num;
}

/*
    91. PROBLEM DESCRIPTION (https://leetcode.com/problems/search-a-2d-matrix-ii/)
*/
public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length, n=matrix[0].length;
    int row_idx=0, col_idx=n-1, cur_num;
    while(row_idx<m && col_idx>=0)
    {
        cur_num = matrix[row_idx][col_idx];
        if(cur_num>target)
            col_idx--;
        else if(cur_num<target)
            row_idx++;
        else
            return true;
    }
    return false;
}

/*
    92. PROBLEM DESCRIPTION (https://leetcode.com/problems/delete-node-in-a-linked-list/)
*/
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}

/*
    93. PROBLEM DESCRIPTION (https://leetcode.com/problems/course-schedule/)
*/
public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> hmap = new HashMap<>();
    for(int prereq[]: prerequisites)
    {
        if(!hmap.containsKey(prereq[1]))
            hmap.put(prereq[1], new ArrayList<>());
        hmap.get(prereq[1]).add(prereq[0]);
    }
    boolean is_global_visited[] = new boolean[numCourses], is_local_visited[] = new boolean[numCourses];
    for(int i=0; i<numCourses; i++)
    {
        if(!topologicalSort(i, hmap, is_global_visited, is_local_visited))
            return false;
    }
    return true;
}

public boolean topologicalSort(int course_num, HashMap<Integer, List<Integer>> hmap, boolean global_visited[], boolean local_visited[])
{
    if(global_visited[course_num])
        return true;
    local_visited[course_num] = true;
    global_visited[course_num] = true;
    for(Integer v: hmap.getOrDefault(course_num, new ArrayList<>()))
    {
        if(local_visited[v])
            return false;
        if(!topologicalSort(v, hmap, global_visited, local_visited))
            return false;
    }
    local_visited[course_num] = false;
    return true;
}

/*
    94. PROBLEM DESCRIPTION (https://leetcode.com/problems/surrounded-regions/)
*/
public void solve(char[][] board) {
    int m = board.length, n = board[0].length;
    for(int i=0; i<m;i++)
    {
        surround_region(board, i, 0, m, n);
        surround_region(board, i, n-1, m, n);
    }
    for(int j=1; j<n-1; j++)
    {
        surround_region(board, 0, j, m, n);
        surround_region(board, m-1, j, m, n);
    }
    update_board(board, m, n);
}
public void surround_region(char[][] board, int row, int col, int m, int n)
{
    if(row>-1 && col>-1 && row<m && col<n && board[row][col]=='O')
    {
        board[row][col] = 'Y';
        surround_region(board, row+1, col, m, n);
        surround_region(board, row-1, col, m, n);
        surround_region(board, row, col+1, m, n);
        surround_region(board, row, col-1, m, n);
    }
}
public void update_board(char[][] board, int m, int n)
{
    char cur_val;
    for(int i=0; i<m;i++)
    {
        for(int j=0; j<n; j++)
        {
            cur_val = board[i][j];
            if(cur_val == 'O')
                board[i][j] = 'X';
            else if(cur_val == 'Y')
                board[i][j] = 'O';
        }
    }
}

/*
    95. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-1-bits/)
*/
public int hammingWeight(int n) {
    int result = 0;
    while(n>0)
    {
        n = n & (n-1);
        result++;
    }
    return result;
}

/*
    96. PROBLEM DESCRIPTION (https://leetcode.com/problems/excel-sheet-column-number/)
*/
public int titleToNumber(String columnTitle) {
    int result=0;
    for(char c: columnTitle.toCharArray())
        result = result*26 + (c-'A'+1);
    return result;
}

/*
    97. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-product-subarray/)
*/
public int maxProduct(int[] nums) {
    int max_positive=1, least_negative = 1, result = nums[0], temp;
    for(int x: nums)
    {
        temp = Math.max(least_negative*x,Math.max(max_positive*x, x));
        least_negative = Math.min(max_positive*x ,Math.min(least_negative*x, x));
        max_positive = temp;
        result = Math.max(result, max_positive);
    }
    return result;
}

/*
    98. PROBLEM DESCRIPTION (https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
*/
public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length-1);
}
public TreeNode helper(int[] nums, int lb, int ub)
{
    if(lb>ub)
        return null;
    int mid = (lb+ub)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, lb, mid-1);
    root.right = helper(nums, mid+1, ub);
    return root;
}
/*
    99. PROBLEM DESCRIPTION (https://leetcode.com/problems/middle-of-the-linked-list/)
*/
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while(fast!=null && fast.next!=null)
    {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

/*
    100. PROBLEM DESCRIPTION (https://leetcode.com/problems/move-zeroes/)
*/
public void moveZeroes(int[] nums) {
    int non_zero_index = 0, n = nums.length;
    for(int i=0; i<n; i++)
        if(nums[i]!=0)
            nums[non_zero_index++] = nums[i];
    Arrays.fill(nums, non_zero_index, n, 0);
}

/*
    101. PROBLEM DESCRIPTION (https://leetcode.com/problems/contiguous-array/)
*/
public int findMaxLength(int[] nums) {
    int n = nums.length, cur_num = 0,result = 0;
    HashMap<Integer, Integer> hmap = new HashMap<>();
    hmap.put(0,-1);
    for(int i=0; i<n; i++)
    {
        cur_num += (nums[i]==1?1:-1);
        if(!hmap.containsKey(cur_num))
            hmap.put(cur_num, i);
        else
            result = Math.max(result, i - hmap.get(cur_num));
    }
    return result;
}

/*
    102. PROBLEM DESCRIPTION (https://leetcode.com/problems/n-queens/)
*/
public List<List<String>> solveNQueens(int n) {
    boolean[] col_visited = new boolean[n], diag1_visited= new boolean[2*n-1], diag2_visited = new boolean[2*n-1];
    char[][] board = new char[n][n];
    List<List<String>> result = new ArrayList<>();
    for(int i=0; i<n; i++)
        Arrays.fill(board[i], '.');
    helper(0,col_visited, diag1_visited, diag2_visited, board, n, result);
    return result;
}
public void helper(int row, boolean col_visited[], boolean diag1_visited[], boolean diag2_visited[], char[][] board, int n, List<List<String>> result)
{
    if(row==n)
    {
        List<String> cur_result = new ArrayList<>();
        String cur_string;
        for(int i=0;i<n;i++)
        {
            cur_string = new String(board[i]);
            cur_result.add(cur_string);
        }
        result.add(cur_result);
        return;
    }
    for(int col_cand=0; col_cand<n; col_cand++)
    {
        if(col_visited[col_cand] || diag1_visited[row+col_cand] || diag2_visited[row-col_cand+n-1])
            continue;
        col_visited[col_cand] = true;
        diag1_visited[row+col_cand] = true;
        diag2_visited[row-col_cand+n-1] = true;
        board[row][col_cand] = 'Q';
        helper(row+1, col_visited, diag1_visited, diag2_visited, board, n, result);
        col_visited[col_cand] = false;
        diag1_visited[row+col_cand] = false;
        diag2_visited[row-col_cand+n-1] = false;
        board[row][col_cand] = '.';
    }
}

/*
    103. PROBLEM DESCRIPTION (https://leetcode.com/problems/backspace-string-compare/)
*/
public boolean backspaceCompare(String s, String t) {
    StringBuffer sb_s = new StringBuffer(), sb_t = new StringBuffer();
    int index1 = s.length()-1, index2 = t.length()-1, num_backspaces1=0, num_backspaces2=0;
    while(index1>-1 || index2>-1)
    {
        Character cur_c1 = index1>-1?s.charAt(index1):null,  cur_c2=index2>-1?t.charAt(index2):null;
        if(cur_c1!=null && cur_c1 == '#')
        {
            num_backspaces1+=1;
            index1--;
        }
        else if(cur_c2!=null && cur_c2 == '#')
        {
            num_backspaces2+=1;
            index2--;
        }
        else if(num_backspaces1>0)
        {
            index1--;
            num_backspaces1--;
        }
        else if(num_backspaces2>0)
        {
            index2 --;
            num_backspaces2--;
        }
        else
        {
            if(cur_c1!=cur_c2)
                return false;
            index1 -= 1;
            index2 -= 1;
        }
    }
    return true;
}

/*
    104. PROBLEM DESCRIPTION (https://leetcode.com/problems/last-stone-weight/)
*/
public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int x: stones)
        pq.offer(x);
    while(pq.size()>1)
    {
        int popped1 = pq.poll(), popped2 = pq.poll();
        if(popped1!=popped2)
            pq.offer(popped1-popped2);
    }
    return pq.size()==0?0:pq.poll();
}

/*
    105. PROBLEM DESCRIPTION (http://leetcode.com/problems/convert-bst-to-greater-tree/)
*/
public TreeNode convertBST(TreeNode root) {
    helper(root, 0);
    return root;
}
public int helper(TreeNode root, int sum_from_parent)
{
    if(root==null)
        return sum_from_parent;
    int rightsum = helper(root.right, sum_from_parent);
    root.val += rightsum;
    int leftsum = helper(root.left, root.val);
    return leftsum;
}

/*
    106. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-depth-of-binary-tree/)
*/
public int minDepth(TreeNode root) {
    if(root == null)
        return 0;
    record Pair<T>(TreeNode node, int depth){}
    Deque<Pair> myqueue = new ArrayDeque<>();
    myqueue.offerLast(new Pair<TreeNode>(root, 1));
    while(!myqueue.isEmpty())
    {
        Pair<TreeNode> popped_pair = myqueue.pollFirst();
        TreeNode popped_node = popped_pair.node();
        int depth = popped_pair.depth();
        if(popped_node.left==null && popped_node.right==null)
            return depth;
        if(popped_node.left!=null)
            myqueue.offerLast(new Pair<TreeNode>(popped_node.left, depth+1));
        if(popped_node.right!=null)
            myqueue.offerLast(new Pair<TreeNode>(popped_node.right, depth+1));
    }
    return -1;
}

/*
    107. PROBLEM DESCRIPTION (https://leetcode.com/problems/reorder-list/)
*/
public void reorderList(ListNode head) {
    ListNode slow = head, fast = head, prev, temp;
    while(fast!=null && fast.next!=null)
    {
        slow = slow.next;
        fast = fast.next.next;
    }
    prev = slow;
    fast = slow;
    slow = slow.next;
    prev.next = null;
    while(slow!=null)
    {
        temp = slow.next;
        slow.next = prev;
        prev = slow;
        slow = temp;
    }
    
    slow = head;
    while(prev!=fast)
    {
        temp = slow.next;
        slow.next = prev;
        prev = prev.next;
        slow.next.next = temp;
        slow = temp;
    }
}

/*
    108. PROBLEM DESCRIPTION (https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)
*/
public TreeNode bstFromPreorder(int[] preorder) {
    return helper(preorder, 0, preorder.length-1);
}
public TreeNode helper(int[] preorder, int lb, int ub)
{
    if(lb>ub)
        return null;
    int cur_num = preorder[lb], inflection_point=lb+1;
    TreeNode root = new TreeNode(cur_num);
    while(inflection_point<=ub && preorder[inflection_point]<cur_num)
        inflection_point++;
    root.left = helper(preorder, lb+1, inflection_point-1);
    root.right = helper(preorder, inflection_point, ub);
    return root;
}

/*
    109. PROBLEM DESCRIPTION (https://leetcode.com/problems/is-subsequence/)
*/
public boolean isSubsequence(String s, String t) {
    int s_index=0, s_len=s.length(), t_index=0, t_len=t.length();
    char cur_s, cur_t;
    while(s_index<s_len && t_index<t_len)
    {
        cur_s = s.charAt(s_index);
        cur_t = t.charAt(t_index);
        if(cur_s == cur_t)
            s_index+=1;
        t_index++;
    }
    return s_index == s_len;
}

/*
    110. PROBLEM DESCRIPTION (https://leetcode.com/problems/detect-capital/)
*/
public boolean detectCapitalUse(String word) {
    return word.matches("([A-Z]*)|(.[a-z]*)");
}

/*
    111. PROBLEM DESCRIPTION (https://leetcode.com/problems/sort-list/)
*/
public ListNode sortList(ListNode head) {
    if(head==null || head.next == null)
        return head;
    ListNode slow=head, fast = head;
    while(fast.next!=null && fast.next.next!=null)
    {
        slow = slow.next;
        fast = fast.next.next;
    }
    fast = slow.next;
    slow.next = null;
    ListNode sortedleft =  sortList(head);
    ListNode sortedright = sortList(fast);
    return mergehelper(sortedleft, sortedright);
}
public ListNode mergehelper(ListNode head1, ListNode head2)
{
    ListNode dummyhead = new ListNode();
    ListNode temp = dummyhead;
    while(head1!=null && head2!=null)
    {
        if(head1.val<head2.val)
        {
            temp.next = head1;
            head1 = head1.next;
        }
        else
        {
            temp.next = head2;
            head2 = head2.next;
        }
        temp = temp.next;
    }
    if(head1==null)
        temp.next = head2;
    else
        temp.next = head1;
    return dummyhead.next;
}

/*
    112. PROBLEM DESCRIPTION (https://leetcode.com/problems/pascals-triangle/)
*/
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> prev_row,cur_row;
    result.add(new ArrayList<>(Arrays.asList(1)));
    for(int i=2; i<=numRows; i++)
    {
        prev_row = result.get(result.size()-1);
        cur_row = new ArrayList<>();
        cur_row.add(1);
        for(int j=0; j<i-2; j++)
            cur_row.add(prev_row.get(j)+ prev_row.get(j+1));
        cur_row.add(1);
        result.add(cur_row);
    }
    return result;
}

/*
    113. PROBLEM DESCRIPTION (https://leetcode.com/problems/house-robber-ii/)
*/
public int rob(int[] nums) {
    int n = nums.length;
    if(n==1)
        return nums[0];
    return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
}
public int helper(int nums[], int lb, int ub)
{
    int prev_total = 0, cur_total = 0, temp;
    for(int i=lb; i<=ub; i++)
    {
        temp = Math.max(prev_total+nums[i], cur_total);
        prev_total = cur_total;
        cur_total = temp;
    }
    return cur_total;
}

/*
    114. PROBLEM DESCRIPTION (https://leetcode.com/problems/flipping-an-image/)
*/
public int[][] flipAndInvertImage(int[][] image) {
    int n = image.length;
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n/2; j++)
        {
            int temp = image[i][j];
            image[i][j] = 1-image[i][n-1-j];
            image[i][n-1-j] = 1-temp;
        }
        if(n%2==1)
            image[i][n/2] = 1-image[i][n/2];
    }
    return image;
}

/*
    115. PROBLEM DESCRIPTION (https://leetcode.com/problems/lexicographical-numbers/)
*/
public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    int cur_num = 1;
    for(int i=0; i<n; i++)
    {
        result.add(cur_num);
        if(cur_num*10<=n)
            cur_num *= 10;
        else
        {
            while(cur_num%10==9 || cur_num+1>n)
                cur_num /= 10;
            cur_num++;
        }
    }
    return result;
}

/*
    116. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximal-square/)
*/
public int maximalSquare(char[][] matrix) {
    int m=matrix.length, n=matrix[0].length, result = 0, popped_idx, width;
    int height[] = new int[n+1];
    Stack<Integer> stck;
    char cur_num;
    for(int i=0; i<m; i++)
    {
        stck = new Stack<>();
        for(int j=0;j<=n;j++)
        {
            cur_num = j==n?0:matrix[i][j];
            if(cur_num=='1')
                height[j]+=1;
            else
                height[j]=0;
            while(!stck.isEmpty() &&  height[j]<=height[stck.peek()])
            {
                popped_idx = stck.pop();
                width = j-1-(stck.isEmpty()?-1:stck.peek());
                result = Math.max(result, Math.min(height[popped_idx], width));
            }
            stck.push(j);
        }
    }
    return result*result; 
}

public int maximalSquare(char[][] matrix) {
    int m=matrix.length, n=matrix[0].length, result = 0;
    int dp_prev[] = new int[n], dp_cur[];
    char cur_num;
    for(int i=0; i<m; i++)
    {
        dp_cur = new int[n];
        dp_cur[0] = matrix[i][0]-'0';
        result = Math.max(result, dp_cur[0]);
        for(int j=1;j<n;j++)
        {
            cur_num = matrix[i][j];
            if(cur_num=='1')
            {
                dp_cur[j] = 1+Math.min(dp_cur[j-1], Math.min(dp_prev[j], dp_prev[j-1]));
                result = Math.max(result, dp_cur[j]);
            }
            else
                dp_cur[j] = 0;
        }
        dp_prev = dp_cur;
    }
    return result*result; 
}

/*
    117. PROBLEM DESCRIPTION (https://leetcode.com/problems/jewels-and-stones/)
*/
public int numJewelsInStones(String jewels, String stones) {
    HashSet<Character> jewelset = new HashSet<>();
    for(char x: jewels.toCharArray())
        jewelset.add(x);
    int result = 0;
    for(char x:stones.toCharArray())
    {
        if(jewelset.contains(x))
            result++;
    }
    return result;
}

/*
    118. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
*/
public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a,b)->(Integer.compare(a[0], b[0])));
    int cur_min_reach = points[0][1], result = 1;
    for(int[] p:points)
    {
        if(cur_min_reach<p[0])
        {
            cur_min_reach = p[1];
            result++;
        }
        else
            cur_min_reach = Math.min(cur_min_reach, p[1]);
    }
    return result;
}

/*
    119. PROBLEM DESCRIPTION (https://leetcode.com/problems/132-pattern/)
*/

public static void main(String args[])
{
    Scanner in = new Scanner(System.in);
    System.out.println("Entered Main");
}

}