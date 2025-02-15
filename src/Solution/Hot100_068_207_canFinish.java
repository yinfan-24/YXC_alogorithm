package Solution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot100_068_207_canFinish {

//    List<List<Integer>> edges;
    List<Integer>[] edges;
    boolean valid;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        edges[0]代表学0之前需要学什么
        edges = new ArrayList[numCourses];
//        初始化edges
//        for (int i = 0; i < numCourses; i++) {
//            edges[i] = new ArrayList<>();
//        }
        Arrays.setAll(edges, i -> new ArrayList<>());
        visited = new int[numCourses];
        for (int[] pair: prerequisites){
//            edges.get(pair[1]).add(pair[0]);
            edges[pair[1]].add(pair[0]);
        }

//        遍历节点，判断是否存在环
        valid = true;
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) dfs(i);
        }
        return valid;
    }

    public void dfs(int u){
        visited[u] = 1;
        for (int prev: edges[u]){
            if (visited[prev] == 0) {
                dfs(prev);
                if (!valid) return;
            }
            else if (visited[prev] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
