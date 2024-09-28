package Chapter_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW_008_792_HighPrecisionSub {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next();
        String b = input.next();

        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
//        反序存储
        for (int i = a.length() - 1; i >= 0; i--) num1.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) num2.add(b.charAt(i) - '0');

//        先判断结果符号：
        int flag = 1;
        if (num1.size() > num2.size()) {
            flag = 1;
        }
        else if (num2.size() > num1.size()) {
            flag = -1;
        } else {
            for (int i = num1.size()-1; i >= 0; ) {
                if (num1.get(i) == num2.get(i)){
                    i--;
                    continue;
                } else if (num1.get(i) < num2.get(i)) {
                    flag = -1;
                    break;
                }
                else {
                    flag = 1;
                    break;
                }
            }
        }

        List<Integer> res = flag == 1 ? true_sub(num1, num2) : true_sub(num2, num1);

//        去掉多余的0
        boolean remove_zero = false;
        for (int i = res.size()-1; i > 0; i--) {
            if (remove_zero == false && res.get(i) == 0){
                res.remove(i);
                continue;
            }else remove_zero = true;
        }
//        输出结果
        if (flag == -1) System.out.print("-");
        for (int i = res.size()-1; i >= 0; i--) {
            System.out.print(res.get(i) + "");
        }
    }
    public static List<Integer> true_sub(List<Integer> num1, List<Integer> num2){
        List<Integer> res = new ArrayList<>();
//        结果一定为正数
        int borrow = 0;
        int i = 0;
        while (i < num2.size()){
            int k = num1.get(i) - borrow - num2.get(i) ;
            if (k < 0){
                k = (k + 10) % 10;
                borrow = 1;
            }else borrow = 0;
            i++;
            res.add(k % 10);
        }
        while (i < num1.size()){
            int k = num1.get(i) - borrow;
            if (k < 0){
                k = (k + 10) % 10;
                borrow = 1;
            }else borrow = 0;
            i++;
            res.add(k % 10);
        }
        return res;
    }
}
