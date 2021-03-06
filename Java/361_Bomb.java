Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3 
Explanation: For the given grid,

0 E 0 0 
E 0 W E 
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.

Method 1: Brute Force
Time compleixty: O(mn * (m+n))
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == '0'){
                    int num = count(grid, i, j);
                    res = Math.max(res, num);
                }
            }
        }
        return res;
    }
    private int count(char[][] grid, int row, int col){
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int i = row;
        while (i >= 0){
            if (grid[i][col] == 'E'){
                res++;
            }else if (grid[i][col] == 'W'){
                break;
            }
            i--;
        }
        i = row;
        while (i < m){
            if (grid[i][col] == 'E'){
                res++;
            }else if (grid[i][col] == 'W'){
                break;
            }
            i++;
        }
        int j = col;
        while (j >= 0){
            if (grid[row][j] == 'E'){
                res++;
            }else if (grid[row][j] == 'W'){
                break;
            }
            j--;
        }
        j = col;
        while (j < n){
            if (grid[row][j] == 'E'){
                res++;
            }else if (grid[row][j] == 'W'){
                break;
            }
            j++;
        }
        return res;
    }
}

