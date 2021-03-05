/*
Average of Levels in Binary Tree
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        //Level order traversal
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double avg = 0.0;
        double sum = 0;
        int count = 0;
        List <Double> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            count = 0;
            sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                count ++;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
           
                list.add((double) sum / count);
        }
        
        return list;
    }
}