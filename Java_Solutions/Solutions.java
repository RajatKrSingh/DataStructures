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

public static void main(String args[])
{
    Scanner in = new Scanner(System.in);
    System.out.println("Entered Main");
}

}