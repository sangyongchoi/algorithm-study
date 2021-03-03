package study.dynamic.q11727;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();

        if (size == 1) {
            System.out.println(1);
        } else if (size == 2) {
            System.out.println(3);
        } else{
            int[] dp = new int[size+1];
            dp[1] = 1;
            dp[2] = 3;

            for (int i = 3; i <= size; i++) {
                dp[i] = dp[i - 1] + 2 * dp[i - 2];
                dp[i] = dp[i] % 10007;
            }

            System.out.println(dp[size]);
        }
    }
}
