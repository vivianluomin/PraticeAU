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


    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode h = null;
        RandomListNode tail = null;
        RandomListNode p = head;
        while (p!=null){
            int la= p.lable;
            RandomListNode node = new RandomListNode(la);
            node.random = p.random;
            node.next = null;
            if(h==null){
                tail = h = node;
            }else {
                tail = tail.next = node;
            }

            p = p.next;
        }

        return h;
    }

    private class RandomListNode{
        int lable;
        RandomListNode next,random;
        RandomListNode(int x){
            this.lable = x;
        }
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


