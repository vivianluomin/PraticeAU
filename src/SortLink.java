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
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
