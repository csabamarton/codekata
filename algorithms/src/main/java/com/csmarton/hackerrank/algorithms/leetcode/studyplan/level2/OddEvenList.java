package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenNodeHead = evenNode;

        while (oddNode != null) {
            if (oddNode.next == null) {
                oddNode.next = evenNodeHead;
                break;

            } else if(oddNode.next.next == null) {
                oddNode.next = evenNodeHead;

                break;
            } else {
                oddNode.next = oddNode.next.next;
                oddNode = oddNode.next;

                evenNode.next = oddNode.next;
                evenNode = evenNode.next;
            }
        }



        return head;
    }

}
