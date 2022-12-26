package com.csmarton.hackerrank.algorithms.leetcode.easy.mergetwolist;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedListsTest {
    MergeSortedLists mergeSortedLists = new MergeSortedLists();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(createListNode(List.of(1, 2, 4)), createListNode(List.of(1,3,4)), createListNode(List.of(1,1,2,3,4,4)))
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
    void testMergingTwoSortedLists(ListNode list1, ListNode list2, ListNode expectedResult) {
        ListNode result = mergeSortedLists.mergeTwoLists2(list1, list2);

        assertEquals(expectedResult, result);
    }

}