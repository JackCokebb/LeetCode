/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Deque<Node> queue;

    public Node connect(Node root) {
        if (root == null) return root;
        
        queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            Node prevNode = null;

            for (int i = 0; i < currQueueSize; i++) {
                Node currNode = queue.pollFirst();
                if (prevNode != null) prevNode.next = currNode;
                prevNode = currNode;

                if (currNode.left != null){
                    queue.addLast(currNode.left);
                    queue.addLast(currNode.right);
                }   
            }
            prevNode = null;
        }

        return root;
    }
}