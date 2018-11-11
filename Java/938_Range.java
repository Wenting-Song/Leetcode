Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 

Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.

Method 1: recusion
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        if (root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, root.val) + rangeSumBST(root.right, root.val, R);
    }
}

Method 2: in order traversal
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int sum = 0;
        boolean startAdd = false;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i) == L){
                startAdd = true;
            }
            if (startAdd == true){
                sum += list.get(i);
            }
            if (list.get(i) == R){
                startAdd = false;
            }
        }
        return sum;
    }
    private void inOrder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
