package study.dfs.q2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int size = Integer.parseInt(br.readLine());
        int[][] node = new int[size][size];
        int max = 0;

        for (int i = 0; i < size; i++) {
            final String s = br.readLine();
            final String[] split = s.split(" ");

            for (int j = 0; j < size; j++) {
                node[i][j] = Integer.parseInt(split[j]);
                max = Math.max(max, node[i][j]);
            }
        }

        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2,o1)));
        for (int k = 0; k < max; k++) {
            int[][] tmp = new int[size][size];
            int count =0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (node[i][j] > k) {
                        tmp[i][j] = node[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (tmp[i][j] != 0) {
                        count++;
                        dfs(tmp, i, j, size);
                    }
                }
            }

            queue.offer(count);
        }

        System.out.println(queue.poll());
    }

    private static void dfs(int[][] node, int i, int j, int size) {
        if(i < 0 || i>=size || j<0 || j>= size || node[i][j] == 0) return;

        node[i][j] = 0;
        dfs(node, i - 1, j, size);
        dfs(node, i + 1, j, size);
        dfs(node, i, j + 1, size);
        dfs(node, i, j - 1, size);
    }
}
