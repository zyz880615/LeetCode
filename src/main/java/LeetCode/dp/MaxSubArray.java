package LeetCode.dp;

/**
 * 求最大连续子数组和
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,1,3,-1,2,-4,2};
        System.out.println(calMaxSubArray(nums));
    }

    public static int calMaxSubArray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int res = Integer.MIN_VALUE;

        int n = nums.length;

        int dp_0 = nums[0];

        int dp_1 = 0;

        for (int i = 0; i < n; i++ ){
            dp_1 = Math.max(dp_0, dp_0 + nums[i]);
            dp_0 = dp_1;
            res = Math.max(res,dp_1);
        }

        return res;

    }

}
