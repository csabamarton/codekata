package com.csmarton.hackerrank.algorithms.daily.day2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

public class MergeTwoSortedLists {
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode fixedHead = new ListNode();
        ListNode head = fixedHead;

        while (node1 != null && node2 != null) {

            ListNode temp = new ListNode();
            if (node1.val < node2.val) {
                temp.val = node1.val;
                node1 = node1.next;
            } else {
                temp.val = node2.val;
                node2 = node2.next;
            }

            head.next = temp;

            head = temp;
        }

        if(node1 != null) {
            head.next = node1;
        } else
            head.next = node2;

        return fixedHead.next;
    }
}
