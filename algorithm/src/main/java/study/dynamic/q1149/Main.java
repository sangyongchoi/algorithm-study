package study.dynamic.q1149;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        int[][] array = new int[size][3];

        for (int i = 0; i < size; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
            array[i][2] = sc.nextInt();
        }

        for (int i = 1; i < size; i++) {
            int[] temp = array[i-1];
            array[i][0] = array[i][0] + Math.min(temp[1], temp[2]);
            array[i][1] = array[i][1] + Math.min(temp[0], temp[2]);
            array[i][2] = array[i][2] + Math.min(temp[0], temp[1]);
        }

        int[] temp = array[size-1];
        int min = Math.min(temp[0], temp[1]);
        min = Math.min(min, temp[2]);

        System.out.println(min);
    }
}
