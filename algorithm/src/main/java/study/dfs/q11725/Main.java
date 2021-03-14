package study.dfs.q11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] list;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int size = Integer.parseInt(br.readLine());
        list = new ArrayList[size + 1];
        parents = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < size -1; i++) {
            final String[] s = br.readLine().split(" ");

            list[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
            list[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
        }

        dfs(1, 0);

        for (int i = 2; i <= size; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int i, int parent) {
        for (int tmp : list[i]) {
            if (tmp != parent) {
                parents[tmp] = i;
                dfs(tmp, i);
            }
        }
    }
}
