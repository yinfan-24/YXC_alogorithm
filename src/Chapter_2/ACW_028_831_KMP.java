package Chapter_2;

import java.io.*;

public class ACW_028_831_KMP {
    static final int N = 100010;
    static final int M = 1000010;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String SON = reader.readLine();
        int m = Integer.parseInt(reader.readLine());
        String PARENT = reader.readLine();
        int[] ne = new int[N];
        char[] son = new char[N];
        for (int i = 0; i < n; i++) son[i+1] = SON.charAt(i);
        char[] parent = new char[M];
        for (int i = 0; i < m; i++) parent[i+1] = PARENT.charAt(i);

        // next数组的创建：
        // 1、非初始化 && 下个字符不匹配 -> next数组回溯
        // 2、下个字符匹配 -> j右移准备下个字符的匹配
        // 3、记录当前匹配字符的next数组值
        for (int i = 2, j = 0; i <= n; i++) {
            while(j >0 && son[i] != son[j+1]) j = ne[j];
            if (son[i] == son[j+1]) j++;
            ne[i] = j;
        }

        // 遍历母串
        // j = ne[j]而不需要移动i，是因为ne已经存储
        for (int i = 1,j = 0; i <= m; i++){
            while (j > 0 && parent[i] != son[j+1]){
                j = ne[j];
            }
            if (parent[i] == son[j+1]) {
                j++;
            }
            if (j == n) {
                writer.write((i-n) + " ");
                j = ne[j];
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}


/*
3
aba
5
ababa
 */