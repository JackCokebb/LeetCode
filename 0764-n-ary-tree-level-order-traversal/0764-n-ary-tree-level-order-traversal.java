/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    Deque<NodeExt> queue = new ArrayDeque<>();

    public List<List<Integer>> levelOrder(Node root) {

        int currDepth = 0;
        List<List<Integer>> answer = new ArrayList<>();

        if (root == null) {
            return answer;
        }

        queue.addLast(new NodeExt(root, currDepth));
        List<Integer> depthNums = new ArrayList<>();

        while (!queue.isEmpty()) {
            NodeExt currNode = queue.pollFirst();

            if (currNode.depth > currDepth) {
                answer.add(depthNums);
                depthNums = new ArrayList<>();
                currDepth++;
            }

            for (Node child : currNode.children) {
                queue.addLast(new NodeExt(child, currDepth + 1));
            }

            depthNums.add(currNode.val);
        }

        answer.add(depthNums);
        return answer;
    }

    public static class NodeExt extends Node {

        public int depth;

        public NodeExt(Node node, int depth) {

            super(node.val, node.children);
            this.depth = depth;
        }
    }
}