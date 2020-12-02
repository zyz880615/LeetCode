package LeetCode.stack.LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode739 {

    public static void main(String[] args) {
        int num[] = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(num)));
    }

    public static int[] dailyTemperatures(int[] T){
        int res[] = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=T.length-1; i >=0; i--){
            while (!stack.empty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return res;
    }

}
