package com.csmarton.hackerrank.algorithms.daily.day2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
