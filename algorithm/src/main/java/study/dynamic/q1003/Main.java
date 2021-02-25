package study.dynamic.q1003;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        int[][] array = new int[41][2];
        StringBuilder sb = new StringBuilder();
        int[] temp = new int[size];
        int max = 0;



        for (int i = 0; i < size; i++) {
            final int number = sc.nextInt();
            max = Math.max(max, number);
            temp[i] = number;
        }

        if(max >= 3) {
            array[0][0] = 1;
            array[0][1] = 0;
            array[1][0] = 0;
            array[1][1] = 1;

            for (int j = 2; j <= max; j++) {
                array[j][0] = array[j - 1][0] + array[j - 2][0];
                array[j][1] = array[j - 1][1] + array[j - 2][1];
            }
        }


        for (int i = 0; i < size; i++) {
            int tmp = temp[i];

            if (tmp == 0) {
                sb.append("1").append(" ").append("0\n");
            } else if (tmp == 1) {
                sb.append("0").append(" ").append("1\n");
            } else {
                sb.append(array[tmp][0]).append(" ").append(array[tmp][1]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
