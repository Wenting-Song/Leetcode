N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.

https://leetcode.com/problems/couples-holding-hands/discuss/117520/Java-union-find-easy-to-understand-5-ms
Union Find  Cyclic swap
class Solution {
    class UF {
        int[] parent;
        int count;
        public UF (int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
            count = n;
        }
        public int find (int x){
            if (parent[x] == x){
                return x;
            }
            return find(parent[x]);
        }
        public void union (int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                parent[rootY] = rootX;
                count--;
            }
        }
    }
    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        UF uf = new UF(N);
        for (int i = 0; i < N; i++){
            int x = row[2*i];
            int y = row[2*i+1];
            uf.union(x/2, y/2);
        }
        return N - uf.count;
    }
}
