package cn.penghaonan.problems;

import cn.penghaonan.ITest;
import cn.penghaonan.Logger;

public class TwoSum implements ITest {
    @Override
    public void test() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] res = twoSum(nums, target);
        Logger.log(res[0] + ", " + res[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
