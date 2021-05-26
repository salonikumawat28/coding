import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * 
 * Input: numRows = 1
 * Output: [[1]]
 *  
 * 
 * Constraints:
 * 
 * 1 <= numRows <= 30
 */
public class PascalLaw {
    public static void main(String[] args) {
        PascalLaw solution = new PascalLaw();
    }

    /**
     * Find Pascal's triangle for given number of rows.
     * 
     * Expression :
     * a[i][j] = a[i-1][j-1] + a[i-1][j]
     * 
     * Steps:
     * 1. Add 1 in the list
     * 2. Start for loop i = 1 to row - 1
     *      Add 1 in the list as starting 1 for the each row of triangle.
     *      Start for loop j = 1 to i-1
     *        add list[i][j] = list[i-1][j-1] + list[i-1][j]
     *      end loop
     *      Add 1 in the list as ending 1 for each row of tringle
     * 3. End loop
     * 4. return list
     * 
     * @param numRows is given input
     * @return rows of pascal's triangle
     * 
     */
    public List<List<Integer>> generate(int numRows) { // O(n^2), O(n^2) where n is numberof rows in triangle 
        List<List<Integer>> rows = new ArrayList<List<Integer>>(); // O(1), O(1)
        rows.add(new ArrayList<Integer>()); // O(1), O(1)
        rows.get(0).add(1); // O(1),O(1)
        for(int i = 1; i < numRows; i++) { // O(n^2), O(n^2) where n is number of rows in triangle
            rows.add(new ArrayList<Integer>()); // O(1), O(1)
            rows.get(i).add(1); // O(1), O(1)
            for(int j = 1; j < i; j++) { // O(i), O(i) 
                int num = rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j); // O(1), O(1)
                rows.get(i).add(num); // O(1), O(1)
            }
            rows.get(i).add(1); // O(1), O(1)
        }
        return rows; // O(1), O(1)

    }
    
}
