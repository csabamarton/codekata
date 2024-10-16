package com.csmarton.hackerrank.algorithms.leetcode.easy.reverselist;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import com.csmarton.hackerrank.algorithms.leetcode.easy.mergetwolist.MergeSortedLists;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseListTest {
    ReverseList reverseList = new ReverseList();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(createListNode(List.of(1, 2, 3, 4, 5)), createListNode(List.of(5, 4, 3, 2, 1)))
        );
    }

    private static ListNode createListNode(List<Integer> numbers) {
        return recursive(0, numbers);
    }

    private static ListNode recursive(int index, List<Integer> numbers) {
        ListNode node = new ListNode(numbers.get(index));

        if(index < numbers.size() - 1)
            node.next = recursive(++index, numbers);

        return node;
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testReverseSortedLists(ListNode list, ListNode expectedResult) {
        ListNode result = reverseList.reverseList(list);

        assertEquals(expectedResult, result);
    }
}