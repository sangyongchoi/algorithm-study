package study.dynamic.q2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();

        int result = solution(n);
        System.out.println(result);
    }

    private static int solution(int n) {
        if (n == 1 || n == 2) {
            return -1;
        }

        if (n % 5 == 0) {
            return n/5;
        }

        int size = n/5;

        for (int i = size; i >= 0; i--) {
            int temp = n - (5 * i);
            if (temp % 3 == 0) {
                return i + (temp / 3);
            }
        }

        return -1;
    }
}
