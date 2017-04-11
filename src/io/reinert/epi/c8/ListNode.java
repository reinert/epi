package io.reinert.epi.c8;

class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data + " -> " + (this.next == null ? "nil" : this.next.toString());
    }

    public static ListNode search(ListNode L, Object key) {
        while (L != null && L.data != key) {
            L = L.next;
        }
        // If key was not present in the list, L will have become null.
        return L;
    }

    // Insert newNode after node.
    public static void insertAfter(ListNode node,
                                   ListNode newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    // Delete the node immediately following aNode. Assumes aNode is not a tail.
    public static void deleteList(ListNode aNode) {
        aNode.next = aNode.next.next ;
    }

    public static String toString(ListNode L) {
        final StringBuilder sb = new StringBuilder();
        String sep = "";
        while (L.next != null) {
            sb.append(sep).append(L.data);
            sep = " -> ";
            L = L.next;
        }
        return sb.toString();
    }
}


