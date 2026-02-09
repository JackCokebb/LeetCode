class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            
            if (currNode.val == head.val) {
                if (dps(head, currNode)) {
                    return true;
                }
            }

            if (currNode.left != null) {
                stack.push(currNode.left);
            }

            if (currNode.right != null) {
                stack.push(currNode.right);
            }
        }
        
        return false;
    }

    public boolean dps(ListNode refNode, TreeNode currNode) {

        if (refNode == null) {
            return true;
        }

        if (currNode == null) {
            return false;
        }

        if (refNode.val != currNode.val) {
            return false;
        } 

        return dps(refNode.next, currNode.left) || dps(refNode.next, currNode.right);
    }
}