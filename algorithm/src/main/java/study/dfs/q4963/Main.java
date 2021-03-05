package study.dfs.q4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int y;
    static int x;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean check = true;

        while (check) {
            String str = br.readLine();
            String[] size = str.split(" ");

            y = Integer.parseInt(size[0]);
            x = Integer.parseInt(size[1]);

            if (y == 0 && x == 0) {
                check = false;
                continue;
            }

            int[][] node = new int[x][y];

            for (int i = 0; i < x; i++) {
                final String s = br.readLine();
                final String[] split = s.split(" ");

                for (int j = 0; j < split.length; j++) {
                    node[i][j] = Integer.parseInt(split[j]);
                }
            }

            int count = 0;

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (node[i][j] == 1) {
                        count++;
                        dfs(node, i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 0}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    private static void dfs(int[][] node, int i, int j){
        if( i < 0 || i >= x || j < 0 || j >= y || node[i][j] == 0) return;
        node[i][j] = 0;

        for (int[] dir : dirs) {
            int a = i + dir[0];
            int b = j + dir[1];

            dfs(node, a, b);
        }
    }

}
