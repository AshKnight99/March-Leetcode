/*
Flip Binary Tree To Match Preorder Traversal
You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n. You are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree.

Any node in the binary tree can be flipped by swapping its left and right subtrees. For example, flipping node 1 will have the following effect:


Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage.

Return a list of the values of all flipped nodes. You may return the answer in any order. If it is impossible to flip the nodes in the tree to make the pre-order traversal match voyage, return the list [-1].

 

Example 1:


Input: root = [1,2], voyage = [2,1]
Output: [-1]
Explanation: It is impossible to flip the nodes such that the pre-order traversal matches voyage.
Example 2:


Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]
Explanation: Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal matches voyage.
Example 3:


Input: root = [1,2,3], voyage = [1,2,3]
Output: []
Explanation: The tree's pre-order traversal already matches voyage, so no nodes need to be flipped.
 

Constraints:

The number of nodes in the tree is n.
n == voyage.length
1 <= n <= 100
1 <= Node.val, voyage[i] <= n
All the values in the tree are unique.
All the values in voyage are unique.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List <Integer> result;  
    int index = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        result = new ArrayList<>();
        flipTraversal(root,voyage);
        return result;        
    }
    private void flipTraversal(TreeNode root, int[] V){
        if(root == null || (result.size() != 0 && result.get(0) == -1))return;
        if(root.val != V[index++])
            result = new ArrayList<>(Arrays.asList(-1));
        else if(root.left != null && root.left.val != V[index]){
            //adding parent
            result.add(root.val);
            flipTraversal(root.right, V);
            flipTraversal(root.left, V);            
        }
        else{
            flipTraversal(root.left, V);
            flipTraversal(root.right, V);            
        }
    }
}
/*
Alternative way
class Solution {
    int idx = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        return dfs(root, voyage, res) ? res : new ArrayList<Integer>(Arrays.asList(-1));
    }
    private boolean dfs(TreeNode n, int[] v, List<Integer> res) {
        if(idx == v.length || n == null) return true;
        if( n.val != v[idx++]) return false;
        if(n.left != null && n.left.val != v[idx]) {
            res.add(n.val);
            return dfs(n.right, v, res) && dfs(n.left, v, res);
        }
        return dfs(n.left, v, res) && dfs(n.right, v, res);
    }
}
*/