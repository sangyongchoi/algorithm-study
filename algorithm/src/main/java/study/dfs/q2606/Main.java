package study.dfs.q2606;

import java.util.Scanner;

public class Main {

    static int[][] node;
    static boolean visited[];
    static int result = 0;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int size = sc.nextInt();

        node = new int[101][101];
        visited = new boolean[101];

        for (int i = 0; i < size; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();

            node[a][b] = 1;
            node[b][a] = 1;
        }

        dfs(node,1, count);

        System.out.println(result);
    }

    static void dfs(int[][] node, int start, int n) {
        visited[start] = true;

        for (int i = 1; i < n + 1; i++) {
            if (node[start][i] == 1 && !visited[i]) {
                result++;
                dfs(node, i, n);
            }
        }
    }
}
