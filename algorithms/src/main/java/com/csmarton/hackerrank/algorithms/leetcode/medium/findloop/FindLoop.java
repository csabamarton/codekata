package com.csmarton.hackerrank.algorithms.leetcode.medium.findloop;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

import java.util.HashSet;
import java.util.Set;

public class FindLoop {

    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;

        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode current = head;
        visitedNodes.add(current);

        while (current.next != null) {
            if (visitedNodes.contains(current.next))
                return current.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return null;

        ListNode tortoise = head;
        ListNode hare = head;

        tortoise = tortoise.next;
        hare = hare.next.next;

        while(hare != tortoise) {
            if(hare.next == null || hare.next.next == null)
                return null;

            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        hare = head;

        while (hare != tortoise) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        return tortoise;
    }


}
