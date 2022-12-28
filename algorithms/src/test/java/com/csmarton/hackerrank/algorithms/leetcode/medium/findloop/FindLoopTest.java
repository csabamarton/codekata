package com.csmarton.hackerrank.algorithms.leetcode.medium.findloop;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindLoopTest {

    private final FindLoop findLoop = new FindLoop();

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
                Arguments.of(createListNode(3204), null)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(ListNode node, ListNode expetedNode) {
        ListNode listNode = findLoop.detectCycle(node) ;

        assertEquals(expetedNode, listNode);
    }
}