package nowCoder.array;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-12 16:56
 **/
public class FindKthToTail {
    /**
     * 题目描述：输入一个链表，输出该链表中倒数第k个结点。
     *
     * 思路：空间换时间最快，空间O(n), 时间O(n)。两个指针相差K步往后遍历，当远的指针到达尾部时，
     * 近的指针到达倒数第K个节点
     */

    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        int n = 0;
        ListNode index = head, index2 = head;
        while(index != null){
            if(n >= k){
                index2 = index2.next;
            }
            else{
                n++;
            }
            index = index.next;
        }
        if(n < k){
            ListNode cur = null;
            return cur;
        }
        return index2;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(FindKthToTail(listNode, 1).val);
    }
}
