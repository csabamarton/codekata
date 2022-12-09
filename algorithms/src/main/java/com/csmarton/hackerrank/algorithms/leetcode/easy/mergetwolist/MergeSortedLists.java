package com.csmarton.hackerrank.algorithms.leetcode.easy.mergetwolist;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;

public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null && list2 != null)
            return list2;
        if(list1 != null && list2 == null)
            return list1;

        return recursive(list1, list2);
    }

    ListNode recursive(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            node.val = list1.val;
            node.next = recursive(list1.next, list2);
        } else {
            node.val = list2.val;
            node.next = recursive(list1, list2.next);
        }

        return node;
    }
}
