package com.csmarton.hackerrank.algorithms.daily.day2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {

    private final LinkedListCycle linkedListCycle = new LinkedListCycle();

    private ListNode createListWithCycle(int[] values, int pos) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleStart = null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleStart = current;
            }
        }

        if (pos >= 0) {
            current.next = cycleStart;
        }

        return head;
    }

    private static Stream<Arguments> cycleTestCasesProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 0, -4}, 1, true),  // Cycle at index 1
                Arguments.of(new int[]{1, 2}, 0, true),         // Cycle at index 0
                Arguments.of(new int[]{1}, -1, false),          // No cycle
                Arguments.of(new int[]{}, -1, false)            // Empty list, no cycle
        );
    }

    @ParameterizedTest
    @MethodSource("cycleTestCasesProvider")
    void testHasCycle(int[] listArray, int pos, boolean expected) {
        ListNode head = createListWithCycle(listArray, pos);

        boolean result = linkedListCycle.hasCycle(head);

        assertEquals(expected, result);
    }


}
