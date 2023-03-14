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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<String> routes = digIn(root);
        for(String route : routes){
            sum += Integer.parseInt(route);
        }
        
        return sum;
    }
    
    private List<String> digIn(TreeNode currNode){
        List<String> routes = new ArrayList<String>();
        
        if(currNode.left == null && currNode.right == null){
            routes.add("" + currNode.val);
            return routes;
        }
        if(currNode.left != null){
            List<String> temp = digIn(currNode.left);
            temp = temp.stream()
                .map(route->"" + currNode.val+route)
                .collect(Collectors.toList());
            routes.addAll(temp);
        }
        if(currNode.right != null){
            List<String> temp = digIn(currNode.right);
            temp = temp.stream()
                .map(route->"" + currNode.val+route)
                .collect(Collectors.toList());
            routes.addAll(temp);
        }
        
        return routes;
    }
}