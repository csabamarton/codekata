package com.csmarton.hackerrank.algorithms.leetcode.easy.palindrome;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class LinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(head.val);

        while(head.next != null) {
            head = head.next;
            numbers.add(head.val);
        }

        int i = 0;
        int j = numbers.size() - 1;

        while(j >= i) {
            if(numbers.get(i) != numbers.get(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
