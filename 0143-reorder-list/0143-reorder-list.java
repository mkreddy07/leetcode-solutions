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
    public void reorderList(ListNode head) 
    {

        if(head==null || head.next==null)
            return;
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while(temp!=null)
        {
            stack.push(temp);
            temp = temp.next;
        }

        temp = head;

        int n = stack.size();
        for(int i=0;i<n/2;i++)
        {
            ListNode front = temp.next;
            ListNode back = stack.pop();

             temp.next = back;
             back.next = front;

             temp = front;
        }
        temp.next = null;
    }
}
