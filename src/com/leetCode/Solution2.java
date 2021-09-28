package com.leetCode;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode l1 = s.numtoListNode(2345);
        ListNode l2 = s.numtoListNode(1111);


        s.soutList(s.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            if(carry==1){
                cur.next = new ListNode(carry);
            }
        }
        return pre.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        return numtoListNode(arrtoNum(listtoArr(l1)) + arrtoNum(listtoArr(l2)));
    }

    public int getSize(ListNode l1) {
        if (l1 == null) {
            return 0;
        }
        int i = 0;
        while (l1.next != null) {
            l1 = l1.next;
            i += 1;
        }
        return i;
    }

    public int[] listtoArr(ListNode l1) {
        if (l1 == null) {
            return null;
        }
        int[] arr = new int[getSize(l1)];
        int i = 0;
        while (l1.next != null) {
            arr[i] = l1.val;
            i += 1;
        }
        return arr;
    }

    public int arrtoNum(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i] * (int) Math.pow(10, i);
        }
        return sum;
    }

    public ListNode numtoListNode(int num) {
        String s = null;
        String ss = s.valueOf(num);
        char[] c = ss.toCharArray();
        int[] arr = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            arr[i] = c[i] - '0';
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = arr.length - 1; i > 0; i--) {
            temp.next = new ListNode();
            temp.val = arr[i];
            temp = temp.next;
        }
        temp.val = arr[0];
        return head;
    }

    public void soutList(ListNode listNode) {
        if (listNode == null) return;
        while (listNode != null) {
            if (listNode.next == null) {
                System.out.print(listNode.val);
                return;
            }
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
