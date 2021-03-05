package study.dynamic.q9461;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int repeatCount = sc.nextInt();

        for (int i = 0; i < repeatCount; i++) {
            final int size = sc.nextInt();

            if (size < 4) {
                System.out.println(1);
            } else {
                long[] dp = new long[size + 1];
                dp[1] = dp[2] = dp[3] = 1;

                for (int j = 4; j <= size; j++) {
                    dp[j] = dp[j-3] + dp[j-2];
                }

                System.out.println(dp[size]);
            }
        }
    }
}
