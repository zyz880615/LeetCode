package LeetCode.dp;

import java.util.Arrays;

/**
 * 求两个字符串的最长公共子序列长度
 */
public class LongestSub {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text1.length() <= 0 || text2 == null || text2.length() <= 0) {
            return 0;
        }

        int[][] dp =new int[text1.length()+1][text2.length()+1];
        fillArraysDP(dp);
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    private static void fillArraysDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;
        }
    }

}
