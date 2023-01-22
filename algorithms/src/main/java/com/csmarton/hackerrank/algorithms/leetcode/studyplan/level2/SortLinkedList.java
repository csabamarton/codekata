package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (slow.next == null)
            return slow;

        fast = slow.next;
        slow.next = null;

        return fast;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode sortedList = new ListNode();
        ListNode head = sortedList;

        while (left != null && right != null) {
            if(left.val < right.val) {
                sortedList.next = left;
                left = left.next;
            } else {
                sortedList.next = right;
                right = right.next;
            }

            sortedList = sortedList.next;
        }

        if(left != null)
            sortedList.next = left;
        else
            sortedList.next = right;

        return head.next;
    }


    public ListNode sortList2(ListNode head) {

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
