package MergePointForTwoLists;

/**
 * Created by vivek.vanga on 19/04/16.
 */
public class MergePointForTwoLists {

    // assumption is head1, head2 are not null and are different. Otherwise behaviour is undefined.
    public Node find(Node a, Node b) {
        Node aIterator = a;
        Node bIterator = b;
        while(aIterator!= null && bIterator != null) {
            aIterator = aIterator.next;
            bIterator = bIterator.next;
        }

        if(aIterator != null) {
            // a list is longer
            int k = lengthOfList(aIterator);
            aIterator = a;
            for(int i=0;i<k;i++) {
                aIterator = aIterator.next;
            }
            bIterator = b;
        } else if(bIterator !=null) {
            // b list is longer
            int k = lengthOfList(bIterator);
            bIterator = b;
            for(int i=0;i<k;i++) {
                bIterator = bIterator.next;
            }
            aIterator = a;
        } else {
            // lists are of same length
            aIterator = a;
            bIterator = b;
        }
        // the list pointed to by aIterator and by bIterator are of same length.
        Node mergePoint = null;

        while(true) {
            if(aIterator == bIterator) {
                mergePoint = aIterator;
                break;
            }
            // if aIterator is not null, bIterator will be non null.
            if(aIterator!=null) {
                aIterator = aIterator.next;
                bIterator = bIterator.next;
            } else {
                break;
            }
        }
        return mergePoint;
    }

    int lengthOfList(Node list) {
        int length = 0;
        while(list != null) {
            length+=1;
            list = list.next;
        }
        return length;
    }



    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node x = new Node("x");
        Node y = new Node("y");
        Node z = new Node("z");
        Node p = new Node("p");
        Node q = new Node("q");
        a.next = b;
        b.next = c;
        c.next = x;
        x.next = y;
        y.next = z;
        z.next = null;

        p.next = q;
        q.next = x;


        Node mergePoint = new MergePointForTwoLists().find(a,p);
        System.out.println(mergePoint.value);
        assert "x".equals(mergePoint.value);
        System.out.println("tests passed");
    }
}
