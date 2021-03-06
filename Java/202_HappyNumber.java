Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number 
equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. T
hose numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1){
            n = getDigit(n);
            if (n == 1){
                return true;
            }
            if (set.contains(n)){
                return false;
            }else{
                set.add(n);
            }
        }
        return true;
    }
    private int getDigit(int n){
        int ans = 0;
        while (n != 0){
            int temp = n % 10;
            ans += temp * temp;
            n /= 10;
        }
        return ans;
    /*    List<Integer> digits = new ArrayList<>();
        while (n != 0){
            digits.add(n%10);
            n /= 10;
        }
        int ans = 0;
        for (Integer i : digits){
            ans += i * i;
        }
        return ans;*/
    }
}
