package study.dynamic.q11052;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] node = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            node[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + node[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
