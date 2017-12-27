/**
 * Problem 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            tm.put(nums[i], i);
        }
        Map.Entry left = tm.firstEntry();
        Map.Entry right = tm.lastEntry();
        int remainder = target - (int)left.getKey();

        while (true) {
            while (remainder < (int)right.getKey()) {
                right = tm.lowerEntry((Integer)right.getKey());
            }
            if ((int)right.getKey() == remainder) {
                return new int[]{Math.min((int)left.getValue(), (int)right.getValue()), Math.max((int)left.getValue(), (int)right.getValue())};
            }
            remainder = target - (int)right.getKey();

            while (remainder > (int)left.getKey()) {
                left = tm.higherEntry((Integer)left.getKey());
            }
            if ((int)left.getKey() == remainder) {
                return new int[]{Math.min((int)left.getValue(), (int)right.getValue()), Math.max((int)left.getValue(), (int)right.getValue())};
            }
            remainder = target - (int)left.getKey();
        }
    }
}
