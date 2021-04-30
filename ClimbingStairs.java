import java.util.spi.ToolProvider;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(n));   
    }

    /**
     * Find Distinct ways to climb stairs.
     * 
     * n = 1 => 1 way
     * n = 2 => 2 way
     * n = 3 => 3 ways
     * n = 4 => 5 ways
     * n = 5 => 8 ways etc.
     * Steps:
     * 
     * Here we will use formula Tn = Tn-1 + Tn-2 to solve the given problem.
     * Initialise TPre = 1 and TPrePre = 1 
     * for loop i = 2 to n , i++
     *   ti = TPre + TPrePre
     *   TPrePre = TPre // changing Tn-2 = Tn-1
     *   TPre = ti  // updating  Tn-1 = Tn
     * End loop
     * return TPre
     * 
     * @param n is number of stairs in input
     * @return distinct ways to climb stairs.
     */
    public int climbStairs(int n) { // O(n), O(1)
        int tPrePre = 1; // O(1), O(1)
        int tPre = 1; // O(1), O(1)
        for(int i = 2; i <= n; i++) { // O(n), O(1)
            int ti = tPre + tPrePre; // O(1), O(1)
            tPrePre = tPre; // O(1), O(1)
            tPre = ti; // O(1), O(1)
        }
        return tPre; // O(1), O(1)
    }
    
    /**
     * Find Distinct ways to climb stairs by using recursion.
     * 
     * Sc = O(n) -> Here, at a given point of time maximum space occupied by stack is O(n), as function keeps on calling itself again and again.
     * Tc = O(2^n) -> TCn = TCn-1 + TCn-2 , we are assuming TCn-2 = TCn-1, so TCn = 2TCn-1 = 2^nTC0 = 2^n
     * 
     * @param n is input
     * @return number of ways to climb stairs.
     */
    public int climbStairsRecursion(int n) { // O(2^n), O(n) where n is number of steps.

        // Recursion ends when n == 0 or n == 1
        if(n == 0 || n == 1) return 1; // O(1), O(1)
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);  // O(2^n), O(1) 
    }

    /**
     * Find Distinct ways to climb stairs by using dynamic programming
     * 
     * @param n is number of steps
     * @return number of ways to climb stairs
     */
    public int climbStairsByDynamicProgramming(int n) { // O(n), O(n)
        int[] dp = new int[n + 1]; // O(1), O(n)
        return dynamicProgramming(n, dp); // O(nn), O(n)
    }

    /**
     * Here, We store the value of tn in dp so that we donot have to solve it again and again.
     * @param n
     * @param dp
     * @return
     */
    public int dynamicProgramming(int n, int[] dp) { // O(2n), O(n)
        if(n == 0 || n == 1) return dp[n]; // O(1), O(1)
        if(dp[n] != 0) return dp[n]; // O(1), O(1)
        dp[n] = dynamicProgramming(n - 1, dp) + dynamicProgramming(n - 2, dp); // O(n + n), O(1)
        return dp[n]; // O(1), O(1)

    }
    
}
