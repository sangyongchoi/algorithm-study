package study.dynamic.q11726;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int number = sc.nextInt();
        final long[] array = new long[number + 1];

        if (number == 1) {
            System.out.println("1");
        } else {
            array[0] = 1;
            array[1] = 1;

            for (int i = 2; i <= number; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }

            System.out.println(array[number] % 10007);
        }
    }
}
