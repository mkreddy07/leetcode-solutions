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
class Solution 
{
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1;i<left; i++)
        {
            prev = prev.next;
        }
        ListNode current = prev.next;

        ListNode subListedHead = current;
        ListNode preNode = null;

       for(int i=0; i<right-left+1; i++)
        {
            ListNode next = current.next;
            current.next = preNode;
            preNode = current;
            current = next;  
        }

        prev.next = preNode;
        subListedHead.next = current;


        return dummy.next;
    }
}