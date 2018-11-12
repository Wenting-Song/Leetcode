There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is 
expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 
0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a 
graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological 
ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = prerequisites.length;
        if (numCourses <= 0){
            return false;
        }
        //calculate indegree
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
            
        for (int i = 0; i < N; i++){
            inDegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < N; i++){
                if (prerequisites[i][1] == cur){
                   inDegree[prerequisites[i][0]]--;
                   if (inDegree[prerequisites[i][0]] == 0){
                       queue.offer(prerequisites[i][0]);
                   }
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++){
            if (inDegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}

Better:
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites){
            indegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int course = queue.poll();
            for (int[] p : prerequisites){
                if (p[1] == course){
                    indegree[p[0]]--;
                    if (indegree[p[0]] == 0){
                        queue.offer(p[0]);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}
