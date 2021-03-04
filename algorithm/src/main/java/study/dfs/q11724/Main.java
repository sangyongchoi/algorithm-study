package study.dfs.q11724;

import java.util.Scanner;

public class Main {

    static int[][] node;
    static boolean[] visit;
    static int count = 0;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        node = new int[size + 1][size + 1];
        visit = new boolean[size + 1];
        final int lineSize = sc.nextInt();

        for (int i = 0; i < lineSize; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();

            node[a][b] = 1;
            node[b][a] = 1;
        }

        for (int i = 1; i <= size; i++) {
            if (!visit[i]) {
                dfs(i, size);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int i, int size) {
        if(visit[i]) return;

        visit[i] = true;

        for (int j = 1; j <= size; j++) {
            if (node[i][j] == 1) {
                dfs(j, size);
            }
        }
    }
}
