/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayDeque<TreeNode> ppq;
    ArrayDeque<TreeNode> qpq;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q, new ArrayDeque<>());
        //printPriorityQueue(ppq);
        //printPriorityQueue(qpq);

        while((!ppq.isEmpty() && !qpq.isEmpty()) && ppq.peekLast().val != qpq.peekLast().val) {
            if (ppq.size() < qpq.size()) {
                TreeNode polled = qpq.pollLast();
                //System.out.println("!" + polled.val + " was polled from qpq");
            } else {
                TreeNode polled = ppq.pollLast();
                //System.out.println("!" + polled.val + " was polled from ppq");
            }
        }

        return ppq.peekLast();
    }

    private void find(TreeNode root, TreeNode p, TreeNode q, ArrayDeque<TreeNode> visited) {
        if (root == null) return;

        visited.addLast(root);
        //System.out.println("pval: " + p.val + ", q.val: " + q.val + ", rootval: " + root.val);

        if (p.val == root.val) {
            ppq = new ArrayDeque<>();
            ppq.addAll(visited);
            //System.out.println("ppq added");
        }

        if (q.val == root.val) {
            qpq = new ArrayDeque<>();
            qpq.addAll(visited);
            //System.out.println("qpq added");
        }

        if (ppq != null && qpq != null) return;
        

        find(root.left, p, q, visited);
        find(root.right, p, q, visited);
        visited.pollLast();
    }

    public static void printPriorityQueue(ArrayDeque<TreeNode> queue) {
        ArrayDeque<TreeNode> copy = new ArrayDeque<>(queue);

        System.out.print("[");
        while (!copy.isEmpty()) {
            System.out.print(copy.pollLast().val);

            if (!copy.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}