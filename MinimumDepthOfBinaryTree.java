/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 *  
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 * 
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();
    }

    /**
     * Find min depth of Binary Tree
     * 
     * Expression :
     * T(root) = min depth of Binary Tree start from root.
     * T(root) = 1 + min(T(left), T(right)).
     * 
     * Steps:
     * Check if root == null, return 0
     * if root.left || root.right is null, return 1 + max(T(left), T(right))
     * else return 1 + min(T(left), T(right)).
     * 
     * @param root
     * @return min depth of Binary Tree
     * 
     * Time Complexity :
     * TC(root) = 1 + TC(left) + Tc(right)
     * TC(n) = 1 + 2TC(n-1)
     * .
     * .
     * .
     * TC(n) = 1 + 2^n
     * 
     * Space Complexity :
     * Sc = O(n), because of stack is using n spaces.
     */
    public int minDepth(TreeNode root) { // O(2^n), O(n) where n is depth of Tree.
        if(root == null) return 0; // O(1), O(1)
        if(root.left == null || root.right == null) return 1 + Math.max(minDepth(root.left), minDepth(root.right)); // O(2^n), O(1)
        return 1 + Math.min(minDepth(root.left), minDepth(root.right)); // O(2^n), O(1)

    }
}
