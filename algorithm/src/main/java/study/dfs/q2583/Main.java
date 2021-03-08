package study.dfs.q2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int x;
    static int y;
    static int[][] node;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String info = br.readLine();
        final String[] infoArray = info.split(" ");

        x = Integer.parseInt(infoArray[0]);
        y = Integer.parseInt(infoArray[1]);
        int inputSize = Integer.parseInt(infoArray[2]);
        node = new int[x][y];

        for (int i = 0; i < inputSize; i++) {
            final String input = br.readLine();
            final String[] areaInfo = input.split(" ");
            int startY = Integer.parseInt(areaInfo[0]);
            int startX = Integer.parseInt(areaInfo[1]);
            int endY = Integer.parseInt(areaInfo[2]);
            int endX = Integer.parseInt(areaInfo[3]);

            for (int k = startX; k < endX; k++) {
                for (int j = startY; j < endY; j++) {
                    node[x - k - 1][j] = 1;
                }
            }
        }

        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (node[i][j] == 0) {
                    count++;
                    queue.offer(dfs(i, j));
                }
            }
        }
        System.out.println(count);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int i, int j) {
        if(i < 0 || i >=x || j < 0 || j >= y || node[i][j] != 0) return 0;

        node[i][j] = 1;
        int result = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            result += dfs(x, y);
        }

        return result;
    }
}
