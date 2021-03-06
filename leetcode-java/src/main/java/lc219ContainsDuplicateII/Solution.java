package lc219ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

/*
219. 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。



示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(nums[j])) {
                int i = map.get(nums[j]);
                if (j - i <= k) {
                    return true;
                }
            }
            map.put(nums[j], j);
        }

        return false;
    }
}
