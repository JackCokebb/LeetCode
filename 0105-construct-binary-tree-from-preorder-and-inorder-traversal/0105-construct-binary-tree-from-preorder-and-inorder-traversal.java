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
    int preIdx;
    HashMap<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, preorder.length - 1);

        return root;
    }
    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;
        int mid = inorderMap.get(root.val);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}