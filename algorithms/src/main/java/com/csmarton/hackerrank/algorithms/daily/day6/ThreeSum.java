package com.csmarton.hackerrank.algorithms.daily.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                }

                if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return triplets;
    }
}
