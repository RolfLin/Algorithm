package company.kuaishou.intern.tree;

import java.util.*;

public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    private static int lastVisit = Integer.MIN_VALUE;

    public static boolean isBST(Node root) {
        if (root == null) return true;

        boolean judgeLeft = isBST(root.left); // 先判断左子树

        if (root.data >= lastVisit && judgeLeft) { // 当前节点比上次访问的数值要大
            lastVisit = root.data;
        } else {
            return false;
        }

        boolean judgeRight = isBST(root.right); // 后判断右子树

        return judgeRight;
    }


    public static boolean isBST2(Node head) {
        if(head != null) {
            Stack<Node> stack = new Stack<>();
            int pre = Integer.MIN_VALUE;
            while (!stack.isEmpty() || head != null) {
                if(head != null) {
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    if(head.data < pre) {
                        return false;
                    }
                    pre = head.data;
                    head = head.right;
                }
            }
        }
        return true;
    }

    public static Node bulidTree(int a[]) {
        Node root = new Node(a[0]);
        Queue<Node> list = new LinkedList<>();
        int index = 1;
        list.offer(root);
        while(index < a.length) {
            Node node = list.poll();
            Node l = new Node(a[index++]);
            Node r = new Node(a[index++]);
            node.left = l;
            node.right = r;
            list.offer(l);
            list.offer(r);
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        if(strs[0] == "None") {
            System.out.println("True");
            return;
        }
        int[] arr = new int[strs.length];
        int index = 0;
        for(String s : strs) {
            arr[index++] = Integer.parseInt(s);
        }
        Node node = bulidTree(arr);
        boolean res = isBST2(node);
        if(res == true) {
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}