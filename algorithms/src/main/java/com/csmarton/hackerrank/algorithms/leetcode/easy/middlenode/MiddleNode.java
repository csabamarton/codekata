package com.csmarton.hackerrank.algorithms.leetcode.easy.middlenode;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode tempNode = head;
        int numOfNodes = 1;

        while(tempNode.next != null) {
            numOfNodes++;
            tempNode = tempNode.next;
        }

        int middleNodeIndex = numOfNodes / 2;
        tempNode = head;

        for(int i = 0; i < middleNodeIndex; i++) {
            tempNode = tempNode.next;
        }

        return tempNode;
    }
}
