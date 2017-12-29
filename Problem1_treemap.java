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
        Map.Entry left = tm.firstEntry();
        Map.Entry right = tm.lastEntry();
        int remainder = target - (int)left.getKey();

        while (true) {
            while (remainder < (int)right.getKey()) {
                right = tm.lowerEntry((Integer)right.getKey());
            }
            if ((int)right.getKey() == remainder) {
                return getAnswerSet(left, right);
            }

            remainder = target - (int)right.getKey();
            while (remainder > (int)left.getKey()) {
                left = tm.higherEntry((Integer)left.getKey());
            }

            if ((int)left.getKey() == remainder) {
                return getAnswerSet(left, right);
            }
            remainder = target - (int)left.getKey();
        }
    }

    static int[] getAnswerSet(Map.Entry left, Map.Entry right) {
        ArrayList<Integer> a = (ArrayList<Integer>)left.getValue();
        ArrayList<Integer> b = (ArrayList<Integer>)right.getValue();
        return (int)left.getKey() == (int)right.getKey() ?
            getOrderedSet(a.get(0), a.get(1)):
            getOrderedSet(a.get(0), b.get(0));
    }

    static int[] getOrderedSet(Integer a, Integer b) {
        return new int[]{Math.min((int)a, (int)b), Math.max((int)a, (int)b)};
    }
}
