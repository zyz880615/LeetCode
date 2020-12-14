package LeetCode.dp.coins;

import java.util.*;

public class SimpleCoins {

    private static Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        System.out.println(coinChange(coins, 30));
        System.out.println(coinChangeMap(coins,30));
        System.out.println(coinChangeDP(coins,30));
    }

    public static int coinChangeDP(List<Integer> coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        //外层for循环遍历所有状态取值
        for (int i=1; i < dp.length; i++){
            //内层循环求所有选择的最小值
            for (int coin : coins){
                //子问题无解，跳过
                if ((i - coin) < 0) continue;
                dp[i] = Math.min(dp[i] , 1 + dp[i-coin]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChangeMap(List<Integer> coins, int amount){
        if (amount == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int coin : coins){
            if ((amount - coin) < 0) continue;
            int subResult = 0;
            if (result.containsKey(amount)){
                subResult = result.get(amount);
            }else {
                subResult = coinChangeMap(coins, amount - coin);
            }
            if (subResult == -1) continue;
            ans = Math.min(ans, subResult + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int coinChange(List<Integer> coins, int amount){
        if (amount == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int coin : coins){
            if ((amount - coin) < 0) continue;
            int subResult = coinChange(coins, amount - coin);
            if (subResult == -1) continue;
            ans = Math.min(ans, subResult + 1);
        }
        return ans == Integer.MAX_VALUE ? -1: ans;
    }

}
