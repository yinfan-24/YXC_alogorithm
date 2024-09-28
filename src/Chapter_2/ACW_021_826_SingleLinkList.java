package Chapter_2;
import java.io.*;

public class ACW_021_826_SingleLinkList
{
    public static int[] e = new int[100010];
    public static int[] ne = new int[100010];
//    idx指向下一个要加入的节点
//    e保存了索引为idx的值
//    ne保存了索引为idx的下一位的idx是什么
//    ps：
//      只要插入过，idx就会自增，e就会保存这次插入的值
//        所谓的删除，只是修改ne的指向
    public static int idx, head;
    public static void init(){
        idx = 0;
        head = -1;
    }

    public static void add_head(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    public static void add(int k, int x){
//        I k x
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    public static void del(int k){
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l1 = reader.readLine().split(" ");
        int m = Integer.parseInt(l1[0]);

        init();
        while (m-- > 0){
            String[] l_op = reader.readLine().split(" ");
            char op = l_op[0].charAt(0);
            if (op == 'H'){
                int x = Integer.parseInt(l_op[1]);
                add_head(x);
            } else if (op == 'I') {
                int k = Integer.parseInt(l_op[1]);
                int x = Integer.parseInt(l_op[2]);
                add(k-1, x);
            } else {
//                op == 'D'
                int k = Integer.parseInt(l_op[1]);
                if (k == 0) head = ne[head];
                else del(k-1);
            }
        }

        int j = head;
        while (j != -1){
            writer.write(e[j] + " ");
            j = ne[j];
        }




        reader.close();
        writer.flush();
        writer.close();
    }
}
