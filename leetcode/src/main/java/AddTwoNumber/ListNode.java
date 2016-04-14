package AddTwoNumber;

/**
 * Created by vivek.vanga on 14/04/16.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ListNode)) {
            return false;
        }
        ListNode node = (ListNode) o;
        return node.val == this.val &&
                ((node.next == null && this.next == null) ||(node.next != null && this.next != null && this.next.equals(node.next))  );
    }
}
