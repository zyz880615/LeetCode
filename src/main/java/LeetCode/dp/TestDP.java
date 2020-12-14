package LeetCode.dp;

import java.util.HashMap;
import java.util.Map;

public class TestDP {

    public static Map<Double,Double> result = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fib(35));
    }

    public static double fib(double n) {
        if ( n == 0) return 0;
        if ( n == 1 || n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }

    public static double fibMap(double n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (result.containsKey(n)){
            return result.get(n);
        }
        double count = fibMap(n-1) + fib(n-2);
        result.put(n,count);
        return count;
    }

}
