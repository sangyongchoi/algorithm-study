package study.dynamic.q9095;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            final int number = sc.nextInt();
            int result = solution(number);

            System.out.println(result);
        }
    }

    private static int solution(int number) {
        if (number < 3) {
            return number;
        }

        int[] array = new int[number + 1];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i <= number; i++) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1];
        }

        return array[number];
    }
}
