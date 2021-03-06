We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.

Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:

Given the 8 x 8 grid below, we want to construct the corresponding quad tree:



It can be divided according to the definition above:



 

The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.

For the non-leaf nodes, val can be arbitrary, so it is represented as *.



Note:

N is less than 1000 and guaranteened to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return build(grid, 0, 0, n-1, n-1);
    }
    private Node build(int[][] grid, int r1, int c1, int r2, int c2){
        if (c1 > c2 || r1 > r2){
            return null;
        }
        boolean isLeaf = true;
        int val = grid[r1][c1];
        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j++){
                if (grid[i][j] != val){
                    isLeaf = false;
                }
            }
        }
        if (isLeaf){
            return new Node(val==1, isLeaf, null, null, null, null);
        }
        int rowMid = (r1 + r2)/2;
        int colMid = (c1 + c2)/2;
        Node topLeft = build(grid, r1, c1, rowMid, colMid);
        Node topRight = build(grid, r1, colMid + 1, rowMid, c2);
        Node bottomLeft = build(grid, rowMid + 1, c1, r2, colMid);
        Node bootmRight = build(grid, rowMid + 1, colMid + 1, r2, c2);
        return new Node(false, false, topLeft, topRight, bottomLeft, bootmRight);
    }
}
