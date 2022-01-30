package com.csmarton.hackerrank.interviewkit.sorting.playercomparator;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        int compare = Integer.valueOf(a.getScore()).compareTo(b.getScore()) * -1;
        if(compare == 0)
            return a.getName().compareTo(b.getName());
        return compare;
    }
}
