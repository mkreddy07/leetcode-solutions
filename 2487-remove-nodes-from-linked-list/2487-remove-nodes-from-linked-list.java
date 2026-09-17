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
    public ListNode removeNodes(ListNode head) {
        ListNode temp = head;
       
        Deque<ListNode> stack = new ArrayDeque<>();
        
        while(temp!=null){
            while(!stack.isEmpty() && stack.peek().val<temp.val)
            {
                stack.pop();
            }
            stack.push(temp);
            temp = temp.next;
        }

        ListNode newHead = null;
        while(!stack.isEmpty())
        {
           ListNode node = stack.pop();
            node.next = newHead;
            newHead = node;
        }   
        return newHead;
        
    }
}