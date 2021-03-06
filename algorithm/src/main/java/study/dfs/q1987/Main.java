package study.dfs.q1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static char[][] node;
    static int x;
    static int y;
    static Map<Character, Boolean> visit = new HashMap<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String size = br.readLine();
        final String[] sizeSplit = size.split(" ");
        x = Integer.parseInt(sizeSplit[0]);
        y = Integer.parseInt(sizeSplit[1]);
        node = new char[x][y];

        for (int i = 0; i < x; i++) {
            final String tmp = br.readLine();

            for (int j = 0; j < tmp.length(); j++) {
                node[i][j] = tmp.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static void dfs(int i, int j, int count) {
        if (visit.get(node[i][j]) != null) {
            result = Math.max(result, count);
            return;
        }

        visit.put(node[i][j], true);

        for (int[] dir : dirs) {
            int a = i + dir[0];
            int b = j + dir[1];

            if (a >= 0 && a < x && b >= 0 && b < y){
                dfs(a, b, count+1);
            }
        }

        visit.remove(node[i][j]);
    }
}
