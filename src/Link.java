public class Link {


    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode quick = head;

        while ((quick!=null&&quick.next!=null)){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                break;
            }
        }

        if(quick == null||quick.next == null){
            return  null;
        }

        ListNode counter = slow;
        slow =   head ;
        quick = counter;

        while (slow!=quick){
            slow = slow.next;
            quick = quick.next;
        }

        return slow;

    }

    private class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    }
}


