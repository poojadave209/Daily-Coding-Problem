package com.dcp;

public class DecodeMessageCount {

    public static int countDecodedMessage(String msg) {
        int[] memo = new int[msg.length() + 1];
        return helper(msg, msg.length(), memo);
    }

    private static int helper(String data, int k, int[] memo) {
        if (k == 0) {
            return 1;
        }
        int s = data.length() - k;
        if (data.charAt(s) == '0') {
            return 0;
        }
        if (memo[k] != 0) {
            return memo[k];
        }
        int result = helper(data, k - 1, memo);
        if (k >= 2 && Integer.parseInt(data.substring(s, s + 2)) <= 26) {
            result += helper(data, k - 2, memo);
        }
        memo[k] = result;
        return result;
    }
}
