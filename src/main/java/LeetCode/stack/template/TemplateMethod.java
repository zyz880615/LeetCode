package LeetCode.stack.template;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 * 单调栈模版解法
 */
public class TemplateMethod {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1)));

    }

    public static int[] nextGreaterElement(int[] nums1){
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=nums1.length-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums1[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1:stack.peek();
            stack.push(nums1[i]);
        }

        return res;
    }

}
