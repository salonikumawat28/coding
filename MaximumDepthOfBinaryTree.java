import javax.swing.tree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 *  
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * 
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 * 
 * Input: root = []
 * Output: 0
 * Example 4:
 * 
 * Input: root = [0]
 * Output: 1
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100f
 */
public class MaximumDepthOfBinaryTree {
    
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
    }

    /**
     * Finding maximum depth of tree of farthest leaf.
     * 
     * Steps :
     * check if root = null , return 0
     * T = max depth of root node
     * T(root) = 1 + max(Tleft, Tright)
     * 
     * @param root is given input
     * @return maximum depth of tree.
     * 
     * Tc(n) = 1 + Tc(left) + Tc(right)
     * Tc(n) = 1 + 2Tc(n-1)
     * .
     * .
     * Tc(n) = 2^n, where n is maximum height
     * 
     * 
     */
    public int maxDepth(TreeNode root) { // O(2^n),O(n) where n is maximum height.
        if (root == null) return 0; // O(1), O(1)
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); // O(2^n), O(n)
        
    }

   
    
    
}
