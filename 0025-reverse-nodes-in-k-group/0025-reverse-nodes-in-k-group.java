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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) 
        {
            ListNode kthNode = getKthNode(temp, k);

            // Less than k nodes remaining
            if (kthNode == null) 
            {
                // Reconnect leftover (unreversed) nodes to the previous group
                if (prevNode != null) 
                {
                    prevNode.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;

            // Separate current group
            kthNode.next = null;

            // Reverse current group
            reverseLinkedList(temp);

            // Connect reversed group
            if (temp == head) 
            {
                head = kthNode;
            } 
            else 
            {
                prevNode.next = kthNode;
            }

            // temp is now the last node of reversed group
            prevNode = temp;

            // Move to next group
            temp = nextNode;
        }

        return head;
    }

    ListNode getKthNode(ListNode temp, int k) 
    {
        k = k - 1;

        while (k > 0 && temp != null) 
        {
            temp = temp.next;
            k--;
        }

        return temp;
    }

    ListNode reverseLinkedList(ListNode temp) 
    {
        ListNode prev = null;
        ListNode current = temp;

        while (current != null) 
        {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}