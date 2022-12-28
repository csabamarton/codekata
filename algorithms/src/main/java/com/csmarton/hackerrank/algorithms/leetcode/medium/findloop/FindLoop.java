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
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        sb.append(current.hashCode());
        while (current.next != null) {
            current = current.next;
            if (sb.indexOf(String.valueOf(current.next.hashCode())) != -1)
                return current.next;
            sb.append(current.hashCode());
        }

        return null;
    }


}
