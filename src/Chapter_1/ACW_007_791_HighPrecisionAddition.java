package Chapter_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW_007_791_HighPrecisionAddition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next();
        String b = input.next();

        List<Integer> A = new ArrayList<>(a.length());
        List<Integer> B = new ArrayList<>(b.length());
        for (int i = a.length()-1; i >= 0 ; i--) A.add(a.charAt(i) - '0');
        for (int i = b.length()-1; i >= 0 ; i--) B.add(b.charAt(i) - '0');

        List<Integer> C = add(A, B);
        for (int i = C.size() - 1; i >= 0 ; i--) {
            System.out.print(C.get(i) + "");
        }
    }

    public static List<Integer> add(List<Integer> A, List<Integer> B){
        List<Integer> C = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < A.size() || i < B.size(); i++) {
            if (i < A.size()) flag += A.get(i);
            if (i < B.size()) flag += B.get(i);

            C.add(flag % 10);
            flag = flag / 10;
        }
        if (flag != 0) C.add(1);
        return C;
    }
}
