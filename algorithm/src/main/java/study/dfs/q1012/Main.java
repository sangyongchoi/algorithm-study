package study.dfs.q1012;

import java.util.Scanner;

public class Main {

    static int width;
    static int height;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();

        for (int k = 0; k < size; k++) {
            int result =0;

            width = sc.nextInt();
            height = sc.nextInt();
            final int count = sc.nextInt();

            int[][] node = new int[width + 1][height + 1];

            for (int i = 0; i < count; i++) {
                final int a = sc.nextInt();
                final int b = sc.nextInt();

                node[a + 1][b + 1] = 1;
            }

            for (int i = 1; i <= width; i++) {
                for (int j = 1; j <= height; j++) {
                    if (node[i][j] == 1) {
                        result++;
                        dfs(node, i, j);
                    }
                }
            }

            System.out.println(result);
        }

    }

    private static void dfs(int[][] node, int i, int j) {
        if (i < 1 || i > width || j < 1 || j > height || node[i][j] == 0)  return;

        node[i][j] = 0;

        dfs(node, i - 1, j);
        dfs(node, i + 1, j);
        dfs(node, i, j + 1);
        dfs(node, i, j - 1);
    }
}
