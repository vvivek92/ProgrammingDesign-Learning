package AddTwoNumber;

/**
 * Created by vivek.vanga on 14/04/16.
 */

//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8

public class AddTwoNumber {

    // assuming that both l1 and l2 are of same length.
    public ListNode add(ListNode l1, ListNode l2, int carryOver) {
        if(l1 == null && l2 == null) {
            return null;
        }
        int sum = l1.val + l2.val + carryOver;
        int unitsDigit = sum % 10;
        int tensDigit = sum / 10;
        ListNode head = new ListNode(unitsDigit);
        head.next = add(l1.next, l2.next, tensDigit);
        return head;
    }

    public static void main(String[] args) {
        // test1
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        ListNode result = new AddTwoNumber().add(list1,list2,0);
        ListNode expectedResult = new ListNode(7);
        expectedResult.next = new ListNode(0);
        expectedResult.next.next = new ListNode(8);
        assert expectedResult.equals(result);

        //test2
//        list1 = new ListNode(1);
//        list1.next = new ListNode(8);
//        list2 = new ListNode(0);
//        result = new AddTwoNumber().add(list1,list2,0);
//        expectedResult = new ListNode(1);
//        expectedResult.next = new ListNode(8);
//        assert expectedResult.equals(result);

        System.out.println("tests passed");


    }
}

