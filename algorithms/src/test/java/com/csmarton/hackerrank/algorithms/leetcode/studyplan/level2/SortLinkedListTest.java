package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortLinkedListTest {

    private final SortLinkedList sortLinkedList = new SortLinkedList();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(createListNode(List.of(-1,5,3,4,0)), createListNode(List.of(-1,0,3,4,5))),
                Arguments.of(createListNode(List.of(4,2,1,3)), createListNode(List.of(1,2,3,4)))
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
    void testMakeSortedLists(ListNode list, ListNode expectedResult) {
        ListNode result = sortLinkedList.sortList(list);

        assertEquals(expectedResult, result);
    }
}