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

            Deque<Node> currQueue = getCurrentQueue(isEven);
            Deque<Node> nextQueue = getNextQueue(isEven);
            Node currNode = currQueue.poll();
            
            if (!currQueue.isEmpty()) {
                currNode.next = currQueue.peek();
            }

            if (currNode.left != null) {
                nextQueue.addLast(currNode.left);
                nextQueue.addLast(currNode.right);
            }

            if (currQueue.isEmpty()) {
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