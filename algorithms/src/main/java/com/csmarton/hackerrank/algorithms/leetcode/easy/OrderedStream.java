package com.csmarton.hackerrank.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderedStream {
    private int ptr = 0;
    private Map<Integer, String> map = new HashMap<>();
    public OrderedStream(int n) {
    }

    public List<String> insert(int idKey, String value) {
        this.map.put(idKey, value);

        boolean endOfStream = false;
        int index = ptr + 1;

        while(!endOfStream) {
            if(!map.containsKey(index))
                break;
            else
                index++;
        }

        List<String> list = new ArrayList<>();

        if(index > ptr + 1) {
            for (int i = ptr + 1; i < index; i++) {
                list.add(map.get(i));
            }
            ptr = index - 1;
        }

        return list;
    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);

        os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
        os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
        os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].

        System.out.println("");
    }
}