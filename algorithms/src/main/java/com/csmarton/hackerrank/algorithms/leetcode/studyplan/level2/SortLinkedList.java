package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

public class SortLinkedList {

    public ListNode sortList(ListNode head) {

        ListNode searchNode = head;

        ListNode sortedListHead = null;
        ListNode sortedListTail = null;


        ListNode prev = null;

        while (searchNode != null) {
            ListNode minNode = findMinNode(searchNode, prev);

            if (sortedListHead == null) {
                sortedListHead = minNode;
                sortedListTail = minNode;
            } else {
                sortedListTail.next = minNode;
                sortedListTail = sortedListTail.next;
            }

            if(minNode == searchNode) {
                searchNode = searchNode.next;
            }
        }

        return sortedListHead;
    }

    private ListNode findMinNode(ListNode head, ListNode prev) {
        ListNode minNode = head;
        while (head.next != null) {
            if (head.next.val < minNode.val) {
                minNode = head.next;
                prev = head;
            }
            head = head.next;
        }

        if(prev != null) {
            prev.next = minNode.next;
        }
        return minNode;
    }

}
