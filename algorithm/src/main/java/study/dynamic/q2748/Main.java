package study.dynamic.q2748;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();

        if (size == 1 || size == 2) {
            System.out.println("1");
        } else {
            long[] dp = new long[size + 1];
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i <= size; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            System.out.println(dp[size]);
        }

    }
}
