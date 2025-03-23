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

    Deque<Node> evenQueue = new ArrayDeque<>();
    Deque<Node> oddQueue = new ArrayDeque<>();

    public Node connect(Node root) {
        
        if (root == null) {

            return root;
        }

        boolean isEven = true;
        evenQueue.addLast(root);
        
        while (!evenQueue.isEmpty() || !oddQueue.isEmpty()) {

            Node currNode = getCurrentQueue(isEven).poll();
            if (!getCurrentQueue(isEven).isEmpty()) {
                currNode.next = getCurrentQueue(isEven).peek();
            }

            if (currNode.left != null) {
                getNextQueue(isEven).addLast(currNode.left);
            }

            if (currNode.right != null) {
                getNextQueue(isEven).addLast(currNode.right);
            }

            if (getCurrentQueue(isEven).isEmpty()) {
                isEven = !isEven;
            }
        }

        return root;
    }

    public Deque<Node> getCurrentQueue(boolean isEven) {
        if (isEven) {
            return evenQueue;
        }
        else {
            return oddQueue;
        }
    }

    public Deque<Node> getNextQueue(boolean isEven) {
        if (isEven) {
            return oddQueue;
        }
        else {
            return evenQueue;
        }
    }
}