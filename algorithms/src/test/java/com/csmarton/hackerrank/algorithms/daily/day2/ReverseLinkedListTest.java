package com.csmarton.hackerrank.algorithms.daily.day2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseLinkedListTest {

    private final ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

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

    @ParameterizedTest
    @MethodSource("reverseLinkedListProvider")
    void testReverseLinkedList(int[] input, int[] expected) {
        ListNode inputList = arrayToList(input);
        ListNode expectedList = arrayToList(expected);

        ListNode result = reverseLinkedList.reverseList(inputList);

        assertArrayEquals(listToArray(expectedList), listToArray(result));
    }

    private static Stream<Arguments> reverseLinkedListProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
}
