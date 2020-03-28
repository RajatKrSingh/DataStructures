package LeetCode;
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

        /** Driver Code for Q31.combinationSum
         *
         */
//        int candidates[] = obj.create_array_int(sc);
//        System.out.println("Enter target");
//        obj.combinationSum2(candidates,sc.nextInt());
    }
}
