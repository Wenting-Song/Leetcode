Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode currA = headA;
        int countA = 0;
        while (currA != null){
            countA++;
            currA = currA.next;
        }
        ListNode currB = headB;
        int countB = 0;
        while (currB != null){
            countB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if (countA < countB){
           for (int i = 0; i < countB - countA && currB != null; i++){
               currB = currB.next;
           }
        }else{
            for (int i = 0; i < countA - countB && currA != null; i++){
                currA = currA.next;
            }
        }
        while (currA != null && currB != null){
            if (currA == currB){
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
        
    }
}


Better version:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (lenA > lenB){
            int diff = lenA - lenB;
            while (nodeA != null && diff >0){
                nodeA = nodeA.next;
                diff--;
            }
        }else{
            int diff = lenB - lenA;
            while (nodeB != null && diff >0){
                nodeB = nodeB.next;
                diff--;
            }
        }
        while (nodeA != null && nodeB != null){
            if (nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
    private int getLen(ListNode head){
        ListNode node = head;
        int len = 0;
        while (node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
