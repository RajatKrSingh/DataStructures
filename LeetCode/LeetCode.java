package LeetCode;
import sun.reflect.generics.tree.Tree;

import javax.lang.model.element.Element;
import java.util.stream.Collectors;
import java.util.*;

public class LeetCode {
/*
 1. PROBLEM DESCRIPTION (https://leetcode.com/problems/two-sum/)
    Given an array of integers, return indices of the two numbers such that they add up to a specific target. You may assume that each
    input would have exactly one solution, and you may not use the same element twice.

    EXAMPLE:
        Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

*/
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int complement = target-nums[i];
            if(map.containsKey(complement))
            {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return nums;
    }


/*
 2. PROBLEM DESCRIPTION (https://leetcode.com/problems/add-two-numbers/)
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    EXAMPLE:
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.

*/

    public void DisplayList(ListNode lnode)
    {
        while(lnode!=null)
        {
            System.out.println(lnode.val);
            lnode = lnode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode temp1=l1,temp2=l2;
        ListNode final_list = new ListNode(0),temp_final = final_list;
        int sum=0;
        while(temp1!=null || temp2!=null)
        {
            sum /= 10;
            if(temp1!=null)
            {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2!=null)
            {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            temp_final.next = new ListNode(sum%10);
            temp_final = temp_final.next;
        }
        if(sum/10==1)
            temp_final.next = new ListNode(1);
        return final_list.next;
    }

/*
 3. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-substring-without-repeating-characters/)
    Given a string, find the length of the longest substring without repeating characters.

    EXAMPLE 1:
        Input: "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

    EXAMPLE 2:
        Input: "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

    EXAMPLE 3:
        Input: "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.

    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/
    public int lengthOfLongestSubstring(String s) {

        int maximum=0,char_map[]= new int[256],j=0;
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            j = char_map[s.charAt(iterator_i)]>0? Math.max(char_map[s.charAt(iterator_i)],j):j;
            char_map[s.charAt(iterator_i)] = iterator_i+1;
            maximum = Math.max(maximum,iterator_i-j+1);
        }
        return maximum;
    }

/*
 4. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-integer/)
    Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:
        Input: 123
        Output: 321

    Example 2:
        Input: -123
        Output: -321

    Example 3:
        Input: 120
        Output: 21

    Note: Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
    public int reverse(int x) {

        int result = 0;
        while(x!=0)
        {
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && x%10 > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && x%10 < -8)) return 0;
            result =result*10 + x%10;
            x /= 10;
        }
        return result;
    }

/*
 5. PROBLEM DESCRIPTION (https://leetcode.com/problems/string-to-integer-atoi/)
    Implement atoi which converts a string to an integer. The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
    Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only
    whitespace characters, no conversion is performed.If no valid conversion could be performed, a zero value is returned.

    Note: Only the space character ' ' is considered as whitespace character.Assume we are dealing with an environment which could only store integers within the 32-bit signed
    integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

    Example 1:
        Input: "42"
        Output: 42

    Example 2:
        Input: "   -42"
        Output: -42
        Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.

    Example 3:
        Input: "4193 with words"
        Output: 4193
        Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

    Example 4:
        Input: "words and 987"
        Output: 0
        Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.

    Example 5:
        Input: "-91283472332"
        Output: -2147483648
        Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.Therefore INT_MIN (−231) is returned.
*/
    public int myAtoi(String str) {
        int i = 0,signflag=0;
        if(str.length()==0 || str==null)
            return 0;
        int result=0;
        while(i<str.length() && str.charAt(i)==' ') {
            i++;
        }
        if(i<str.length() &&((str.charAt(i)<='9' && str.charAt(i)>='0')||(str.charAt(i)=='+')||(str.charAt(i)=='-')))
        {
            if(str.charAt(i)=='-') {
                signflag = 1;
                i++;
            }
            else if(str.charAt(i)=='+')
                i++;
            while(i<str.length() &&(str.charAt(i)<='9'&& str.charAt(i)>='0'))
            {
                if (signflag == 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && ((int) (str.charAt(i) - '0')) % 10 > 7)))
                    return Integer.MAX_VALUE;
                if (signflag == 1 && ((0-result) < Integer.MIN_VALUE / 10 || ((0-result) == Integer.MIN_VALUE / 10 && ((0-(int) (str.charAt(i) - '0'))) % 10 < -8)))
                    return Integer.MIN_VALUE;
                result = result * 10 + (int) (str.charAt(i) - '0');
                i++;
                System.out.flush();
            }
            if(signflag==1)
                result = 0-result;
            return result;
        }
        else
            return 0;
    }

/*
 6. PROBLEM DESCRIPTION (https://leetcode.com/problems/palindrome-number/)
    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

    Example 1:
        Input: 121
        Output: true

    Example 2:
        Input: -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:
        Input: 10
        Output: false
        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/
    public boolean isPalindrome(int x) {

        if(x<0)
            return false;
        int cpy = x,res=0;
        while(cpy!=0)
        {
            res = res*10 + cpy%10;
            cpy = cpy/10;
        }
        if(res==x)
            return true;
        return false;
    }

/*
 7. PROBLEM DESCRIPTION (https://leetcode.com/problems/integer-to-roman/)
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven
    is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.

    Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:
        Input: 3
        Output: "III"

    Example 2:
        Input: 4
        Output: "IV"

    Example 3:
        Input: 9
        Output: "IX"

    Example 4:
        Input: 58
        Output: "LVIII"
        Explanation: L = 50, V = 5, III = 3.

    Example 5:
        Input: 1994
        Output: "MCMXCIV"
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
    public String intToRoman(int num) {

        String result ="";
        while(num!=0)
        {
            if(num>=1000)
            {
                num -= 1000;
                result += "M";
            }
            else if(num>=900)
            {
                num -= 900;
                result += "CM";
            }
            else if(num>=500)
            {
                num -= 500;
                result += "D";
            }
            else if(num>=400)
            {
                num -= 400;
                result += "CD";
            }
            else if(num>=100)
            {
                num -= 100;
                result += "C";
            }
            else if(num>=90)
            {
                num -= 90;
                result += "XC";
            }
            else if(num>=50)
            {
                num -= 50;
                result += "L";
            }
            else if(num>=40)
            {
                num -= 40;
                result += "XL";
            }
            else if(num>=10)
            {
                num -= 10;
                result += "X";
            }
            else if(num>=9)
            {
                num -= 9;
                result += "IX";
            }
            else if(num>=5)
            {
                num -= 5;
                result += "V";
            }
            else if(num>=4)
            {
                num -= 4;
                result += "IV";
            }
            else if(num>=1)
            {
                num -= 1;
                result += "I";
            }
        }
        return result;

    }

    public String intToRoman_opt(int num)
    {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

/*
 8. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-common-prefix/)
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:
        Input: ["flower","flow","flight"]
        Output: "fl"

    Example 2:
        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.
*/
    public String longestCommonPrefix(String[] strs) {

        String prefix="";
        if(strs==null || strs.length<1)
            return prefix;
        if(strs.length==1)
            return strs[0];
        for(int i=0;i<strs[0].length();i++)
        {
            for(int j=1;j< strs.length;j++)
            {
                if((i>=strs[j].length())||strs[j].charAt(i)!=strs[0].charAt(i))
                    return prefix;
            }
            prefix += strs[0].charAt(i);
        }
        return prefix;
    }

/*
 9. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-parentheses/)
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.

    Note that an empty string is also considered valid.

    Example 1:
        Input: "()"
        Output: true

    Example 2:
        Input: "()[]{}"
        Output: true

    Example 3:
        Input: "(]"
        Output: false

    Example 4:
        Input: "([)]"
        Output: false

    Example 5:
        Input: "{[]}"
        Output: true
*/
    public boolean isValid(String s) {

        int top=-1;
        char stack[] = new char[s.length()];

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[')
            {
                stack[++top] = s.charAt(i);
            }
            else
            {
                if(top<0)
                    return false;
                switch(s.charAt(i))
                {
                    case '}':
                        if(stack[top]!='{')
                            return false;
                        else
                            top--;
                        break;
                    case ')':
                        if(stack[top]!='(')
                            return false;
                        else
                            top--;
                        break;
                    case ']':
                        if(stack[top]!='[')
                            return false;
                        else
                            top--;
                        break;
                }
            }
        }
        if(top==-1)
            return true;
        return false;
    }

/*
10. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-two-sorted-lists/)
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

    Example:
        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4
*/

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode final_result = new ListNode(0),temp_result=final_result;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                temp_result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                temp_result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp_result = temp_result.next;
        }
        temp_result.next = l1==null?l2:l1;
        return final_result.next;
    }


/*
11. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:
        Given nums = [1,1,2],
        Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

    Example 2:
        Given nums = [0,0,1,1,1,2,2,3,3,4],
        Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

    Note: It doesn't matter what values are set beyond the returned length.
*/

    public int removeDuplicates(int[] nums) {
        int last_index=1,iterator_i=1;
        while(iterator_i<nums.length)
        {
            if(nums[iterator_i]!=nums[iterator_i-1])
                nums[last_index++] = nums[iterator_i];
            iterator_i++;
        }
        return last_index;
    }

/*
12. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-element/)
    Given an array nums and a value val, remove all instances of that value in-place and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory. The order of elements
    can be changed. It doesn't matter what you leave beyond the new length.

    Example 1:
        Given nums = [3,2,2,3], val = 3,
        Your function should return length = 2, with the first two elements of nums being 2.


    Example 2:
        Given nums = [0,1,2,2,3,0,4,2], val = 2,
        Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

    Note that the order of those five elements can be arbitrary.
    Note: It doesn't matter what values are set beyond the returned length.
*/
    public int removeElement(int[] nums, int val) {

        int last_index=-1,index=0;
        while(index<nums.length)
        {
            if(nums[index]!=val) {
                nums[++last_index] = nums[index];
            }
            index++;
        }
        return last_index;
    }

/*
13. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-and-say/)
    The count-and-say sequence is the sequence of integers with the first five terms as following:

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221

    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.

    Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

    Note: Each term of the sequence of integers will be represented as a string.

    Example 1:
        Input: 1
        Output: "1"

    Example 2:
        Input: 4
        Output: "1211"
*/

    public String countAndSay(int n) {
        String final_string="1";
        for(int iterator_i=1;iterator_i<n;iterator_i++)
        {
            int iterator_j=0;String iterator_string="";
            while(iterator_j<final_string.length())
            {
                int current__item_pos = iterator_j;
                while(iterator_j<final_string.length()-1 && final_string.charAt(iterator_j)==final_string.charAt(iterator_j+1))
                    iterator_j++;
                iterator_string += (char)(iterator_j++ -current__item_pos+49) + "" + final_string.charAt(current__item_pos);

            }
            final_string = iterator_string;
        }
        return final_string;
    }

/*
14. PROBLEM DESCRIPTION (https://leetcode.com/problems/search-insert-position/)
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:
        Input: [1,3,5,6], 5
        Output: 2

    Example 2:
        Input: [1,3,5,6], 2
        Output: 1

    Example 3:
        Input: [1,3,5,6], 7
        Output: 4

    Example 4:
        Input: [1,3,5,6], 0
        Output: 0
*/
    public int searchInsert(int[] nums, int target) {
        int lb=0,ub=nums.length-1,mid=0;
        if(nums.length==1 && nums[0]<target)
            return 1;
        else if(nums.length==1)
            return 0;
        while(lb<ub)
        {
            mid = (int)Math.ceil((lb+ub)/2.0);
            if(nums[mid-1]<target && nums[mid]>=target)
                return mid;
            else if(nums[mid-1]<target)
                lb = mid+1;
            else
                ub = mid-1;
            System.out.println(lb+" "+ub);
        }
        if(ub==0)
            return 0;
        System.out.println(lb+" "+ub);
        if((lb==ub)&&nums[lb]>=target)
            return lb;


        return ub+1;


    }

/*
    15. PROBLEM DESCRIPTION (https://leetcode.com/problems/plus-one/)
        Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

        The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
        You may assume the integer does not contain any leading zero, except the number 0 itself.

        Example 1:
            Input: [1,2,3]
            Output: [1,2,4]
            Explanation: The array represents the integer 123.

        Example 2:
            Input: [4,3,2,1]
            Output: [4,3,2,2]
            Explanation: The array represents the integer 4321.
*/
    public int[] plusOne(int[] digits) {

        int index=digits.length-1;
        while(index>=0)
        {
            if(digits[index]<9) {
                digits[index]++;
                return digits;
            }
            digits[index]=0;
            index--;
        }
        int copy_arr[] = new int[digits.length+1];
        copy_arr[0] = 1;
        return copy_arr;

    }



/*
    16. PROBLEM DESCRIPTION (https://leetcode.com/problems/sqrtx/)
    Implement int sqrt(int x).
    Compute and return the square root of x, where x is guaranteed to be a non-negative integer. Since the return type is an integer, the decimal digits are
    truncated and only the integer part of the result is returned.

    Example 1:
        Input: 4
        Output: 2

    Example 2:
        Input: 8
        Output: 2
        Explanation: The square root of 8 is 2.82842..., and since
            the decimal part is truncated, 2 is returned.
*/

    public int mySqrt(int x) {
        if(x==1 || x==2 )
            return 1;
        int lb = 1,ub = x;
        while(lb<=ub)
        {
            int mid = (int)((lb+ub)/2);
            if(mid>1.0*x/mid)
                ub = mid-1;
            else if((mid<=x/mid && (mid+1)>x/(mid+1)))
                return (int)mid;
            else lb = mid+1;
        }
        return 0;
    }


/*
    17. PROBLEM DESCRIPTION (https://leetcode.com/problems/length-of-last-word/)
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    Example:
        Input: "Hello World"
        Output: 5
*/

    public int lengthOfLastWord(String s) {
        int iterator_i=s.length()-1;
        while(iterator_i>0)
        {
            while(iterator_i>=0 && s.charAt(iterator_i)==' ')
                iterator_i--;
            int curr_last=iterator_i;
            while(iterator_i>=0 && s.charAt(iterator_i)!=' ')
                iterator_i--;
            return curr_last-iterator_i>0? curr_last-iterator_i+(iterator_i<0?1:0):0;
        }
        return 0;
    }

/*
18. PROBLEM DESCRIPTION (https://leetcode.com/problems/add-binary/)
    Given two binary strings, return their sum (also a binary string).
    The input strings are both non-empty and contains only characters 1 or 0.

    Example 1:
        Input: a = "11", b = "1"
        Output: "100"

    Example 2:
        Input: a = "1010", b = "1011"
        Output: "10101"
*/

    public String addBinary(String a, String b) {
        int a_len = a.length()-1,b_len = b.length()-1,curr_sum=0;
        String final_sum="";
        while(a_len>=0 || b_len>=0)
        {
            if(a_len>=0)
            {
                curr_sum += ((int)a.charAt(a_len))-48;
                a_len--;
            }
            if(b_len>=0)
            {
                curr_sum += ((int)b.charAt(b_len))-48;
                b_len--;
            }
            final_sum = curr_sum%2 + final_sum;
            curr_sum = curr_sum>1?1:0;
        }
        if(curr_sum==1)
            return "1"+final_sum;
        return  final_sum;
    }

/*
19. PROBLEM DESCRIPTION (https://leetcode.com/problems/climbing-stairs/)
    You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Note: Given n will be a positive integer.

    Example 1:
        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
            1. 1 step + 1 step
            2. 2 steps

    Example 2:
        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
            1. 1 step + 1 step + 1 step
            2. 1 step + 2 steps
            3. 2 steps + 1 step
*/
    public int climbStairs(int n) {

        int ways[] = new int[n+1];
        ways[0] = 1;
        ways[1] = 2;
        for(int i=2;i<n;i++)
        {
            ways[i] = ways[i-1]+ways[i-2];
        }
        return ways[n-1];
    }

/*
20. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-sorted-array/)
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    Note: The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough space (size that is greater or equal
    to m + n) to hold additional elements from nums2.

    Example:
    Input:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]
*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int iterator_i=m-1,iterator_j=n-1;
        while(iterator_i>=0 || iterator_j>=0)
        {
            if(iterator_i<0 ? false : ( iterator_j<0? true : nums1[iterator_i]>nums2[iterator_j]))
                nums1[iterator_i+iterator_j+1] = nums1[iterator_i--];
            else
                nums1[iterator_i+iterator_j+1] = nums2[iterator_j--];
        }
    }

/*
21. PROBLEM DESCRIPTION (https://leetcode.com/problems/single-number/)
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:
        Input: [2,2,1]
        Output: 1

    Example 2:
        Input: [4,1,2,1,2]
        Output: 4
*/
    public int singleNumber(int[] nums) {

        int result = 0;
        for(int i=0;i<nums.length;i++)
            result = result ^ nums[i];
        return result;
    }


/*
22. PROBLEM DESCRIPTION (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
    Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

    Note that you cannot sell a stock before you buy one.

    Example 1:
        Input: [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

    Example 2:
        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/
    public int maxProfit(int[] prices) {

        int max_profit = 0, min_till_now = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            min_till_now = Math.min(min_till_now,prices[i]);
            max_profit = Math.max(max_profit,prices[i] - min_till_now);
        }
        return max_profit;
    }


/*
23. PROBLEM DESCRIPTION (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

    Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

    Example 1:
        Input: [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

    Example 2:
        Input: [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

    Example 3:
        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/
    public int maxProfit1(int[] prices) {

        int max_profit = 0;
        for(int i=0;i<prices.length-1;i++)
                max_profit = prices[i+1]<prices[i]? max_profit : max_profit+prices[i+1] - prices[i];
        return max_profit;
    }


/*
    24. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-palindrome/)
        Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

        Note: For the purpose of this problem, we define empty string as valid palindrome.

        Example 1:
            Input: "A man, a plan, a canal: Panama"
            Output: true

        Example 2:
            Input: "race a car"
            Output: false
*/
    public boolean isPalindrome(String s) {
        int start_index=0,end_index=s.length()-1;
        while(start_index<end_index)
        {
            if(Character.isLetterOrDigit(s.charAt(start_index)) && Character.isLetterOrDigit(s.charAt(end_index)))
                if(Character.toUpperCase(s.charAt(start_index++)) != Character.toUpperCase(s.charAt(end_index--)))
                    return false;
            if(!Character.isLetterOrDigit(s.charAt(start_index)))
                start_index++;
            if(!Character.isLetterOrDigit(s.charAt(end_index)))
                end_index--;
        }
        return true;
    }


/*
    25. PROBLEM DESCRIPTION (https://leetcode.com/problems/implement-strstr/)
        Implement strStr().
        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

        Example 1:
            Input: haystack = "hello", needle = "ll"
            Output: 2

        Example 2:
            Input: haystack = "aaaaa", needle = "bba"
            Output: -1

*/

    public int strStr(String haystack, String needle) {
        for(int iterator_i=0;;iterator_i++)
        {
            for(int iterator_j=0;;iterator_j++)
            {
                if(iterator_j==needle.length())
                    return iterator_i;
                if(iterator_i+iterator_j==haystack.length())
                    return -1;
                if(needle.charAt(iterator_j)!=haystack.charAt(iterator_i+iterator_j))
                    break;
            }
        }
    }

    public static int strStr1(String haystack,String needle)
    {
        if(needle.length()==0)
            return 0;
        //Create shift table
        int shift_table[] = new int[256];
        for(int iterator_i=0;iterator_i<shift_table.length;iterator_i++)
            shift_table[iterator_i] = needle.length();
        for(int iterator_i=0;iterator_i<needle.length()-1;iterator_i++)
            shift_table[needle.charAt(iterator_i)] = needle.length()-1-iterator_i;

        // Create Bad Symbol Table
        int bad_symbol[] = new int[needle.length()-1];
        for(int iterator_i=0;iterator_i<bad_symbol.length;iterator_i++)
            bad_symbol[iterator_i] = needle.length();
        for(int iterator_i=0;iterator_i<bad_symbol.length;iterator_i++)
        {
            int iterator_j=needle.length()-2-iterator_i + ((iterator_i==0)?0:1),iterator_k=needle.length()-1;
            while(iterator_j>=0 && iterator_k>=needle.length()-1-iterator_i)
            {
                if(needle.charAt(iterator_j)==needle.charAt(iterator_k))
                    iterator_k--;
                else
                    iterator_k = needle.length()-1;
                iterator_j--;
            }
            if(iterator_j<0 || iterator_k<needle.length()-1-iterator_i)
                bad_symbol[iterator_i] = iterator_k-iterator_j;
        }

        for(int iterator_i=0;iterator_i<bad_symbol.length;iterator_i++)
            System.out.print(bad_symbol[iterator_i]+" ");
        System.out.println();
        // Perform actual String Matching
        int iterator_i = needle.length()-1;
        while(iterator_i<haystack.length())
        {
            int iterator_j = 0;
            while(iterator_j<needle.length() && needle.charAt(needle.length()-1-iterator_j)==haystack.charAt(iterator_i-iterator_j))
                iterator_j++;
            if(iterator_j==needle.length())
                return iterator_i-iterator_j+1;

            if(iterator_j==0)
            {
                iterator_i += shift_table[haystack.charAt(iterator_i)];
                System.out.println(iterator_i + " " + iterator_j + " ");
            }
            else {
                iterator_i += Math.max(shift_table[haystack.charAt(iterator_i - iterator_j )]-iterator_j, bad_symbol[iterator_j - 1]);
                System.out.println(iterator_i + " " + iterator_j + " " + shift_table[haystack.charAt(iterator_i - iterator_j )]);
            }
        }
        return -1;
    }

    /*
    26. PROBLEM DESCRIPTION (https://leetcode.com/problems/permutations/)
        Given a collection of distinct integers, return all possible permutations.

        Example:

        Input: [1,2,3]
        Output:
        [
            [1,2,3],
            [1,3,2],
            [2,1,3],
            [2,3,1],
            [3,1,2],
            [3,2,1]
        ]
    */
    public int[]  create_array_int(Scanner sc) {
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int created_arr[] = new int[n];
        System.out.println("Enter elements");
        for (int iterator_i = 0; iterator_i < n; iterator_i++)
            created_arr[iterator_i] = sc.nextInt();
        return created_arr;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all_permutations = new ArrayList<List<Integer>>();
        permute_backtrack(nums,all_permutations,new ArrayList<>());
        return all_permutations;
    }

    public static void permute_backtrack(int nums[],List<List<Integer>> all_permutations,List<Integer> curr_perm)
    {
        if(curr_perm.size()==nums.length)
            all_permutations.add(new ArrayList<>(curr_perm));
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(curr_perm.contains(nums[iterator_i])) continue;
            curr_perm.add(nums[iterator_i]);
            permute_backtrack(nums,all_permutations,curr_perm);
            System.out.println(iterator_i);
            curr_perm.remove(curr_perm.size()-1);

        }
    }

    /*
    27. PROBLEM DESCRIPTION (https://leetcode.com/problems/permutations-ii/)
        Given a collection of numbers that might contain duplicates, return all possible unique permutations.

        Example:

        Input: [1,1,2]
        Output:
        [
            [1,1,2],
            [1,2,1],
            [2,1,1]
        ]
    */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        permuteUniqueBacktrack(nums,new boolean[nums.length],new ArrayList<Integer>(),list);
        return list;
    }

    public boolean isPermuteReached(boolean[] position_visited_flag)
    {
        for(boolean value: position_visited_flag){
            if(!value){ return false;}
        }
        return true;
    }

    public void permuteUniqueBacktrack(int[] nums,boolean[] position_visited_flag,List curr_perm,List<List<Integer>> list)
    {
        if(isPermuteReached(position_visited_flag))
        {
            list.add(new ArrayList<>(curr_perm));
            return;
        }
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(position_visited_flag[iterator_i]==true || (iterator_i>0 && nums[iterator_i-1]==nums[iterator_i] && !position_visited_flag[iterator_i-1]))
                continue;
            position_visited_flag[iterator_i]=true;
            curr_perm.add(nums[iterator_i]);
            permuteUniqueBacktrack(nums,position_visited_flag,curr_perm,list);
            curr_perm.remove(curr_perm.size()-1);
            position_visited_flag[iterator_i] = false;
        }
    }

    /*
    28. PROBLEM DESCRIPTION (https://leetcode.com/problems/multiply-strings/)
        Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

        Example 1:
        Input: num1 = "2", num2 = "3"
        Output: "6"

        Example 2:
        Input: num1 = "123", num2 = "456"
        Output: "56088"
    */

    public String multiply(String num1, String num2)
    {
        int final_product[] = new int[num1.length()+num2.length()],carry=0;
        String product_str="";
        for(int iterator_i=num1.length()-1;iterator_i>=0;iterator_i--)
        {
            for (int iterator_j = num2.length() - 1; iterator_j >= 0; iterator_j--)
            {
                int temp=carry;
                carry = (temp + final_product[num1.length() + num2.length() - 2 - iterator_i - iterator_j] + (int) (num1.charAt(iterator_i) - 48) * (int) (num2.charAt(iterator_j) - 48)) / 10;
                final_product[num1.length() + num2.length() - 2 - iterator_i - iterator_j] = (temp + final_product[num1.length() + num2.length() - 2 - iterator_i - iterator_j] + (int) (num1.charAt(iterator_i) - 48) * (int) (num2.charAt(iterator_j) - 48)) % 10;
            }
            final_product[num2.length()+num1.length()-1-iterator_i] += carry;
            carry=0;
        }
        int last_pos=final_product.length-1;
        while(last_pos>0 && final_product[last_pos]==0)
            last_pos--;
        for(int digits:Arrays.copyOfRange(final_product,0,last_pos+1))
            product_str = digits+product_str;
        return carry>0?carry+product_str:product_str;
    }

    /*
    28. PROBLEM DESCRIPTION (http://leetcode.com/problems/generate-parentheses/)
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

        For example, given n = 3, a solution set is:
        [
          "((()))",
          "(()())",
          "(())()",
          "()(())",
          "()()()"
        ]
    */

    public List<String> generateParenthesis(int n)
    {
        List<String> list = new ArrayList<String>();
        generateParenthesisBacktrack(list,0,"",n*2);
        return list;
    }

    public void generateParenthesisBacktrack(List<String> list,int bracket_count,String current_string,int n)
    {
        if(current_string.length()==n)
        {
            if(bracket_count==0)
                list.add(current_string);
            return;
        }
        if(bracket_count>0)
            generateParenthesisBacktrack(list,bracket_count-1,new String(current_string+")"),n);
        if(bracket_count<n/2)
            generateParenthesisBacktrack(list,bracket_count+1,new String(current_string+"("),n);
    }

    /*
    30. PROBLEM DESCRIPTION (https://leetcode.com/problems/combination-sum/)

        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
        The same repeated number may be chosen from candidates unlimited number of times.

        Note:
        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.

        Example 1:
        Input: candidates = [2,3,6,7], target = 7,
        A solution set is:
        [
            [7],
            [2,2,3]
        ]
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumBacktrack(list,target,new ArrayList<Integer>(),0,candidates,0);
        return list;
    }

    public static void combinationSumBacktrack(List<List<Integer>> list,int target,List current_items,int current_sum,int[] candidates,int current_item)
    {
        for(int iterator_i=current_item;iterator_i<candidates.length;iterator_i++)
        {
            if(current_sum+candidates[iterator_i]==target)
            {
                current_items.add(candidates[iterator_i]);
                list.add(new ArrayList<>(current_items));
                current_items.remove(current_items.size()-1);
                return;
            }
            if(current_sum+candidates[iterator_i]<target)
            {
                current_items.add(candidates[iterator_i]);
                combinationSumBacktrack(list, target,current_items , current_sum+candidates[iterator_i], candidates, iterator_i);
                current_items.remove(current_items.size()-1);
            }
            else
                return;
        }
    }

    /*
    31. PROBLEM DESCRIPTION (https://leetcode.com/problems/combination-sum-ii/)
        Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
        Each number in candidates may only be used once in the combination.

        Note:
        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.

        Example 1:
        Input: candidates = [10,1,2,7,6,1,5], target = 8,
        A solution set is:
        [
            [1, 7],
            [1, 2, 5],
            [2, 6],
            [1, 1, 6]
        ]
    */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumBacktrack2(list,target,new ArrayList<Integer>(),0,candidates,-1);
        return list;
    }

    public static void combinationSumBacktrack2(List<List<Integer>> list,int target,List current_items,int current_sum,int[] candidates,int current_item)
    {
        System.out.print("pos:"+current_item+":"+current_sum+" ");
        for(Object e:current_items)
            System.out.print(e.toString()+" ");
        System.out.println();
        for(int iterator_i=current_item+1;iterator_i<candidates.length;iterator_i++)
        {
            if(current_sum+candidates[iterator_i]==target)
            {
                current_items.add(candidates[iterator_i]);
                for(Object e:current_items)
                    System.out.print(e.toString()+" ");
                System.out.println();
                list.add(new ArrayList<>(current_items));
                current_items.remove(current_items.size()-1);
                return;
            }
            if(current_sum+candidates[iterator_i]<target)
            {
                if((iterator_i==current_item+1)||(candidates[iterator_i]!=candidates[iterator_i-1])) {
                    current_items.add(candidates[iterator_i]);
                    combinationSumBacktrack2(list, target, current_items, current_sum + candidates[iterator_i], candidates, iterator_i);
                    current_items.remove(current_items.size() - 1);
                }
            }
            else
                return;
        }
    }

    /*
    32. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-sudoku/)
        Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    */

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hset = new HashSet<>();
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
            {
                if(board[iterator_i][iterator_j]!='.')
                {
                    if(!hset.add(iterator_i+"-"+board[iterator_i][iterator_j]) ||!hset.add("-"+board[iterator_i][iterator_j]+""+iterator_j)||!hset.add(iterator_i/3+"-"+board[iterator_i][iterator_j]+""+iterator_j/3))
                        return false;
                }
            }
        }
        return true;
    }

    /*
    33. PROBLEM DESCRIPTION (https://leetcode.com/problems/sudoku-solver/)
        Write a program to solve a Sudoku puzzle by filling the empty cells.

        A sudoku solution must satisfy all of the following rules:

        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
        Empty cells are indicated by the character '.'.
    */

    public void solveSudoku(char[][] board) {
        solveSudokuBacktrack(board,0,0);
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
                System.out.print(board[iterator_i][iterator_j]+" ");
            System.out.println();
        }
    }

    public static boolean isSudokuValid(char[][] board,int row_current,int column_current,char value)
    {
        //Column Elements Check
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
            if(board[iterator_i][column_current]==value)
                return false;

        //Row Elements Check
        for(int iterator_i=0;iterator_i<board[0].length;iterator_i++)
            if(board[row_current][iterator_i]==value)
                return false;

        //Subsection check
        for(int iterator_i=3*(row_current/3);iterator_i<3*(row_current/3) + 3;iterator_i++)
        {
            for(int iterator_j=3*(column_current/3);iterator_j<3*(column_current/3)+3;iterator_j++)
                if(board[iterator_i][iterator_j]==value)
                    return false;
        }
        return true;
    }

    public static boolean solveSudokuBacktrack(char[][] board,int row_current,int column_current)
    {
        //System.out.println(row_current+""+column_current+" "+((board[0].length)-1));
        if(board[row_current][column_current]!='.')
        {
            if(row_current==board.length-1 && column_current==board[0].length-1)
                return true;
            if(solveSudokuBacktrack(board,column_current==board[0].length-1? row_current+1:row_current,column_current==board[0].length-1?0:column_current+1))
                return true;
        }
        else
        {
            for (char iterator_i = '1'; iterator_i <= '9'; iterator_i++) {
                if (isSudokuValid(board, row_current, column_current, iterator_i)) {
                    board[row_current][column_current] = iterator_i;
                    if (row_current == board.length - 1 && column_current == board[0].length - 1)
                        return true;
                    if (solveSudokuBacktrack(board, column_current == board[0].length - 1 ? row_current + 1 : row_current, column_current == board[0].length - 1 ? 0 : column_current + 1))
                        return true;
                    board[row_current][column_current] = '.';
                }
            }
        }
        return false;
    }

    /*
    34. PROBLEM DESCRIPTION (https://leetcode.com/problems/3sum/)
        Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
        Note:
            The solution set must not contain duplicate triplets.

        Example:
        Given array nums = [-1, 0, 1, 2, -1, -4],
        A solution set is:
        [
            [-1, 0, 1],
            [-1, -1, 2]
        ]
    */



    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int iterator_i=0;
        while(iterator_i<nums.length-2)
        {
            if(iterator_i==0 || nums[iterator_i]!=nums[iterator_i-1])
            {
                int l_pos = iterator_i + 1, r_pos = nums.length - 1;
                while (l_pos < r_pos)
                {
                    if ((l_pos != iterator_i + 1 && nums[l_pos] == nums[l_pos - 1])||(nums[iterator_i] + nums[l_pos] + nums[r_pos] < 0))
                        l_pos++;
                    else if ((r_pos != nums.length - 1 && nums[r_pos] == nums[r_pos + 1])||(nums[iterator_i] + nums[l_pos] + nums[r_pos] > 0))
                        r_pos--;
                    else {
                        list.add(Arrays.asList(nums[iterator_i], nums[l_pos], nums[r_pos]));
                        l_pos++;
                        r_pos--;
                    }
                }
            }
            iterator_i++;
        }
        return list;
    }

    /*
    34. PROBLEM DESCRIPTION (https://leetcode.com/problems/3sum-closest/)
        Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

        Example:
        Given array nums = [-1, 2, 1, -4], and target = 1.
        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    */

    public int threeSumClosest(int[] nums, int target) {
        int min_diff = Integer.MAX_VALUE,iterator_i=0;
        while(iterator_i<nums.length-2)
        {
            int l_pos=iterator_i+1,r_pos=nums.length-1;
            while(l_pos<r_pos)
            {
                System.out.println(l_pos+" "+r_pos);
                if(Math.abs(nums[iterator_i]+nums[l_pos]+nums[r_pos]-target)<Math.abs(min_diff))
                    min_diff = nums[iterator_i]+nums[l_pos]+nums[r_pos]-target;
                if(nums[iterator_i]+nums[l_pos]+nums[r_pos]-target<0)
                    l_pos++;
                else
                    r_pos--;
            }
            iterator_i++;
        }
        return min_diff+target;
    }

    /*
    35. PROBLEM DESCRIPTION (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

        Input: "23"
        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    */

    public List<String> letterCombinations(String digits)
    {
        List<String> list= new ArrayList<String>();
        String vocabulary[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinationsBacktrack(list,digits,0,vocabulary,new StringBuilder());
        return list;
    }

    public static void letterCombinationsBacktrack(List<String> list,String digits,int position,String[] vocabulary,StringBuilder curr_elements)
    {
        if(position==digits.length())
        {
            if(curr_elements.toString().length()>0)
                list.add(curr_elements.toString());
            return;
        }
        for(int iterator_i=0;iterator_i<vocabulary[digits.charAt(position)-50].length();iterator_i++)
        {
            curr_elements.append(vocabulary[digits.charAt(position)-50].charAt(iterator_i));
            letterCombinationsBacktrack(list,digits,position+1,vocabulary,curr_elements);
            curr_elements.deleteCharAt(curr_elements.length()-1);
        }
    }

    /*
    36. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-valid-parentheses/)
        Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

        Example 1:
        Input: "(()"
        Output: 2
        Explanation: The longest valid parentheses substring is "()"
        Space not optimized
    */

    public int longestValidParentheses(String s)
    {
        if(s.length()==0)
            return 0;
        int max_valid[]=new int[s.length()];
        for(int iterator_i=1;iterator_i<s.length();iterator_i++)
        {
            if(s.charAt(iterator_i) == ')' && s.charAt(iterator_i-1)=='(')
                max_valid[iterator_i] = iterator_i<2?2:Math.max(max_valid[iterator_i], max_valid[iterator_i - 2] + 2);
            else if(s.charAt(iterator_i) == ')' && s.charAt(iterator_i-1)==')' && iterator_i -1-max_valid[iterator_i-1]>=0 && s.charAt(iterator_i -1-max_valid[iterator_i-1])=='(')
                max_valid[iterator_i] = Math.max(max_valid[iterator_i], max_valid[iterator_i-1]+2+((iterator_i -1-max_valid[iterator_i-1]>0)?max_valid[iterator_i -2-max_valid[iterator_i-1]]:0));
        }
        Arrays.sort(max_valid);
        return max_valid[max_valid.length-1];
    }

    /*
    37. PROBLEM DESCRIPTION (https://leetcode.com/problems/decode-ways/)
        A message containing letters from A-Z is being encoded to numbers using the following mapping:

        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
        Given a non-empty string containing only digits, determine the total number of ways to decode it.
    */
    public int numDecodings(String s)
    {
        if(s.length()==0)
            return 0;
        int num_decodings[] = new int[s.length()+1];
        num_decodings[0] = 1;
        num_decodings[1] = s.charAt(0)=='0'?0:1;
        for(int iterator_i=2;iterator_i<num_decodings.length;iterator_i++)
        {
            if(s.charAt(iterator_i-1)!='0')
                num_decodings[iterator_i] = num_decodings[iterator_i-1];
            if(s.charAt(iterator_i-2)<'3' && (s.charAt(iterator_i-2)=='2'?s.charAt(iterator_i-1)<'7':true) && s.charAt(iterator_i-2)!='0')
                num_decodings[iterator_i] += num_decodings[iterator_i-2];
        }
        return num_decodings[num_decodings.length-1];
    }

    /*
    38. PROBLEM DESCRIPTION (https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/)
        Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.

        In case of a tie, return the minimum such integer.
        Notice that the answer is not neccesarilly a number from arr.

        Example 1:

            Input: arr = [4,9,3], target = 10
            Output: 3
            Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
    */

    public static int findClosestposition(int[] arr,int value)
    {
        int lb=0,ub=arr.length-1,mid=0;
        while(lb<=ub)
        {
            mid = (lb+ub)/2;
            if(arr[mid]==value ||( mid>0 && arr[mid]>value && arr[mid-1]<value)||(mid==0 && arr[mid]>value))
                return mid;
            else if(arr[mid]<value)
                lb = mid+1;
            else
                ub = mid-1;
        }
        return mid;
    }

    public int findBestValue(int[] arr, int target)
    {
        Arrays.sort(arr);
        int lb = arr[0],ub=arr[arr.length-1],sum_arr[] = new int[arr.length+1],current_closest_val=Integer.MAX_VALUE,current_best_value=-1;
        for(int iterator_i=1;iterator_i<=arr.length;iterator_i++)
            sum_arr[iterator_i] = sum_arr[iterator_i-1]+arr[iterator_i-1];
        if(target<arr[0]*arr.length)
            return (int)(Math.round(1.0*target/arr.length));
        while(lb<=ub)
        {
            int mid = (lb+ub)/2,pos_mid = findClosestposition(arr,mid);
            if(current_closest_val==Integer.MAX_VALUE || Math.abs(sum_arr[pos_mid]+(arr.length-pos_mid)*mid-target)<Math.abs(current_closest_val)|| mid<current_best_value && Math.abs(sum_arr[pos_mid]+(arr.length-pos_mid)*mid-target)==Math.abs(current_closest_val))
            {
                current_closest_val = sum_arr[pos_mid]+(arr.length-pos_mid)*mid-target;
                current_best_value = mid;
            }
            if(sum_arr[pos_mid]+(arr.length-pos_mid)*mid-target<0)
                lb = mid+1;
            else if(sum_arr[pos_mid]+(arr.length-pos_mid)*mid-target>0)
                ub = mid-1;
            else
                return current_best_value;
        }
        return current_best_value;
    }

    /*
    39. PROBLEM DESCRIPTION (https://leetcode.com/problems/happy-number/)
        A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

        Example:
        Input: 19
        Output: true
        Explanation:
            1^2 + 9^2 = 82
            8^2 + 2^2 = 68
            6^2 + 8^2 = 100
            1^2 + 0^2 + 0^2 = 1
    */

    public boolean isHappy(int n) {
        HashSet<String> hset = new HashSet<>();
        int new_number=0;
        while(true)
        {
            char curr_temp[] = new char[1];
            int sum=0;
            while(n!=0)
            {
                curr_temp[curr_temp.length-1] = (char)(n%10+48);
                sum += n%10;
                curr_temp = Arrays.copyOf(curr_temp,curr_temp.length+1);
                new_number += Math.pow((n%10),2);
                n /= 10;
            }
            if(sum==1)
                return true;
            n = new_number;
            new_number=0;
            Arrays.sort(curr_temp);
            if(!hset.add(new String(curr_temp)))
                return false;
            System.out.println(n+":"+sum);
        }
    }

    /*
    40. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-inorder-traversal/)
        Given a binary tree, return the inorder traversal of its nodes' values.

        Example:
        Input: [1,null,2,3]
          1
           \
            2
           /
          3

        Output: [1,3,2]
    */

    public static TreeNode create_binary_tree(TreeNode input_treenode, Scanner sc)
    {
        System.out.println("Enter value");
        int val = sc.nextInt();
        if(val==-1)
            return input_treenode;
        input_treenode = new TreeNode(val);
        System.out.println("Left Node of "+val);
        input_treenode.left =  create_binary_tree(input_treenode.left,sc);
        System.out.println("Right node of "+val);
        input_treenode.right = create_binary_tree(input_treenode.right,sc);
        return input_treenode;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack node_stack = new Stack();
        List<Integer> list = new ArrayList<>();
        TreeNode current_node = root;
        while(!node_stack.empty() || current_node!=null)
        {
            while(current_node!=null)
            {
                node_stack.push(current_node);
                current_node = current_node.left;
            }
            while(current_node==null && !node_stack.empty())
            {
                list.add(((TreeNode) (node_stack.peek())).val);
                System.out.print(((TreeNode) (node_stack.peek())).val+" ");
                current_node = ((TreeNode) (node_stack.pop())).right;
            }
        }
        return list;
    }

    /*
    41. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-inorder-traversal/)
        Given the root of a binary tree, each node in the tree has a distinct value.

        After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
        Return the roots of the trees in the remaining forest.  You may return the result in any order.
    */

    public static boolean isForDeletion(int val,int[] del_arr)
    {
        for(int del_val:del_arr)
            if(del_val==val)
                return true;
        return false;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        delNodesHelper(root,to_delete,list,true);
        return list;
    }

    public static TreeNode delNodesHelper(TreeNode node,int[] to_delete,List<TreeNode> list,boolean is_root)
    {
        if(node==null)
            return null;
        if(is_root && !isForDeletion(node.val,to_delete))
            list.add(node);
        node.left = delNodesHelper(node.left,to_delete,list,isForDeletion(node.val,to_delete));
        node.right = delNodesHelper(node.right,to_delete,list,isForDeletion(node.val,to_delete));
        return isForDeletion(node.val,to_delete)?null:node;
    }

    /*
    42. PROBLEM DESCRIPTION (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
        Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
        lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null || root==p || root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        if(left==null && right==null)
            return null;
        return left==null?right:left;
    }

    public TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q)
    {
        Stack bfs_stack = new Stack();
        Map<TreeNode,TreeNode> parents_edges = new HashMap<TreeNode, TreeNode>();
        TreeNode current_node = root;
        bfs_stack.push(current_node);
        parents_edges.put(current_node,null);
        while(!parents_edges.containsKey(p) || !parents_edges.containsKey(q))
        {
            current_node = (TreeNode) bfs_stack.pop();
            if(current_node.left!=null)
            {
                bfs_stack.push(current_node.left);
                parents_edges.put(current_node.left,current_node);;
            }
            if(current_node.right!=null)
            {
                parents_edges.put(current_node.right,current_node);
                bfs_stack.push(current_node.right);
            }
        }
        HashSet<TreeNode> ancestor_path = new HashSet<>();
        ancestor_path.add(p);
        while(p!=null &&parents_edges.containsKey(p))
        {
            p = parents_edges.get(p);
            ancestor_path.add(p);
        }
        while(!ancestor_path.contains(q))
            q = parents_edges.get(q);

        return q;
    }

    /*
    43. PROBLEM DESCRIPTION (https://leetcode.com/problems/subarray-sum-equals-k/)
        Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

        Example 1:
        Input:nums = [1,1,1], k = 2
        Output: 2
    */

    public int subarraySum_alt(int[] nums, int k) //DP approach
    {
        int dp_arr[][] = new int[2][nums.length],count=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            dp_arr[0][iterator_i] = nums[iterator_i];
            if(nums[iterator_i]==k)
                count++;
        }
        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            for(int iterator_j=iterator_i;iterator_j<nums.length;iterator_j++)
            {
                if(dp_arr[0][iterator_j-1]+nums[iterator_j]==k)
                    count++;
                dp_arr[1][iterator_j] = dp_arr[0][iterator_j-1]+nums[iterator_j];
            }
            dp_arr[0] = dp_arr[1].clone();
        }
        return count;
    }
    public int subarraySum(int[] nums, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0,count=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            sum += nums[iterator_i];
            count += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0) +1);
        }
        return count;
    }

    /*
    44. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-subarray/)
        Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

        Example:
        Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
    */

    public int maxSubArray(int[] nums)
    {
        int current_sum = Integer.MIN_VALUE,max_till_now = Integer.MIN_VALUE;
        for(int curr_num: nums)
        {
            current_sum = (current_sum==Integer.MIN_VALUE || curr_num+current_sum<curr_num)?curr_num:current_sum+curr_num;
            max_till_now =Math.max(max_till_now,current_sum);
        }
        return max_till_now;
    }

    /*
    45. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-palindromic-substring/solution/)
        Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

        Example 1:
        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
    */

    public String longestPalindrome_alt(String s) // O(n^2) time and space
    {
        if(s.length()==0)
            return "";
        int dp_arr[][] = new int[s.length()][s.length()];
        String max_palindrome=""+s.charAt(0);
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
            dp_arr[0][iterator_i] = 1;

        for(int iterator_i=1;iterator_i<s.length();iterator_i++)
        {
            for(int iterator_j=iterator_i;iterator_j<s.length();iterator_j++)
            {
                dp_arr[iterator_i][iterator_j] = ( (iterator_i>1?dp_arr[iterator_i-2][iterator_j-1] == 1:true) && s.charAt(iterator_j)==s.charAt(iterator_j-iterator_i))?1:0;
                if(dp_arr[iterator_i][iterator_j]==1)
                    max_palindrome = s.substring(iterator_j-iterator_i ,iterator_j+1);
            }
        }
        return max_palindrome;
    }

    public String longestPalindrome(String s) // O(n^2) time  O(1)space
    {
        String max_palindrome = "";
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            String curr_pal = expandFromCenterPalindrome(s,iterator_i,iterator_i);
            if(curr_pal.length()>max_palindrome.length())
                max_palindrome = curr_pal;
            if(iterator_i>0 && s.charAt(iterator_i-1)==s.charAt(iterator_i))
            {
                curr_pal = expandFromCenterPalindrome(s,iterator_i-1,iterator_i);
                if(curr_pal.length()>max_palindrome.length())
                    max_palindrome = curr_pal;
            }
        }
        return max_palindrome;
    }

    public static String expandFromCenterPalindrome(String s, int left,int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    /*
    46. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
        Given a linked list, remove the n-th node from the end of list and return its head.

        Example:
        Given linked list: 1->2->3->4->5, and n = 2.
        After removing the second node from the end, the linked list becomes 1->2->3->5.
    */

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode slow_ptr=head,fast_ptr=head,prev_ptr=null;
        for(int iterator_i=0;iterator_i<n;iterator_i++)
            fast_ptr = fast_ptr.next;
        while(fast_ptr!=null)
        {
            int slide = 0;
            while(slide<n && fast_ptr!=null)
            {
                fast_ptr = fast_ptr.next;
                slide++;
            }
            for(int iterator_i=0;iterator_i<slide;iterator_i++)
            {
                prev_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
        }
        if(prev_ptr!=null)
            prev_ptr.next = slow_ptr.next;
        else return head.next;
        return head;
    }

    public static ListNode create_linked_list(Scanner sc)
    {
        System.out.println("Enter number of items");
        int n = sc.nextInt();
        ListNode return_node = null,current_node=null;
        for(int iterator_i=0;iterator_i<n;iterator_i++)
        {
            if(return_node==null) {
                current_node = new ListNode(sc.nextInt());
                return_node = current_node;
            }
            else
            {
                current_node.next = new ListNode(sc.nextInt());
                current_node = current_node.next;
            }
        }
        return return_node;
    }

    /*
    47. PROBLEM DESCRIPTION (https://leetcode.com/problems/container-with-most-water/)
        Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
        n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
        with x-axis forms a container, such that the container contains the most water.
    */
    public int maxArea(int[] height)
    {
        int left_ptr=0,right_ptr=height.length-1,max_area = Integer.MIN_VALUE;
        while(left_ptr<right_ptr)
        {
            System.out.println(left_ptr+" "+right_ptr);
            max_area = Math.max(max_area,Math.min(height[left_ptr],height[right_ptr])*(right_ptr-left_ptr));
            if(height[left_ptr]<height[right_ptr])
                left_ptr++;
            else
                right_ptr--;
        }
        return max_area;
    }

    /*
    48. PROBLEM DESCRIPTION (https://leetcode.com/problems/sort-colors/)
        Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
        with the colors in the order red, white and blue.
        Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

        Example:
        Input: [2,0,2,1,1,0]
        Output: [0,0,1,1,2,2]
    */
    public void sortColors(int[] nums)
    {
        int pos[] = new int[2];
        pos[0]=-1;pos[1]=-1;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(nums[iterator_i]==0)
            {
                int temp = nums[pos[0]+1];
                nums[++pos[0]] = nums[iterator_i];
                pos[1]++;
                if(temp==1)
                {
                    int temp1 = nums[pos[1]];
                    nums[pos[1]] = temp;
                    temp = temp1;
                }
                if(temp==2)
                    nums[iterator_i] = 2;
            }
            else if(nums[iterator_i]==1)
            {
                int temp = nums[pos[1]+1];
                nums[++pos[1]] = nums[iterator_i];
                if(temp==2)
                    nums[iterator_i]=2;
            }
            System.out.println(pos[0]+":"+pos[1]);
            for(int iterator_k=0;iterator_k<nums.length;iterator_k++)
                System.out.print(nums[iterator_k]+" ");
            System.out.println();
        }
    }

    /*
    49. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
        Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
        Your algorithm's runtime complexity must be in the order of O(log n).

        If the target is not found in the array, return [-1, -1].
        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
    */
    public int[] searchRange(int[] nums, int target)
    {
        int lb=0,ub=nums.length-1;
        int return_range[] = {-1,-1};
        while(lb<=ub)
        {
            int mid = (lb+ub)/2;
            if(nums[mid]==target)
            {
                int front=mid,rear=mid;
                while(front>=0 && nums[front] == target)
                    front--;
                while(rear<nums.length && nums[rear] == target)
                    rear++;
                return_range[0] = front+1;
                return_range[1] = rear-1;
                return return_range;
            }
            else if(nums[mid]>target && ((mid>0 && nums[mid-1]<target)||mid==0))
                return return_range;
            else if(nums[mid]>target)
                ub = mid-1;
            else
                lb = mid+1;
        }
        return return_range;
    }

    /*
    50. PROBLEM DESCRIPTION (https://leetcode.com/problems/copy-list-with-random-pointer/)
        A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
        Return a deep copy of the list.
        The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of
        [val, random_index] where:
            val: an integer representing Node.val
            random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point
                    to any node.
    */
    public Node copyRandomList(Node head)
    {
        if(head==null)
            return head;
        Node temp = head;
        while(temp!=null)
        {
            Node newnode = new Node(temp.val);
            newnode.next = temp.next;
            temp.next = newnode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp!=null)
        {
            temp.next.random = (temp.random==null)?null:temp.random.next;;
            temp = temp.next.next;
        }
        Node return_head = null,return_temp=null;
        temp=head;
        while(temp!=null)
        {
            if(return_head==null) {
                return_head = temp.next;
                return_temp = return_head;
            }
            else {
                return_temp.next = temp.next;
                return_temp = return_temp.next;
            }
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return return_head;
    }

    /*
    51. PROBLEM DESCRIPTION (https://leetcode.com/problems/daily-temperatures/)
        Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
        If there is no future day for which this is possible, put 0 instead.
        For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

        Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
    */
    public int[] dailyTemperatures_alt(int[] T) { // O(N*W) Time  O(W+N) Space
        int temperature_record[] = new int[70];
        int return_result[] = new int[T.length];
        Arrays.fill(temperature_record,Integer.MAX_VALUE);
        for(int iterator_i=T.length-1;iterator_i>=0;iterator_i--)
        {
            int current_pos = Integer.MAX_VALUE,current_valid_temp_found=0;
            for(int iterator_j=T[iterator_i]-29;iterator_j<temperature_record.length && current_valid_temp_found<T.length-iterator_i-1 ;iterator_j++)
            {
                if(temperature_record[iterator_j]!=Integer.MAX_VALUE)
                    current_valid_temp_found++;
                if(temperature_record[iterator_j]<current_pos)
                    current_pos = temperature_record[iterator_j];
            }
            temperature_record[T[iterator_i]-30] = iterator_i;
            return_result[iterator_i] = (current_pos==Integer.MAX_VALUE)?0:current_pos-iterator_i;
        }
        return return_result;
    }

    public int[] dailyTemperatures(int[] T)
    {
        Stack temp_stack = new Stack();
        int return_result[] = new int[T.length];
        for(int iterator_i=T.length-1;iterator_i>=0;iterator_i--)
        {
            int next_ele = (temp_stack.empty())?-1:(int)temp_stack.peek();
            while(!temp_stack.empty() && T[(int)temp_stack.peek()]<=T[iterator_i])
                next_ele = (int)temp_stack.pop();
            if(next_ele==-1 || temp_stack.isEmpty())
                return_result[iterator_i] = 0;
            else
                return_result[iterator_i] = (int)temp_stack.peek() - iterator_i;
            temp_stack.push(iterator_i);
        }
        return return_result;
    }

    /*
    51. PROBLEM DESCRIPTION (https://leetcode.com/problems/invert-binary-tree/)
        Invert a binary tree.
    */
    public TreeNode invertTree(TreeNode root)
    {
        if(root==null)
            return root;
        TreeNode right = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = right;
        return root;
    }

    public TreeNode invertTree_stck(TreeNode root)
    {
        Stack treenode_stack = new Stack();
        TreeNode current_node = root;
        while(current_node!=null)
        {
            if(current_node.left!=null)
                treenode_stack.push(current_node.left);
            if(current_node.right!=null)
                treenode_stack.push(current_node.right);
            TreeNode temp = current_node.left;
            current_node.left = current_node.right;
            current_node.right = temp;

            current_node =  treenode_stack.empty()?null:(TreeNode)treenode_stack.pop();
        }
        return root;
    }

    /*
    52. PROBLEM DESCRIPTION (https://leetcode.com/problems/linked-list-cycle/)
        Given a linked list, determine if it has a cycle in it.
    */
    public boolean hasCycle(ListNode head)
    {
        ListNode slow_ptr = head, fast_ptr = head;
        while(fast_ptr!=null)
        {
            if(fast_ptr.next==null)
                return false;
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if(fast_ptr == slow_ptr)
                return true;
        }
        return false;
    }

    /*
    53. PROBLEM DESCRIPTION (https://leetcode.com/problems/linked-list-cycle-ii/)
        Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    */
    public ListNode detectCycle(ListNode head)
    {
        ListNode slow_ptr = head, fast_ptr = head;
        boolean isCycle = false;
        while(fast_ptr!=null)
        {
            if(fast_ptr.next==null)
                break;
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if(fast_ptr == slow_ptr) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return null;

        slow_ptr = head;
        while(slow_ptr != fast_ptr)
        {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }
        return slow_ptr;
    }

    /*
    54. PROBLEM DESCRIPTION (https://leetcode.com/problems/palindrome-linked-list/)
        Given a singly linked list, determine if it is a palindrome.

        Example 1:
        Input: 1->2
        Output: false
    */
    public boolean isPalindrome(ListNode head)
    {
        if(head==null || head.next==null)
            return true;
        ListNode first = head;
        int count = 0;
        while(first!=null)
        {
            first = first.next;
            count++;
        }
        first = head;
        for(int iterator_i=0;iterator_i<Math.ceil(count/2.0)-1;iterator_i++)
            first = first.next;

        ListNode prev_node = first;
        first = first.next;
        for(int iterator_i=0;iterator_i<Math.floor(count/2.0);iterator_i++)
        {
            ListNode next_node = first.next;
            first.next = prev_node;
            prev_node = first;
            if(next_node != null)
                first = next_node;
        }
        for(int iterator_i=0;iterator_i<Math.floor(count/2.0);iterator_i++)
        {
            if(head.val != first.val)
                return false;
            head = head.next;
            first = first.next;
        }
        return true;

    }

    /*
    55. PROBLEM DESCRIPTION (https://leetcode.com/problems/majority-element/)
        Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

        You may assume that the array is non-empty and the majority element always exist in the array.
        Example 1:
        Input: [3,2,3]
        Output: 3
    */
    public int majorityElement(int[] nums) // Boyer Moore Voting
    {
        int current_ele =0,count_majority=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(count_majority==0) {
                current_ele = nums[iterator_i];
                count_majority = 1;
            }
            else if(current_ele == nums[iterator_i])
                count_majority++;
            else
                count_majority--;
        }
        return current_ele;
    }

    /*
    56. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-largest-element-in-an-array/)
        Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

        Example 1:
        Input: [3,2,1,5,6,4] and k = 2
        Output: 5
    */
    public int findKthLargest_alt(int[] nums, int k) // Priority Dueue
    {
        PriorityQueue pqueue = new PriorityQueue();
        for(int num:nums)
        {
            pqueue.offer(num);
            while(pqueue.size()>k)
                pqueue.poll();
        }
        return (int)pqueue.peek();
    }

    public int findKthLargest(int[] nums,int k)
    {
        int lb = 0,ub = nums.length-1;
        k=nums.length-k;
        while(lb<=ub)
        {
            int s = findKthPartition(nums, lb, ub);
            if(s<k)
                lb = s+1;
            else if(s>k)
                ub = s-1;
            else
                return nums[s];
        }
        return -1;
    }

    public static int findKthPartition(int[] nums,int lb, int ub)
    {
        int i=lb+1,j=ub;
        while(i<=j)
        {
            while(i<=ub && nums[lb]>nums[i])
                i++;
            while(j>=i && nums[j]>=nums[lb])
                j--;

            if(i<j)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[lb];
        nums[lb] = nums[j];
        nums[j] = temp;
        return j;
    }

    /*
    57. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-two-binary-trees/)
        Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped
        while the others are not.
        You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new
        value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
    */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2)
    {
        if(t1==null)
            return t2;
        if(t2 ==null)
            return t1;
        t1 .val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    /*
    58. PROBLEM DESCRIPTION (https://leetcode.com/problems/game-of-life/)
        According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

        Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight
        neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
            1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
            2. Any live cell with two or three live neighbors lives on to the next generation.
            3. Any live cell with more than three live neighbors dies, as if by over-population..
            4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

        Write a function to compute the next state (after one update) of the board given its current state.
        The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
    */
    public void gameOfLife(int[][] board)
    {
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
                updateLivingCondition(board,iterator_i,iterator_j);

        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
            {
                if(board[iterator_i][iterator_j]==2)
                    board[iterator_i][iterator_j] = 1;
                else if(board[iterator_i][iterator_j]==-1)
                    board[iterator_i][iterator_j] = 0;
            }
        }
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++)
                System.out.print(board[iterator_i][iterator_j] + " ");
            System.out.println();
        }
    }

    public static void updateLivingCondition(int[][] board,int row, int col)
    {
        int offset[] ={-1,0,1},count_active_neighbors = 0;
        for(int iterator_i=0;iterator_i<offset.length;iterator_i++)
        {

            for(int iterator_j=0;iterator_j<offset.length;iterator_j++)
            {
                if(row+offset[iterator_i]<0 || row+offset[iterator_i]>=board.length || col+offset[iterator_j]<0 || col+offset[iterator_j]>=board[0].length || (iterator_i==1 && iterator_j==1))
                    continue;
                if(board[row+offset[iterator_i]][col+offset[iterator_j]]==1 || board[row+offset[iterator_i]][col+offset[iterator_j]]==-1)
                    count_active_neighbors++;
            }
        }
        if(board[row][col]==1)
        {
            if(count_active_neighbors<2 || count_active_neighbors>3)
                board[row][col] = -1;
        }
        else
        {
            if(count_active_neighbors==3)
                board[row][col] = 2;
        }
    }

    /*
    59. PROBLEM DESCRIPTION (https://leetcode.com/problems/diameter-of-binary-tree/)
        Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

        Example:
        Given a binary tree
              1
             / \
            2   3
           / \
          4   5
        Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
    */
    int max_dia=0;
    public int diameterOfBinaryTree(TreeNode root)
    {
        depth(root);
        return max_dia;
    }

    public int depth(TreeNode root)
    {
        if(root==null)
            return 0;
        int lheight = depth(root.left);
        int rheight = depth(root.right);
        max_dia = Math.max(max_dia,lheight+rheight);
        return 1+Math.max(lheight,rheight);
    }

    /*
    60. PROBLEM DESCRIPTION (https://leetcode.com/problems/intersection-of-two-linked-lists/)
        Write a program to find the node at which the intersection of two singly linked lists begins.

    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode list1 = headA, list2= headB;
        if(headA==null || headB==null)
            return null;
        boolean cycle_completed = false;
        while(list1!=list2)
        {
            if(list1.next==null) {
                if(cycle_completed)
                    return null;
                list1 = headB;
                cycle_completed = true;
            }
            else
                list1 = list1.next;

            if(list2.next==null)
                list2=headA;
            else
                list2 = list2.next;
        }
        return list1;
    }

    /*
    61. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-linked-list/)
        Reverse a singly linked list.

        Example:
        Input: 1->2->3->4->5->NULL
        Output: 5->4->3->2->1->NULL

    */
    public ListNode reverseList_alt(ListNode head) // Iter
    {
        if(head==null)
            return head;
        ListNode prev_node = head,next_node = head.next;
        prev_node.next = null;
        while(next_node!=null)
        {
            ListNode temp = next_node.next;
            next_node.next = prev_node;
            prev_node = next_node;
            next_node = temp;
        }
        return prev_node;
    }

    public ListNode reverseList(ListNode head)
    {
        if(head==null || head.next == null)
            return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    /*
    62. PROBLEM DESCRIPTION (https://leetcode.com/problems/house-robber/)
        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only
        constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically
        contact the police if two adjacent houses were broken into on the same night.

        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can
        rob tonight without alerting the police.

        Example 1:

        Input: [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

    */
    public int rob(int[] nums)
    {
       int max_prev1 = 0,max_prev2 = 0;
       for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
       {
           int temp = max_prev1;
           max_prev1 = Math.max(max_prev2+nums[iterator_i],max_prev1);
           max_prev2 = temp;
       }
       return max_prev1;
    }

    /*
    63. PROBLEM DESCRIPTION (https://leetcode.com/problems/lru-cache/)
        Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should
        invalidate the least recently used item before inserting a new item.

        The cache is initialized with a positive capacity.
        O(1) time complexity?

        Example:
        LRUCache cache = new LRUCache( 2  capacity  )

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

        New Class created
    */

    /*
    64. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
        Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

        Find all the elements of [1, n] inclusive that do not appear in this array.
        Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

        Example:
        Input:
        [4,3,2,7,8,2,3,1]
        Output:
        [5,6]
    */
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        List<Integer> list = new ArrayList<>();
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            nums[Math.abs(nums[iterator_i])-1] = Math.min(nums[Math.abs(nums[iterator_i])-1],-nums[Math.abs(nums[iterator_i])-1]);
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(nums[iterator_i]>0) {
                System.out.println(iterator_i);
                list.add(iterator_i);
            }

        }
        return list;
    }

    /*
    65. PROBLEM DESCRIPTION (https://leetcode.com/problems/target-sum/)
        You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

        Find out how many ways to assign symbols to make sum of integers equal to target S.

        Example 1:
        Input: nums is [1, 1, 1, 1, 1], S is 3.
        Output: 5
        Explanation:

            -1+1+1+1+1 = 3
            +1-1+1+1+1 = 3
            +1+1-1+1+1 = 3
            +1+1+1-1+1 = 3
            +1+1+1+1-1 = 3

        There are 5 ways to assign symbols to make the sum of nums be target 3.
        Note:
            The length of the given array is positive and will not exceed 20.
            The sum of elements in the given array will not exceed 1000.
            Your output answer is guaranteed to be fitted in a 32-bit integer.
    */
    public int findTargetSumWays(int[] nums, int S) // Can also be done as Subset Sum Problem
    {
        // DP Programming
        return findTargetSumWays_dp(nums,S);


        // Memoization and Recursion
//        int mem_arr[][] = new int[nums.length][2001];
//        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
//            Arrays.fill(mem_arr[iterator_i], Integer.MIN_VALUE);
//        return findTargetSumWays_memoization(nums,S,0,0,mem_arr);

        //Recursive
//        return findTargetSumWays_rcur(nums,S,0,0);
    }

    public static int findTargetSumWays_rcur(int[] nums,int sum, int position,int current_sum)
    {
        if(position==nums.length)
        {
            if (sum == current_sum)
                return 1;
            return 0;
        }
        return (findTargetSumWays_rcur(nums,sum,position+1,current_sum+nums[position]) +
        findTargetSumWays_rcur(nums,sum,position+1,current_sum-nums[position]));
    }

    public static  int findTargetSumWays_memoization(int nums[],int sum,int position,int current_sum,int[][] mem_arr)
    {
        if(position<nums.length && mem_arr[position][current_sum+1000]!=Integer.MIN_VALUE)
            return mem_arr[position][current_sum+1000];
        if(position==nums.length)
        {
            if(current_sum==sum)
                return 1;
            return 0;
        }
        mem_arr[position][current_sum+1000] = findTargetSumWays_memoization(nums,sum,position+1,current_sum+nums[position],mem_arr)+ findTargetSumWays_memoization(nums,sum,position+1,current_sum-nums[position],mem_arr);
        return mem_arr[position][current_sum+1000];
    }

    public static int findTargetSumWays_dp(int[] nums,int sum)
    {
        int max_sum=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            max_sum += nums[iterator_i];
        int dp_prev[] = new int[max_sum*2+1],dp_curr[] = new int[max_sum*2+1];
        Arrays.fill(dp_prev,Integer.MIN_VALUE);

        dp_prev[max_sum+nums[0]] = 1;
        dp_prev[max_sum-nums[0]] = dp_prev[max_sum-nums[0]]==Integer.MIN_VALUE?1:2;

        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            Arrays.fill(dp_curr,Integer.MIN_VALUE);
            for(int iterator_j=0;iterator_j<max_sum*2+1;iterator_j++)
            {
                if(dp_prev[iterator_j]!=Integer.MIN_VALUE)
                {
                    dp_curr[iterator_j + nums[iterator_i]] = ((dp_curr[iterator_j + nums[iterator_i]]==Integer.MIN_VALUE)?dp_prev[iterator_j]:(dp_curr[iterator_j + nums[iterator_i]]+dp_prev[iterator_j]));
                    dp_curr[iterator_j - nums[iterator_i]] = ((dp_curr[iterator_j - nums[iterator_i]]==Integer.MIN_VALUE)?dp_prev[iterator_j]:(dp_curr[iterator_j - nums[iterator_i]]+dp_prev[iterator_j]));
                }
            }
            dp_prev = Arrays.copyOf(dp_curr,dp_curr.length);
        }
        return ( sum>max_sum || dp_prev[sum+max_sum]==Integer.MIN_VALUE)?0:dp_prev[sum+max_sum];
    }

    /*
    66. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-depth-of-binary-tree/)
        Given a binary tree, find its maximum depth.

        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

        Note: A leaf is a node with no children.

        Example:

        Given binary tree [3,9,20,null,null,15,7],
                 3
                / \
               9  20
                 /  \
                15   7
        return its depth = 3.
    */
    public int maxDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /*
    67. PROBLEM DESCRIPTION (https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
        Given a binary tree, flatten it to a linked list in-place.

        For example, given the following tree:

              1
             / \
            2   5
           / \   \
          3   4   6
        The flattened tree should look like:

        1
         \
          2
           \
            3
             \
              4
               \
                5
                 \
                  6
    */
    TreeNode curr = null;
    public void flatten(TreeNode root) {
        if(root==null)
            return ;
        flatten(root.left);
        flatten(root.right);
        root.right = curr;
        root.left = null;
        curr = root;
    }

    /*
    68. PROBLEM DESCRIPTION (https://leetcode.com/problems/subsets/)
        Given a set of distinct integers, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        Example:
        Input: nums = [1,2,3]
        Output:
            [
                [3],
                [1],
                [2],
                [1,2,3],
                [1,3],
                [2,3],
                [1,2],
                []
            ]
    */
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        subsetsSpace(nums,new ArrayList<>(),0,list);
        return null;
    }

    public static void subsetsSpace(int[] nums, List<Integer> current_set,int position,List<List<Integer>> list)
    {
        if(position==nums.length) {
            list.add(new ArrayList<> (current_set));
            return;
        }
        subsetsSpace(nums,current_set,position+1,list);
        current_set.add(nums[position]);
        subsetsSpace(nums,current_set,position+1,list);
        current_set.remove(current_set.size()-1);
    }

    /*
    69. PROBLEM DESCRIPTION (https://leetcode.com/problems/symmetric-tree/)
        Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    */
    public boolean isSymmetric(TreeNode root)
    {
        if(root==null)
            return true;
        return isSymmetricHelper(root.left,root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right)
    {
        if(left==null && right==null)
            return true;
        if(left==null||right==null)
            return false;
        return isSymmetricHelper(left.left,left.right) && isSymmetricHelper(right.left,right.right) && left.val==right.val;
    }

    /*
    70. PROBLEM DESCRIPTION (https://leetcode.com/problems/subsets-ii/)
        Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.
        Example:

        Input: [1,2,2]
        Output:
            [
              [2],
              [1],
              [1,2,2],
              [2,2],
              [1,2],
              []
            ]
    */
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        subsetsWithDupSpace(nums,list,new ArrayList<Integer>(),0);
        return list;
    }


    public void subsetsWithDupSpace(int[] nums,List<List<Integer>> list,List<Integer> current_set,int position)
    {
        if(position==nums.length)
        {
            list.add(new ArrayList<>(current_set));
            return;
        }
        current_set.add(nums[position]);
        subsetsWithDupSpace(nums,list,current_set,++position);
        current_set.remove(current_set.size()-1);
        while(position<nums.length && nums[position]==nums[position-1])
            position++;
        subsetsWithDupSpace(nums,list,current_set,position);
    }

    public List<List<Integer>> subsetsWithDup_iter(int[] nums)
    {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        list.add(new ArrayList<>());
        int count=0;
        for(int i=0;i<nums.length;i+=count)
        {
            count=0;
            while(i+count<nums.length && nums[i+count]==nums[i])
                count++;
            int count_prev_sets = list.size();
            for(int subset_iterator=0;subset_iterator<count_prev_sets;subset_iterator++)
            {
                List<Integer> prev_set = new ArrayList<>(list.get(subset_iterator));
                for(int addition_iterator=0;addition_iterator<count;addition_iterator++)
                {
                    prev_set.add(nums[i+addition_iterator]);
                    list.add(new ArrayList<>(prev_set));
                    for(Integer setval:prev_set)
                        System.out.print(setval+" ");
                    System.out.println();
                }
            }
        }
        return list;
    }

    /*
    71. PROBLEM DESCRIPTION (https://leetcode.com/problems/jump-game/)
        Given an array of non-negative integers, you are initially positioned at the first index of the array.

        Each element in the array represents your maximum jump length at that position.

        Determine if you are able to reach the last index.
        Example 1:
            Input: [2,3,1,1,4]
            Output: true
            Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

        Example 2:
            Input: [3,2,1,0,4]
            Output: false
            Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
    */
    public boolean canJump(int[] nums)
    {
        int zero_pos = 1;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(zero_pos<=iterator_i)
                return false;
            while(zero_pos<nums.length)
            {
                if(nums[iterator_i]+iterator_i>=zero_pos)
                    zero_pos++;
                else
                    break;
            }
            if(zero_pos==nums.length)
                return true;
        }
        return false;
    }

    /*
    72. PROBLEM DESCRIPTION (https://leetcode.com/problems/group-anagrams/)
        Given an array of strings, group anagrams together.

        Example:
            Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
            Output:
                [
                    ["ate","eat","tea"],
                    ["nat","tan"],
                    ["bat"]
                ]
        Note:
            All inputs will be in lowercase.
            The order of your output does not matter.
    */
    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String,List<String>> hmap = new HashMap<String,List<String>>();
        String key;
        int count[] = new int[26];
        for(int iterator_i=0;iterator_i<strs.length;iterator_i++)
        {
            Arrays.fill(count,0);
            for(int iterator_j=0;iterator_j<strs[iterator_i].length();iterator_j++)
                count[strs[iterator_i].charAt(iterator_j)-'a']++;
            key = Arrays.toString(count);
            if(hmap.containsKey(key))
            {
                List<String> curr_list = hmap.get(key);
                curr_list.add(strs[iterator_i]);
            }
            else
                hmap.put(key,new ArrayList<>(Arrays.asList(strs[iterator_i])));
        }
        return new ArrayList<>(hmap.values());
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        LeetCode obj = new LeetCode();

        /** Driver Code for Q1. twoSum
         **
         */
//
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
//
//        System.out.println(result[0]+" "+result[1]);

        /** Driver Code for Q2. addTwoNumbers
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
//        obj.combinationSum2(candidates,sc.nextInt());

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
//        obj.solveSudoku(board);

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
//        System.out.println(obj.findBestValue(input_arr, sc.nextInt()));


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
//        obj.maxArea(height);

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
//        List<List<String>> final_list = obj.groupAnagrams(input_strs);
//        for(List<String> lists:final_list) {
//            for (String s : lists)
//                System.out.print(s + " ");
//            System.out.println();
//        }
        
    }
}
