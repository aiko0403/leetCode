/**
 * Problem 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = sum / 10;
        ListNode output = new ListNode(sum % 10);
        ListNode ptr = output;
        while (l1.next != null || l2.next != null) {
            if (l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
                sum = l1.val + l2.val + carry;
                carry = sum / 10;
                ListNode temp = new ListNode(sum % 10);
                ptr.next = temp;
                ptr = temp;
            } else if (l1.next != null){
                l1 = l1.next;
                sum = l1.val + carry;
                carry = sum / 10;
                ListNode temp = new ListNode(sum % 10);
                ptr.next = temp;
                ptr = temp;
            } else {
                l2 = l2.next;
                sum = l2.val + carry;
                carry = sum / 10;
                ListNode temp = new ListNode(sum % 10);
                ptr.next = temp;
                ptr = temp;
            }
        }
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            ptr.next = temp;
            ptr = temp;
        }
        return output;
    }
}
