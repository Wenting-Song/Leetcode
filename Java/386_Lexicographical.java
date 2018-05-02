Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

https://leetcode.com/problems/lexicographical-numbers/discuss/86242/Java-O(n)-time-O(1)-space-iterative-solution-130ms
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i <= n; i++){
            result.add(curr);
            if (curr * 10 <= n){
                curr *= 10;
            }else if (curr % 10 != 9 && curr + 1 <= n){
                curr++;
            }else{
                while ((curr/10) % 10 == 9){
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return result;
    }
}
