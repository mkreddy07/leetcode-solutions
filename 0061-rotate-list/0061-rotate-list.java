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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k==0)
            return head;
        
        int count = getLength(head);
         k = k%count;
         if(k==0)
            return head;

         head = reverse(head);
        ListNode firstPart = head;
        ListNode secondPart = head;
        for(int i=1; i<k;i++)
        {
            secondPart = secondPart.next;
        }

        ListNode remaining = secondPart.next;
        secondPart.next = null;
        firstPart = reverse(firstPart);
        remaining = reverse(remaining);

        ListNode temp = firstPart;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = remaining;

        return firstPart;   
    }

    public ListNode reverse(ListNode current)
    {
        ListNode prev  = null;
        while(current!=null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
      return prev;
    }

    public int getLength(ListNode temp)
    {
        int count = 0;
        while(temp!=null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

}