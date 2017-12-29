/**
 * Problem 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (hm.containsKey(current)) {
                return new int[]{hm.get(current), i};
            } else {
                hm.put(target-current, i);
            }
        }
        return null;
    }
}
