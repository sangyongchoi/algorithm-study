package study.dfs.q2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int numberOfPerson;
    static int[][] relation;
    static boolean[][] visited;
    static boolean find;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfPerson = Integer.parseInt(br.readLine());
        final String[] goal = br.readLine().split(" ");
        final int source = Integer.parseInt(goal[0]);
        final int destination = Integer.parseInt(goal[1]);
        final int count = Integer.parseInt(br.readLine());
        relation = new int[numberOfPerson + 1][numberOfPerson + 1];
        visited = new boolean[numberOfPerson + 1][numberOfPerson + 1];

        for (int i = 0; i < count; i++) {
            final String[] tmp = br.readLine().split(" ");
            final int parent = Integer.parseInt(tmp[0]);
            final int child = Integer.parseInt(tmp[1]);

            relation[parent][child] = 1;
            relation[child][parent] = 1;
        }

        int result = dfs(source,  destination, 1);

        System.out.println(result);
    }

    private static int dfs(int i, int destination, int count) {
        for (int k = 1; k <= numberOfPerson; k++) {
            if (relation[i][k] == 1 && k == destination) {
                find = true;
                return count;
            } else if (relation[i][k] == 1 && !visited[i][k]) {
                visited[i][k] = true;
                visited[k][i] = true;

                int result = dfs(k, destination, count + 1);
                if(find){
                    return result;
                }
            }
        }

        return -1;
    }
}
