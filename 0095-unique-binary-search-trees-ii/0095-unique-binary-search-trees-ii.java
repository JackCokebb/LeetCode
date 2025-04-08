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
    public List<TreeNode> generateTrees(int n) {
        
        return generateSubTrees(1, n);
    }

    private List<TreeNode> generateSubTrees(int start, int end) {

        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start ; i <= end ; i++) {
            List<TreeNode> leftSub = generateSubTrees(start, i - 1);
            List<TreeNode> rightSub = generateSubTrees(i + 1, end);    

            for (TreeNode l : leftSub) {
                for (TreeNode r : rightSub) {
                    TreeNode root = new TreeNode(i, l, r);
                    result.add(root);
                }
            }
        }

        return result;
    }
}