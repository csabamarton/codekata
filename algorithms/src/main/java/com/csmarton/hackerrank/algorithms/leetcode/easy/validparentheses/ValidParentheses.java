package com.csmarton.hackerrank.algorithms.leetcode.easy.validparentheses;

import java.util.Stack;

public class ValidParentheses {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
     */

    private enum Bracket {
        SIMPLE('(', ')'),
        SQUARE('[', ']'),
        DUCK('{','}');

        private final char openBracket;
        private final char closeBracket;

        Bracket(char openBracket, char closeBracket) {
            this.openBracket = openBracket;
            this.closeBracket = closeBracket;
        }

        boolean isTheSame(Bracket otherBracket) {
            return otherBracket.openBracket == this.openBracket && otherBracket.closeBracket == this.closeBracket;
        }
    }

    public boolean isValid(String input) {

        Stack<Bracket> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char value = input.charAt(i);

            for (Bracket bracket : Bracket.values()) {
                if (bracket.closeBracket == value) {
                    if (stack.isEmpty())
                        return false;
                    Bracket topBracket = stack.pop();
                    if (!topBracket.isTheSame(bracket))
                        return false;
                } else if (bracket.openBracket == value) {
                    stack.add(bracket);
                    break;
                }
            }
        }

        return stack.isEmpty();
    }
}
