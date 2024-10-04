package com.csmarton.hackerrank.algorithms.daily.day2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// Test class for Merge Two Sorted Lists problem
class MergeTwoSortedListsTest {

    private final MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    private ListNode arrayToList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private int[] listToArray(ListNode head) {
        if (head == null) return new int[]{};

        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] result = new int[size];
        temp = head;
        int index = 0;
        while (temp != null) {
            result[index++] = temp.val;
            temp = temp.next;
        }

        return result;
    }

    private static Stream<Arguments> mergeTwoSortedListsProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{5}, new int[]{1, 2, 3}, new int[]{1, 2, 3, 5}),
                Arguments.of(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}, new int[]{1, 2, 3, 4, 5, 6, 7, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("mergeTwoSortedListsProvider")
    void testMergeTwoSortedLists(int[] list1Array, int[] list2Array, int[] expectedArray) {
        ListNode list1 = arrayToList(list1Array);
        ListNode list2 = arrayToList(list2Array);
        ListNode expected = arrayToList(expectedArray);

        ListNode result = mergeTwoSortedLists.merge(list1, list2);

        assertArrayEquals(listToArray(expected), listToArray(result));
    }

}

