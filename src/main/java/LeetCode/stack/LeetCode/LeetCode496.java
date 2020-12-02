package LeetCode.stack.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode496题
 */
public class LeetCode496 {

    public static void main(String[] args) {
        int []num1 = {2,4};
        int []num2 = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(num1,num2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[nums1.length];
        for (int i=0; i<nums2.length; i++){
            while (!stack.isEmpty() && stack.peek() <= nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.empty()){
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++){
            res[i]= map.get(nums1[i]);
        }

        return res;
    }



}
