## START OF CLASS OBJECTS
import collections
import re

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

## END OF CLASS OBJECTS

'''
    1. PROBLEM DESCRIPTION (https://leetcode.com/problems/two-sum/)
'''
def twoSum(self, nums: List[int], target: int) -> List[int]:
    mymap = dict()
    for idx, num in enumerate(nums):
        if (target-num) in mymap:
            return list([mymap.get(target-num), idx])
        mymap[num] = idx
    return list([-1,-1])

'''
    2. PROBLEM DESCRIPTION (https://leetcode.com/problems/add-two-numbers/)
'''
def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    dummyhead = ListNode(0)
    temphead =  dummyhead
    carry = 0
    while l1 or l2 or carry:
        l1_val = l1.val if l1 else 0
        l2_val = l2.val if l2 else 0
        total = l1_val+l2_val+carry
        dummyhead.next = ListNode(total%10)
        dummyhead = dummyhead.next
        if l1:
            l1 = l1.next
        if l2:
            l2 = l2.next
        carry  = total // 10
        return temphead.next

'''
    3. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-substring-without-repeating-characters/)
'''
def lengthOfLongestSubstring(self, s: str) -> int:
    hmap = dict()
    max_len, cur_end = 0, -1
    for idx, cur_c in enumerate(s):
        cur_end = max(cur_end, hmap.get(cur_c, -1))
        max_len = max(max_len, idx - cur_end)
        hmap[cur_c] = idx
    return max_len

'''
    4. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-integer/)
'''
def reverse(self, x: int) -> int:
    rev = 0
    
    if(x < 0):
        sign = -1
    else:
        sign = 1
    x = abs(x)
    while(x > 0):
        last = x % 10
        rev = rev * 10 + last
        x = x // 10
    
    final_result = rev * sign
    if -2**31 <= final_result <= 2**31 - 1:
        return final_result
    else:
        return 0

'''
 5. PROBLEM DESCRIPTION (https://leetcode.com/problems/string-to-integer-atoi/)
'''
def myAtoi(self, s: str) -> int:
    n, idx, result, sgn = len(s), 0, 0, 1
    while(idx<n and s[idx]==' '):
        idx+=1
    if(idx<n and s[idx] in "+-"):
        sgn = (-1 if s[idx]=='-' else 1)
        idx+=1
    while(idx<n):
        cur_c = s[idx]
        idx += 1
        if not(cur_c.isdigit()):
            return result * sgn
        result = result*10 + int(cur_c)
        if result*sgn >= 2**31:
            return 2**31 - 1
        if result*sgn < -2**31:
            return -2**31
    return result*sgn

'''
    6. PROBLEM DESCRIPTION (https://leetcode.com/problems/palindrome-number/)
'''
def isPalindrome(self, x: int) -> bool:
    str_x = str(x)
    if str_x[::-1] == str_x:
        return True
    return False

'''
    7. PROBLEM DESCRIPTION (https://leetcode.com/problems/integer-to-roman/)
'''
def intToRoman(self, num: int) -> str:
    keymap = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
    valmap = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"]
    idx = len(keymap)-1
    s = ""
    while num>0:
        if num>=keymap[idx]:
            s += valmap[idx]
            num -= keymap[idx]
        else:
            idx -= 1
    return s

'''
    8. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-common-prefix/)
'''
def longestCommonPrefix(self, strs: List[str]) -> str:
    idx = 0
    while idx<len(strs[0]):
        cur_c = strs[0][idx]
        for str_itr in range(0, len(strs)):
            if( idx >= len(strs[str_itr]) or strs[str_itr][idx] != cur_c ):
                return strs[0][:idx]
        idx+=1
    return strs[0]

'''
    9. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-parentheses/)
'''
def isValid(self, s: str) -> bool:
    stck = []
    for c in s:
        if c=='[':
            stck.append(']')
        elif c == '{':
            stck.append('}')
        elif c == '(':
            stck.append(')')
        else:
            if not stck:
                return False
            p = stck.pop()
            if p!=c:
                return False
    return len(stck)==0

'''
    10. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-two-sorted-lists/)
'''
def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    dummylist = ListNode(0)
    dummylist.next = list1
    head = dummylist
    while dummylist.next and list2:
        if dummylist and dummylist.next.val > list2.val:
            temp = dummylist.next
            nextlist2 = list2.next
            dummylist.next = list2
            list2.next = temp
            list2 = nextlist2
        dummylist = dummylist.next
    if list2:
        dummylist.next = list2
    return head.next

'''
    11. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
'''
def removeDuplicates(self, nums: List[int]) -> int:
    cur_ptr = 1
    for idx in range(1, len(nums)):
        if nums[idx] != nums[idx-1]:
            nums[cur_ptr] = nums[idx]
            cur_ptr+=1
    return cur_ptr

'''
    12. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-element/)
'''
def removeElement(self, nums: List[int], val: int) -> int:
    cur_ptr = 0
    for idx in range(0, len(nums)):
        if nums[idx] != val:
            nums[cur_ptr] = nums[idx]
            cur_ptr += 1
    return cur_ptr

'''
    13. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-and-say/)
'''
def countAndSay(self, n: int) -> str:
    if n == 1:
        return "1"
    prev_string = self.countAndSay(n-1)
    result = ""
    cur_idx = 0
    while(cur_idx<len(prev_string)):
        cur_c = prev_string[cur_idx]
        count_c = 0
        while cur_idx<len(prev_string) and cur_c == prev_string[cur_idx]:
            cur_idx +=1
            count_c += 1
        result += str(count_c) + cur_c
    return result

'''
    14. PROBLEM DESCRIPTION (https://leetcode.com/problems/search-insert-position/)
'''
def searchInsert(self, nums: List[int], target: int) -> int:
    lb, ub = 0, len(nums)
    while lb<ub:
        mid = lb + (ub-lb)//2
        if nums[mid] > target:
            ub = mid
        elif nums[mid] < target:
            lb = mid+1
        else:
            return mid
    return lb

'''
    15. PROBLEM DESCRIPTION (https://leetcode.com/problems/plus-one/)
'''
def plusOne(self, digits: List[int]) -> List[int]:
    for i in range(len(digits)-1,-1, -1):
        if digits[i] !=9:
            digits[i]+=1
            return digits
        digits[i] = 0
    return [1]+digits

'''
    16. PROBLEM DESCRIPTION (https://leetcode.com/problems/sqrtx/)
'''
def mySqrt(self, x: int) -> int:
    lb, ub = 0, max(1,x//2)
    while lb < ub:
        mid = lb + (ub-lb)//2
        if mid*mid<=x and (mid+1)*(mid+1)>x:
            return mid
        elif mid*mid>x:
            ub = mid-1
        else:
            lb = mid+1
    return lb

'''
    17. PROBLEM DESCRIPTION (https://leetcode.com/problems/length-of-last-word/)
'''
def lengthOfLastWord(self, s: str) -> int:
    end_idx, result = len(s)-1, 0
    while end_idx>=0 and s[end_idx] == ' ':
        end_idx-=1
    while end_idx>=0 and s[end_idx] != ' ':
        result += 1
        end_idx -= 1
    return result

'''
    18. PROBLEM DESCRIPTION (https://leetcode.com/problems/add-binary/)
'''
def addBinary(self, a: str, b: str) -> str:
    #bin(int(a,2)+int(b,2))[2:]
    result, max_len, index, carry = "", max(len(a), len(b)), 0, 0
    for index in range(max_len):
        cur_a = int(a[len(a)-index-1]) if index < len(a) else 0
        cur_b = int(b[len(b)-index-1]) if index < len(b) else 0
        cur_sum = cur_a + cur_b + carry
        if cur_sum % 2 == 0:
            result = '0'+ result
        else:
            result = '1' + result
        carry = cur_sum>1
    return result if carry==0 else "1"+result

'''
    19. PROBLEM DESCRIPTION (https://leetcode.com/problems/climbing-stairs/)
'''
def climbStairs(self, n: int) -> int:
    prev_1, prev_2 = 1, 1
    for _ in range(2,n+1):
        prev_2, prev_1 = prev_1, prev_1+prev_2
    return prev_1

'''
    20. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-sorted-array/)
'''
def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
    """
    Do not return anything, modify nums1 in-place instead.
    """
    index, index1, index2 = m+n-1, m-1, n-1
    while index2 >= 0:
        if index1<0 or nums2[index2] >= nums1[index1]:
            nums1[index] = nums2[index2]
            index2 -= 1
        else:
            nums1[index] = nums1[index1]
            index1 -= 1
        index -= 1

'''
    21. PROBLEM DESCRIPTION (https://leetcode.com/problems/single-number/)
'''
def singleNumber(self, nums: List[int]) -> int:
    xor_val = 0
    for x in nums:
        xor_val ^= x
    return xor_val

'''
    22. PROBLEM DESCRIPTION (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
'''
def maxProfit(self, prices: List[int]) -> int:
    cur_min,cur_max = prices[0], 0
    for price in prices[1:]:
        cur_max = max(cur_max, price - cur_min)
        cur_min = min(cur_min, price)
    return cur_max

'''
    23. PROBLEM DESCRIPTION (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
'''
def maxProfit(self, prices: List[int]) -> int:
    profit = 0
    for idx in range(1, len(prices)):
        profit += max(0, prices[idx]- prices[idx-1])
    return profit

'''
    24. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-palindrome/)
'''
def isPalindrome(self, s: str) -> bool:
    clean_s = re.sub(r"[^a-zA-Z0-9]", "", s).lower()
    return clean_s == clean_s[::-1]

'''
    25. PROBLEM DESCRIPTION (https://leetcode.com/problems/implement-strstr/)
'''
def strStr(self, haystack: str, needle: str) -> int:
    len_needle = len(needle)
    for idx in range(0, len(haystack) - len_needle+1):
        if needle == haystack[idx:idx+len(needle)]:
            return idx
    return -1

'''
    26. PROBLEM DESCRIPTION (https://leetcode.com/problems/permutations/)
'''
def permute(self, nums: List[int]) -> List[List[int]]:
    result = []

    def swap(nums: List[int], i : int, j: int) -> None:
        nums[i], nums[j] = nums[j], nums[i]

    def permute_helper(pos_idx: int, nums: List[int], result: List[List[int]]) ->   None:
        if pos_idx == len(nums)-1:
            result.append(list(nums))
            return
        for idx in range(pos_idx, len(nums)):
            swap(nums, pos_idx, idx)
            permute_helper(pos_idx+1, nums, result)
            swap(nums, pos_idx, idx)

    permute_helper(0, nums, result)
    return result

'''
    27. PROBLEM DESCRIPTION (https://leetcode.com/problems/permutations-ii/)
'''
def permuteUnique(self, nums: List[int]) -> List[List[int]]:
    def helper(cur_pos: int, nums: List[int], result: List[List[int]], cur_list: List[int], visited: List[bool]):
        if cur_pos == len(nums):
            result.append(cur_list[:])
            return
        for idx in range(0, len(nums)):
            if not visited[idx] and ((idx==0) or (nums[idx]!=nums[idx-1]) or (nums[idx]==nums[idx-1] and not visited[idx-1])):
                visited[idx] = True
                cur_list.append(nums[idx])
                helper(cur_pos+1, nums, result, cur_list, visited)
                cur_list.pop()
                visited[idx] = False
    
    nums.sort()
    cur_list, result, visited = [], [], [False]*len(nums)
    helper(0, nums, result, cur_list, visited)
    return result

'''
    28. PROBLEM DESCRIPTION (https://leetcode.com/problems/multiply-strings/)
'''
def multiply(self, num1: str, num2: str) -> str:
    idx1, result = len(num1)-1, [0]*(len(num1)+len(num2))
    while idx1>=0:
        idx2 = len(num2)-1
        while idx2>=0:
            cur_product = int(num1[idx1]) * int(num2[idx2])
            result[idx1+idx2+1] += cur_product%10
            result[idx1+idx2] += cur_product//10
            idx2 -= 1
        idx1 -= 1
    carry = 0
    for i in range(len(result)-1,-1,-1):
        result[i] += carry
        carry = result[i]//10
        result[i] %= 10
    idx = 0
    while idx<len(result)-1 and result[idx] == 0:
        idx +=1
    result = result[idx:]
    return "".join([str(x) for x in result])

'''
    29. PROBLEM DESCRIPTION (http://leetcode.com/problems/generate-parentheses/)
'''
def generateParenthesis(self, n: int) -> List[str]:
    def helper(cur_pos: int, open_brac: int, result: List[str], cur_list: str, n: int):
        if cur_pos == n:
            result.append(cur_list)
            return
        if n-cur_pos > open_brac:
            cur_list +="("
            helper(cur_pos+1, open_brac+1, result, cur_list, n)
            cur_list = cur_list[:-1]
        if open_brac >0:
            cur_list += ")"
            helper(cur_pos+1, open_brac-1, result, cur_list, n)
            cur_list = cur_list[:-1]
    
    cur_list, result = "", []
    helper(0,0,result, cur_list,2*n)
    return result

'''
    30. PROBLEM DESCRIPTION (https://leetcode.com/problems/combination-sum/)
'''
def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    def helper(cur_idx: int, candidates: List[int], sum_left: int, result: List[List[int]], cur_list: List[int]):
        if sum_left == 0:
            result.append(cur_list[:])
            return
        if cur_idx == len(candidates):
            return
        if sum_left >= candidates[cur_idx]:
            cur_list.append(candidates[cur_idx])
            helper(cur_idx, candidates, sum_left-candidates[cur_idx], result, cur_list)
            cur_list.pop()
        helper(cur_idx+1, candidates, sum_left, result, cur_list)
    
    
    result, cur_list = [], []
    candidates.sort()
    helper(0, candidates, target, result, cur_list)
    return result

'''
    31. PROBLEM DESCRIPTION (https://leetcode.com/problems/combination-sum-ii/)
'''
def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
    def helper(cur_idx: int, sum_left: int, cur_list: List[int]):
        if sum_left == 0:
            result.append(cur_list[:])
            return
        for i in range(cur_idx, len(candidates)):
            if candidates[i]>sum_left:
                break
            if i>cur_idx and candidates[i]==candidates[i-1]:
                continue
            cur_list.append(candidates[i])
            helper(i+1, sum_left-candidates[i], cur_list)
            cur_list.pop()

    result = []
    candidates.sort()
    helper(0, target, [])
    return result

'''
    32. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-sudoku/)
'''

def main():
    print("Entering Main")
    return 0

if __name__=="__main__":
    main()