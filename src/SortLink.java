public class SortLink {

    public ListNode sortList(ListNode head){

        quickSort(head,null);

        return head;

    }

    public ListNode getPoint(ListNode start,ListNode end){
        if(start == null){
            return start;
        }
        int key = start.val;
        ListNode i = start;
        ListNode j = start.next;
        while (j!=end){
            if(key>j.val){
                i = i.next;
                int v = i.val;
                i.val = j.val;
                j.val = v;
            }

            j = j.next;
        }

        int v = i.val;
        i.val = key;
        start.val = v;

        return i;
    }

    public void quickSort(ListNode start,ListNode end){
        if(start!=end){
            ListNode ponit = getPoint(start,end);
            quickSort(start,ponit);
            quickSort(ponit.next,end);
        }

    }

    public ListNode insertionSortList(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        ListNode h ;
        ListNode pre ;
        ListNode help = new ListNode(0);//辅助结点
        help.next = null;
        h = head;
        while(h!=null){
            ListNode next = h.next;
            pre = help;
            while (pre.next!=null && pre.next.val<h.val){
                pre = pre.next;
            }
            h.next = pre.next;
            pre.next = h;
            h = next;
        }

        return help.next;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
