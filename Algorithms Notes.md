1. in case of multiple for loop.......if internal condition doesnot depend on order of i or j (i, j = indexs)...then we can use internal index j =i+1 or i (instead of j = 0) to avoid duplicate checking. For Eg - nums[i] + nums[j] we can avoid duplicate checking but nums[i] / nums[j] we can not avoid duplicate checking.
2. if you are getting digits one by one then instead of char array / StringBuilder, make it as a single integer by using concept = a * 10 + b (https://leetcode.com/problems/reverse-integer/)
3. Always avoid ' + ' operation in String specially in loop , instead use StringBuilder or char[] as it has less TC. Better to use String Builder because of its simplicity.
4. append() method of StringBuilder takes TC = O(1) while toString() method of StringBuilder takes TC = O(n), SC = O(n).
5. To get each digit in integer, divide by 10 in loop and do % to get the digit.
6. n = logx  + 1 where n is number of digits in x. So, O(n) = O(logx) = O(1) , we can say O(1) because we know n max = 32, Hence constant.
7. when ever a problem is using parantheses, think of using stack.
8. In Promblems of linked list current is used to access every node and head is remain fixed for starting node only.