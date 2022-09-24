package com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest
{
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    private static ListNode createListNode(int num) {

        String s = Integer.toString(num);
        ListNode baseNode = new ListNode();
        baseNode.val = s.charAt(0) - '0';

        baseNode = fillNode(s.toCharArray(), 0, baseNode);

        return baseNode;
    }

    private static ListNode fillNode(char[] nums, int index, ListNode node) {
        node = new ListNode();
        node.val = nums[index] - '0';
        if(nums.length - 1 > index)
            node.next = fillNode(nums, index + 1, node.next);

        return node;
    }

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(createListNode(9999999), createListNode(9999), createListNode(10009998)),
                Arguments.of(createListNode(243), createListNode(564), createListNode(708))
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(ListNode num1, ListNode num2, ListNode expetedSum) {
        ListNode listNode = addTwoNumbers.addTwoNumbers(num1, num2);


        assertEquals(expetedSum, listNode);
    }
}

