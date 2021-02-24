package study.dynamic.q1463;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int number = sc.nextInt();

        int result = solution(number);
        System.out.println(result);
    }

    private static int solution(int number) {
        int[] array = new int[number + 1];

        if (number == 1) {
            return 0;
        }

        if (number == 2 || number == 3) {
            return 1;
        }

        array[0] = 0;
        array[1] = 0;
        array[2] = 1;
        array[3] = 1;

        for (int i = 4; i <= number; i++) {
            int min = array[i - 1];
            if (i % 2 == 0) {
                int b = array[i / 2];

                min = Math.min(min, b);
            }

            if (i % 3 == 0) {
                int c = array[i / 3];
                min = Math.min(min, c);
            }

            array[i] = min + 1;
        }

        return array[number];
    }
}
