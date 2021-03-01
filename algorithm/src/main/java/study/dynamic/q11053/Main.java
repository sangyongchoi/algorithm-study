package study.dynamic.q11053;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        int[] array = new int[size + 1];
        int[] dp = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            array[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 2; i <= size; i++) {
            for (int j = 1; j <i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i=1; i<=size ; i++){
            if(dp[i]>max)
                max=dp[i];
        }
        System.out.println(max);
    }
}
