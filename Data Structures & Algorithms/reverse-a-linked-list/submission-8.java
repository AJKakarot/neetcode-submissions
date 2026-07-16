class Solution {

    public ListNode reverseList(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while( != null){

             ListNode  next = curr.next;
             curr.next = prev;
             prev=curr;
             curr=next;



        }




    }
}