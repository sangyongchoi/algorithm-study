package study.dynamic.q9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            final int size = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][size + 1];
            int[][] dp = new int[2][size + 1];

            for (int j = 0; j < 2; j++) {
                final String[] s = br.readLine().split(" ");

                for (int k = 1; k <= size; k++) {
                    arr[j][k] = Integer.parseInt(s[k-1]);
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= size; j++) {
                dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + arr[1][j];
            }

            System.out.println(Math.max(dp[1][size], dp[0][size]));
        }
    }
}
