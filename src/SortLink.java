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

    public void reorderList(ListNode head) {
        ListNode h = head;
        ListNode hh = null;
        if(head == null ||head.next == null){
            return;
        }
        int n = 0;
        while (h!=null){
            ListNode x = new ListNode(h.val);
            h = h.next;
            x.next = hh;
            hh = x;
            n++;
        }

        int mid = n/2;

        ListNode reh = null;
        ListNode p = null;
        h = head;
        for(int i = 0;i<mid;i++){
            if(reh == null){
                p = reh = h;
                h = h.next;
                p =  p.next = hh;
            }else {
                p = p.next = h;
                h = h.next;
                p = p.next = hh;
            }

            hh = hh.next;
            p.next = null;
        }
        if(n- mid*2 !=0){

            p =p.next = h;
            h= h.next;
            p.next = null;
        }

        head = reh;


    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        ListNode node = new ListNode(3);
        head.next = next;
        next.next = node;
        node.next = null;
        new SortLink().reorderList(head);
        while (head!=null){

            System.out.println(head.val);
            head = head.next;
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
