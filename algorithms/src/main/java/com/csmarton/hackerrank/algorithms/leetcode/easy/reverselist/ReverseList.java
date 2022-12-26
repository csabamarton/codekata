package com.csmarton.hackerrank.algorithms.leetcode.easy.reverselist;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

import java.util.Stack;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = temp;
        }

        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;
        while (current != null) {
            stack.add(current);
            current = current.next;
        }

        return buildReverse(stack);
    }

    private ListNode buildReverse(Stack<ListNode> stack) {
        if (stack.empty())
            return null;

        ListNode current = new ListNode();
        current.val = stack.pop().val;

        ListNode node = buildReverse(stack);
        if (node != null){
            current.next = node;
        }

        return current;
    }
}
