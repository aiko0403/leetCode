/**
 * Problem 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (tm.containsKey(nums[i])) {
                tm.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                tm.put(nums[i], list);
            }
        }
        Integer left = tm.firstKey();
        Integer right = tm.lastKey();

        while (left < right && (left + right != target)) {
            int sum = left + right;
            if (sum > target) {
                right = tm.lowerKey(right);
            } else {
                left = tm.higherKey(left);
            }
        }
        return getAnswerSet(left, right, tm);
    }

    static int[] getAnswerSet(Integer left, Integer right, TreeMap<Integer, ArrayList<Integer>> tm) {
        ArrayList<Integer> a = tm.get(left);
        ArrayList<Integer> b = tm.get(right);
        return left == right ?
            getOrderedSet(a.get(0), a.get(1)):
            getOrderedSet(a.get(0), b.get(0));
    }

    static int[] getOrderedSet(Integer a, Integer b) {
        return (a > b) ? new int[]{b, a} : new int[]{a, b};
    }
}
