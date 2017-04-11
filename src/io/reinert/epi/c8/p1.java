package io.reinert.epi.c8;

public class p1 {

    public static void main(String[] args) {
        ListNode<Integer> L1 = new ListNode<>(2, new ListNode<>(5, new ListNode<>(7, null)));
        ListNode<Integer> L2 = new ListNode<>(3, new ListNode<>(11, null));
        ListNode<Integer> L = mergeTwoSortedLists(L1, L2);
        System.out.println(L.toString());
    }

    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                        ListNode<Integer> L2) {
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> current = dummyHead;
        ListNode<Integer> p1 = L1, p2 = L2;

        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        current.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }
}
