/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {   

        if(head == null)
            return null;

        ListNode p1 = head;

        while(p1.next!=null)
        {
            if(p1.val==p1.next.val)
            {
                p1.next = p1.next.next;
            }
            else
            {
                p1 = p1.next;
            }
        }

        return head;
        
    }
}