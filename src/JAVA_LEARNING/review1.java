package JAVA_LEARNING;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class review1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = reader.readLine();
        String b = reader.readLine();
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) num1.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) num2.add(b.charAt(i) - '0');

        int flag = 0;
        int idx = 0;
        while (idx < a.length() && idx < b.length()){
            int current = num1.get(idx) + num2.get(idx) + flag;
            flag = current / 10;
            rst.add(current % 10);
            idx++;
        }
        while (idx < a.length()){
            int current = num1.get(idx) + flag;
            flag = current / 10;
            rst.add(current % 10);
            idx++;
        }
        while (idx < b.length()){
            int current = num2.get(idx) + flag;
            flag = current / 10;
            rst.add(current % 10);
            idx++;
        }
        if (flag != 0) rst.add(flag);
        for (int i = rst.size() - 1; i >= 0; i--) {
            writer.write(rst.get(i) + "");
        }
        reader.close();
        writer.flush();
        writer.close();

    }
}
