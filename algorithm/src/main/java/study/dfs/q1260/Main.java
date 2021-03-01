package study.dfs.q1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] visit;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        final int count = sc.nextInt();
        final int start = sc.nextInt();
        visit = new boolean[size + 1];
        int[][] node = new int[size + 1][size + 1];

        for (int i = 0; i < count; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            node[a][b] = 1;
        }

        dfs(node, start, size);
        visit = new boolean[size + 1];
        System.out.println();
        bfs(node, start, size);
    }

    public static void dfs(int[][] node, int start, int size){
        visit[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= size; i++) {
            if (!visit[i] && node[start][i] == 1) {
                dfs(node, i, size);
            }
        }
    }

    public static void bfs(int[][] node, int start, int size){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visit[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            final Integer poll = queue.poll();

            for (int i = 1; i <= size; i++) {
                if (!visit[i] && node[poll][i] == 1) {
                    visit[i] = true;
                    queue.offer(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
