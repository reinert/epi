package io.reinert.epi.c8;

public class p2 {

    public static void main(String[] args) {
        ListNode<Integer> L = new ListNode<>(11, new ListNode<>(3, new ListNode<>(5, new ListNode<>(7, new ListNode<>(2, null)))));
        L = revertSubList(L, 2, 4);
        System.out.println(L.toString());
    }

    public static ListNode<Integer> revertSubList(ListNode<Integer> L, int s, int f) {
        if (s == f) return L;

        ListNode<Integer> dummyHead = new ListNode<>(null, L);
        ListNode<Integer> subListHead = dummyHead;

        // position the subListHead
        int k = 1;
        while (k++ < s) {
            subListHead = subListHead.next;
        }

        // reverse the subList
        ListNode<Integer> iter = subListHead.next;
        while (s++ < f) {
            ListNode<Integer> temp = iter.next;
            iter.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
        }

        return dummyHead.next;
    }
}
