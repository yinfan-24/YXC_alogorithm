package Chapter_1;

import java.io.*;

public class ACW_018_801_NumberOf1InBinary {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine());
        String[] arr_str = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            BitCount(Integer.parseInt(arr_str[i]));
        }

        writer.flush();
        reader.close();
        writer.close();
    }
    public static void BitCount(int num) throws IOException {
        int cnt = 0;
        int next = num;
        int i = 0;
        while (next != 0){
            cnt += next >> 0 & 1;
            next = next >> 1;
            i++;
        }
        writer.write(cnt + " ");
    }
}


/*

30
513123041 161234103 711788490 94430754 573397340 464792381 969885587 764519986 285160802 16778527 515057770 27429357 637095449 29999875 508510458 351959310 604454639 215954547 628199123 963025551 318659939 705775055 272415638 777314089 795760201 290769147 141053061 308310240 56766245 13497114

 */