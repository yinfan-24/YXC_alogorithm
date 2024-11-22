package Solution;

import java.util.ArrayList;
import java.util.List;

public class Hot100_068_207_canFinish {
    List<List<Integer>> edges;
    boolean valid = true;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites){
//            访问 info[1] 之前要先访问 info[0]
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u){
        visited[u] = 1;
        for (int v : edges.get(u)){
            if (visited[v] == 0){
                dfs(v);
                if (!valid){
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
