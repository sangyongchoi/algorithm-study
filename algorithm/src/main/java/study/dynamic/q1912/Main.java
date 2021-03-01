package study.dynamic.q1912;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        int[] array = new int[size + 1];
        int[] dp = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            array[i] = sc.nextInt();
        }

        dp[size] = array[size];
        int max = dp[size];
        for (int i = size - 1; i >= 1; i--) {
            dp[i] = Math.max(array[i], dp[i + 1] + array[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
