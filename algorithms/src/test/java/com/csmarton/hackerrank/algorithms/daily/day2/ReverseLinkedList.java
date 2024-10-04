package com.csmarton.hackerrank.algorithms.daily.day2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;

            prev = head;
            head = next;
        }

        return prev;
    }
}
