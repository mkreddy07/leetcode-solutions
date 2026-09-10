class Solution 
{
    public ListNode reverseEvenLengthGroups(ListNode head) 
    {
        ListNode current = head;
        ListNode prev = null;
        int group = 1;

        while(current != null)
        {
            // Find actual size of this group
            ListNode temp = current;
            int count = 0;

            while(temp != null && count < group)
            {
                temp = temp.next;
                count++;
            }

            // If group length is even, reverse it
            if(count % 2 == 0)
            {
                ListNode groupHead = current;
                ListNode nextGroup = temp;

                ListNode reversedHead = reverse(groupHead, count);

                if(prev == null)
                {
                    head = reversedHead;
                }
                else
                {
                    prev.next = reversedHead;
                }

                groupHead.next = nextGroup;
                prev = groupHead;
                current = nextGroup;
            }
            else
            {
                // Don't reverse
                prev = current;

                for(int i = 1; i < count; i++)
                {
                    prev = prev.next;
                }

                current = temp;
            }

            group++;
        }

        return head;
    }

    public ListNode reverse(ListNode current, int n)
    {
        ListNode prev = null;

        while(current != null && n > 0)
        {
            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;

            n--;
        }

        return prev;
    }
}