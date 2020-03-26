package LeetCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    void DisplayList(ListNode lnode)
    {
        while(lnode!=null)
        {
            System.out.println(lnode.val);
            lnode = lnode.next;
        }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode target = null,final_result=null;
        int carry = 0;
        while(l1!=null && l2!=null)
        {
            ListNode tmp_target = new ListNode((l1.val + l2.val + carry)%10);
            carry = (int)((l1.val + l2.val + carry)/10);
            if(target==null)
            {
                final_result = tmp_target;
                target = tmp_target;
            }
            else {
                target.next = tmp_target;
                target = tmp_target;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null)
        {
            ListNode tmp_target = new ListNode((l1.val + carry)%10);
            carry = (int)((l1.val + carry)/10);
            target.next = tmp_target;
            target = tmp_target;
            l1 = l1.next;
        }
        while(l2!=null)
        {
            ListNode tmp_target = new ListNode((l2.val + carry)%10);
            carry = (int)((l2.val + carry)/10);
            target.next = tmp_target;
            target = tmp_target;
            l2 = l2.next;
        }
        if(carry==1)
        {
            ListNode tmp_target = new ListNode(1);
            target.next = tmp_target;
        }
        return final_result;
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

        int max_till_now = 0,index_start=0,final_max=0;
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            Character curr = (Character)s.charAt(i);
            if(map.containsKey(curr))
            {
                while(s.charAt(index_start)!=s.charAt(i)) {
                    map.remove((Character)s.charAt(index_start));
                    index_start++;
                    max_till_now--;
                }
                index_start++;
//                System.out.println(index_start+" "+max_till_now);
            }
            else
            {
                max_till_now++;
                map.put(curr,curr);
                if(max_till_now>final_max)
                    final_max = max_till_now;
            }
        }
        return final_max;
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

        ListNode mergedlist=null;
        ListNode firstNode = null;
        if((l1==null) && (l2==null))
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        while(l1!=null && l2!=null)
        {
            if(l1.val < l2.val) {
                if (mergedlist == null) {
                    mergedlist = new ListNode(l1.val);
                    firstNode = mergedlist;
                }
                else
                {
                    ListNode temp = new ListNode(l1.val);
                    mergedlist.next = temp;
                    mergedlist = temp;
                }
                l1 = l1.next;
            }
            else
            {
                if (mergedlist == null) {
                    mergedlist = new ListNode(l2.val);
                    firstNode = mergedlist;
                }
                else
                {
                    ListNode temp = new ListNode(l2.val);
                    mergedlist.next = temp;
                    mergedlist = temp;
                }
                l2 = l2.next;
            }
        }
        while(l1!=null)
        {
            ListNode temp = new ListNode(l1.val);
            mergedlist.next = temp;
            mergedlist = temp;
            l1 = l1.next;
        }
        while(l2!=null)
        {
            ListNode temp = new ListNode(l2.val);
            mergedlist.next = temp;
            mergedlist = temp;
            l2 = l2.next;
        }
    return firstNode;
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

        int last_index=0,index=0;
        while(index<nums.length)
        {
            nums[last_index++] = nums[index++];
            while((index<nums.length)&&(nums[index]==nums[last_index-1]))
                index++;
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

        int curr_arr[] = new int[10000],index=0;
        String current_line ="1";
        if(n==1)
            return current_line;
        //for loop
        for(int i=1;i<n;i++) {
            String new_line = "";
            index =0;
            while (index < current_line.length()) {
                char current_char = current_line.charAt(index);
                int iteration_of_current_char = 0;
                while (index < current_line.length() && current_line.charAt(index) == current_char) {
                    iteration_of_current_char++;
                    index++;
                }
                new_line += (char) (iteration_of_current_char + 48);
                new_line += (char) (current_char );
            }
            current_line = new_line;
        }
        return current_line;
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
        int carry =1;
        while(index>=0)
        {
            digits[index] = (digits[index]+carry)%10;
            if(digits[index]==0)
                carry=1;
            else
                carry=0;
            index--;
            if(carry==0)
                break;
        }
        if(index==-1 && carry==1)
        {
            int new_arr[] = new int[digits.length+1];
            new_arr[0]=1;
            for(int i=0;i<digits.length;i++)
                new_arr[i+1] = digits[i];
            return new_arr;
        }
        return digits;
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

        int word_length = 0,index=0;
        while(index<s.length()&& s.charAt(index)==' ' )
            index++;
        while(index<s.length())
        {
            if(s.charAt(index) == ' ' ) {
                while(index<s.length() && s.charAt(index)==' ')
                    index++;
                if(index==s.length())
                    return word_length;
                word_length = 0;
            }
            else {
                word_length++;
                index++;
            }
        }

        return word_length;

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

        int index1 = a.length()-1, index2 = b.length()-1;
        String result = "";
        if(index1==-1 && index2==-1)
            return result;
        else if(index1==-1)
            return b;
        else if(index2==-1)
            return a;
        int carry=0;
        while(index1>=0 && index2>=0)
        {
            if((int)(a.charAt(index1)) + (int)(b.charAt(index2)) + carry - 96 == 3) {
                result = '1' + result;
            }
            else if((int)(a.charAt(index1)) + (int)(b.charAt(index2)) + carry - 96 == 2)
            {
                result = '0'+ result;
                carry =1 ;
            }
            else if((int)(a.charAt(index1)) + (int)(b.charAt(index2)) + carry - 96 == 1)
            {
                result = '1' + result;
                carry = 0;
            }
            else if((int)(a.charAt(index1)) + (int)(b.charAt(index2)) + carry - 96 == 0)
            {
                result = '0' + result;
            }
            index1--;
            index2--;
        }
        while(index1>=0)
        {
            if((int)(a.charAt(index1))+ carry -48 ==2)
            {
                result = '0'+ result;
            }
            else if((int)(a.charAt(index1))+ carry -48 ==1)
            {
                result = '1'+ result;
                carry=0;
            }
            else if((int)(a.charAt(index1))+ carry -48 ==0)
            {
                result = '0' + result;
            }
            index1--;
        }
        while(index2>=0)
        {
            if((int)(b.charAt(index2))+ carry -48 ==2)
            {
                result = '0'+ result;
            }
            else if((int)(b.charAt(index2))+ carry -48 ==1)
            {
                result = '1'+ result;
                carry=0;
            }
            else if((int)(b.charAt(index2))+ carry -48 ==0)
            {
                result = '0' + result;
            }
            index2--;
        }
        if(carry==1)
            result = '1'+ result;
        return result;
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

        int index1 = m-1,index2=n-1,len=m+n-1;
        while(index1>=0 && index2>=0)
        {
            if(nums1[index1] > nums2[index2])
            {
                nums1[len] = nums1[index1];
                index1--;
                len--;
            }
            else
            {
                nums1[len] = nums2[index2];
                index2--;
                len--;
            }
        }
        while(index1>=0)
        {
            nums1[len] = nums1[index1];
            index1--;
            len--;
        }
        while(index2>=0)
        {
            nums1[len] = nums2[index2];
            index2--;
            len--;
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
            if(prices[i]<min_till_now)
                min_till_now = prices[i];
            if(max_profit< prices[i]-min_till_now)
                max_profit = prices[i] - min_till_now;
        }
        return max_profit;
    }


/*
22. PROBLEM DESCRIPTION (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
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
        {
            if(prices[i+1]>prices[i])
                max_profit = max_profit+prices[i+1] - prices[i];
        }
        return max_profit;
    }


/*
    23. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-palindrome/)
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
        if(s.equals(" "))
            return true;
        s = s.toLowerCase();
        int start_index = 0, last_index = s.length()-1;
        while(start_index<=last_index)
        {
            while(start_index<s.length()-1 && !Character.isDigit(s.charAt(start_index)) && !Character.isLetter(s.charAt(start_index)) )
                start_index++;
            while(last_index>-1 && !Character.isDigit(s.charAt(last_index)) && !Character.isLetter(s.charAt(last_index))   )
                last_index--;
            if(start_index<=last_index)
            {
                if(s.charAt(start_index)!=s.charAt(last_index))
                    return false;
                start_index++;
                last_index--;
            }
        }
        return true;
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
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
        int count = 0;
        int temp = nums[0];
        for(int i=0;i<k;i++) {
            int t_temp = nums[i];
            nums[i] = temp;
            temp = t_temp;
            int skip_index = i+k;
            int j=i;
            while (skip_index > i ) {
                temp = nums[skip_index];
                nums[skip_index] = temp;
                j = (j+k)%nums.length;
                skip_index= (skip_index+k)%nums.length;
                temp = nums[j];
            }
        }
    }

    static String getBits(byte b)
    {
        String result = "";
        for(int i = 0; i < 8; i++)
            result += (b & (1 << i)) == 0 ? "0" : "1";
        return result;
    }

    /* Create Binary Tree
        -1 : End of tree
        -2 : Skip the node (null)
     */
    public TreeNode CreateTree(Scanner sc )
    {
        TreeNode tree = new TreeNode();
        int iv_val = 0;
        while(true)
        {
            if(iv_val == -1 )
                return tree;
            else if(iv_val == -2)
            {

            }

        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        LeetCode obj = new LeetCode();

        /** Driver Code for twoSum
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

        /** Driver Code for addTwoNumbers
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


        /** Driver Code for lengthOfLongestSubstring
         **
         */
//        System.out.println("Enter string\n");
//        String str = sc.next();
//        System.out.println(obj.lengthOfLongestSubstring(str));


        /** Driver Code for reverse
         **
         */

//        System.out.println("Enter number");
//        int num = sc.nextInt();
//        System.out.println(obj.reverse(num));

        /** Driver Code for myAtoi
         **
         */

//        System.out.println("Enter number");
//        String str = sc.next();
//        System.out.println(obj.myAtoi(str));

        /** Driver Code for isPalindrome
         **
         */

//        System.out.println("Enter number");
//        int num = sc.nextInt();
//        System.out.println(obj.isPalindrome(num));

        /** Driver Code for intToRoman
         **
         */
//        System.out.println("Enter number");
//        int num = sc.nextInt();
//        System.out.println(obj.intToRoman(num));

        /** Driver Code for longestCommonPrefix
         **
         */
//        System.out.println("Enter number of string");
//        int len = sc.nextInt();
//        String str[] = new String[len];
//        for(int i=0;i<len;i++)
//            str[i] = sc.next();
//        System.out.println(obj.longestCommonPrefix(str));

        /** Driver Code for isValid
         **
         */
//        System.out.println("Enter string");
//        String str = sc.next();
//        System.out.println(obj.isValid(str));

        /** Driver Code for mergeTwoLists
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


        /** Driver Code for removeDuplicates
         **
         */
//        System.out.println("Enter length");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//        obj.removeDuplicates(arr);

        /** Driver Code for removeElement
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

        /** Driver Code for countAndSay
         **
         */
//        System.out.println("Enter n");
//        int n = sc.nextInt();
//        obj.countAndSay(n);

        /** Driver Code for searchInsert
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


        /** Driver Code for plusOne
         **
         */
//        System.out.println("Enter length");
//        int len = sc.nextInt();
//        int digits[] = new int[len];
//        for(int i=0;i<len;i++)
//            digits[i] = sc.nextInt();
//        obj.plusOne(digits);

        /** Driver Code for mySqrt
         **
         */
//        System.out.println("Enter number");
//        int square = sc.nextInt();
//        System.out.println(obj.mySqrt(square));

        /** Driver Code for lengthOfLastWord
         **
         */
//        System.out.println("Enter String");
//        String str = sc.nextLine();
//        str ="";
//        System.out.println(obj.lengthOfLastWord(str));


        /** Driver Code for addBinary
         **
         */
//        System.out.println("Enter binary strings");
//        String bin1 = sc.next();
//        String bin2 = sc.next();
//        System.out.println(obj.addBinary(bin1,bin2));

        /** Driver Code for climbStairs
         **
         */
//        System.out.println("Enter n");
//        int n = sc.nextInt();
//        System.out.println(obj.climbStairs(n));


        /** Driver Code for merge
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

        /** Driver Code for singleNumber
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

        /** Driver Code for maxProfit
         **
         */
//        System.out.println("Enter length ");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//
//        System.out.println(obj.maxProfit(arr));

        /** Driver Code for maxProfit1
         **
         */
//        System.out.println("Enter length ");
//        int len = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//
//        System.out.println(obj.maxProfit1(arr));

        /** Driver Code for isPalindrome
         **
         */
//        System.out.println("Enter string");
//        String str = sc.nextLine();
//        System.out.println(obj.isPalindrome(str));

        /** Driver Code for rotate
         **
         */
//        System.out.println("Enter length");
//        int len = sc.nextInt();
//        System.out.println("Enter k");
//        int k = sc.nextInt();
//        int arr[] = new int[len];
//        for(int i=0;i<len;i++)
//            arr[i] = sc.nextInt();
//
//        obj.rotate(arr,k);
//
//        for(int i=0;i<len;i++)
//            System.out.print(arr[i]+" ");


        System.out.println("rotate is unfinished");

        TreeNode tree1 = obj.CreateTree(sc);


    }
}
