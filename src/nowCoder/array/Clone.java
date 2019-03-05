package nowCoder.array;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-19 14:20
 **/
public class Clone {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode cur = pHead;
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = pHead;
        while(cur != null){
            if(cur.random == null){
                cur.next.random = null;
            }else{
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode res = pHead.next;
        RandomListNode resHead = pHead.next;
        cur = pHead;
        while(res != null){
            cur.next = res.next;
            cur = cur.next;
            if(cur != null){
                res.next = cur.next;
            }
            res = res.next;
        }
        return resHead;
    }

    public static void main(String[] args) {
        RandomListNode cur = new RandomListNode(1);
        RandomListNode cur2 = new RandomListNode(2);
        RandomListNode cur3 = new RandomListNode(3);
        RandomListNode cur4 = new RandomListNode(4);
        RandomListNode cur5 = new RandomListNode(5);
        cur.next = cur2;
        cur2.next = cur3;
        cur3.next = cur4;
        cur4.next = cur5;
        cur.random = cur3;
        cur2.random = cur5;
        cur3.random = null;
        cur4.random = cur2;
        cur5.random = null;
        RandomListNode res = Clone(cur);
        RandomListNode c = res;
        while(res != null){
            System.out.print(res.label);
            res = res.next;
        }
        System.out.println();
        res = c;
        while(res != null){
            if(res.random == null){
                System.out.print('#');
            }else{
                System.out.print(res.random.label);
            }
            res = res.next;
        }

    }
}
