package study.dynamic.q2156;

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

        if (size == 1) {
            System.out.println(array[1]);
        } else if (size == 2) {
            System.out.println(array[1] + array[2]);
        } else{
            dp[1] = array[1];
            dp[2] = array[1] + array[2];

            for (int i = 3; i <= size; i++) {
                dp[i] = Math.max(array[i] + Math.max(dp[i-2], dp[i-3] + array[i-1]), dp[i-1]);
            }

            System.out.println(dp[size]);
        }
    }
}
