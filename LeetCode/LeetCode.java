package LeetCode;

import javafx.util.Pair;
//import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode
{
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
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
        while (lnode != null) {
            System.out.println(lnode.val);
            lnode = lnode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode temp1 = l1, temp2 = l2;
        ListNode final_list = new ListNode(0), temp_final = final_list;
        int sum = 0;
        while (temp1 != null || temp2 != null) {
            sum /= 10;
            if (temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            temp_final.next = new ListNode(sum % 10);
            temp_final = temp_final.next;
        }
        if (sum / 10 == 1)
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
    public int lengthOfLongestSubstring(String s)
    {

        int maximum = 0, char_map[] = new int[256], j = 0;
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++) {
            j = char_map[s.charAt(iterator_i)] > 0 ? Math.max(char_map[s.charAt(iterator_i)], j) : j;
            char_map[s.charAt(iterator_i)] = iterator_i + 1;
            maximum = Math.max(maximum, iterator_i - j + 1);
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
    public int reverse(int x)
    {

        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && x % 10 > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && x % 10 < -8)) return 0;
            result = result * 10 + x % 10;
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
    public int myAtoi(String str)
    {
        int i = 0, signflag = 0;
        if (str.length() == 0 || str == null)
            return 0;
        int result = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i < str.length() && ((str.charAt(i) <= '9' && str.charAt(i) >= '0') || (str.charAt(i) == '+') || (str.charAt(i) == '-'))) {
            if (str.charAt(i) == '-') {
                signflag = 1;
                i++;
            } else if (str.charAt(i) == '+')
                i++;
            while (i < str.length() && (str.charAt(i) <= '9' && str.charAt(i) >= '0')) {
                if (signflag == 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && ((int) (str.charAt(i) - '0')) % 10 > 7)))
                    return Integer.MAX_VALUE;
                if (signflag == 1 && ((0 - result) < Integer.MIN_VALUE / 10 || ((0 - result) == Integer.MIN_VALUE / 10 && ((0 - (int) (str.charAt(i) - '0'))) % 10 < -8)))
                    return Integer.MIN_VALUE;
                result = result * 10 + (int) (str.charAt(i) - '0');
                i++;
                System.out.flush();
            }
            if (signflag == 1)
                result = 0 - result;
            return result;
        } else
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
    public boolean isPalindrome(int x)
    {

        if (x < 0)
            return false;
        int cpy = x, res = 0;
        while (cpy != 0) {
            res = res * 10 + cpy % 10;
            cpy = cpy / 10;
        }
        if (res == x)
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
    public String intToRoman(int num)
    {

        String result = "";
        while (num != 0) {
            if (num >= 1000) {
                num -= 1000;
                result += "M";
            } else if (num >= 900) {
                num -= 900;
                result += "CM";
            } else if (num >= 500) {
                num -= 500;
                result += "D";
            } else if (num >= 400) {
                num -= 400;
                result += "CD";
            } else if (num >= 100) {
                num -= 100;
                result += "C";
            } else if (num >= 90) {
                num -= 90;
                result += "XC";
            } else if (num >= 50) {
                num -= 50;
                result += "L";
            } else if (num >= 40) {
                num -= 40;
                result += "XL";
            } else if (num >= 10) {
                num -= 10;
                result += "X";
            } else if (num >= 9) {
                num -= 9;
                result += "IX";
            } else if (num >= 5) {
                num -= 5;
                result += "V";
            } else if (num >= 4) {
                num -= 4;
                result += "IV";
            } else if (num >= 1) {
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
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
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
    public String longestCommonPrefix(String[] strs)
    {

        String prefix = "";
        if (strs == null || strs.length < 1)
            return prefix;
        if (strs.length == 1)
            return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if ((i >= strs[j].length()) || strs[j].charAt(i) != strs[0].charAt(i))
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
    public boolean isValid(String s)
    {

        int top = -1;
        char stack[] = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack[++top] = s.charAt(i);
            } else {
                if (top < 0)
                    return false;
                switch (s.charAt(i)) {
                    case '}':
                        if (stack[top] != '{')
                            return false;
                        else
                            top--;
                        break;
                    case ')':
                        if (stack[top] != '(')
                            return false;
                        else
                            top--;
                        break;
                    case ']':
                        if (stack[top] != '[')
                            return false;
                        else
                            top--;
                        break;
                }
            }
        }
        if (top == -1)
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode final_result = new ListNode(0), temp_result = final_result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp_result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp_result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp_result = temp_result.next;
        }
        temp_result.next = l1 == null ? l2 : l1;
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

    public int removeDuplicates(int[] nums)
    {
        int last_index = 1, iterator_i = 1;
        while (iterator_i < nums.length) {
            if (nums[iterator_i] != nums[iterator_i - 1])
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
    public int removeElement(int[] nums, int val)
    {

        int last_index = -1, index = 0;
        while (index < nums.length) {
            if (nums[index] != val) {
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

    public String countAndSay(int n)
    {
        String final_string = "1";
        for (int iterator_i = 1; iterator_i < n; iterator_i++) {
            int iterator_j = 0;
            String iterator_string = "";
            while (iterator_j < final_string.length()) {
                int current__item_pos = iterator_j;
                while (iterator_j < final_string.length() - 1 && final_string.charAt(iterator_j) == final_string.charAt(iterator_j + 1))
                    iterator_j++;
                iterator_string += (char) (iterator_j++ - current__item_pos + 49) + "" + final_string.charAt(current__item_pos);

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
    public int searchInsert(int[] nums, int target)
    {
        int lb = 0, ub = nums.length - 1, mid = 0;
        if (nums.length == 1 && nums[0] < target)
            return 1;
        else if (nums.length == 1)
            return 0;
        while (lb < ub) {
            mid = (int) Math.ceil((lb + ub) / 2.0);
            if (nums[mid - 1] < target && nums[mid] >= target)
                return mid;
            else if (nums[mid - 1] < target)
                lb = mid + 1;
            else
                ub = mid - 1;
            System.out.println(lb + " " + ub);
        }
        if (ub == 0)
            return 0;
        System.out.println(lb + " " + ub);
        if ((lb == ub) && nums[lb] >= target)
            return lb;


        return ub + 1;


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
    public int[] plusOne(int[] digits)
    {

        int index = digits.length - 1;
        while (index >= 0) {
            if (digits[index] < 9) {
                digits[index]++;
                return digits;
            }
            digits[index] = 0;
            index--;
        }
        int copy_arr[] = new int[digits.length + 1];
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

    public int mySqrt(int x)
    {
        if (x == 1 || x == 2)
            return 1;
        int lb = 1, ub = x;
        while (lb <= ub) {
            int mid = (int) ((lb + ub) / 2);
            if (mid > 1.0 * x / mid)
                ub = mid - 1;
            else if ((mid <= x / mid && (mid + 1) > x / (mid + 1)))
                return (int) mid;
            else lb = mid + 1;
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

    public int lengthOfLastWord(String s)
    {
        int iterator_i = s.length() - 1;
        while (iterator_i > 0) {
            while (iterator_i >= 0 && s.charAt(iterator_i) == ' ')
                iterator_i--;
            int curr_last = iterator_i;
            while (iterator_i >= 0 && s.charAt(iterator_i) != ' ')
                iterator_i--;
            return curr_last - iterator_i > 0 ? curr_last - iterator_i + (iterator_i < 0 ? 1 : 0) : 0;
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

    public String addBinary(String a, String b)
    {
        int a_len = a.length() - 1, b_len = b.length() - 1, curr_sum = 0;
        String final_sum = "";
        while (a_len >= 0 || b_len >= 0) {
            if (a_len >= 0) {
                curr_sum += ((int) a.charAt(a_len)) - 48;
                a_len--;
            }
            if (b_len >= 0) {
                curr_sum += ((int) b.charAt(b_len)) - 48;
                b_len--;
            }
            final_sum = curr_sum % 2 + final_sum;
            curr_sum = curr_sum > 1 ? 1 : 0;
        }
        if (curr_sum == 1)
            return "1" + final_sum;
        return final_sum;
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
    public int climbStairs(int n)
    {

        int ways[] = new int[n + 1];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n - 1];
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
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int iterator_i = m - 1, iterator_j = n - 1;
        while (iterator_i >= 0 || iterator_j >= 0) {
            if (iterator_i < 0 ? false : (iterator_j < 0 ? true : nums1[iterator_i] > nums2[iterator_j]))
                nums1[iterator_i + iterator_j + 1] = nums1[iterator_i--];
            else
                nums1[iterator_i + iterator_j + 1] = nums2[iterator_j--];
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
    public int singleNumber(int[] nums)
    {

        int result = 0;
        for (int i = 0; i < nums.length; i++)
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
    public int maxProfit(int[] prices)
    {

        int max_profit = 0, min_till_now = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min_till_now = Math.min(min_till_now, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_till_now);
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
    public int maxProfit1(int[] prices)
    {

        int max_profit = 0;
        for (int i = 0; i < prices.length - 1; i++)
            max_profit = prices[i + 1] < prices[i] ? max_profit : max_profit + prices[i + 1] - prices[i];
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
    public boolean isPalindrome(String s)
    {
        int start_index = 0, end_index = s.length() - 1;
        while (start_index < end_index) {
            if (Character.isLetterOrDigit(s.charAt(start_index)) && Character.isLetterOrDigit(s.charAt(end_index)))
                if (Character.toUpperCase(s.charAt(start_index++)) != Character.toUpperCase(s.charAt(end_index--)))
                    return false;
            if (!Character.isLetterOrDigit(s.charAt(start_index)))
                start_index++;
            if (!Character.isLetterOrDigit(s.charAt(end_index)))
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

    public int strStr(String haystack, String needle)
    {
        for (int iterator_i = 0; ; iterator_i++) {
            for (int iterator_j = 0; ; iterator_j++) {
                if (iterator_j == needle.length())
                    return iterator_i;
                if (iterator_i + iterator_j == haystack.length())
                    return -1;
                if (needle.charAt(iterator_j) != haystack.charAt(iterator_i + iterator_j))
                    break;
            }
        }
    }

    public static int strStr1(String haystack, String needle)
    {
        if (needle.length() == 0)
            return 0;
        //Create shift table
        int shift_table[] = new int[256];
        for (int iterator_i = 0; iterator_i < shift_table.length; iterator_i++)
            shift_table[iterator_i] = needle.length();
        for (int iterator_i = 0; iterator_i < needle.length() - 1; iterator_i++)
            shift_table[needle.charAt(iterator_i)] = needle.length() - 1 - iterator_i;

        // Create Bad Symbol Table
        int bad_symbol[] = new int[needle.length() - 1];
        for (int iterator_i = 0; iterator_i < bad_symbol.length; iterator_i++)
            bad_symbol[iterator_i] = needle.length();
        for (int iterator_i = 0; iterator_i < bad_symbol.length; iterator_i++) {
            int iterator_j = needle.length() - 2 - iterator_i + ((iterator_i == 0) ? 0 : 1), iterator_k = needle.length() - 1;
            while (iterator_j >= 0 && iterator_k >= needle.length() - 1 - iterator_i) {
                if (needle.charAt(iterator_j) == needle.charAt(iterator_k))
                    iterator_k--;
                else
                    iterator_k = needle.length() - 1;
                iterator_j--;
            }
            if (iterator_j < 0 || iterator_k < needle.length() - 1 - iterator_i)
                bad_symbol[iterator_i] = iterator_k - iterator_j;
        }

        for (int iterator_i = 0; iterator_i < bad_symbol.length; iterator_i++)
            System.out.print(bad_symbol[iterator_i] + " ");
        System.out.println();
        // Perform actual String Matching
        int iterator_i = needle.length() - 1;
        while (iterator_i < haystack.length()) {
            int iterator_j = 0;
            while (iterator_j < needle.length() && needle.charAt(needle.length() - 1 - iterator_j) == haystack.charAt(iterator_i - iterator_j))
                iterator_j++;
            if (iterator_j == needle.length())
                return iterator_i - iterator_j + 1;

            if (iterator_j == 0) {
                iterator_i += shift_table[haystack.charAt(iterator_i)];
                System.out.println(iterator_i + " " + iterator_j + " ");
            } else {
                iterator_i += Math.max(shift_table[haystack.charAt(iterator_i - iterator_j)] - iterator_j, bad_symbol[iterator_j - 1]);
                System.out.println(iterator_i + " " + iterator_j + " " + shift_table[haystack.charAt(iterator_i - iterator_j)]);
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
    public int[] create_array_int(Scanner sc)
    {
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int created_arr[] = new int[n];
        System.out.println("Enter elements");
        for (int iterator_i = 0; iterator_i < n; iterator_i++)
            created_arr[iterator_i] = sc.nextInt();
        return created_arr;
    }

    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> all_permutations = new ArrayList<List<Integer>>();
        permute_backtrack(nums, all_permutations, new ArrayList<>());
        return all_permutations;
    }

    public static void permute_backtrack(int nums[], List<List<Integer>> all_permutations, List<Integer> curr_perm)
    {
        if (curr_perm.size() == nums.length)
            all_permutations.add(new ArrayList<>(curr_perm));
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            if (curr_perm.contains(nums[iterator_i])) continue;
            curr_perm.add(nums[iterator_i]);
            permute_backtrack(nums, all_permutations, curr_perm);
            System.out.println(iterator_i);
            curr_perm.remove(curr_perm.size() - 1);

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

    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        permuteUniqueBacktrack(nums, new boolean[nums.length], new ArrayList<Integer>(), list);
        return list;
    }

    public boolean isPermuteReached(boolean[] position_visited_flag)
    {
        for (boolean value : position_visited_flag) {
            if (!value) {
                return false;
            }
        }
        return true;
    }

    public void permuteUniqueBacktrack(int[] nums, boolean[] position_visited_flag, List curr_perm, List<List<Integer>> list)
    {
        if (isPermuteReached(position_visited_flag)) {
            list.add(new ArrayList<>(curr_perm));
            return;
        }
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            if (position_visited_flag[iterator_i] == true || (iterator_i > 0 && nums[iterator_i - 1] == nums[iterator_i] && !position_visited_flag[iterator_i - 1]))
                continue;
            position_visited_flag[iterator_i] = true;
            curr_perm.add(nums[iterator_i]);
            permuteUniqueBacktrack(nums, position_visited_flag, curr_perm, list);
            curr_perm.remove(curr_perm.size() - 1);
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
        int final_product[] = new int[num1.length() + num2.length()], carry = 0;
        String product_str = "";
        for (int iterator_i = num1.length() - 1; iterator_i >= 0; iterator_i--) {
            for (int iterator_j = num2.length() - 1; iterator_j >= 0; iterator_j--) {
                int temp = carry;
                carry = (temp + final_product[num1.length() + num2.length() - 2 - iterator_i - iterator_j] + (int) (num1.charAt(iterator_i) - 48) * (int) (num2.charAt(iterator_j) - 48)) / 10;
                final_product[num1.length() + num2.length() - 2 - iterator_i - iterator_j] = (temp + final_product[num1.length() + num2.length() - 2 - iterator_i - iterator_j] + (int) (num1.charAt(iterator_i) - 48) * (int) (num2.charAt(iterator_j) - 48)) % 10;
            }
            final_product[num2.length() + num1.length() - 1 - iterator_i] += carry;
            carry = 0;
        }
        int last_pos = final_product.length - 1;
        while (last_pos > 0 && final_product[last_pos] == 0)
            last_pos--;
        for (int digits : Arrays.copyOfRange(final_product, 0, last_pos + 1))
            product_str = digits + product_str;
        return carry > 0 ? carry + product_str : product_str;
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
        generateParenthesisBacktrack(list, 0, "", n * 2);
        return list;
    }

    public void generateParenthesisBacktrack(List<String> list, int bracket_count, String current_string, int n)
    {
        if (current_string.length() == n) {
            if (bracket_count == 0)
                list.add(current_string);
            return;
        }
        if (bracket_count > 0)
            generateParenthesisBacktrack(list, bracket_count - 1, new String(current_string + ")"), n);
        if (bracket_count < n / 2)
            generateParenthesisBacktrack(list, bracket_count + 1, new String(current_string + "("), n);
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

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumBacktrack(list, target, new ArrayList<Integer>(), 0, candidates, 0);
        return list;
    }

    public static void combinationSumBacktrack(List<List<Integer>> list, int target, List current_items, int current_sum, int[] candidates, int current_item)
    {
        for (int iterator_i = current_item; iterator_i < candidates.length; iterator_i++) {
            if (current_sum + candidates[iterator_i] == target) {
                current_items.add(candidates[iterator_i]);
                list.add(new ArrayList<>(current_items));
                current_items.remove(current_items.size() - 1);
                return;
            }
            if (current_sum + candidates[iterator_i] < target) {
                current_items.add(candidates[iterator_i]);
                combinationSumBacktrack(list, target, current_items, current_sum + candidates[iterator_i], candidates, iterator_i);
                current_items.remove(current_items.size() - 1);
            } else
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
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumBacktrack2(list, target, new ArrayList<Integer>(), 0, candidates, -1);
        return list;
    }

    public static void combinationSumBacktrack2(List<List<Integer>> list, int target, List current_items, int current_sum, int[] candidates, int current_item)
    {
        System.out.print("pos:" + current_item + ":" + current_sum + " ");
        for (Object e : current_items)
            System.out.print(e.toString() + " ");
        System.out.println();
        for (int iterator_i = current_item + 1; iterator_i < candidates.length; iterator_i++) {
            if (current_sum + candidates[iterator_i] == target) {
                current_items.add(candidates[iterator_i]);
                for (Object e : current_items)
                    System.out.print(e.toString() + " ");
                System.out.println();
                list.add(new ArrayList<>(current_items));
                current_items.remove(current_items.size() - 1);
                return;
            }
            if (current_sum + candidates[iterator_i] < target) {
                if ((iterator_i == current_item + 1) || (candidates[iterator_i] != candidates[iterator_i - 1])) {
                    current_items.add(candidates[iterator_i]);
                    combinationSumBacktrack2(list, target, current_items, current_sum + candidates[iterator_i], candidates, iterator_i);
                    current_items.remove(current_items.size() - 1);
                }
            } else
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

    public boolean isValidSudoku(char[][] board)
    {
        HashSet<String> hset = new HashSet<>();
        for (int iterator_i = 0; iterator_i < board.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++) {
                if (board[iterator_i][iterator_j] != '.') {
                    if (!hset.add(iterator_i + "-" + board[iterator_i][iterator_j]) || !hset.add("-" + board[iterator_i][iterator_j] + "" + iterator_j) || !hset.add(iterator_i / 3 + "-" + board[iterator_i][iterator_j] + "" + iterator_j / 3))
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

    public void solveSudoku(char[][] board)
    {
        solveSudokuBacktrack(board, 0, 0);
        for (int iterator_i = 0; iterator_i < board.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++)
                System.out.print(board[iterator_i][iterator_j] + " ");
            System.out.println();
        }
    }

    public static boolean isSudokuValid(char[][] board, int row_current, int column_current, char value)
    {
        //Column Elements Check
        for (int iterator_i = 0; iterator_i < board.length; iterator_i++)
            if (board[iterator_i][column_current] == value)
                return false;

        //Row Elements Check
        for (int iterator_i = 0; iterator_i < board[0].length; iterator_i++)
            if (board[row_current][iterator_i] == value)
                return false;

        //Subsection check
        for (int iterator_i = 3 * (row_current / 3); iterator_i < 3 * (row_current / 3) + 3; iterator_i++) {
            for (int iterator_j = 3 * (column_current / 3); iterator_j < 3 * (column_current / 3) + 3; iterator_j++)
                if (board[iterator_i][iterator_j] == value)
                    return false;
        }
        return true;
    }

    public static boolean solveSudokuBacktrack(char[][] board, int row_current, int column_current)
    {
        if (board[row_current][column_current] != '.') {
            if (row_current == board.length - 1 && column_current == board[0].length - 1)
                return true;
            if (solveSudokuBacktrack(board, column_current == board[0].length - 1 ? row_current + 1 : row_current, column_current == board[0].length - 1 ? 0 : column_current + 1))
                return true;
        } else {
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
        int iterator_i = 0;
        while (iterator_i < nums.length - 2) {
            if (iterator_i == 0 || nums[iterator_i] != nums[iterator_i - 1]) {
                int l_pos = iterator_i + 1, r_pos = nums.length - 1;
                while (l_pos < r_pos) {
                    if ((l_pos != iterator_i + 1 && nums[l_pos] == nums[l_pos - 1]) || (nums[iterator_i] + nums[l_pos] + nums[r_pos] < 0))
                        l_pos++;
                    else if ((r_pos != nums.length - 1 && nums[r_pos] == nums[r_pos + 1]) || (nums[iterator_i] + nums[l_pos] + nums[r_pos] > 0))
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

    public int threeSumClosest(int[] nums, int target)
    {
        int min_diff = Integer.MAX_VALUE, iterator_i = 0;
        while (iterator_i < nums.length - 2) {
            int l_pos = iterator_i + 1, r_pos = nums.length - 1;
            while (l_pos < r_pos) {
                System.out.println(l_pos + " " + r_pos);
                if (Math.abs(nums[iterator_i] + nums[l_pos] + nums[r_pos] - target) < Math.abs(min_diff))
                    min_diff = nums[iterator_i] + nums[l_pos] + nums[r_pos] - target;
                if (nums[iterator_i] + nums[l_pos] + nums[r_pos] - target < 0)
                    l_pos++;
                else
                    r_pos--;
            }
            iterator_i++;
        }
        return min_diff + target;
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
        List<String> list = new ArrayList<String>();
        String vocabulary[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsBacktrack(list, digits, 0, vocabulary, new StringBuilder());
        return list;
    }

    public static void letterCombinationsBacktrack(List<String> list, String digits, int position, String[] vocabulary, StringBuilder curr_elements)
    {
        if (position == digits.length()) {
            if (curr_elements.toString().length() > 0)
                list.add(curr_elements.toString());
            return;
        }
        for (int iterator_i = 0; iterator_i < vocabulary[digits.charAt(position) - 50].length(); iterator_i++) {
            curr_elements.append(vocabulary[digits.charAt(position) - 50].charAt(iterator_i));
            letterCombinationsBacktrack(list, digits, position + 1, vocabulary, curr_elements);
            curr_elements.deleteCharAt(curr_elements.length() - 1);
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
        if (s.length() == 0)
            return 0;
        int max_valid[] = new int[s.length()];
        for (int iterator_i = 1; iterator_i < s.length(); iterator_i++) {
            if (s.charAt(iterator_i) == ')' && s.charAt(iterator_i - 1) == '(')
                max_valid[iterator_i] = iterator_i < 2 ? 2 : Math.max(max_valid[iterator_i], max_valid[iterator_i - 2] + 2);
            else if (s.charAt(iterator_i) == ')' && s.charAt(iterator_i - 1) == ')' && iterator_i - 1 - max_valid[iterator_i - 1] >= 0 && s.charAt(iterator_i - 1 - max_valid[iterator_i - 1]) == '(')
                max_valid[iterator_i] = Math.max(max_valid[iterator_i], max_valid[iterator_i - 1] + 2 + ((iterator_i - 1 - max_valid[iterator_i - 1] > 0) ? max_valid[iterator_i - 2 - max_valid[iterator_i - 1]] : 0));
        }
        Arrays.sort(max_valid);
        return max_valid[max_valid.length - 1];
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
        if (s.length() == 0)
            return 0;
        int num_decodings[] = new int[s.length() + 1];
        num_decodings[0] = 1;
        num_decodings[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int iterator_i = 2; iterator_i < num_decodings.length; iterator_i++) {
            if (s.charAt(iterator_i - 1) != '0')
                num_decodings[iterator_i] = num_decodings[iterator_i - 1];
            if (s.charAt(iterator_i - 2) < '3' && (s.charAt(iterator_i - 2) == '2' ? s.charAt(iterator_i - 1) < '7' : true) && s.charAt(iterator_i - 2) != '0')
                num_decodings[iterator_i] += num_decodings[iterator_i - 2];
        }
        return num_decodings[num_decodings.length - 1];
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

    public static int findClosestposition(int[] arr, int value)
    {
        int lb = 0, ub = arr.length - 1, mid = 0;
        while (lb <= ub) {
            mid = (lb + ub) / 2;
            if (arr[mid] == value || (mid > 0 && arr[mid] > value && arr[mid - 1] < value) || (mid == 0 && arr[mid] > value))
                return mid;
            else if (arr[mid] < value)
                lb = mid + 1;
            else
                ub = mid - 1;
        }
        return mid;
    }

    public int findBestValue(int[] arr, int target)
    {
        Arrays.sort(arr);
        int lb = arr[0], ub = arr[arr.length - 1], sum_arr[] = new int[arr.length + 1], current_closest_val = Integer.MAX_VALUE, current_best_value = -1;
        for (int iterator_i = 1; iterator_i <= arr.length; iterator_i++)
            sum_arr[iterator_i] = sum_arr[iterator_i - 1] + arr[iterator_i - 1];
        if (target < arr[0] * arr.length)
            return (int) (Math.round(1.0 * target / arr.length));
        while (lb <= ub) {
            int mid = (lb + ub) / 2, pos_mid = findClosestposition(arr, mid);
            if (current_closest_val == Integer.MAX_VALUE || Math.abs(sum_arr[pos_mid] + (arr.length - pos_mid) * mid - target) < Math.abs(current_closest_val) || mid < current_best_value && Math.abs(sum_arr[pos_mid] + (arr.length - pos_mid) * mid - target) == Math.abs(current_closest_val)) {
                current_closest_val = sum_arr[pos_mid] + (arr.length - pos_mid) * mid - target;
                current_best_value = mid;
            }
            if (sum_arr[pos_mid] + (arr.length - pos_mid) * mid - target < 0)
                lb = mid + 1;
            else if (sum_arr[pos_mid] + (arr.length - pos_mid) * mid - target > 0)
                ub = mid - 1;
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

    public boolean isHappy(int n)
    {
        HashSet<String> hset = new HashSet<>();
        int new_number = 0;
        while (true) {
            char curr_temp[] = new char[1];
            int sum = 0;
            while (n != 0) {
                curr_temp[curr_temp.length - 1] = (char) (n % 10 + 48);
                sum += n % 10;
                curr_temp = Arrays.copyOf(curr_temp, curr_temp.length + 1);
                new_number += Math.pow((n % 10), 2);
                n /= 10;
            }
            if (sum == 1)
                return true;
            n = new_number;
            new_number = 0;
            Arrays.sort(curr_temp);
            if (!hset.add(new String(curr_temp)))
                return false;
            System.out.println(n + ":" + sum);
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
        if (val == -1)
            return input_treenode;
        input_treenode = new TreeNode(val);
        System.out.println("Left Node of " + val);
        input_treenode.left = create_binary_tree(input_treenode.left, sc);
        System.out.println("Right node of " + val);
        input_treenode.right = create_binary_tree(input_treenode.right, sc);
        return input_treenode;
    }

    public List<Integer> inorderTraversal(TreeNode root)
    {
        Stack node_stack = new Stack();
        List<Integer> list = new ArrayList<>();
        TreeNode current_node = root;
        while (!node_stack.empty() || current_node != null) {
            while (current_node != null) {
                node_stack.push(current_node);
                current_node = current_node.left;
            }
            while (current_node == null && !node_stack.empty()) {
                list.add(((TreeNode) (node_stack.peek())).val);
                System.out.print(((TreeNode) (node_stack.peek())).val + " ");
                current_node = ((TreeNode) (node_stack.pop())).right;
            }
        }
        return list;
    }

    /*
    41. PROBLEM DESCRIPTION (https://leetcode.com/problems/delete-nodes-and-return-forest/)
        Given the root of a binary tree, each node in the tree has a distinct value.

        After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
        Return the roots of the trees in the remaining forest.  You may return the result in any order.
    */

    public static boolean isForDeletion(int val, int[] del_arr)
    {
        for (int del_val : del_arr)
            if (del_val == val)
                return true;
        return false;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
    {
        List<TreeNode> list = new ArrayList<TreeNode>();
        delNodesHelper(root, to_delete, list, true);
        return list;
    }

    public static TreeNode delNodesHelper(TreeNode node, int[] to_delete, List<TreeNode> list, boolean is_root)
    {
        if (node == null)
            return null;
        if (is_root && !isForDeletion(node.val, to_delete))
            list.add(node);
        node.left = delNodesHelper(node.left, to_delete, list, isForDeletion(node.val, to_delete));
        node.right = delNodesHelper(node.right, to_delete, list, isForDeletion(node.val, to_delete));
        return isForDeletion(node.val, to_delete) ? null : node;
    }

    /*
    42. PROBLEM DESCRIPTION (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
        Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
        lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q)
    {
        Stack bfs_stack = new Stack();
        Map<TreeNode, TreeNode> parents_edges = new HashMap<TreeNode, TreeNode>();
        TreeNode current_node = root;
        bfs_stack.push(current_node);
        parents_edges.put(current_node, null);
        while (!parents_edges.containsKey(p) || !parents_edges.containsKey(q)) {
            current_node = (TreeNode) bfs_stack.pop();
            if (current_node.left != null) {
                bfs_stack.push(current_node.left);
                parents_edges.put(current_node.left, current_node);
                ;
            }
            if (current_node.right != null) {
                parents_edges.put(current_node.right, current_node);
                bfs_stack.push(current_node.right);
            }
        }
        HashSet<TreeNode> ancestor_path = new HashSet<>();
        ancestor_path.add(p);
        while (p != null && parents_edges.containsKey(p)) {
            p = parents_edges.get(p);
            ancestor_path.add(p);
        }
        while (!ancestor_path.contains(q))
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
        int dp_arr[][] = new int[2][nums.length], count = 0;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            dp_arr[0][iterator_i] = nums[iterator_i];
            if (nums[iterator_i] == k)
                count++;
        }
        for (int iterator_i = 1; iterator_i < nums.length; iterator_i++) {
            for (int iterator_j = iterator_i; iterator_j < nums.length; iterator_j++) {
                if (dp_arr[0][iterator_j - 1] + nums[iterator_j] == k)
                    count++;
                dp_arr[1][iterator_j] = dp_arr[0][iterator_j - 1] + nums[iterator_j];
            }
            dp_arr[0] = dp_arr[1].clone();
        }
        return count;
    }

    public int subarraySum(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            sum += nums[iterator_i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
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
        int current_sum = Integer.MIN_VALUE, max_till_now = Integer.MIN_VALUE;
        for (int curr_num : nums) {
            current_sum = (current_sum == Integer.MIN_VALUE || curr_num + current_sum < curr_num) ? curr_num : current_sum + curr_num;
            max_till_now = Math.max(max_till_now, current_sum);
        }
        return max_till_now;
    }

    /*
    45. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-palindromic-substring)
        Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

        Example 1:
        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
    */

    public String longestPalindrome_alt(String s) // O(n^2) time and space
    {
        if (s.length() == 0)
            return "";
        int dp_arr[][] = new int[s.length()][s.length()];
        String max_palindrome = "" + s.charAt(0);
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++)
            dp_arr[0][iterator_i] = 1;

        for (int iterator_i = 1; iterator_i < s.length(); iterator_i++) {
            for (int iterator_j = iterator_i; iterator_j < s.length(); iterator_j++) {
                dp_arr[iterator_i][iterator_j] = ((iterator_i > 1 ? dp_arr[iterator_i - 2][iterator_j - 1] == 1 : true) && s.charAt(iterator_j) == s.charAt(iterator_j - iterator_i)) ? 1 : 0;
                if (dp_arr[iterator_i][iterator_j] == 1)
                    max_palindrome = s.substring(iterator_j - iterator_i, iterator_j + 1);
            }
        }
        return max_palindrome;
    }

    public String longestPalindrome(String s) // O(n^2) time  O(1)space
    {
        String max_palindrome = "";
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++) {
            String curr_pal = expandFromCenterPalindrome(s, iterator_i, iterator_i);
            if (curr_pal.length() > max_palindrome.length())
                max_palindrome = curr_pal;
            if (iterator_i > 0 && s.charAt(iterator_i - 1) == s.charAt(iterator_i)) {
                curr_pal = expandFromCenterPalindrome(s, iterator_i - 1, iterator_i);
                if (curr_pal.length() > max_palindrome.length())
                    max_palindrome = curr_pal;
            }
        }
        return max_palindrome;
    }

    public static String expandFromCenterPalindrome(String s, int left, int right)
    {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
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
        ListNode slow_ptr = head, fast_ptr = head, prev_ptr = null;
        for (int iterator_i = 0; iterator_i < n; iterator_i++)
            fast_ptr = fast_ptr.next;
        while (fast_ptr != null) {
            int slide = 0;
            while (slide < n && fast_ptr != null) {
                fast_ptr = fast_ptr.next;
                slide++;
            }
            for (int iterator_i = 0; iterator_i < slide; iterator_i++) {
                prev_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
        }
        if (prev_ptr != null)
            prev_ptr.next = slow_ptr.next;
        else return head.next;
        return head;
    }

    public static ListNode create_linked_list(Scanner sc)
    {
        System.out.println("Enter number of items");
        int n = sc.nextInt();
        ListNode return_node = null, current_node = null;
        for (int iterator_i = 0; iterator_i < n; iterator_i++) {
            if (return_node == null) {
                current_node = new ListNode(sc.nextInt());
                return_node = current_node;
            } else {
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
        int left_ptr = 0, right_ptr = height.length - 1, max_area = Integer.MIN_VALUE;
        while (left_ptr < right_ptr) {
            System.out.println(left_ptr + " " + right_ptr);
            max_area = Math.max(max_area, Math.min(height[left_ptr], height[right_ptr]) * (right_ptr - left_ptr));
            if (height[left_ptr] < height[right_ptr])
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
        pos[0] = -1;
        pos[1] = -1;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            if (nums[iterator_i] == 0) {
                int temp = nums[pos[0] + 1];
                nums[++pos[0]] = nums[iterator_i];
                pos[1]++;
                if (temp == 1) {
                    int temp1 = nums[pos[1]];
                    nums[pos[1]] = temp;
                    temp = temp1;
                }
                if (temp == 2)
                    nums[iterator_i] = 2;
            } else if (nums[iterator_i] == 1) {
                int temp = nums[pos[1] + 1];
                nums[++pos[1]] = nums[iterator_i];
                if (temp == 2)
                    nums[iterator_i] = 2;
            }
            System.out.println(pos[0] + ":" + pos[1]);
            for (int iterator_k = 0; iterator_k < nums.length; iterator_k++)
                System.out.print(nums[iterator_k] + " ");
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
        int lb = 0, ub = nums.length - 1;
        int return_range[] = {-1, -1};
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (nums[mid] == target) {
                int front = mid, rear = mid;
                while (front >= 0 && nums[front] == target)
                    front--;
                while (rear < nums.length && nums[rear] == target)
                    rear++;
                return_range[0] = front + 1;
                return_range[1] = rear - 1;
                return return_range;
            } else if (nums[mid] > target && ((mid > 0 && nums[mid - 1] < target) || mid == 0))
                return return_range;
            else if (nums[mid] > target)
                ub = mid - 1;
            else
                lb = mid + 1;
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
        if (head == null)
            return head;
        Node temp = head;
        while (temp != null) {
            Node newnode = new Node(temp.val);
            newnode.next = temp.next;
            temp.next = newnode;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            temp.next.random = (temp.random == null) ? null : temp.random.next;
            ;
            temp = temp.next.next;
        }
        Node return_head = null, return_temp = null;
        temp = head;
        while (temp != null) {
            if (return_head == null) {
                return_head = temp.next;
                return_temp = return_head;
            } else {
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
    public int[] dailyTemperatures_alt(int[] T)
    { // O(N*W) Time  O(W+N) Space
        int temperature_record[] = new int[70];
        int return_result[] = new int[T.length];
        Arrays.fill(temperature_record, Integer.MAX_VALUE);
        for (int iterator_i = T.length - 1; iterator_i >= 0; iterator_i--) {
            int current_pos = Integer.MAX_VALUE, current_valid_temp_found = 0;
            for (int iterator_j = T[iterator_i] - 29; iterator_j < temperature_record.length && current_valid_temp_found < T.length - iterator_i - 1; iterator_j++) {
                if (temperature_record[iterator_j] != Integer.MAX_VALUE)
                    current_valid_temp_found++;
                if (temperature_record[iterator_j] < current_pos)
                    current_pos = temperature_record[iterator_j];
            }
            temperature_record[T[iterator_i] - 30] = iterator_i;
            return_result[iterator_i] = (current_pos == Integer.MAX_VALUE) ? 0 : current_pos - iterator_i;
        }
        return return_result;
    }

    public int[] dailyTemperatures(int[] T)
    {
        Stack temp_stack = new Stack();
        int return_result[] = new int[T.length];
        for (int iterator_i = T.length - 1; iterator_i >= 0; iterator_i--) {
            int next_ele = (temp_stack.empty()) ? -1 : (int) temp_stack.peek();
            while (!temp_stack.empty() && T[(int) temp_stack.peek()] <= T[iterator_i])
                next_ele = (int) temp_stack.pop();
            if (next_ele == -1 || temp_stack.isEmpty())
                return_result[iterator_i] = 0;
            else
                return_result[iterator_i] = (int) temp_stack.peek() - iterator_i;
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
        if (root == null)
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
        while (current_node != null) {
            if (current_node.left != null)
                treenode_stack.push(current_node.left);
            if (current_node.right != null)
                treenode_stack.push(current_node.right);
            TreeNode temp = current_node.left;
            current_node.left = current_node.right;
            current_node.right = temp;

            current_node = treenode_stack.empty() ? null : (TreeNode) treenode_stack.pop();
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
        while (fast_ptr != null) {
            if (fast_ptr.next == null)
                return false;
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if (fast_ptr == slow_ptr)
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
        while (fast_ptr != null) {
            if (fast_ptr.next == null)
                break;
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if (fast_ptr == slow_ptr) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle)
            return null;

        slow_ptr = head;
        while (slow_ptr != fast_ptr) {
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
        if (head == null || head.next == null)
            return true;
        ListNode first = head;
        int count = 0;
        while (first != null) {
            first = first.next;
            count++;
        }
        first = head;
        for (int iterator_i = 0; iterator_i < Math.ceil(count / 2.0) - 1; iterator_i++)
            first = first.next;

        ListNode prev_node = first;
        first = first.next;
        for (int iterator_i = 0; iterator_i < Math.floor(count / 2.0); iterator_i++) {
            ListNode next_node = first.next;
            first.next = prev_node;
            prev_node = first;
            if (next_node != null)
                first = next_node;
        }
        for (int iterator_i = 0; iterator_i < Math.floor(count / 2.0); iterator_i++) {
            if (head.val != first.val)
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
        int current_ele = 0, count_majority = 0;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            if (count_majority == 0) {
                current_ele = nums[iterator_i];
                count_majority = 1;
            } else if (current_ele == nums[iterator_i])
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
        for (int num : nums) {
            pqueue.offer(num);
            while (pqueue.size() > k)
                pqueue.poll();
        }
        return (int) pqueue.peek();
    }

    public int findKthLargest(int[] nums, int k)
    {
        int lb = 0, ub = nums.length - 1;
        k = nums.length - k;
        while (lb <= ub) {
            int s = findKthPartition(nums, lb, ub);
            if (s < k)
                lb = s + 1;
            else if (s > k)
                ub = s - 1;
            else
                return nums[s];
        }
        return -1;
    }

    public static int findKthPartition(int[] nums, int lb, int ub)
    {
        int i = lb + 1, j = ub;
        while (i <= j) {
            while (i <= ub && nums[lb] > nums[i])
                i++;
            while (j >= i && nums[j] >= nums[lb])
                j--;

            if (i < j) {
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
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
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
        for (int iterator_i = 0; iterator_i < board.length; iterator_i++)
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++)
                updateLivingCondition(board, iterator_i, iterator_j);

        for (int iterator_i = 0; iterator_i < board.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++) {
                if (board[iterator_i][iterator_j] == 2)
                    board[iterator_i][iterator_j] = 1;
                else if (board[iterator_i][iterator_j] == -1)
                    board[iterator_i][iterator_j] = 0;
            }
        }
        for (int iterator_i = 0; iterator_i < board.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++)
                System.out.print(board[iterator_i][iterator_j] + " ");
            System.out.println();
        }
    }

    public static void updateLivingCondition(int[][] board, int row, int col)
    {
        int offset[] = {-1, 0, 1}, count_active_neighbors = 0;
        for (int iterator_i = 0; iterator_i < offset.length; iterator_i++) {

            for (int iterator_j = 0; iterator_j < offset.length; iterator_j++) {
                if (row + offset[iterator_i] < 0 || row + offset[iterator_i] >= board.length || col + offset[iterator_j] < 0 || col + offset[iterator_j] >= board[0].length || (iterator_i == 1 && iterator_j == 1))
                    continue;
                if (board[row + offset[iterator_i]][col + offset[iterator_j]] == 1 || board[row + offset[iterator_i]][col + offset[iterator_j]] == -1)
                    count_active_neighbors++;
            }
        }
        if (board[row][col] == 1) {
            if (count_active_neighbors < 2 || count_active_neighbors > 3)
                board[row][col] = -1;
        } else {
            if (count_active_neighbors == 3)
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
    int max_dia = 0;

    public int diameterOfBinaryTree(TreeNode root)
    {
        depth(root);
        return max_dia;
    }

    public int depth(TreeNode root)
    {
        if (root == null)
            return 0;
        int lheight = depth(root.left);
        int rheight = depth(root.right);
        max_dia = Math.max(max_dia, lheight + rheight);
        return 1 + Math.max(lheight, rheight);
    }

    /*
    60. PROBLEM DESCRIPTION (https://leetcode.com/problems/intersection-of-two-linked-lists/)
        Write a program to find the node at which the intersection of two singly linked lists begins.

    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode list1 = headA, list2 = headB;
        if (headA == null || headB == null)
            return null;
        boolean cycle_completed = false;
        while (list1 != list2) {
            if (list1.next == null) {
                if (cycle_completed)
                    return null;
                list1 = headB;
                cycle_completed = true;
            } else
                list1 = list1.next;

            if (list2.next == null)
                list2 = headA;
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
        if (head == null)
            return head;
        ListNode prev_node = head, next_node = head.next;
        prev_node.next = null;
        while (next_node != null) {
            ListNode temp = next_node.next;
            next_node.next = prev_node;
            prev_node = next_node;
            next_node = temp;
        }
        return prev_node;
    }

    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
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
        int max_prev1 = 0, max_prev2 = 0;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            int temp = max_prev1;
            max_prev1 = Math.max(max_prev2 + nums[iterator_i], max_prev1);
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
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++)
            nums[Math.abs(nums[iterator_i]) - 1] = Math.min(nums[Math.abs(nums[iterator_i]) - 1], -nums[Math.abs(nums[iterator_i]) - 1]);
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            if (nums[iterator_i] > 0) {
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
        return findTargetSumWays_dp(nums, S);


        // Memoization and Recursion
//        int mem_arr[][] = new int[nums.length][2001];
//        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
//            Arrays.fill(mem_arr[iterator_i], Integer.MIN_VALUE);
//        return findTargetSumWays_memoization(nums,S,0,0,mem_arr);

        //Recursive
//        return findTargetSumWays_rcur(nums,S,0,0);
    }

    public static int findTargetSumWays_rcur(int[] nums, int sum, int position, int current_sum)
    {
        if (position == nums.length) {
            if (sum == current_sum)
                return 1;
            return 0;
        }
        return (findTargetSumWays_rcur(nums, sum, position + 1, current_sum + nums[position]) +
                findTargetSumWays_rcur(nums, sum, position + 1, current_sum - nums[position]));
    }

    public static int findTargetSumWays_memoization(int nums[], int sum, int position, int current_sum, int[][] mem_arr)
    {
        if (position < nums.length && mem_arr[position][current_sum + 1000] != Integer.MIN_VALUE)
            return mem_arr[position][current_sum + 1000];
        if (position == nums.length) {
            if (current_sum == sum)
                return 1;
            return 0;
        }
        mem_arr[position][current_sum + 1000] = findTargetSumWays_memoization(nums, sum, position + 1, current_sum + nums[position], mem_arr) + findTargetSumWays_memoization(nums, sum, position + 1, current_sum - nums[position], mem_arr);
        return mem_arr[position][current_sum + 1000];
    }

    public static int findTargetSumWays_dp(int[] nums, int sum)
    {
        int max_sum = 0;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++)
            max_sum += nums[iterator_i];
        int dp_prev[] = new int[max_sum * 2 + 1], dp_curr[] = new int[max_sum * 2 + 1];
        Arrays.fill(dp_prev, Integer.MIN_VALUE);

        dp_prev[max_sum + nums[0]] = 1;
        dp_prev[max_sum - nums[0]] = dp_prev[max_sum - nums[0]] == Integer.MIN_VALUE ? 1 : 2;

        for (int iterator_i = 1; iterator_i < nums.length; iterator_i++) {
            Arrays.fill(dp_curr, Integer.MIN_VALUE);
            for (int iterator_j = 0; iterator_j < max_sum * 2 + 1; iterator_j++) {
                if (dp_prev[iterator_j] != Integer.MIN_VALUE) {
                    dp_curr[iterator_j + nums[iterator_i]] = ((dp_curr[iterator_j + nums[iterator_i]] == Integer.MIN_VALUE) ? dp_prev[iterator_j] : (dp_curr[iterator_j + nums[iterator_i]] + dp_prev[iterator_j]));
                    dp_curr[iterator_j - nums[iterator_i]] = ((dp_curr[iterator_j - nums[iterator_i]] == Integer.MIN_VALUE) ? dp_prev[iterator_j] : (dp_curr[iterator_j - nums[iterator_i]] + dp_prev[iterator_j]));
                }
            }
            dp_prev = Arrays.copyOf(dp_curr, dp_curr.length);
        }
        return (sum > max_sum || dp_prev[sum + max_sum] == Integer.MIN_VALUE) ? 0 : dp_prev[sum + max_sum];
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
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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

    public void flatten(TreeNode root)
    {
        if (root == null)
            return;
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
        subsetsSpace(nums, new ArrayList<>(), 0, list);
        return null;
    }

    public static void subsetsSpace(int[] nums, List<Integer> current_set, int position, List<List<Integer>> list)
    {
        if (position == nums.length) {
            list.add(new ArrayList<>(current_set));
            return;
        }
        subsetsSpace(nums, current_set, position + 1, list);
        current_set.add(nums[position]);
        subsetsSpace(nums, current_set, position + 1, list);
        current_set.remove(current_set.size() - 1);
    }

    /*
    69. PROBLEM DESCRIPTION (https://leetcode.com/problems/symmetric-tree/)
        Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    */
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right)
    {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return isSymmetricHelper(left.left, left.right) && isSymmetricHelper(right.left, right.right) && left.val == right.val;
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
        subsetsWithDupSpace(nums, list, new ArrayList<Integer>(), 0);
        return list;
    }


    public void subsetsWithDupSpace(int[] nums, List<List<Integer>> list, List<Integer> current_set, int position)
    {
        if (position == nums.length) {
            list.add(new ArrayList<>(current_set));
            return;
        }
        current_set.add(nums[position]);
        subsetsWithDupSpace(nums, list, current_set, ++position);
        current_set.remove(current_set.size() - 1);
        while (position < nums.length && nums[position] == nums[position - 1])
            position++;
        subsetsWithDupSpace(nums, list, current_set, position);
    }

    public List<List<Integer>> subsetsWithDup_iter(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        list.add(new ArrayList<>());
        int count = 0;
        for (int i = 0; i < nums.length; i += count) {
            count = 0;
            while (i + count < nums.length && nums[i + count] == nums[i])
                count++;
            int count_prev_sets = list.size();
            for (int subset_iterator = 0; subset_iterator < count_prev_sets; subset_iterator++) {
                List<Integer> prev_set = new ArrayList<>(list.get(subset_iterator));
                for (int addition_iterator = 0; addition_iterator < count; addition_iterator++) {
                    prev_set.add(nums[i + addition_iterator]);
                    list.add(new ArrayList<>(prev_set));
                    for (Integer setval : prev_set)
                        System.out.print(setval + " ");
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
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            if (zero_pos <= iterator_i)
                return false;
            while (zero_pos < nums.length) {
                if (nums[iterator_i] + iterator_i >= zero_pos)
                    zero_pos++;
                else
                    break;
            }
            if (zero_pos == nums.length)
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
        HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
        String key;
        int count[] = new int[26];
        for (int iterator_i = 0; iterator_i < strs.length; iterator_i++) {
            Arrays.fill(count, 0);
            for (int iterator_j = 0; iterator_j < strs[iterator_i].length(); iterator_j++)
                count[strs[iterator_i].charAt(iterator_j) - 'a']++;
            key = Arrays.toString(count);
            if (hmap.containsKey(key)) {
                List<String> curr_list = hmap.get(key);
                curr_list.add(strs[iterator_i]);
            } else
                hmap.put(key, new ArrayList<>(Arrays.asList(strs[iterator_i])));
        }
        return new ArrayList<>(hmap.values());
    }

    /*
    73. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-paths/)
        A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of
        the grid (marked 'Finish' in the diagram below).

        How many possible unique paths are there?

        Example 1:
            Input: m = 3, n = 2
            Output: 3
            Explanation:
                From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
                1. Right -> Right -> Down
                2. Right -> Down -> Right
                3. Down -> Right -> Right

        Example 2:
            Input: m = 7, n = 3
            Output: 28

        Constraints:
            1 <= m, n <= 100
            It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
    */
    public int uniquePaths_alt(int m, int n) // TLE
    {
        int dp_prev[][] = new int[m][n], dp_next[][] = new int[m][n];
        dp_prev[0][0] = 1;
        HashSet<String> current_set = new HashSet<String>(), next_set;
        current_set.add("00");
        while (current_set.size() != 1 || !current_set.contains((m - 1) + "" + (n - 1))) {
            next_set = new HashSet<String>();
            for (String s : current_set) {
                int i = s.charAt(0) - '0', j = s.charAt(1) - '0';
                if (i < m - 1) {
                    dp_next[i + 1][j] += dp_prev[i][j];
                    next_set.add(((i + 1) + "" + j));
                }
                if (j < n - 1) {
                    dp_next[i][j + 1] += dp_prev[i][j];
                    next_set.add(i + "" + (j + 1));
                }
            }
            current_set = (HashSet<String>) next_set.clone();
            for (int iterator_i = 0; iterator_i < m; iterator_i++) {
                dp_prev[iterator_i] = Arrays.copyOf(dp_next[iterator_i], dp_next[iterator_i].length);
                Arrays.fill(dp_next[iterator_i], 0);
            }

        }
        return dp_prev[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n)
    {
        int curr[] = new int[n];
        Arrays.fill(curr, 1);
        for (int iterator_i = 1; iterator_i < m; iterator_i++)
            for (int iterator_j = 1; iterator_j < n; iterator_j++)
                curr[iterator_j] = curr[iterator_j] + curr[iterator_j - 1];
        return curr[n - 1];
    }

    /*
    74. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-path-sum/)
        Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.

        Example:
        Input:
        [
            [1,3,1],
            [1,5,1],
            [4,2,1]
        ]
        Output: 7
        Explanation: Because the path 1→3→1→1→1 minimizes the sum.
    */
    public int minPathSum(int[][] grid)
    {
        int dp_next[] = Arrays.copyOf(grid[0], grid[0].length);
        for (int iterator_i = 1; iterator_i < dp_next.length; iterator_i++)
            dp_next[iterator_i] += dp_next[iterator_i - 1];
        for (int iterator_i = 1; iterator_i < grid.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < grid[0].length; iterator_j++)
                dp_next[iterator_j] = grid[iterator_i][iterator_j] + Math.min(dp_next[iterator_j], (iterator_j == 0 ? Integer.MAX_VALUE : dp_next[iterator_j - 1]));
        }
        return dp_next[dp_next.length - 1];
    }

    /*
    75. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-level-order-traversal/)
        Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

        For example:
        Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
        return its level order traversal as:
        [
          [3],
          [9,20],
          [15,7]
        ]
    */
    public List<List<Integer>> levelOrder_iter(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int nodes_in_level;
        queue.add(root);
        while (!queue.isEmpty()) {
            int iterator_level = 0;
            nodes_in_level = queue.size();
            List<Integer> current_level_list = new ArrayList<Integer>();
            while (iterator_level < nodes_in_level) {
                TreeNode curr_node = queue.remove();
                if (curr_node != null) {
                    current_level_list.add(curr_node.val);
                    if (curr_node.left != null)
                        queue.add(curr_node.left);
                    if (curr_node.right != null)
                        queue.add(curr_node.right);
                }
                iterator_level++;
            }
            list.add(new ArrayList<>(current_level_list));
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        levelOrderRcurSpace(root, list, 0);
        return list;
    }

    public static void levelOrderRcurSpace(TreeNode root, List<List<Integer>> list, int height)
    {
        if (root == null)
            return;
        if (height == list.size())
            list.add(new ArrayList<>());
        list.get(height).add(root.val);

        levelOrderRcurSpace(root.left, list, height + 1);
        levelOrderRcurSpace(root.right, list, height + 1);
    }

    /*
    76. PROBLEM DESCRIPTION (https://leetcode.com/problems/validate-binary-search-tree/)
        Given a binary tree, determine if it is a valid binary search tree (BST).

        Assume a BST is defined as follows:
        1. The left subtree of a node contains only nodes with keys less than the node's key.
        2. The right subtree of a node contains only nodes with keys greater than the node's key.
        3. Both the left and right subtrees must also be binary search trees.
    */
    public boolean isValidBST(TreeNode root)
    {
        return isValidBSTHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public static boolean isValidBSTHelper(TreeNode root, long max_allowed, long min_allowed)
    {
        if (root == null)
            return true;

        if (root.val < max_allowed && root.val > min_allowed) {
            Long max_allowed_new = Math.min(max_allowed, root.val);
            Long min_allowed_new = Math.max(min_allowed, root.val);
            return isValidBSTHelper(root.left, max_allowed_new, min_allowed) && isValidBSTHelper(root.right, max_allowed, min_allowed_new);
        }
        return false;
    }

    /*
    77. PROBLEM DESCRIPTION (https://leetcode.com/problems/word-search/)
        Given a 2D board and a word, find if the word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
        vertically neighboring. The same letter cell may not be used more than once.

        Example:
            board =
                [
                    ['A','B','C','E'],
                    ['S','F','C','S'],
                    ['A','D','E','E']
                ]

            Given word = "ABCCED", return true.
            Given word = "SEE", return true.
            Given word = "ABCB", return false.


        Constraints:
        1. board and word consists only of lowercase and uppercase English letters.
        2. 1 <= board.length <= 200
        3. 1 <= board[i].length <= 200
        4. 1 <= word.length <= 10^3
    */
    public boolean exist(char[][] board, String word)
    {
        for (int iterator_i = 0; iterator_i < board.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++) {
                if (existRcurSpace(board, word, 0, iterator_i, iterator_j))
                    return true;
            }
        }
        return false;
    }

    public static boolean existRcurSpace(char[][] board, String word, int word_pos, int board_x, int board_y)
    {
        boolean existence_found = false;
        if (board_x < 0 || board_x == board.length || board_y < 0 || board_y == board[0].length || board[board_x][board_y] != word.charAt(word_pos))
            return false;
        if (word_pos == word.length() - 1)
            return true;

        board[board_x][board_y] ^= 256;
        existence_found = (existRcurSpace(board, word, word_pos + 1, board_x - 1, board_y) ||
                existRcurSpace(board, word, word_pos + 1, board_x, board_y - 1) ||
                existRcurSpace(board, word, word_pos + 1, board_x + 1, board_y) ||
                existRcurSpace(board, word, word_pos + 1, board_x, board_y + 1));
        board[board_x][board_y] ^= 256;
        return existence_found;
    }

    /*
    78. PROBLEM DESCRIPTION (https://leetcode.com/problems/contains-duplicate/)
        Given an array of integers, find if the array contains any duplicates.

        Your function should return true if any value appears at least twice in the array, and it should return false if every element is
        distinct.

        Example 1:
            Input: [1,2,3,1]
            Output: true

            Example 2:
            Input: [1,2,3,4]
            Output: false
    */
    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++)
            if (!set.add(nums[iterator_i]))
                return true;
        return false;
    }

    /*
    79. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-primes/)
        Count the number of prime numbers less than a non-negative number, n.

        Example:
            Input: 10
            Output: 4
            Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
    */
    public int countPrimes(int n)
    {
        if (n < 3)
            return 0;
        boolean prime_arr[] = new boolean[n];
        int count = n / 2;
        for (int iterator_i = 3; iterator_i * iterator_i < n; iterator_i += 2) {
            if (!prime_arr[iterator_i]) {
                for (int j = iterator_i * iterator_i; j < n; j += 2 * iterator_i) {
                    if (!prime_arr[j]) {
                        prime_arr[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    /*
    80. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-islands/)
        Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by
        connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

        Example 1:
        Input:
            11110
            11010
            11000
            00000
        Output: 1

        Example 2:
        Input:
            11000
            11000
            00100
            00011
        Output: 3
    */
    public int numIslands(char[][] grid)
    {
        int count_islands = 0;
        for (int iterator_i = 0; iterator_i < grid.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < grid[0].length; iterator_j++) {
                if (grid[iterator_i][iterator_j] == '1') {
                    sinkIsland(grid, iterator_i, iterator_j);
                    count_islands++;
                }
            }
        }
        return count_islands;
    }

    public static void sinkIsland(char[][] grid, int pos_row, int pos_col)
    {
        if (pos_col < 0 || pos_col == grid[0].length || pos_row < 0 || pos_row == grid.length || grid[pos_row][pos_col] == '0')
            return;
        grid[pos_row][pos_col] = '0';
        sinkIsland(grid, pos_row - 1, pos_col);
        sinkIsland(grid, pos_row + 1, pos_col);
        sinkIsland(grid, pos_row, pos_col - 1);
        sinkIsland(grid, pos_row, pos_col + 1);
    }

    /*
    81. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-peak-element/)
        A peak element is an element that is greater than its neighbors.
        Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
        You may imagine that nums[-1] = nums[n] = -∞.

        Example 1:
        Input: nums = [1,2,3,1]
        Output: 2
        Explanation: 3 is a peak element and your function should return the index number 2.

        Example 2:
        Input: nums = [1,2,1,3,5,6,4]
        Output: 1 or 5
        Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
    */
    public int findPeakElement(int[] nums)
    {
        int lb = 0, ub = nums.length - 1, mid;
        while (lb <= ub) {
            mid = (lb + ub) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid])
                ub = mid - 1;
            else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid])
                lb = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /*
    82. PROBLEM DESCRIPTION (https://leetcode.com/problems/fizz-buzz/)
        Write a program that outputs the string representation of numbers from 1 to n.
        But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers
        which are multiples of both three and five output “FizzBuzz”.

        Example:
        n = 15,
        Return:
        [
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz"
        ]
    */
    public List<String> fizzBuzz(int n)
    {
        List<String> list = new ArrayList<>();
        HashMap<Integer, String> divisibility_ruleset = new HashMap();
        divisibility_ruleset.put(3, "Fizz");
        divisibility_ruleset.put(5, "Buzz");
        for (int i = 1; i <= n; i++) {
            String curr_string = "";
            for (Integer div_rule : divisibility_ruleset.keySet())
                if (i % div_rule == 0)
                    curr_string += divisibility_ruleset.get(div_rule);

            if (curr_string.length() == 0)
                list.add(i + "");
            else
                list.add(curr_string);
        }
        return list;
    }

    /*
    83. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
        Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

        Note that it is the kth smallest element in the sorted order, not the kth distinct element.

        Example:
        matrix = [
            [ 1,  5,  9],
            [10, 11, 13],
            [12, 13, 15]
        ],
        k = 8,
        return 13.

        Note: You may assume k is always valid, 1 ≤ k ≤ n2.
    */
    public int kthSmallest_alt(int[][] matrix, int k)
    {
        PriorityQueue<Tuple> prio_queue = new PriorityQueue<Tuple>();
        for (int iterator_i = 0; iterator_i < matrix[0].length; iterator_i++)
            prio_queue.add(new Tuple(0, iterator_i, matrix[0][iterator_i]));

        for (int iterator_i = 1; iterator_i < k; iterator_i++) {
            Tuple lowestEle = prio_queue.poll();
            if (lowestEle.pos_x == matrix.length - 1)
                continue;
            prio_queue.add(new Tuple(lowestEle.pos_x + 1, lowestEle.pos_y, matrix[lowestEle.pos_x + 1][lowestEle.pos_y]));
        }
        return prio_queue.peek().val;
    }

    static int closest_val, far_val;

    public int kthSmallest(int[][] matrix, int k)
    {
        int lb = matrix[0][0], ub = matrix[matrix.length - 1][matrix[0].length - 1], mid, count_lesser;
        while (lb < ub) {
            mid = lb + (ub - lb) / 2;
            count_lesser = count_for_kthSmallest(matrix, mid);
            if (count_lesser > k)
                ub = mid - closest_val;
            else if (count_lesser < k)
                lb = mid + far_val;
            else
                return mid - closest_val;
        }
        return lb;
    }

    public static int count_for_kthSmallest(int matrix[][], int mid)
    {
        closest_val = Integer.MAX_VALUE;
        far_val = Integer.MAX_VALUE;
        int count = 0;
        for (int iterator_i = 0; iterator_i < matrix.length; iterator_i++) {
            int iterator_j = 0;
            while (iterator_j < matrix[0].length && matrix[iterator_i][iterator_j] <= mid) {
                closest_val = Math.min(closest_val, mid - matrix[iterator_i][iterator_j]);
                iterator_j++;
                count++;
            }
            while (iterator_j < matrix[0].length) {
                far_val = Math.min(far_val, matrix[iterator_i][iterator_j] - mid);
                iterator_j++;
            }
        }
        return count;
    }

    /*
    84. PROBLEM DESCRIPTION (https://leetcode.com/problems/odd-even-linked-list/)
        Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
        talking about the node number and not the value in the nodes.
        You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

        Example 1:
            Input: 1->2->3->4->5->NULL
            Output: 1->3->5->2->4->NULL

        Example 2:
            Input: 2->1->3->5->6->4->7->NULL
            Output: 2->3->6->7->1->5->4->NULL

        Note:
        1. The relative order inside both the even and odd groups should remain as it was in the input.
        2. The first node is considered odd, the second node even and so on
    */
    public ListNode oddEvenList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        int count = 0;
        ListNode odd_ptr_tail = head, even_ptr_tail = head.next, curr_ptr = head.next.next;
        while (curr_ptr != null) {
            if (count % 2 == 0) //Odd Sequence
            {
                even_ptr_tail.next = curr_ptr.next;
                curr_ptr.next = odd_ptr_tail.next;
                odd_ptr_tail.next = curr_ptr;
                odd_ptr_tail = odd_ptr_tail.next;
            } else
                even_ptr_tail = even_ptr_tail.next;
            curr_ptr = even_ptr_tail.next;
            count++;
        }
        return head;
    }

    /*
    85. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-the-duplicate-number/)
        Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

        Example 1:
            Input: [1,3,4,2,2]
            Output: 2

        Example 2:
            Input: [3,1,3,4,2]
            Output: 3

        Note:
        1. You must not modify the array (assume the array is read only).
        2. You must use only constant, O(1) extra space.
        3. Your runtime complexity should be less than O(n^2).
        4. There is only one duplicate number in the array, but it could be repeated more than once.
    */
    public int findDuplicate(int[] nums)
    {
        int slow_ptr = nums[0], fast_ptr = nums[0];
        do {
            slow_ptr = nums[slow_ptr];
            fast_ptr = nums[nums[fast_ptr]];
        } while (slow_ptr != fast_ptr);

        // Since Cycle formed, get point of intersection
        slow_ptr = nums[0];
        while (slow_ptr != fast_ptr) {
            slow_ptr = nums[slow_ptr];
            fast_ptr = nums[fast_ptr];
        }

        return slow_ptr;
    }

    /*
    86. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-anagram/)
        Given two strings s and t , write a function to determine if t is an anagram of s.

        Example 1:
            Input: s = "anagram", t = "nagaram"
            Output: true

        Example 2:
            Input: s = "rat", t = "car"
            Output: false

        Note:
            You may assume the string contains only lowercase alphabets.
    */
    public boolean isAnagram(String s, String t)
    { // Generic Solution Use
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> char_hmap = new HashMap<>();
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++)
            char_hmap.put(s.charAt(iterator_i), char_hmap.getOrDefault(s.charAt(iterator_i), 0) + 1);

        for (int iterator_i = 0; iterator_i < t.length(); iterator_i++) {
            int new_val = char_hmap.getOrDefault(t.charAt(iterator_i), -1);
            if (new_val <= 0)
                return false;
            if (new_val > 1)
                char_hmap.put(t.charAt(iterator_i), new_val - 1);
            else
                char_hmap.remove(t.charAt(iterator_i));
        }
        if (char_hmap.isEmpty())
            return true;
        return false;
    }

    /*
    87. PROBLEM DESCRIPTION (https://leetcode.com/problems/product-of-array-except-self/)
        Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all
        the elements of nums except nums[i].

        Example:
        Input:  [1,2,3,4]
        Output: [24,12,8,6]
        Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

        Note: Solve it without division and in O(n) time and O(1) space.
    */
    public int[] productExceptSelf(int[] nums)
    {
        int result_arr[] = new int[nums.length];
        result_arr[0] = 1;
        // Store product from left of element
        for (int iterator_i = 1; iterator_i < nums.length; iterator_i++)
            result_arr[iterator_i] = result_arr[iterator_i - 1] * nums[iterator_i - 1];

        // Combine result with right products
        int curr_right_product = 1;
        for (int iterator_i = nums.length - 1; iterator_i >= 0; iterator_i--) {
            result_arr[iterator_i] *= curr_right_product;
            curr_right_product *= nums[iterator_i];
        }
        return result_arr;
    }

    /*
    88. PROBLEM DESCRIPTION (https://leetcode.com/problems/factorial-trailing-zeroes/)
        Given an integer n, return the number of trailing zeroes in n!.

        Example 1:
        Input: 3
        Output: 0
        Explanation: 3! = 6, no trailing zero.

        Example 2:
        Input: 5
        Output: 1
        Explanation: 5! = 120, one trailing zero.

        Note: Your solution should be in logarithmic time complexity.
    */
    public int trailingZeroes(int n)
    {
        int count = 0;
        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }
        return count;
    }

    /*
    89. PROBLEM DESCRIPTION (https://leetcode.com/problems/basic-calculator-ii/)
        Implement a basic calculator to evaluate a simple expression string.

        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division
        should truncate toward zero.

        Example 1:
            Input: "3+2*2"
            Output: 7

        Example 2:
            Input: " 3/2 "
            Output: 1

        Example 3:
            Input: " 3+5 / 2 "
            Output: 5
    */
    public int calculate_alt(String s) //Stack Approach
    {
        Stack<Integer> operator_stack = new Stack<>();
        Stack<Character> operand_stack = new Stack<>();
        int iterator_i = 0;
        while (iterator_i < s.length()) {
            char c = s.charAt(iterator_i);
            if (c == ' ' || c == '\t') {
                iterator_i++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                int next_num = 0;
                while (iterator_i < s.length() && s.charAt(iterator_i) >= '0' && s.charAt(iterator_i) <= '9') {
                    c = s.charAt(iterator_i);
                    next_num = next_num * 10 + (int) (c - '0');
                    iterator_i++;
                }
                operator_stack.push(next_num);
            } else //Operand
            {
                if (operand_stack.isEmpty() || isPriorityHigher(operand_stack.peek(), c))
                    operand_stack.push(c);
                else {
                    while (!operand_stack.isEmpty() && !isPriorityHigher(operand_stack.peek(), c)) {
                        int operator2 = operator_stack.pop();
                        int operator1 = operator_stack.pop();
                        char ch = operand_stack.pop();

                        switch (ch) {
                            case '+':
                                operator_stack.push(operator1 + operator2);
                                break;
                            case '-':
                                operator_stack.push(operator1 - operator2);
                                break;
                            case '*':
                                operator_stack.push(operator1 * operator2);
                                break;
                            case '/':
                                operator_stack.push(operator1 / operator2);
                                break;
                        }
                    }
                    operand_stack.push(c);
                }
                iterator_i++;
            }
        }
        while (!operand_stack.empty()) {
            int operator2 = operator_stack.pop();
            int operator1 = operator_stack.pop();
            char c = operand_stack.pop();
            switch (c) {
                case '+':
                    operator_stack.push(operator1 + operator2);
                    break;
                case '-':
                    operator_stack.push(operator1 - operator2);
                    break;
                case '*':
                    operator_stack.push(operator1 * operator2);
                    break;
                case '/':
                    operator_stack.push(operator1 / operator2);
                    break;
            }
        }
        return operator_stack.pop();
    }

    public static boolean isPriorityHigher(char stack_top, char current_operand)
    {
        if ((stack_top == '+' || stack_top == '-') && (current_operand == '*' || current_operand == '/'))
            return true;
        return false;
    }

    public int calculate(String s)
    {
        char sign = '+';
        int result_till_now = 0, prev_add = 0, curr_num = 0;
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++) {
            char c = s.charAt(iterator_i);
            if (Character.isDigit(c))
                curr_num = curr_num * 10 + (int) (s.charAt(iterator_i) - '0');

            if ("*/+-".contains(c + "") || iterator_i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        prev_add = curr_num;
                        break;
                    case '-':
                        prev_add = -curr_num;
                        break;
                    case '*':
                        result_till_now -= prev_add;
                        prev_add *= curr_num;
                        break;
                    case '/':
                        result_till_now -= prev_add;
                        prev_add /= curr_num;
                }
                sign = c;
                curr_num = 0;
                result_till_now += prev_add;
            }
        }
        return result_till_now;
    }

    /*
    90. PROBLEM DESCRIPTION (https://leetcode.com/problems/search-a-2d-matrix-ii/)
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
        1. Integers in each row are sorted in ascending from left to right.
        2. Integers in each column are sorted in ascending from top to bottom.

        Example:
        Consider the following matrix:
        [
            [1,   4,  7, 11, 15],
            [2,   5,  8, 12, 19],
            [3,   6,  9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30]
        ]
        Given target = 5, return true.
        Given target = 20, return false.
    */
    public boolean searchMatrix(int[][] matrix, int target) //BST from top right position
    {
        if (matrix.length == 0)
            return false;
        int curr_row = 0, curr_col = matrix[0].length - 1;
        while (curr_col >= 0 && curr_row < matrix.length) {
            if (target < matrix[curr_row][curr_col])
                curr_col--;
            else if (target > matrix[curr_row][curr_col])
                curr_row++;
            else
                return true;
        }
        return false;
    }

    /*
    91. PROBLEM DESCRIPTION (https://leetcode.com/problems/delete-node-in-a-linked-list/)
        Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

        Example 1:
        Input: head = [4,5,1,9], node = 5
        Output: [4,1,9]
        Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
    */
    public void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /*
    92. PROBLEM DESCRIPTION (https://leetcode.com/problems/course-schedule/)
        There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as
        a pair: [0,1]
        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

        Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.

        Example 2:
        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
    */
    public boolean canFinish_alt(int numCourses, int[][] prerequisites) //Topological Sorting
    {
        int adj_matrix[][] = new int[numCourses][numCourses];
        int in_degree[] = new int[numCourses];
        for (int iterator_i = 0; iterator_i < prerequisites.length; iterator_i++) {
            adj_matrix[prerequisites[iterator_i][1]][prerequisites[iterator_i][0]] = 1;
            in_degree[prerequisites[iterator_i][0]]++;
        }
        Queue bfs_q = new LinkedList();
        for (int iterator_i = 0; iterator_i < numCourses; iterator_i++)
            if (in_degree[iterator_i] == 0)
                bfs_q.add(iterator_i);

        int count_visited = 0;
        while (!bfs_q.isEmpty()) {
            count_visited++;
            int current_vertex = (int) bfs_q.poll();
            for (int iterator_i = 0; iterator_i < numCourses; iterator_i++) {
                if (adj_matrix[current_vertex][iterator_i] == 1) {
                    if (in_degree[iterator_i] == 1)
                        bfs_q.add(iterator_i);
                    else
                        in_degree[iterator_i]--;
                }
            }
        }
        return count_visited == numCourses;

    }

    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) // Cycle Detection
    {
        int visited[] = new int[numCourses];
        int adj_matrix[][] = new int[numCourses][numCourses];
        boolean checked_for_cycles[] = new boolean[numCourses];
        for (int iterator_i = 0; iterator_i < prerequisites.length; iterator_i++)
            adj_matrix[prerequisites[iterator_i][1]][prerequisites[iterator_i][0]] = 1;

        for (int iterator_i = 0; iterator_i < numCourses; iterator_i++) {
            if (detectCyclefromvertex(adj_matrix, visited, iterator_i, checked_for_cycles))
                return false;
        }
        return true;
    }

    public static boolean detectCyclefromvertex(int[][] adj_matrix, int visited[], int current_vertex, boolean checked_for_cycles[])
    {
        if (!checked_for_cycles[current_vertex]) {
            if (visited[current_vertex] == 1)
                return true;
            visited[current_vertex] = 1;
            for (int iterator_i = 0; iterator_i < visited.length; iterator_i++) {
                if (adj_matrix[current_vertex][iterator_i] == 1) {
                    if (detectCyclefromvertex(adj_matrix, visited, iterator_i, checked_for_cycles))
                        return true;
                }
            }
            checked_for_cycles[current_vertex] = true;
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) // Cycle Detection Adjacency list
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int visited[] = new int[numCourses];
        boolean checked_for_cycles[] = new boolean[numCourses];
        for (int iterator_i = 0; iterator_i < numCourses; iterator_i++)
            list.add(new ArrayList<>());
        for (int iterator_i = 0; iterator_i < prerequisites.length; iterator_i++)
            list.get(prerequisites[iterator_i][1]).add(prerequisites[iterator_i][0]);

        for (int iterator_i = 0; iterator_i < numCourses; iterator_i++) {
            if (detectCyclefromvertex_list(list, visited, iterator_i, checked_for_cycles))
                return false;
        }
        return true;
    }

    public static boolean detectCyclefromvertex_list(List<List<Integer>> adj_list, int visited[], int current_vertex, boolean checked_for_cycles[])
    {
        if (!checked_for_cycles[current_vertex]) {
            if (visited[current_vertex] == 1)
                return true;
            visited[current_vertex] = 1;
            for (int courseId : adj_list.get(current_vertex)) {
                if (detectCyclefromvertex_list(adj_list, visited, courseId, checked_for_cycles))
                    return true;
            }
            checked_for_cycles[current_vertex] = true;
        }
        return false;
    }

    /*
    93. PROBLEM DESCRIPTION (https://leetcode.com/problems/surrounded-regions/)
        Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

        A region is captured by flipping all 'O's into 'X's in that surrounded region.

        Example:
            X X X X
            X O O X
            X X O X
            X O X X

        After running your function, the board should be:
            X X X X
            X X X X
            X X X X
            X O X X

        Explanation:
            Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not
            flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
            Two cells are connected if they are adjacent cells connected horizontally or vertically.
    */
    public void solve(char[][] board)
    {
        if (board.length == 0)
            return;
        for (int iterator_i = 0; iterator_i < board[0].length; iterator_i++)
            if (board[0][iterator_i] == 'O')
                solveDfs(board, 0, iterator_i);
        for (int iterator_i = 0; iterator_i < board[0].length; iterator_i++)
            if (board[board.length - 1][iterator_i] == 'O')
                solveDfs(board, board.length - 1, iterator_i);
        for (int iterator_i = 1; iterator_i < board.length - 1; iterator_i++)
            if (board[iterator_i][0] == 'O')
                solveDfs(board, iterator_i, 0);
        for (int iterator_i = 1; iterator_i < board.length - 1; iterator_i++)
            if (board[iterator_i][board[0].length - 1] == 'O')
                solveDfs(board, iterator_i, board[0].length - 1);

        for (int iterator_i = 0; iterator_i < board.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++) {
                if (board[iterator_i][iterator_j] == 'Y')
                    board[iterator_i][iterator_j] = 'O';
                else
                    board[iterator_i][iterator_j] = 'X';
            }
        }
    }

    public static void solveDfs(char board[][], int x_pos, int y_pos)
    {
        board[x_pos][y_pos] = 'Y';
        if (x_pos + 1 < board.length - 1 && board[x_pos + 1][y_pos] == 'O')
            solveDfs(board, x_pos + 1, y_pos);
        if (x_pos - 1 > 0 && board[x_pos - 1][y_pos] == 'O')
            solveDfs(board, x_pos - 1, y_pos);
        if (y_pos + 1 < board[0].length - 1 && board[x_pos][y_pos + 1] == 'O')
            solveDfs(board, x_pos, y_pos + 1);
        if (y_pos - 1 > 0 && board[x_pos][y_pos - 1] == 'O')
            solveDfs(board, x_pos, y_pos - 1);
    }

    /*
    94. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-1-bits/)
        Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

        Example 1:
        Input: 00000000000000000000000000001011
        Output: 3
        Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
    */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
        int count_ones = 0;
        while (n != 0) {
            count_ones++;
            n = n & (n - 1);
        }
        return count_ones;
    }

    /*
    95. PROBLEM DESCRIPTION (https://leetcode.com/problems/excel-sheet-column-number/)
        Given a column title as appear in an Excel sheet, return its corresponding column number.

        For example:
            A -> 1
            B -> 2
            C -> 3
            ...
            Z -> 26
            AA -> 27
            AB -> 28
            ...
    */
    public int titleToNumber(String s)
    {
        int final_val = 0;
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++)
            final_val += Math.pow(26, s.length() - 1 - iterator_i) * (int) (s.charAt(iterator_i) - 'A' + 1);
        return final_val;
    }

    /*
    96. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-product-subarray/)
        Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

        Example 1:
        Input: [2,3,-2,4]
        Output: 6
        Explanation: [2,3] has the largest product 6.
    */
    public int maxProduct_complicated(int[] nums)
    {
        int max_value_till_now = Integer.MIN_VALUE, curr_negative_till_now = Integer.MAX_VALUE, curr_positive_till_now = Integer.MIN_VALUE;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            if (nums[iterator_i] > 0) {
                curr_positive_till_now = (curr_positive_till_now < 0) ? nums[iterator_i] : curr_positive_till_now * nums[iterator_i];
                curr_negative_till_now = (curr_negative_till_now < 0) ? curr_negative_till_now * nums[iterator_i] : curr_negative_till_now;
            } else if (nums[iterator_i] < 0) {
                int temp = (curr_positive_till_now < 0) ? nums[iterator_i] : curr_positive_till_now * nums[iterator_i];
                if (curr_negative_till_now < 0)
                    curr_positive_till_now = curr_negative_till_now * nums[iterator_i];
                else
                    curr_positive_till_now = Integer.MIN_VALUE;
                curr_negative_till_now = temp;
            } else {
                curr_positive_till_now = Integer.MIN_VALUE;
                curr_negative_till_now = Integer.MAX_VALUE;
                max_value_till_now = Math.max(max_value_till_now, 0);
            }
            max_value_till_now = Math.max(max_value_till_now, curr_positive_till_now);
            if (curr_negative_till_now < 0)
                max_value_till_now = Math.max(max_value_till_now, curr_negative_till_now);

        }
        return max_value_till_now;
    }

    public int maxProduct_simplified(int[] nums)
    {
        int final_max = nums[0], curr_positive = nums[0], curr_negative = nums[0], temp;
        for (int iterator_i = 1; iterator_i < nums.length; iterator_i++) {
            if (nums[iterator_i] < 0) {
                temp = curr_negative;
                curr_negative = curr_positive;
                curr_positive = temp;
            }
            curr_positive = Math.max(curr_positive * nums[iterator_i], nums[iterator_i]);
            curr_negative = Math.min(curr_negative * nums[iterator_i], nums[iterator_i]);

            final_max = Math.max(final_max, curr_positive);
        }
        return final_max;
    }

    public int maxProduct(int[] nums) //Do passes from front to end and end to front
    {
        int final_max = nums[0], current_prod = nums[0];
        for (int iterator_i = 1; iterator_i < nums.length; iterator_i++) {
            current_prod = current_prod * nums[iterator_i];
            final_max = Math.max(final_max, current_prod);
            if (current_prod == 0)
                current_prod = 1;
        }
        current_prod = 1;
        for (int iterator_i = nums.length - 1; iterator_i >= 0; iterator_i--) {
            current_prod = current_prod * nums[iterator_i];
            final_max = Math.max(final_max, current_prod);
            if (current_prod == 0)
                current_prod = 1;
        }
        return final_max;
    }

    /*
    97. PROBLEM DESCRIPTION (https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
        Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
        of every node never differ by more than 1.

        Example:
        Given the sorted array: [-10,-3,0,5,9],
        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

              0
             / \
           -3   9
           /   /
         -10  5
    */
    public TreeNode sortedArrayToBST(int[] nums)
    {

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTHelper(int nums[], int lb, int ub)
    {
        int mid = lb + (ub - lb) / 2;
        TreeNode new_node = new TreeNode(nums[mid]);
        if (lb < mid)
            new_node.left = sortedArrayToBSTHelper(nums, lb, mid - 1);
        if (mid < ub)
            new_node.right = sortedArrayToBSTHelper(nums, mid + 1, ub);

        return new_node;
    }

    /*
    98. PROBLEM DESCRIPTION (https://leetcode.com/problems/middle-of-the-linked-list/)
        Given a non-empty, singly linked list with head node head, return a middle node of linked list.
        If there are two middle nodes, return the second middle node.

        Example 1:
        Input: [1,2,3,4,5]
        Output: Node 3 from this list (Serialization: [3,4,5])
        The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).

        Example 2:
        Input: [1,2,3,4,5,6]
        Output: Node 4 from this list (Serialization: [4,5,6])
        Since the list has two middle nodes with values 3 and 4, we return the second one.
    */
    public ListNode middleNode(ListNode head)
    {
        ListNode slow_ptr = head, fast_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr;
    }


    /*
    99. PROBLEM DESCRIPTION (https://leetcode.com/problems/move-zeroes/)
        Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

        Example:
            Input: [0,1,0,3,12]
            Output: [1,3,12,0,0]
    */
    public void moveZeroes(int[] nums)
    {
        int zero_ptr = 0, scan_ptr = 0;
        while (scan_ptr < nums.length) {
            if (nums[scan_ptr] != 0)
                nums[zero_ptr++] = nums[scan_ptr];
            scan_ptr++;
        }
        while (zero_ptr < nums.length)
            nums[zero_ptr++] = 0;
    }

    /*
    100. PROBLEM DESCRIPTION (https://leetcode.com/problems/contiguous-array/)
        Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

        Example 1:
        Input: [0,1]
        Output: 2
        Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

        Example 2:
        Input: [0,1,0]
        Output: 2
        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

        Note: The length of the given binary array will not exceed 50,000.
    */
    public int findMaxLength(int[] nums)
    {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        hmap.put(0, -1);
        int count_zero = 0, max_length = 0;
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++) {
            count_zero += (nums[iterator_i] == 0) ? 1 : -1;
            if (hmap.containsKey(count_zero))
                max_length = Math.max(max_length, iterator_i - hmap.get(count_zero));
            else
                hmap.put(count_zero, iterator_i);
        }
        return max_length;
    }

    /*
    101. PROBLEM DESCRIPTION (https://leetcode.com/problems/n-queens/)
        Given an integer n, return all distinct solutions to the n-queens puzzle.

        Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
        a queen and an empty space respectively.
    */
    public List<List<String>> solveNQueens_alt(int n)
    {
        List<List<String>> list = new ArrayList<List<String>>();
        solveQueensHelper_alt(list, 0, new ArrayList<Integer>(), n);
        return list;
    }

    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> list = new ArrayList<List<String>>();
        boolean visited_col[] = new boolean[n];
        boolean visited_diag1[] = new boolean[2 * n - 1];
        boolean visited_diag2[] = new boolean[2 * n - 1];
        solveQueensHelper(list, new ArrayList<Integer>(), n, visited_col, visited_diag1, visited_diag2);
        return list;
    }

    public List<List<String>> solveNQueens_dp(int n)
    {
        List<List<String>> list = new ArrayList<List<String>>();
        HashMap<TreeSet<String>, NQueensHashval> hmap = new HashMap<>();
        hmap.put(new TreeSet<>(), new NQueensHashval(1));
        int row_count = 0;
        while (row_count < n) {
            HashMap<TreeSet<String>, NQueensHashval> newmap = new HashMap<>();
            for (TreeSet hset : hmap.keySet()) //Iterate over sets and if intersection is 0 only then do next steps otherwise invalid
            {
                for (int iterator_i = 0; iterator_i < n; iterator_i++)  //Column Values for Current Row
                {
                    if (hset.contains("c_" + iterator_i) || hset.contains("d1_" + (n + row_count - iterator_i - 1)) || hset.contains("d2_" + (row_count + iterator_i)))
                        continue;
                    // Create new set using contained set
                    TreeSet current_set = (TreeSet) hset.clone();
                    current_set.add("c_" + iterator_i);
                    current_set.add("d1_" + (n + row_count - iterator_i - 1));
                    current_set.add("d2_" + (row_count + iterator_i));

                    if (newmap.containsKey(current_set)) {
                        LinkedHashSet[] prev_set = (LinkedHashSet[]) hmap.get(hset).queen_configuration;
                        LinkedHashSet[] new_set = new LinkedHashSet[Math.max(1, hmap.get(hset).val)];
                        for (int iterator_j = 0; iterator_j < Math.max(1, hmap.get(hset).val); iterator_j++) {
                            new_set[iterator_j] = (LinkedHashSet) prev_set[iterator_j].clone();
                            new_set[iterator_j].add(iterator_i);
                        }
                        NQueensHashval newval = newmap.get(current_set);
                        LinkedHashSet<Integer>[] queen_new_configuration = new LinkedHashSet[Math.max(1, newval.val + prev_set.length)];
                        for (int iterator_j = 0; iterator_j < Math.max(1, newval.val); iterator_j++)
                            queen_new_configuration[iterator_j] = newval.queen_configuration[iterator_j];
                        for (int iterator_j = Math.max(1, newval.val); iterator_j < Math.max(1, newval.val + prev_set.length); iterator_j++)
                            queen_new_configuration[iterator_j] = new_set[iterator_j - Math.max(1, newval.val)];
                        newval.queen_configuration = queen_new_configuration;
                        newval.val = newval.val + prev_set.length;
                        newmap.put(current_set, newval);
                    } else {
                        LinkedHashSet[] prev_set = (LinkedHashSet[]) hmap.get(hset).queen_configuration;
                        LinkedHashSet[] new_set = new LinkedHashSet[Math.max(1, hmap.get(hset).val)];
                        for (int iterator_j = 0; iterator_j < Math.max(1, hmap.get(hset).val); iterator_j++) {
                            new_set[iterator_j] = (LinkedHashSet) prev_set[iterator_j].clone();
                            new_set[iterator_j].add(iterator_i);
                        }
                        NQueensHashval newval = new NQueensHashval(hmap.get(hset).val);
                        newval.queen_configuration = new_set;

                        newmap.put(current_set, newval);
                    }
                }
            }
            hmap = newmap;
            row_count++;
        }
        for (NQueensHashval allval : hmap.values()) {
            for (LinkedHashSet curr_set : allval.queen_configuration) {
                List<String> chess_board_config = new ArrayList<>();
                for (Object col_placed : curr_set) {
                    String current_row = "";
                    for (int iterator_i = 0; iterator_i < n; iterator_i++) {
                        if (iterator_i == (Integer) (col_placed))
                            current_row += 'Q';
                        else
                            current_row += '.';
                    }
                    chess_board_config.add(current_row);
                }
                list.add(chess_board_config);
            }
        }
        return list;
    }

    public static boolean isValidQueen_alt(List<Integer> current_queen_placement, int col)
    {
        int current_row = 1, placement_row = current_queen_placement.size() + 1;
        for (int queen_col_pos : current_queen_placement) {
            if (col == queen_col_pos || queen_col_pos + placement_row - current_row == col || queen_col_pos - placement_row + current_row == col)
                return false;
            current_row++;
        }
        return true;
    }

    public static void solveQueensHelper_alt(List<List<String>> list, int row_num, List<Integer> current_queen_placement, int n)
    {
        if (row_num == n) {
            List<String> newlist = new ArrayList<>();
            for (int queen_pos : current_queen_placement) {
                String current_row = "";
                for (int iterator_i = 0; iterator_i < n; iterator_i++) {
                    if (iterator_i != queen_pos)
                        current_row += '.';
                    else
                        current_row += 'Q';
                }
                newlist.add(current_row);
            }
            list.add(newlist);
            return;
        }
        for (int iterator_i = 0; iterator_i < n; iterator_i++) {
            if (isValidQueen_alt(current_queen_placement, iterator_i)) {
                current_queen_placement.add(iterator_i);
                solveQueensHelper_alt(list, row_num + 1, current_queen_placement, n);
                current_queen_placement.remove(current_queen_placement.size() - 1);
            }
        }
    }

    public static void solveQueensHelper(List<List<String>> list, List<Integer> current_queen_placement, int n, boolean visited_col[], boolean visited_diag1[], boolean visited_diag2[])
    {
        if (current_queen_placement.size() == n) {
            List<String> newlist = new ArrayList<>();
            for (int queen_pos : current_queen_placement) {
                System.out.print(queen_pos + " ");
                String current_row = "";
                for (int iterator_i = 0; iterator_i < n; iterator_i++) {
                    if (iterator_i != queen_pos)
                        current_row += '.';
                    else
                        current_row += 'Q';
                }
                newlist.add(current_row);
            }
            System.out.println();
            list.add(newlist);
            return;
        }
        for (int iterator_i = 0; iterator_i < n; iterator_i++) {
            if (visited_col[iterator_i] || visited_diag1[n + current_queen_placement.size() - iterator_i - 1] || visited_diag2[current_queen_placement.size() + iterator_i])
                continue;
            else {
                visited_col[iterator_i] = true;
                visited_diag1[n + current_queen_placement.size() - iterator_i - 1] = true;
                visited_diag2[current_queen_placement.size() + iterator_i] = true;
                current_queen_placement.add(iterator_i);
                solveQueensHelper(list, current_queen_placement, n, visited_col, visited_diag1, visited_diag2);
                current_queen_placement.remove(current_queen_placement.size() - 1);
                visited_col[iterator_i] = false;
                visited_diag1[n + current_queen_placement.size() - iterator_i - 1] = false;
                visited_diag2[current_queen_placement.size() + iterator_i] = false;
            }
        }
    }

    /*
    102. PROBLEM DESCRIPTION (https://leetcode.com/problems/backspace-string-compare/)
        Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

        Note that after backspacing an empty text, the text will continue empty.

        Example 1:
        Input: S = "ab#c", T = "ad#c"
        Output: true
        Explanation: Both S and T become "ac".

        Example 2:
        Input: S = "ab##", T = "c#d#"
        Output: true
        Explanation: Both S and T become "".
    */
    public boolean backspaceCompare_space(String S, String T)
    {
        String final_string1 = "", final_string2 = "";
        int count_del = 0;
        for (int iterator_i = S.length() - 1; iterator_i >= 0; iterator_i--) {
            if (S.charAt(iterator_i) == '#') {
                count_del++;
                continue;
            }
            if (count_del > 0) {
                count_del--;
                continue;
            }
            final_string1 = S.charAt(iterator_i) + final_string1;
        }
        count_del = 0;
        for (int iterator_i = T.length() - 1; iterator_i >= 0; iterator_i--) {
            if (T.charAt(iterator_i) == '#') {
                count_del++;
                continue;
            }
            if (count_del > 0) {
                count_del--;
                continue;
            }
            final_string2 = T.charAt(iterator_i) + final_string2;
        }
        return final_string1.compareTo(final_string2) == 0 ? true : false;
    }

    public boolean backspaceCompare(String S, String T)
    {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;

            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }

    /*
    103. PROBLEM DESCRIPTION (https://leetcode.com/problems/last-stone-weight/)
        We have a collection of stones, each stone has a positive integer weight.

        Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.
        The result of this smash is:
        1. If x == y, both stones are totally destroyed;
        2. If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.

        At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

        Example 1:
        Input: [2,7,4,1,8,1]
        Output: 1

        Explanation:
        We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


        Note:
            1 <= stones.length <= 30
            1 <= stones[i] <= 1000
    */
    public int lastStoneWeight_alt(int[] stones)
    {
        PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());
        for (int stone_val : stones)
            queue.add(stone_val);

        while (queue.size() > 1)
            queue.add((int) queue.poll() - (int) queue.poll());

        return (int) queue.poll();
    }

    public int lastStoneWeight_bucket(int[] stones) //BucketSort
    {
        int bucket[] = new int[1001], i_val = Integer.MIN_VALUE;
        for (int stoneval : stones) {
            bucket[stoneval]++;
            i_val = Math.max(i_val, stoneval);
        }
        while (i_val > 0) {
            if (bucket[i_val] == 0) {
                i_val--;
                continue;
            }
            bucket[i_val] = bucket[i_val] % 2;
            if (bucket[i_val] != 0) {
                int j_val = i_val - 1;
                while (j_val > 0 && bucket[j_val] == 0)
                    if (bucket[j_val] == 0)
                        j_val--;
                if (j_val == 0)
                    return i_val;
                bucket[i_val - j_val]++;
                bucket[i_val]--;
                bucket[j_val]--;
            }
            i_val--;
        }
        return bucket[i_val];
    }

    public int lastStoneWeight(int[] stones) //Plain Sorting
    {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }

    /*
    105. PROBLEM DESCRIPTION (http://leetcode.com/problems/convert-bst-to-greater-tree/)
        Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

        Example:
        Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

        Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
    */
    int rootval = 0;

    public TreeNode convertBST_rcur(TreeNode root) //Recursive
    {
        if (root == null)
            return null;
        convertBST(root.right);
        root.val += rootval;
        rootval = root.val;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST_iter(TreeNode root) //Iterative
    {
        TreeNode node = root;
        int sum_till_now = 0;
        Stack<TreeNode> stck = new Stack();

        while (!stck.isEmpty() || node != null) {
            while (node != null) {
                stck.push(node);
                node = node.right;
            }

            node = stck.pop();
            sum_till_now += node.val;
            node.val = sum_till_now;

            node = node.left;
        }
        return root;
    }

    public TreeNode getSuccessor(TreeNode root) // Reached only if right is present
    {
        TreeNode successor = root.right;
        while (successor.left != null && successor.left != root)
            successor = successor.left;
        return successor;
    }

    public TreeNode convertBST(TreeNode root) //Morris
    {
        TreeNode node = root;
        int sum_till_now = 0;

        while (node != null) {
            if (node.right == null) {
                node.val += sum_till_now;
                sum_till_now = node.val;
                node = node.left;
            } else {
                TreeNode successor = getSuccessor(node);
                if (successor.left == null) //First Visit Attach Node
                {
                    successor.left = node;
                    node = node.right;
                } else //Modify Node
                {
                    successor.left = null;
                    node.val += sum_till_now;
                    sum_till_now = node.val;
                    node = node.left;
                }
            }
        }
        return root;
    }

    /*
    106. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-depth-of-binary-tree/)
        Given a binary tree, find its minimum depth.

        The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
        Given binary tree [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7
        return its minimum depth = 2.
    */
    public int minDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        if (root.right == null)
            return minDepth(root.left) + 1;
        if (root.left == null)
            return minDepth(root.right) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /*
    107. PROBLEM DESCRIPTION (https://leetcode.com/problems/reorder-list/)
        Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

        You may not modify the values in the list's nodes, only nodes itself may be changed.
        Example 1:
        Given 1->2->3->4, reorder it to 1->4->2->3.

        Example 2:
        Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
    */
    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null)
            return;
        ListNode slow_ptr = head, fast_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        fast_ptr = slow_ptr; //Midway

        //Reverse Lisked list from slow_ptr
        ListNode prev_ptr = slow_ptr;
        slow_ptr = slow_ptr.next;
        prev_ptr.next = null;
        prev_ptr = null;
        ListNode next_node;
        while (slow_ptr != null) {
            next_node = slow_ptr.next;
            slow_ptr.next = prev_ptr;
            prev_ptr = slow_ptr;
            slow_ptr = next_node;
        }

        while (prev_ptr != null) {
            next_node = prev_ptr.next;
            prev_ptr.next = head.next;
            head.next = prev_ptr;
            head = prev_ptr.next;
            prev_ptr = next_node;
        }
    }

    /*
    108. PROBLEM DESCRIPTION (https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)
        Return the root node of a binary search tree that matches the given preorder traversal.

        Example 1:
        Input: [8,5,1,7,10,12]
        Output: [8,5,10,1,7,null,12]
             8
           /   \
          5    10
        /  \     \
       1    7     12
    */
    public TreeNode bstFromPreorder_iter(int[] preorder) //Stack Approach
    {
        Stack<TreeNode> stck = new Stack();
        stck.push(new TreeNode(preorder[0]));
        for (int iterator_i = 1; iterator_i < preorder.length; iterator_i++) {
            TreeNode current_node = new TreeNode(preorder[iterator_i]);
            if (preorder[iterator_i] < stck.peek().val)
                stck.peek().left = current_node;
            else {
                TreeNode parent = stck.peek();
                while (!stck.isEmpty() && stck.peek().val < current_node.val)
                    parent = stck.pop();
                parent.right = current_node;
            }
            stck.push(current_node);
        }
        return null;
    }

    int current_item = 0;

    public TreeNode bstFromPreorder(int[] preorder)
    {
        return bstFromPreorder_helper(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder_helper(int[] preorder, int current_bound)
    {
        if (current_item == preorder.length || preorder[current_item] > current_bound)
            return null;
        TreeNode root = new TreeNode(preorder[current_item++]);
        root.left = bstFromPreorder_helper(preorder, root.val);
        root.right = bstFromPreorder_helper(preorder, current_bound);
        return root;
    }

    /*
    109. PROBLEM DESCRIPTION (https://leetcode.com/problems/is-subsequence/)
        Given a string s and a string t, check if s is subsequence of t.

        You may assume that there is only lower case English letters in both s and t. t is potentially a very long
        (length ~= 500,000) string, and s is a short string (<=100).

        A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the
        characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while
        "aec" is not).

        Example 1:
        s = "abc", t = "ahbgdc"
        Return true.

        Example 2:
        s = "axc", t = "ahbgdc"

        Return false.
    */
    public boolean isSubsequence_full(String s, String t)
    {
        List<Integer> list_character[] = new ArrayList[256]; //ASCII set
        for (int iterator_i = 0; iterator_i < t.length(); iterator_i++) {
            if (list_character[t.charAt(iterator_i)] == null)
                list_character[t.charAt(iterator_i)] = new ArrayList<>();
            list_character[t.charAt(iterator_i)].add(iterator_i);
        }

        int current_seeked_position = 0;
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++) {
            if (current_seeked_position == t.length() || list_character[s.charAt(iterator_i)] == null)
                return false;
            int current_position_found = Collections.binarySearch(list_character[s.charAt(iterator_i)], current_seeked_position);
            if (current_position_found < 0) // Pos not found . get index of position just greater that it
                current_position_found = -current_position_found - 1;
            if (current_position_found == list_character[s.charAt(iterator_i)].size())// Not present in string anymore
                return false;
            current_seeked_position = list_character[s.charAt(iterator_i)].get(current_position_found) + 1;
            System.out.println("cpos:" + current_position_found + " seek:" + current_seeked_position);
        }
        return true;
    }

    public boolean isSubsequence(String s, String t)
    {
        int seek_val = 0, next_occurence_pos;
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++) {
            next_occurence_pos = t.indexOf(s.charAt(iterator_i), seek_val);
            if (next_occurence_pos < 0)
                return false;
            seek_val = next_occurence_pos + 1;
        }
        return true;
    }

    /*
    110. PROBLEM DESCRIPTION (https://leetcode.com/problems/detect-capital/)
        Given a word, you need to judge whether the usage of capitals in it is right or not.

        We define the usage of capitals in a word to be right when one of the following cases holds:
        1. All letters in this word are capitals, like "USA".
        2. All letters in this word are not capitals, like "leetcode".
        3. Only the first letter in this word is capital, like "Google".
        4. Otherwise, we define that this word doesn't use capitals in a right way.

        Example 1:
        Input: "USA"
        Output: True

        Example 2:
        Input: "FlaG"
        Output: False
    */
    public boolean detectCapitalUse(String word)
    {
        if (word.length() < 2)
            return true;
        boolean allcaps = false;
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1)))
            allcaps = true;
        else if (Character.isLowerCase(word.charAt(0))) {
            if (Character.isUpperCase(word.charAt(1)))
                return false;
        }
        for (int iterator_i = 2; iterator_i < word.length(); iterator_i++) {
            if (!allcaps && Character.isUpperCase(word.charAt(iterator_i)))
                return false;
            if (allcaps && Character.isLowerCase(word.charAt(iterator_i)))
                return false;
        }
        return true;
    }

    /*
    111. PROBLEM DESCRIPTION (https://leetcode.com/problems/sort-list/)
        Sort a linked list in O(n log n) time using constant space complexity.

        Example 1:
        Input: 4->2->1->3
        Output: 1->2->3->4

        Example 2:
        Input: -1->5->3->4->0
        Output: -1->0->3->4->5
    */
    public ListNode sortList_msort(ListNode head) //Recursive Merge Sort
    {
        if (head == null || head.next == null)
            return head;
        ListNode slow_ptr = head, fast_ptr = head, prev_ptr = slow_ptr;
        while (fast_ptr != null && fast_ptr.next != null) {
            prev_ptr = slow_ptr;
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        prev_ptr.next = null;
        ListNode left_sorted = sortList(head);
        ListNode right_sorted = sortList(slow_ptr);

        return sortList_merge(left_sorted, right_sorted);

    }

    public ListNode sortList_merge(ListNode left_sorted, ListNode right_sorted)
    {
        ListNode prev_list = null, temp, root;
        if (left_sorted.val == -85 && right_sorted.val == -85)
            System.out.println(left_sorted.val + ":" + right_sorted.val);
        if (left_sorted.val > right_sorted.val) //Boundary Condtion Swap for first item
        {
            temp = right_sorted;
            right_sorted = left_sorted;
            left_sorted = temp;
        }
        root = left_sorted;
        while (left_sorted != null && right_sorted != null) {
            if (left_sorted.val <= right_sorted.val) {
                prev_list = left_sorted;
                left_sorted = left_sorted.next;
            } else {
                temp = right_sorted.next;
                right_sorted.next = left_sorted;
                prev_list.next = right_sorted;
                right_sorted = temp;
                prev_list = prev_list.next;
            }
        }
        if (left_sorted == null)
            prev_list.next = right_sorted;
        return root;
    }

    public ListNode sortList(ListNode head) //Recursive PartitionSort Important: Duplicate value handling .. can be clubbed along with pivot
    {                                       // Causes huge performance issue otherwise
        if (head == null || head.next == null)
            return head;
        ListNode pivot = head, left = new ListNode(0), right = new ListNode(0),
                left_iter = left, right_iter = right, head1 = head;
        head = head.next;
        while (head != null) {
            if (head.val < pivot.val) {
                left_iter.next = head;
                left_iter = left_iter.next;
            } else if (head.val > pivot.val) {
                right_iter.next = head;
                right_iter = right_iter.next;
            } else {
                pivot.next = head;
                pivot = pivot.next;
            }
            head = head.next;
        }
        left_iter.next = null;
        right_iter.next = null;
        pivot.next = null;
        left.next = sortList(left.next);
        right.next = sortList(right.next);
        left_iter = left;
        while (left.next != null)
            left = left.next;

        left.next = head1;
        pivot.next = right.next;
        return left_iter.next;
    }

    /*
    112. PROBLEM DESCRIPTION (https://leetcode.com/problems/pascals-triangle/)
        Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

        Example:
        Input: 5
        Output:
        [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
        ]
    */
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> final_list = new ArrayList<>();
        if (numRows == 0)
            return final_list;
        List<Integer> prev_list = new ArrayList<>(), curr_list;
        prev_list.add(1);
        final_list.add(prev_list);
        for (int iterator_i = 1; iterator_i < numRows; iterator_i++) {
            curr_list = new ArrayList<>();
            curr_list.add(final_list.get(final_list.size() - 1).get(0));
            for (int iterator_prev = 1; iterator_prev < final_list.get(final_list.size() - 1).size(); iterator_prev++)
                curr_list.add(final_list.get(final_list.size() - 1).get(iterator_prev - 1) + final_list.get(final_list.size() - 1).get(iterator_prev));
            curr_list.add(final_list.get(final_list.size() - 1).get(final_list.get(final_list.size() - 1).size() - 1));
            final_list.add(curr_list);
        }
        return final_list;
    }

    /*
    113. PROBLEM DESCRIPTION (https://leetcode.com/problems/house-robber-ii/)
        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All
        houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent
        houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the
        same night.

        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you
        can rob tonight without alerting the police.

        Example 1:
        Input: [2,3,2]
        Output: 3
        Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

        Example 2:
        Input: [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
    */
    public int rob2(int[] nums)
    {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob2_helper(nums, 0, nums.length - 2), rob2_helper(nums, 1, nums.length - 1));
    }

    public int rob2_helper(int[] nums, int start_index, int end_index)
    {
        if (start_index >= end_index)
            return nums[start_index];
        int dp_max_till_non_adjacent = nums[start_index++];
        if (start_index == end_index)
            return Math.max(nums[start_index], dp_max_till_non_adjacent);
        int dp_max_till_now_prev = Math.max(nums[start_index++], dp_max_till_non_adjacent);
        for (int iterator_i = start_index; iterator_i <= end_index; iterator_i++) {
            int current_max = Math.max(dp_max_till_non_adjacent + nums[iterator_i], dp_max_till_now_prev);
            dp_max_till_non_adjacent = dp_max_till_now_prev;
            dp_max_till_now_prev = current_max;
        }
        return dp_max_till_now_prev;
    }

    /*
    114. PROBLEM DESCRIPTION (https://leetcode.com/problems/flipping-an-image/)
        Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

        To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
        horizontally results in [0, 1, 1].
        To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results
        in [1, 0, 0].

        Example 1:
        Input: [[1,1,0],[1,0,1],[0,0,0]]
        Output: [[1,0,0],[0,1,0],[1,1,1]]
        Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
        Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

        Example 2:
        Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
        Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
        Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
        Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    */
    public int[][] flipAndInvertImage(int[][] A) // Also can be done vai xor if symmetric elements found. No change required in case dissimilar values found
    {
        for (int iterator_i = 0; iterator_i < A.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < A[0].length / 2; iterator_j++) {
                int temp = A[iterator_i][A[0].length - 1 - iterator_j];
                A[iterator_i][A[0].length - 1 - iterator_j] = (A[iterator_i][iterator_j] == 0) ? 1 : 0;
                A[iterator_i][iterator_j] = (temp == 0) ? 1 : 0;
            }
            if (A[0].length % 2 != 0)
                A[iterator_i][A[0].length / 2] = (A[iterator_i][A[0].length / 2] == 1) ? 0 : 1;
        }
        return A;
    }

    /*
    115. PROBLEM DESCRIPTION (https://leetcode.com/problems/lexicographical-numbers/)
        Given an integer n, return 1 - n in lexicographical order.
        For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
        Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
    */
    public List<Integer> lexicalOrder_rcur(int n) //Recursive DFS
    {
        List<Integer> list = new ArrayList<>();
        for (int iterator_i = 1; iterator_i < 10; iterator_i++)
            lexicalOrderHelper(iterator_i, n, list);
        return null;
    }

    public void lexicalOrderHelper(int current_val, int n, List<Integer> list)
    {
        if (current_val > n)
            return;
        list.add(current_val);
        for (int iterator_i = 0; iterator_i < 10; iterator_i++) {
            if (current_val * 10 + iterator_i > n)
                return;
            lexicalOrderHelper(current_val * 10 + iterator_i, n, list);
        }
    }

    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> list = new ArrayList<>();
        int current_val = 1;
        for (int iterator_i = 0; iterator_i < n; iterator_i++) {
            list.add(current_val);
            if (current_val * 10 <= n)
                current_val *= 10;
            else if (current_val % 10 != 9 && current_val + 1 <= n)
                current_val++;
            else {
                while ((current_val / 10) % 10 == 9)
                    current_val /= 10;
                current_val++;
            }
        }
        return list;
    }

    /*
    116. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximal-square/)
        Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

        Example:
        Input:
            1 0 1 0 0
            1 0 1 1 1
            1 1 1 1 1
            1 0 0 1 0

        Output: 4
    */
    public int maximalSquare(char[][] matrix)
    {
        if (matrix.length == 0)
            return 0;
        int max_len = Integer.MIN_VALUE;
        char dp_prev[] = matrix[0], dp_curr[] = new char[matrix[0].length];
        for (int iterator_i = 0; iterator_i < dp_prev.length; iterator_i++)
            max_len = Math.max(dp_prev[iterator_i] - '0', max_len);
        for (int iterator_i = 1; iterator_i < matrix.length; iterator_i++) {
            dp_curr = matrix[iterator_i];
            max_len = Math.max(dp_curr[0] - '0', max_len);
            for (int iterator_j = 1; iterator_j < matrix[0].length; iterator_j++) {
                dp_curr[iterator_j] = dp_curr[iterator_j] == '1' ? ((char) (Math.min((int) dp_prev[iterator_j - 1], Math.min((int) dp_prev[iterator_j], (int) dp_curr[iterator_j - 1])) + 1)) : '0';
                max_len = Math.max(dp_curr[iterator_j] - '0', max_len);
            }
            dp_prev = dp_curr;
        }
        return max_len * max_len;
    }

    /*
    117. PROBLEM DESCRIPTION (https://leetcode.com/problems/jewels-and-stones/)
        You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
        Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

        The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is
        considered a different type of stone from "A".

        Example 1:
        Input: J = "aA", S = "aAAbbbb"
        Output: 3

        Example 2:
        Input: J = "z", S = "ZZ"
        Output: 0

        Note:
        S and J will consist of letters and have length at most 50.
        The characters in J are distinct.
    */
    public int numJewelsInStones(String J, String S)
    {
        HashSet jewel_set = new HashSet();
        for (char c : J.toCharArray())
            jewel_set.add(c);
        int count = 0;
        for (char c : S.toCharArray()) {
            if (jewel_set.contains(c))
                count++;
        }
        return count;
        //return S.replaceAll("[^"+J+"]","").length();
    }

    /*
    118. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
        There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and
        end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start
        and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

        An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an
        arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling
        up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

        Example:
        Input:
        [[10,16], [2,8], [1,6], [7,12]]
        Output:
        2

        Explanation:
        One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
    */
    public int findMinArrowShots_alt(int[][] points) //Sort using start value
    {
        //Arrays.sort(points,(a,b)->a[0]-b[0]);
        Arrays.sort(points, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });
        int min_end = Integer.MAX_VALUE, count_arrows = 0;
        for (int iterator_i = 0; iterator_i < points.length; iterator_i++) {
            if (points[iterator_i][0] <= min_end)
                min_end = Math.min(min_end, points[iterator_i][1]);
            else {
                count_arrows++;
                min_end = points[iterator_i][1];
            }
        }
        return count_arrows + ((points.length == 0) ? 0 : 1);
    }

    public int findMinArrowShots(int[][] points) //Sort using start value
    {
        if (points.length < 2)
            return points.length;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int count_arrows = 1, current_max_end = points[0][1];
        for (int iterator_i = 1; iterator_i < points.length; iterator_i++) {
            if (points[iterator_i][0] > current_max_end) {
                count_arrows++;
                current_max_end = points[iterator_i][1];
            }
        }
        return count_arrows;
    }

    /*
    119. PROBLEM DESCRIPTION (https://leetcode.com/problems/132-pattern/)
        Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

        Note: n will be less than 15,000.
        Example 1:
        Input: [1, 2, 3, 4]
        Output: False
        Explanation: There is no 132 pattern in the sequence.

        Example 2:
        Input: [3, 1, 4, 2]
        Output: True
        Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

        Example 3:
        Input: [-1, 3, 2, 0]
        Output: True
        Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
    */
    public boolean find132pattern_alt(int[] nums) // Time O(n^2) Space O(1)
    {
        if (nums.length < 3)
            return false;
        int min_i = nums[0];
        for (int iterator_j = 1; iterator_j < nums.length - 1; iterator_j++) {
            if (min_i >= nums[iterator_j]) {
                min_i = nums[iterator_j];
            } else {
                for (int iterator_k = iterator_j + 1; iterator_k < nums.length; iterator_k++) {
                    if (nums[iterator_k] > min_i && nums[iterator_k] < nums[iterator_j])
                        return true;
                }
            }
        }
        return false;
    }

    public boolean find132pattern(int[] nums) // Time O(n) Space O(n) Set approach to store possible k values
    {
        if (nums.length < 3)
            return false;
        int min_i_arr[] = new int[nums.length];
        min_i_arr[0] = nums[0];
        for (int iterator_i = 1; iterator_i < nums.length; iterator_i++)
            min_i_arr[iterator_i] = Math.min(min_i_arr[iterator_i - 1], nums[iterator_i]);
        Stack<Integer> stck_k = new Stack();

        for (int iterator_j = nums.length - 1; iterator_j >= 0; iterator_j--) {
            if (nums[iterator_j] > min_i_arr[iterator_j]) {
                while (!stck_k.isEmpty() && stck_k.peek() <= min_i_arr[iterator_j])
                    stck_k.pop();
                if (!stck_k.isEmpty() && stck_k.peek() < nums[iterator_j])
                    return true;
                stck_k.push(nums[iterator_j]);
            }
        }
        return false;
    }

    /*
    120. PROBLEM DESCRIPTION (https://leetcode.com/problems/lemonade-change/)
        At a lemonade stand, each lemonade costs $5.

        Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
        Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to
        each customer, so that the net transaction is that the customer pays $5.

        Note that you don't have any change in hand at first.

        Return true if and only if you can provide every customer with correct change.

        Example 1:
        Input: [5,5,5,10,20]
        Output: true
        Explanation:
            From the first 3 customers, we collect three $5 bills in order.
            From the fourth customer, we collect a $10 bill and give back a $5.
            From the fifth customer, we give a $10 bill and a $5 bill.
            Since all customers got correct change, we output true.

        Example 2:
        Input: [5,5,10,10,20]
        Output: false
        Explanation:
        From the first two customers in order, we collect two $5 bills.
        For the next two customers in order, we collect a $10 bill and give back a $5 bill.
        For the last customer, we can't give change of $15 back because we only have two $10 bills.
        Since not every customer received correct change, the answer is false.

        Note:
            0 <= bills.length <= 10000
            bills[i] will be either 5, 10, or 20.
    */
    public boolean lemonadeChange(int[] bills)
    {
        int five_counter = 0, ten_counter = 0;
        for (int iterator_i = 0; iterator_i < bills.length; iterator_i++) {
            if (bills[iterator_i] == 5)
                five_counter++;
            else if (bills[iterator_i] == 10) {
                if (five_counter < 1)
                    return false;
                ten_counter++;
                five_counter--;
            } else if (bills[iterator_i] == 20) {
                if (ten_counter > 0 && five_counter > 0) {
                    ten_counter--;
                    five_counter--;
                } else if (five_counter >= 3)
                    five_counter -= 3;
                else
                    return false;
            }
        }
        return true;
    }

    /*
    121. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-parenthesis-string/)
        Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is
        valid. We define the validity of a string by these rules:

        Any left parenthesis '(' must have a corresponding right parenthesis ')'.
        Any right parenthesis ')' must have a corresponding left parenthesis '('.
        Left parenthesis '(' must go before the corresponding right parenthesis ')'.
        '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
        An empty string is also valid.

        Example 1:
        Input: "()"
        Output: True

        Example 2:
        Input: "(*)"
        Output: True

        Example 3:
        Input: "(*))"
        Output: True

        Note:
        The string size will be in the range [1, 100].
    */
    public boolean checkValidString_alt(String s) //Greedy Approach
    {
        int min_valid_open_brackets = 0, maximum_closed_brackets = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                min_valid_open_brackets++;
            else
                min_valid_open_brackets--;

            if (c == ')')
                maximum_closed_brackets--;
            else
                maximum_closed_brackets++;

            if (maximum_closed_brackets < 0)
                return false;
            min_valid_open_brackets = Math.max(min_valid_open_brackets, 0);
        }
        return min_valid_open_brackets == 0;
    }

    public boolean checkValidString(String s) //Dynamic Approach
    {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++) {
            if (s.charAt(iterator_i) == '*')
                dp[iterator_i][iterator_i] = true;
        }

        for (int iterator_i = 1; iterator_i < s.length(); iterator_i++) {
            int iterator_j = 0;
            while (iterator_j + iterator_i < s.length()) {
                if (s.charAt(iterator_j) == '*' && dp[iterator_j + 1][iterator_j + iterator_i] == true)
                    dp[iterator_j][iterator_j + iterator_i] = true;
                else if (s.charAt(iterator_j) == '(' || s.charAt(iterator_j) == '*') {
                    for (int iterator_k = iterator_j + 1; iterator_k <= iterator_j + iterator_i; iterator_k++) {
                        if ((s.charAt(iterator_k) == ')' || s.charAt(iterator_k) == '*') // midpointcheck
                                && (iterator_k == iterator_j + 1 || dp[iterator_j][iterator_k] == true) //less than midpoint valid
                                && (iterator_k == iterator_j + iterator_i || dp[iterator_k + 1][iterator_j + iterator_i] == true))
                            dp[iterator_j][iterator_j + iterator_i] = true;
                    }
                }
                iterator_j++;
            }
        }
        return dp[0][s.length() - 1];
    }

    /*
    122. PROBLEM DESCRIPTION (https://leetcode.com/problems/arranging-coins/)
        You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
        Given n, find the total number of full staircase rows that can be formed.
        n is a non-negative integer and fits within the range of a 32-bit signed integer.

        Example 1:
        n = 5
        The coins can form the following rows:
        ¤
        ¤ ¤
        ¤ ¤
        Because the 3rd row is incomplete, we return 2.

        Example 2:
        n = 8
        The coins can form the following rows:
        ¤
        ¤ ¤
        ¤ ¤ ¤
        ¤ ¤
        Because the 4th row is incomplete, we return 3.
    */
    public int arrangeCoins(int n)
    {
        int lb = 0, ub = n, mid = 0;
        while (lb < ub) {
            mid = lb + (int) Math.ceil((ub - lb) / 2.0);
            if (mid / 2.0 * (mid + 1) <= n)
                lb = mid;
            else
                ub = mid - 1;
        }
        return lb;
    }

    /*
    123. PROBLEM DESCRIPTION (https://leetcode.com/problems/minesweeper/)
        You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed
        empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines,
        digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

        Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after
        revealing this position according to the following rules:
        1. If a mine ('M') is revealed, then the game is over - change it to 'X'.
        2. If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
        3. If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
        4. Return the board when no more squares will be revealed.

        Example 1:
        Input:
        [['E', 'E', 'E', 'E', 'E'],
         ['E', 'E', 'M', 'E', 'E'],
         ['E', 'E', 'E', 'E', 'E'],
         ['E', 'E', 'E', 'E', 'E']]
        Click : [3,0]
        Output:
        [['B', '1', 'E', '1', 'B'],
         ['B', '1', 'M', '1', 'B'],
         ['B', '1', '1', '1', 'B'],
         ['B', 'B', 'B', 'B', 'B']]

        Example 2:
        Input:
        [['B', '1', 'E', '1', 'B'],
         ['B', '1', 'M', '1', 'B'],
         ['B', '1', '1', '1', 'B'],
         ['B', 'B', 'B', 'B', 'B']]
        Click : [1,2]
        Output:
        [['B', '1', 'E', '1', 'B'],
         ['B', '1', 'X', '1', 'B'],
         ['B', '1', '1', '1', 'B'],
         ['B', 'B', 'B', 'B', 'B']]
    */
    public char[][] updateBoard(char[][] board, int[] click)
    {
        if (board[click[0]][click[1]] == 'M' || board[click[0]][click[1]] == 'X') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        if (!checkAdjacentMines(board, click)) {
            for (int iterator_i = -1; iterator_i < 2; iterator_i++) {
                for (int iterator_j = -1; iterator_j < 2; iterator_j++) {
                    int row = click[0] + iterator_i, col = click[1] + iterator_j;
                    if (row > -1 && row < board.length && col > -1 && col < board[0].length && board[row][col] == 'E')
                        updateBoard(board, new int[]{row, col});
                }
            }
        }
        return board;
    }

    public boolean checkAdjacentMines(char board[][], int click[])
    {
        int count_mines = 0;
        for (int iterator_i = -1; iterator_i < 2; iterator_i++) {
            for (int iterator_j = -1; iterator_j < 2; iterator_j++) {
                int row = click[0] + iterator_i, col = click[1] + iterator_j;
                if (row > -1 && row < board.length && col > -1 && col < board[0].length && board[row][col] == 'M')
                    count_mines++;
            }
        }
        if (count_mines > 0) {
            board[click[0]][click[1]] = (char) (count_mines + '0');
            return true;
        }
        board[click[0]][click[1]] = 'B';
        return false;
    }

    /*
    124. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-perfect-square/)
        Given a positive integer num, write a function which returns True if num is a perfect square else False.

        Note: Do not use any built-in library function such as sqrt.

        Example 1:
        Input: 16
        Output: true

        Example 2:
        Input: 14
        Output: false
    */
    public boolean isPerfectSquare(int num)
    {
        if (num == 0)
            return true;
        int lb = 0, ub = num;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (1.0 * mid == 1.0 * num / mid)
                return true;
            else if (1.0 * mid < 1.0 * num / mid)
                lb = mid + 1;
            else
                ub = mid - 1;
        }
        return false;
    }

    /*
    125. PROBLEM DESCRIPTION (https://leetcode.com/problems/n-queens-ii/)
        The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
        Given an integer n, return the number of distinct solutions to the n-queens puzzle.
        Input: 4
        Output: 2
    */
    public int totalNQueens(int n)
    {
        boolean visited_col[] = new boolean[n];
        boolean visited_diag1[] = new boolean[2 * n - 1];
        boolean visited_diag2[] = new boolean[2 * n - 1];
        return totalNQueensHelper(n, visited_col, visited_diag1, visited_diag2, 0);
    }

    public int totalNQueensHelper(int n, boolean[] visited_col, boolean[] visited_diag1, boolean[] visited_diag2, int current_row)
    {
        int count_states = 0;
        if (current_row == n)
            return 1;
        for (int iterator_i = 0; iterator_i < n; iterator_i++) {
            if (visited_col[iterator_i] || visited_diag1[n + current_row - 1 - iterator_i] || visited_diag2[current_row + iterator_i])
                continue;
            else {
                visited_col[iterator_i] = true;
                visited_diag1[n + current_row - 1 - iterator_i] = true;
                visited_diag2[current_row + iterator_i] = true;
                count_states += totalNQueensHelper(n, visited_col, visited_diag1, visited_diag2, current_row + 1);
                visited_col[iterator_i] = false;
                visited_diag1[n + current_row - 1 - iterator_i] = false;
                visited_diag2[current_row + iterator_i] = false;
            }
        }
        return count_states;
    }

    /*
    126. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
        Given a sorted linked list, delete all duplicates such that each element appear only once.

        Example 1:
        Input: 1->1->2
        Output: 1->2

        Example 2:
        Input: 1->1->2->3->3
        Output: 1->2->3
    */
    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode curr_unique, final_head = head;
        while (head != null) {
            curr_unique = head;
            while (head != null && head.val == curr_unique.val)
                head = head.next;
            curr_unique.next = head;
        }
        return final_head;
    }

    /*
    127. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
        Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

        Return the linked list sorted as well.

        Example 1:
        Input: 1->2->3->3->4->4->5
        Output: 1->2->5

        Example 2:
        Input: 1->1->1->2->3
        Output: 2->3
    */
    public ListNode deleteDuplicates2(ListNode head)
    {
        if (head == null)
            return head;
        ListNode final_head = null, curr_unique = head, prev_unique = null;
        while (head != null) {
            while (head != null && head.val == curr_unique.val) {
                head = head.next;
            }
            if (curr_unique.next != head)
                curr_unique = head;
            else {
                if (prev_unique == null) {
                    final_head = curr_unique;
                    prev_unique = curr_unique;
                } else {
                    prev_unique.next = curr_unique;
                    prev_unique = prev_unique.next;
                }
            }
        }
        if (prev_unique != null)
            prev_unique.next = null;
        return final_head;
    }

    /*
    128. PROBLEM DESCRIPTION (https://leetcode.com/problems/partition-list/)
        Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
        You should preserve the original relative order of the nodes in each of the two partitions.

        Example:
        Input: head = 1->4->3->2->5->2, x = 3
        Output: 1->2->2->4->3->5
    */
    public ListNode partition(ListNode head, int x)
    {
        ListNode header = new ListNode(0), partition_less_node = header, partition_greater_node = header;
        while (head != null) {
            if (head.val < x) {
                ListNode next_head = head.next, partion_less_next = partition_less_node.next;
                if (partition_greater_node == partition_less_node)
                    partition_greater_node = head;

                partition_less_node.next = head;
                partition_less_node = head;
                partition_less_node.next = partion_less_next;
                head = next_head;
            } else {
                partition_greater_node.next = head;
                partition_greater_node = head;
                head = head.next;
                partition_greater_node.next = null;
            }
        }
        return header.next;
    }

    /*
    129. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximal-rectangle/)
        Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

        Example:
        Input:
        [
          ["1","0","1","0","0"],
          ["1","0","1","1","1"],
          ["1","1","1","1","1"],
          ["1","0","0","1","0"]
        ]
        Output: 6
    */
    public int maximalRectangle(char[][] matrix)
    {
        if (matrix.length == 0)
            return 0;
        int left_boundary[] = new int[matrix[0].length], right_boundary[] = new int[matrix[0].length], height_till_row[] = new int[matrix[0].length], max_area = Integer.MIN_VALUE;
        Arrays.fill(right_boundary, matrix[0].length);

        for (int iterator_row = 0; iterator_row < matrix.length; iterator_row++) {
            int curr_left_count = 0, curr_right_count = matrix[0].length;
            for (int iterator_j = 0; iterator_j < matrix[0].length; iterator_j++) {
                //Left Boundary for Row iterator_row. Get rightmost boundary if 1 present in prev rows
                if (matrix[iterator_row][iterator_j] == '1')
                    left_boundary[iterator_j] = Math.max(left_boundary[iterator_j], curr_left_count);
                else {
                    left_boundary[iterator_j] = 0;
                    curr_left_count = iterator_j + 1;
                }

                // Right Boundary Minimal if connected across previous rows
                if (matrix[iterator_row][matrix[0].length - 1 - iterator_j] == '1')
                    right_boundary[matrix[0].length - 1 - iterator_j] = Math.min(right_boundary[matrix[0].length - 1 - iterator_j], curr_right_count);
                else {
                    right_boundary[matrix[0].length - 1 - iterator_j] = matrix[0].length;
                    curr_right_count = matrix[0].length - 1 - iterator_j;
                }

            }
            //Compute height for current row. Also update max area if encountered
            for (int iterator_j = 0; iterator_j < matrix[0].length; iterator_j++) {
                if (matrix[iterator_row][iterator_j] == '1')
                    height_till_row[iterator_j]++;
                else
                    height_till_row[iterator_j] = 0;

                max_area = Math.max(max_area, (right_boundary[iterator_j] - left_boundary[iterator_j]) * height_till_row[iterator_j]);
            }
        }
        return max_area;
    }

    /*
    130. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-linked-list-ii/)
        Reverse a linked list from position m to n. Do it in one-pass.
        Note: 1 ≤ m ≤ n ≤ length of list.

        Example:
        Input: 1->2->3->4->5->NULL, m = 2, n = 4
        Output: 1->4->3->2->5->NULL
    */
    ListNode non_reversed_node = null;

    public ListNode reverseBetween_rcur(ListNode head, int m, int n) //Recursive logic
    {
        if (m == 1)
            return reverseTillN(head, n);
        ListNode last = reverseBetween_rcur(head.next, m - 1, n - 1);
        head.next = last;
        return head;
    }

    public ListNode reverseTillN(ListNode head, int n)
    {
        if (n == 1) {
            non_reversed_node = head.next;
            return head;
        }
        ListNode lastNode = reverseTillN(head.next, n - 1);
        head.next.next = head;
        head.next = non_reversed_node;
        return lastNode;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) //Iterative logic
    {
        ListNode final_header = new ListNode(0);
        final_header.next = head;
        head = final_header;
        n = n - m;
        for (int iterator_i = 2; iterator_i <= m; iterator_i++)
            head = head.next;

        ListNode prev_node = head, last_unsorted_node = prev_node;
        head = head.next;
        for (int iterator_i = 0; iterator_i <= n; iterator_i++) {
            ListNode next_node = head.next;
            head.next = prev_node;
            prev_node = head;
            head = next_node;
        }

        last_unsorted_node.next.next = head;
        last_unsorted_node.next = prev_node;
        return final_header.next;
    }

    /*
    131. PROBLEM DESCRIPTION (https://leetcode.com/problems/array-partition-i/)
        Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

        Example 1:
        Input: [1,4,3,2]
        Output: 4
        Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
        Note:
            n is a positive integer, which is in the range of [1, 10000].
            All the integers in the array will be in the range of [-10000, 10000].
    */
    public int arrayPairSum_alt(int[] nums) //Sorting
    {
        int min_sum = 0;
        Arrays.sort(nums);
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i += 2)
            min_sum += nums[iterator_i];

        return min_sum;
    }

    public int arrayPairSum(int[] nums) //Buckets
    {
        int bucket_arr[] = new int[20001], max_bucket_non_zero = 0, min_bucket_non_zero = 20000, min_sum = 0;
        for (int num_val : nums) {
            bucket_arr[num_val + 10000]++;
            max_bucket_non_zero = Math.max(max_bucket_non_zero, num_val + 10000);
            min_bucket_non_zero = Math.min(min_bucket_non_zero, num_val + 10000);
        }
        boolean is_min_in_pair = true; //First is always in pair
        for (int iterator_i = min_bucket_non_zero; iterator_i <= max_bucket_non_zero; iterator_i++) {
            while (bucket_arr[iterator_i] > 0) {
                if (is_min_in_pair)
                    min_sum += iterator_i - 10000;
                is_min_in_pair = !is_min_in_pair;
                bucket_arr[iterator_i]--;
            }
        }
        return min_sum;
    }

    /*
    132. PROBLEM DESCRIPTION (https://leetcode.com/problems/super-ugly-number/)
        Write a program to find the nth super ugly number.

        Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

        Example:
        Input: n = 12, primes = [2,7,13,19]
        Output: 32
        Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
             super ugly numbers given primes = [2,7,13,19] of size 4.

        Note:
        1. 1 is a super ugly number for any given primes.
        2. The given numbers in primes are in ascending order.
        3. 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
        4. The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
    */
    public int nthSuperUglyNumber_alt(int n, int[] primes) // Can also be done using priority queue for next_value_for_prime
    {
        int ugly_arr[] = new int[n], next_value_for_prime[] = new int[primes.length], current_prime_multiplication_index[] = new int[primes.length];
        Arrays.fill(next_value_for_prime, 1);
        int next = 1;
        for (int iterator_i = 0; iterator_i < n; iterator_i++) {
            ugly_arr[iterator_i] = next;
            next = Integer.MAX_VALUE;
            for (int iterator_j = 0; iterator_j < primes.length; iterator_j++) {
                if (next_value_for_prime[iterator_j] == ugly_arr[iterator_i])
                    next_value_for_prime[iterator_j] = primes[iterator_j] * ugly_arr[current_prime_multiplication_index[iterator_j]++];
                next = Math.min(next, next_value_for_prime[iterator_j]);
            }
        }
        return ugly_arr[n - 1];
    }

    public int nthSuperUglyNumber(int n, int[] primes)
    {
        PriorityQueue<UglyNum> ugly_queue = new PriorityQueue();
        int ugly[] = new int[n], next = 1;
        ugly[0] = 1;
        for (int i = 0; i < primes.length; i++)
            ugly_queue.add(new UglyNum(1, primes[i], primes[i]));
        for (int iterator_i = 1; iterator_i < n; iterator_i++) {
            UglyNum popped = ugly_queue.peek();
            ugly[iterator_i] = popped.current_prime_val;
            while (ugly_queue.peek().current_prime_val == ugly[iterator_i]) {
                popped = ugly_queue.poll();
                ugly_queue.add(new UglyNum(popped.prev_ugly_index + 1, popped.prime * ugly[popped.prev_ugly_index], popped.prime));
            }
        }
        return ugly[n - 1];
    }

    /*
    133. PROBLEM DESCRIPTION (https://leetcode.com/problems/image-smoother/)
        Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

        Example 1:
        Input:
            [[1,1,1],
             [1,0,1],
             [1,1,1]]
        Output:
            [[0, 0, 0],
             [0, 0, 0],
             [0, 0, 0]]
        Explanation:
            For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
            For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
            For the point (1,1): floor(8/9) = floor(0.88888889) = 0

        Note:
            1. The value in the given matrix is in the range of [0, 255].
            2. The length and width of the given matrix are in the range of [1, 150].
    */
    public int[][] imageSmoother(int[][] M)
    {
        if (M.length == 0)
            return M;
        int final_matrix[][] = new int[M.length][M[0].length];
        int directions[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 1}, {1, 0}, {0, -1}, {0, 1}};
        for (int iterator_i = 0; iterator_i < M.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < M[0].length; iterator_j++) {
                int valid_pixels = 1, final_pixel_val = M[iterator_i][iterator_j];
                for (int[] direction : directions) {
                    int curr_row = iterator_i + direction[0], curr_col = iterator_j + direction[1];
                    if (curr_row < 0 || curr_row >= M.length || curr_col < 0 || curr_col >= M[0].length)
                        continue;
                    valid_pixels++;
                    final_pixel_val += M[curr_row][curr_col];
                }
                final_matrix[iterator_i][iterator_j] = final_pixel_val / valid_pixels;
            }
        }
        return final_matrix;
    }

    /*
    134. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-tilt/)
        Given a binary tree, return the tilt of the whole tree.
        The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum
        of all right subtree node values. Null node has tilt 0.
        The tilt of the whole tree is defined as the sum of all nodes' tilt.

        Example:
        Input:
             1
           /   \
          2     3
        Output: 1
        Explanation:
        Tilt of node 2 : 0
        Tilt of node 3 : 0
        Tilt of node 1 : |2-3| = 1
        Tilt of binary tree : 0 + 0 + 1 = 1

        Note:
        1. The sum of node values in any subtree won't exceed the range of 32-bit integer.
        2. All the tilt values won't exceed the range of 32-bit integer.
    */
    int tilt = 0;

    public int findTilt(TreeNode root)
    {
        findTiltHelper(root);
        return tilt;
    }

    public int findTiltHelper(TreeNode root)
    {
        if (root == null)
            return 0;
        int leftSum = findTiltHelper(root.left);
        int rightSum = findTiltHelper(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

    /*
    135. PROBLEM DESCRIPTION (https://leetcode.com/problems/distribute-candies/)
        Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each
        number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
        Return the maximum number of kinds of candies the sister could gain.

        Example 1:
        Input: candies = [1,1,2,2,3,3]
        Output: 3
        Explanation:
        There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
        Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
        The sister has three different kinds of candies.

        Example 2:
        Input: candies = [1,1,2,3]
        Output: 2
        Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
        The sister has two different kinds of candies, the brother has only one kind of candies.

        Note:
        The length of the given array is in range [2, 10,000], and will be even.
        The number in given array is in range [-100,000, 100,000].
    */
    public int distributeCandies_alt(int[] candies) //Time O(nlog(n)) Space O(1)
    {
        int count_candies = 1;
        Arrays.sort(candies);
        for (int iterator_i = 1; iterator_i < candies.length && count_candies < candies.length / 2; iterator_i++) {
            if (candies[iterator_i] > candies[iterator_i - 1])
                count_candies++;
        }
        return count_candies;
    }

    public int distributeCandies_alt1(int[] candies) //Time O(n) Space O(n)
    {
        HashSet<Integer> hset = new HashSet();
        for (int iterator_i = 0; iterator_i < candies.length && hset.size() < candies.length / 2; iterator_i++)
            hset.add(candies[iterator_i]);

        return hset.size();
    }

    public int distributeCandies(int[] candies) //Buckets
    {
        boolean bucket[] = new boolean[200001];
        int unique_val = 0;
        for (int iterator_i = 0; iterator_i < candies.length && unique_val < candies.length / 2; iterator_i++) {
            if (bucket[100000 + candies[iterator_i]] == false)
                unique_val++;
            bucket[100000 + candies[iterator_i]] = true;
        }
        return unique_val;
    }

    /*
    136. PROBLEM DESCRIPTION (https://leetcode.com/problems/trapping-rain-water/)
        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able
        to trap after raining.

        The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
        are being trapped.

        Example:
        Input: [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6
    */
    public int trap_alt(int[] height) // Time O(n) Space O(n)
    {
        if (height.length == 0)
            return 0;
        int left_max[] = new int[height.length], right_max[] = new int[height.length], total_area = 0;
        left_max[0] = height[0];
        right_max[height.length - 1] = height[height.length - 1];
        for (int iterator_i = 1; iterator_i < height.length; iterator_i++) {
            left_max[iterator_i] = Math.max(left_max[iterator_i - 1], height[iterator_i]);
            right_max[height.length - iterator_i - 1] = Math.max(right_max[height.length - iterator_i], height[height.length - iterator_i - 1]);
        }
        for (int iterator_i = 0; iterator_i < height.length; iterator_i++)
            total_area += Math.min(left_max[iterator_i], right_max[iterator_i]) - height[iterator_i];
        return total_area;
    }

    public int trap(int[] height) // Time O(n) Space O(1)
    {
        int max_left_till_now = 0, max_right_till_now = 0, left_pointer = 0, right_pointer = height.length - 1, total_area = 0;
        while (left_pointer < right_pointer) {
            if (height[left_pointer] < height[right_pointer]) // Trap bounded by max left val and current height itself since right is greater
            {
                if (height[left_pointer] > max_left_till_now)
                    max_left_till_now = height[left_pointer];
                else
                    total_area += max_left_till_now - height[left_pointer];
                left_pointer++;
            } else //Trap bounded by right max since left is greater than current val
            {
                if (height[right_pointer] > max_right_till_now)
                    max_right_till_now = height[right_pointer];
                else
                    total_area += max_right_till_now - height[right_pointer];
                right_pointer--;
            }
        }
        return total_area;
    }

    /*
    137. PROBLEM DESCRIPTION (https://leetcode.com/problems/first-unique-character-in-a-string/)
        Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

        Examples:
        s = "leetcode"
        return 0.

        s = "loveleetcode",
        return 2.
        Note: You may assume the string contain only lowercase letters.
    */
    public int firstUniqChar(String s)
    {
        int isEncountered[] = new int[26];
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++)
            isEncountered[s.charAt(iterator_i) - 'a']++;
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++)
            if (isEncountered[s.charAt(iterator_i) - 'a'] == 1)
                return iterator_i;
        return -1;
    }

    /*
    138. PROBLEM DESCRIPTION (https://leetcode.com/problems/perfect-squares/)
        Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

        Example 1:
        Input: n = 12
        Output: 3
        Explanation: 12 = 4 + 4 + 4.

        Example 2:
        Input: n = 13
        Output: 2
        Explanation: 13 = 4 + 9.
    */
    public int numSquares_alt(int n) //dynamic programming
    {
        int dp_arr[] = new int[n + 1];
        Arrays.fill(dp_arr, Integer.MAX_VALUE);
        for (int iterator_i = 1; 1.0 * iterator_i <= 1.0 * n / iterator_i; iterator_i++)
            dp_arr[iterator_i * iterator_i] = 1;

        for (int iterator_i = 2; iterator_i <= n; iterator_i++) // Corresponds to each dp_arr
        {
            if (dp_arr[iterator_i] == 1)
                continue;
            //Check if any j exists such i = j*j +k , dp[k_val] should be >0 (also a square)
            for (int iterator_j = 1; iterator_j * iterator_j < iterator_i; iterator_j++) {
                if (dp_arr[iterator_i - iterator_j * iterator_j] != Integer.MAX_VALUE)
                    dp_arr[iterator_i] = Math.min(dp_arr[iterator_i], dp_arr[iterator_i - iterator_j * iterator_j] + 1);
            }
        }
        return dp_arr[n];
    }

    public int numSquares_alt1(int n) //BFS Add primes to queue and continue search from there updating count array for reaching particular number
    {
        int count_arr[] = new int[n + 1];
        Arrays.fill(count_arr, Integer.MAX_VALUE);
        List<Integer> squares_list = new ArrayList<>();
        Queue<Integer> bfs_q = new LinkedList<>();
        for (int iterator_i = 1; 1.0 * iterator_i <= 1.0 * n / iterator_i; iterator_i++) {
            squares_list.add(iterator_i * iterator_i);
            count_arr[iterator_i * iterator_i] = 1;
            bfs_q.add(iterator_i * iterator_i);
        }
        // If n is basic square
        if (count_arr[n] == 1)
            return 1;

        while (!bfs_q.isEmpty()) {
            int current_val = bfs_q.poll();
            for (Integer basicSquares : squares_list) {
                if (current_val + basicSquares > n)
                    break;
                if (current_val + basicSquares < n && count_arr[current_val + basicSquares] == Integer.MAX_VALUE) //Push value
                {
                    count_arr[current_val + basicSquares] = count_arr[current_val] + 1;
                    bfs_q.add(current_val + basicSquares);
                } else if (current_val + basicSquares == n) // Since BFS will have least squares
                    return count_arr[current_val] + 1;
            }
        }
        return -1;
    }

    public int numSquares(int n) // Lagrange's four square theorem
    {
        //Check for basic prime count == 1
        int sqrt_num = (int) Math.sqrt(n);
        if (sqrt_num * sqrt_num == n)
            return 1;

        // Lagrange 3 square theorem : if for 4^k(8m+7) then count == 4
        int n_cpy = n;
        while (n % 4 == 0)
            n = n / 4;
        if (n % 8 == 7)
            return 4;

        // Check if count == 2
        for (int iterator_i = 1; iterator_i < Math.sqrt(n_cpy); iterator_i++) {
            int complement = n - iterator_i * iterator_i;
            sqrt_num = (int) Math.sqrt(complement);
            if (sqrt_num * sqrt_num == complement)
                return 2;
        }

        // If no cases match answer is 3
        return 3;

    }

    /*
    139. PROBLEM DESCRIPTION (https://leetcode.com/problems/path-sum/)
        Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the
        path equals the given sum.

        Note: A leaf is a node with no children.

        Example:
        Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    */

    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null)
            return false;
        if (root.right == null && root.left == null) {
            if (root.val == sum)
                return true;
            return false;
        }
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));

    }

    public boolean hasPathSum_alt(TreeNode root, int sum) //Reduce recursion stack for root==null
    {
        if (root == null)
            return false;
        return hasPathSumHelper(root, sum);

    }

    public boolean hasPathSumHelper(TreeNode root, int sum)
    {
        if (root == null)
            return false;
        if (root.right == null && root.left == null) {
            if (root.val == sum)
                return true;
            return false;
        }
        return (hasPathSumHelper(root.left, sum - root.val) || hasPathSumHelper(root.right, sum - root.val));
    }

    /*
    140. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-k-sorted-lists/)
        Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

        Example:
        Input:
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        Output: 1->1->2->3->4->4->5->6
    */
    public ListNode mergeKLists_alt(ListNode[] lists) // Sort k lists 2 at a time using one with the least as result node Time O(nk) Space O(1)
    {
        ListNode result_node = new ListNode(Integer.MIN_VALUE);
        for (int iterator_i = 0; iterator_i < lists.length; iterator_i++) {
            ListNode result_node_ptr = result_node.next, result_node_prev = result_node, curr_list_ptr = lists[iterator_i];
            while (curr_list_ptr != null) {
                while (result_node_ptr != null && result_node_ptr.val < curr_list_ptr.val) {
                    result_node_prev = result_node_ptr;
                    result_node_ptr = result_node_ptr.next;
                }
                if (result_node_ptr == null) {
                    result_node_prev.next = curr_list_ptr;
                    curr_list_ptr = null;
                } else {
                    result_node_prev.next = curr_list_ptr;
                    curr_list_ptr = curr_list_ptr.next;
                    result_node_prev.next.next = result_node_ptr;
                    result_node_prev = result_node_prev.next;
                }
            }
        }
        return result_node.next;
    }

    public ListNode mergeKLists_alt1(ListNode[] lists) // Using priority Queue Time O(nlogk), where k<<n Space O(k) for Priority Queue
    {
        PriorityQueue<ListNodeQueue> pq = new PriorityQueue();
        // Enter all starting nodes as initialization
        for (int iterator_i = 0; iterator_i < lists.length; iterator_i++) {
            if (lists[iterator_i] != null)
                pq.add(new ListNodeQueue(lists[iterator_i].val, lists[iterator_i]));
        }
        ListNode result_node = new ListNode(0), result_node_ptr = result_node;
        while (!pq.isEmpty()) {
            ListNodeQueue popped = pq.poll();
            result_node.next = popped.node;
            result_node = result_node.next;
            if (popped.node.next != null)
                pq.add(new ListNodeQueue(popped.node.next.val, popped.node.next));
        }
        return result_node_ptr.next;
    }

    public ListNode mergeKLists(ListNode[] lists) //Divide and Conquer using MergeSort Time: O(nlogk) Space O(1)
    {
        return mergeKListsDistributer(lists, 0, lists.length - 1);
    }

    public ListNode mergeKListsDistributer(ListNode[] lists, int lb, int ub)
    {
        if (lb == ub)
            return lists[lb];

        int mid = (lb + ub) / 2;
        ListNode leftSortedList = mergeKListsDistributer(lists, lb, mid);
        ListNode rightSortedList = mergeKListsDistributer(lists, mid + 1, ub);

        return mergeKListsMerger(leftSortedList, rightSortedList);
    }

    public ListNode mergeKListsMerger(ListNode list1, ListNode list2)
    {
        ListNode result_node = new ListNode(0), result_node_cpy = result_node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result_node.next = list1;
                list1 = list1.next;
            } else {
                result_node.next = list2;
                list2 = list2.next;
            }
            result_node = result_node.next;
        }
        if (list1 == null)
            result_node.next = list2;
        else
            result_node.next = list1;
        return result_node_cpy.next;
    }

    /*
    141. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
        Given an integer matrix, find the length of the longest increasing path.

        From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move
        outside of the boundary (i.e. wrap-around is not allowed).

        Example 1:
        Input: nums =
        [
          [9,9,4],
          [6,6,8],
          [2,1,1]
        ]
        Output: 4
        Explanation: The longest increasing path is [1, 2, 6, 9].

        Example 2:
        Input: nums =
        [
          [3,4,5],
          [3,2,6],
          [2,2,1]
        ]
        Output: 4
        Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
    */
    public int longestIncreasingPath(int[][] matrix)
    {
        if (matrix.length == 0)
            return 0;
        int memoization_arr[][] = new int[matrix.length][matrix[0].length], max_increasing_length = 0;
        for (int iterator_i = 0; iterator_i < matrix.length; iterator_i++)
            Arrays.fill(memoization_arr[iterator_i], -1);
        for (int iterator_i = 0; iterator_i < matrix.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < matrix[0].length; iterator_j++) {
                longestIncreasingPathHelper(matrix, iterator_i, iterator_j, memoization_arr);
                max_increasing_length = Math.max(max_increasing_length, memoization_arr[iterator_i][iterator_j]);
            }
        }
        return max_increasing_length;
    }

    public int longestIncreasingPathHelper(int[][] matrix, int row, int col, int[][] memoization_arr)
    {
        if (memoization_arr[row][col] >= 0)
            return memoization_arr[row][col];
        int directions[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int max_path_len = 0;
        for (int[] direction : directions) {
            int curr_row = row + direction[0], curr_col = col + direction[1];
            if (curr_row < 0 || curr_row >= matrix.length || curr_col < 0 || curr_col >= matrix[0].length || matrix[row][col] >= matrix[curr_row][curr_col])
                continue;
            max_path_len = Math.max(max_path_len, longestIncreasingPathHelper(matrix, curr_row, curr_col, memoization_arr));
        }
        memoization_arr[row][col] = max_path_len + 1;
        return memoization_arr[row][col];
    }

    /*
    142. PROBLEM DESCRIPTION (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
        Given two arrays, write a function to compute their intersection.

        Example 1:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]

        Example 2:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [4,9]
        Note:
        1. Each element in the result should appear as many times as it shows in both arrays.
        2. The result can be in any order.

        Follow up:
        1. What if the given array is already sorted? How would you optimize your algorithm?
        2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
        3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    */
    public int[] intersect(int[] nums1, int[] nums2)
    {
        if (nums1.length < nums2.length)
            return intersect(nums2, nums1);
        HashMap<Integer, Integer> hmap = new HashMap();
        for (int iterator_i = 0; iterator_i < nums1.length; iterator_i++)
            hmap.put(nums1[iterator_i], hmap.getOrDefault(nums1[iterator_i], 0) + 1);

        int result_index = 0;
        for (int iterator_i = 0; iterator_i < nums2.length; iterator_i++) {
            if (hmap.getOrDefault(nums2[iterator_i], 0) > 0) {
                nums1[result_index++] = nums2[iterator_i];
                hmap.put(nums2[iterator_i], hmap.get(nums2[iterator_i]) - 1);
            }
        }
        return Arrays.copyOf(nums1, result_index);
    }

    /*
    143. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-string/)
        Write a function that reverses a string. The input string is given as an array of characters char[].
        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
        You may assume all the characters consist of printable ascii characters.

        Example 1:
        Input: ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]

        Example 2:
        Input: ["H","a","n","n","a","h"]
        Output: ["h","a","n","n","a","H"]
    */
    public void reverseString(char[] s)
    {
        for (int iterator_i = 0; iterator_i < s.length / 2; iterator_i++) {
            char temp = s[iterator_i];
            s[iterator_i] = s[s.length - 1 - iterator_i];
            s[s.length - 1 - iterator_i] = temp;
        }
    }

    /*
    144. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-intervals/)
        Given a collection of intervals, merge all overlapping intervals.

        Example 1:
        Input: [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

        Example 2:
        Input: [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    */
    public int[][] merge(int[][] intervals)
    {
        if (intervals.length == 0)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int iterator_i = 1, current_max = intervals[0][1], current_min = intervals[0][0];
        LinkedList<int[]> result_list = new LinkedList<>();
        while (iterator_i < intervals.length) {
            if (intervals[iterator_i][0] <= current_max)
                current_max = Math.max(current_max, intervals[iterator_i][1]);
            else {
                result_list.add(new int[]{current_min, current_max});
                current_min = intervals[iterator_i][0];
                current_max = intervals[iterator_i][1];
            }
            iterator_i++;
        }
        result_list.add(new int[]{current_min, current_max});
        // make copy of result
        return result_list.toArray(new int[result_list.size()][]);
    }

    /*
        145. PROBLEM DESCRIPTION (https://leetcode.com/problems/median-of-two-sorted-arrays/)
            There are two sorted arrays nums1 and nums2 of size m and n respectively.

            Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
            You may assume nums1 and nums2 cannot be both empty.

            Example 1:
            nums1 = [1, 3]
            nums2 = [2]
            The median is 2.0

            Example 2:
            nums1 = [1, 2]
            nums2 = [3, 4]
            The median is (2 + 3)/2 = 2.5
        */
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if (nums1.length < nums2.length) // Swap bcuz of cornercase when no elements present in nums1
        {
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int lb_arr1 = 0, ub_arr1 = nums1.length - 1;
        int elements_in_median = (int) Math.ceil((nums1.length + nums2.length + 1) / 2.0);
        while (lb_arr1 <= ub_arr1) {
            int elements_in_nums1 = Math.min((lb_arr1 + ub_arr1 + 2) / 2, elements_in_median);
            int elements_in_nums2 = elements_in_median - elements_in_nums1;

            if (elements_in_nums2 > nums2.length) {
                lb_arr1 = elements_in_nums1;// Increase elements chosen from first arr
                continue;
            }
            if (elements_in_nums1 > nums1.length) {
                ub_arr1 = elements_in_nums1 - 1;// Decrease elements chosen from first arr
                continue;
            }

            int last_chosen_nums1 = elements_in_nums1 > 0 ? nums1[elements_in_nums1 - 1] : Integer.MIN_VALUE;
            int last_chosen_nums2 = elements_in_nums2 > 0 ? nums2[elements_in_nums2 - 1] : Integer.MIN_VALUE;
            int last_nums1 = elements_in_nums1 >= nums1.length ? Integer.MAX_VALUE : nums1[elements_in_nums1];
            int last_nums2 = elements_in_nums2 >= nums2.length ? Integer.MAX_VALUE : nums2[elements_in_nums2];

            if (elements_in_nums2 < nums2.length && elements_in_nums1 >= 0 && last_chosen_nums1 > last_nums2)
                ub_arr1 = elements_in_nums1 - 1;
            else if (elements_in_nums1 < nums1.length && elements_in_nums2 >= 0 && last_chosen_nums2 > last_nums1)
                lb_arr1 = elements_in_nums1;
            else {
                if ((nums1.length + nums2.length) % 2 != 0) {
                    if (last_chosen_nums1 > last_chosen_nums2)
                        return last_chosen_nums1;
                    else
                        return last_chosen_nums2;
                } else {
                    int total_med = 0, max2 = last_chosen_nums1;
                    if (last_chosen_nums1 > last_chosen_nums2) {
                        max2 = last_chosen_nums2;
                        total_med += last_chosen_nums1;
                    } else
                        total_med += last_chosen_nums2;
                    if (elements_in_nums1 - 1 > 0)
                        max2 = Math.max(max2, nums1[elements_in_nums1 - 2]);
                    if (elements_in_nums2 - 1 > 0)
                        max2 = Math.max(max2, nums2[elements_in_nums2 - 2]);
                    return (total_med + max2) / 2.0;
                }
            }

        }
        return 0.0;
    }

    /*
    146. PROBLEM DESCRIPTION (https://leetcode.com/problems/excel-sheet-column-title/)
        Given a positive integer, return its corresponding column title as appear in an Excel sheet.

        For example:
            1 -> A
            2 -> B
            3 -> C
            ...
            26 -> Z
            27 -> AA
            28 -> AB
            ...

        Example 1:
        Input: 1
        Output: "A"

        Example 2:
        Input: 28
        Output: "AB"

        Example 3:
        Input: 701
        Output: "ZY"
    */
    public String convertToTitle(int n)
    {
        String final_str = "";
        while (n != 0) {
            final_str = (char) ((n - 1) % 26 + 'A') + final_str;
            n = (n - 1) / 26;
        }
        return final_str;
    }

    /*
    147. PROBLEM DESCRIPTION (https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
        Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target
        number.
        The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than
        index2.

        Note:
        1. Your returned answers (both index1 and index2) are not zero-based.
        2. You may assume that each input would have exactly one solution and you may not use the same element twice.

        Example:
        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
    */
    public int[] twoSum2(int[] numbers, int target)
    {
        int left_ptr = 0, right_ptr = numbers.length - 1;
        while (left_ptr < right_ptr) {
            if (numbers[left_ptr] + numbers[right_ptr] < target)
                left_ptr++;
            else if ((numbers[left_ptr] + numbers[right_ptr] > target))
                right_ptr--;
            else
                return new int[]{left_ptr + 1, right_ptr + 1};
        }
        return null;
    }

    /*
    148. PROBLEM DESCRIPTION (https://leetcode.com/problems/zigzag-conversion/)
        The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern
         in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"

        Write the code that will take a string and make this conversion given a number of rows:
        string convert(string s, int numRows);

        Example 1:
        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"

        Example 2:
        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:
        P     I    N
        A   L S  I G
        Y A   H R
        P     I
    */
    public String convert_alt(String s, int numRows)
    {
        String separate_rows[] = new String[numRows], result_str = "";
        if (numRows == 1)
            return s;
        for (int iterator_i = 0; iterator_i < separate_rows.length; iterator_i++)
            separate_rows[iterator_i] = "";
        for (int iterator_i = 0; iterator_i < s.length(); iterator_i++) {
            int pattern_mod_val = (iterator_i) % (2 * numRows - 2);
            if (pattern_mod_val < numRows)
                separate_rows[pattern_mod_val] += s.charAt(iterator_i);
            else {
                separate_rows[2 * numRows - 2 - pattern_mod_val] += s.charAt(iterator_i);
            }
        }
        for (String row_string : separate_rows)
            result_str += row_string;
        return result_str;
    }

    public String convert(String s, int numRows) // use String Builder to avoid String arrays. Process row at a time
    {
        if (numRows == 1)
            return s;
        StringBuilder result = new StringBuilder();
        for (int iterator_i = 0; iterator_i < numRows; iterator_i++) {
            for (int iterator_j = 0; iterator_j + iterator_i < s.length(); iterator_j += (2 * numRows - 2)) {
                result.append(s.charAt(iterator_i + iterator_j));
                if (iterator_i != 0 && iterator_i != (numRows - 1) && (iterator_j - iterator_i + 2 * numRows - 2) < s.length())
                    result.append(s.charAt(iterator_j - iterator_i + 2 * numRows - 2));
            }
        }
        return result.toString();
    }

    /*
    149. PROBLEM DESCRIPTION (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
        Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
        An example is the root-to-leaf path 1->2->3 which represents the number 123. Find the total sum of all root-to-leaf numbers.

        Note: A leaf is a node with no children.
        Example:
        Input: [1,2,3]
            1
           / \
          2   3
        Output: 25
        Explanation:
        The root-to-leaf path 1->2 represents the number 12.
        The root-to-leaf path 1->3 represents the number 13.
        Therefore, sum = 12 + 13 = 25.

        Example 2:
        Input: [4,9,0,5,1]
            4
           / \
          9   0
         / \
        5   1
        Output: 1026
        Explanation:
        The root-to-leaf path 4->9->5 represents the number 495.
        The root-to-leaf path 4->9->1 represents the number 491.
        The root-to-leaf path 4->0 represents the number 40.
        Therefore, sum = 495 + 491 + 40 = 1026.
    */
    public int sumNumbers(TreeNode root)
    {
        return sumNumbersHelper(root, 0);
    }

    public int sumNumbersHelper(TreeNode root, int sum_till_now)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return sum_till_now * 10 + root.val;
        return sumNumbersHelper(root.left, sum_till_now * 10 + root.val) + sumNumbersHelper(root.right, sum_till_now * 10 + root.val);
    }

    /*
    150. PROBLEM DESCRIPTION (https://leetcode.com/problems/burst-balloons/)
        Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are
        asked to burst all the balloons. If you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left
        and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

        Find the maximum coins you can collect by bursting the balloons wisely.
        Note:
        1. You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
        2. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

        Example:
        Input: [3,1,5,8]
        Output: 167
        Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
    */
    public int maxCoins_alt(int[] nums) //Recursion with memoization
    {
        int extended_balloons[] = new int[nums.length + 2], memoization_arr[][] = new int[nums.length + 2][nums.length + 2];
        for (int iterator_i = 1; iterator_i <= nums.length; iterator_i++)
            extended_balloons[iterator_i] = nums[iterator_i - 1];
        extended_balloons[0] = extended_balloons[nums.length + 1] = 1;
        return maxCoinsHelper(extended_balloons, 0, extended_balloons.length - 1, memoization_arr);

    }

    public int maxCoinsHelper(int[] balloons, int lb, int ub, int[][] memoization_arr) // lb and ub are boundaries will not be bursted
    {
        if (lb + 1 == ub) //No balloon to burst
            return 0;
        if (memoization_arr[lb][ub] > 0)
            return memoization_arr[lb][ub];
        int max_till_now = Integer.MIN_VALUE;
        for (int iterator_i = lb + 1; iterator_i < ub; iterator_i++) {
            max_till_now = Math.max(max_till_now, balloons[lb] * balloons[iterator_i] * balloons[ub] +
                    maxCoinsHelper(balloons, lb, iterator_i, memoization_arr) + maxCoinsHelper(balloons, iterator_i, ub, memoization_arr));
        }
        memoization_arr[lb][ub] = max_till_now;
        return max_till_now;
    }

    public int maxCoins(int[] nums) //Dp approach Start with size 3 sets since size 2 is 0
    {
        int extended_balloons[] = new int[nums.length + 2], dp_arr[][] = new int[nums.length + 2][nums.length + 2];
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++)
            extended_balloons[iterator_i + 1] = nums[iterator_i];
        extended_balloons[0] = extended_balloons[nums.length + 1] = 1;

        for (int iterator_size_interval = 2; iterator_size_interval < extended_balloons.length; iterator_size_interval++) {
            for (int iterator_left = 0; iterator_left + iterator_size_interval < extended_balloons.length; iterator_left++) {
                int right_balloon = iterator_left + iterator_size_interval, maxCoin = Integer.MIN_VALUE;
                for (int iterator_dp = iterator_left + 1; iterator_dp < right_balloon; iterator_dp++) {
                    maxCoin = Math.max((dp_arr[iterator_left][iterator_dp] + dp_arr[iterator_dp][right_balloon]
                            + extended_balloons[iterator_left] * extended_balloons[iterator_dp] * extended_balloons[right_balloon]), maxCoin);
                }
                dp_arr[iterator_left][right_balloon] = maxCoin;
            }
        }
        return dp_arr[0][dp_arr.length - 1];
    }

    /*
    151. PROBLEM DESCRIPTION (https://leetcode.com/problems/isomorphic-strings/)
        Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.
        All occurrences of a character must be replaced with another character while preserving the order of characters. No two
        characters may map to the same character but a character may map to itself.

        Example 1:
        Input: s = "egg", t = "add"
        Output: true

        Example 2:
        Input: s = "foo", t = "bar"
        Output: false

        Example 3:
        Input: s = "paper", t = "title"
        Output: true

        Note:
        You may assume both s and t have the same length.
    */
    public boolean isIsomorphic(String s, String t)
    {
        int mapping_s[] = new int[256], mapping_t[] = new int[256]; //Extended Ascii
        Arrays.fill(mapping_s, -1);
        Arrays.fill(mapping_t, -1);

        for (int iterator_s = 0; iterator_s < s.length(); iterator_s++) {
            if (mapping_s[s.charAt(iterator_s)] != mapping_t[t.charAt(iterator_s)])
                return false;
            mapping_s[s.charAt(iterator_s)] = s.charAt(iterator_s);
            mapping_t[t.charAt(iterator_s)] = s.charAt(iterator_s);
        }
        return true;
    }

    /*
    152. PROBLEM DESCRIPTION (https://leetcode.com/problems/ugly-number/)
        Write a program to check whether a given number is an ugly number. Ugly numbers are positive numbers whose prime factors only
        include 2, 3, 5.

        Example 1:
        Input: 6
        Output: true
        Explanation: 6 = 2 × 3

        Example 2:
        Input: 8
        Output: true
        Explanation: 8 = 2 × 2 × 2

        Example 3:
        Input: 14
        Output: false
        Explanation: 14 is not ugly since it includes another prime factor 7.

        Note:
        1. 1 is typically treated as an ugly number.
        2. Input is within the 32-bit signed integer range: [−2^31,  2^31 − 1].
    */
    public boolean isUgly(int num)
    {
        if (num <= 0)
            return false;
        int primes_for_ugly[] = new int[]{2, 3, 5}, prime_iterator = 0;
        while (num != 1 && prime_iterator < primes_for_ugly.length) {
            int current_prime = primes_for_ugly[prime_iterator++];
            while (num % current_prime == 0)
                num /= current_prime;
        }
        if (num == 1)
            return true;
        return false;
    }

    /*
    153. PROBLEM DESCRIPTION (https://leetcode.com/problems/restore-ip-addresses/)
        Given a string containing only digits, restore it by returning all possible valid IP address combinations.
        A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

        Example:
        Input: "25525511135"
        Output: ["255.255.11.135", "255.255.111.35"]
    */
    public List<String> restoreIpAddresses(String s)
    {
        List<String> list = new ArrayList<>();
        for (int len1 = 1; len1 < 4 && len1 <= s.length(); len1++) {
            if ((len1 > 1 && s.charAt(0) == '0') || (len1 == 3 && Integer.parseInt(s.substring(0, len1)) > 255))
                continue;
            for (int len2 = 1; len2 < 4 && len1 + len2 <= s.length(); len2++) {
                if ((len2 > 1 && s.charAt(len1) == '0') || (len2 == 3 && Integer.parseInt(s.substring(len1, len1 + len2)) > 255))
                    continue;
                for (int len3 = 1; len3 < 4 && len1 + len2 + len3 <= s.length(); len3++) {
                    if ((len3 > 1 && s.charAt(len1 + len2) == '0') || (len3 == 3 && Integer.parseInt(s.substring(len1 + len2, len1 + len2 + len3)) > 255))
                        continue;
                    int len4 = s.length() - len1 - len2 - len3;
                    if (len4 > 0 && len4 < 4) {
                        if ((len4 > 1 && s.charAt(len1 + len2 + len3) == '0') || (len4 == 3 && Integer.parseInt(s.substring(len1 + len2 + len3, len1 + len2 + len3 + len4)) > 255))
                            continue;
                        list.add(s.substring(0, len1) + "." + s.substring(len1, len1 + len2) + "." + s.substring(len1 + len2, len1 + len2 + len3) + "." +
                                s.substring(len1 + len2 + len3, len1 + len2 + len3 + len4));
                    }
                }
            }
        }
        return list;
    }

    /*
    154. PROBLEM DESCRIPTION (https://leetcode.com/problems/triangle/)
        Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

        For example, given the following triangle
        [
             [2],
            [3,4],
           [6,5,7],
          [4,1,8,3]
        ]
        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

        Note:
        Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
    */
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if (triangle.size() == 0)
            return 0;
        int dp_current_row[] = triangle.get(triangle.size() - 1).stream().mapToInt(i -> i).toArray();

        for (int iterator_row = triangle.size() - 2; iterator_row >= 0; iterator_row--) {
            List<Integer> current_list = triangle.get(iterator_row);
            for (int iterator_list = dp_current_row.length - 1; iterator_list >= triangle.size() - iterator_row - 1; iterator_list--)
                dp_current_row[iterator_list] = Math.min(dp_current_row[iterator_list - 1], dp_current_row[iterator_list]) + current_list.get(iterator_list - (triangle.size() - iterator_row - 1));
        }
        return dp_current_row[dp_current_row.length - 1];
    }

    /*
    155. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-paths/)
        Given a binary tree, return all root-to-leaf paths.

        Note: A leaf is a node with no children.

        Example:
        Input:
           1
         /   \
        2     3
         \
          5

        Output: ["1->2->5", "1->3"]
        Explanation: All root-to-leaf paths are: 1->2->5, 1->3
    */
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> list = new ArrayList<>();
        binaryTreePathsHelper(root, list, new StringBuilder());
        return list;
    }

    public void binaryTreePathsHelper(TreeNode root, List<String> list, StringBuilder current_path)
    {
        if (root == null)
            return;
        int len = current_path.length();
        current_path.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(current_path.toString());
            current_path.setLength(len);
            return;
        }
        current_path.append("->");
        binaryTreePathsHelper(root.left, list, current_path);
        binaryTreePathsHelper(root.right, list, current_path);
        current_path.setLength(len);
    }

    /*
    156. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-of-smaller-numbers-after-self/)
        You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i]
        is the number of smaller elements to the right of nums[i].

        Example:
        Input: [5,2,6,1]
        Output: [2,1,1,0]
        Explanation:
        To the right of 5 there are 2 smaller elements (2 and 1).
        To the right of 2 there is only 1 smaller element (1).
        To the right of 6 there is 1 smaller element (1).
        To the right of 1 there is 0 smaller element.
    */

    public List<Integer> countSmaller(int[] nums) //Using MergeSort Implementation
    {
        List<Integer> count_smaller_right = new ArrayList<>();
        if (nums.length == 0)
            return count_smaller_right;
        countSmallerTuple num_arr[] = new countSmallerTuple[nums.length];
        for (int iterator_i = 0; iterator_i < nums.length; iterator_i++)
            num_arr[iterator_i] = new countSmallerTuple(nums[iterator_i], iterator_i);
        int count_arr[] = new int[nums.length];
        countSmallerMergeSort(num_arr, count_arr, 0, nums.length - 1);
        return Arrays.stream(count_arr).boxed().collect(Collectors.toList());
    }

    public void countSmallerMergeSort(countSmallerTuple[] nums, int[] count_arr, int lb, int ub)
    {
        if (lb < ub) {
            int mid = lb + (ub - lb) / 2;
            countSmallerMergeSort(nums, count_arr, lb, mid);
            countSmallerMergeSort(nums, count_arr, mid + 1, ub);
            countSmallerMerge(nums, count_arr, lb, mid, ub);
        }
    }

    public void countSmallerMerge(countSmallerTuple[] nums, int[] count_arr, int lb, int mid, int ub)
    {
        int index_left = mid, index_right = ub, sorted_index = ub - lb, current_increment = ub - mid;//Total elements in right subarray
        countSmallerTuple sorted_result[] = new countSmallerTuple[ub - lb + 1];
        while (index_left >= lb && index_right > mid) {
            if (nums[index_left].arr_val > nums[index_right].arr_val)// greater than all elements in right subarray
            {
                sorted_result[sorted_index] = nums[index_left];
                count_arr[sorted_result[sorted_index].index] = count_arr[sorted_result[sorted_index--].index] + current_increment;
                index_left--;
            } else {
                sorted_result[sorted_index] = nums[index_right];
                count_arr[sorted_result[sorted_index].index] = count_arr[sorted_result[sorted_index--].index];
                current_increment--;
                index_right--;
            }
        }
        while (index_right > mid) {
            sorted_result[sorted_index] = nums[index_right];
            count_arr[sorted_result[sorted_index].index] = count_arr[sorted_result[sorted_index--].index];
            index_right--;
        }
        while (index_left >= lb) {
            sorted_result[sorted_index] = nums[index_left];
            count_arr[sorted_result[sorted_index].index] = count_arr[sorted_result[sorted_index--].index];
            index_left--;
        }

        for (int iterator_i = lb; iterator_i <= ub; iterator_i++)
            nums[iterator_i] = sorted_result[iterator_i - lb];
    }

    /*
    157. PROBLEM DESCRIPTION (https://leetcode.com/problems/intersection-of-two-arrays/)
        Given two arrays, write a function to compute their intersection.

        Example 1:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]

        Example 2:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]

        Note:
        Each element in the result must be unique.
        The result can be in any order.
    */
    public int[] intersection(int[] nums1, int[] nums2)
    {
        if (nums1.length < nums2.length)
            intersection(nums2, nums1);
        HashSet hset = new HashSet();
        for (int numval : nums1)
            hset.add(numval);
        int counter_index = 0;
        for (int numval : nums2) {
            if (hset.contains(numval)) {
                nums1[counter_index++] = numval;
                hset.remove(numval);
            }
        }
        return Arrays.copyOf(nums1, counter_index);
    }

    /*
    158. PROBLEM DESCRIPTION (https://leetcode.com/problems/the-skyline-problem/)
        A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
        Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program
        to output the skyline formed by these buildings collectively (Figure B).

        The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x
        coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that
        0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on
        an absolutely flat surface at height 0.

        For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

        The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines
        a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building
        ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two
        adjacent buildings should be considered part of the skyline contour.

        For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

        Notes:
        The number of buildings in any input list is guaranteed to be in the range [0, 10000].
        The input list is already sorted in ascending order by the left x position Li.
        The output list must be sorted by the x position.
        There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
    */
    public List<List<Integer>> getSkyline_alt(int[][] buildings) // using Treemap O(nlogn)
    {
        List<int[]> height_changes = new ArrayList<>();
        List<List<Integer>> outline = new ArrayList<>();
        for (int[] building : buildings) {
            height_changes.add(new int[]{building[0], -building[2]});
            height_changes.add(new int[]{building[1], building[2]});
        }
        Collections.sort(height_changes, (a, b) -> (a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0])));

        TreeMap<Integer, Integer> tmap = new TreeMap<>(Collections.reverseOrder());
        tmap.put(0, 1);
        int previous_height = 0;
        for (int[] height_encountered : height_changes) {
            if (height_encountered[1] < 0) {
                Integer mapval = tmap.get(-height_encountered[1]);
                int count = mapval == null ? 1 : mapval + 1;
                tmap.put(-height_encountered[1], count);
            } else {
                Integer mapval = tmap.get(height_encountered[1]);
                if (mapval == 1)
                    tmap.remove(height_encountered[1]);
                else
                    tmap.put(height_encountered[1], mapval - 1);
            }
            int current_max_height = tmap.firstKey();
            if (current_max_height != previous_height) {
                List<Integer> new_addition = new ArrayList<>();
                new_addition.add(height_encountered[0]);
                new_addition.add(current_max_height);
                outline.add(new_addition);
                previous_height = current_max_height;
            }
        }
        return outline;
    }

    public List<List<Integer>> getSkyline(int[][] buildings) //Merge Sort logic
    {
        if (buildings.length == 0)
            return new ArrayList<>();
        List<List<Integer>> finlist = getSkylineMergeHelper(buildings, 0, buildings.length - 1);
        return finlist;
    }

    public List<List<Integer>> getSkylineMergeHelper(int[][] buildings, int lb, int ub)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (ub == lb) {
            List<Integer> outline = new ArrayList<>();
            outline.add(buildings[lb][0]);
            outline.add(buildings[lb][2]);
            result.add(outline);
            outline = new ArrayList<>();
            outline.add(buildings[lb][1]);
            outline.add(0);
            result.add(outline);
            return result;
        }

        int mid = lb + (ub - lb) / 2;
        List<List<Integer>> left_outline = getSkylineMergeHelper(buildings, lb, mid);
        List<List<Integer>> right_outline = getSkylineMergeHelper(buildings, mid + 1, ub);

        return getSkylineMerge(left_outline, right_outline);
    }

    public List<List<Integer>> getSkylineMerge(List<List<Integer>> left, List<List<Integer>> right)
    {
        List<List<Integer>> result = new ArrayList<>();
        int current_x = 0, height_left = 0, height_right = 0, curr_height = 0, left_ptr = 0, right_ptr = 0;
        while (left_ptr < left.size() && right_ptr < right.size()) {
            List<Integer> l1 = left.get(left_ptr);
            List<Integer> l2 = right.get(right_ptr);

            if (l1.get(0) < l2.get(0)) {
                current_x = l1.get(0);
                height_left = l1.get(1);
                left_ptr++;
            } else if (l1.get(0) > l2.get(0)) {
                current_x = l2.get(0);
                height_right = l2.get(1);
                right_ptr++;
            } else {
                current_x = l1.get(0);
                height_right = l2.get(1);
                height_left = l1.get(1);
                left_ptr++;
                right_ptr++;
            }

            //Check if new height recorded
            if (curr_height != Math.max(height_left, height_right)) {
                curr_height = Math.max(height_left, height_right);
                List<Integer> new_add = new ArrayList<>();
                new_add.add(current_x);
                new_add.add(curr_height);
                result.add(new_add);
            }
        }
        while (left_ptr < left.size()) {
            result.add(left.get(left_ptr));
            left_ptr++;
        }
        while (right_ptr < right.size()) {
            result.add(right.get(right_ptr));
            right_ptr++;
        }
        return result;
    }

    /*
    159. PROBLEM DESCRIPTION (http://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
        Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

        Example 1:
        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        Output: 6
        Explanation: The LCA of nodes 2 and 8 is 6.

        Example 2:
        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        Output: 2
        Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

        Note:
        1. All of the nodes' values will be unique.
        2. p and q are different and both values will exist in the BST.
    */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
            return root;
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor2(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor2(root.left, p, q);
        return root;
    }

    /*
    160. PROBLEM DESCRIPTION (https://leetcode.com/problems/h-index/)
        Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's
        h-index. According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h
        citations each, and the other N − h papers have no more than h citations each."

        Example:
        Input: citations = [3,0,6,1,5]
        Output: 3
        Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
             received 3, 0, 6, 1, 5 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.
        Note: If there are several possible values for h, the maximum one is taken as the h-index.
    */
    public int hIndex_sort(int[] citations) //Using sort
    {
        Arrays.sort(citations);
        for (int iterator_i = 0; iterator_i < citations.length; iterator_i++) {
            if (citations[iterator_i] >= (citations.length - iterator_i))
                return citations.length - iterator_i;
        }
        return 0;
    }

    public int hIndex_bucket(int[] citations) //Buckets Approach
    {
        int buckets[] = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation <= citations.length)
                buckets[citation]++;
            else
                buckets[buckets.length - 1]++;
        }
        for (int iterator_i = buckets.length - 1, count_till_now = 0; iterator_i >= 0; iterator_i--) {
            count_till_now += buckets[iterator_i];
            if (count_till_now >= iterator_i)
                return iterator_i;
        }
        return 0;
    }

    public int hIndex(int[] citations) //In Place Bucket Sort Approach
    {
        for (int iterator_i = 0; iterator_i < citations.length; iterator_i++) {
            int current_citation = citations[iterator_i], next_citation = 0;
            if (current_citation < 0) // Already accounted for
                continue;
            citations[iterator_i] = -1; // No entries in this bucket till now
            if (current_citation < citations.length) {
                while ((next_citation = citations[current_citation]) > -1) {
                    citations[current_citation] = -2;//Since positive and this is first occurrence encountered
                    if (next_citation >= citations.length)
                        break;
                    current_citation = next_citation;
                }
                if (next_citation < citations.length)
                    citations[current_citation]--; // Increase count of occurrence
            }
        }

        int count_till_now = 0;
        for (int iterator_i = 0; iterator_i < citations.length; iterator_i++) {
            count_till_now += Math.max(-citations[iterator_i] - 1, 0);
            if (count_till_now >= citations.length - iterator_i)
                return iterator_i;
        }
        return citations.length;
    }

    /*
    161. PROBLEM DESCRIPTION (https://leetcode.com/problems/sum-of-left-leaves/)
        Find the sum of all left leaves in a given binary tree.

        Example:

            3
           / \
          9  20
            /  \
           15   7

        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
    */
    public int sumOfLeftLeaves_alt(TreeNode root) //With Helper
    {
        if (root == null)
            return 0;
        return sumOfLeftLeavesHelper(root, false);
    }

    public int sumOfLeftLeavesHelper(TreeNode root, boolean isLeft)
    {
        if (root.left == null && root.right == null) {
            if (isLeft)
                return root.val;
            return 0;
        }
        return (root.left != null ? sumOfLeftLeavesHelper(root.left, true) : 0) + (root.right != null ? sumOfLeftLeavesHelper(root.right, false) : 0);
    }

    public int sumOfLeftLeaves(TreeNode root) //Without Helper
    {
        int sum = 0;
        if (root == null)
            return sum;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);
        }

        return sum + sumOfLeftLeaves(root.right);
    }

    /*
    162. PROBLEM DESCRIPTION (https://leetcode.com/problems/ransom-note/)
        Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that
        will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

        Each letter in the magazine string can only be used once in your ransom note.
        Example 1:
        Input: ransomNote = "a", magazine = "b"
        Output: false

        Example 2:
        Input: ransomNote = "aa", magazine = "ab"
        Output: false

        Example 3:
        Input: ransomNote = "aa", magazine = "aab"
        Output: true
    */
    public boolean canConstruct(String ransomNote, String magazine)
    {
        int count_characters[] = new int[26];//Ascii Set
        for (char c : magazine.toCharArray())
            count_characters[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            int curr_val = --count_characters[c - 'a'];
            if (curr_val < 0)
                return false;
        }
        return true;
    }

    /*
    163. PROBLEM DESCRIPTION (https://leetcode.com/problems/reconstruct-itinerary/)
        Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in
        order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

        Note:
        1. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
        2. All airports are represented by three capital letters (IATA code).
        3. You may assume all tickets form at least one valid itinerary.

        Example 1:
        Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

        Example 2:
        Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
        Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
    */
    public List<String> findItinerary_bfs(List<List<String>> tickets) //BFS
    {
        HashMap<String, PriorityQueue<String>> hmap = new HashMap<>();
        for (int iterator_i = 0; iterator_i < tickets.size(); iterator_i++)
            hmap.computeIfAbsent(tickets.get(iterator_i).get(0), a -> new PriorityQueue<>()).add(tickets.get(iterator_i).get(1));

        Stack<String> output_stck = new Stack<>();
        LinkedList<String> final_list = new LinkedList<>();
        output_stck.push("JFK");
        String next_stop = "";
        while (!output_stck.isEmpty()) {
            while ((hmap.get(output_stck.peek()) != null) && (next_stop = hmap.get(output_stck.peek()).poll()) != null)
                output_stck.push(next_stop);

            final_list.add(0, output_stck.pop());
        }
        return final_list;
    }

    public List<String> findItinerary(List<List<String>> tickets) //DFS
    {
        HashMap<String, PriorityQueue<String>> hmap = new HashMap<>();
        for (int iterator_i = 0; iterator_i < tickets.size(); iterator_i++)
            hmap.computeIfAbsent(tickets.get(iterator_i).get(0), a -> new PriorityQueue<>()).add(tickets.get(iterator_i).get(1));

        LinkedList<String> final_string = new LinkedList<>();
        findItinerary_dfsHelper(final_string, "JFK", hmap);
        return final_string;
    }

    public void findItinerary_dfsHelper(LinkedList<String> final_string, String airport, HashMap<String, PriorityQueue<String>> hmap)
    {
        String next_airport = "";
        while (hmap.get(airport) != null && (next_airport = hmap.get(airport).poll()) != null)
            findItinerary_dfsHelper(final_string, next_airport, hmap);
        final_string.add(0, airport);
    }

    /*
    164. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-number-of-refueling-stops/)
        A car travels from a starting position to a destination which is target miles east of the starting position.
        Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of
        the starting position, and has station[i][1] liters of gas. The car starts with an infinite tank of gas, which
        initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives. When the car
        reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car. What is the
        least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.

        Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
        If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

        Example 1:
            Input: target = 1, startFuel = 1, stations = []
            Output: 0
            Explanation: We can reach the target without refueling.

        Example 2:
            Input: target = 100, startFuel = 1, stations = [[10,100]]
            Output: -1
            Explanation: We can't reach the target (or even the first gas station).

        Example 3:
            Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
            Output: 2
            Explanation:
            We start with 10 liters of fuel.
            We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
            Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
            and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
            We made 2 refueling stops along the way, so we return 2.

        Note:
            1 <= target, startFuel, stations[i][1] <= 10^9
            0 <= stations.length <= 500
            0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
    */
    public int minRefuelStops_dp(int target, int startFuel, int[][] stations)
    {
        int dp_arr[] = new int[stations.length+1]; // Store maximum distance reached using index stops(0 to num_stations)
        dp_arr[0] = startFuel;

        for(int iterator_station=0;iterator_station<stations.length;iterator_station++)
        {
            for (int iterator_refuels = iterator_station; iterator_refuels >= 0; iterator_refuels--)
            {
                if(dp_arr[iterator_refuels]>=stations[iterator_station][0])
                    dp_arr[iterator_refuels + 1] = Math.max(dp_arr[iterator_refuels + 1], dp_arr[iterator_refuels] + stations[iterator_station][1]);
            }
        }

        for(int iterator_i=0;iterator_i<=stations.length;iterator_i++)
            if(dp_arr[iterator_i]>=target)
                return iterator_i;
        return -1;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations)
    {
        PriorityQueue<Integer> fuel_capacity_passed = new PriorityQueue(Collections.reverseOrder());
        int iterator_index = 0, prev_distance_covered = 0, refuel_stops=0,current_fuel=startFuel;
        while(iterator_index<stations.length)
        {
            current_fuel = current_fuel -(stations[iterator_index][0]-prev_distance_covered); // current fuel capaity after reaching station i
            while(!fuel_capacity_passed.isEmpty() && current_fuel<0)
            {
                current_fuel += fuel_capacity_passed.poll();
                refuel_stops++;
            }

            if(current_fuel<0)
                return -1;

            prev_distance_covered = stations[iterator_index][0];
            fuel_capacity_passed.add(stations[iterator_index++][1]);
        }

        while(!fuel_capacity_passed.isEmpty()  && current_fuel<target-prev_distance_covered)
        {
            current_fuel += fuel_capacity_passed.poll();
            refuel_stops++;
        }
        return current_fuel>=target-prev_distance_covered?refuel_stops:-1;

    }

    /*
    165. PROBLEM DESCRIPTION (https://leetcode.com/problems/largest-rectangle-in-histogram/)
        Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
        return the area of the largest rectangle in the histogram.

        Example 1:
        Input: heights = [2,1,5,6,2,3]
        Output: 10
        Explanation: The above is a histogram where width of each bar is 1.
        The largest rectangle is shown in the red area, which has an area = 10 units.

        Example 2:
        Input: heights = [2,4]
        Output: 4

        Constraints:
            1 <= heights.length <= 105
            0 <= heights[i] <= 104

    */
    public int largestRectangleArea_eac(int[] heights) // Expand from center TLE
    {
        int lower_bound=0,upper_bound=0,current_height=0, max_area=0;
        for(int iterator_i=0;iterator_i<heights.length;iterator_i++)
        {
            lower_bound = iterator_i;
            upper_bound = iterator_i;
            current_height = heights[iterator_i];
            while(lower_bound>=0 && heights[lower_bound]>=current_height)
                lower_bound--;
            while(upper_bound<heights.length && heights[upper_bound]>=current_height)
                upper_bound++;
            max_area = Math.max((upper_bound-lower_bound-1)*current_height, max_area);
        }
        return max_area;
    }
    public int largestRectangleArea_dp(int[] heights) //DP Approach
    {
        int left_boundary[] = new int[heights.length], right_boundary[] = new int[heights.length],max_area=0;
        for(int iterator_i=0;iterator_i<heights.length;iterator_i++)
        {
            int prev_boundary = iterator_i-1;
            while(prev_boundary>-1 && heights[prev_boundary]>=heights[iterator_i])
                prev_boundary = left_boundary[prev_boundary];
            left_boundary[iterator_i] = prev_boundary;
        }

        for(int iterator_i=heights.length-1;iterator_i>=0;iterator_i--)
        {
            int prev_boundary = iterator_i+1;
            while(prev_boundary<heights.length && heights[prev_boundary]>=heights[iterator_i])
                prev_boundary = right_boundary[prev_boundary];
            right_boundary[iterator_i] = prev_boundary;
        }
        for(int iterator_i=0;iterator_i<heights.length;iterator_i++)
            max_area = Math.max(max_area,(right_boundary[iterator_i]-left_boundary[iterator_i]-1)*heights[iterator_i]);

        return max_area;
    }

    public int largestRectangleArea_stack(int[] heights) // Using Stacks
    {
        Stack<Integer> index_stck= new Stack();
        int curr_index=0,max_area=0;
        while(!index_stck.isEmpty() || curr_index!=heights.length)
        {
            int current_height = curr_index==heights.length?0:heights[curr_index];
            while(!index_stck.isEmpty() && current_height<=heights[index_stck.peek()])
            {
                int popped_index = index_stck.pop();
                max_area = Math.max(max_area,(curr_index-(index_stck.isEmpty()?0:index_stck.peek()+1))*heights[popped_index]);
            }
            if(curr_index<heights.length)
                index_stck.push(curr_index++);
        }
        return max_area;
    }

    public int largestRectangleArea(int[] heights) // Array based stacks
    {
        int curr_index=0, stck_arr[] = new int[heights.length],max_area=0,top=-1;
        while(top!=-1 || curr_index!=heights.length)
        {
            int current_height = curr_index==heights.length?0:heights[curr_index];
            while(top!=-1 && heights[stck_arr[top]]>=current_height)
            {
                int popped_index = stck_arr[top--];
                max_area = Math.max(max_area,(curr_index-(top==-1?0:stck_arr[top]+1))*heights[popped_index]);
            }
            if(curr_index<heights.length)
                stck_arr[++top] = curr_index++;
        }
        return max_area;
    }


    /*
    166. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-complete-tree-nodes/)
        Given the root of a complete binary tree, return the number of the nodes in the tree.
        According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
        and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the
        last level h.

        Example 1:
            Input: root = [1,2,3,4,5,6]
            Output: 6

        Example 2:
            Input: root = []
            Output: 0

        Example 3:
            Input: root = [1]
            Output: 1

        Constraints:
            1 <= heights.length <= 105
            0 <= heights[i] <= 104

    */
    public int countNodes(TreeNode root)
    {
        if(root==null)
            return 0;
        int height_root = countNodesHeight(root);
        int height_right = countNodesHeight(root.right);
        return (height_right == height_root-1)?(int)Math.pow(2,height_root-1) + countNodes(root.right):
                (int)Math.pow(2,height_right)+countNodes(root.left);
    }

    public int countNodesHeight(TreeNode root)
    {
        int height = 0;
        while(root!=null)
        {
            root = root.left;
            height++;
        }
        return height;
    }

    /*
    167. PROBLEM DESCRIPTION (https://leetcode.com/problems/sliding-window-maximum/)
        You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
        of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
        right by one position.

        Return the max sliding window.

        Example 1:
            Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
            Output: [3,3,5,5,6,7]

        Example 2:
            Input: nums = [1], k = 1
            Output: [1]

        Example 3:
            Input: nums = [1,-1], k = 1
            Output: [1,-1]

        Example 4:
            Input: nums = [9,11], k = 2
            Output: [11]

        Example 5:
            Input: nums = [4,-2], k = 2
            Output: [4]

        Constraints:
            1 <= nums.length <= 105
            -104 <= nums[i] <= 104
            1 <= k <= nums.length

    */
    public int[] maxSlidingWindow_linklst(int[] nums, int k)// Using LinkedList or Deque
    {
        LinkedList<Integer> index_queue = new LinkedList();
        int max_window[] = new int[nums.length-k+1], result_index=0;

        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(!index_queue.isEmpty() && iterator_i-k==index_queue.peek())
                index_queue.poll();
            // Remove less than current values
            while(!index_queue.isEmpty() &&  nums[iterator_i]>=nums[index_queue.peekLast()])
                index_queue.pollLast();

            index_queue.offer(iterator_i);
            if(iterator_i>=k-1)
                max_window[result_index++] = nums[index_queue.peek()];
        }

        return max_window;
    }

    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int sliding_deque[] = new int[nums.length],result_max[] = new int[nums.length-k+1], first_index=0,last_index=-1,result_index=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(last_index>=first_index &&  (iterator_i-k)==sliding_deque[first_index])
                first_index++;
            while(last_index>=first_index && nums[iterator_i]>=nums[sliding_deque[last_index]])
                last_index--;
            sliding_deque[++last_index] = iterator_i;
            if(iterator_i>=k-1)
                result_max[result_index++] = nums[sliding_deque[first_index]];
        }
        return result_max;
    }

    /*
    168. PROBLEM DESCRIPTION (https://leetcode.com/problems/summary-ranges/)
        You are given a sorted unique integer array nums.
        Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element
        of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges
        but not in nums.

        Each range [a,b] in the list should be output as:
            "a->b" if a != b
            "a" if a == b

        Example 1:
            Input: nums = [0,1,2,4,5,7]
            Output: ["0->2","4->5","7"]
            Explanation: The ranges are:


        Constraints:
            0 <= nums.length <= 20
            -231 <= nums[i] <= 231 - 1
            All the values of nums are unique.
            nums is sorted in ascending order.

    */
    public List<String> summaryRanges(int[] nums)
    {
        List<String> result_string = new ArrayList();
        int iterator_index=0;
        while(iterator_index<nums.length)
        {
            StringBuffer sb = new StringBuffer();
            int range_start = nums[iterator_index];
            sb.append(range_start);
            while(iterator_index<nums.length-1 && (nums[iterator_index+1] == nums[iterator_index]+1))
                iterator_index++;
            if(nums[iterator_index]!=range_start)
                sb.append("->").append(nums[iterator_index]);
            result_string.add(sb.toString());
            iterator_index++;
        }
        return result_string;
    }

    /*
    169. PROBLEM DESCRIPTION (https://leetcode.com/problems/first-missing-positive/)
        Given an unsorted integer array nums, find the smallest missing positive integer.

        Example 1:
            Input: nums = [1,2,0]
            Output: 3

        Example 2:
            Input: nums = [3,4,-1,1]
            Output: 2

        Example 3:
            Input: nums = [7,8,9,11,12]
            Output: 1

        Constraints:
            0 <= nums.length <= 300
            -231 <= nums[i] <= 231 - 1

        Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?
    */
    public int firstMissingPositive_alt(int[] nums)
    {
        int current_index;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            current_index = iterator_i;
            while(nums[current_index]>0 && nums[current_index]<nums.length && nums[current_index] != current_index+1 && nums[current_index]!=nums[nums[current_index]-1])
            {
                int temp = nums[current_index];
                nums[current_index] = nums[nums[current_index]-1];
                nums[temp-1] = temp;
            }
        }

        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            if(nums[iterator_i]!=iterator_i+1)
                return iterator_i+1;

        return nums.length;
    }

    public int firstMissingPositive(int[] nums)
    {
        int nums_cpy[] = Arrays.copyOf(nums,nums.length+1),n=nums_cpy.length;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            if(nums_cpy[iterator_i]<0 || nums_cpy[iterator_i]>nums.length)
                nums_cpy[iterator_i]=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            nums_cpy[(nums_cpy[iterator_i])%n]+=n;

        for(int iterator_i=1;iterator_i<=nums.length;iterator_i++)
            if(nums_cpy[iterator_i]<n)
                return iterator_i;

        return n;
    }

    /*
    170. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-maximum-path-sum/)
        A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting
        them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
        The path sum of a path is the sum of the node's values in the path. Given the root of a binary tree, return the
        maximum path sum of any path.

        Example 1:
            Input: root = [1,2,3]
            Output: 6
            Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

        Example 2:
            Input: root = [-10,9,20,null,null,15,7]
            Output: 42
            Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


        Constraints:
            The number of nodes in the tree is in the range [1, 3 * 104].
            -1000 <= Node.val <= 1000
    */
    int binary_maxpathsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root)
    {
        maxPathSumHelper(root);
        return binary_maxpathsum;
    }

    public int maxPathSumHelper(TreeNode root)
    {
        if(root==null)
            return 0;
        int left_sum = maxPathSumHelper(root.left);
        int right_sum = maxPathSumHelper(root.right);

        binary_maxpathsum = Math.max(root.val,Math.max(binary_maxpathsum,left_sum+right_sum+root.val));
        if(root.val>=0)
            binary_maxpathsum = Math.max(binary_maxpathsum, Math.max(left_sum,right_sum) + root.val);

        return Math.max(root.val,Math.max(left_sum,right_sum)+root.val);
    }

    /*
    171. PROBLEM DESCRIPTION (https://leetcode.com/problems/decode-string/)
        Given an encoded string, return its decoded string.
        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
        exactly k times. Note that k is guaranteed to be a positive integer.
        You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed,etc.
        Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
        repeat numbers, k. For example, there won't be input like 3a or 2[4].

        Example 1:
            Input: s = "3[a]2[bc]"
            Output: "aaabcbc"

        Example 2:
            Input: s = "3[a2[c]]"
            Output: "accaccacc"

        Example 3:
            Input: s = "2[abc]3[cd]ef"
            Output: "abcabccdcdcdef"

        Example 4:
            Input: s = "abc3[cd]xyz"
            Output: "abccdcdcdxyz"
    */
    public String decodeString(String s)
    {
        StringBuffer stack_arr[] = new StringBuffer[s.length()];
        int stack_top=-1,iterator_index=0;
        while(iterator_index<s.length())
        {
            StringBuffer sb = new StringBuffer();
            char current_char = s.charAt(iterator_index);
            if(Character.isDigit(current_char))
            {
                while(Character.isDigit(s.charAt(iterator_index)))
                    sb.append(s.charAt(iterator_index++));
                stack_arr[++stack_top] = sb;
            }
            else if(Character.isLetter(current_char))
            {
                while(iterator_index<s.length() && Character.isLetter(s.charAt(iterator_index)))
                    sb.append(s.charAt(iterator_index++));
                try
                {
                    int prev_value = Integer.parseInt(stack_arr[stack_top].toString());
                    stack_arr[++stack_top] = sb;
                }
                catch (Exception e)
                {
                    if(stack_top==-1)
                        stack_arr[++stack_top] = sb;
                    else
                        stack_arr[stack_top].append(sb);
                }

            }
            else if(current_char == '[')
            {
                //stack_arr[++stack_top] = new StringBuffer().append(current_char);
                iterator_index++;
            }
            else if(current_char == ']')
            {
                StringBuffer decoded_string = new StringBuffer();
                StringBuffer str_to_decode = stack_arr[stack_top--];
                System.out.println(stack_arr[stack_top]);
                int repetition = Integer.parseInt(stack_arr[stack_top--].toString());
                for(int iterator_i=0;iterator_i<repetition;iterator_i++)
                    decoded_string.append(str_to_decode);
                boolean new_value =false;
                try
                {
                    int prev_value = Integer.parseInt(stack_arr[stack_top].toString());
                    new_value = true;
                }
                catch (Exception e)
                {
                }

                if(stack_top!=-1 && !new_value)
                    stack_arr[stack_top].append(decoded_string);
                else
                    stack_arr[++stack_top] = decoded_string;
                iterator_index++;
            }
        }
        return stack_arr[0].toString();
    }

    /*
    172. PROBLEM DESCRIPTION (https://leetcode.com/problems/missing-number/)
        Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that
        is missing from the array.
        Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

        Example 1:
            Input: nums = [3,0,1]
            Output: 2
            Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number
            in the range since it does not appear in nums.

        Example 2:
            Input: nums = [0,1]
            Output: 2
            Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number
            in the range since it does not appear in nums.

        Example 3:
            Input: nums = [9,6,4,2,3,5,7,0,1]
            Output: 8
            Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number
            in the range since it does not appear in nums.

        Example 4:
            Input: nums = [0]
            Output: 1
            Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in
            the range since it does not appear in nums.
    */
    public int missingNumber(int[] nums)
    {
        int sum = 0,n=nums.length;
        for(int num:nums)
            sum += num;
        return n*(n+1)/2 -sum;
    }

    /*
    173. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
        Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
        Example 1:
            Input: root = [3,1,4,null,2], k = 1
            Output: 1

        Example 2:
            Input: root = [5,3,6,2,4,null,null,1], k = 3
            Output: 3

        Constraints:
            The number of nodes in the tree is n.
            1 <= k <= n <= 104
            0 <= Node.val <= 104

        Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the
        kth smallest frequently, how would you optimize?
    */
    int kthSmallest_val = 0;
    public int kthSmallest(TreeNode root, int k)
    {
        return kthSmallestHelper(root,k).val;
    }
    public TreeNode kthSmallestHelper(TreeNode root,int k)
    {
        if(root==null)
            return null;
        TreeNode left_val = kthSmallestHelper(root.left,k);
        if(left_val!=null)
            return left_val;
        kthSmallest_val++;
        if(kthSmallest_val == k)
            return root;
        return kthSmallestHelper(root.right,k);
    }
    // Interesting followup for optimizing add/delete/search(kth smalllest) using doubly linked queue(increasing)

    /*
    174. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-increasing-subsequence/)
        Given an integer array nums, return the length of the longest strictly increasing subsequence.
        A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
        the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

        Example 1:
            Input: nums = [10,9,2,5,3,7,101,18]
            Output: 4
            Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

        Example 2:
            Input: nums = [0,1,0,3,2,3]
            Output: 4

        Example 3:
            Input: nums = [7,7,7,7,7,7,7]
            Output: 1

        Constraints:
            1 <= nums.length <= 2500
            -104 <= nums[i] <= 104


        Follow up:
            Could you come up with the O(n2) solution?
            Could you improve it to O(n log(n)) time complexity?
    */
    public int lengthOfLIS_dp(int[] nums) // O(n^2) General DP solution
    {
        int dp_length[] = new int[nums.length],max_length=1;
        Arrays.fill(dp_length,1);

        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            int curr_ele = nums[iterator_i];
            for(int iterator_j =iterator_i-1;iterator_j>=0;iterator_j--)
            {
                if(curr_ele>nums[iterator_j])
                    dp_length[iterator_i] = Math.max(dp_length[iterator_i],dp_length[iterator_j]+1);
            }
            max_length = Math.max(dp_length[iterator_i],max_length);
        }
        return max_length;
    }

    public int lengthOfLIS(int nums[]) // Patience sort O(nlog(n))
    {
        int piles_arr[] = new int[nums.length],n=nums.length,curr_num;
        int piles_len = 0;
        for(int iterator_i=0;iterator_i<n;iterator_i++)
        {
            curr_num=nums[iterator_i];
            int search_index = Arrays.binarySearch(piles_arr,0,piles_len,curr_num);
            if(search_index<0)
                search_index = -(search_index+1);
            piles_arr[search_index] = curr_num;
            if(search_index==piles_len)
                piles_len++;
        }
        return piles_len;
    }

    /*
    175. PROBLEM DESCRIPTION (https://leetcode.com/problems/coin-change/)
        You are given an integer array coins representing coins of different denominations and an integer amount
        representing a total amount of money. Return the fewest number of coins that you need to make up that amount.
        If that amount of money cannot be made up by any combination of the coins, return -1.

        You may assume that you have an infinite number of each kind of coin.

        Example 1:
            Input: coins = [1,2,5], amount = 11
            Output: 3
            Explanation: 11 = 5 + 5 + 1

        Example 2:
            Input: coins = [2], amount = 3
            Output: -1

        Example 3:
            Input: coins = [1], amount = 0
            Output: 0

        Example 4:
            Input: coins = [1], amount = 1
            Output: 1

        Example 5:
            Input: coins = [1], amount = 2
            Output: 2

        Constraints:
            1 <= coins.length <= 12
            1 <= coins[i] <= 231 - 1
            0 <= amount <= 104
    */
    public int coinChange_dp(int[] coins, int amount)
    {
        int dp_arr[] = new int[amount+1],min_coin_value=Integer.MAX_VALUE;
        Arrays.fill(dp_arr,Integer.MAX_VALUE);
        dp_arr[0] = 0;
        for(int iterator_coins=0;iterator_coins< coins.length;iterator_coins++)
        {
            int current_coin = coins[iterator_coins];
            for(int iterator_amount=current_coin;iterator_amount<=amount;iterator_amount++)
                dp_arr[iterator_amount] = Math.min(dp_arr[iterator_amount],dp_arr[iterator_amount-current_coin]+1);
        }

        return dp_arr[amount]==Integer.MAX_VALUE?-1:dp_arr[amount];
    }

    public int coinChange(int[] coins, int amount)
    {
        return coinChangeHelper(coins,amount,new int[amount+1]);
    }

    public int coinChangeHelper(int[] coins,int remaining_amount, int memoization_arr[])
    {
        if(remaining_amount<0)
            return -1;
        if(remaining_amount==0)
            return 0;
        if(memoization_arr[remaining_amount]!=0)
            return memoization_arr[remaining_amount];

        int min_length = Integer.MAX_VALUE;

        for(int coint_iterator=0;coint_iterator<coins.length;coint_iterator++)
        {
            int result_child = coinChangeHelper(coins,remaining_amount-coins[coint_iterator],memoization_arr);
            if(result_child+1<min_length && result_child>=0)
                min_length = result_child+1;
        }
        memoization_arr[remaining_amount] = min_length==Integer.MAX_VALUE?-1:min_length;
        return memoization_arr[remaining_amount];
    }

    /*
    176. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-distance-between-bst-nodes/)
        Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different
        nodes in the tree.
        Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/

        Example 1:
            Input: root = [4,2,6,1,3]
            Output: 1

        Example 2:
            Input: root = [1,0,48,null,null,12,49]
            Output: 1

        Constraints:
            The number of nodes in the tree is in the range [2, 100].
            0 <= Node.val <= 105
    */
    int min_diffBST = Integer.MAX_VALUE;
    TreeNode max_leftBST = null;
    public int minDiffInBST(TreeNode root)
    {
        minDiffInBSTHelper(root);
        return min_diffBST;
    }

    public void minDiffInBSTHelper(TreeNode root)
    {
        if(root==null)
            return;
        minDiffInBSTHelper(root.left);
        if(max_leftBST!=null)
            min_diffBST = Math.min(min_diffBST,root.val - max_leftBST.val);
        max_leftBST = root;
        minDiffInBSTHelper(root.right);
    }

    /*
    177. PROBLEM DESCRIPTION (https://leetcode.com/problems/spiral-matrix/)
        Given an m x n matrix, return all elements of the matrix in spiral order.

        Example 1:
            Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
            Output: [1,2,3,6,9,8,7,4,5]

        Example 2:
            Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
            Output: [1,2,3,4,8,12,11,10,9,5,6,7]

        Constraints:
            m == matrix.length
            n == matrix[i].length
            1 <= m, n <= 10
            -100 <= matrix[i][j] <= 100
    */
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result_list = new ArrayList();
        int current_row=0,current_col=0,n = matrix.length,m=matrix[0].length,spiral_index=0;

        while(current_col<m-spiral_index)
        {
            while(current_col<m-spiral_index)
                result_list.add(matrix[current_row][current_col++]);
            current_col--;
            current_row++;
            if(current_row>=n-spiral_index)
                break;
            while(current_row<n-spiral_index)
                result_list.add(matrix[current_row++][current_col]);
            current_row--;
            current_col--;
            if(current_col<spiral_index)
                break;
            while(current_col>=spiral_index)
                result_list.add(matrix[current_row][current_col--]);
            current_col++;
            current_row--;
            if(current_row<=spiral_index)
                break;
            while(current_row>spiral_index)
                result_list.add(matrix[current_row--][current_col]);
            current_row++;
            current_col++;
            spiral_index++;
        }
        return result_list;
    }

    /*
    178. PROBLEM DESCRIPTION (https://leetcode.com/problems/word-ladder/)
        A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
        beginWord -> s1 -> s2 -> ... -> sk such that:
            Every adjacent pair of words differs by a single letter.
            Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
            sk == endWord

        Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
        transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

        Example 1:
            Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
            Output: 5
            Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

        Example 2:
            Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
            Output: 0
            Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

        Constraints:
            1 <= beginWord.length <= 10
            endWord.length == beginWord.length
            1 <= wordList.length <= 5000
            wordList[i].length == beginWord.length
            beginWord, endWord, and wordList[i] consist of lowercase English letters.
            beginWord != endWord
            All the words in wordList are unique.
    */

    public class wordListClass implements Comparable<wordListClass>
    {
        String target_str;
        int difference;
        public wordListClass(String target_str, int difference)
        {
            this.target_str = target_str;
            this.difference = difference;
        }
        @Override
        public int compareTo(wordListClass obj)
        {
            return Integer.compare(difference,obj.difference);
        }
    }

    public int ladderLength_alt(String beginWord, String endWord, List<String> wordList)
    {
        HashMap<String,List<String>> hmap = new HashMap();
        wordList.add(beginWord);
        boolean transformation_flag = true;
        for(String src_str: wordList)
        {
            if(src_str.equals(endWord))
            {
                transformation_flag = false;
                continue;
            }
            for(String target_str: wordList)
            {
                int difference_between_words=0;
                for(int iterator_i=0;iterator_i<src_str.length();iterator_i++)
                    if(src_str.charAt(iterator_i)!=target_str.charAt(iterator_i))
                        difference_between_words++;
                if(difference_between_words==1)
                    hmap.computeIfAbsent(src_str,a->new ArrayList<>()).add(target_str);
            }
        }
        if(transformation_flag)
            return 0;
        PriorityQueue<wordListClass> bfs_queue = new PriorityQueue();
        bfs_queue.add(new wordListClass(beginWord,0));
        Set<String> visited_set = new HashSet();
        while(!bfs_queue.isEmpty() && !bfs_queue.peek().target_str.equals(endWord))
        {
            wordListClass polled_ele = bfs_queue.poll();
            int difference_till_now = polled_ele.difference;
            visited_set.add(polled_ele.target_str);
            if(!hmap.containsKey(polled_ele.target_str))
                continue;
            for(String connected_str:hmap.get(polled_ele.target_str))
                if(!visited_set.contains(connected_str))
                    bfs_queue.add(new wordListClass(connected_str,1+difference_till_now));
        }
        return bfs_queue.isEmpty()?0:bfs_queue.peek().difference+1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Set non_visited_set = new HashSet(wordList);
        Deque<String> q = new ArrayDeque<>();
        if(!non_visited_set.contains(endWord))
            return 0;
        int current_transformation_length = 1;
        q.add(beginWord);
        non_visited_set.remove(beginWord);
        while(!q.isEmpty())
        {
            int current_level_size = q.size();
            for(int iterator_i=0;iterator_i<current_level_size;iterator_i++)
            {
                String popped_str = q.pollFirst();
                if(popped_str.equals(endWord))
                    return current_transformation_length;
                char popped_char_array[] = popped_str.toCharArray();
                for(int iterator_index=0;iterator_index<popped_str.length();iterator_index++)
                {
                    char current_char = popped_char_array[iterator_index];
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        if(c==current_char)
                            continue;
                        popped_char_array[iterator_index] = c;
                        String formed_string = String.valueOf(popped_char_array);
                        if(!non_visited_set.contains(formed_string))
                            continue;
                        q.offer(formed_string);
                        non_visited_set.remove(formed_string);
                    }
                    popped_char_array[iterator_index] = current_char;
                }
            }
            current_transformation_length++;
        }
        return 0;
    }


    /*
    179. PROBLEM DESCRIPTION (https://leetcode.com/problems/contains-duplicate-ii/)
        Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
        such that nums[i] == nums[j] and abs(i - j) <= k.

        Example 1:
            Input: nums = [1,2,3,1], k = 3
            Output: true

        Example 2:
            Input: nums = [1,0,1,1], k = 1
            Output: true

        Example 3:
            Input: nums = [1,2,3,1,2,3], k = 2
            Output: false

        Constraints:
            1 <= nums.length <= 105
            -109 <= nums[i] <= 109
            0 <= k <= 105
    */
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Set<Integer> hset_window = new HashSet();
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(iterator_i-k>=1)
                hset_window.remove(nums[iterator_i-k-1]);
            if(!hset_window.add(nums[iterator_i]))
                return true;
        }
        return false;
    }

    /*
    180. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-consecutive-sequence/)
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

        Example 1:
            Input: nums = [100,4,200,1,3,2]
            Output: 4
            Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

        Example 2:
            Input: nums = [0,3,7,2,5,8,4,6,0,1]
            Output: 9

        Constraints:
            0 <= nums.length <= 104
            -109 <= nums[i] <= 109

        Follow up: Could you implement the O(n) solution?
    */
    public int longestConsecutive(int[] nums)
    {
        HashSet<Integer> hset = new HashSet();
        for(int num:nums)
            hset.add(num);
        int longest_consecutive_length = 0;
        for(int num:nums)
        {
            if(hset.contains(num-1))
                continue;
            int current_length =0;
            int current_num = num;
            while(hset.remove(current_num))
            {
                current_num++;
                current_length++;
            }
            longest_consecutive_length = Math.max(longest_consecutive_length,current_length);
        }
        return longest_consecutive_length;
    }

    /*
    181. PROBLEM DESCRIPTION (https://leetcode.com/problems/regular-expression-matching/)
        Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'
        where:
            '.' Matches any single character.​​​​
            '*' Matches zero or more of the preceding element.
        The matching should cover the entire input string (not partial).

        Example 1:
            Input: s = "aa", p = "a"
            Output: false
            Explanation: "a" does not match the entire string "aa".

        Example 2:
            Input: s = "aa", p = "a*"
            Output: true
            Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

        Example 3:
            Input: s = "ab", p = ".*"
            Output: true
            Explanation: ".*" means "zero or more (*) of any character (.)".

        Example 4:
            Input: s = "aab", p = "c*a*b"
            Output: true
            Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

        Example 5:
            Input: s = "mississippi", p = "mis*is*p*."
            Output: false

        Constraints:
            0 <= s.length <= 20
            0 <= p.length <= 30
            s contains only lowercase English letters.
            p contains only lowercase English letters, '.', and '*'.
            It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
    */
    int isMatch_dp[][];
    public boolean isMatch(String s, String p)
    {
        isMatch_dp = new int[s.length()+1][p.length()+1];
        isMatch_dp[s.length()][p.length()] = 1;

        return isMatchHelper(s.toCharArray(),p.toCharArray(),0,0);
    }

    public boolean isMatchHelper(char s[], char p[],int s_index, int p_index)
    {
        if(s_index==s.length && p_index==p.length)
            return true;
        if(s_index>s.length || p_index>=p.length)
            return false;
        if(isMatch_dp[s_index][p_index]!=0)
            return isMatch_dp[s_index][p_index]==1?true:false;
        boolean iscurrent = false,final_value=false;
        if(s_index<s.length &&(s[s_index]==p[p_index] || p[p_index] == '.'))
            iscurrent = true;

        if(p_index+1<p.length && p[p_index+1]=='*')
            final_value = isMatchHelper(s,p,s_index,p_index+2) ||(iscurrent && isMatchHelper(s,p,s_index+1,p_index));
        else
            final_value = iscurrent && isMatchHelper(s,p,s_index+1,p_index+1);

        isMatch_dp[s_index][p_index] = final_value==true?1:-1;
        return final_value;
    }

    /*
    182. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-email-addresses/)
        Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters,
        the email may contain one or more '.' or '+'.
        For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
        If you add periods '.' between some characters in the local name part of an email address, mail sent there will be
        forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

        For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
        If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain
        emails to be filtered. Note that this rule does not apply to domain names.

        For example, "m.y+name@email.com" will be forwarded to "my@email.com".
        It is possible to use both of these rules at the same time.
        Given an array of strings emails where we send one email to each email[i], return the number of different addresses
        that actually receive mails.

        Example 1:
            Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
            Output: 2
            Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.

        Example 2:
            Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
            Output: 3

        Constraints:
            1 <= emails.length <= 100
            1 <= emails[i].length <= 100
            email[i] consist of lowercase English letters, '+', '.' and '@'.
            Each emails[i] contains exactly one '@' character.
            All local and domain names are non-empty.
            Local names do not start with a '+' character.
    */
    public int numUniqueEmails(String[] emails)
    {
        HashSet<String> valid_emails = new HashSet();
        for(String email:emails)
        {
            int indexOfSplit = email.indexOf('@');
            String local = email.substring(0,indexOfSplit);
            String domain = email.substring(indexOfSplit);
            if(local.contains("+"))
                local = local.substring(0,local.indexOf('+'));
            local = local.replaceAll("\\.","");
            valid_emails.add(local+domain);
        }

        return valid_emails.size();
    }

    /*
    183. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-window-substring/)
        Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is
        no such window in s that covers all characters in t, return the empty string "".
        Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

        Example 1:
            Input: s = "ADOBECODEBANC", t = "ABC"
            Output: "BANC"

        Example 2:
            Input: s = "a", t = "a"
            Output: "a"

        Constraints:
            1 <= s.length, t.length <= 105
            s and t consist of English letters.

        Follow up: Could you find an algorithm that runs in O(n) time?
    */
    public String minWindow(String s, String t)
    {
        int patternchar_index[] = new int[s.length()],front=0,top=-1,iterator_begin=0,iterator_end=0,required_matches=0,current_matches=0;
        HashSet<Character> t_set= new HashSet();
        int t_current[] = new int[128];
        for(int iterator_i=0;iterator_i<t.length();iterator_i++) {
            t_set.add(t.charAt(iterator_i));
            t_current[t.charAt(iterator_i)]++;
        }
        int min_window = Integer.MAX_VALUE;
        int[] position = new int[2];

        while(iterator_begin<s.length() && t_current[s.charAt(iterator_begin)]==0)
            iterator_begin++;
        iterator_end = iterator_begin;
        if(iterator_begin==s.length())
            return "";
        required_matches = t.length();
        while(iterator_end<s.length() && iterator_begin<=iterator_end)
        {
            char current_char = s.charAt(iterator_end);
            if(t_set.contains(current_char))
            {
                patternchar_index[++top] = iterator_end;
            }
            if(t_current[current_char]>0)
                current_matches++;
            t_current[current_char]--;
            while(current_matches==required_matches && iterator_begin<=iterator_end)
            {
                if(min_window>iterator_end-iterator_begin)
                {
                    min_window = iterator_end-iterator_begin;
                    position[0] = patternchar_index[front];
                    position[1] = iterator_end;
                }
                t_current[s.charAt(patternchar_index[front])]++;
                if(t_current[s.charAt(patternchar_index[front])]==1)
                    current_matches--;
                ++front;
                iterator_begin = front<top+1?patternchar_index[front]:iterator_end+1;
            }
            iterator_end++;
        }
        return min_window==Integer.MAX_VALUE?"":s.substring(position[0],position[1]+1);
    }

    /*
    184. PROBLEM DESCRIPTION (https://leetcode.com/problems/power-of-three/)
        Given an integer n, return true if it is a power of three. Otherwise, return false.
        An integer n is a power of three, if there exists an integer x such that n == 3^x.

        Example 1:
            Input: n = 27
            Output: true

        Example 2:
            Input: n = 0
            Output: false
    */
    public boolean isPowerOfThree_alt(int n)
    {
        if((Math.log(n)/Math.log(3) + 0.00001)%1.0 < 0.00002)
            return true;
        return false;
    }
    public boolean isPowerOfThree(int n)
    {
        return n > 0 && 1162261467 % n == 0;
    }


    /*
    185. PROBLEM DESCRIPTION (https://leetcode.com/problems/top-k-frequent-elements/)
        Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in
        any order.

        Example 1:
            Input: nums = [1,1,1,2,2,3], k = 2
            Output: [1,2]

        Example 2:
            Input: nums = [1], k = 1
            Output: [1]

        Constraints:
            1 <= nums.legth <= 105
            k is in the range [1, the number of unique elements in the array].
            It is guaranteed that the answer is unique.

        Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    */
    HashMap<Integer,Integer> hmap_kfrequent = new HashMap();
    public int[] topKFrequent_alt(int[] nums, int k) // Heap Approach
    {
        PriorityQueue<Integer> pq = new PriorityQueue((a,b)->(Integer.compare(hmap_kfrequent.get(a),hmap_kfrequent.get(b))));

        for(int num:nums)
            hmap_kfrequent.put(num,hmap_kfrequent.getOrDefault(num,0)+1);

        for(Integer hmap_key:hmap_kfrequent.keySet())
        {
            int frequency_current = hmap_kfrequent.get(hmap_key);
            if(pq.size()<k)
                pq.add(hmap_key);
            else if(hmap_kfrequent.get(pq.peek())<frequency_current)
            {
                pq.poll();
                pq.add(hmap_key);
            }
        }

        int result[] = new int[k];
        for(int iterator_k=k-1;iterator_k>=0;iterator_k--)
            result[iterator_k] = pq.poll();

        return result;
    }

    HashMap<Integer,Integer> freq_map = new HashMap();
    public int[] topKFrequent(int[] nums, int k)
    {
        for(int num:nums)
            freq_map.put(num,freq_map.getOrDefault(num,0)+1);
        int distinct_num[] = new int[freq_map.size()],counter=0;
        for(Integer num:freq_map.keySet())
            distinct_num[counter++] = num;
        topKFrequentQuickSelectHelper(distinct_num,0,distinct_num.length-1);
        return Arrays.copyOfRange(distinct_num,distinct_num.length-k,distinct_num.length);
    }

    public void topKFrequentQuickSelectHelper(int nums[],int lb,int ub)
    {
        if(lb>=ub)
            return;
        int partition = topKFrequentQuickSelect(nums,lb,ub);
        topKFrequentQuickSelectHelper(nums,lb,partition-1);
        topKFrequentQuickSelectHelper(nums,partition+1,ub);
    }


    public int topKFrequentQuickSelect(int nums[],int lb,int ub)
    {
        int partition_pos = (lb+ub)/2, ub_cpy=ub;
        int temp = nums[partition_pos];
        nums[partition_pos] = nums[ub];
        nums[ub--] = temp;

        while(lb<=ub)
        {
            if(freq_map.get(nums[lb])<=freq_map.get(nums[ub_cpy]))
                lb++;
            else if(freq_map.get(nums[ub])>freq_map.get(nums[ub_cpy]))
                ub--;
            else
            {
                temp = nums[lb];
                nums[lb] = nums[ub];
                nums[ub] = temp;
            }
        }
        temp = nums[ub_cpy];
        nums[ub_cpy] = nums[lb];
        nums[lb] = temp;
        return lb;
    }

    /*
    186. PROBLEM DESCRIPTION (https://leetcode.com/problems/next-permutation/)
        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of
        numbers.
        If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in
        ascending order).
        The replacement must be in place and use only constant extra memory.

        Example 1:
            Input: nums = [1,2,3]
            Output: [1,3,2]

        Example 2:
            Input: nums = [3,2,1]
            Output: [1,2,3]

        Example 3:
            Input: nums = [1,1,5]
            Output: [1,5 ,1]

        Example 4:
            Input: nums = [1]
            Output: [1]

        Constraints:
            1 <= nums.length <= 100
            0 <= nums[i] <= 100
    */

    public void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        if(n<2)
            return;
        int iterator_swap = n-2,temp;
        while(iterator_swap>=0 && nums[iterator_swap]>=nums[iterator_swap+1])
            iterator_swap--;
        if(iterator_swap<0)
        {
            for(int iterator_index=0;iterator_index<n/2;iterator_index++)
                swap(nums,iterator_index,n-iterator_index-1);
            return;
        }

        int swap_lowest = iterator_swap+1;
        while(swap_lowest<n && nums[swap_lowest]>nums[iterator_swap])
            swap_lowest++;

        swap(nums,swap_lowest-1,iterator_swap);

        for(int iterator_index=0;iterator_index<(nums.length-iterator_swap)/2;iterator_index++)
            swap(nums,iterator_index+1+iterator_swap,nums.length-iterator_index-1);
    }

    /*
    187. PROBLEM DESCRIPTION (https://leetcode.com/problems/search-in-rotated-sorted-array/)
        There is an integer array nums sorted in ascending order (with distinct values).
        Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such
        that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

        Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1
        if it is not in nums.

        Example 1:
            Input: nums = [4,5,6,7,0,1,2], target = 0
            Output: 4

        Example 2:
            Input: nums = [4,5,6,7,0,1,2], target = 3
            Output: -1

        Example 3:
            Input: nums = [1], target = 0
            Output: -1

        Constraints:
            1 <= nums.length <= 5000
            -104 <= nums[i] <= 104
            All values of nums are unique.
            nums is guaranteed to be rotated at some pivot.
            -104 <= target <= 104

    Follow up: Can you achieve this in O(log n) time complexity?
    */

    public int search(int[] nums, int target)
    {
        int lb=0,ub=nums.length-1,n=nums.length;

        while(lb<ub)
        {
            int mid = (lb+ub)/2;
            if(nums[mid]>nums[ub])
                lb = mid+1;
            else
                ub = mid;
        }
        ub = lb+n-1;

        while(lb<=ub)
        {
            int mid = (lb+ub)/2;
            if(nums[mid%n]>target)
                ub = mid-1;
            else if(nums[mid%n]<target)
                lb = mid+1;
            else
                return mid%n;
        }

        return -1;
    }

    /*
    188. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-paths-ii/)
        A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
        corner of the grid (marked 'Finish' in the diagram below).
        Now consider if some obstacles are added to the grids. How many unique paths would there be?

        An obstacle and space is marked as 1 and 0 respectively in the grid.

        Example 1:
            Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
            Output: 2
            Explanation: There is one obstacle in the middle of the 3x3 grid above.
            There are two ways to reach the bottom-right corner:
                1. Right -> Right -> Down -> Down
                2. Down -> Down -> Right -> Right

        Example 2:
            Input: obstacleGrid = [[0,1],[0,0]]
            Output: 1

        Constraints:
            m == obstacleGrid.length
            n == obstacleGrid[i].length
            1 <= m, n <= 100
            obstacleGrid[i][j] is 0 or 1.
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int dp_uniquepaths[][] = new int[n][m];
        if(obstacleGrid[0][0]==0)
        {
            dp_uniquepaths[0][0] = 1;
            int iterator_traversal =1;
            while(iterator_traversal<n &&  dp_uniquepaths[iterator_traversal - 1][0] == 1 && obstacleGrid[iterator_traversal][0] == 0)
                    dp_uniquepaths[iterator_traversal++][0] = 1;
        }

        for(int iterator_row=0;iterator_row<n;iterator_row++)
            for(int iterator_col=1;iterator_col<m;iterator_col++)
                dp_uniquepaths[iterator_row][iterator_col] = obstacleGrid[iterator_row][iterator_col]==1?0:(dp_uniquepaths[iterator_row][iterator_col-1] + (iterator_row>0?dp_uniquepaths[iterator_row-1][iterator_col]:0));
        return dp_uniquepaths[n-1][m-1];
    }

    /*
    189. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
        Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
        (i.e., from left to right, then right to left for the next level and alternate between).

        Example 1:
            Input: root = [3,9,20,null,null,15,7]
            Output: [[3],[20,9],[15,7]]

        Example 2:
            Input: root = [1]
            Output: [[1]]

        Example 3:
            Input: root = []
            Output: []

        Constraints:
            The number of nodes in the tree is in the range [0, 2000].
            -100 <= Node.val <= 100
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> result_list = new ArrayList();
        zigzagLevelOrderHelper(root,result_list,0);
        return result_list;
    }

    public void zigzagLevelOrderHelper(TreeNode root,List<List<Integer>> result_list, int level)
    {
        if(root==null)
            return;
        if(result_list.size()<=level)
        {
            List<Integer> new_add = new ArrayList();
            new_add.add(root.val);
            result_list.add(new_add);
        }
        else
        {
            if(level%2==0)
                result_list.get(level).add(root.val);
            else
                result_list.get(level).add(0,root.val);
        }
        zigzagLevelOrderHelper(root.left,result_list,level+1);
        zigzagLevelOrderHelper(root.right,result_list,level+1);
    }

    /*
    190. PROBLEM DESCRIPTION (https://leetcode.com/problems/island-perimeter/)
        You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents
        water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by
        water, and there is exactly one island (i.e., one or more connected land cells).

        The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell
        is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter
        of the island.

        Example 1:
            Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
            Output: 16
            Explanation: The perimeter is the 16 yellow stripes in the image above.

        Example 2:
            Input: grid = [[1]]
            Output: 4

        Example 3:
            Input: grid = [[1,0]]
            Output: 4

        Constraints:
            row == grid.length
            col == grid[i].length
            1 <= row, col <= 100
            grid[i][j] is 0 or 1.
    */
    public int islandPerimeter_alt(int[][] grid) // Recursive Approach
    {
        for(int iterator_i=0;iterator_i<grid.length;iterator_i++)
            for(int iterator_j=0;iterator_j<grid[0].length;iterator_j++)
                if(grid[iterator_i][iterator_j]==1)
                    return islandPerimeterHelper(grid,iterator_i,iterator_j);

        return 0;
    }
    int grid_islanddirection[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int islandPerimeterHelper(int[][] grid,int current_row,int current_col)
    {
        int n = grid.length,m=grid[0].length;
        grid[current_row][current_col] = -1;
        int perimeter_for_box = 0;

        for(int[] direction:grid_islanddirection)
        {
            int new_row = current_row + direction[0];
            int new_col = current_col + direction[1];
            if(new_row<0 || new_row>=n || new_col<0 || new_col>=m || grid[new_row][new_col]==0)
                perimeter_for_box++;
            else if(grid[new_row][new_col]==1)
                perimeter_for_box += islandPerimeterHelper(grid,new_row,new_col);
        }
        return perimeter_for_box;
    }

    public int islandPerimeter(int[][] grid)
    {
        int squares=0, common_edges=0;

        for(int iterator_i=0;iterator_i<grid.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<grid[0].length;iterator_j++)
            {
                if(grid[iterator_i][iterator_j]==1)
                {
                    squares++;
                    if (iterator_i > 0 && grid[iterator_i - 1][iterator_j] == 1)
                        common_edges++;
                    if (iterator_j > 0 && grid[iterator_i][iterator_j - 1] == 1)
                        common_edges++;
                }
            }
        }
        return 4*squares - common_edges*2;
    }

    /*
    191. PROBLEM DESCRIPTION (https://leetcode.com/problems/word-break/)
        Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
        sequence of one or more dictionary words.
        Note that the same word in the dictionary may be reused multiple times in the segmentation.

        Example 1:
            Input: s = "leetcode", wordDict = ["leet","code"]
            Output: true
            Explanation: Return true because "leetcode" can be segmented as "leet code".

        Example 2:
            Input: s = "applepenapple", wordDict = ["apple","pen"]
            Output: true
            Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
            Note that you are allowed to reuse a dictionary word.

        Example 3:
            Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
            Output: false

        Constraints:
            1 <= s.length <= 300
            1 <= wordDict.length <= 1000
            1 <= wordDict[i].length <= 20
            s and wordDict[i] consist of only lowercase English letters.
            All the strings of wordDict are unique.
    */
    public boolean wordBreak(String s, List<String> wordDict)
    {
        boolean dp_breakpossible[] = new boolean[s.length()];
        int iterator_index=0;

        while(iterator_index<s.length())
        {
            for(String dict_str:wordDict)
            {
                if(dp_breakpossible[iterator_index])
                    continue;
                int iterator_dictindex = dict_str.length()-1,iterator_index_cpy=iterator_index;
                while(iterator_index_cpy>=0 && iterator_dictindex>=0 && dict_str.charAt(iterator_dictindex)==s.charAt(iterator_index_cpy))
                {
                    iterator_index_cpy--;
                    iterator_dictindex--;
                }
                if(iterator_dictindex<0 && (iterator_index-dict_str.length()==-1 || dp_breakpossible[iterator_index-dict_str.length()]))
                    dp_breakpossible[iterator_index]= true;
            }
            iterator_index++;
        }

        return dp_breakpossible[s.length()-1];
    }

    /*
    192. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
        Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
        the array nums = [0,1,2,4,5,6,7] might become:
            [4,5,6,7,0,1,2] if it was rotated 4 times.
            [0,1,2,4,5,6,7] if it was rotated 7 times.
        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
        [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

        Given the sorted rotated array nums of unique elements, return the minimum element of this array.

        Example 1:
            Input: nums = [3,4,5,1,2]
            Output: 1
            Explanation: The original array was [1,2,3,4,5] rotated 3 times.

        Example 2:
            Input: nums = [4,5,6,7,0,1,2]
            Output: 0
            Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

        Example 3:
            Input: nums = [11,13,15,17]
            Output: 11
            Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

        Constraints:
            n == nums.length
            1 <= n <= 5000
            -5000 <= nums[i] <= 5000
            All the integers of nums are unique.
            nums is sorted and rotated between 1 and n times.
    */
    public int findMin(int[] nums)
    {
        int lb=0,ub=nums.length-1;
        while(lb<ub)
        {
            int mid = (lb+ub)/2;
            if(nums[mid]>nums[ub])
                lb = mid+1;
            else
                ub = mid;
        }
        return nums[lb];
    }

    /*
    193. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-size-subarray-sum/)
        Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
        subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is
        no such subarray, return 0 instead.

        Example 1:
            Input: target = 7, nums = [2,3,1,2,4,3]
            Output: 2
            Explanation: The subarray [4,3] has the minimal length under the problem constraint.

        Example 2:
            Input: target = 4, nums = [1,4,4]
            Output: 1

        Example 3:
            Input: target = 11, nums = [1,1,1,1,1,1,1,1]
            Output: 0

        Constraints:
            1 <= target <= 109
            1 <= nums.length <= 105
            1 <= nums[i] <= 105

    Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
    */
    public int minSubArrayLen(int target, int[] nums)
    {
        int lb=0,ub=-1,min_length=Integer.MAX_VALUE,current_sum=0;
        while(ub<nums.length-1)
        {
            current_sum += nums[++ub];
            while(lb<=ub && current_sum-nums[lb]>=target)
                current_sum -= nums[lb++];
            if(current_sum>=target)
                min_length = Math.min(min_length,ub-lb+1);
        }
        return min_length==Integer.MAX_VALUE?0:min_length;
    }

    /*
    194. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-k-pairs-with-smallest-sums/)
        You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
        Define a pair (u, v) which consists of one element from the first array and one element from the second array.
        Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

        Example 1:
            Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
            Output: [[1,2],[1,4],[1,6]]
            Explanation: The first 3 pairs are returned from the sequence:
            [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

        Example 2:
            Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
            Output: [[1,1],[1,1]]
            Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

        Example 3:
            Input: nums1 = [1,2], nums2 = [3], k = 3
            Output: [[1,3],[2,3]]
            Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

        Constraints:
            1 <= nums1.length, nums2.length <= 104
            -109 <= nums1[i], nums2[i] <= 109
            nums1 and nums2 both are sorted in ascending order.
            1 <= k <= 1000
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
        List<List<Integer>> result_list = new ArrayList();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(Integer.compare(a[0]+a[1],b[0]+b[1])));

        for(int iterator_i=0;iterator_i<nums1.length;iterator_i++)
            pq.add(new int[]{nums1[iterator_i],nums2[0],0});

        for(int iterator_i=0;iterator_i<k && !pq.isEmpty();iterator_i++)
        {
            int[] polled_ele = pq.poll();
            List<Integer> new_ele = new ArrayList<>();
            new_ele.add(polled_ele[0]);
            new_ele.add(polled_ele[1]);
            result_list.add(new_ele);
            if(polled_ele[2]+1<nums2.length)
                pq.add(new int[]{polled_ele[0],nums2[polled_ele[2]+1],polled_ele[2]+1});
        }

        return result_list;
    }

    /*
    195. PROBLEM DESCRIPTION (https://leetcode.com/problems/max-area-of-island/)
        Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
        4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
        Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

        Example 1:
            [[0,0,1,0,0,0,0,1,0,0,0,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,1,1,0,1,0,0,0,0,0,0,0,0],
            [0,1,0,0,1,1,0,0,1,0,1,0,0],
            [0,1,0,0,1,1,0,0,1,1,1,0,0],
            [0,0,0,0,0,0,0,0,0,0,1,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,0,0,0,0,0,0,1,1,0,0,0,0]]
        Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

        Example 2:
            [[0,0,0,0,0,0,0,0]]
            Given the above grid, return 0.

        Note: The length of each dimension in the given grid does not exceed 50.
    */
    public int maxAreaOfIsland(int[][] grid)
    {
        int max_area = Integer.MIN_VALUE;
        for(int iterator_i=0;iterator_i<grid.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<grid[0].length;iterator_j++)
            {
                if(grid[iterator_i][iterator_j]==1)
                    max_area = Math.max(max_area,maxAreaOfIslandHelper(grid,iterator_i,iterator_j));
            }
        }
        return max_area==Integer.MIN_VALUE?0:max_area;
    }

    public int maxAreaOfIslandHelper(int grid[][],int curr_row,int curr_col)
    {
        int current_area =1;
        grid[curr_row][curr_col] = 0;

        for(int direction[]:grid_islanddirection)
        {
            int new_row = direction[0]+curr_row;
            int new_col = direction[1]+curr_col;
            if(new_row>=0 && new_row<grid.length && new_col>=0 && new_col<grid[0].length && grid[new_row][new_col]==1)
                current_area += maxAreaOfIslandHelper(grid,new_row,new_col);
        }
        return current_area;
    }


    /*
    196. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-largest-element-in-a-stream/)
        Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted
        order, not the kth distinct element.

        Implement KthLargest class:
            KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
            int add(int val) Returns the element representing the kth largest element in the stream.

        Example 1:
        Input: ["KthLargest", "add", "add", "add", "add", "add"]
               [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        Output:
               [null, 4, 5, 5, 8, 8]

        Explanation
            KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
            kthLargest.add(3);   // return 4
            kthLargest.add(5);   // return 5
            kthLargest.add(10);  // return 5
            kthLargest.add(9);   // return 8
            kthLargest.add(4);   // return 8

        Constraints:
            1 <= k <= 104
            0 <= nums.length <= 104
            -104 <= nums[i] <= 104
            -104 <= val <= 104
            At most 104 calls will be made to add.
            It is guaranteed that there will be at least k elements in the array when you search for the kth element.
    */

    class KthLargest
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k;
        public KthLargest(int k, int[] nums)
        {
            this.k =k;
            int iterator_index=0;
            while(iterator_index<k && iterator_index<nums.length)
                pq.add(nums[iterator_index++]);
            while(iterator_index<nums.length)
            {
                if(nums[iterator_index]>pq.peek())
                {
                    pq.poll();
                    pq.add(nums[iterator_index]);
                }
                iterator_index++;
            }

        }

        public int add(int val)
        {
            if(pq.size()<k)
                pq.add(val);
            else if(val>pq.peek())
            {
                pq.poll();
                pq.add(val);
            }
            return pq.peek();
        }
    }

    /*
    197. PROBLEM DESCRIPTION (https://leetcode.com/problems/k-th-symbol-in-grammar/)
        On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each
        occurrence of 0 with 01, and each occurrence of 1 with 10.
        Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

        Examples:
            Input: N = 1, K = 1
            Output: 0

            Input: N = 2, K = 1
            Output: 0

            Input: N = 2, K = 2
            Output: 1

            Input: N = 4, K = 5
            Output: 1

            Explanation:
            row 1: 0
            row 2: 01
            row 3: 0110
            row 4: 01101001

        Note:
            N will be an integer in the range [1, 30].
            K will be an integer in the range [1, 2^(N-1)].
    */
    public int kthGrammar_alt(int N, int K) // TLE and MLE
    {
        boolean prev_grammar[] = new boolean[(1<<(N-1))];
        boolean curr_grammer[] = new boolean[(1<<(N-1))];
        int prev_top=1;
        int iterator_top_prev=0, iterator_top_curr=0;
        for(int iterator_i=1;iterator_i<N;iterator_i++)
        {
            iterator_top_prev=0;iterator_top_curr=0;
            while(iterator_top_prev<prev_top)
            {
                if(prev_grammar[iterator_top_prev])
                {
                    curr_grammer[iterator_top_curr++] = true;
                    curr_grammer[iterator_top_curr++] = false;
                }
                else
                {
                    curr_grammer[iterator_top_curr++] = false;
                    curr_grammer[iterator_top_curr++] = true;
                }
                iterator_top_prev++;
            }
            prev_top = iterator_top_curr;
            prev_grammar = curr_grammer;
        }
        return prev_grammar[K-1]?1:0;
    }

    public int kthGrammar(int N, int K)
    {
        //return Integer.bitCount(K-1)&1 ;
        if(N==1)
            return 0;
        if(K%2==0)
        {
            if (kthGrammar(N-1,K/2)==0)
                return 1;
            else
                return 0;
        }
        else
        {
            if(kthGrammar(N-1,(K+1)/2)==0)
                return 0;
            else
                return 1;
        }
    }

    /*
    198. PROBLEM DESCRIPTION (https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
        A conveyor belt has packages that must be shipped from one port to another within D days.
        The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the
        conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of
        the ship.
        Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being
        shipped within D days.

        Example 1:
            Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
            Output: 15
            Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
                1st day: 1, 2, 3, 4, 5
                2nd day: 6, 7
                3rd day: 8
                4th day: 9
                5th day: 10

        Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

        Example 2:
            Input: weights = [3,2,2,4,1,4], D = 3
            Output: 6
            Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
            1st day: 3, 2
            2nd day: 2, 4
            3rd day: 1, 4

        Example 3:
            Input: weights = [1,2,3,1,1], D = 4
            Output: 3
            Explanation:
            1st day: 1
            2nd day: 2
            3rd day: 3
            4th day: 1, 1

        Constraints:
            1 <= D <= weights.length <= 5 * 104
            1 <= weights[i] <= 500
    */
    public int shipWithinDays(int[] weights, int D)
    {
        int lb=0,ub=0;
        for(int weight:weights)
        {
            lb = Math.max(lb,weight);
            ub += weight;
        }
        while(lb<ub)
        {
            int mid = (lb+ub)/2,days_required=1,current_weight=0;
            for(int weight:weights)
            {
                if(current_weight+weight<=mid)
                    current_weight +=weight;
                else
                {
                    current_weight=weight;
                    days_required++;
                }
            }
            if(days_required>D)
                lb = mid+1;
            else
                ub = mid;
        }
        return lb;
    }

    /*
    199. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)
        Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
        Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

        Example 1:
            Input: root = [1,7,0,7,-8,null,null]
            Output: 2
            Explanation:
                Level 1 sum = 1.
                Level 2 sum = 7 + 0 = 7.
                Level 3 sum = 7 + -8 = -1.
                So we return the level with the maximum sum which is level 2.

            Example 2:
                Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
                Output: 2

            Constraints:
                The number of nodes in the tree is in the range [1, 104].
                -105 <= Node.val <= 105
    */
    public int maxLevelSum(TreeNode root)
    {
        List<Integer> level_sum = new ArrayList<>();
        maxLevelSumHelper(root,level_sum,0);

        return level_sum.indexOf(Collections.max(level_sum))+1;
    }

    public void maxLevelSumHelper(TreeNode root,List<Integer> level_sum,int current_level)
    {
        if(root==null)
            return;
        if(level_sum.size()<=current_level)
            level_sum.add(root.val);
        else {
            int prev = level_sum.remove(current_level);
            level_sum.add(current_level , prev + root.val);
        }
        maxLevelSumHelper(root.left,level_sum,current_level+1);
        maxLevelSumHelper(root.right,level_sum,current_level+1);
    }

    /*
        200. PROBLEM DESCRIPTION (https://leetcode.com/problems/shortest-unsorted-continuous-subarray/)
        Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in
        ascending order, then the whole array will be sorted in ascending order.
        Return the shortest such subarray and output its length.

        Example 1:
            Input: nums = [2,6,4,8,10,9,15]
            Output: 5
            Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

        Example 2:
            Input: nums = [1,2,3,4]
            Output: 0

        Example 3:
            Input: nums = [1]
            Output: 0

        Constraints:
            1 <= nums.length <= 104
            -105 <= nums[i] <= 105

        Follow up: Can you solve it in O(n) time complexity?
    */
    public int findUnsortedSubarray(int[] nums)
    {
        int lb=0,ub=nums.length-1,lb_value_unsorted,ub_value_unsorted;

        while(lb<nums.length-1 && nums[lb+1]>=nums[lb])
            lb++;

        if(lb==nums.length-1) // Already Sorted
            return 0;

        lb_value_unsorted = nums[lb+1];
        for(int iterator_i=lb+2;iterator_i<nums.length;iterator_i++)
            if(lb_value_unsorted>nums[iterator_i])
                lb_value_unsorted = nums[iterator_i];

        while(lb>=0 && lb_value_unsorted<nums[lb])
            lb--;
        lb++;

        while(ub>0 && nums[ub-1]<=nums[ub])
            ub--;
        ub_value_unsorted = nums[ub-1];

        for(int iterator_i=ub-2;iterator_i>=0;iterator_i--)
            if(ub_value_unsorted<nums[iterator_i])
                ub_value_unsorted = nums[iterator_i];

        while(ub<nums.length && ub_value_unsorted>nums[ub])
            ub++;
        ub--;

        return ub-lb+1;
    }


    
}

