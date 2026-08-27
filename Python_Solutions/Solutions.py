## START OF CLASS OBJECTS
import collections

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

def main():
    print("Entering Main")
    return 0

if __name__=="__main__":
    main()