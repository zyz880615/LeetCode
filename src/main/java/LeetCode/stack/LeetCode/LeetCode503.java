package LeetCode.stack.LeetCode;

import java.util.Stack;

public class LeetCode503 {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=2*n-1; i>=0; i--){
            while (!stack.empty() && stack.peek() <= nums[i % n]){
                stack.pop();
            }
            res[i % n] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
