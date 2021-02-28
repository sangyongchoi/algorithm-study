package study.dynamic.q1932;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        int[][] array = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                array[i][j] = Math.max(array[i - 1][j-1], array[i-1][j]) + array[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i <= size; i++) {
            max = Math.max(max, array[size][i]);
        }

        System.out.println(max);
    }
}
