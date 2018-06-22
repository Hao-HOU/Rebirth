package difficulty.medium;

import common.ListNode;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/21 22:35
 */
public class P002AddTwoNumbers {
    public static void main(String[] args) {

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addListElementwise(l1, l2, 0);
    }

    private static ListNode addListElementwise(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = 0;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }
        sum += carry;

        ListNode current = new ListNode(sum % 10);
        current.next = addListElementwise(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
        return current;
    }
}
