package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

import java.util.List;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        head = reverseListWithSkip(head, null);

        return reverseListWithSkip(head, n);
    }

    private ListNode reverseListWithSkip(ListNode head, Integer skip) {
        ListNode prev = null;
        ListNode curr = head;

        int counter = 1;

        while (curr != null) {
            if(skip != null && counter == skip) {
                curr = curr.next;
                continue;
            }

            ListNode temp = curr.next;
            curr.next = prev;


            prev = curr;
            curr = temp;
        }

        return prev;
    }

}

