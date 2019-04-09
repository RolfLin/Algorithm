package middle;

/**
 * Created by billlin on 2018/12/20
 */
public class AddTwoNumbers1 {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode lead = new ListNode(0);
            ListNode current = new ListNode(0);
            boolean flag = false;
            boolean first = true;
            while(l1 != null || l2 != null || flag == true){
                if(flag == true && l1 == null && l2 == null){
                    ListNode theEnd = new ListNode(1);
                    current.next = theEnd;
                    return lead;
                }
                int total;
                ListNode tmp = new ListNode(0);
                if(l1 == null){
                    total = l2.val;
                }
                else if(l2 == null){
                    total = l1.val;
                }
                else{
                    total = l1.val + l2.val;
                }
                if(flag == true){
                    total++;
                    flag = false;
                }
                if(total >= 10){
                    flag = true;
                    tmp.val = total - 10;
                }
                else{
                    tmp.val = total;
                }
                if(first == true){
                    lead = tmp;
                    current = tmp;
                    first = false;
                }else{
                    current.next = tmp;
                    current = tmp;
                }
                if(l1 == null || l1.next == null){
                    l1 = null;
                }else{
                    l1 = l1.next;
                }
                if(l2 == null || l2.next == null){
                    l2 = null;
                }else{
                    l2 = l2.next;
                }
            }
            return lead;
        }

    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
//        ListNode l3 = new ListNode(8);
//        l1.next = l3;
        AddTwoNumbers1 addTwoNumbers = new AddTwoNumbers1();
        ListNode total = addTwoNumbers.addTwoNumbers(l1 ,l2);
        while (total != null){
            System.out.println(total.val);
            total = total.next;
        }
    }
}
