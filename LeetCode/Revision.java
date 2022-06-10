package LeetCode;

//import sun.plugin.javascript.navig.Array;
//import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class Revision
{

    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(hmap.containsKey(target-nums[iterator_i]))
                return new int[]{hmap.get(target-nums[iterator_i]),iterator_i};
            hmap.put(nums[iterator_i],iterator_i);
        }
        return new int[]{-1,-1};
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int sum=0;
        ListNode final_list = new ListNode(0),iterator_node = final_list;
        while(l1!=null || l2!=null)
        {
            if(l1!=null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode next_node = new ListNode(sum%10);
            sum = sum/10;
            iterator_node.next = next_node;
            iterator_node = iterator_node.next;

        }
        if(sum!=0)
        {
            ListNode newnode = new ListNode(1);
            iterator_node.next = newnode;
        }
        return final_list.next;
    }

    public int lengthOfLongestSubstring_hmap(String s)
    {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int max_length=0, index_last_start = -1;

        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            char current_char = s.charAt(iterator_i);
            int mapval = hmap.getOrDefault(current_char,-1);
            if(mapval>index_last_start)
                index_last_start = mapval;
            if(max_length<iterator_i-index_last_start)
                max_length = iterator_i - index_last_start;
            hmap.put(current_char,iterator_i);
        }
        return max_length;
    }

    public int lengthOfLongestSubstring(String s)
    {
        int hmap[] = new int[256];
        int max_length=0, index_last_start = 0;

        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            char current_char = s.charAt(iterator_i);
            int mapval = hmap[current_char];
            if(mapval>index_last_start)
                index_last_start = mapval;

            max_length = Math.max( max_length,iterator_i - index_last_start+1);
            hmap[current_char] = iterator_i+1;
        }
        return max_length;
    }

    public int reverse(int x)
    {
        boolean positive = (x>0)?true:false;
        int reversed_number = 0;
        while(x!=0)
        {
         if (Math.abs(reversed_number) > Integer.MAX_VALUE / 10 || (Math.abs(reversed_number) == Integer.MAX_VALUE / 10 && (x % 10 + (positive?0:1) > Integer.MAX_VALUE % 10)))
             return 0;

         reversed_number = reversed_number * 10 + x%10;
         x /= 10;
        }
        return reversed_number;
    }

    public int myAtoi(String s)
    {
        boolean positive = true;
        int char_index = 0,result=0;
        while(char_index<s.length() && s.charAt(char_index)==' ')
            char_index++;
        if(char_index==s.length())
            return 0;
        char curr_char = s.charAt(char_index);
        if(curr_char=='+'|| curr_char=='-')
        {
            if(curr_char == '-')
                positive = false;
            char_index++;
        }
        if(char_index==s.length())
            return 0;
        curr_char = s.charAt(char_index);
        if(!Character.isDigit(curr_char))
            return 0;
        while(Character.isDigit(curr_char))
        {
            if (Math.abs(result) > Integer.MAX_VALUE / 10 || (Math.abs(result) == Integer.MAX_VALUE/10 && ((curr_char-'0') + (positive?0:-1) > Integer.MAX_VALUE % 10)))
                return (positive?Integer.MAX_VALUE:Integer.MIN_VALUE);
            result = result*10 + (curr_char-'0');
            if(char_index == s.length()-1)
                return result*(positive?1:-1);
            curr_char = s.charAt(++char_index);
        }
        return result*(positive?1:-1);
    }

    public boolean isPalindrome(int x)
    {
        if(x<0)
            return false;
        int len=0,x_cpy=x;
        while(x_cpy!=0)
        {
            x_cpy /=10;
            len++;
        }
        for(int iterator_index=0;iterator_index<len/2;iterator_index++)
        {
            if(((int)(x/Math.pow(10,len-iterator_index-1))%10) != ((int)(x/Math.pow(10,iterator_index)))%10)
                return false;
        }
        return true;
    }

    public String intToRoman(int num)
    {
        String thousandth[] = {"","M","MM","MMM"};
        String hundred[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ten[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String unit[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};

        return thousandth[num/1000] + hundred[(num%1000)/100] + ten[(num%100)/10] + unit[(num%10)];
    }

    public String longestCommonPrefix(String[] strs)
    {
        StringBuilder prefix = new StringBuilder();
        int index = 0;
        if(strs.length==0)
            return "";
        while(index<strs[0].length())
        {
            for (int iterator_strs = 1; iterator_strs < strs.length; iterator_strs++) {
                if (index>=strs[iterator_strs].length() || strs[iterator_strs].charAt(index) != strs[0].charAt(index))
                    return prefix.toString();
            }
            prefix.append(strs[0].charAt(index++));
        }
        return prefix.toString();
    }

    public boolean isValid(String s)
    {
        Stack<Character> paranthesis_stck = new Stack<>();
        String open_brackets = "([{", closed_brackets = ")]}";
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            char curr = s.charAt(iterator_i);
            if(closed_brackets.indexOf(curr) != -1)
            {
                try {
                    if (paranthesis_stck.peek() != open_brackets.charAt(closed_brackets.indexOf(curr)))
                        return false;
                    paranthesis_stck.pop();
                }
                catch (Exception e)
                {
                    return false;
                }
                continue;
            }
            paranthesis_stck.push(curr);
        }
        return paranthesis_stck.empty()?true:false;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode returnNode = new ListNode(0),startNode = returnNode;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                returnNode.next = l1;
                l1 = l1.next;
            }
            else
            {
                returnNode.next = l2;
                l2 = l2.next;
            }
            returnNode = returnNode.next;
        }
        returnNode.next = (l1==null?l2:l1);
        return startNode.next;
    }

    public int removeDuplicates(int[] nums)
    {
        int unique_index=0;
        if(nums.length==0) return 0;
        for(int iterator_index=0;iterator_index<nums.length;iterator_index++)
        {
            if(nums[unique_index]!=nums[iterator_index])
                nums[++unique_index] = nums[iterator_index];
        }
        return unique_index+1;
    }

    public int removeElement(int[] nums, int val)
    {
        int result_iterator = -1;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(val != nums[iterator_i])
                nums[++result_iterator] = nums[iterator_i];
        }
        return result_iterator+1;
    }

    public String countAndSay(int n)
    {
        String result=new String("1");
        for(int iterator_level=1;iterator_level<n;iterator_level++)
        {
            int index_str = 0;
            StringBuilder newstr = new StringBuilder();
            char cArr[] = result.toCharArray();
            while(index_str<result.length())
            {
                int count_repeat = 0;
                char curr = cArr[index_str];
                while (index_str < result.length() && curr == cArr[index_str]) {
                    count_repeat++;
                    index_str++;
                }
                newstr.append(count_repeat);
                newstr.append(curr);
            }
            result = newstr.toString();
        }
        return result;
    }

    public int searchInsert(int[] nums, int target)
    {
        int lb=0,ub=nums.length-1,mid=0;
        if(target<nums[0])
            return 0;
        if(target>nums[nums.length-1])
            return nums.length;
        while(lb<=ub)
        {
            mid = (lb+ub)/2;
            if((nums[mid]== target) || (mid>0 && nums[mid-1]<target && nums[mid]>target))
                return mid;
            else if(nums[mid]<target)
                lb = mid+1;
            else
                ub = mid-1;
        }
        return -1;
    }

    public int[] plusOne(int[] digits)
    {
        int index_curr=digits.length-1;
        while(index_curr>=0)
        {
            if(digits[index_curr]==9)
            {
                digits[index_curr--] = 0;
                continue;
            }
            digits[index_curr] = digits[index_curr--] + 1;
            return digits;
        }
        int cArr[] = new int[digits.length+1];
        cArr[0] = 1;
        return cArr;

    }


    public int mySqrt(int x)
    {
        if(x==0 || x==1)
            return x;
        int lb=0,ub=x,mid=0;
        while(lb<=ub)
        {
            mid = lb + (ub-lb)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1))
                return mid;
            else if(mid<x/mid)
                lb = mid+1;
            else
                ub = mid-1;
        }
        return -1;
    }

    public int lengthOfLastWord(String s)
    {
        s = s.trim();
        return s.length()-s.lastIndexOf(' ')+1;
    }


    public String addBinary(String a, String b)
    {
        StringBuilder result = new StringBuilder();
        boolean carry = false;
        int index_counter = 0, len_a = a.length(), len_b = b.length();
        while(index_counter<Math.max(len_a,len_b))
        {
            char curr_b = (b.length()-index_counter>0)?b.charAt(b.length()-1-index_counter):'0', curr_a = (a.length()-index_counter>0)?a.charAt(a.length()-1-index_counter):'0';
            switch(curr_a + curr_b + (carry?'1':'0') - '0' - '0' - '0')
            {
                case 2:
                    result.append('0');
                    carry = true;
                    break;
                case 1:
                    result.append('1');
                    carry = false;
                    break;
                case 3:
                    result.append('1');
                    carry = true;
                    break;
                case 0:
                    result.append('0');
            }
            index_counter++;
        }
        if(carry)
            result.append('1');
        return result.reverse().toString();
    }


    public int climbStairs(int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int iterator_i=2;iterator_i<=n;iterator_i++)
            dp[iterator_i] = dp[iterator_i-1] + dp[iterator_i-2];
        return dp[n];
    }


    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int index1= m-1,index2=n-1;
        while(index1 +index2 +1 >=0)
        {
            if(index1>=0)
                nums1[index1+index2+1] = (index2<0 || nums1[index1]>nums2[index2])?nums1[index1--]:nums2[index2--];
            else
                nums1[index1+index2+1] = nums2[index2--];
        }
    }

    public int singleNumber(int[] nums)
    {
        int result=0;
        for(int num: nums)
            result ^= num;
        return result;
    }

    public int maxProfit(int[] prices)
    {
        int max_profit = 0, curr_min = prices[0];
        for(int iterator_i=1;iterator_i<prices.length;iterator_i++)
        {
            int curr_price = prices[iterator_i];
            curr_min = Math.min(curr_min,curr_price);
            max_profit = Math.max(max_profit,curr_price-curr_min);
        }
        return max_profit;
    }

    public int maxProfit2(int[] prices)
    {
        int profit = 0;
        for(int iterator_i=1;iterator_i<prices.length;iterator_i++)
            profit +=  Math.max(prices[iterator_i]-prices[iterator_i-1],0);
        return profit;
    }

    public boolean isPalindrome(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            char curr_char = s.charAt(iterator_i);
            if(Character.isLetterOrDigit(curr_char))
                sb.append(curr_char);
        }

        for(int iterator_i=0;iterator_i<sb.length()/2;iterator_i++)
        {
            if(Character.toLowerCase(sb.charAt(iterator_i)) != Character.toLowerCase(sb.charAt(sb.length()-1-iterator_i)))
                return false;
        }
        return true;
    }

    public int strStr(String haystack, String needle)
    {
        if(needle == "")
            return 0;
        int index_str = 0;
        while(index_str<=haystack.length()-needle.length())
        {
            int index_needle = 0;
            while(index_needle<needle.length() && haystack.charAt(index_str+index_needle) == needle.charAt(index_needle))
                index_needle++;
            if(index_needle == needle.length())
                return index_str;
            index_str++;
        }
        return -1;
    }


    public List<List<Integer>> permute(int[] nums)
    {
        List result = new ArrayList<List<Integer>>();
        permuteHelper(nums,0,result);
        return result;
    }

    public void permuteHelper(int nums[],int index,List<List<Integer>> result)
    {
        if(index == nums.length-1)
        {

            List<Integer> subset = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                subset.add(nums[i]);
            }
            result.add(subset);
            return;
        }
        for(int iterator_i=index;iterator_i<nums.length;iterator_i++)
        {
            int temp = nums[index];
            nums[index] = nums[iterator_i];
            nums[iterator_i] = temp;
            permuteHelper(nums,index+1,result);
            nums[iterator_i] = nums[index];
            nums[index] = temp;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List result = new ArrayList();
        boolean used[] = new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        permuteUniqueHelper(nums,result, new ArrayList(),used);
        return result;
    }

    public void permuteUniqueHelper(int[] nums,List<List<Integer>> result,List tempList,boolean used[])
    {
        if(tempList.size() == nums.length)
        {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(used[iterator_i] ||(iterator_i>0 && nums[iterator_i] == nums[iterator_i-1] && !used[iterator_i-1]))
                continue;
            used[iterator_i] = true;
            tempList.add(nums[iterator_i]);
            permuteUniqueHelper(nums,result,tempList,used);
            used[iterator_i] = false;
            tempList.remove(tempList.size()-1);
        }
    }

    public String multiply(String num1, String num2)
    {
        StringBuilder sb = new StringBuilder();
        int carry ;
        for(int iterator_i=num1.length()-1;iterator_i>=0;iterator_i--)
        {
            carry =0;
            for(int iterator_j=num2.length()-1;iterator_j>=0;iterator_j--)
            {
                int pdt = (num1.charAt(iterator_i)-'0') * (num2.charAt(iterator_j)-'0') + carry;
                int strPos = num1.length()-1- iterator_i + num2.length()-1-iterator_j;
                if(sb.length() <= strPos)
                {
                    sb.append(pdt % 10);
                    carry = pdt/10;
                }
                else
                {
                    carry = (sb.charAt(strPos)-'0'+pdt)/10;
                    sb.replace(strPos,strPos+1,((sb.charAt(strPos)-'0'+pdt)%10)+"");
                    //sb.insert(strPos,(sb.charAt(strPos)-'0'+pdt)%10);
                }

            }
            if(carry!=0)
                sb.append(carry);
        }
        return sb.reverse().toString();
    }


    public List<String> generateParenthesis(int n)
    {
        List result = new ArrayList();
        generateParenthesisHelper(result,0,0,new StringBuffer(),n);
        return result;
    }

    public void generateParenthesisHelper(List result, int open_count,int closed_count, StringBuffer tmpres,int n)
    {
        if(closed_count==n)
        {
            result.add(tmpres.toString());
            return;
        }
        if(closed_count<open_count)
        {
            tmpres.append(")");
            generateParenthesisHelper(result, open_count, closed_count + 1, tmpres,n);
            tmpres.delete(tmpres.length()-1,tmpres.length());
        }
        if(open_count<n)
        {
            tmpres.append("(");
            generateParenthesisHelper(result, open_count + 1, closed_count, tmpres,n);
            tmpres.delete(tmpres.length()-1,tmpres.length());
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List result = new ArrayList();
        combinationSumHelper(candidates,target,result,new ArrayList(),0,0);
        return result;
    }

    public void combinationSumHelper(int[] candidates,int target,List result,List tempres,int position,int sum_till_now)
    {
        if(sum_till_now==target)
        {
            result.add(new ArrayList(tempres));
            return;
        }
        for(int iterator_i=position;iterator_i<candidates.length;iterator_i++)
        {
            if(sum_till_now+candidates[iterator_i]<=target)
            {
                tempres.add(candidates[iterator_i]);
                combinationSumHelper(candidates, target, result, tempres, iterator_i, sum_till_now + candidates[iterator_i]);
                tempres.remove(tempres.size()-1);
            }
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List result = new ArrayList();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates,target,result,new ArrayList(),-1,0);
        return result;
    }

    public void combinationSum2Helper(int[] candidates,int target,List result,List tempres,int position,int sum_till_now)
    {
        if(sum_till_now==target)
        {
            result.add(new ArrayList(tempres));
            return;
        }
        for(int iterator_i=position+1;iterator_i<candidates.length;iterator_i++)
        {
            if((iterator_i == position+1 || candidates[iterator_i]!=candidates[iterator_i-1])  && sum_till_now+candidates[iterator_i]<=target)
            {
                tempres.add(candidates[iterator_i]);
                combinationSum2Helper(candidates, target, result, tempres, iterator_i, sum_till_now+candidates[iterator_i]);
                tempres.remove(tempres.size()-1);
            }
        }
    }

    public boolean isValidSudoku(char[][] board)
    {
        boolean val_row[],val_col[],val_sub[];

        for(int iterator_i = 0;iterator_i<9;iterator_i++)
        {
            val_row = new boolean[10];
            val_col = new boolean[10];
            val_sub = new boolean[10];
            for(int iterator_j = 0;iterator_j<9;iterator_j++)
            {
                if(board[iterator_i][iterator_j] != '.')
                {
                    if(val_row[board[iterator_i][iterator_j]-'0'])
                        return false;
                    val_row[board[iterator_i][iterator_j]-'0'] = true;
                }
                if(board[iterator_j][iterator_i] != '.')
                {
                    if(val_col[board[iterator_j][iterator_i]-'0'])
                        return false;
                    val_col[board[iterator_j][iterator_i]-'0'] = true;
                }
                if(board[(iterator_i/3)*3+iterator_j/3][(iterator_i%3)*3+iterator_j%3]!='.')
                {
                    if(val_sub[board[(iterator_i/3)*3+iterator_j/3][(iterator_i%3)*3+iterator_j%3]-'0'])
                        return false;
                    val_sub[board[(iterator_i/3)*3+iterator_j/3][(iterator_i%3)*3+iterator_j%3]-'0'] = true;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board)
{
    boolean row_val[][] = new boolean[10][10],col_val[][] = new boolean[10][10],sub_val[][] = new boolean[10][10];
    for(int iterator_i=0;iterator_i<9;iterator_i++)
    {
        for(int iterator_j=0;iterator_j<9;iterator_j++)
        {
            char curr_char = board[iterator_i][iterator_j];
            if(curr_char=='.')
                continue;
            row_val[iterator_i][curr_char-'0'] = true;
            col_val[iterator_j][curr_char-'0'] = true;
            sub_val[(iterator_i/3)*3+iterator_j/3][curr_char-'0'] = true;
        }
    }
    solveSudokuHelper(board,row_val,col_val,sub_val,0,0);
}

    public boolean solveSudokuHelper(char[][] board,boolean[][] row_val,boolean[][] col_val,boolean[][] sub_val, int curr_row, int curr_col)
    {
        if(curr_row==9 && curr_col==0)
            return true;
        if(board[curr_row][curr_col]!='.')
        {
            if(curr_col==8)
            {
                if (solveSudokuHelper(board, row_val, col_val, sub_val, curr_row + 1, 0))
                    return true;
            }
            else {
                if (solveSudokuHelper(board, row_val, col_val, sub_val, curr_row, curr_col + 1))
                    return true;
            }
            return false;
        }

        for(int iterator_val=1;iterator_val<10;iterator_val++)
        {
            if(!row_val[curr_row][iterator_val] && !col_val[curr_col][iterator_val] && !sub_val[(curr_row/3)*3+curr_col/3][iterator_val])
            {
                row_val[curr_row][iterator_val] = true;
                col_val[curr_col][iterator_val] = true;
                sub_val[(curr_row/3)*3+curr_col/3][iterator_val] = true;
                board[curr_row][curr_col] = (char)(iterator_val+'0');
                if(curr_col==8)
                {
                    if (solveSudokuHelper(board, row_val, col_val, sub_val, curr_row + 1, 0))
                        return true;
                }
                else {
                    if (solveSudokuHelper(board, row_val, col_val, sub_val, curr_row, curr_col + 1))
                        return true;
                }
                board[curr_row][curr_col] = '.';
                row_val[curr_row][iterator_val] = false;
                col_val[curr_col][iterator_val] = false;
                sub_val[(curr_row/3)*3+curr_col/3][iterator_val] = false;
            }
        }
        return false;
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List result = new ArrayList();
        for(int iterator_i=0;iterator_i<nums.length-2 && nums[iterator_i]<=0;iterator_i++) {
            if (iterator_i == 0 || (iterator_i > 0 && nums[iterator_i] != nums[iterator_i - 1])) {
                int l_ptr = iterator_i + 1, r_ptr = nums.length - 1;
                while (l_ptr < r_ptr) {
                    if (nums[l_ptr] + nums[r_ptr] == 0 - nums[iterator_i]) {
                        result.add(Arrays.asList(nums[iterator_i], nums[l_ptr], nums[r_ptr]));
                        while (l_ptr < r_ptr && nums[l_ptr] == nums[l_ptr + 1])
                            l_ptr++;
                        while (r_ptr > l_ptr && nums[r_ptr - 1] == nums[r_ptr])
                            r_ptr--;

                        l_ptr++;
                        r_ptr--;
                    } else if (nums[l_ptr] + nums[r_ptr] < 0 - nums[iterator_i]) {
                        while (l_ptr < r_ptr && nums[l_ptr] == nums[l_ptr + 1])
                            l_ptr++;
                        l_ptr++;
                    } else {
                        while (r_ptr > l_ptr && nums[r_ptr] == nums[r_ptr - 1])
                            r_ptr--;
                        r_ptr--;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target)
    {
        int closest_sum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int iterator_i=0;iterator_i<nums.length-2;iterator_i++)
        {
            int l_ptr = iterator_i+1, r_ptr = nums.length-1;
            while(l_ptr<r_ptr)
            {
                if(closest_sum==Integer.MAX_VALUE || Math.abs(target - (nums[l_ptr]+nums[r_ptr]+nums[iterator_i])) < Math.abs(closest_sum-target))
                    closest_sum = nums[l_ptr]+nums[r_ptr]+nums[iterator_i];
                if(nums[l_ptr]+nums[r_ptr]+nums[iterator_i] <= target )
                    l_ptr++;
                else
                    r_ptr--;
            }
        }
        return closest_sum;
    }

    public List<String> letterCombinations(String digits)
    {
        char mappings[][] =  {{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List result = new ArrayList();
        if(digits.equals(""))
            return result;
        letterCombinationsHelper(digits, 0, mappings,result,new StringBuffer());
        return result;
    }

    public void letterCombinationsHelper(String digits,int position,char[][] mappings,List result,StringBuffer temp)
    {
        if(position == digits.length())
        {
            result.add(temp.toString());
            return;
        }
        for(int iterator_i=0;iterator_i<mappings[digits.charAt(position)-'1'].length;iterator_i++)
        {
            temp.append(mappings[digits.charAt(position)-'1'][iterator_i]);
            letterCombinationsHelper(digits, position+1, mappings,result,temp);
            temp.delete(temp.length()-1,temp.length());
        }
    }


    public int longestValidParentheses(String s)
    {
        int dp[] = new int[s.length()],max=Integer.MIN_VALUE;
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            char curr_char = s.charAt(iterator_i);
            if(curr_char == '(')
                dp[iterator_i] = 1 + ((iterator_i>0 && s.charAt(iterator_i-1)==')')?(dp[iterator_i-1]/2)*2:0);
            else if(curr_char==')' )
            {
                if(iterator_i==0)
                    continue;
                dp[iterator_i] = (s.charAt(iterator_i-1)=='('?(2+((iterator_i-2>0&&s.charAt(iterator_i-2)==')')?dp[iterator_i-2]:0)):
                        (((iterator_i-dp[iterator_i-1]-1>=0) && s.charAt(iterator_i-dp[iterator_i-1]-1)=='(')?dp[iterator_i-1]+2+
                        ((iterator_i-dp[iterator_i-1]-2>0 && s.charAt(iterator_i-dp[iterator_i-1]-2)==')')?dp[iterator_i-dp[iterator_i-1]-2]:0)
                                :0));
            }
            max = Math.max(max,dp[iterator_i]/2);
        }
        return max*2;
    }


    public int numDecodings(String s)
    {
        if(s.length()==0 || s.charAt(0)=='0')
            return 0;
        int dp_arr[] = new int[s.length()];
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            if(s.charAt(iterator_i)<='9' && s.charAt(iterator_i)>'0')
                dp_arr[iterator_i] += (iterator_i>0?dp_arr[iterator_i-1]:1);

            if(iterator_i>0 && (s.charAt(iterator_i-1)=='1' || (s.charAt(iterator_i-1)=='2' && s.charAt(iterator_i)<'7')))
                dp_arr[iterator_i] += (iterator_i>=2)?dp_arr[iterator_i-2]:1;
        }
        return dp_arr[s.length()-1];
    }


    public int findBestValue(int[] arr, int target)
    {
        Arrays.sort(arr);
        int index = 0, n=arr.length;
        while(index<n && target>(n-index)*arr[index])
            target -= arr[index++];

        if(index==n)
            return arr[n-1];

        int res = target/(n-index);
        if(target - res*(n-index) > (res+1)*(n-index)-target)
            res++;
        return res;

    }

    public boolean isHappy(int n)
    {
        HashSet hset = new HashSet();
        while(true)
        {
            int sos = 0;
            while(n!=0)
            {
                sos += Math.pow(n%10,2);
                n /= 10;
            }
            if(sos==1)
                return true;
            if(hset.contains(sos))
                return false;
            hset.add(sos);
            n = sos;
        }
    }

    List reslist = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root)
    {
        if(root==null)
            return reslist;
        inorderTraversal(root.left);
        reslist.add(root.val);
        inorderTraversal(root.right);
        return reslist;
    }


    public List<Integer> inorderTraversal1(TreeNode root)
    {
        List result = new ArrayList();
        TreeNode current = root;
        Stack stck = new Stack();
        while(current!=null || !stck.isEmpty())
        {
            while(current!=null)
            {
                stck.push(current);
                current = current.left;
            }
            if(current==null)
            {
                current = (TreeNode) stck.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }


    public boolean isPartOfDelete(int val,int to_delete[])
    {
        for(int nums:to_delete)
        {
            if(val == nums)
                return true;
        }
        return false;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
    {
        List result = new ArrayList();
        if(!isPartOfDelete(root.val,to_delete))
            result.add(root);
        delNodesHelper(root,to_delete,null,result);
        return result;
    }

    public void delNodesHelper(TreeNode root,int[] to_delete, TreeNode parent,List result)
    {
        if(root==null)
        return;
        TreeNode lchild=root.left,rchild=root.right;
        if(isPartOfDelete(root.val,to_delete))
        {
            if(lchild != null && !isPartOfDelete(lchild.val,to_delete))
                result.add(lchild);
            if(rchild!=null && !isPartOfDelete(rchild.val,to_delete))
                result.add(rchild );
            if(parent!=null)
            {
                if(parent.left == root)
                    parent.left = null;
                else
                    parent.right = null;
            }
            delNodesHelper(lchild,to_delete,null,result);
            delNodesHelper(rchild,to_delete,null,result);
            return;
        }
        delNodesHelper(lchild,to_delete,root,result);
        delNodesHelper(rchild,to_delete,root,result);

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null|| root==p||root==q)
            return root;
        TreeNode lrcur = lowestCommonAncestor(root.left,p,q);
        TreeNode rrcur = lowestCommonAncestor(root.right,p,q);
        if(lrcur != null && rrcur!=null)
            return root;
        if(lrcur==null && rrcur==null)
            return null;
        return (lrcur==null)?rrcur:lrcur;

    }

    public int subarraySum(int[] nums, int k)
    {
        int total_result=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            int sum=0;
            for(int iterator_j=iterator_i;iterator_j<nums.length;iterator_j++)
            {
                sum += nums[iterator_j];
                if(sum==k)
                    total_result++;
            }
        }
        return total_result;
    }

    public int subarraySum1(int[] nums, int k)
    {
        int total_result=0,sum=0;
        HashMap<Integer,Integer> hmap_continuoussum = new HashMap();
        hmap_continuoussum.put(0,1);
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            sum += nums[iterator_i];
            if(hmap_continuoussum.containsKey(sum-k))
                total_result += hmap_continuoussum.get(sum-k);
            hmap_continuoussum.put(sum,hmap_continuoussum.getOrDefault(sum,0)+1);
        }
        return total_result;
    }

    public int maxSubArray(int[] nums)
    {
        int max_till_now=nums[0],sum=nums[0];
        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {

            sum = Math.max(nums[iterator_i],sum+nums[iterator_i]);
            max_till_now = Math.max(max_till_now,sum);
        }
        return max_till_now;
    }

    public String longestPalindrome(String s)
    {
        int dp_arr[][] = new int[s.length()][s.length()],max_till_now=0;
        if(s.length()==1 || s.length()==0)
            return s;
        String result= s.substring(0,1);
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
            dp_arr[0][iterator_i] = 1;
        for(int iterator_length=1;iterator_length<s.length();iterator_length++)
        {
            for(int iterator_index=iterator_length;iterator_index<s.length();iterator_index++)
            {
                char curr = s.charAt(iterator_index);
                if(s.charAt(iterator_index-iterator_length) == curr && (iterator_length<2 || dp_arr[iterator_length-2][iterator_index-1]==1))
                {
                    dp_arr[iterator_length][iterator_index] = 1;
                    if (max_till_now < iterator_length)
                        result = s.substring(iterator_index-iterator_length,iterator_index+1);
                }
            }
        }
        return result;
    }


    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode frwd_ptr = head, back_ptr = head;
        for(int iterator_i=0;iterator_i<n;iterator_i++)
            frwd_ptr = frwd_ptr.next;
        if(frwd_ptr==null)
            return head.next;
        while(frwd_ptr.next!=null)
        {
            frwd_ptr = frwd_ptr.next;
            back_ptr = back_ptr.next;
        }

        back_ptr.next = back_ptr.next.next;
        return head;
    }

    public int maxArea(int[] height)
    {
        int l_ptr=0,r_ptr=height.length-1,max_area=0;
        while(l_ptr<=r_ptr)
        {
            max_area = Math.max(Math.min(height[r_ptr],height[l_ptr])*(r_ptr-l_ptr),max_area);
            if(height[l_ptr] < height[r_ptr])
                l_ptr++;
            else
                r_ptr--;
        }
        return max_area;
    }

    public void sortColors(int[] nums)
    {
        int ptr_0 = 0,ptr_1=0,ptr_2=nums.length-1;
        while(ptr_1<=ptr_2)
        {
            if(nums[ptr_1] == 0)
            {
                int temp = nums[ptr_0];
                nums[ptr_0++] = nums[ptr_1];
                nums[ptr_1++] = temp;
            }
            else if(nums[ptr_1] == 1)
                ptr_1++;
            else
            {
                int temp = nums[ptr_2];
                nums[ptr_2--] = nums[ptr_1];
                nums[ptr_1] = temp;
            }
        }
    }

    public int[] searchRange(int[] nums, int target)
    {
        int low=0,high=nums.length-1,mid=0;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(nums[mid] == target && (mid==0 || nums[mid-1]<target))
                break;
            else if(nums[mid]>=target)
                high = mid-1;
            else
                low = mid+1;
        }
        if(nums[mid]!=target)
            return new int[]{-1,-1};
        int leftboundary = mid;
        low = 0; high = nums.length-1;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(nums[mid] == target && (mid==nums.length-1 || nums[mid+1]>target))
                break;
            else if(nums[mid]<=target)
                low = mid+1;
            else
                high = mid-1;
        }
        return new int[]{leftboundary,mid};
    }

    public Node copyRandomList(Node head)
    {
        if(head==null)
            return null;
        Node original_head = head,new_head=null,result_head=null;
        while(original_head!=null)
        {
            Node newnode = new Node(original_head.val);
            newnode.next = original_head.next;
            original_head.next = newnode;
            original_head = original_head.next.next;
        }

        original_head = head;
        while(original_head!=null)
        {
            original_head.next.random = original_head.random==null?null:original_head.random.next;
            original_head = original_head.next.next;
        }
        original_head = head;
        while(original_head!=null)
        {
            if(new_head==null)
            {
                new_head = original_head.next;
                result_head = new_head;
            }
            else
            {
                new_head.next = original_head.next;
                new_head = new_head.next;
            }
            original_head.next = original_head.next.next;
            original_head = original_head.next;
        }
        return result_head;
    }

    public int[] dailyTemperatures(int[] T)
    {
        int result[] = new int[T.length];
        Stack<Integer> stck = new Stack();

        for(int iterator_i=T.length-1;iterator_i>=0;iterator_i--)
        {
            while(!stck.isEmpty() && T[stck.peek()]<=T[iterator_i])
                stck.pop();
            result[iterator_i] = stck.isEmpty()?0:stck.peek()-iterator_i;
            stck.push(iterator_i);
        }
        return result;
    }

    public TreeNode invertTree(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode lchild = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = lchild;
        return root;
    }


    public boolean hasCycle(ListNode head)
    {
        ListNode slow_ptr=head,fast_ptr=head;
        if(head == null || head.next==null)
            return false;
        do
        {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
            if(fast_ptr==null)
                return false;
            fast_ptr = fast_ptr.next;
            if(fast_ptr==null)
                return false;
        }
        while(slow_ptr!=fast_ptr);
        return true;
    }

    public ListNode detectCycle(ListNode head)
    {
        ListNode slow_ptr=head,fast_ptr=head;
        if(head==null || head.next==null)
            return null;
        do
        {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
            if(fast_ptr==null)
                return null;
            fast_ptr = fast_ptr.next;
            if(fast_ptr==null)
                return null;
        }while(slow_ptr!=fast_ptr);

        ListNode start_cycle = head;
        while(slow_ptr!=start_cycle)
        {
            start_cycle = start_cycle.next;
            slow_ptr = slow_ptr.next;
        }
        return  start_cycle;

    }

    public boolean isPalindrome(ListNode head)
    {
        int count = 0;
        ListNode original_head = head,palindrome_head=head;
        while(original_head!=null)
        {
            count++;
            original_head = original_head.next;
        }
        original_head = head;
        for(int iterator_i=0;iterator_i<count/2;iterator_i++)
            palindrome_head = palindrome_head.next;
        if(count%2!=0)
            palindrome_head = palindrome_head.next;
        ListNode prev = null;
        while(palindrome_head!=null)
        {
            ListNode temp = palindrome_head.next;
            palindrome_head.next = prev;
            prev = palindrome_head;
            palindrome_head = temp;
        }
        palindrome_head = prev;
        while(palindrome_head!=null)
        {
            if(original_head.val!=palindrome_head.val)
                return false;
            original_head = original_head.next;
            palindrome_head = palindrome_head.next;
        }
        return true;
    }


    public int majorityElement(int[] nums)
    {
        int curr = nums[0],count =1;
        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            if(curr==nums[iterator_i])
                count++;
            else
                count--;
            if(count<0) {
                count = 0;
                curr = nums[iterator_i];
            }
        }
        return curr;
    }

    public int findKthLargest(int[] nums, int k)
    {
        Queue<Integer> pq = new PriorityQueue();
        for(int iterator_i=0;iterator_i<k;iterator_i++)
            pq.add(nums[iterator_i]);
        for(int iterator_i=k;iterator_i<nums.length;iterator_i++)
        {
            if(pq.peek()<nums[iterator_i])
            {
                pq.poll();
                pq.add(nums[iterator_i]);
            }
        }
        return pq.poll();
    }

    public int findKthLargest1(int[] nums, int k)
    {
        int heap[] = new int[k];
        for(int iterator_i=0;iterator_i<k;iterator_i++)
            heap[iterator_i] = nums[iterator_i];

        for(int iterator=k/2-1;iterator>=0;iterator--)
            heapify(heap,iterator);

        for(int iterator_i=k;iterator_i<nums.length;iterator_i++)
        {
            if(heap[0]<nums[iterator_i])
            {
                heap[0] = nums[iterator_i];
                top_bottom_heapify(heap,0);
            }
        }
        return heap[0];
    }

    public void top_bottom_heapify(int[] nums,int pos)
    {
        int min_pos=pos;
        if((pos+1)*2-1 >= nums.length)
            return;
        //System.out.println(nums[(pos+1)*2-1]+","+nums[pos]);
        if(nums[(pos+1)*2-1]<nums[pos])
            min_pos = (pos+1)*2-1;
        if((pos+1)*2<nums.length && nums[min_pos]>nums[(pos+1)*2])
            min_pos = (pos+1)*2;

        if(min_pos!=pos)
        {
            int temp = nums[pos];
            nums[pos] = nums[min_pos];
            nums[min_pos] = temp;
            if((min_pos+1)*2-1 <nums.length)
                top_bottom_heapify(nums,min_pos);
        }
    }

    public void heapify(int[] arr, int pos)
    {
        int min_pos=pos;
        if(arr[(pos+1)*2-1] < arr[pos])
            min_pos = (pos+1)*2-1;
        if((pos+1)*2<arr.length && arr[(pos+1)*2]<arr[min_pos])
            min_pos = (pos+1)*2;
        if(min_pos!=pos)
        {
            int temp = arr[min_pos];
            arr[min_pos] = arr[pos];
            arr[pos] = temp;
            if(2*(min_pos+1)-1<arr.length)
                heapify(arr,min_pos);
        }
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null)
            return null;
        TreeNode result = new TreeNode((root1==null?0:root1.val)+(root2==null?0:root2.val));
        result.left = mergeTrees(root1==null?null:root1.left,root2==null?null:root2.left);
        result.right = mergeTrees(root1==null?null:root1.right,root2==null?null:root2.right);
        return result;
    }

    int offsets[][] = {{1,1},{1,0},{0,1},{-1,-1},{-1,0},{0,-1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board)
    {
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
            {
                System.out.println(iterator_i+","+iterator_j);
                int count_live = computeLiveNeighbors(board,iterator_i,iterator_j);
                if(board[iterator_i][iterator_j]==1 && (count_live<2 || count_live>3))
                    board[iterator_i][iterator_j] = -1;
                else if(board[iterator_i][iterator_j]==0 && count_live==3)
                    board[iterator_i][iterator_j] = 2;
            }
        }

        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for (int iterator_j = 0; iterator_j < board[0].length; iterator_j++)
            {
                if (board[iterator_i][iterator_j] == -1)
                    board[iterator_i][iterator_j] = 0;
                if (board[iterator_i][iterator_j] == 2)
                    board[iterator_i][iterator_j] = 1;
            }
        }
    }

    public int computeLiveNeighbors(int[][] board,int pos_x,int pos_y)
    {
        int count =0;
        for(int[] offset: offsets)
        {
            if(pos_x+offset[0]<0 || pos_y+offset[1]<0 || pos_x+offset[0]==board.length || pos_y+offset[1]==board[0].length )
                continue;
            if(board[pos_x+offset[0]][pos_y+offset[1]]==1 || board[pos_x+offset[0]][pos_y+offset[1]]==-1)
                count++;
        }
        return count;
    }

    int diameter =0;
    public int diameterOfBinaryTree(TreeNode root)
    {
        diaTree(root);
        return diameter;
    }

    public int diaTree(TreeNode root)
    {
        if(root==null)
            return 0;
        int lrcur = diaTree(root.left),rrcur = diaTree(root.right);
        diameter = Math.max(diameter,lrcur+rrcur);
        return Math.max(lrcur+1,rrcur+1);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode ptr_1=headA, ptr_2 = headB;
        boolean haslooped = false;
        while(ptr_1!=ptr_2)
        {
            if(ptr_1.next==null)
            {
                if(haslooped)
                    return null;
                ptr_1 = headB;
                haslooped = true;
            }
            else
                ptr_1 = ptr_1.next;

            if(ptr_2.next == null)
                ptr_2 = headA;
            else
                ptr_2 = ptr_2.next;
        }
        return ptr_1;
    }

    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null,temp;
        while(head!=null)
        {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    ListNode final_head = null;

    public ListNode reverseList1(ListNode head)
    {
        reverseListHelper(head);
        return final_head;
    }

    public ListNode reverseListHelper(ListNode head)
    {
        if(head==null)
            return null;
        ListNode newhead = reverseListHelper(head.next);
        head.next = null;
        if(newhead==null)
        {
            final_head = head;
            return head;
        }
        newhead.next = head;
        return newhead.next;
    }


    public int rob(int[] nums)
    {
        if(nums.length<2)
            return nums[0];
        int max_adjacent=0, max_nonadjacent=nums[0];
        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            int temp = Math.max(max_nonadjacent+nums[iterator_i],max_adjacent);
            max_nonadjacent = Math.max(max_adjacent,max_nonadjacent);
            max_adjacent = temp;
        }
        return max_adjacent;
    }

    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        List<Integer> result = new ArrayList();
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(nums[Math.abs(nums[iterator_i])-1]>0)
                nums[Math.abs(nums[iterator_i])-1] = 0- nums[Math.abs(nums[iterator_i])-1];
        }
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(nums[iterator_i]>0)
                result.add(iterator_i+1);
        }
        return result;
    }

    public int findTargetSumWays(int[] nums, int S)
    {
        return findTargetSumWaysHelper(nums,S,0,0);
    }

    public int findTargetSumWaysHelper(int[] nums,int S, int pos,int curr_sum)
    {
        if(pos == nums.length)
        {
            if(curr_sum == S)
                return 1;
            return 0;
        }
        return findTargetSumWaysHelper(nums,S,pos+1,curr_sum+nums[pos]) + findTargetSumWaysHelper(nums,S,pos+1,curr_sum-nums[pos]);
    }

    public int findTargetSumWays1(int[] nums,int S)
    {
        int max_sum = 0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            max_sum += nums[iterator_i];
        if(S>max_sum)
            return 0;
        int dp_prev[] = new int[2*max_sum+1];
        Arrays.fill(dp_prev,-1);
        dp_prev[max_sum+nums[0]] = 1;
        dp_prev[max_sum-nums[0]] = dp_prev[max_sum-nums[0]]==-1?1:2;

        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            int dp_next[] = new int[2*max_sum+1];
            Arrays.fill(dp_next,-1);
            for(int iterator_j=0;iterator_j<=2*max_sum;iterator_j++)
            {
                if(dp_prev[iterator_j]!=-1)
                {
                    dp_next[iterator_j+nums[iterator_i]] = (dp_next[iterator_j+nums[iterator_i]]==-1)?dp_prev[iterator_j]:dp_prev[iterator_j]+dp_next[iterator_j+nums[iterator_i]];
                    dp_next[iterator_j-nums[iterator_i]] = (dp_next[iterator_j-nums[iterator_i]]==-1)?dp_prev[iterator_j]:dp_prev[iterator_j]+dp_next[iterator_j-nums[iterator_i]];
                }
            }
            dp_prev = dp_next;
        }
        return dp_prev[max_sum+S]<0?0:dp_prev[max_sum+S];
    }

    public int maxDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    TreeNode prev_flattened = null;
    public void flatten(TreeNode root)
    {
        if(root==null)
            return;
        if(prev_flattened!=null)
            prev_flattened.right = root;

        prev_flattened = root;
        TreeNode left = root.left,right = root.right;
        root.right = null;
        root.left = null;
        flatten(left);
        flatten(right);

    }

    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList();
        subsetsHelper(nums,0,result,new ArrayList());
        return result;
    }

    public void subsetsHelper(int[] nums,int pos, List result, List curr_list)
    {
        if(pos == nums.length)
        {
            result.add(new ArrayList(curr_list));
            return;
        }
        subsetsHelper(nums,pos+1,result,curr_list);
        curr_list.add(nums[pos]);
        subsetsHelper(nums,pos+1,result,curr_list);
        curr_list.remove(curr_list.size()-1);
    }

    public boolean isSymmetric(TreeNode root)
    {
        if(root==null)
            return true;
        return isSymmetricHelper(root.left,root.right);
    }

    public boolean isSymmetricHelper(TreeNode left,TreeNode right )
    {
        if(left == null && right == null)
            return true;
        if(left!=null && right!=null && left.val==right.val && isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left))
            return true;
        return false;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        boolean inclusion_array[] = new boolean[nums.length];
        subsetsWithDupHelper(nums,inclusion_array,0,result);
        return result;
    }

    public void subsetsWithDupHelper(int[] nums,boolean[] inclusion_array,int pos,List result)
    {
        if(pos==nums.length)
        {
            List curr_lst = new ArrayList();
            for(int iterator_i=0; iterator_i<nums.length;iterator_i++)
            {
                if(inclusion_array[iterator_i])
                    curr_lst.add(nums[iterator_i]);
            }
            result.add(curr_lst);
            return;
        }
        subsetsWithDupHelper(nums,inclusion_array,pos+1,result);
        if(pos==0 || (pos>0 && (nums[pos]!=nums[pos-1] || (nums[pos]==nums[pos-1] && inclusion_array[pos-1]))))
        {
            inclusion_array[pos] = true;
            subsetsWithDupHelper(nums,inclusion_array,pos+1,result);
            inclusion_array[pos] = false;
        }
    }

    public boolean canJump(int[] nums)
    {
        int max_pos_reached = 0,current_pos=0;
        while(current_pos<=max_pos_reached && current_pos<nums.length)
        {
            max_pos_reached = Math.max(current_pos+nums[current_pos],max_pos_reached);
            current_pos++;

            if(max_pos_reached >= nums.length-1)
                return true;
        }
        return false;
    }

    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList();
        HashMap<String,Integer> hmap= new HashMap();
        for(int iterator_i=0;iterator_i<strs.length;iterator_i++)
        {
            char curr_c[] = strs[iterator_i].toCharArray();
            Arrays.sort(curr_c);
            String curr_str = String.valueOf(curr_c);
            int index_to_insert = (hmap.getOrDefault(curr_str,result.size()));
            if(index_to_insert==result.size())
            {
                List<String> new_list = new ArrayList();
                new_list.add(strs[iterator_i]);
                result.add(new_list);
                hmap.put(curr_str,index_to_insert);
            }
            else
            {
                List<String> prev_list = result.get(index_to_insert);
                prev_list.add(strs[iterator_i]);
            }
        }
        return result;
    }

    public int uniquePaths(int m, int n)
    {
        int dp_prev[] = new int[n];
        Arrays.fill(dp_prev,1);
        for(int iterator_i=1;iterator_i<m;iterator_i++)
        {
            int dp_curr[] = new int[n];
            for(int iterator_j=0;iterator_j<n;iterator_j++)
                dp_curr[iterator_j] = (iterator_j>0?dp_curr[iterator_j-1]:0) + dp_prev[iterator_j];
            dp_prev = dp_curr;
        }
        return dp_prev[n-1];
    }

    public int minPathSum(int[][] grid)
    {
        int dp_prev[] = new int[grid[0].length];
        dp_prev[0] = grid[0][0];
        for(int iterator_i=1;iterator_i<grid[0].length;iterator_i++)
            dp_prev[iterator_i] = dp_prev[iterator_i-1] + grid[0][iterator_i];

        for(int iterator_i=1;iterator_i<grid.length;iterator_i++)
        {
            int dp_curr[] = new int[grid[0].length];
            for(int iterator_j=0;iterator_j<grid[0].length;iterator_j++)
                dp_curr[iterator_j] = Math.min(dp_prev[iterator_j]+grid[iterator_i][iterator_j],(iterator_j>0?(dp_curr[iterator_j-1]+grid[iterator_i][iterator_j]):Integer.MAX_VALUE) );
            dp_prev = dp_curr;
        }
        return dp_prev[grid[0].length-1];
    }

    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList();
        levelOrderHelper(root,result,0);
        return result;
    }

    public void levelOrderHelper(TreeNode root, List<List<Integer>> result,int height)
    {
        if(root==null)
            return;
        if(result.size()-1<height)
        {
            List<Integer> new_list = new ArrayList();
            new_list.add(root.val);
            result.add(new_list);
        }
        else
        {
            List<Integer> curr_list = result.get(height);
            curr_list.add(root.val);
        }
        levelOrderHelper(root.left,result,height+1);
        levelOrderHelper(root.right,result,height+1);
    }


    TreeNode prev_max_bst = null;
    public boolean isValidBST(TreeNode root)
    {
        if(root==null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(prev_max_bst!=null && prev_max_bst.val>=root.val)
            return false;
        prev_max_bst = root;
        if(!isValidBST(root.right))
            return false;
        return true;
    }

    public boolean exist(char[][] board, String word)
    {
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
            {
                if (existHelper(board, word, iterator_i, iterator_j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean existHelper(char[][] board,String word, int pos_x, int pos_y, int comparison_index)
    {
        if(pos_x<0 || pos_x>=board.length || pos_y<0 || pos_y>=board[0].length ||board[pos_x][pos_y] != word.charAt(comparison_index))
            return false;
        if(comparison_index == word.length()-1)
            return true;

        board[pos_x][pos_y] ^= 256;
        if(existHelper(board,word,pos_x+1,pos_y,comparison_index+1) ||
                existHelper(board,word,pos_x-1,pos_y,comparison_index+1) ||
                existHelper(board,word,pos_x,pos_y+1,comparison_index+1) ||
                existHelper(board,word,pos_x,pos_y-1,comparison_index+1) )
            return true;
        board[pos_x][pos_y] ^= 256;
        return false;
    }

    public int countPrimes(int n)
    {
        if(n<2)
            return 0;
        int count_primes = 0;
        boolean prime_sieve[]  = new boolean[n];
        for(int iterator_i=2;iterator_i<=(int)Math.sqrt(n);iterator_i++)
        {
            if(!prime_sieve[iterator_i])
            {
                count_primes++;

                for(int iterator_j=iterator_i*iterator_i;iterator_j<n && iterator_j>0;iterator_j+=iterator_i)
                    prime_sieve[iterator_j] = true;
            }
        }
        for(int iterator_i=(int)Math.sqrt(n)+1;iterator_i<n;iterator_i++)
        {
            if(!prime_sieve[iterator_i])
                count_primes++;
        }

        return count_primes;
    }

    public int numIslands(char[][] grid)
    {
        int number_islands = 0;
        for (int iterator_i = 0; iterator_i < grid.length; iterator_i++)
        {
            for (int iterator_j = 0; iterator_j < grid[0].length; iterator_j++)
            {
                if(grid[iterator_i][iterator_j]=='1')
                {
                    numIslandsHelper(grid, iterator_i, iterator_j);
                    number_islands++;
                }

            }
        }
        return number_islands;
    }

    public void numIslandsHelper(char[][] grid,int pos_x,int pos_y)
    {
        if(pos_x==grid.length || pos_y==grid[0].length || pos_x<0 || pos_y<0 || grid[pos_x][pos_y] == '0')
            return;
        grid[pos_x][pos_y] = '0';
        numIslandsHelper(grid,pos_x+1,pos_y);
        numIslandsHelper(grid,pos_x-1,pos_y);
        numIslandsHelper(grid,pos_x,pos_y+1);
        numIslandsHelper(grid,pos_x,pos_y-1);

    }

    public int findPeakElement(int[] nums)
    {
        int lb=0,ub=nums.length-1;
        while(lb<=ub)
        {
            int mid = (lb+ub)/2;
            if(((mid>0 &&nums[mid]>nums[mid-1]) || mid==0) && ((mid<nums.length-1 && nums[mid]>nums[mid+1]) || mid==nums.length-1) )
                return mid;
            if(mid==0 || nums[mid-1]<nums[mid] )
                lb = mid+1;
            else
                ub = mid-1;
        }
        return -1;
    }

    public int kthSmallest(int[][] matrix, int k)
    {
        int lb = matrix[0][0],ub = matrix[matrix.length-1][matrix.length-1];
        while(lb<ub)
        {
            int mid = lb+ (ub-lb)/2;
            int curr_k = kthSmallestHelper(matrix,mid);
            if(curr_k == k )
                return mid-ub_decrement;
            else if(curr_k <k)
                lb = mid+lb_increment;
            else
                ub = mid-ub_decrement;
        }
        return -1;
    }

    int ub_decrement,lb_increment;
    public int kthSmallestHelper(int[][] matrix,int find_val)
    {
        lb_increment = Integer.MAX_VALUE;
        ub_decrement = Integer.MAX_VALUE;
        int curr_k=0;
        for(int iterator_i=0;iterator_i<matrix.length;iterator_i++)
        {
            int iterator_j=0;
            while(iterator_j<matrix.length && matrix[iterator_i][iterator_j]<=find_val)
            {
                ub_decrement = Math.min(ub_decrement,find_val-matrix[iterator_i][iterator_j]);
                curr_k++;
                iterator_j++;
            }
            if(iterator_j<matrix.length)
                lb_increment = Math.min(lb_increment,matrix[iterator_i][iterator_j]-find_val);
        }
        return curr_k;
    }


    public ListNode oddEvenList(ListNode head)
    {
        if(head==null)
            return null;
        int count_nodes = 1;
        ListNode odd_head=head,even_head=head;
        while(even_head.next!=null)
        {
            count_nodes++;
            even_head = even_head.next;
        }
        if(count_nodes%2==0)
        {
            ListNode newnode = new ListNode(0);
            even_head.next = newnode;
            even_head = even_head.next;
        }
        int counter = count_nodes/2;
        while(counter>0)
        {
            counter--;
            even_head.next = odd_head.next;

            if(count_nodes%2==0 && counter==0)
                odd_head.next = odd_head.next.next.next;
            else
                odd_head.next = odd_head.next.next;
            odd_head = odd_head.next;
            even_head = even_head.next;
        }
        even_head.next=null;
        return head;
    }

    public int findDuplicate(int[] nums)
    {
        int slow_ptr = nums[0],fast_ptr = nums[0];
        do
        {
            slow_ptr = nums[slow_ptr];
            fast_ptr = nums[fast_ptr];
            fast_ptr = nums[fast_ptr];

        }while(slow_ptr!=fast_ptr);

        slow_ptr = nums[0];
        while(slow_ptr!=fast_ptr)
        {
            slow_ptr = nums[slow_ptr];
            fast_ptr = nums[fast_ptr];
        }
        return slow_ptr;
    }

    public int[] productExceptSelf(int[] nums)
    {
        int right_product[] = new int[nums.length],produxt_till_before=1;
        for(int iterator_i=nums.length-1;iterator_i>=0;iterator_i--)
        {
            right_product[iterator_i] = produxt_till_before;
            produxt_till_before *= nums[iterator_i];
        }
        produxt_till_before = 1;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            right_product[iterator_i] *= produxt_till_before;
            produxt_till_before *= nums[iterator_i];
        }
        return right_product;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }

    public boolean searchMatrix(int[][] matrix, int target)
    {
        int row_index=0,col_index=matrix[0].length-1;
        while(col_index>=0 && row_index<matrix.length)
        {
            if(matrix[row_index][col_index]>target)
                col_index--;
            else if(matrix[row_index][col_index]<target)
                row_index++;
            else
                return true;
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        boolean visited[] = new boolean[numCourses];
        int in_vertices[] = new int[numCourses];
        List<Integer>[] prereq_list = new ArrayList[numCourses];

        for(int iterator_i=0;iterator_i<numCourses;iterator_i++)
            prereq_list[iterator_i] = new ArrayList();

        for(int iterator_i=0;iterator_i<prerequisites.length;iterator_i++)
        {
            prereq_list[prerequisites[iterator_i][1]].add(prerequisites[iterator_i][0]);
            in_vertices[prerequisites[iterator_i][0]]++;
        }

        for(int iterator_i=0;iterator_i<numCourses;iterator_i++)
            canFinishHelper(numCourses,prereq_list,visited,iterator_i,in_vertices);

        for(int iterator_i=0;iterator_i<numCourses;iterator_i++)
        {
            if(!visited[iterator_i])
                return false;
        }
        return true;
    }

    public void canFinishHelper(int numCourses, List<Integer>[] prereq_list, boolean[] visited,int cur_course,int[] in_vertices)
    {
        if(visited[cur_course] || in_vertices[cur_course]!=0)
            return;

        for(int edges:prereq_list[cur_course])
            in_vertices[edges]--;

        visited[cur_course] = true;
        for(int iterator_i=0;iterator_i<numCourses;iterator_i++)
        {
            if(!visited[iterator_i] && in_vertices[iterator_i]==0)
                canFinishHelper(numCourses,prereq_list,visited,iterator_i,in_vertices);
        }
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) // Cycle Detection Adjacency list
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int visited[] = new int[numCourses];
        boolean checked_for_cycles[] = new boolean[numCourses];
        for(int iterator_i=0;iterator_i<numCourses;iterator_i++)
            list.add(new ArrayList<>());
        for(int iterator_i=0;iterator_i<prerequisites.length;iterator_i++)
            list.get(prerequisites[iterator_i][1]).add(prerequisites[iterator_i][0]);

        for(int iterator_i=0;iterator_i<numCourses;iterator_i++)
        {
            if(detectCyclefromvertex_list(list,visited,iterator_i,checked_for_cycles))
                return false;
        }
        return true;
    }

    public static boolean detectCyclefromvertex_list(List<List<Integer>> adj_list, int visited[],int current_vertex, boolean checked_for_cycles[])
    {
        if(!checked_for_cycles[current_vertex])
        {
            if (visited[current_vertex] == 1)
                return true;
            visited[current_vertex] = 1;
            for(int courseId: adj_list.get(current_vertex))
            {
                if (detectCyclefromvertex_list(adj_list, visited, courseId, checked_for_cycles))
                    return true;
            }
            checked_for_cycles[current_vertex] = true;
        }
        return false;
    }

    public void solve(char[][] board)
    {
        for(int iterator_i=0;iterator_i<board[0].length;iterator_i++)
        {
            solveHelper(board, 0, iterator_i);
            solveHelper(board,board.length-1,iterator_i);
        }
        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            solveHelper(board, iterator_i,0);
            solveHelper(board,iterator_i,board[0].length-1);
        }


        for(int iterator_i=0;iterator_i<board.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<board[0].length;iterator_j++)
            {
                if(board[iterator_i][iterator_j]=='Y')
                    board[iterator_i][iterator_j] = 'O';
                else
                    board[iterator_i][iterator_j] = 'X';
            }
        }
    }

    public void solveHelper(char[][] board, int cur_row,int cur_col)
    {
        if(cur_row<0 || cur_row==board.length || cur_col<0 || cur_col==board[0].length || board[cur_row][cur_col]=='X'|| board[cur_row][cur_col]=='Y')
            return;
        board[cur_row][cur_col] = 'Y';
        solveHelper(board,cur_row-1,cur_col);
        solveHelper(board,cur_row+1,cur_col);
        solveHelper(board,cur_row,cur_col+1);
        solveHelper(board,cur_row,cur_col-1);
    }

    public int hammingWeight(int n)
    {
        int count_ones = 0;
        while(n!=0)
        {
            count_ones++;
            n = n & (n-1);
        }
        return count_ones;
    }

    public int titleToNumber(String columnTitle)
    {
        int value = 0;
        for(int iterator_i=0;iterator_i<columnTitle.length();iterator_i++)
        {
            char curr = columnTitle.charAt(iterator_i);
            value += Math.pow(26,columnTitle.length()-iterator_i-1)*(curr-'A'+1);
        }
        return value;
    }

    public int maxProduct(int[] nums)
    {
        int max_till_now = nums[0],cur_positive=nums[0],cur_negative=nums[0];

        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
        {
            if(nums[iterator_i]<0)
            {
                int swap = cur_negative;
                cur_negative = cur_positive;
                cur_positive = swap;
            }
            cur_positive = Math.max(cur_positive*nums[iterator_i],nums[iterator_i]);
            cur_negative = Math.min(cur_negative*nums[iterator_i],nums[iterator_i]);

            max_till_now = Math.max(max_till_now,cur_positive);
        }
        return max_till_now;
    }

    public TreeNode sortedArrayToBST(int[] nums)
    {
        return sortedArrayToBSTHelper(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int lo, int hi)
    {
        if(lo>hi)
            return null;
        int mid = (lo+hi)/2;
        TreeNode current_node = new TreeNode(nums[mid]);
        if(lo==hi)
            return current_node;
        current_node.left = sortedArrayToBSTHelper(nums,lo,mid-1);
        current_node.right = sortedArrayToBSTHelper(nums,mid+1,hi);
        return current_node;
    }

    public ListNode middleNode(ListNode head)
    {
        ListNode slow_ptr = head, fast_ptr = head;
        while(fast_ptr!=null && fast_ptr.next!=null)
        {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
            fast_ptr = fast_ptr.next;
        }
        return slow_ptr;
    }


    public void moveZeroes(int[] nums)
    {
        int nonzero_index=0;
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            if(nums[iterator_i] !=0 )
                nums[nonzero_index++] = nums[iterator_i];
        }
        while(nonzero_index<nums.length)
            nums[nonzero_index++] = 0;
    }

    public int findMaxLength(int[] nums)
    {
        int ones_counter=0,max_length=0;
        HashMap<Integer,Integer> hmap = new HashMap();
        hmap.put(0,-1);

        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
        {
            ones_counter += nums[iterator_i]==1?1:-1;
            if(hmap.containsKey(ones_counter))
                max_length = Math.max(max_length,iterator_i-hmap.get(ones_counter));
            else
                hmap.put(ones_counter,iterator_i);
        }
        return max_length;
    }

    public List<List<String>> solveNQueens(int n)
    {
        boolean column_index[] = new boolean[n], diag1_index[] = new boolean[2*n-1],diag2_index[] = new boolean[2*n-1];
        List<List<String>> return_list = new ArrayList();
        solveNQueensHelper(0,column_index,diag1_index,diag2_index,return_list,new int[n]);
        return return_list;
    }

    public void solveNQueensHelper(int row,boolean[] column_index,boolean[] diag1_index,boolean[] diag2_index,List return_list,int positions[])
    {
        if(row==column_index.length)
        {
            List<String> new_result = new ArrayList();
            for(int iterator_i=0;iterator_i<positions.length;iterator_i++)
            {
                char row_str[] = new char[positions.length];
                Arrays.fill(row_str,'.');
                row_str[positions[iterator_i]] = 'Q';
                StringBuffer sb = new StringBuffer();
                for(char c: row_str)
                    sb.append(c);
                new_result.add(sb.toString());
            }
            return_list.add(new_result);
        }

        for(int iterator_i=0;iterator_i<positions.length;iterator_i++)
        {
            if(!column_index[iterator_i] && !diag1_index[iterator_i-row+ positions.length-1] && !diag2_index[iterator_i+row])
            {
                column_index[iterator_i] = true;
                diag1_index[iterator_i-row+positions.length-1] = true;
                diag2_index[iterator_i+row] = true;
                positions[row] = iterator_i;
                solveNQueensHelper(row+1,column_index,diag1_index,diag2_index,return_list,positions);
                column_index[iterator_i] = false;
                diag1_index[iterator_i-row+positions.length-1] = false;
                diag2_index[iterator_i+row] = false;
            }
        }
    }

    public boolean backspaceCompare(String S, String T)
    {
        int backspace_S = 0, backspace_T=0,iterator_i=S.length()-1, iterator_j=T.length()-1;
        while(iterator_i>=0 || iterator_j>=0)
        {
            while(iterator_i>=0)
            {
                if(S.charAt(iterator_i)=='#')
                    backspace_S++;
                else if(backspace_S>0)
                    backspace_S--;
                else
                    break;
                iterator_i--;
            }
            while(iterator_j>=0)
            {
                if(T.charAt(iterator_j)=='#')
                    backspace_T++;
                else if(backspace_T>0)
                    backspace_T--;
                else
                    break;
                iterator_j--;
            }
            if((iterator_i>=0) != (iterator_j>=0))
                return false;
            if(iterator_i>=0 && S.charAt(iterator_i) != T.charAt(iterator_j))
                return false;
            iterator_i--; iterator_j--;
        }
        return true;
    }

    public int lastStoneWeight(int[] stones)
    {
        int weights[] = new int[1001],index=1000;
        for(int stone:stones)
            weights[stone]++;

        while(index>=0)
        {
            if(weights[index]==0)
                index--;
            else
            {
                int curr_bucket = weights[index--],last_index=index+1;
                if(curr_bucket%2!=0)
                {
                    weights[last_index] = 0;
                    while(index>0 && weights[index]==0)
                        index--;
                    if(index==0)
                        return last_index;
                    weights[index]--;
                    weights[last_index-index]++;
                    index = Math.max(last_index-index,index);
                }
            }
        }
        return 0;
    }

    public TreeNode convertBST(TreeNode root)
    {
        convertBSTHelper(root,0);
        return root;
    }

    public int convertBSTHelper(TreeNode root,int greaterValue)
    {
        if(root==null)
            return greaterValue;

        int newValue = convertBSTHelper(root.right,greaterValue);
        root.val += newValue;
        newValue = convertBSTHelper(root.left,root.val);
        return newValue;

    }

    public int minDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        if((root.left==null) == (root.right==null))
            return 1+Math.min(minDepth(root.left),minDepth(root.right));
        else
            return 1+Math.min(root.left==null?Integer.MAX_VALUE:minDepth(root.left),root.right==null?Integer.MAX_VALUE:minDepth(root.right));
    }

    public void reorderList(ListNode head)
    {
        int count = 0;
        ListNode headNode=head,tailNode=head;
        while(headNode!=null)
        {
            headNode = headNode.next;
            count++;
        }
        count = (count-1)/2;
        while(count>0)
        {
            count--;
            tailNode = tailNode.next;
        }
        headNode = tailNode;
        ListNode prev = null;
        tailNode = tailNode.next;
        headNode.next = null;
        headNode = head;
        while(tailNode!=null)
        {
            ListNode next = tailNode.next;
            tailNode.next = prev;
            prev = tailNode;
            tailNode = next;
        }
        tailNode = prev;
        while(tailNode!=null)
        {
            ListNode temp = tailNode.next;
            tailNode.next = headNode.next;
            headNode.next = tailNode;
            headNode = tailNode.next;
            tailNode = temp;
        }
    }

    int preorder_index = 0;
    public TreeNode bstFromPreorder(int[] preorder)
    {
        return bstFromPreorderHelper(preorder,Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorderHelper(int[] preorder,int bound)
    {
        if(preorder_index==preorder.length || preorder[preorder_index]>bound)
            return null;
        TreeNode current_root = new TreeNode(preorder[preorder_index++]);
        current_root.left = bstFromPreorderHelper(preorder,current_root.val);
        current_root.right = bstFromPreorderHelper(preorder,bound);
        return current_root;
    }

    public boolean isSubsequence(String s, String t)
    {
        int iterator_j=0;
        for(int iterator_i=0;iterator_i<t.length()&& iterator_j<s.length();iterator_i++)
        {
            if(t.charAt(iterator_i)==s.charAt(iterator_j))
                iterator_j++;
        }
        return iterator_j==s.length()?true:false;
    }

    public boolean detectCapitalUse(String word)
    {
        boolean isCap = Character.isUpperCase(word.charAt(0));
        int index = 1;
        if(isCap && word.length()>1 && !Character.isUpperCase(word.charAt(1)))
            isCap = false;
        while(index<word.length())
        {
            if(isCap != Character.isUpperCase(word.charAt(index)))
                return false;
            index++;
        }
        return true;
    }

    public ListNode sortList1(ListNode head)
    {
        ListNode dummyHead = new ListNode(0), minNode = new ListNode(Integer.MAX_VALUE), headNode, prev, sortHead = dummyHead;
        dummyHead.next = head;
        while (sortHead.next != null) {
            headNode = sortHead;
            prev = sortHead;
            minNode = sortHead.next;
            while (headNode.next != null) {
                if (minNode.val > headNode.next.val) {
                    minNode = headNode.next;
                    prev = headNode;
                }
                headNode = headNode.next;
            }
            prev.next = minNode.next;
            minNode.next = sortHead.next;
            sortHead.next = minNode;
            sortHead = sortHead.next;
        }
        return dummyHead.next;
    }

    public ListNode sortList(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode midNode = split_mid_list(head);
        head = sortList(head);
        midNode = sortList(midNode);
        return mergeList(head,midNode);
    }

    public ListNode mergeList(ListNode list1, ListNode list2)
    {
        ListNode prev_node = new ListNode(0),head_copy = prev_node;
        prev_node.next = list1;
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
                list1 = list1.next;
            else
            {
                ListNode temp = list2.next;
                list2.next = list1;
                prev_node.next = list2;
                list2 = temp;
            }
            prev_node = prev_node.next;
        }
        prev_node.next = list2==null?list1:list2;
        return head_copy.next;
    }


    public ListNode split_mid_list(ListNode head)
    {
        ListNode slow_ptr=head,fast_ptr=head;
        while(fast_ptr!=null && fast_ptr.next!=null)
        {
            fast_ptr = fast_ptr.next.next;
            if(fast_ptr==null)
                break;
            slow_ptr = slow_ptr.next;
        }
        ListNode returnNode = slow_ptr.next;
        slow_ptr.next = null;
        return returnNode;
    }

    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> return_list = new ArrayList();
        List<Integer> current_rowlist = new ArrayList();
        current_rowlist.add(1);
        return_list.add(current_rowlist);
        for(int iterator_i=1;iterator_i<numRows;iterator_i++)
        {
            current_rowlist = new ArrayList();
            current_rowlist.add(1);
            for(int iterator_j=1;iterator_j<iterator_i;iterator_j++)
                current_rowlist.add(return_list.get(iterator_i-1).get(iterator_j) + return_list.get(iterator_i-1).get(iterator_j-1));
            current_rowlist.add(1);
            return_list.add(current_rowlist);
        }
        return return_list;
    }


    public int rob2(int[] nums)
    {
        return Math.max(nums[nums.length-1]+robHelper(nums,1,nums.length-3),robHelper(nums,0,nums.length-2));
    }

    public int robHelper(int [] nums,int lb, int ub)
    {
        if(lb>=nums.length || ub<lb)
            return 0;
        if(ub-lb<1)
            return nums[lb];
        int max_adjacent = nums[lb], max_nonadjacent = 0;
        for(int iterator_i=lb+1;iterator_i<=ub;iterator_i++)
        {
            int temp = Math.max(max_nonadjacent+nums[iterator_i],max_adjacent);
            max_nonadjacent = Math.max(max_adjacent,max_nonadjacent);
            max_adjacent = temp;
        }
        return max_adjacent;
    }


    public int[][] flipAndInvertImage(int[][] image)
    {
        for(int iterator_i=0;iterator_i<image.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<image[0].length/2;iterator_j++)
            {
                int temp = image[iterator_i][iterator_j];
                image[iterator_i][iterator_j] = image[iterator_i][image[0].length-1-iterator_j]==1?0:1;
                image[iterator_i][image[0].length-1-iterator_j] = temp==0?1:0;
            }
            if(image[0].length%2!=0)
                image[iterator_i][image[0].length/2] = image[iterator_i][image[0].length/2]==0?1:0;
        }
        return image;
    }

    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> result_list = new ArrayList();
        int curr_val = 1;
        boolean bool9=false;
        while(true)
        {
            result_list.add(curr_val);
            if((curr_val%10 == 9 && !bool9)|| curr_val==n)
            {
                int temp = curr_val;
                while(temp%10 ==9 || temp==n)
                    temp /= 10;
                if(temp==0)
                    return result_list;
                curr_val = temp+1;
                bool9 = true;
            }
            else
            {
                if(curr_val*10 <=n)
                    curr_val *= 10;
                else if(curr_val%10==9 && bool9)
                {
                    bool9=false;
                    result_list.remove(result_list.size()-1);
                    continue;
                }
                else
                {
                    if((curr_val+1)%10==9)
                        bool9=true;
                    curr_val++;
                }
            }
        }
    }


    public int maximalSquare(char[][] matrix)
    {
        int dp_prev[] = new int[matrix[0].length];
        int max_square = 0;
        for(int iterator_i=0;iterator_i<matrix[0].length;iterator_i++)
        {
            dp_prev[iterator_i] = matrix[0][iterator_i];
            max_square = Math.max(max_square,dp_prev[iterator_i]);
        }

        for(int iterator_i=1;iterator_i<matrix.length;iterator_i++)
        {
            int dp_curr[] = new int[matrix[0].length];
            for (int iterator_j = 0; iterator_j < matrix[0].length; iterator_j++)
            {
                dp_curr[iterator_j] = (matrix[iterator_i][iterator_j]-'0')==1?(1 + Math.min(Math.min(iterator_j > 0 ? dp_prev[iterator_j - 1] : '0', dp_prev[iterator_j]), iterator_j > 0 ? dp_curr[iterator_j - 1] : '0')):'0';
                max_square = Math.max(dp_curr[iterator_j],max_square);
            }
            dp_prev = dp_curr;
        }
        return (max_square-'0')*(max_square-'0');
    }


    public int findMinArrowShots(int[][] points)
    {
        if(points.length<2)
            return points.length;
        Arrays.sort(points, (a,b) -> a[1] == b[1] ? Integer.compare(-a[0], -b[0]): Integer.compare(a[1],b[1]));
        int curr_arrow = points[0][1],points_index=1,num_arrow=1;
        while(points_index<points.length)
        {
            if(points[points_index][0]<=curr_arrow)
                points_index++;
            else
            {
                curr_arrow = points[points_index++][1];
                num_arrow++;
            }
        }
        return num_arrow;
    }

    public boolean find132pattern(int[] nums)
    {
        int min_arr[] = new int[nums.length];
        min_arr[0] = nums[0];
        for(int iterator_i=1;iterator_i<nums.length;iterator_i++)
            min_arr[iterator_i] = Math.min(min_arr[iterator_i-1],nums[iterator_i]);

        int top= nums.length;
        for(int iterator_i=nums.length-1;iterator_i>=0;iterator_i--)
        {
            if(min_arr[iterator_i]>=nums[iterator_i])
                continue;
            while(top<nums.length && nums[top]<min_arr[iterator_i])
                top++;
            if(top<nums.length && nums[iterator_i]>nums[top])
                return true;
            nums[--top] = nums[iterator_i];
        }
        return false;
    }

    public boolean find132patternStack(int[] nums)
    {
        int min_arr[] = new int[nums.length];
        min_arr[0] = nums[0];
        for(int iterator_i=1;iterator_i<nums.length;iterator_i++ )
            min_arr[iterator_i] = Math.min(min_arr[iterator_i-1],nums[iterator_i]);

        Stack<Integer> stck = new Stack();
        for(int iterator_i=nums.length-1;iterator_i>=0;iterator_i--)
        {
            if(nums[iterator_i]<=min_arr[iterator_i])
                continue;
            while(!stck.isEmpty() && (int)stck.peek()<=min_arr[iterator_i])
                stck.pop();
            if(!stck.isEmpty() && (int)stck.peek()<nums[iterator_i])
                return true;
            stck.push(nums[iterator_i]);
        }
        return false;
    }

    public boolean lemonadeChange(int[] bills)
    {
        int change[] = new int[2];
        for(int iterator_i=0;iterator_i<bills.length;iterator_i++)
        {
            switch(bills[iterator_i])
            {
                case 20:
                    if((change[1]>0) && change[0]>0)
                    {
                        change[0]--;
                        change[1]--;
                    }
                    else if(change[0]>2)
                        change[0] = change[0]-3;
                    else
                        return false;
                    break;
                case 10:
                    if(change[0]>0)
                        change[0]--;
                    else
                        return false;
                    change[1]++;
                    break;
                case 5:
                    change[0]++;
            }
        }
        return true;
    }

    public boolean checkValidString_greedy(String s)
    {
        int minOpenBrackets=0,maxOpenBrackets=0;
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            char ch = s.charAt(iterator_i);
            if(ch=='(')
            {
                minOpenBrackets++;
                maxOpenBrackets++;
            }
            else if(ch==')')
            {
                minOpenBrackets--;
                maxOpenBrackets--;
            }
            else
                minOpenBrackets--;
            if(maxOpenBrackets<0)
                return false;
            minOpenBrackets = Math.max(minOpenBrackets,0);
        }
        return minOpenBrackets==0?true:false;
    }

    public boolean checkValidString(String s)
    {
        boolean dp_arr[][] = new boolean[s.length()][s.length()];
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
            dp_arr[0][iterator_i] = s.charAt(iterator_i)=='*'?true:false;

        for(int iterator_size=1;iterator_size<s.length();iterator_size++)
        {
            for(int iterator_i=iterator_size;iterator_i<s.length();iterator_i++)
            {
                int current_char = s.charAt(iterator_i);
                if(current_char=='*')
                {
                    dp_arr[iterator_size][iterator_i] = dp_arr[iterator_size - 1][iterator_i - 1] ||
                            ((s.charAt(iterator_i - iterator_size) == '(' || s.charAt(iterator_i - iterator_size) == '*') ? (iterator_size > 1 ? dp_arr[iterator_size - 2][iterator_i - 1] : true) : false);

                    for(int iterator_j=1;iterator_j<iterator_size && !dp_arr[iterator_size][iterator_i];iterator_j++)
                    {
                        dp_arr[iterator_size][iterator_i] = dp_arr[iterator_size][iterator_i] || ((s.charAt(iterator_j + iterator_i-iterator_size)=='(' || s.charAt(iterator_j + iterator_i-iterator_size)=='*')
                                && dp_arr[iterator_j-1][iterator_i-iterator_size+iterator_j-1] && (iterator_size-iterator_j-2>=0?dp_arr[iterator_size-iterator_j-2][iterator_i-1]:true));
                    }
                }

                else if(current_char == ')')
                {
                    dp_arr[iterator_size][iterator_i] = (s.charAt(iterator_i-iterator_size)=='(' || s.charAt(iterator_i-iterator_size)=='*')?((iterator_size>1)?dp_arr[iterator_size-2][iterator_i-1]:true):false;
                    for(int iterator_j=1;iterator_j<iterator_size && !dp_arr[iterator_size][iterator_i];iterator_j++)
                    {
                        dp_arr[iterator_size][iterator_i] = dp_arr[iterator_size][iterator_i] || ((s.charAt(iterator_j + iterator_i-iterator_size)=='(' || s.charAt(iterator_j + iterator_i-iterator_size)=='*')
                                && dp_arr[iterator_j-1][iterator_i-iterator_size+iterator_j-1] && (iterator_size-iterator_j-2>=0?dp_arr[iterator_size-iterator_j-2][iterator_i-1]:true));
                    }
                }
            }
        }
        return dp_arr[s.length()-1][s.length()-1];
    }


    int directions[][] = {{1,0},{0,1},{1,1},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}};
    public char[][] updateBoard(char[][] board, int[] click)
    {
        updateBoardHelper(board,click[0],click[1]);
        return board;
    }

    public void updateBoardHelper(char[][] board, int row, int col)
    {
        if(row<0 || col<0 || row==board.length || col == board[0].length || (board[row][col] != 'E' && board[row][col] != 'M' && board[row][col] != 'x')  )
            return;
        if(board[row][col] == 'M' || board[row][col] == 'x')
        {
            board[row][col] = 'X';
            return;
        }
        int count_adjacent_mines = 0;
        for (int direction[] : directions)
        {
            if(col + direction[1]>=0 && row+direction[0]>=0 && direction[0] +row<board.length && col + direction[1]<board[0].length &&  board[row + direction[0]][col + direction[1]]=='M')
                count_adjacent_mines++;
        }

        if(count_adjacent_mines==0)
        {
            board[row][col] = 'B';
            for (int direction[] : directions)
                updateBoardHelper(board, row + direction[0], col + direction[1]);
        }
        else
            board[row][col] = (char) ('0' + count_adjacent_mines);
    }


    public boolean isPerfectSquare(int num)
    {
        if(num==1)
            return true;
        int lb=0,ub=num/2;
        while(lb<=ub)
        {
            int mid = lb + (ub-lb)/2;
            if(mid*1.0 == (num*1.0)/mid )
                return true;
            else if(mid*1.0 < (num*1.0)/mid && mid+1 > (num*1.0)*(mid+1))
                return false;
            else if(mid*1.0 < (num*1.0)/mid)
                lb = mid+1;
            else
                ub = mid-1;
        }
        return false;
    }

    public ListNode deleteDuplicates(ListNode head)
    {
        if(head==null)
            return head;
        ListNode next = head.next, original_head=head;
        while(next!=null)
        {
            while (next != null && original_head.val == next.val)
                next = next.next;

            original_head.next = next;
            original_head = next;
            if(next!=null)
                next = next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head)
    {
        if(head==null)
            return null;
        ListNode dummy_head = new ListNode(0),original_head=head,next_node=head.next,prev_node = dummy_head;
        dummy_head.next = head;
        while(original_head!=null)
        {
            boolean isdup = false;
            while(next_node!=null && original_head.val == next_node.val)
            {
                isdup = true;
                next_node = next_node.next;
            }
            if(!isdup)
            {
                prev_node.next = original_head;
                prev_node = original_head;
                original_head = next_node;
            }
            else
            {
                original_head = next_node;
            }
            if (next_node != null)
                next_node = next_node.next;
        }
        return dummy_head.next;
    }

    public ListNode partition(ListNode head, int x)
    {
        ListNode lesser_head = new ListNode(0), return_head = lesser_head, greater_head = new ListNode(0);
        lesser_head.next = greater_head;

        while(head!=null)
        {
            ListNode next = head.next;
            if(head.val<x)
            {
                ListNode temp = lesser_head.next;
                lesser_head.next = head;
                lesser_head.next.next = temp;
                lesser_head = head;
            }
            else
            {
                greater_head.next = head;
                greater_head.next.next = null;
                greater_head = head;
            }
            head = next;
        }
        lesser_head.next = lesser_head.next.next;
        return return_head.next;
    }


    public int maximalRectangle1(char[][] matrix)
    {
        if(matrix.length==0)
            return 0;
        int height[] = new int[matrix[0].length];
        int left[] = new int[matrix[0].length];
        int right[] = new int[matrix[0].length], max_area=0;
        Arrays.fill(right,matrix[0].length);

        for(int iterator_i=0;iterator_i<matrix.length;iterator_i++)
        {
            int curr_left=0,curr_right=matrix[0].length;
            for(int iterator_j=0;iterator_j<matrix[0].length;iterator_j++)
            {
                height[iterator_j] = (matrix[iterator_i][iterator_j] == '1') ? height[iterator_j] + 1 : 0;
                if(matrix[iterator_i][iterator_j]=='1')
                    left[iterator_j] = Math.max(left[iterator_j],curr_left);
                else
                {
                    left[iterator_j] = 0;
                    curr_left = iterator_j+1;
                }

                if(matrix[iterator_i][matrix[0].length-1-iterator_j] == '1')
                    right[matrix[0].length-1-iterator_j] = Math.min(right[matrix[0].length-1-iterator_j],curr_right);
                else
                {
                    right[matrix[0].length-1-iterator_j] = matrix[0].length;
                    curr_right = matrix[0].length-1-iterator_j;
                }
            }

            for(int iterator_j=0;iterator_j<matrix[0].length;iterator_j++)
                max_area = Math.max(max_area,(right[iterator_j]-left[iterator_j])*height[iterator_j]);

        }
        return max_area;
    }

    public int maximalRectangle(char[][] matrix)
    {
        if(matrix.length==0)
            return 0;
        int height[] = new int[matrix[0].length],max_area=0;
        for(int iterator_i=0;iterator_i<matrix.length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<matrix[0].length;iterator_j++)
                height[iterator_j] = (matrix[iterator_i][iterator_j] == '1')?height[iterator_j]+1:0;
            Stack<Integer> histogram = new Stack();
            int iterator_j=0;
            while(!histogram.isEmpty() || iterator_j<matrix[0].length)
            {
                int curr_height = iterator_j==matrix[0].length?-1:height[iterator_j];
                while(!histogram.isEmpty() && curr_height<height[histogram.peek()])
                {
                    int popped_index = histogram.pop();
                    max_area = Math.max(max_area,height[popped_index]*(histogram.isEmpty()?1:iterator_j-histogram.peek()-1));
                }
                if(iterator_j<matrix[0].length)
                {
                    histogram.push(iterator_j);
                    iterator_j++;
                }
            }
        }
        return max_area;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right)
    {
        ListNode dummyhead = new ListNode(0),prevNode = dummyhead,result_head = dummyhead;
        dummyhead.next = head;
        for(int iterator_i=1;iterator_i<left;iterator_i++)
        {
            prevNode = prevNode.next;
            head = head.next;
        }
        ListNode temp = prevNode;
        prevNode = prevNode.next;
        head= head.next;
        for(int iterator_i=0;iterator_i<right-left;iterator_i++)
        {
            ListNode new_next = head.next;
            head.next = prevNode;
            prevNode = head;
            head = new_next;
        }
        temp.next = prevNode;
        for(int iterator_i=0;iterator_i<=right-left;iterator_i++)
            temp = temp.next;
        temp.next = head;
        return result_head.next;
    }

    ListNode unreversedNode = null,prevs=null;
    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        return reverseBetweenHelper(dummyHead,left,right).next;
    }

    public ListNode reverseBetweenHelper(ListNode head,int left,int right)
    {
        if(left !=1)
            head.next = reverseBetweenHelper(head.next,left-1,right-1);
        else if(right !=0)
        {
            head.next = reverseNodeRcur(head.next, right - 1);
            prevs.next = unreversedNode;
        }
        return head;
    }

    public  ListNode reverseNodeRcur(ListNode head,int num)
    {
        if(num==0) {
            unreversedNode = head.next;
            prevs = head;
            return head;
        }
        ListNode rightNodes = reverseNodeRcur(head.next,num-1);
        prevs.next = head;
        prevs=head;
        return rightNodes;
    }

    public int arrayPairSum(int[] nums)
    {
        int bucket[] = new int[20001],iterator_i=0,sum=0;
        for(int num:nums)
            bucket[10000+num]++;
        while(iterator_i<=200000)
        {
            while(iterator_i<=20000 && bucket[iterator_i]==0)
                iterator_i++;
            if(iterator_i==20001)
                return sum;
            sum += (iterator_i-10000)*(bucket[iterator_i]/2);
            if(bucket[iterator_i]%2==0)
                bucket[iterator_i++] = 0;
            else
            {
                sum+= (iterator_i-10000);
                bucket[iterator_i++] = 0;
                while(bucket[iterator_i]==0)
                    iterator_i++;
                bucket[iterator_i]--;
            }
        }
        return sum;
    }

    public int nthSuperUglyNumber1(int n, int[] primes)
    {
        int ugly_arr[] = new int[n], multiplication_index[] = new int[primes.length],next_ugly;
        ugly_arr[0] = 1;

        for(int iterator_i=0;iterator_i<n-1;iterator_i++)
        {
            next_ugly=Integer.MAX_VALUE;
            for(int iterator_j=0;iterator_j<primes.length;iterator_j++)
            {
                if(ugly_arr[iterator_i] == primes[iterator_j]*ugly_arr[multiplication_index[iterator_j]])
                    multiplication_index[iterator_j]++;
                next_ugly = Math.min(next_ugly,primes[iterator_j]*ugly_arr[multiplication_index[iterator_j]]);
            }
            ugly_arr[iterator_i+1] = next_ugly;
        }
        return ugly_arr[n-1];
    }

    public int nthSuperUglyNumber(int n, int[] primes)
    {
        PriorityQueue<UglyTuple> pq = new PriorityQueue();
        int ugly_num[] = new int[n];ugly_num[0] = 1;
        for(int iterator_i=0;iterator_i<primes.length;iterator_i++)
            pq.add(new UglyTuple(primes[iterator_i],0,primes[iterator_i]));

        for(int iterator_i=1;iterator_i<n;iterator_i++)
        {
            UglyTuple popped_ele = pq.peek();
            int next_ugly = popped_ele.ugly_val;
            ugly_num[iterator_i] = next_ugly;
            while(pq.peek().ugly_val == next_ugly)
            {
                UglyTuple temp = pq.poll();
                pq.add(new UglyTuple(ugly_num[temp.multiplication_index+1]*temp.prime,temp.multiplication_index+1,temp.prime));
            }
        }
        return ugly_num[n-1];
    }

    public class UglyTuple implements Comparable<UglyTuple>
    {
        int multiplication_index=0,prime=0,ugly_val=0;
        public UglyTuple(int ugly,int mul_index,int prime_val)
        {
            ugly_val = ugly;
            multiplication_index = mul_index;
            prime = prime_val;
        }

        @Override
        public int compareTo(UglyTuple o)
        {
            return Integer.compare(this.ugly_val,o.ugly_val);
        }
    }

    int final_tilt=0;
    public int findTilt(TreeNode root)
    {
        findTiltHelper(root);
        return final_tilt;
    }

    public int findTiltHelper(TreeNode root)
    {
        if(root==null)
            return 0;
        int left_val = findTiltHelper(root.left);
        int right_val = findTiltHelper(root.right);
        final_tilt += Math.abs(right_val-left_val);
        return left_val+right_val+root.val;
    }

    public int distributeCandies(int[] candyType)
    {
        int total_types=0;
        HashSet hset = new HashSet();
        for(int candy:candyType)
        {
            if(!hset.contains(candy))
            {
                hset.add(candy);
                total_types++;
            }
        }
        return Math.min(total_types,candyType.length/2);

    }

    public int trap1(int[] height)
    {
        if(height.length==0)
            return 0;
        int left_boundary[] = new int[height.length],max_right=height[height.length-1],trapped_units=0;
        left_boundary[0] = height[0];
        for(int iterator_i=1;iterator_i<height.length;iterator_i++)
            left_boundary[iterator_i] = Math.max(left_boundary[iterator_i-1],height[iterator_i]);

        for(int iterator_i=height.length-1;iterator_i>=0;iterator_i--)
        {
            max_right = Math.max(height[iterator_i],max_right);
            trapped_units += Math.max(0,Math.min(left_boundary[iterator_i],max_right)-height[iterator_i]);
        }
        return trapped_units;
    }

    public int trap2(int[] height)
    {
        if(height.length==0)
            return 0;
        int left_index=0,right_index=height.length-1,trapped_water=0,left_boundary=height[0],right_boundary=height[height.length-1];
        while(left_index<=right_index)
        {
            if(height[left_index]<=height[right_index])
            {
                trapped_water += Math.min(left_boundary,right_boundary) - height[left_index++];
                left_boundary = Math.max(left_boundary,(left_index==height.length?left_boundary:height[left_index]));
            }
            else
            {
                trapped_water += Math.min(right_boundary,left_boundary) - height[right_index--];
                right_boundary = Math.max(right_boundary,(right_index==-1?right_boundary:height[right_index]));
            }
        }
        return trapped_water;
    }

    public int trap(int[] height)
    {
        Stack<Integer> stck = new Stack();
        int curr_index = 0,trapped_water=0;
        while(curr_index!=height.length)
        {
            int curr_height = height[curr_index];
            while(!stck.isEmpty() && curr_height>=height[stck.peek()])
            {
                int popped_ele = stck.pop();
                trapped_water += (Math.min(curr_height,stck.isEmpty()?height[popped_ele]:height[stck.peek()])-height[popped_ele])*(curr_index - (stck.isEmpty()?-1:stck.peek()+1));
            }
            stck.push(curr_index++);
        }
        return trapped_water;
    }


    public int numSquares(int n)
    {
        int dp_arr[] = new int[n+1];
        Arrays.fill(dp_arr,Integer.MAX_VALUE);
        for(int iterator_i=1; iterator_i*iterator_i <= n;iterator_i++)
            dp_arr[iterator_i*iterator_i] = 1;
        if(dp_arr[n] == 1)
            return 1;
        for(int iterator_i=2;iterator_i<=n;iterator_i++)
        {
            if(dp_arr[iterator_i]==1)
                continue;
            for(int iterator_j=1;iterator_j<iterator_i;iterator_j++)
                dp_arr[iterator_i] = Math.min(dp_arr[iterator_i],(dp_arr[iterator_i-iterator_j] + dp_arr[iterator_j]));
        }

        return dp_arr[n];
    }

    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return targetSum == root.val? true:false;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        return mergeListsHelper(lists,0,lists.length-1);
    }

    public ListNode mergeListsHelper(ListNode[] lists,int lb, int ub)
    {
        if(lb==ub)
            return lists[lb];
        int mid = (lb+ub)/2;
        ListNode left_sorted = mergeListsHelper(lists,lb,mid);
        ListNode right_sorted = mergeListsHelper(lists,mid+1,ub);
        return mergeListsHelperMerge(left_sorted,right_sorted);
    }

    public ListNode mergeListsHelperMerge(ListNode left_sorted,ListNode right_sorted)
    {
        ListNode dummyHead = new ListNode(0),result_head= dummyHead;
        dummyHead.next = left_sorted;
        while(right_sorted!=null && left_sorted!=null)
        {
            if(right_sorted.val<left_sorted.val)
            {
                ListNode temp = dummyHead.next;
                dummyHead.next = right_sorted;
                right_sorted = right_sorted.next;
                dummyHead.next.next = temp;
                dummyHead = dummyHead.next;
            }
            else
            {
                dummyHead = dummyHead.next;
                left_sorted = left_sorted.next;
            }
        }
        if(left_sorted==null)
            dummyHead.next = right_sorted;
        return result_head.next;
    }

    public int longestIncreasingPath(int[][] matrix)
    {
        int longest_path = Integer.MIN_VALUE, memoization_arr[][] = new int[matrix.length][matrix[0].length];
        for(int iterator_i=0;iterator_i<matrix.length;iterator_i++)
            Arrays.fill(memoization_arr[iterator_i],Integer.MAX_VALUE);
        for(int iterator_i=0;iterator_i<matrix.length;iterator_i++)
            for (int iterator_j = 0; iterator_j < matrix[0].length; iterator_j++)
                longest_path = Math.max(longest_path, longestIncreasingPathHelper(matrix, iterator_i, iterator_j, memoization_arr));

        return longest_path;
    }
    int[][] longestDirections = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPathHelper(int matrix[][],int row,int col, int[][] memoization_arr)
    {
        if(memoization_arr[row][col]!=Integer.MAX_VALUE)
            return memoization_arr[row][col];
        int max_path = Integer.MIN_VALUE;
        for(int[] direction:longestDirections)
        {
            int new_row = row+direction[0], new_col = col+direction[1];
            if(new_row>=0 && new_row<matrix.length && new_col>=0 && new_col<matrix[0].length && matrix[new_row][new_col]>matrix[row][col])
                max_path = Math.max(longestIncreasingPathHelper(matrix,new_row,new_col,memoization_arr),max_path);
        }
        memoization_arr[row][col] = 1+ (max_path==Integer.MIN_VALUE?0:max_path);
        return 1+ (max_path==Integer.MIN_VALUE?0:max_path);
    }

    public int[] intersect(int[] nums1, int[] nums2)
    {
        int hmap_arr[] = new int[1001];
        for(int num: nums1)
            hmap_arr[num]++;
        ArrayList<Integer> result = new ArrayList();
        for(int nums:nums2)
        {
            if(hmap_arr[nums]!=0)
            {
                hmap_arr[nums]--;
                result.add(nums);
            }
        }
        int arr[] = new int[result.size()],counter=0;
        for(int result_val:result)
            arr[counter++] = result_val;
        return arr;
    }

    public int[][] merge1(int[][] intervals)
    {
        Arrays.sort(intervals, (a,b)->{return (a[0]!=b[0])?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]);});
        List<List<Integer>> result_list = new ArrayList();
        int curr_intend = intervals[0][1],curr_intstrt = intervals[0][0];

        for(int iterator_i=1;iterator_i<intervals.length;iterator_i++)
        {
            if(intervals[iterator_i][0]>curr_intend )
            {
                List<Integer> interval = new ArrayList();
                interval.add(curr_intstrt);
                interval.add(curr_intend);
                curr_intstrt = intervals[iterator_i][0];
                curr_intend = intervals[iterator_i][1];
                result_list.add(interval);
            }
            else
                curr_intend = Math.max(curr_intend,intervals[iterator_i][1]);
        }
        List<Integer> interval = new ArrayList();
        interval.add(curr_intstrt);
        interval.add(curr_intend);
        result_list.add(interval);
        int merged_intervals[][] = new int[result_list.size()][2],counter=0;
        for(List<Integer> lst: result_list)
        {
            merged_intervals[counter][0] = lst.get(0);
            merged_intervals[counter++][1] = lst.get(1);

        }
        return merged_intervals;
    }


    public class mergeIntervalsNode
    {
        int interval_low,interval_high,interval_mid;
        mergeIntervalsNode lchild, rchild;
        public mergeIntervalsNode(int low,int high)
        {
            interval_low = low;
            interval_high = high;
            interval_mid = (low+high)/2;
            lchild = rchild = null;
        }
    }

    public mergeIntervalsNode addInterval(mergeIntervalsNode root, int[] newInterval)
    {
        if(root==null)
            return new mergeIntervalsNode(newInterval[0],newInterval[1]);

        if(newInterval[1]<root.interval_mid)
        {
            root.lchild = addInterval(root.lchild,newInterval);
        }
        else if(newInterval[0]>root.interval_mid)
        {
            root.rchild = addInterval(root.rchild,newInterval);
        }
        else
        {
            root.interval_low = Math.min(root.interval_low,newInterval[0]);
            root.interval_high = Math.max(root.interval_high,newInterval[1]);
        }
        return root;
    }

    public int[][] mergeIntervalsHelper(mergeIntervalsNode root)
    {
        if(root==null)
            return null;
        int left_intervals[][]=null,right_intervals[][]=null;
        if(root.lchild!=null)
            left_intervals = mergeIntervalsHelper(root.lchild);
        if(root.rchild!=null)
            right_intervals = mergeIntervalsHelper(root.rchild);

        return mergeIntervalsHelperMerge(left_intervals,right_intervals,root);
    }

    public int[][] mergeIntervalsHelperMerge(int[][] left_intervals,int[][] right_intervals,mergeIntervalsNode root)
    {
        List<int[]> result = new ArrayList();
        int curr_end, curr_start,iterator_left=0;
        if(left_intervals == null)
        {
            curr_end = root.interval_high;
            curr_start = root.interval_low;
        }
        else
        {
            curr_end=left_intervals[0][1];
            curr_start=left_intervals[0][0];
        }

        boolean isMerged=false;
        if(left_intervals!=null) {
            while (iterator_left < left_intervals.length) {
                if (left_intervals[iterator_left][1] >= root.interval_low) {
                    isMerged = true;
                    if(iterator_left!=0)
                        result.add(new int[]{curr_start, curr_end});
                    curr_start = left_intervals[iterator_left][0];
                    curr_end = left_intervals[iterator_left][1];
                    break;
                } else if (left_intervals[iterator_left][0] > curr_end && iterator_left!=0) {
                    result.add(new int[]{curr_start, curr_end});
                    curr_start = left_intervals[iterator_left][0];
                    curr_end = left_intervals[iterator_left][1];
                } else {
                    curr_end = Math.max(curr_end, left_intervals[iterator_left][1]);
                    curr_start = Math.min(curr_start, left_intervals[iterator_left][0]);
                }
                iterator_left++;
            }
            if (!isMerged)
            {
                result.add(new int[]{curr_start, curr_end});
                curr_start = root.interval_low;
                curr_end = root.interval_high;
            }
            else {
                while (iterator_left < left_intervals.length)
                    curr_start = Math.min(curr_start, left_intervals[iterator_left++][0]);
                curr_start = Math.min(curr_start, root.interval_low);
                curr_end = root.interval_high;
            }
        }

        iterator_left = 0;
        while(right_intervals!=null && iterator_left<right_intervals.length && curr_end>=right_intervals[iterator_left][0])
        {
            curr_end = Math.max(curr_end,right_intervals[iterator_left][1]);
            curr_start = Math.min(curr_start,right_intervals[iterator_left][0]);
            iterator_left++;
        }
        result.add(new int[]{curr_start,curr_end});
        if(right_intervals!=null) {
            if (iterator_left < right_intervals.length) {
                curr_start = right_intervals[iterator_left][0];
                curr_end = right_intervals[iterator_left][1];
                while (iterator_left < right_intervals.length) {
                    if (right_intervals[iterator_left][0] > curr_end) {
                        result.add(new int[]{curr_start, curr_end});
                        curr_start = right_intervals[iterator_left][0];
                        curr_end = right_intervals[iterator_left][1];
                    } else {
                        curr_end = Math.max(curr_end, right_intervals[iterator_left][1]);
                        curr_start = Math.min(curr_start, right_intervals[iterator_left][0]);
                    }
                    iterator_left++;
                }
            result.add(new int[]{curr_start, curr_end});
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge(int[][] intervals)
    {
        mergeIntervalsNode root = null;
        for(int iterator_i=0;iterator_i<intervals.length;iterator_i++)
            root = addInterval(root,intervals[iterator_i]);

        return mergeIntervalsHelper(root);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int len1=nums1.length, len2=nums2.length, lb=0, ub=2*len2;
        if(len2>len1)
            return findMedianSortedArrays(nums2,nums1);

        while(lb<=ub)
        {
            int mid2 = (lb+ub)/2;
            int mid1 = len1+len2-mid2;

            int L1 = mid1==0?Integer.MIN_VALUE:nums1[(mid1-1)/2];
            int L2 = mid2==0?Integer.MIN_VALUE:nums2[(mid2-1)/2];
            int R1 = mid1==len1*2?Integer.MAX_VALUE:nums1[mid1/2];
            int R2 = mid2==len2*2?Integer.MAX_VALUE:nums2[(mid2/2)];

            if(L1>R2)
                lb = mid2+1;
            else if(L2>R1)
                ub = mid2-1;
            else
                return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;
        }
        return 0.0;
    }


    public String convertToTitle(int columnNumber)
    {
        StringBuffer sb = new StringBuffer();
        while(columnNumber!=0)
        {
            sb.append((char)((columnNumber-1)%26+'A'));
            columnNumber = (columnNumber-1)/26;
        }
        return sb.reverse().toString();
    }

    public int[] twoSum1(int[] numbers, int target)
    {
        int lb=0,ub=numbers.length-1;
        while(lb<ub)
        {
            int num1 = numbers[lb],num2 = numbers[ub];
            if(num1+num2 < target)
                lb++;
            else if(num1+num2>target)
                ub--;
            else
                return new int[]{lb+1,ub+1};
        }
        return null;
    }

    public String convert(String s, int numRows)
    {
        StringBuffer sb[] = new StringBuffer[numRows],result=new StringBuffer();
        for(int iterator_i=0;iterator_i<numRows;iterator_i++)
            sb[iterator_i] = new StringBuffer();
        for(int iterator_i=0;iterator_i<s.length();iterator_i++)
        {
            int modval = iterator_i%(2*numRows-2);
            if(modval>numRows-1)
                modval = 2*numRows-modval-2;
            sb[modval].append(s.charAt(iterator_i));
        }
        for(int iterator_i=0;iterator_i<numRows;iterator_i++)
            result = result.append(sb[iterator_i]);
        return result.toString();
    }

    public int sumNumbers(TreeNode root)
    {
        return sumNumbersHelper(root,0);
    }

    public int sumNumbersHelper(TreeNode root,int sum)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return sum*10+root.val;
        return sumNumbersHelper(root.left,sum*10+root.val) + sumNumbersHelper(root.right,sum*10+root.val);
    }

    public int maxCoins(int[] nums)
    {
        int extended_balloons[] = new int[nums.length+2];
        int dp_arr[][] = new int[extended_balloons.length][extended_balloons.length];
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            extended_balloons[iterator_i+1] = nums[iterator_i];
        extended_balloons[0] = extended_balloons[nums.length+1] = 1;
        for(int iterator_size=2;iterator_size<extended_balloons.length;iterator_size++)
        {
            for(int iterator_left=0;iterator_left+iterator_size<extended_balloons.length;iterator_left++)
            {
                int maxCoins = Integer.MIN_VALUE;
                for(int iterator_balloon=iterator_left+1;iterator_balloon<iterator_left+iterator_size;iterator_balloon++)
                {
                    maxCoins = Math.max(maxCoins, dp_arr[iterator_left][iterator_balloon] + dp_arr[iterator_balloon][iterator_left+iterator_size] +
                            extended_balloons[iterator_left]*extended_balloons[iterator_balloon]*extended_balloons[iterator_left+iterator_size]);
                }
                dp_arr[iterator_left][iterator_left+iterator_size] = maxCoins;
            }
        }
        return dp_arr[0][extended_balloons.length-1];
    }

    public boolean isIsomorphic(String s, String t)
    {
        if(s.length()!=t.length())
            return false;
        char hset[] = new char[256], hset1[] = new char[256];
        for(int iterator_i=0;iterator_i<t.length();iterator_i++)
        {
            char s_c = s.charAt(iterator_i), t_c = t.charAt(iterator_i);
            if(hset[s_c]>0 && hset[s_c]!=t_c)
                return false;
            if(hset1[t_c]>0 && hset1[t_c]!=s_c)
                return false;
            hset1[t_c] = s_c;
            hset[s_c] = t_c;
        }
        return true;
    }

    public boolean isUgly(int n)
    {
        if(n==0)
            return false;
        int div[] = {2,3,5};
        for(int iterator_i=0;iterator_i<div.length;iterator_i++)
        {
            int div_num = div[iterator_i];
            while(n%div_num==0)
                n /= div_num;
        }
        return n==1?true:false;
    }

    public List<String> restoreIpAddresses(String s)
    {
        List<String> result = new ArrayList();
        if(s.length()<4 || s.length()>12)
            return result;
        for(int iterator_1=0;iterator_1<3 && iterator_1<s.length()-3;iterator_1++)
        {
            if((s.charAt(0)=='0' && iterator_1>0) || Integer.parseInt(s.substring(0,iterator_1+1))>255)
                continue;
            for(int iterator_2=iterator_1+1;iterator_2<=iterator_1+3 && iterator_2<s.length()-2;iterator_2++)
            {
                if((s.charAt(iterator_1+1)=='0' && iterator_2-iterator_1>1) || Integer.parseInt(s.substring(iterator_1+1,iterator_2+1))>255)
                    continue;
                for(int iterator_3=iterator_2+1; iterator_3<s.length()-1 && iterator_3<=iterator_2+3;iterator_3++)
                {
                    if((s.charAt(iterator_2+1)=='0' && iterator_3-iterator_2>1) || Integer.parseInt(s.substring(iterator_2+1,iterator_3+1))>255)
                        continue;
                    System.out.println(s.substring(0,iterator_1+1)+"."+s.substring(iterator_1+1,iterator_2+1)+"."+s.substring(iterator_2+1,iterator_3+1));
                    if((s.charAt(iterator_3+1)=='0' && s.length()-iterator_3-1>1) || Integer.parseInt(s.substring(iterator_3+1))>255)
                        continue;
                    StringBuffer sb = new StringBuffer();
                    sb.append(s.substring(0,iterator_1+1));
                    sb.append(".");
                    sb.append(s.substring(iterator_1+1,iterator_2+1));
                    sb.append(".");
                    sb.append(s.substring(iterator_2+1,iterator_3+1));
                    sb.append(".");
                    sb.append(s.substring(iterator_3+1));
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    public int minimumTotal(List<List<Integer>> triangle)
    {
        int dp_prev[] = new int[triangle.get(triangle.size()-1).size()+1];
        int dp_curr[];

        for(int iterator_i=triangle.size()-1;iterator_i>=0;iterator_i--)
        {
            int iterator_index=0;
            dp_curr = new int[triangle.get(triangle.size()-1).size()+1];
            for(int lst:triangle.get(iterator_i)) {
                dp_curr[iterator_index] = Math.min(dp_prev[iterator_index], dp_prev[iterator_index + 1]) + lst;
                iterator_index++;
            }
            dp_prev = dp_curr;
        }
        return dp_prev[0];
    }

    public List<String> binaryTreePaths(TreeNode root)
{
    List<String> result_list = new ArrayList();
    binaryTreePathsHelper(root,new StringBuffer(),result_list);
    return result_list;
}

    public void binaryTreePathsHelper(TreeNode root,StringBuffer sb,List<String> result_list)
    {
        if(root==null)
            return;
        StringBuffer new_buffer = new StringBuffer(sb);
        new_buffer.append(root.val);
        if(root.left==null && root.right==null)
        {
            result_list.add(new_buffer.toString());
            return;
        }
        new_buffer.append("->");
        if(root.left!=null)
            binaryTreePathsHelper(root.left,new_buffer,result_list);
        if(root.right!=null)
            binaryTreePathsHelper(root.right,new_buffer,result_list);
    }


    public List<Integer> countSmaller(int[] nums)
    {
        List<Integer> return_list = new ArrayList();
        int count_array[] = new int[nums.length];
        countSmallerElement input_arr[] = new countSmallerElement[nums.length];
        for(int iterator_i=0;iterator_i<nums.length;iterator_i++)
            input_arr[iterator_i] = new countSmallerElement(iterator_i,nums[iterator_i]);

        countSmallerMergeHelper(input_arr,count_array,0,nums.length-1);
        for(int counts:count_array)
            return_list.add(counts);

        return return_list;
    }

    public void countSmallerMergeHelper(countSmallerElement[] input_arr,int[] count_array,int lb,int ub)
    {
        if(lb>=ub)
            return;
        int mid = lb + (ub-lb)/2;
        countSmallerMergeHelper(input_arr,count_array,lb,mid);
        countSmallerMergeHelper(input_arr,count_array,mid+1,ub);
        countSmallerMerge(input_arr,count_array,lb,mid,ub);
    }

    public void countSmallerMerge(countSmallerElement input_arr[],int[] count_arr,int lb,int mid,int ub)
    {
        int right_index = ub,left_index = mid, count_increment = ub-mid, index_merged=ub-lb;
        countSmallerElement merged_arr[] = new countSmallerElement[ub-lb+1];
        while(right_index>mid && left_index>=lb)
        {
            if(input_arr[left_index].value>input_arr[right_index].value)
            {
                merged_arr[index_merged--] = new countSmallerElement(input_arr[left_index].index,input_arr[left_index].value);
                count_arr[input_arr[left_index].index] += count_increment;
                left_index--;
            }
            else
            {
                merged_arr[index_merged--] = new countSmallerElement(input_arr[right_index].index,input_arr[right_index].value);
                count_increment--;
                right_index--;
            }
        }
        while(left_index>=lb)
        {
            merged_arr[index_merged--] = new countSmallerElement(input_arr[left_index].index,input_arr[left_index].value);
            left_index--;
        }
        while(right_index>mid)
        {
            merged_arr[index_merged--] = new countSmallerElement(input_arr[right_index].index,input_arr[right_index].value);
            right_index--;
        }

        for(int iterator_i=ub;iterator_i>=lb;iterator_i--)
        {
            input_arr[iterator_i] = merged_arr[iterator_i-lb];
        }
    }

    public class countSmallerElement
    {
        int index,value;
        public countSmallerElement(int index,int value)
        {
            this.index = index;
            this.value = value;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null || root==p || root==q)
            return root;
        TreeNode left=null,right=null;
        if(p.val<root.val || q.val<root.val)
            left = lowestCommonAncestor1(root.left,p,q);
        if(p.val>root.val || q.val>root.val)
            right = lowestCommonAncestor1(root.right,p,q);

        if(left!=null && right!=null)
            return root;
        return (left==null)?right:left;
    }

    public int sumOfLeftLeaves(TreeNode root)
    {
        return sumOfLeftLeavesHelper(root,false);
    }

    public int sumOfLeftLeavesHelper(TreeNode root,boolean to_add)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null && to_add)
            return root.val;
        return sumOfLeftLeavesHelper(root.left,true) + sumOfLeftLeavesHelper(root.right,false);
    }

    public boolean canConstruct(String ransomNote, String magazine)
    {
        int hset[] = new int[256];
        for(int iterator_i=0;iterator_i<magazine.length();iterator_i++)
            hset[magazine.charAt(iterator_i)]++;
        for(int iterator_i=0;iterator_i<ransomNote.length();iterator_i++)
        {
            hset[ransomNote.charAt(iterator_i)]--;
            if(hset[ransomNote.charAt(iterator_i)]<0)
                return false;
        }
        return true;
    }

    public List<String> findItinerary(List<List<String>> tickets)
    {
        HashMap<String,PriorityQueue<String>> paths = new HashMap();
        List<String> itinerary = new ArrayList();
        for(int iterator_i=0;iterator_i<tickets.size();iterator_i++)
        {
            String curr_start = tickets.get(iterator_i).get(0);
            if(!paths.containsKey(curr_start))
            {
                PriorityQueue<String> new_q = new PriorityQueue();
                paths.put(curr_start,new_q);
                new_q.add(tickets.get(iterator_i).get(1));
            }
            else
                paths.get(curr_start).add(tickets.get(iterator_i).get(1));
        }

        findItineraryHelper(paths,"JFK",itinerary);
        return itinerary;
    }

    public void findItineraryHelper(HashMap<String,PriorityQueue<String>> paths,String current_airport,List<String> result)
    {
        String next_airport = "";
        while(paths.get(current_airport)!=null && (next_airport=paths.get(current_airport).poll())!=null)
            findItineraryHelper(paths,next_airport,result);

        result.add(0,current_airport);
    }

    public List<String> findItinerary_bfs(List<List<String>> tickets)
    {
        HashMap<String,PriorityQueue<String>> hmap = new HashMap();
        for(int iterator_i=0;iterator_i<tickets.size();iterator_i++)
            hmap.computeIfAbsent(tickets.get(iterator_i).get(0),a-> new PriorityQueue<>()).add(tickets.get(iterator_i).get(1));

        Stack<String> bfs_stck = new Stack();
        bfs_stck.push("JFK");
        List<String> result = new ArrayList();
        while(!bfs_stck.isEmpty())
        {
            String next_airport="";
            while(hmap.get(bfs_stck.peek())!=null && (next_airport=hmap.get(bfs_stck.peek()).poll())!=null)
                bfs_stck.push(next_airport);
            result.add(0,bfs_stck.pop());
        }
        return result;
    }

    public List<List<Integer>> getSkyline1(int[][] buildings)
    {
        List<List<Integer>> result_list = new ArrayList();
        return getSkylineMergeHelper(buildings,0,buildings.length-1);

    }

    public List<List<Integer>> getSkylineMergeHelper(int[][] buildings,int lb,int ub)
    {
        if(lb>ub)
            return null;
        if(lb==ub)
        {
            List<List<Integer>> building_outline = new ArrayList();
            List<Integer> new_outline = new ArrayList();
            new_outline.add(buildings[lb][0]);
            new_outline.add(buildings[lb][2]);
            building_outline.add(new_outline);
            new_outline = new ArrayList();
            new_outline.add(buildings[lb][1]);
            new_outline.add(0);
            building_outline.add(new_outline);
            return building_outline;
        }

        int mid = lb+(ub-lb)/2;
        List<List<Integer>> left_outline = getSkylineMergeHelper(buildings,lb,mid);
        List<List<Integer>> right_outline = getSkylineMergeHelper(buildings,mid+1,ub);

        return getSkylineMerge(left_outline,right_outline);
    }

    public List<List<Integer>> getSkylineMerge(List<List<Integer>> left_outline, List<List<Integer>> right_outline)
    {
        int left_pointer = 0,right_pointer=0,prev_x=0,left_height=0,right_height=0,cur_height=0;
        if(right_outline==null)
            return left_outline;
        List<List<Integer>> merged_outline = new ArrayList();
        while(left_pointer<left_outline.size() && right_pointer<right_outline.size())
        {
            if(left_outline.get(left_pointer).get(0)<right_outline.get(right_pointer).get(0))
            {
                prev_x = left_outline.get(left_pointer).get(0);
                left_height = left_outline.get(left_pointer).get(1);
                left_pointer++;
            }
            else if(left_outline.get(left_pointer).get(0)>right_outline.get(right_pointer).get(0))
            {
                prev_x = right_outline.get(right_pointer).get(0);
                right_height = right_outline.get(right_pointer).get(1);
                right_pointer++;
            }
            else
            {
                prev_x = left_outline.get(left_pointer).get(0);
                left_height = left_outline.get(left_pointer).get(1);
                right_height = right_outline.get(right_pointer).get(1);
                left_pointer++;
                right_pointer++;
            }

            if(cur_height != Math.max(left_height,right_height))
            {
                cur_height = Math.max(left_height,right_height);
                List<Integer> new_add = new ArrayList();
                new_add.add(prev_x);
                new_add.add(cur_height);
                merged_outline.add(new_add);
            }
        }

        while(right_pointer<right_outline.size())
            merged_outline.add(right_outline.get(right_pointer++));


        while(left_pointer<left_outline.size())
            merged_outline.add(left_outline.get(left_pointer++));

        return merged_outline;
    }

    public List<List<Integer>> getSkyline(int[][] buildings)
    {
        List<List<Integer>> final_result = new ArrayList();
        List<int[]> height_sorted = new ArrayList();
        for(int building[]:buildings)
        {
            height_sorted.add(new int[]{building[0],-building[2]});
            height_sorted.add(new int[]{building[1],building[2]});
        }

        Collections.sort(height_sorted,(a,b)->(a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0])));
        TreeMap<Integer,Integer> tmap = new TreeMap(Collections.reverseOrder());
        tmap.put(0,1);
        int prev_height = 0;

        for(int[] height_changes: height_sorted)
        {
            if(height_changes[1]<0)
            {
                Integer stored_val = tmap.get(-height_changes[1]);
                int new_val = stored_val==null?1:stored_val+1;
                tmap.put(-height_changes[1],new_val);
            }
            else
            {
                int current_val = tmap.get(height_changes[1]);
                if(current_val==1)
                    tmap.remove(height_changes[1]);
                else
                    tmap.put(height_changes[1],current_val-1);
            }

            int current_max_height = tmap.firstKey();
            if(current_max_height!=prev_height)
            {
                List<Integer> new_outline = new ArrayList();
                new_outline.add(height_changes[0]);
                new_outline.add(current_max_height);
                final_result.add(new_outline);
                prev_height = current_max_height;
            }
        }
        return final_result;
    }

    public int hIndex(int[] citations)
    {
        int buckets[] = new int[1001];
        for(int citation:citations)
            buckets[citation]++;

        int current_bucket = 1000,greater_buckets=0;
        while(current_bucket>=0)
        {
            greater_buckets+=buckets[current_bucket];
            if(greater_buckets>=current_bucket)
                return current_bucket;
            current_bucket--;
        }
        return 0;
    }
}
