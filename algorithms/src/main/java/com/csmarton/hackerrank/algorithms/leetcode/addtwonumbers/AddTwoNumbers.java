package com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode sumNode = recurciveAdd(node1, node2, false);

        return sumNode;
    }

    private ListNode recurciveAdd(ListNode node1, ListNode node2, boolean remain) {
        int sum = ((node1 != null) ? node1.val : 0) + ((node2 != null) ? node2.val : 0);

        ListNode sumNode = new ListNode();
        sumNode.val = remain ? sum + 1 : sum;
        if(sumNode.val > 9) {
            remain = true;
            sumNode.val = sumNode.val - 10;
        } else remain = false;



        if ((node1 == null || node1.next == null) && (node2 == null || node2.next == null)) {
            if(remain) {
                sumNode.next = new ListNode(1);
            }
            return sumNode;
        }
        sumNode.next = recurciveAdd(node1 == null ? null : node1.next, node2 == null ? null : node2.next, remain);

        return sumNode;
    }
}
