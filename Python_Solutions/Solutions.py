## START OF CLASS OBJECTS
from collections import deque
from collections import defaultdict
import re
import heapq
import math

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

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
def isValidSudoku(self, board: List[List[str]]) -> bool:
    rowflag, colflag, subboardflag = [set() for _ in range(0,9)], [set() for _ in range(0,9)], [set() for _ in range(0,9)]
    for row_idx in range(0,9):
        for col_idx in range(0,9):
            cur_val = board[row_idx][col_idx]
            if cur_val == '.':
                continue
            if cur_val in rowflag[row_idx] or cur_val in colflag[col_idx] or cur_val in subboardflag[(row_idx//3)*3 + col_idx//3]:
                return False
            colflag[col_idx].add(cur_val)
            rowflag[row_idx].add(cur_val)
            subboardflag[(row_idx//3)*3 + col_idx//3].add(cur_val)
    return True

'''
    33. PROBLEM DESCRIPTION (https://leetcode.com/problems/sudoku-solver/)
'''
def solveSudoku(self, board: List[List[str]]) -> None:
    """
    Do not return anything, modify board in-place instead.
    """
    def placeexisting():
        emptylist = []
        for row_idx in range(9):
            for col_idx in range(9):
                c = board[row_idx][col_idx]
                if c == '.':
                    emptylist.append((row_idx, col_idx))
                    continue
                rowflag[row_idx].add(c)
                colflag[col_idx].add(c)
                subblockflag[(row_idx//3)*3 + col_idx//3].add(c)
        return emptylist

    def fillboard(cur_idx: int):
        if cur_idx == len(emptylist):
            return True
        cur_row, cur_col = emptylist[cur_idx]
        subblock_idx = (cur_row//3)*3+cur_col//3
        c = board[cur_row][cur_col]
        for idx_c in "123456789":
            if idx_c in rowflag[cur_row] or idx_c in colflag[cur_col] or idx_c in subblockflag[subblock_idx]:
                continue
            rowflag[cur_row].add(idx_c)
            colflag[cur_col].add(idx_c)
            subblockflag[subblock_idx].add(idx_c)
            board[cur_row][cur_col] = idx_c
            if fillboard(cur_idx+1):
                return True
            rowflag[cur_row].remove(idx_c)
            colflag[cur_col].remove(idx_c)
            subblockflag[subblock_idx].remove(idx_c)
            board[cur_row][cur_col] = '.'
        return False
    rowflag, colflag, subblockflag = [set() for _ in range(9)], [set() for _ in range(9)], [set() for _ in range(9)]
    emptylist = placeexisting()
    fillboard(0)

'''
    34. PROBLEM DESCRIPTION (https://leetcode.com/problems/3sum/)
'''
def threeSum(self, nums: list[int]) -> list[list[int]]:
    nums.sort()
    result = []
    for i in range(len(nums)-2):
        if i>0 and nums[i] == nums[i-1]:
            continue
        k = len(nums)-1
        for j in range(i+1, len(nums)-1):
            if j>=k:
                break
            if (j>i+1 and nums[j] == nums[j-1]):
                continue
            sum_2 = nums[i]+ nums[j]
            while k>j+1 and sum_2 + nums[k] > 0:
                k-=1
            if sum_2 + nums[k] == 0:
                result.append([nums[i], nums[j], nums[k]])
    return result

'''
    34_2. PROBLEM DESCRIPTION (https://leetcode.com/problems/3sum-closest/)
'''
def threeSumClosest(self, nums: List[int], target: int) -> int:
    nums.sort()
    closest = nums[0]+nums[1]+nums[2]
    for i in range(len(nums)):
        lb, ub = i+1, len(nums)-1
        while(lb<ub):
            cur_sum = nums[i]+nums[lb]+nums[ub]
            if abs(cur_sum-target) < abs(closest-target):
                closest = cur_sum
            if cur_sum == target:
                return target
            if cur_sum < target:
                lb +=1
            else:
                ub -=1
    return closest

'''
    35. PROBLEM DESCRIPTION (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
'''
def letterCombinations(self, digits: str) -> List[str]:
    result = [""]
    phone_dict = ["abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    def helper(idx: int)-> None:
        if idx == len(digits):
            return
        nonlocal result
        c = digits[idx]
        newresult = []
        for cur_cand in result:
            for cur_c in phone_dict[int(c)-2]:
                newresult.append(cur_cand+cur_c)
        result = newresult
        helper(idx+1)
    helper(0)
    return result

'''
    36. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-valid-parentheses/)
'''
def longestValidParentheses(self, s: str) -> int:
    s_len, dp = len(s), [0]*(len(s)+1)
    cur_max, global_max = 0, 0
    for i in range(2, s_len+1):
        cur_max = 0
        if s[i-1]==')':
            if s[i-2] == '(':
                cur_max = 2+dp[i-2]
            if i-2-dp[i-1]!=-1 and s[i-2-dp[i-1]]=='(':
                cur_max = max(cur_max, 2+dp[i-1]+dp[i-2-dp[i-1]])
            
        dp[i] = cur_max
        global_max = max(global_max, cur_max)
    return global_max

def longestValidParentheses(self, s: str) -> int:
    stck, result = [-1], 0
    for i in range(len(s)):
        if s[i] == '(':
            stck.append(i)
        else:
            stck.pop()
            if not stck:
                stck.append(i)
            else:
                result = max(result, i-stck[-1])

    return result

'''
    37. PROBLEM DESCRIPTION (https://leetcode.com/problems/decode-ways/)
'''
def numDecodings(self, s: str) -> int:
    num_ways_prev, num_ways = 0, 1
    for i in range(len(s)):
        cur_ways = 0
        if s[i]!='0':
            cur_ways = num_ways
        if i>=1 and (s[i-1]=='1' or (s[i-1]=='2' and s[i]<'7')):
            cur_ways += num_ways_prev
        num_ways_prev, num_ways = num_ways, cur_ways
    return num_ways

'''
    38. PROBLEM DESCRIPTION (https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/)
'''
def findBestValue(self, arr: list[int], target: int) -> int:
    arr.sort()
    for idx in range(len(arr)):
        cur_total = (len(arr)-idx)*arr[idx]
        if cur_total > target:
            mid_val = math.ceil(target/(len(arr)-idx) - 0.5)
            return mid_val
        target -= arr[idx]
    return arr[-1]

def findBestValue(self, arr: list[int], target: int) -> int:
    def sumhelper(arr, potential_num):
        total = 0
        for x in arr:
            total += min(x, potential_num)
        return total
    lb, ub = 1, 0
    for x in arr:
        ub = max(x, ub)
    while lb<ub:
        mid = int((lb+ub)/2)
        if sumhelper(arr, mid) >= target:
            ub = mid
        else:
            lb = mid+1
    potential_lower = target - sumhelper(arr, lb-1)
    potential_higher = sumhelper(arr, lb) - target

    return lb-1 if potential_lower<=potential_higher else lb

'''
    39. PROBLEM DESCRIPTION (https://leetcode.com/problems/happy-number/)
'''
def isHappy(self, n: int) -> bool:
    fast, tracker, tracker_idx, skipbool =  n, [n], 0, False
    while n!=1:
        slow = tracker[tracker_idx]
        fast = 0
        while n>0:
            modval = n%10
            fast += modval**2
            n //= 10
        if fast == slow:
            return False
        tracker.append(fast)
        if skipbool:
            tracker_idx += 1
        skipbool = not skipbool
        n = fast
    return True

'''
    40. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-inorder-traversal/)
'''
def inorderTraversal(self, root: TreeNode | None) -> list[int]:
    stck, result, cur_node = [], [] , root
    while cur_node or len(stck)>0:
        while cur_node:
            stck.append(cur_node)
            cur_node = cur_node.left
        cur_node = stck.pop()
        result.append(cur_node.val)
        cur_node = cur_node.right
    return result

'''
    41. PROBLEM DESCRIPTION (https://leetcode.com/problems/delete-nodes-and-return-forest/)
'''
def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
    result = []
    to_delete = set(to_delete)
    def helper(root, to_delete, result):
        if not root:
            return
        root.left = helper(root.left, to_delete, result)
        root.right = helper(root.right, to_delete, result)
        to_delete_cur_node = root.val in to_delete
        if to_delete_cur_node:
            if root.right:
                result.append(root.right)
            if root.left:
                result.append(root.left)
            return None
        return root
    if helper(root, to_delete, result):
        result.append(root)
    return result

'''
    42. PROBLEM DESCRIPTION (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
'''
def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    if not root:
        return root
    if root == p or root == q:
        return root
    leftAncestor, rightAncestor = self.lowestCommonAncestor(root.left, p, q), self.lowestCommonAncestor(root.right, p, q)
    if leftAncestor and rightAncestor:
        return root
    return leftAncestor if leftAncestor else rightAncestor

'''
    43. PROBLEM DESCRIPTION (https://leetcode.com/problems/subarray-sum-equals-k/)
'''
def subarraySum(self, nums: List[int], k: int) -> int:
    hmap, cur_sum, result = {0:1}, 0, 0
    for x in nums:
        cur_sum += x
        result += hmap.get(cur_sum-k, 0)
        hmap[cur_sum] = hmap.get(cur_sum,0)+1
    return result

'''
    44. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-subarray/)
'''
def maxSubArray(self, nums: list[int]) -> int:
    cur_max, cur_sum = nums[0], 0
    for x in nums:
        cur_sum += x
        cur_max = max(cur_max, cur_sum)
        cur_sum = max(0, cur_sum)
    return cur_max

'''
    45. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-palindromic-substring)
'''
def longestPalindrome(self, s: str) -> str:
    def expandFromCenter(s, i, cur_max):
        left, right = i, i
        while left>-1 and right<len(s) and s[left]==s[right]:
            left -=1
            right+=1
        
        if right-left-1 > len(cur_max):
            cur_max = s[left+1:right]
        left, right = i, i+1
        while left>-1 and right<len(s) and s[left]==s[right]:
            left-=1
            right+=1
        
        if right-left-1 > len(cur_max):
            cur_max = s[left+1:right]
        return cur_max
    
    cur_max = ""
    for i in range(len(s)):
        cur_max = expandFromCenter(s, i, cur_max)
    return cur_max

'''
    46. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
'''
def removeNthFromEnd(self, head: ListNode | None, n: int) -> ListNode | None:
    dummy_head = ListNode(0, head)
    fast, slow = dummy_head, dummy_head
    for i in range(n):
        fast = fast.next
    while fast.next:
        fast = fast.next
        slow = slow.next
    slow.next = slow.next.next
    return dummy_head.next

'''
    47. PROBLEM DESCRIPTION (https://leetcode.com/problems/container-with-most-water/)
'''
def maxArea(self, height: list[int]) -> int:
    left, right, result = 0, len(height)-1, 0
    while left<right:
        cur_vol = (right-left)*min(height[left], height[right])
        result = max(result, cur_vol)
        if height[left] < height[right]:
            left+=1
        else:
            right-=1
    return result

'''
    48. PROBLEM DESCRIPTION (https://leetcode.com/problems/sort-colors/)
'''
def sortColors(self, nums: list[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    boundary1, boundary2 = 0, 0
    for x in nums:
        if x == 0:
            boundary1+=1
            boundary2+=1
        elif x == 1:
            boundary2+=1
    for i in range(boundary1):
        nums[i] = 0
    for i in range(boundary1, boundary2):
        nums[i] = 1
    for i in range(boundary2, len(nums)):
        nums[i] = 2

'''
    49. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
'''
def searchRange(self, nums: list[int], target: int) -> list[int]:
    left, right = 0, len(nums)-1
    while left < right:
        mid = (left+right)//2
        if nums[mid]>=target:
            right = mid
        else:
            left = mid + 1
    if left==len(nums) or nums[left]!=target:
        return [-1,-1]

    start_pos, right = left, len(nums)-1
    while left < right:
        mid = (left+right+1)//2
        if nums[mid] == target:
            left = mid
        else:
            right = mid-1
    return [start_pos, left]

'''
    50. PROBLEM DESCRIPTION (https://leetcode.com/problems/copy-list-with-random-pointer/)
'''
def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
    def duplicate_nodes(head):
        while head:
            new_node = Node(head.val, head.next, None)
            head.next = new_node
            head = new_node.next
    
    def assign_random_ptr(head):
        while head:
            added_node = head.next
            added_node.random = head.random.next if head.random else None
            head = added_node.next
    
    def reassign_next_ptr(head, dummy_head):
        while head:
            dummy_head.next = head.next
            head.next = head.next.next
            dummy_head = dummy_head.next
            head = head.next
            
    dummy_head=Node(0)
    duplicate_nodes(head)
    assign_random_ptr(head)
    reassign_next_ptr(head, dummy_head)
    return dummy_head.next

'''
    51. PROBLEM DESCRIPTION (https://leetcode.com/problems/daily-temperatures/)
'''
def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
    stck, result = [], [0]*len(temperatures)
    for i in range(len(temperatures)):
        cur_temp = temperatures[i]
        while stck and temperatures[stck[-1]]<cur_temp:
            popped_day = stck.pop()
            result[popped_day] = i - popped_day
        stck.append(i)
    return result

'''
    52. PROBLEM DESCRIPTION (https://leetcode.com/problems/invert-binary-tree/)
'''
def invertTree(self, root: TreeNode | None) -> TreeNode | None:
    if not root:
        return None
    lefttree = self.invertTree(root.right)
    root.right = self.invertTree(root.left)
    root.left = lefttree
    return root

'''
    53. PROBLEM DESCRIPTION (https://leetcode.com/problems/linked-list-cycle/)
'''
def hasCycle(self, head: Optional[ListNode]) -> bool:
    slow_ptr, fast_ptr = head, head
    while fast_ptr and fast_ptr.next:
        fast_ptr = fast_ptr.next.next
        slow_ptr = slow_ptr.next
        if slow_ptr == fast_ptr:
            return True
    return False

'''
    54. PROBLEM DESCRIPTION (https://leetcode.com/problems/linked-list-cycle-ii/)
'''
def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
    fast, slow = head, head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        if fast == slow:
            break
    if not fast or not fast.next:
        return None

    slow = head
    while slow!=fast:
        slow=slow.next
        fast=fast.next
    return slow

'''
    55. PROBLEM DESCRIPTION (https://leetcode.com/problems/palindrome-linked-list/)
'''
def isPalindrome(self, head: ListNode | None) -> bool:
    slow, fast = head, head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
    fast = slow
    prev = None
    while fast:
        temp = fast.next
        fast.next = prev
        prev = fast
        fast = temp
    slow = head
    while prev:
        if prev.val!=slow.val:
            return False
        prev = prev.next
        slow = slow.next
    return True


'''
    56. PROBLEM DESCRIPTION (https://leetcode.com/problems/majority-element/)
'''
def majorityElement(self, nums: list[int]) -> int:
    cur_num, cur_count = nums[0], 1
    for x in nums[1:]:
        if x == cur_num:
            cur_count+=1
        else:
            if cur_count == 0:
                cur_num = x
                cur_count = 1
            else:
                cur_count-=1
    return cur_num

'''
    57. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-largest-element-in-an-array/)
'''

def findKthLargest(self, nums: list[int], k: int) -> int:
    myheap = nums[:k]
    heapq.heapify(myheap)
    for x in nums[k:]:
        heapq.heappush(myheap,x)
        heapq.heappop(myheap)
    return myheap[0]

def findKthLargest(self, nums: list[int], k: int) -> int:
    max_val, min_val = nums[0], nums[0]
    for x in nums:
        max_val = max(max_val, x)
        min_val = min(min_val, x)
    
    count_list = [0]*(max_val-min_val+1)
    for x in nums:
        count_list[x-min_val]+=1
    for x in range(max_val-min_val, -1, -1):
        k -= count_list[x]
        if k<=0:
            return x+min_val
    return min_val

def findKthLargest(self, nums: list[int], k: int) -> int:
    def getpivot(nums, lb, ub):
        pivot, lower, same, index = nums[ub], 0, 0, lb
        while index < ub:
            if nums[index] > pivot:
                nums[index], nums[lb+lower] = nums[lb+lower], nums[index]
                if nums[index]==pivot:
                    index-=1
                    same-=1
                lower+=1
            elif nums[index] == pivot:
                nums[index], nums[lb+lower+same] = nums[lb+lower+same], nums[index]
                same+=1
            index+=1
        nums[ub], nums[lb+lower+same] = nums[lb+lower+same], nums[ub]
        return lower+lb-1, same+1; 


    def quickselect(nums, lb, ub, k):
        pivot_bdry, pivot_same = getpivot(nums, lb, ub)

        if k>pivot_bdry and k<=pivot_bdry+pivot_same:
            return nums[pivot_bdry+pivot_same]
        if k<=pivot_bdry:
            return quickselect(nums, lb, pivot_bdry, k)
        else:
            return quickselect(nums, pivot_bdry+pivot_same+1, ub, k)

    return quickselect(nums, 0, len(nums)-1, k-1)

'''
    58. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-two-binary-trees/)
'''
def mergeTrees(self, root1: TreeNode | None, root2: TreeNode | None) -> TreeNode | None:
    if not root1:
        return root2
    if root2:
        root1.val += root2.val
        root1.left = self.mergeTrees(root1.left, root2.left)
        root1.right = self.mergeTrees(root1.right, root2.right)
    return root1

'''
    59. PROBLEM DESCRIPTION (https://leetcode.com/problems/game-of-life/)
'''
def gameOfLife(self, board: list[list[int]]) -> None:
    """
    Do not return anything, modify board in-place instead.
    """
    m, n, directions = len(board), len(board[0]), [(0,1), (1,0), (1,1), (-1,1), (-1,-1), (1,-1), (-1,0),(0,-1)]
    
    def count_neighbors(row, col):
        count=0
        for d in directions:
            new_row, new_col = row+d[0], col+d[1]
            if new_row>-1 and new_row<m and new_col>-1 and new_col<n and board[new_row][new_col]>0:
                count+=1
        return count
    
    def perform_transitions():
        for i in range(m):
            for j in range(n):
                count = count_neighbors(i, j)
                if board[i][j]:
                    if count <2:
                        board[i][j] = 2
                    elif count >3:
                        board[i][j] = 3
                else:
                    if count==3:
                        board[i][j]=-1
    
    def update_next_state():
        for i in range(m):
            for j in range(n):
                cur_num = board[i][j]
                if cur_num >= 2:
                    board[i][j] = 0
                elif cur_num == -1:
                    board[i][j] = 1
    
    perform_transitions()
    update_next_state()

'''
    60. PROBLEM DESCRIPTION (https://leetcode.com/problems/diameter-of-binary-tree/)
'''
def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
    self.result_max = 0
    def helper(root):
        if not root:
            return 0
        count_left, count_right = helper(root.left), helper(root.right)
        self.result_max = max(count_left+count_right, self.result_max)
        # print(root.val, count_left, count_right, result_max)
        return 1+max(count_left, count_right)
    helper(root)
    return self.result_max

'''
    61. PROBLEM DESCRIPTION (https://leetcode.com/problems/intersection-of-two-linked-lists/)
'''
def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
    ptr1, ptr2 = headA, headB
    while ptr1 is not ptr2:
        ptr1 = ptr1.next if ptr1 else headB
        ptr2 = ptr2.next if ptr2 else headA
    return ptr1

'''
    62. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-linked-list/)
'''
def reverseList(self, head: ListNode | None) -> ListNode | None:
    prev=None
    while head:
        temp = head.next
        head.next = prev
        prev = head
        head = temp
    return prev

'''
    63. PROBLEM DESCRIPTION (https://leetcode.com/problems/house-robber/)
'''
def rob(self, nums: list[int]) -> int:
    prev, current = 0, nums[0]
    for x in nums[1:]:
        prev, current = current, max(current, prev+x)
    return current

'''
    64. PROBLEM DESCRIPTION (https://leetcode.com/problems/lru-cache/)
'''
class LRUCache:

    class Node:
        def __init__(self, key, value):
            self.key, self.value = key, value                                                                                    
            self.next, self.prev = None, None

    def __init__(self, capacity: int):
        self.cache, self.capacity = {}, capacity
        self.headnode, self.tailnode = self.Node(0,0), self.Node(0, 0)
        self.headnode.next, self.tailnode.prev = self.tailnode, self.headnode

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        mynode = self.cache[key]
        self.move_to_front(mynode)
        return mynode.value

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            mynode = self.cache[key]
            mynode.value = value
            self.move_to_front(mynode)
        else:
            if len(self.cache) == self.capacity:
                self.remove_node()
            mynode = self.Node(key, value)
            self.cache[key] = mynode
            self.add_to_front(mynode)
    
    def add_to_front(self, mynode):
        mynode.next, mynode.prev = self.headnode.next, self.headnode
        self.headnode.next.prev , self.headnode.next = mynode, mynode

    def remove_node(self):
        del self.cache[self.tailnode.prev.key]
        self.tailnode.prev = self.tailnode.prev.prev
        self.tailnode.prev.next = self.tailnode

    def move_to_front(self, node):
        node.prev.next, node.next.prev = node.next, node.prev
        node.next, node.prev = None, None
        self.add_to_front(node)

'''
    65. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
'''
def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
    for i in range(len(nums)):
        index_value = abs(nums[i])-1
        if nums[index_value] > 0:
            nums[index_value] = 0-nums[index_value]
    
    result = []
    for i in range(len(nums)):
        if nums[i] > 0:
            result.append(i+1)
        else:
            nums[i] = 0-nums[i]
    return result

'''
    66. PROBLEM DESCRIPTION (https://leetcode.com/problems/target-sum/)
'''
def findTargetSumWays(self, nums: list[int], target: int) -> int:
        max_sum = sum(nums)
        dp_prev = [0]*max_sum + [1] + [0]*max_sum
        for i in range(len(nums)):
            dp_next = [0]*(2*max_sum+1)
            cur_num = nums[i]
            for j in range(cur_num, 2*max_sum+1):
                dp_next[j] +=  dp_prev[j-cur_num]
            for j in range(0, 2*max_sum+1-cur_num):
                dp_next[j] += dp_prev[j+cur_num]
            dp_prev = dp_next
        target_index = target+max_sum
        if target_index<0 or target_index>2*max_sum:
            return 0
        return dp_prev[target_index]

'''
    67. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-depth-of-binary-tree/)
'''
def maxDepth(self, root: TreeNode | None) -> int:
    if not root:
        return 0
    return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

'''
    68. PROBLEM DESCRIPTION (https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
'''
def flatten(self, root: TreeNode | None) -> None:
    """
    Do not return anything, modify root in-place instead.
    """
    if not root:
        return
    if root.left:
        self.flatten(root.left)
        ptr = root.left
        while ptr.right:
            ptr = ptr.right
        ptr.right = root.right
        root.right = root.left
        root.left = None
        root = ptr
    self.flatten(root.right)

'''
    69. PROBLEM DESCRIPTION (https://leetcode.com/problems/subsets/)
'''
def subsets(self, nums: list[int]) -> list[list[int]]:
    self.result, self.cur_list = [], []
    def helper(index):
        if index == len(nums):
            self.result.append(self.cur_list[:])
            return
        helper(index+1)
        self.cur_list.append(nums[index])
        helper(index+1)
        self.cur_list = self.cur_list[:-1]
    helper(0)
    return self.result


'''
    70. PROBLEM DESCRIPTION (https://leetcode.com/problems/symmetric-tree/)
'''
def isSymmetric(self, root: TreeNode | None) -> bool:
    def helper(leftnode, rightnode):
        if bool(leftnode) ^ bool(rightnode):
            return False
        if not leftnode:
            return True
        if leftnode and leftnode.val!=rightnode.val:
            return False
        return helper(leftnode.left, rightnode.right) and helper(leftnode.right, rightnode.left) 
    return helper(root.left, root.right)

'''
    71. PROBLEM DESCRIPTION (https://leetcode.com/problems/subsets-ii/)
'''
def subsetsWithDup(self, nums: list[int]) -> list[list[int]]:
    self.result = []

    def helper(nums, start, cur_list):
        self.result.append(cur_list[:])
        for index in range(start, len(nums)):
            if(index>start and nums[index]==nums[index-1]):
                continue
            cur_list.append(nums[index])
            helper(nums, index+1, cur_list)
            cur_list.pop()

    nums.sort()
    helper(nums, 0, [])
    return self.result

'''
    72. PROBLEM DESCRIPTION (https://leetcode.com/problems/jump-game/)
'''
def canJump(self, nums: list[int]) -> bool:
    max_reached, to_reach, index = 0, len(nums)-1, 0
    while index<=max_reached and max_reached<to_reach:
        max_reached = max(max_reached, index+nums[index])
        index+=1
    return max_reached>=to_reach

'''
    73. PROBLEM DESCRIPTION (https://leetcode.com/problems/group-anagrams/)
'''
def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
    mydict = defaultdict(list)
    for s in strs:
        sorted_str = "".join(sorted(s))
        mydict[sorted_str].append(s)
    return list(mydict.values())

'''
    74. PROBLEM DESCRIPTION (https://leetcode.com/problems/unique-paths/)
'''
def uniquePaths(self, m: int, n: int) -> int:
    dp = [1]*n
    for _ in range(1, m):
        for j in range(1, n):
            dp[j] += dp[j-1]
    return dp[n-1]

'''
    75. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-path-sum/)
'''
def minPathSum(self, grid: list[list[int]]) -> int:
    m, n, dp = len(grid), len(grid[0]), grid[0][:]
    for i in range(1, n):
        dp[i] += dp[i-1]
    for i in range(1,m):
        dp[0] += grid[i][0]
        for j in range(1, n):
            dp[j] = min(dp[j-1], dp[j])+grid[i][j]
    return dp[n-1] 

'''
    76. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-level-order-traversal/)
'''
def levelOrder(self, root: TreeNode | None) -> list[list[int]]:
    result = []
    if not root:
        return result
    myqueue = deque([(root, 0)])
    while myqueue:
        popped_node, popped_lvl = myqueue.popleft()
        if popped_node.left:
            myqueue.append((popped_node.left, popped_lvl+1))
        if popped_node.right:
            myqueue.append((popped_node.right, popped_lvl+1))
        if popped_lvl == len(result):
            result.append([])
        result[popped_lvl].append(popped_node.val)
    return result

'''
    77. PROBLEM DESCRIPTION (https://leetcode.com/problems/validate-binary-search-tree/)
'''
def isValidBST(self, root: TreeNode | None) -> bool:
    def helper(root, lb, ub):
        if not root:
            return True
        if lb is not None and root.val<=lb:
            return False
        if ub is not None and root.val>=ub:
            return False
        return helper(root.left, lb, root.val) and helper(root.right, root.val, ub)
    return helper(root, None, None)

'''
    78. PROBLEM DESCRIPTION (https://leetcode.com/problems/word-search/)
'''
def exist(self, board: list[list[str]], word: str) -> bool:
    self.dir = [(0,1), (0,-1), (1, 0), (-1,0)]
    self.m, self.n = len(board), len(board[0])
    def helper(word_idx, row, col):
        if row<0 or row>=self.m or col<0 or col>=self.n or board[row][col] != word[word_idx]:
            return False
        if word_idx == len(word)-1:
            return True
        temp = board[row][col]
        board[row][col] = '#'
        isreached = False
        for d in self.dir:
            new_row, new_col = row+d[0], col+d[1]
            isreached |= helper(word_idx+1, new_row, new_col)
        board[row][col] = temp
        return isreached

    for i in range(self.m):
        for j in range(self.n):
            if helper(0, i, j):
                return True
    return False

'''
    79. PROBLEM DESCRIPTION (https://leetcode.com/problems/contains-duplicate/)
'''
def containsDuplicate(self, nums: list[int]) -> bool:
    myset = set()
    for x in nums:
        if x in myset:
            return True
        myset.add(x)
    return False


'''
    80. PROBLEM DESCRIPTION (https://leetcode.com/problems/count-primes/)
'''
def countPrimes(self, n: int) -> int:
    if n<3:
        return 0
    is_prime = [True] * n
    is_prime[0] = is_prime[1] = False
    upper_bound = math.isqrt(n)

    for i in range(2, upper_bound + 1):
        if is_prime[i]:
            for j in range(i * i, n , i):
                is_prime[j] = False

    return sum(is_prime)
    
'''
    81. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-islands/)
'''
def numIslands(self, grid: List[List[str]]) -> int:
    m, n, result = len(grid), len(grid[0]), 0
    def helper(grid, row, col):
        if row<0 or col<0 or row>=m or col>=n or grid[row][col]!='1':
            return
        grid[row][col] = '0'
        helper(grid, row+1, col)
        helper(grid, row-1, col)
        helper(grid, row, col+1)
        helper(grid, row, col-1)
    for i in range(m):
        for j in range(n):
            if grid[i][j] == '1':
                result+=1
                helper(grid, i, j)
    return result

'''
    82. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-peak-element/)
'''
def findPeakElement(self, nums: list[int]) -> int:
    left, right = 0, len(nums)-1
    while left<right:
        mid = (left+right)//2
        if nums[mid]>nums[mid+1]:
            right = mid
        else:
            left = mid+1
    return left

'''
    83. PROBLEM DESCRIPTION (https://leetcode.com/problems/fizz-buzz/)
'''
def fizzBuzz(self, n: int) -> list[str]:
    result = []
    for i in range(1, n+1):
        ans = ""
        if i%3 == 0:
            ans += "Fizz"
        if i%5 == 0:
            ans += "Buzz"
        if len(ans) == 0:
            ans = str(i)
        result.append(ans)
    return result

'''
    84. PROBLEM DESCRIPTION (https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
'''
def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
    n = len(matrix)
    
    def get_rank(current_num):
        cur_count, col_index = 0, n-1
        for i in range(n):
            while col_index>-1 and matrix[i][col_index]>current_num:
                col_index-=1
            cur_count += col_index+1
        return cur_count

    
    lb, ub = matrix[0][0], matrix[n-1][n-1]
    while lb<ub:
        mid = (lb+ub)//2
        count_less_than_equal = get_rank(mid)
        if k <= count_less_than_equal:
            ub = mid
        else:
            lb = mid+1
    return lb

'''
    85. PROBLEM DESCRIPTION (https://leetcode.com/problems/odd-even-linked-list/)
'''
def oddEvenList(self, head: ListNode | None) -> ListNode | None:
    oddhead , evenhead = ListNode(), ListNode()
    evenhead_cpy , node_iter, i = evenhead, head, 1
    while node_iter:
        if i%2!=0:
            oddhead.next = node_iter
            oddhead = oddhead.next
        else:
            evenhead.next = node_iter
            evenhead = evenhead.next
        i+=1
        node_iter = node_iter.next
    evenhead.next = None
    oddhead.next = evenhead_cpy.next
    return head

'''
    86. PROBLEM DESCRIPTION (https://leetcode.com/problems/find-the-duplicate-number/)
'''
def findDuplicate(self, nums: list[int]) -> int:
    for x in nums:
        index_for_num = abs(x)-1
        if nums[index_for_num]<0:
            return index_for_num+1
        nums[index_for_num] = 0-nums[index_for_num]
    return -1

'''
    87. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-anagram/)
'''
def isAnagram(self, s: str, t: str) -> bool:
    freq_map = [0]*26
    ord_a = ord('a')
    for c in s:
        freq_map[ord(c)-ord_a]+=1
    for c in t:
        freq_map[ord(c)-ord_a]-=1
        if freq_map[ord(c)-ord_a]<0:
            return False
    for x in freq_map:
        if x!=0:
            return False
    return True

'''
    88. PROBLEM DESCRIPTION (https://leetcode.com/problems/product-of-array-except-self/)
'''
def productExceptSelf(self, nums: list[int]) -> list[int]:
    result , cur_prod, n= [1]*len(nums), 1, len(nums)
    for i in range(1, n):
        cur_prod *= nums[i-1]
        result[i] = cur_prod
    cur_prod = 1
    for i in range(n-2, -1, -1):
        cur_prod *= nums[i+1]
        result[i] *= cur_prod
    return result

'''
    89. PROBLEM DESCRIPTION (https://leetcode.com/problems/factorial-trailing-zeroes/)
'''
def trailingZeroes(self, n: int) -> int:
    result = 0
    while n!=0:
        n //= 5
        result += n
    return result

'''
    90. PROBLEM DESCRIPTION (https://leetcode.com/problems/basic-calculator-ii/)
'''
def calculate(self, s: str) -> int:
    self.operand_stck, self.operator_stck = [], []
    s_iter = 0

    def perform_operation():
        operand2, operand1 = self.operand_stck.pop(), self.operand_stck.pop()
        cur_operator = self.operator_stck.pop()
        result = 0
        if cur_operator == '+':
            result = operand1 + operand2
        elif cur_operator == '-':
            result = operand1 -  operand2
        elif cur_operator == '*':
            result = operand1 * operand2
        else:
            result = operand1 // operand2
        self.operand_stck.append(result)

    while s_iter < len(s):
        # print(self.operator_stck, self.operand_stck,len(self.operator_stck))
        cur_char = s[s_iter]
        if cur_char.isdigit():
            next_iter = s_iter+1
            while next_iter<len(s) and s[next_iter].isdigit():
                next_iter += 1
            self.operand_stck.append(int(s[s_iter: next_iter]))
            s_iter = next_iter-1
        elif cur_char != ' ':
            if cur_char == '+' or cur_char == '-':
                while self.operator_stck:
                    perform_operation()
            elif self.operator_stck and (self.operator_stck[-1]=="*" or self.operator_stck[-1]=="/"):
                perform_operation()
            self.operator_stck.append(cur_char)
        s_iter+=1
    while self.operator_stck:
        perform_operation()
    return self.operand_stck[-1]

'''
    91. PROBLEM DESCRIPTION (https://leetcode.com/problems/search-a-2d-matrix-ii/)
'''
def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    m, n = len(matrix), len(matrix[0])
    row_idx, col_idx = 0, n-1
    while row_idx<m and col_idx>-1:
        cur_num = matrix[row_idx][col_idx]
        if cur_num == target:
            return True
        elif cur_num > target:
            col_idx-=1
        else:
            row_idx+=1
    return False

'''
    92. PROBLEM DESCRIPTION (https://leetcode.com/problems/delete-node-in-a-linked-list/)
'''
def deleteNode(self, node):
    """
    :type node: ListNode
    :rtype: void Do not return anything, modify node in-place instead.
    """
    node.val = node.next.val
    node.next = node.next.next

'''
    93. PROBLEM DESCRIPTION (https://leetcode.com/problems/course-schedule/)
'''
def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
    myqueue, inedges , adj_list = [], [0]*numCourses , defaultdict(list)
    for p in prerequisites:
        adj_list[p[1]].append(p[0])
        inedges[p[0]]+=1
    for course_num in range(numCourses):
        if inedges[course_num]==0:
            myqueue.append(course_num)
    num_vertices_visited = 0
    while myqueue:
        popped_vertex = myqueue.pop()
        num_vertices_visited+=1
        for adj_v in adj_list[popped_vertex]:
            inedges[adj_v]-=1
            if inedges[adj_v] == 0:
                myqueue.append(adj_v)
    return numCourses == num_vertices_visited

'''
    94. PROBLEM DESCRIPTION (https://leetcode.com/problems/surrounded-regions/)
'''
def solve(self, board: list[list[str]]) -> None:
    """
    Do not return anything, modify board in-place instead.
    """
    m, n = len(board), len(board[0])        
    def fill_region(board, row, col):
        if row<m and col<n and row>-1 and col>-1 and board[row][col] == 'O':
            board[row][col] = 'Y'
            fill_region(board, row, col+1)
            fill_region(board, row, col-1)
            fill_region(board, row+1, col)
            fill_region(board, row-1, col)
    
    def convert_board(board):
        for i in range(m):
            for j in range(n):
                cur_val = board[i][j]
                if cur_val == 'O':
                    board[i][j] = 'X'
                elif cur_val == 'Y':
                    board[i][j] = 'O'

    for i in range(0, m):
        fill_region(board, i, 0)
        fill_region(board, i, n-1)
    for i in range(1, n-1):
        fill_region(board, 0, i)
        fill_region(board, m-1, i)
    convert_board(board)

'''
    95. PROBLEM DESCRIPTION (https://leetcode.com/problems/number-of-1-bits/)
'''
def hammingWeight(self, n: int) -> int:
    result = 0
    while n>0:
        n = n & (n-1)
        result+=1
    return result

'''
    96. PROBLEM DESCRIPTION (https://leetcode.com/problems/excel-sheet-column-number/)
'''
def titleToNumber(self, columnTitle: str) -> int:
    result, n = 0, len(columnTitle)
    for i in range(n):
        result = result*26 + (ord(columnTitle[i])-ord('A')+1)
    return result

'''
    97. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximum-product-subarray/)
'''
def maxProduct(self, nums: list[int]) -> int:
    max_positive, min_negative, result = 1, 1, nums[0]
    for x in nums:
        temp_max = max(x, max(max_positive*x, min_negative*x))
        min_negative = min(x, min(min_negative*x, max_positive*x))
        max_positive = temp_max
        result = max(result, max_positive)
    return result

'''
    98. PROBLEM DESCRIPTION (https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
'''
def sortedArrayToBST(self, nums: list[int]) -> TreeNode | None:
        
    def helper(nums, lb, ub):
        if lb>ub:
            return None
        mid = (lb+ub)//2
        root = TreeNode(nums[mid])
        root.right = helper(nums, mid+1, ub)
        root.left = helper(nums, lb, mid-1)
        return root

    return helper(nums, 0, len(nums)-1)

'''
    99. PROBLEM DESCRIPTION (https://leetcode.com/problems/middle-of-the-linked-list/)
'''
def middleNode(self, head: ListNode | None) -> ListNode | None:
    slow, fast = head, head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    return slow

'''
    100. PROBLEM DESCRIPTION (https://leetcode.com/problems/move-zeroes/)
'''
def moveZeroes(self, nums: list[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    non_zero_index = 0
    for index in range(len(nums)):
        if nums[index] != 0:
            nums[non_zero_index]= nums[index]
            non_zero_index+=1

    nums[non_zero_index:len(nums)]= [0]*(len(nums)-non_zero_index)

'''
    101. PROBLEM DESCRIPTION (https://leetcode.com/problems/contiguous-array/)
'''
def findMaxLength(self, nums: List[int]) -> int:
    mydict, cur_count, result = {0:-1}, 0, 0
    for idx, x in enumerate(nums):
        cur_count += (1 if x==1 else -1)
        if cur_count in mydict:
            result = max(result, idx - mydict[cur_count])
        else:
            mydict[cur_count] = idx
    return result

'''
    102. PROBLEM DESCRIPTION (https://leetcode.com/problems/n-queens/)
'''
def solveNQueens(self, n: int) -> list[list[str]]:
    self.result, self.queen_pos, self.col_placed_set, self.diag1_placed_set, self.diag2_placed_set = [], [], set(), set(), set()
    self.board = [['.']*n for _ in range(n)]
    
    def isValidCell(row, col):
        if col in self.col_placed_set or col+row in self.diag1_placed_set or col-row in self.diag2_placed_set:
            return False
        return True

    def helper(row):
        if row == n:
            copy = self.board[:]
            sol = []
            for c in copy:
                sol.append("".join(c[:]))
            self.result.append(sol)
            return
        for col_cand in range(n):
            if isValidCell(row, col_cand):
                self.col_placed_set.add(col_cand)
                self.diag1_placed_set.add(col_cand+row)
                self.diag2_placed_set.add(col_cand-row)
                self.board[row][col_cand] = 'Q'
                helper(row+1)
                self.col_placed_set.remove(col_cand)
                self.diag1_placed_set.remove(col_cand+row)
                self.diag2_placed_set.remove(col_cand-row)
                self.board[row][col_cand] = '.'

    helper(0)
    return self.result

'''
    103. PROBLEM DESCRIPTION (https://leetcode.com/problems/backspace-string-compare/)
'''
def backspaceCompare(self, s: str, t: str) -> bool:
    index1, index2 = len(s)-1, len(t)-1
    
    def get_next_character_index(string, index):
        num_backspaces = 0
        while index>-1:
            if index>-1 and string[index]=='#':
                num_backspaces+=1
            elif num_backspaces>0:
                num_backspaces-=1
            else:
                break
            index-=1
        return index
    count =0
    while index1>-1 or index2>1:
        index1 = get_next_character_index(s, index1)
        index2 = get_next_character_index(t, index2)
        if index1<0 or index2<0:
            return index1==index2
        if s[index1] != t[index2]:
            return False
        index1-=1
        index2-=1
    return True

'''
    104. PROBLEM DESCRIPTION (https://leetcode.com/problems/last-stone-weight/)
'''
def lastStoneWeight(self, stones: list[int]) -> int:
    mymap, max_stone = defaultdict(int), stones[0]
    for x in stones:
        mymap[x]+=1
        max_stone = max(max_stone, x)
    index = max_stone
    while index>=1:
        if mymap[index]%2==1:
            prev_stone = index-1
            while prev_stone>=1 and mymap[prev_stone]==0:
                prev_stone-=1
            if prev_stone<1:
                return index
            mymap[index-prev_stone]+=1
            mymap[prev_stone]-=1
            index = max(prev_stone, index-prev_stone)
        else:
            index-=1
    return 0

def lastStoneWeight(self, stones: list[int]) -> int:
    heapq.heapify_max(stones)
    while len(stones)>1:
        current_largest = heapq.heappop_max(stones)
        current_second_largest = heapq.heappop_max(stones)
        if current_largest != current_second_largest:
            heapq.heappush_max(stones, current_largest - current_second_largest) 
    return stones[-1] if stones else 0

'''
    105. PROBLEM DESCRIPTION (http://leetcode.com/problems/convert-bst-to-greater-tree/)
'''
def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
    self.sum_til_now = 0
    def helper(root):
        if not root:
            return
        helper(root.right)
        root.val += self.sum_til_now
        self.sum_til_now = root.val
        helper(root.left)
    helper(root)
    return root

'''
    106. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-depth-of-binary-tree/)
'''
def minDepth(self, root: TreeNode | None) -> int:
    if not root:
        return 0
    if not root.left:
        return 1+self.minDepth(root.right)
    elif not root.right:
        return 1+self.minDepth(root.left)
    return 1+min(self.minDepth(root.left), self.minDepth(root.right))

'''
    107. PROBLEM DESCRIPTION (https://leetcode.com/problems/reorder-list/)
'''
def reorderList(self, head: ListNode | None) -> None:
    """
    Do not return anything, modify head in-place instead.
    """
    slow, fast = head, head
    while (fast and fast.next):
        slow = slow.next
        fast = fast.next.next
    prev, curr = None, slow
    while curr:
        curr.next, prev, curr = prev, curr, curr.next
    while (prev.next):
        head.next, head = prev, head.next
        prev.next, prev = head, prev.next

'''
    108. PROBLEM DESCRIPTION (https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)
'''
def bstFromPreorder(self, preorder: list[int]) -> TreeNode | None:
    n = len(preorder)
    def helper(index, ub):
        if index>ub:
            return None
        cur_num = preorder[index]
        root = TreeNode(cur_num)
        inflection_point = index+1
        while inflection_point<=ub and preorder[inflection_point]<cur_num:
            inflection_point+=1
        root.left = helper(index+1, inflection_point-1)
        root.right = helper(inflection_point, ub)
        return root

    return helper(0, n-1)

'''
    109. PROBLEM DESCRIPTION (https://leetcode.com/problems/is-subsequence/)
'''
def isSubsequence(self, s: str, t: str) -> bool:
    s_index, t_index, s_len, t_len = 0, 0, len(s), len(t) 
    while s_index<s_len and t_index<t_len:
        if s[s_index]==t[t_index]:
            s_index+=1
        t_index+=1
    return s_index == s_len

'''
    110. PROBLEM DESCRIPTION (https://leetcode.com/problems/detect-capital/)
'''
def detectCapitalUse(self, word: str) -> bool:
    if len(word) ==1:
        return True
    firstCapital, secondCapital = 'A' <= word[0] <= 'Z', 'A' <= word[1] <= 'Z'
    allLower = not firstCapital or not secondCapital
    allHigher = firstCapital and secondCapital
    for c in word[1:]:
        if allLower and (c<'a' or c>'z'):
            return False
        if allHigher and (c<'A' or c>'Z'):
            return False
    return True

'''
    111. PROBLEM DESCRIPTION (https://leetcode.com/problems/sort-list/)
'''
def sortList(self, head: ListNode | None) -> ListNode | None:
    if not head or not head.next:
        return head
    slow, fast = head, head.next
    while fast and fast.next:
        slow, fast = slow.next, fast.next.next
    fast = slow.next
    slow.next = None
    head1 = self.sortList(head)
    head2 = self.sortList(fast)
    return self.mergehelper(head1, head2)

def mergehelper(self, head1, head2):
    dummyhead = ListNode(0)
    node_iter = dummyhead
    while head1 and head2:
        if head1.val<head2.val:
            node_iter.next = head1
            head1 = head1.next
        else:
            node_iter.next = head2
            head2 = head2.next
        node_iter = node_iter.next
    if head1:
        node_iter.next = head1
    else:
        node_iter.next = head2
    return dummyhead.next

'''
    112. PROBLEM DESCRIPTION (https://leetcode.com/problems/pascals-triangle/)
'''
def generate(self, numRows: int) -> list[list[int]]:
    result = [[1]]
    for i in range(2, numRows+1):
        prev_row, new_row_result = result[-1], [1]
        for col_idx in range(0, (i+1)//2-1):
            new_row_result.append(prev_row[col_idx]+ prev_row[col_idx+1])
        if i%2==0:
            new_row_result = new_row_result + new_row_result[::-1]
        else:
            new_row_result = new_row_result + new_row_result[-2::-1]
        result.append(new_row_result)
    return result

'''
    113. PROBLEM DESCRIPTION (https://leetcode.com/problems/house-robber-ii/)
'''
def rob(self, nums: list[int]) -> int:
    n = len(nums)
    if n==1:
        return nums[0]

    def helper(nums, lb, ub):
        prev_sum, cur_sum = 0, 0
        for x in nums[lb:ub]:
            prev_sum, cur_sum = cur_sum, max(prev_sum+x, cur_sum)
        return cur_sum

    return max(helper(nums, 0, n-1), helper(nums, 1, n))

'''
    114. PROBLEM DESCRIPTION (https://leetcode.com/problems/flipping-an-image/)
'''
def flipAndInvertImage(self, image: list[list[int]]) -> list[list[int]]:
    n = len(image)
    for row in range(n):
        for col in range(0,n//2):
            image[row][col], image[row][n-1-col] = 1 - image[row][n-1-col], 1 - image[row][col]
        if n%2==1:
            image[row][n//2]=1-image[row][n//2]
    return image

'''
    115. PROBLEM DESCRIPTION (https://leetcode.com/problems/lexicographical-numbers/)
'''
def lexicalOrder(self, n: int) -> list[int]:
    cur_num, result = 1, []
    for _ in range(n):
        result.append(cur_num)
        if cur_num * 10 <= n:
            cur_num*=10
        else:
            while cur_num%10==9 or cur_num==n:
                cur_num //= 10
            cur_num+=1
    return result

'''
    116. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximal-square/)
'''
def maximalSquare(self, matrix: list[list[str]]) -> int:
    result, m, n = 0, len(matrix), len(matrix[0])
    dp_prev = [0]*n
    for i in range(m):
        dp_next = [0]*n
        dp_next[0] = 1 if matrix[i][0]=='1' else 0
        for j in range(1,n):
            if matrix[i][j] == '1':
                dp_next[j] = 1 + min([dp_next[j-1], dp_prev[j-1], dp_prev[j]])
        dp_prev = dp_next
        result = max(result, max(dp_next))
    return result*result

def maximalSquare(self, matrix: list[list[str]]) -> int:
    result, m, n = 0, len(matrix), len(matrix[0])
    height, stck = [0]*(n+1), []
    for i in range(m):
        stck = []
        for j in range(n+1):
            cur_num = matrix[i][j] if j<n else 0
            if cur_num == '1':
                height[j]+=1
            else:
                height[j] = 0
            while stck and height[j]<=height[stck[-1]]:
                popped_index = stck.pop()
                width = j-1-(stck[-1] if stck else -1)
                result = max(result, min(width, height[popped_index]))
            stck.append(j)
    return result*result
    
'''
    117. PROBLEM DESCRIPTION (https://leetcode.com/problems/jewels-and-stones/)
'''
def numJewelsInStones(self, jewels: str, stones: str) -> int:
    jewelset, result = set(jewels), 0
    for x in stones:
        if x in jewelset:
            result +=1
    return result

'''
    118. PROBLEM DESCRIPTION (https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
'''
def findMinArrowShots(self, points: list[list[int]]) -> int:
    points.sort(key = lambda x: x[0])
    cur_reach, result = points[0][1], 1
    for p in points:
        if p[0]>cur_reach:
            result += 1
            cur_reach = p[1]
        else:
            cur_reach = min(cur_reach, p[1])

    return result

'''
    119. PROBLEM DESCRIPTION (https://leetcode.com/problems/132-pattern/)
'''
def find132pattern(self, nums: list[int]) -> bool:
    mystck = []
    second = None
    for x in reversed(nums):
        if second and x<second:
            return True
        while mystck and x>mystck[-1]:
            second = mystck.pop()
        mystck.append(x)
    return False

'''
    120. PROBLEM DESCRIPTION (https://leetcode.com/problems/lemonade-change/)
'''
def lemonadeChange(self, bills: list[int]) -> bool:
    num_5, num_10 = 0, 0
    for x in bills:
        if x == 5:
            num_5+=1
        elif x == 10:
            num_10+=1
            num_5-=1
        else:
            if num_10 > 0:
                num_10-=1
                num_5-=1
            else: 
                num_5-=3
        if num_5<0:
            return False
    return True

'''
    121. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-parenthesis-string/)
'''
def checkValidString(self, s: str) -> bool:
    max_open, min_open = 0, 0
    for x in s:
        if x=='(':
            max_open+=1
            min_open+=1
        elif x==')':
            max_open-=1
            min_open-=1
        else:
            max_open+=1
            min_open-=1
        if max_open<0:
            return False
        min_open = max(min_open, 0)
    return min_open==0

'''
    122. PROBLEM DESCRIPTION (https://leetcode.com/problems/arranging-coins/)
'''
def arrangeCoins(self, n: int) -> int:
    lb, ub = 1, n//2+1
    while lb<=ub:
        mid = (lb+ub)//2
        total = mid*(mid+1)//2
        if total<=n:
            lb = mid+1
        else:
            ub = mid-1
    return ub

'''
    123. PROBLEM DESCRIPTION (https://leetcode.com/problems/minesweeper/)
'''
def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
    self.m, self.n, self.board, self.dir = len(board), len(board[0]), board, [[0,1],[0,-1], [1,1], [1,-1], [1,0], [-1,0], [-1,1], [-1,-1]]
    if board[click[0]][click[1]] == 'M':
        board[click[0]][click[1]] = 'X'
        return board

    def get_adjacent_count(row, col):
        total_count =0
        for d in self.dir:
            new_row, new_col = row+d[0], col+d[1]
            if new_row>-1 and new_col>-1 and new_row<self.m and new_col<self.n and self.board[new_row][new_col]=='M':
                total_count+=1
        return total_count

    def revealsquare(row, col):
        count_zeros = get_adjacent_count(row, col)
        if count_zeros ==0:
            self.board[row][col] = 'B'
            for d in self.dir:
                new_row, new_col = row+d[0], col+d[1]
                if new_row>-1 and new_col>-1 and new_row<self.m and new_col<self.n and self.board[new_row][new_col]=='E':
                    revealsquare(new_row, new_col)
        else:
            self.board[row][col] = str(count_zeros)
    revealsquare(click[0], click[1])
    return board

'''
    124. PROBLEM DESCRIPTION (https://leetcode.com/problems/valid-perfect-square/)
'''
def isPerfectSquare(self, num: int) -> bool:
    lb, ub = 1, num//2
    while lb<ub:
        mid = (lb+ub)//2
        if mid*mid>=num:
            ub = mid
        else:
            lb = mid+1
    return lb*lb==num

'''
    125. PROBLEM DESCRIPTION (https://leetcode.com/problems/n-queens-ii/)
'''
def totalNQueens(self, n: int) -> int:
    self.n, col, diag1, diag2 = n, 0, 0, 0
    
    def solve(row, col, diag1, diag2):
        if row==self.n:
            return 1
        total_count = 0
        for iter_col in range(0, self.n):
            col_bit = 1<<iter_col
            diag1_bit = 1<<(row+iter_col)
            diag2_bit = 1<<(self.n-1+row-iter_col)
            if  (col & col_bit) or (diag1 & diag1_bit) or (diag2 & diag2_bit): 
                continue    
            total_count += solve(row+1, col|col_bit, diag1|diag1_bit, diag2|diag2_bit)
        return total_count

    return solve(0, col, diag1, diag2)

'''
    126. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
'''
def deleteDuplicates(self, head: ListNode | None) -> ListNode | None:
    cur_node = head

    while cur_node:
        next_node = cur_node.next
        while next_node and next_node.val==cur_node.val:
            next_node = next_node.next
        cur_node.next = next_node
        cur_node = cur_node.next

    return head

'''
    127. PROBLEM DESCRIPTION (https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
'''
def deleteDuplicates(self, head: ListNode | None) -> ListNode | None:
    dummyhead = ListNode()
    result_iter = dummyhead
    while head:
        cur_val = head.val
        if head.next and head.next.val==cur_val:
            while head and head.val==cur_val:
                head = head.next
        else:
            result_iter.next = head
            head = head.next
            result_iter = result_iter.next
    result_iter.next = None
    return dummyhead.next

'''
    128. PROBLEM DESCRIPTION (https://leetcode.com/problems/partition-list/)
'''
def partition(self, head: ListNode | None, x: int) -> ListNode | None:
    less_than_head, more_than_head = ListNode(), ListNode()
    iter_less_than, iter_more_than = less_than_head, more_than_head
    while head:
        if head.val<x:
            iter_less_than.next = head
            iter_less_than = iter_less_than.next
        else:
            iter_more_than.next = head
            iter_more_than = iter_more_than.next
        head = head.next
    iter_less_than.next = more_than_head.next
    iter_more_than.next = None
    return less_than_head.next

'''
    129. PROBLEM DESCRIPTION (https://leetcode.com/problems/maximal-rectangle/)
'''
def maximalRectangle(self, matrix: list[list[str]]) -> int:
    m, n, result = len(matrix), len(matrix[0]), 0
    height = [0]*(n+1)
    for i in range(m):
        stck = []
        for j in range(n+1):
            cur_val = '0' if j==n else matrix[i][j]
            if cur_val == '1':
                height[j]+=1
            else:
                height[j]=0
            while stck and height[j]<=height[stck[-1]]:
                popped_idx = stck.pop()
                cur_len = j - 1 -(stck[-1] if stck else -1)
                result = max(result, cur_len*height[popped_idx])
            stck.append(j)
    return result

'''
    130. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-linked-list-ii/)
'''
def reverseBetween(self, head: ListNode | None, left: int, right: int) -> ListNode | None:
    dummyhead = ListNode()
    dummyhead.next, head = head, dummyhead 
    self.last_node, self.next_node = None, None
    for i in range(left-1):
        head = head.next

    def reverse_helper(head, num_nodes):
        if num_nodes == 0:
            self.prev_node = head
            self.next_node = head.next if head else None
            return head
        next_reversed_node = reverse_helper(head.next, num_nodes-1)
        self.prev_node.next = head
        self.prev_node = head
        return next_reversed_node

    head.next = reverse_helper(head.next, right-left)
    self.prev_node.next = self.next_node
    return dummyhead.next

'''
    131. PROBLEM DESCRIPTION (https://leetcode.com/problems/array-partition/)
'''
def arrayPairSum(self, nums: List[int]) -> int:
    total = 0
    nums.sort()
    for i in range(0, len(nums), 2):
        total+=nums[i]
    return total

'''
    132. PROBLEM DESCRIPTION (https://leetcode.com/problems/super-ugly-number/)
'''
def nthSuperUglyNumber(self, n: int, primes: list[int]) -> int:
    result, pq, num_elements = [1], [0]*len(primes), 1
    for p in primes:
        pq.append((1, p, 1))
    heapq.heapify(pq)
    while num_elements < n:
        popped_product, popped_prime, popped_prime_count = heapq.heappop(pq)

        if popped_product != result[-1]:
            result.append(popped_product)
            num_elements +=1
        heapq.heappush(pq, (popped_prime*result[popped_prime_count-1], popped_prime, popped_prime_count+1))
    return result[-1]

'''
    133. PROBLEM DESCRIPTION (https://leetcode.com/problems/image-smoother/)
'''
def imageSmoother(self, img: list[list[int]]) -> list[list[int]]:
    m, n, dir = len(img), len(img[0]), [[1,0],[1,-1],[1,1],[-1,0],[-1,-1],[-1,1],[0,1],[0,-1]]
    result = [[0]*n for _ in range(m)]
    
    def average_helper(row, col):
        cur_total, neighbor_count = img[row][col], 1
        for d in dir:
            new_row, new_col = d[0]+row, d[1]+col
            if new_row>-1 and new_row<m and new_col<n and new_col>-1:
                cur_total += img[new_row][new_col]
                neighbor_count +=1
        return cur_total//neighbor_count

    
    for i in range(m):
        for j in range(n):
            result[i][j] = average_helper(i, j)
    return result

'''
    134. PROBLEM DESCRIPTION (https://leetcode.com/problems/binary-tree-tilt/)
'''
def findTilt(self, root: Optional[TreeNode]) -> int:
    self.tilt = 0
    def tilt_helper(root) -> int: #(tilt, sum)
        if not root:
            return 0
        leftsum, rightsum = tilt_helper(root.left), tilt_helper(root.right)
        self.tilt += abs(leftsum-rightsum)
        return leftsum+rightsum+root.val
    tilt_helper(root)
    return self.tilt
    
'''
    135. PROBLEM DESCRIPTION (https://leetcode.com/problems/distribute-candies/)
'''
def distributeCandies(self, candyType: list[int]) -> int:
    return min(len(set(candyType)), len(candyType)//2)

'''
    136. PROBLEM DESCRIPTION (https://leetcode.com/problems/trapping-rain-water/)
'''
def trap(self, height: list[int]) -> int:
    n, stck, total_water = len(height), [], 0
    for i in range(n):
        cur_height = height[i]
        while stck and cur_height>=height[stck[-1]]:
            popped_idx = stck.pop()
            if stck:
                cur_len, cur_water_height = i - stck[-1]-1, min(cur_height, height[stck[-1]]) - height[popped_idx]
                total_water += cur_len*cur_water_height
        stck.append(i)
    return total_water

'''
    137. PROBLEM DESCRIPTION (https://leetcode.com/problems/first-unique-character-in-a-string/)
'''
def firstUniqChar(self, s: str) -> int:
    mymap = defaultdict(int)
    for c in s:
        mymap[c]+=1
    for idx, c in enumerate(s):
        if mymap[c]==1:
            return idx
    return -1

'''
    138. PROBLEM DESCRIPTION (https://leetcode.com/problems/perfect-squares/)
'''
def numSquares(self, n: int) -> int:
    dp = [0]*(n+1)
    dp[0] = 0
    for idx in range(1, n+1):
        dp[idx] = idx
        for perfect_square in range(1, math.isqrt(idx)+1):
            cur_square = perfect_square*perfect_square
            dp[idx]=min(dp[idx], 1+dp[idx-cur_square])
    return dp[n]

'''
    139. PROBLEM DESCRIPTION (https://leetcode.com/problems/path-sum/)
'''
def hasPathSum(self, root: TreeNode | None, targetSum: int) -> bool:
    if not root:
        return False
    cur_num = targetSum-root.val
    if cur_num==0 and not root.left and not root.right:
        return True
    return self.hasPathSum(root.left, cur_num) | self.hasPathSum(root.right, cur_num)

'''
    140. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-k-sorted-lists/)
'''
def mergeKLists(self, lists: list[ListNode | None]) -> ListNode | None:
        
    def mergelists(left, right)->ListNode:
        dummynode = ListNode()
        head = dummynode
        while left and right:
            if left.val <= right.val:
                dummynode.next = left
                left = left.next
            else:
                dummynode.next = right
                right = right.next
            dummynode = dummynode.next
        dummynode.next = left if left else right
        return head.next

    def mergelisthelper(lists, lb, ub) -> ListNode:
        if lb==ub:
            return lists[lb]
        mid = (lb+ub)//2
        leftmerged = mergelisthelper(lists, lb, mid)
        rightmerged = mergelisthelper(lists, mid+1, ub)

        return mergelists(leftmerged, rightmerged)

    if not lists:
        return None
    return mergelisthelper(lists, 0, len(lists)-1)

'''
    141. PROBLEM DESCRIPTION (https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
'''
def longestIncreasingPath(self, matrix: list[list[int]]) -> int:
    m, n, answer, directions = len(matrix), len(matrix[0]), 0, [[0,1],[0,-1],[-1,0],[1,0]]
    self.memo = [[0]*n for _ in range(m)]
    
    def helper(row, col):
        if self.memo[row][col]>0:
            return self.memo[row][col]
        cur_num, cur_max_path = matrix[row][col], 0
        for d in directions:
            new_row, new_col = d[0]+row, d[1]+col
            if new_row>-1 and new_row<m and new_col>-1 and new_col<n and matrix[new_row][new_col]>cur_num:
                cur_max_path = max(cur_max_path, helper(new_row, new_col))
        self.memo[row][col] = 1+cur_max_path
        return self.memo[row][col]
    
    for i in range(m):
        for j in range(n):
            answer = max(answer, helper(i, j))
    return answer

'''
    142. PROBLEM DESCRIPTION (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
'''
def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
    mymap, answer = defaultdict(int), []
    for x in nums1:
        mymap[x]+=1
    for x in nums2:
        if mymap[x]:
            answer.append(x)
            mymap[x]-=1
    return answer

'''
    143. PROBLEM DESCRIPTION (https://leetcode.com/problems/reverse-string/)
'''
def reverseString(self, s: list[str]) -> None:
    """
    Do not return anything, modify s in-place instead.
    """
    l = len(s)
    for i in range(l//2):
        s[i], s[l-i-1] = s[l-i-1], s[i]

'''
    144. PROBLEM DESCRIPTION (https://leetcode.com/problems/merge-intervals/)
'''
def merge(self, intervals: list[list[int]]) -> list[list[int]]:
    intervals.sort(key=lambda x: x[0])
    current_end, result, current_start = intervals[0][1], [], intervals[0][0] 
    for interval in intervals[1:]:
        if current_end<interval[0]:
            result.append([current_start, current_end])
            current_start, current_end = interval[0], interval[1]
        else:
            current_end = max(current_end, interval[1])
    result.append([current_start, current_end])
    return result

'''
    145. PROBLEM DESCRIPTION (https://leetcode.com/problems/median-of-two-sorted-arrays/)
'''
def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
    len1, len2 = len(nums1), len(nums2)
    if len1>len2:
        return self.findMedianSortedArrays(nums2,nums1)
    lb, ub = 0, 2*len1
    while lb<=ub:
        mid1 = (lb+ub)//2
        mid2 = len1+len2-mid1
        L1 = float(-inf) if mid1==0 else nums1[(mid1-1)//2]
        L2 = float(-inf) if mid2==0 else nums2[(mid2-1)//2]
        R1 = float(inf) if mid1==2*len1 else nums1[mid1//2]
        R2 = float(inf) if mid2==2*len2 else nums2[mid2//2]
        if L1>R2:
            ub = mid1-1
        elif L2>R1:
            lb = mid1+1
        else:
            return (min(R1,R2)+max(L1, L2))/2
    return -1

'''
    146. PROBLEM DESCRIPTION (https://leetcode.com/problems/excel-sheet-column-title/)
'''

def main():
    print("Entering Main")
    return 0

if __name__=="__main__":
    main()